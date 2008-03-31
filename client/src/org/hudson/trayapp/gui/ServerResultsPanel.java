package org.hudson.trayapp.gui;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JTable;
import javax.swing.BoxLayout;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import org.hudson.trayapp.HudsonTrayApp;
import org.hudson.trayapp.model.Job;
import org.hudson.trayapp.model.Server;

import com.sun.swing.TableSorter;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

public class ServerResultsPanel extends JPanel {

	private JScrollPane descriptionScrollPane = null;
	private JEditorPane descriptionEditorPane = null;
	private JScrollPane resultsScrollPane = null;
	private JTable resultsTable = null;
	private TitledBorder titledBorder = null;

	/**
	 * This method initializes 
	 * 
	 */
	public ServerResultsPanel() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 */
	private void initialize() {
        titledBorder = BorderFactory.createTitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 14), new Color(51, 51, 51));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(titledBorder);
        this.add(getDescriptionScrollPane(), null);
        this.add(getResultsScrollPane(), null);
			
	}

	/**
	 * This method initializes descriptionScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getDescriptionScrollPane() {
		if (descriptionScrollPane == null) {
			descriptionScrollPane = new JScrollPane();
			descriptionScrollPane.setViewportView(getDescriptionEditorPane());
		}
		return descriptionScrollPane;
	}

	/**
	 * This method initializes descriptionEditorPane	
	 * 	
	 * @return javax.swing.JEditorPane	
	 */
	private JEditorPane getDescriptionEditorPane() {
		if (descriptionEditorPane == null) {
			descriptionEditorPane = new JEditorPane();
			descriptionEditorPane.setSize(new Dimension(546, 128));
			descriptionEditorPane.setBackground(SystemColor.control);
			descriptionEditorPane.setPreferredSize(new Dimension(48, 48));
			descriptionEditorPane.setText("");
			descriptionEditorPane.setEditable(false);
			descriptionEditorPane.setContentType("text/html");
			descriptionEditorPane.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return descriptionEditorPane;
	}

	/**
	 * This method initializes resultsScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getResultsScrollPane() {
		if (resultsScrollPane == null) {
			resultsScrollPane = new JScrollPane();
			resultsScrollPane.setPreferredSize(new Dimension(453, 200));
			resultsScrollPane.setViewportView(getResultsTable());
		}
		return resultsScrollPane;
	}

	/**
	 * This method initializes resultsTable	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getResultsTable() {
		if (resultsTable == null) {
			resultsTable = new JTable();
			resultsTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			resultsTable.addMouseListener(new MouseListener() {
				public void mouseClicked(MouseEvent e) {
					int column = resultsTable.columnAtPoint(e.getPoint());
					if (e.getClickCount() == 2) {
						int row = resultsTable.rowAtPoint(e.getPoint());
						try {
							String value = resultsTable.getValueAt(row, column).toString();
							if (value.indexOf("http://") != -1 || value.indexOf("https://") != -1) {
								HudsonTrayApp.getHudsonTrayAppInstance().getTray().browse(new URL(Job.getRFC2396CompliantURL(value)));
							}
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				}
				
				public void mouseEntered(MouseEvent e) { }
				public void mouseExited(MouseEvent e) { }
				public void mousePressed(MouseEvent e) { }
				public void mouseReleased(MouseEvent e) { }
				
			});
		}
		return resultsTable;
	}
	


	public void setServer(Server server) {
		titledBorder.setTitle(server.getName());
		getDescriptionEditorPane().setText(server.getDescription());
		ServerTableModel stm = null;
		try {
			stm = (ServerTableModel) resultsTable.getModel();
			stm.setServer(server);
		} catch (ClassCastException e) {
			stm = new ServerTableModel(server);
		}
		
		TableSorter sortedModel = new TableSorter(stm);
		resultsTable.setModel(sortedModel);
		sortedModel.addMouseListenerToHeaderInTable(resultsTable);
	
		TableColumn colourColumn = resultsTable.getColumnModel().getColumn(0);
		colourColumn.setCellRenderer(new DefaultTableCellRenderer() {
			/**
			 *
			 */
			private static final long serialVersionUID = 1L;
	
			public Component getTableCellRendererComponent(JTable table,
					Object value, boolean isSelected, boolean hasFocus, int row,
					int column) {
	
				super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/org/hudson/trayapp/gui/icons/16x16/"+(String)value + ".gif")));
				setIcon(icon);
				icon.setImageObserver(new CellImageObserver(resultsTable, row, column));
				setText("");
				setIgnoreRepaint(false);
				return this;
			}
		});
		colourColumn.setResizable(false);
		colourColumn.setPreferredWidth(20);
		colourColumn.setMinWidth(20);
		colourColumn.setMaxWidth(20);
		colourColumn.setWidth(20);
		
		if (stm.getColumnCount() == 4) {
			TableColumn healthColumn = resultsTable.getColumnModel().getColumn(1);
			healthColumn.setCellRenderer(new DefaultTableCellRenderer() {
				/**
				 *
				 */
				private static final long serialVersionUID = 1L;
	
				public Component getTableCellRendererComponent(JTable table,
						Object value, boolean isSelected, boolean hasFocus, int row,
						int column) {
	
					super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
					ImageIcon icon = (ImageIcon) Tray.getIconFromHealth(((Integer) value).intValue());
					setIcon(icon);
					icon.setImageObserver(new CellImageObserver(resultsTable, row, column));
					setText("");
					if (((Integer) value).intValue() != -1) {
						setToolTipText(((Integer) value).toString() + "%");
					}
					setIgnoreRepaint(false);
					return this;
				}
			});
			healthColumn.setResizable(false);
			healthColumn.setPreferredWidth(20);
			healthColumn.setMinWidth(20);
			healthColumn.setMaxWidth(20);
			healthColumn.setWidth(20);
			int width = getWidth() - 40;
			resultsTable.getColumnModel().getColumn(2).setPreferredWidth((width - colourColumn.getPreferredWidth() - healthColumn.getPreferredWidth()) / 2 );
			resultsTable.getColumnModel().getColumn(3).setPreferredWidth((width - colourColumn.getPreferredWidth() - healthColumn.getPreferredWidth()) / 2 );
		} else if (stm.getColumnCount() == 3) {
			int width = getWidth() - 40;
			resultsTable.getColumnModel().getColumn(1).setPreferredWidth((width - colourColumn.getPreferredWidth()) / 2 );
			resultsTable.getColumnModel().getColumn(2).setPreferredWidth((width - colourColumn.getPreferredWidth()) / 2 );
		}
	}

}
