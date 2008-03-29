package org.hudson.trayapp.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.event.ListDataListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import org.hudson.trayapp.HudsonTrayApp;
import org.hudson.trayapp.actions.FileExecutor;
import org.hudson.trayapp.model.Job;
import org.hudson.trayapp.model.Model;
import org.hudson.trayapp.model.Preferences;
import org.hudson.trayapp.model.Server;
import org.hudson.trayapp.gui.tray.TrayIconImplementation;

import javax.swing.ListSelectionModel;
import javax.swing.JCheckBox;

public class MainFrame extends JFrame implements HyperlinkListener{

	private static MainFrame mainframe = null;

	public static MainFrame getMainFrameInstance() {
		if (mainframe == null) {
			mainframe = new MainFrame();
		}
		return mainframe;
	}

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTabbedPane mainTabbedPane = null;
	private JPanel resultsPanel = null;
	private JPanel configurationPanel = null;
	private JScrollPane resultsScrollPane = null;
	private JPanel serverConfigurationTopPane = null;
	private JSplitPane configurationSplitPane = null;
	private JList configurationList = null;
	private JPanel configurationRightPanel = null;
	private JPanel configurationBottomPanel = null;
	private JLabel updateFrequencyLabel = null;
	private JPanel serverConfigurationPane = null;
	private JPanel updateFrequencyPanel = null;
	private JTextField updateField = null;
	private JLabel updateFrequencyTimeScaleLabel = null;
	private JLabel updateFrequencyEveryLabel = null;
	private JPanel resultsTopPanel = null;
	private JLabel resultsOverallLabel = null;
	private JScrollPane descriptionScrollPane = null;
	private JPanel updatePanel = null;
	private JList serverList = null;
	private JPanel spacingPanel = null;
	private JLabel topLabel = null;
	private JLabel westLabel = null;
	private JLabel eastLabel = null;
	private JPanel bottomPanel = null;
	private JButton addServerButton = null;
	private JButton removeServerButton = null;
	private JPanel serverPanel = null;
	private JPanel serverDetailsPane = null;
	private JLabel serverNameLabel = null;
	private JLabel serverLocationLabel = null;
	private JTextField serverNameField = null;
	private JTextField serverLocationField = null;
	private JPanel resultsTablePanel = null;
	private JEditorPane descriptionEditorPane = null;
	private JTable resultsTable = null;
	private JScrollPane resultsTableScrollPane = null;
	private JPanel statusPanel = null;
	private JLabel statusLabel = null;
	private JPanel statusOverviewPane = null;
	private JLabel failedStatusLabel = null;
	private JLabel unstableStatusLabel = null;
	private JLabel stableStatusLabel = null;
	private JLabel disabledStatusLabel = null;
	private JLabel buildingStatusLabel = null;
	private JPanel actionConfigurationPanel = null;
	private JLabel actionLabel = null;
	private JTabbedPane actionTabbedPane = null;
	private JPanel redToActionPanel = null;
	private JTextField redToRedUnchangedField = null;
	private JTextField redToRedChangedField = null;
	private JTextField redToRedAnimeUnchangedField = null;
	private JTextField redToRedAnimeChangedField = null;
	private JTextField redAnimeToRedUnchangedField = null;
	private JTextField redAnimeToRedChangedField = null;
	private JTextField redAnimeToRedAnimeUnchangedField = null;
	private JTextField redAnimeToRedAnimeChangedField = null;
	private JTextField redToYellowUnchangedField = null;
	private JTextField redToYellowChangedField = null;
	private JTextField redToYellowAnimeUnchangedField = null;
	private JTextField redToYellowAnimeChangedField = null;
	private JTextField redAnimeToYellowUnchangedField = null;
	private JTextField redAnimeToYellowChangedField = null;
	private JTextField redAnimeToYellowAnimeUnchangedField = null;
	private JTextField redAnimeToYellowAnimeChangedField = null;
	private JTextField redToBlueUnchangedField = null;
	private JTextField redToBlueChangedField = null;
	private JTextField redToBlueAnimeUnchangedField = null;
	private JTextField redToBlueAnimeChangedField = null;
	private JTextField redToGreyUnchangedField = null;
	private JTextField redToGreyChangedField = null;
	private JTextField redAnimeToBlueUnchangedField = null;
	private JTextField redAnimeToBlueChangedField = null;
	private JTextField redAnimeToBlueAnimeUnchangedField = null;
	private JTextField redAnimeToBlueAnimeChangedField = null;
	private JTextField redAnimeToGreyUnchangedField = null;
	private JTextField redAnimeToGreyChangedField = null;
	private JPanel yellowToActionPanel = null;
	private JTextField yellowToRedUnchangedField = null;
	private JTextField yellowToRedChangedField = null;
	private JTextField yellowToRedAnimeUnchangedField = null;
	private JTextField yellowToRedAnimeChangedField = null;
	private JTextField yellowAnimeToRedUnchangedField = null;
	private JTextField yellowAnimeToRedChangedField = null;
	private JTextField yellowAnimeToRedAnimeUnchangedField = null;
	private JTextField yellowAnimeToRedAnimeChangedField = null;
	private JTextField yellowToYellowUnchangedField = null;
	private JTextField yellowToYellowChangedField = null;
	private JTextField yellowToYellowAnimeUnchangedField = null;
	private JTextField yellowToYellowAnimeChangedField = null;
	private JTextField yellowAnimeToYellowUnchangedField = null;
	private JTextField yellowAnimeToYellowChangedField = null;
	private JTextField yellowAnimeToYellowAnimeUnchangedField = null;
	private JTextField yellowAnimeToYellowAnimeChangedField = null;
	private JTextField yellowToBlueUnchangedField = null;
	private JTextField yellowToBlueChangedField = null;
	private JTextField yellowToBlueAnimeUnchangedField = null;
	private JTextField yellowToBlueAnimeChangedField = null;
	private JTextField yellowToGreyUnchangedField = null;
	private JTextField yellowToGreyChangedField = null;
	private JTextField yellowAnimeToBlueUnchangedField = null;
	private JTextField yellowAnimeToBlueChangedField = null;
	private JTextField yellowAnimeToBlueAnimeUnchangedField = null;
	private JTextField yellowAnimeToBlueAnimeChangedField = null;
	private JTextField yellowAnimeToGreyUnchangedField = null;
	private JTextField yellowAnimeToGreyChangedField = null;
	private JPanel blueToActionPanel = null;
	private JTextField blueToRedUnchangedField = null;
	private JTextField blueToRedChangedField = null;
	private JTextField blueToRedAnimeUnchangedField = null;
	private JTextField blueToRedAnimeChangedField = null;
	private JTextField blueAnimeToRedUnchangedField = null;
	private JTextField blueAnimeToRedChangedField = null;
	private JTextField blueAnimeToRedAnimeUnchangedField = null;
	private JTextField blueAnimeToRedAnimeChangedField = null;
	private JTextField blueToYellowUnchangedField = null;
	private JTextField blueToYellowChangedField = null;
	private JTextField blueToYellowAnimeUnchangedField = null;
	private JTextField blueToYellowAnimeChangedField = null;
	private JTextField blueAnimeToYellowUnchangedField = null;
	private JTextField blueAnimeToYellowChangedField = null;
	private JTextField blueAnimeToYellowAnimeUnchangedField = null;
	private JTextField blueAnimeToYellowAnimeChangedField = null;
	private JTextField blueToBlueUnchangedField = null;
	private JTextField blueToBlueChangedField = null;
	private JTextField blueToBlueAnimeUnchangedField = null;
	private JTextField blueToBlueAnimeChangedField = null;
	private JTextField blueToGreyUnchangedField = null;
	private JTextField blueToGreyChangedField = null;
	private JTextField blueAnimeToBlueUnchangedField = null;
	private JTextField blueAnimeToBlueChangedField = null;
	private JTextField blueAnimeToBlueAnimeUnchangedField = null;
	private JTextField blueAnimeToBlueAnimeChangedField = null;
	private JTextField blueAnimeToGreyUnchangedField = null;
	private JTextField blueAnimeToGreyChangedField = null;
	private JPanel greyToActionPanel = null;
	private JTextField greyToRedUnchangedField = null;
	private JTextField greyToRedChangedField = null;
	private JTextField greyToRedAnimeUnchangedField = null;
	private JTextField greyToRedAnimeChangedField = null;
	private JTextField greyToYellowUnchangedField = null;
	private JTextField greyToYellowChangedField = null;
	private JTextField greyToYellowAnimeUnchangedField = null;
	private JTextField greyToYellowAnimeChangedField = null;
	private JTextField greyToBlueUnchangedField = null;
	private JTextField greyToBlueChangedField = null;
	private JTextField greyToBlueAnimeUnchangedField = null;
	private JTextField greyToBlueAnimeChangedField = null;
	private JTextField greyToGreyUnchangedField = null;
	private JTextField greyToGreyChangedField = null;
	private Model model = null;
	private Preferences prefs = null;  //  @jve:decl-index=0:
	private ServerListModel serverListModel = null;
	private JPanel serverNamePanel = null;
	private JPanel serverChangesApplyPanel = null;
	private JButton applyServerChangesButton = null;
	private JPanel uiConfigurationPanel = null;
	private JPanel trayIconConfigurationPanel = null;
	private JLabel showHealthLabel = null;
	private JCheckBox showHealthCB = null;
	private JLabel showAnimatedBuildLabel = null;
	private JCheckBox showAnimatedBuildCB = null;
	private JLabel showPopupNotificationLabel = null;
	private JCheckBox showPopupNotificationCB = null;
	/**
	 * This is the default constructor
	 */
	public MainFrame() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		this.setSize(580, 797);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/org/hudson/trayapp/gui/icons/16x16/hudson.png")));
		this.setContentPane(getJContentPane());
		this.setTitle("Hudson Tray Monitor");
	}

	/**
	 * This method initializes jContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getMainTabbedPane(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	/**
	 * This method initializes mainTabbedPane
	 *
	 * @return javax.swing.JTabbedPane
	 */
	public JTabbedPane getMainTabbedPane() {
		if (mainTabbedPane == null) {
			mainTabbedPane = new JTabbedPane();
			mainTabbedPane.addTab("Latest Results", null, getResultsPanel(), null);
			mainTabbedPane.addTab("Configuration", null, getConfigurationPanel(), null);
		}
		return mainTabbedPane;
	}

	/**
	 * This method initializes resultsPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getResultsPanel() {
		if (resultsPanel == null) {
			resultsPanel = new JPanel();
			resultsPanel.setLayout(new BorderLayout());
			resultsPanel.add(getResultsTopPanel(), BorderLayout.NORTH);
			resultsPanel.add(getResultsTableScrollPane(), BorderLayout.CENTER);
		}
		return resultsPanel;
	}

	/**
	 * This method initializes configurationPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getConfigurationPanel() {
		if (configurationPanel == null) {
			configurationPanel = new JPanel();
			configurationPanel.setLayout(new BorderLayout());
			configurationPanel.add(getConfigurationSplitPane(), BorderLayout.CENTER);
			configurationPanel.add(getConfigurationBottomPanel(), BorderLayout.SOUTH);
		}
		return configurationPanel;
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
	 * This method initializes serverConfigurationTopPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getServerConfigurationTopPane() {
		if (serverConfigurationTopPane == null) {
			BorderLayout borderLayout1 = new BorderLayout();
			borderLayout1.setHgap(5);
			borderLayout1.setVgap(5);
			updateFrequencyLabel = new JLabel();
			updateFrequencyLabel.setText("Frequency of Update");
			serverConfigurationTopPane = new JPanel();
			serverConfigurationTopPane.setLayout(borderLayout1);
			serverConfigurationTopPane.setName("serverConfigurationPane");
			serverConfigurationTopPane.setVisible(true);
			serverConfigurationTopPane.add(getServerPanel(), BorderLayout.CENTER);
		}
		return serverConfigurationTopPane;
	}

	/**
	 * This method initializes configurationSplitPane
	 *
	 * @return javax.swing.JSplitPane
	 */
	private JSplitPane getConfigurationSplitPane() {
		if (configurationSplitPane == null) {
			configurationSplitPane = new JSplitPane();
			configurationSplitPane.setDividerLocation(100);
			configurationSplitPane.setLeftComponent(getConfigurationList());
			configurationSplitPane.setRightComponent(getConfigurationRightPanel());
		}
		return configurationSplitPane;
	}

	/**
	 * This method initializes configurationList
	 *
	 * @return javax.swing.JList
	 */
	private JList getConfigurationList() {
		if (configurationList == null) {
			configurationList = new JList();
			configurationList.setPreferredSize(new Dimension(100, 100));
			configurationList.setModel(new ListModel() {

				final String[] SA = new String[]{"Server", "Actions", "UI Config"};
				/* (non-Javadoc)
				 * @see javax.swing.ListModel#addListDataListener(javax.swing.event.ListDataListener)
				 */
				public void addListDataListener(ListDataListener l) {
					// The data model shouldn't change for this
				}

				/* (non-Javadoc)
				 * @see javax.swing.ListModel#getElementAt(int)
				 */
				public Object getElementAt(int index) {

					return SA[index];
				}

				/* (non-Javadoc)
				 * @see javax.swing.ListModel#getSize()
				 */
				public int getSize() {
					return 3;
				}

				/* (non-Javadoc)
				 * @see javax.swing.ListModel#removeListDataListener(javax.swing.event.ListDataListener)
				 */
				public void removeListDataListener(ListDataListener l) {
					// The data model shouldn't change for this
				}

			});
			MouseListener mouseListener = new MouseAdapter() {
			     public void mouseClicked(MouseEvent e) {
			         if (e.getClickCount() >= 1) {
			             int index = configurationList.locationToIndex(e.getPoint());
		            	 CardLayout layout = (CardLayout) configurationRightPanel.getLayout();
			             if (index == 0) {
			            	 updatePreferencesFromConfiguration();
			            	 layout.show(configurationRightPanel, getServerConfigurationPane().getName());
			             } else if (index == 1) {
			            	 updateConfigurationPanelFromPreferences();
			            	 layout.show(configurationRightPanel, getActionConfigurationPanel().getName());
			             } else if (index == 2) {
			            	 updateUIConfigurationFromPreferences();
			            	 layout.show(configurationRightPanel, getUiConfigurationPanel().getName());
			             }
			          }
			     }
			 };
			 configurationList.addMouseListener(mouseListener);
		}
		return configurationList;
	}

	/**
	 * This method initializes configurationRightPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getConfigurationRightPanel() {
		if (configurationRightPanel == null) {
			configurationRightPanel = new JPanel();
			configurationRightPanel.setLayout(new CardLayout());
			configurationRightPanel.add(getServerConfigurationPane(), getServerConfigurationPane().getName());
			configurationRightPanel.add(getActionConfigurationPanel(), getActionConfigurationPanel().getName());
			configurationRightPanel.add(getUiConfigurationPanel(), getUiConfigurationPanel().getName());
		}
		return configurationRightPanel;
	}

	/**
	 * This method initializes configurationBottomPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getConfigurationBottomPanel() {
		if (configurationBottomPanel == null) {
			configurationBottomPanel = new JPanel();
			configurationBottomPanel.setLayout(new BorderLayout());
		}
		return configurationBottomPanel;
	}

	/**
	 * This method initializes serverConfigurationPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getServerConfigurationPane() {
		if (serverConfigurationPane == null) {
			serverConfigurationPane = new JPanel();
			serverConfigurationPane.setLayout(new BorderLayout());
			serverConfigurationPane.setName("serverConfigurationPane");
			serverConfigurationPane.add(getServerConfigurationTopPane(), BorderLayout.CENTER);
			serverConfigurationPane.add(getUpdatePanel(), BorderLayout.SOUTH);
		}
		return serverConfigurationPane;
	}

	/**
	 * This method initializes updateFrequencyPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getUpdateFrequencyPanel() {
		if (updateFrequencyPanel == null) {
			BorderLayout borderLayout = new BorderLayout();
			borderLayout.setHgap(3);
			updateFrequencyEveryLabel = new JLabel();
			updateFrequencyEveryLabel.setText("every");
			updateFrequencyTimeScaleLabel = new JLabel();
			updateFrequencyTimeScaleLabel.setText("minutes");
			updateFrequencyPanel = new JPanel();
			updateFrequencyPanel.setLayout(borderLayout);
			updateFrequencyPanel.add(getUpdateField(), BorderLayout.CENTER);
			updateFrequencyPanel.add(updateFrequencyTimeScaleLabel, BorderLayout.EAST);
			updateFrequencyPanel.add(updateFrequencyEveryLabel, BorderLayout.WEST);
		}
		return updateFrequencyPanel;
	}

	/**
	 * This method initializes updateField
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getUpdateField() {
		if (updateField == null) {
			updateField = new JTextField();
			updateField.addKeyListener(new KeyListener() {
				public void keyReleased(KeyEvent source) {}

				public void keyPressed(KeyEvent source) {}

				public void keyTyped(KeyEvent source) {
					int k=source.getKeyChar();
					if(!(k>47 && k<58))
					{
					source.setKeyChar((char)KeyEvent.VK_CLEAR);
					}
				}
			});
		}
		return updateField;
	}

	/**
	 * This method initializes resultsTopPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getResultsTopPanel() {
		if (resultsTopPanel == null) {
			resultsOverallLabel = new JLabel();
			resultsOverallLabel.setText("Overall Status");
			resultsOverallLabel.setIcon(new ImageIcon(getClass().getResource("/org/hudson/trayapp/gui/icons/48x48/red.gif")));
			resultsTopPanel = new JPanel();
			resultsTopPanel.setLayout(new BorderLayout());
			resultsTopPanel.add(resultsOverallLabel, BorderLayout.WEST);
			resultsTopPanel.add(getStatusPanel(), BorderLayout.CENTER);
		}
		return resultsTopPanel;
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


	public void hyperlinkUpdate(HyperlinkEvent event) {
	    if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
	    	System.out.println(event.getURL().toString());
	    	try {
	    		HudsonTrayApp.getHudsonTrayAppInstance().getTray().browse(event.getURL());
	    	} catch(Exception e) {
	    		HudsonTrayApp.getHudsonTrayAppInstance().getTray().showMessage("Error launching Browser", "Couldn't launch the url:\n"+event.getURL().toString(), TrayIconImplementation.ERROR_MESSAGE_TYPE);
	    	}
	    }
	}

	public void setWorstCaseColour(String colour) {
		resultsOverallLabel.setIcon(new ImageIcon(getClass().getResource("/org/hudson/trayapp/gui/icons/48x48/" + colour +".gif")));
	}

	public void updateResults(TableModel tableModel) {

		resultsTable.setModel(tableModel);
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
		int width = getWidth() - 40;
		resultsTable.getColumnModel().getColumn(1).setPreferredWidth((width - colourColumn.getPreferredWidth()) / 2 );
		resultsTable.getColumnModel().getColumn(2).setPreferredWidth((width - colourColumn.getPreferredWidth()) / 2 );
	}

	/**
	 * This method takes the colour and counts provided, and updates the panel accordingly
	 * @param worstColour The worst case colour as defined in model.colours[]
	 * @param red The number of jobs in a Red state (including those building)
	 * @param yellow The number of jobs in a Yellow state (including those building)
	 * @param blue The number of jobs in a Blue state (including those building)
	 * @param grey The number of jobs in a Grey state
	 * @param building The number of jobs building
	 */
	public void updateOverallStatusPanel(String worstColour, int red, int yellow, int blue, int grey, int building) {
		setWorstCaseColour(worstColour);
		failedStatusLabel.setText(Integer.toString(red) + " job(s) failed");
		unstableStatusLabel.setText(Integer.toString(yellow) + " job(s) unstable");
		stableStatusLabel.setText(Integer.toString(blue) + " job(s) stable");
		disabledStatusLabel.setText(Integer.toString(grey) + " job(s) disabled");
		buildingStatusLabel.setText(Integer.toString(building) + " job(s) building");
	}

	/**
	 * This method initializes updatePanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getUpdatePanel() {
		if (updatePanel == null) {
			GridLayout gridLayout1 = new GridLayout();
			gridLayout1.setRows(1);
			updatePanel = new JPanel();
			updatePanel.setLayout(gridLayout1);
			updatePanel.add(updateFrequencyLabel, null);
			updatePanel.add(getUpdateFrequencyPanel(), null);
		}
		return updatePanel;
	}

	/**
	 * This method initializes serverList
	 *
	 * @return javax.swing.JList
	 */
	private JList getServerList() {
		if (serverList == null) {
			serverList = new JList();
			serverList.setPreferredSize(new Dimension(120, 120));
			serverList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			serverList.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
			serverList.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					Server server = model.getServerAt(serverList.locationToIndex(e.getPoint()));
					if (server == null) {
						serverLocationField.setText("");
						serverNameField.setText("");
						serverLocationField.setEnabled(false);
						serverNameField.setEnabled(false);
					} else {
						serverLocationField.setText(server.getURL());
						serverNameField.setText(server.getName());
						serverLocationField.setEnabled(true);
						serverNameField.setEnabled(true);
					}
				}
			});
		}
		return serverList;
	}

	/**
	 * This method initializes spacingPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getSpacingPanel() {
		if (spacingPanel == null) {
			eastLabel = new JLabel();
			eastLabel.setText("");
			eastLabel.setPreferredSize(new Dimension(5, 5));
			westLabel = new JLabel();
			westLabel.setText("");
			westLabel.setPreferredSize(new Dimension(5, 5));
			topLabel = new JLabel();
			topLabel.setText("");
			topLabel.setPreferredSize(new Dimension(5, 5));
			spacingPanel = new JPanel();
			spacingPanel.setLayout(new BorderLayout());
			spacingPanel.setPreferredSize(new Dimension(130, 120));
			spacingPanel.add(getServerList(), BorderLayout.CENTER);
			spacingPanel.add(topLabel, BorderLayout.NORTH);
			spacingPanel.add(westLabel, BorderLayout.WEST);
			spacingPanel.add(eastLabel, BorderLayout.EAST);
			spacingPanel.add(getBottomPanel(), BorderLayout.SOUTH);
		}
		return spacingPanel;
	}

	/**
	 * This method initializes bottomPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getBottomPanel() {
		if (bottomPanel == null) {
			bottomPanel = new JPanel();
			bottomPanel.setLayout(new BorderLayout());
			bottomPanel.add(getAddServerButton(), BorderLayout.WEST);
			bottomPanel.add(getRemoveServerButton(), BorderLayout.EAST);
		}
		return bottomPanel;
	}

	/**
	 * This method initializes addServerButton
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getAddServerButton() {
		if (addServerButton == null) {
			addServerButton = new JButton();
			addServerButton.setText("Add");
			addServerButton.setPreferredSize(new Dimension(52, 26));
			addServerButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (model.containsServer("") == false) {
						model.addServer("", "");
						int index = model.getServerIndex("");
						serverLocationField.setText("");
						serverNameField.setText("");
						serverLocationField.setEnabled(true);
						serverNameField.setEnabled(true);
						serverListModel.objectAdded(index);
						serverList.setSelectedIndex(index);
					}
				}
			});
		}
		return addServerButton;
	}

	/**
	 * This method initializes removeServerButton
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getRemoveServerButton() {
		if (removeServerButton == null) {
			removeServerButton = new JButton();
			removeServerButton.setText("Remove");
			removeServerButton.setPreferredSize(new Dimension(78, 26));
			removeServerButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int index = serverList.getSelectedIndex();
					if (index != -1) {
						Server server = model.getServerAt(index);
						model.removeServer(server.getURL());
						serverListModel.objectRemoved(index);
						if (index == model.getServerModelSize()) {
							index--;
						}
						if (index == -1) {
							serverList.setSelectedIndices(new int[0]);
							serverLocationField.setText("");
							serverNameField.setText("");
							serverLocationField.setEnabled(false);
							serverNameField.setEnabled(false);
						} else {
							serverList.setSelectedIndex(index);
							server = model.getServerAt(index);
							serverLocationField.setText(server.getURL());
							serverNameField.setText(server.getName());
							serverLocationField.setEnabled(true);
							serverNameField.setEnabled(true);
						}
					}
				}
			});
		}
		return removeServerButton;
	}

	/**
	 * This method initializes serverPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getServerPanel() {
		if (serverPanel == null) {
			serverPanel = new JPanel();
			serverPanel.setLayout(new BorderLayout());
			serverPanel.setPreferredSize(new Dimension(50, 50));
			serverPanel.setBorder(BorderFactory.createTitledBorder(null, "Servers", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			serverPanel.add(getSpacingPanel(), BorderLayout.WEST);
			serverPanel.add(getServerDetailsPane(), BorderLayout.CENTER);
		}
		return serverPanel;
	}

	/**
	 * This method initializes serverDetailsPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getServerDetailsPane() {
		if (serverDetailsPane == null) {
			serverLocationLabel = new JLabel();
			serverLocationLabel.setText("Server Location");
			serverLocationLabel.setBounds(new Rectangle(8, 40, 90, 16));
			serverNameLabel = new JLabel();
			serverNameLabel.setText("Server Name");
			serverNameLabel.setBounds(new Rectangle(8, 12, 74, 16));
			serverDetailsPane = new JPanel();
			serverDetailsPane.setLayout(new BorderLayout());
			serverDetailsPane.add(getServerNamePanel(), BorderLayout.CENTER);
			serverDetailsPane.add(getServerChangesApplyPanel(), BorderLayout.SOUTH);
		}
		return serverDetailsPane;
	}

	/**
	 * This method initializes serverNameField
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getServerNameField() {
		if (serverNameField == null) {
			serverNameField = new JTextField();
			serverNameField.setBounds(new Rectangle(108, 8, 181, 20));
			serverNameField.setEnabled(false);
		}
		return serverNameField;
	}

	/**
	 * This method initializes serverLocationField
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getServerLocationField() {
		if (serverLocationField == null) {
			serverLocationField = new JTextField();
			serverLocationField.setBounds(new Rectangle(108, 36, 181, 21));
			serverLocationField.setEnabled(false);
		}
		return serverLocationField;
	}

	/**
	 * This method initializes resultsTablePanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getResultsTablePanel() {
		if (resultsTablePanel == null) {
			resultsTablePanel = new JPanel();
			resultsTablePanel.setLayout(new BoxLayout(getResultsTablePanel(), BoxLayout.Y_AXIS));
			resultsTablePanel.add(getDescriptionScrollPane(), null);
			resultsTablePanel.add(getResultsScrollPane(), null);
		}
		return resultsTablePanel;
	}

	/**
	 * This method initializes descriptionEditorPane
	 *
	 * @return javax.swing.JEditorPane
	 */
	public JEditorPane getDescriptionEditorPane() {
		if (descriptionEditorPane == null) {
			descriptionEditorPane = new JEditorPane();
			descriptionEditorPane.setBackground(SystemColor.control);
			descriptionEditorPane.setText("");
			descriptionEditorPane.setEditable(false);
			descriptionEditorPane.setContentType("text/html");
			descriptionEditorPane.setSize(new Dimension(546, 128));
			descriptionEditorPane.setPreferredSize(new Dimension(48, 48));
			descriptionEditorPane.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return descriptionEditorPane;
	}

	/**
	 * This method initializes resultsTable
	 *
	 * @return javax.swing.JTable
	 */
	private JTable getResultsTable() {
		if (resultsTable == null) {
			resultsTable = new JTable();
			resultsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		}
		return resultsTable;
	}

	/**
	 * This method initializes resultsTableScrollPane
	 *
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getResultsTableScrollPane() {
		if (resultsTableScrollPane == null) {
			resultsTableScrollPane = new JScrollPane();
			resultsTableScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			resultsTableScrollPane.setViewportView(getResultsTablePanel());
		}
		return resultsTableScrollPane;
	}

	/**
	 * This method initializes statusPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getStatusPanel() {
		if (statusPanel == null) {
			buildingStatusLabel = new JLabel();
			buildingStatusLabel.setText("5 job(s) building");
			buildingStatusLabel.setHorizontalAlignment(SwingConstants.CENTER);
			statusLabel = new JLabel();
			statusLabel.setText("Status Overview");
			statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
			statusPanel = new JPanel();
			statusPanel.setLayout(new BorderLayout());
			statusPanel.add(statusLabel, BorderLayout.NORTH);
			statusPanel.add(getStatusOverviewPane(), BorderLayout.CENTER);
			statusPanel.add(buildingStatusLabel, BorderLayout.SOUTH);
		}
		return statusPanel;
	}

	/**
	 * This method initializes statusOverviewPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getStatusOverviewPane() {
		if (statusOverviewPane == null) {
			disabledStatusLabel = new JLabel();
			disabledStatusLabel.setText("4 job(s) disabled");
			disabledStatusLabel.setIcon(new ImageIcon(getClass().getResource("/org/hudson/trayapp/gui/icons/16x16/grey.gif")));
			stableStatusLabel = new JLabel();
			stableStatusLabel.setText("3 job(s) stable");
			stableStatusLabel.setIcon(new ImageIcon(getClass().getResource("/org/hudson/trayapp/gui/icons/16x16/blue.gif")));
			unstableStatusLabel = new JLabel();
			unstableStatusLabel.setText("2 job(s) unstable");
			unstableStatusLabel.setIcon(new ImageIcon(getClass().getResource("/org/hudson/trayapp/gui/icons/16x16/yellow.gif")));
			failedStatusLabel = new JLabel();
			failedStatusLabel.setText("1 job(s) failed");
			failedStatusLabel.setIcon(new ImageIcon(getClass().getResource("/org/hudson/trayapp/gui/icons/16x16/red.gif")));
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(1);
			statusOverviewPane = new JPanel();
			statusOverviewPane.setLayout(gridLayout);
			statusOverviewPane.add(failedStatusLabel, null);
			statusOverviewPane.add(unstableStatusLabel, null);
			statusOverviewPane.add(stableStatusLabel, null);
			statusOverviewPane.add(disabledStatusLabel, null);
		}
		return statusOverviewPane;
	}

	/**
	 * This method initializes actionConfigurationPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getActionConfigurationPanel() {
		if (actionConfigurationPanel == null) {

			actionConfigurationPanel = new JPanel();
			actionConfigurationPanel.setLayout(new BorderLayout());
			actionConfigurationPanel.setName("actionConfigurationPanel");
			actionConfigurationPanel.setBorder(BorderFactory.createTitledBorder(null, "Actions", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			actionConfigurationPanel.add(getActionTabbedPane(), BorderLayout.CENTER);

		}
		return actionConfigurationPanel;
	}

	private JTextField addRowToPanel(final JPanel panel, final int rowMinusOne, final Integer preferencesFrom, final Integer preferencesTo, final Integer preferencesBuildType) {
		// We're expecting a 0 based row, but we need to add 1 to it, because the 0th row in the grid is for the label "File to Execute"
		int row = rowMinusOne + 1;
		String iconFrom = "";
		String iconTo = "";
		String buildString = "";
		if (preferencesFrom.intValue() == Job.RED.intValue()) iconFrom = "red";
		if (preferencesFrom.intValue() == Job.RED_ANIME.intValue()) iconFrom = "red_anime";
		if (preferencesFrom.intValue() == Job.YELLOW.intValue()) iconFrom = "yellow";
		if (preferencesFrom.intValue() == Job.YELLOW_ANIME.intValue()) iconFrom = "yellow_anime";
		if (preferencesFrom.intValue() == Job.BLUE.intValue()) iconFrom = "blue";
		if (preferencesFrom.intValue() == Job.BLUE_ANIME.intValue()) iconFrom = "blue_anime";
		if (preferencesFrom.intValue() == Job.GREY.intValue()) iconFrom = "grey";

		if (preferencesTo.intValue() == Job.RED.intValue()) iconTo = "red";
		if (preferencesTo.intValue() == Job.RED_ANIME.intValue()) iconTo = "red_anime";
		if (preferencesTo.intValue() == Job.YELLOW.intValue()) iconTo = "yellow";
		if (preferencesTo.intValue() == Job.YELLOW_ANIME.intValue()) iconTo = "yellow_anime";
		if (preferencesTo.intValue() == Job.BLUE.intValue()) iconTo = "blue";
		if (preferencesTo.intValue() == Job.BLUE_ANIME.intValue()) iconTo = "blue_anime";
		if (preferencesTo.intValue() == Job.GREY.intValue()) iconTo = "grey";

		if (preferencesBuildType.intValue() == Job.BUILD_CHANGED.intValue()) buildString = "Build Changed";
		if (preferencesBuildType.intValue() == Job.BUILD_UNCHANGED.intValue()) buildString = "Build Unchanged";

		JLabel label;
		GridBagConstraints constraints;
		final JTextField textField;
		JButton button;
		label= new JLabel();
		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = row;
		label.setIcon(new ImageIcon(getClass().getResource("/org/hudson/trayapp/gui/icons/16x16/" + iconFrom + ".gif")));
		label.setText("");
		panel.add(label, constraints);

		label = new JLabel();
		constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = row;
		label.setText("->");
		panel.add(label, constraints);

		label= new JLabel();
		constraints = new GridBagConstraints();
		constraints.gridx = 2;
		constraints.gridy = row;
		label.setIcon(new ImageIcon(getClass().getResource("/org/hudson/trayapp/gui/icons/16x16/" + iconTo + ".gif")));
		label.setText("");
		panel.add(label, constraints);

		label = new JLabel();
		constraints = new GridBagConstraints();
		constraints.gridx = 3;
		constraints.gridy = row;
		label.setText(buildString);
		panel.add(label, constraints);

		textField = new JTextField();
		textField.setPreferredSize(new Dimension(256, 20));
		constraints = new GridBagConstraints();
		constraints.gridx = 4;
		constraints.gridy = row;
		constraints.weightx = 1.0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		panel.add(textField, constraints);

		button = new JButton();
		constraints = new GridBagConstraints();
		constraints.gridx = 5;
		constraints.gridy = row;
		button.setText("...");
		panel.add(button, constraints);

		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				if (fileChooser.showOpenDialog(configurationRightPanel) == JFileChooser.APPROVE_OPTION) {
					textField.setText(fileChooser.getSelectedFile().getAbsolutePath());
				}
			}

		});

		return textField;
	}

	/**
	 * This method initializes actionTabbedPane
	 *
	 * @return javax.swing.JTabbedPane
	 */
	private JTabbedPane getActionTabbedPane() {
		if (actionTabbedPane == null) {
			actionTabbedPane = new JTabbedPane();
			actionTabbedPane.addTab("->", new ImageIcon(getClass().getResource("/org/hudson/trayapp/gui/icons/16x16/red.gif")), getRedToActionPanel(), "Red to anything actions");
			actionTabbedPane.addTab("->", new ImageIcon(getClass().getResource("/org/hudson/trayapp/gui/icons/16x16/yellow.gif")), getYellowToActionPanel(), "Yellow to anything actions");
			actionTabbedPane.addTab("->", new ImageIcon(getClass().getResource("/org/hudson/trayapp/gui/icons/16x16/blue.gif")), getBlueToActionPanel(), "Blue to anything actions");
			actionTabbedPane.addTab("->", new ImageIcon(getClass().getResource("/org/hudson/trayapp/gui/icons/16x16/grey.gif")), getGreyToActionPanel(), "Grey to anything actions");
		}
		return actionTabbedPane;
	}

	/**
	 * This method initializes redToActionPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getRedToActionPanel() {
		if (redToActionPanel == null) {

			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 4;
			gridBagConstraints.gridy = 0;
			redToActionPanel = new JPanel();
			redToActionPanel.setLayout(new GridBagLayout());

			actionLabel = new JLabel();
			actionLabel.setText("File to Execute");
			redToActionPanel.add(actionLabel, gridBagConstraints);

			int row = 0;

			redToRedUnchangedField = addRowToPanel(redToActionPanel, row++, Job.RED, Job.RED, Job.BUILD_UNCHANGED);
			redToRedChangedField = addRowToPanel(redToActionPanel, row++, Job.RED, Job.RED, Job.BUILD_CHANGED);
			redToRedAnimeUnchangedField = addRowToPanel(redToActionPanel, row++, Job.RED, Job.RED_ANIME, Job.BUILD_UNCHANGED);
			redToRedAnimeChangedField = addRowToPanel(redToActionPanel, row++, Job.RED, Job.RED_ANIME, Job.BUILD_CHANGED);
			redAnimeToRedUnchangedField = addRowToPanel(redToActionPanel, row++, Job.RED_ANIME, Job.RED, Job.BUILD_UNCHANGED);
			redAnimeToRedChangedField = addRowToPanel(redToActionPanel, row++, Job.RED_ANIME, Job.RED, Job.BUILD_CHANGED);
			redAnimeToRedAnimeUnchangedField = addRowToPanel(redToActionPanel, row++, Job.RED_ANIME, Job.RED_ANIME, Job.BUILD_UNCHANGED);
			redAnimeToRedAnimeChangedField = addRowToPanel(redToActionPanel, row++, Job.RED_ANIME, Job.RED_ANIME, Job.BUILD_CHANGED);
			redToYellowUnchangedField = addRowToPanel(redToActionPanel, row++, Job.RED, Job.YELLOW, Job.BUILD_UNCHANGED);
			redToYellowChangedField = addRowToPanel(redToActionPanel, row++, Job.RED, Job.YELLOW, Job.BUILD_CHANGED);
			redToYellowAnimeUnchangedField = addRowToPanel(redToActionPanel, row++, Job.RED, Job.YELLOW_ANIME, Job.BUILD_UNCHANGED);
			redToYellowAnimeChangedField = addRowToPanel(redToActionPanel, row++, Job.RED, Job.YELLOW_ANIME, Job.BUILD_CHANGED);
			redAnimeToYellowUnchangedField = addRowToPanel(redToActionPanel, row++, Job.RED_ANIME, Job.YELLOW, Job.BUILD_UNCHANGED);
			redAnimeToYellowChangedField = addRowToPanel(redToActionPanel, row++, Job.RED_ANIME, Job.YELLOW, Job.BUILD_CHANGED);
			redAnimeToYellowAnimeUnchangedField = addRowToPanel(redToActionPanel, row++, Job.RED_ANIME, Job.YELLOW_ANIME, Job.BUILD_UNCHANGED);
			redAnimeToYellowAnimeChangedField = addRowToPanel(redToActionPanel, row++, Job.RED_ANIME, Job.YELLOW_ANIME, Job.BUILD_CHANGED);
			redToBlueUnchangedField = addRowToPanel(redToActionPanel, row++, Job.RED, Job.BLUE, Job.BUILD_UNCHANGED);
			redToBlueChangedField = addRowToPanel(redToActionPanel, row++, Job.RED, Job.BLUE, Job.BUILD_CHANGED);
			redToBlueAnimeUnchangedField = addRowToPanel(redToActionPanel, row++, Job.RED, Job.BLUE_ANIME, Job.BUILD_UNCHANGED);
			redToBlueAnimeChangedField = addRowToPanel(redToActionPanel, row++, Job.RED, Job.BLUE_ANIME, Job.BUILD_CHANGED);
			redAnimeToBlueUnchangedField = addRowToPanel(redToActionPanel, row++, Job.RED_ANIME, Job.BLUE, Job.BUILD_UNCHANGED);
			redAnimeToBlueChangedField = addRowToPanel(redToActionPanel, row++, Job.RED_ANIME, Job.BLUE, Job.BUILD_CHANGED);
			redAnimeToBlueAnimeUnchangedField = addRowToPanel(redToActionPanel, row++, Job.RED_ANIME, Job.BLUE_ANIME, Job.BUILD_UNCHANGED);
			redAnimeToBlueAnimeChangedField = addRowToPanel(redToActionPanel, row++, Job.RED_ANIME, Job.BLUE_ANIME, Job.BUILD_CHANGED);
			redToGreyUnchangedField = addRowToPanel(redToActionPanel, row++, Job.RED, Job.GREY, Job.BUILD_UNCHANGED);
			redToGreyChangedField = addRowToPanel(redToActionPanel, row++, Job.RED, Job.GREY, Job.BUILD_CHANGED);
			redAnimeToGreyUnchangedField = addRowToPanel(redToActionPanel, row++, Job.RED_ANIME, Job.GREY, Job.BUILD_UNCHANGED);
			redAnimeToGreyChangedField = addRowToPanel(redToActionPanel, row++, Job.RED_ANIME, Job.GREY, Job.BUILD_CHANGED);
		}
		return redToActionPanel;
	}

	/**
	 * This method initializes yellowToActionPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getYellowToActionPanel() {
		if (yellowToActionPanel == null) {

			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 4;
			gridBagConstraints.gridy = 0;
			yellowToActionPanel = new JPanel();
			yellowToActionPanel.setLayout(new GridBagLayout());

			actionLabel = new JLabel();
			actionLabel.setText("File to Execute");
			yellowToActionPanel.add(actionLabel, gridBagConstraints);

			int row = 0;

			yellowToRedUnchangedField = addRowToPanel(yellowToActionPanel, row++, Job.YELLOW, Job.RED, Job.BUILD_UNCHANGED);
			yellowToRedChangedField = addRowToPanel(yellowToActionPanel, row++, Job.YELLOW, Job.RED, Job.BUILD_CHANGED);
			yellowToRedAnimeUnchangedField = addRowToPanel(yellowToActionPanel, row++, Job.YELLOW, Job.RED_ANIME, Job.BUILD_UNCHANGED);
			yellowToRedAnimeChangedField = addRowToPanel(yellowToActionPanel, row++, Job.YELLOW, Job.RED_ANIME, Job.BUILD_CHANGED);
			yellowAnimeToRedUnchangedField = addRowToPanel(yellowToActionPanel, row++, Job.YELLOW_ANIME, Job.RED, Job.BUILD_UNCHANGED);
			yellowAnimeToRedChangedField = addRowToPanel(yellowToActionPanel, row++, Job.YELLOW_ANIME, Job.RED, Job.BUILD_CHANGED);
			yellowAnimeToRedAnimeUnchangedField = addRowToPanel(yellowToActionPanel, row++, Job.YELLOW_ANIME, Job.RED_ANIME, Job.BUILD_UNCHANGED);
			yellowAnimeToRedAnimeChangedField = addRowToPanel(yellowToActionPanel, row++, Job.YELLOW_ANIME, Job.RED_ANIME, Job.BUILD_CHANGED);
			yellowToYellowUnchangedField = addRowToPanel(yellowToActionPanel, row++, Job.YELLOW, Job.YELLOW, Job.BUILD_UNCHANGED);
			yellowToYellowChangedField = addRowToPanel(yellowToActionPanel, row++, Job.YELLOW, Job.YELLOW, Job.BUILD_CHANGED);
			yellowToYellowAnimeUnchangedField = addRowToPanel(yellowToActionPanel, row++, Job.YELLOW, Job.YELLOW_ANIME, Job.BUILD_UNCHANGED);
			yellowToYellowAnimeChangedField = addRowToPanel(yellowToActionPanel, row++, Job.YELLOW, Job.YELLOW_ANIME, Job.BUILD_CHANGED);
			yellowAnimeToYellowUnchangedField = addRowToPanel(yellowToActionPanel, row++, Job.YELLOW_ANIME, Job.YELLOW, Job.BUILD_UNCHANGED);
			yellowAnimeToYellowChangedField = addRowToPanel(yellowToActionPanel, row++, Job.YELLOW_ANIME, Job.YELLOW, Job.BUILD_CHANGED);
			yellowAnimeToYellowAnimeUnchangedField = addRowToPanel(yellowToActionPanel, row++, Job.YELLOW_ANIME, Job.YELLOW_ANIME, Job.BUILD_UNCHANGED);
			yellowAnimeToYellowAnimeChangedField = addRowToPanel(yellowToActionPanel, row++, Job.YELLOW_ANIME, Job.YELLOW_ANIME, Job.BUILD_CHANGED);
			yellowToBlueUnchangedField = addRowToPanel(yellowToActionPanel, row++, Job.YELLOW, Job.BLUE, Job.BUILD_UNCHANGED);
			yellowToBlueChangedField = addRowToPanel(yellowToActionPanel, row++, Job.YELLOW, Job.BLUE, Job.BUILD_CHANGED);
			yellowToBlueAnimeUnchangedField = addRowToPanel(yellowToActionPanel, row++, Job.YELLOW, Job.BLUE_ANIME, Job.BUILD_UNCHANGED);
			yellowToBlueAnimeChangedField = addRowToPanel(yellowToActionPanel, row++, Job.YELLOW, Job.BLUE_ANIME, Job.BUILD_CHANGED);
			yellowAnimeToBlueUnchangedField = addRowToPanel(yellowToActionPanel, row++, Job.YELLOW_ANIME, Job.BLUE, Job.BUILD_UNCHANGED);
			yellowAnimeToBlueChangedField = addRowToPanel(yellowToActionPanel, row++, Job.YELLOW_ANIME, Job.BLUE, Job.BUILD_CHANGED);
			yellowAnimeToBlueAnimeUnchangedField = addRowToPanel(yellowToActionPanel, row++, Job.YELLOW_ANIME, Job.BLUE_ANIME, Job.BUILD_UNCHANGED);
			yellowAnimeToBlueAnimeChangedField = addRowToPanel(yellowToActionPanel, row++, Job.YELLOW_ANIME, Job.BLUE_ANIME, Job.BUILD_CHANGED);
			yellowToGreyUnchangedField = addRowToPanel(yellowToActionPanel, row++, Job.YELLOW, Job.GREY, Job.BUILD_UNCHANGED);
			yellowToGreyChangedField = addRowToPanel(yellowToActionPanel, row++, Job.YELLOW, Job.GREY, Job.BUILD_CHANGED);
			yellowAnimeToGreyUnchangedField = addRowToPanel(yellowToActionPanel, row++, Job.YELLOW_ANIME, Job.GREY, Job.BUILD_UNCHANGED);
			yellowAnimeToGreyChangedField = addRowToPanel(yellowToActionPanel, row++, Job.YELLOW_ANIME, Job.GREY, Job.BUILD_CHANGED);
		}
		return yellowToActionPanel;
	}

	/**
	 * This method initializes blueToActionPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getBlueToActionPanel() {
		if (blueToActionPanel == null) {

			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 4;
			gridBagConstraints.gridy = 0;
			blueToActionPanel = new JPanel();
			blueToActionPanel.setLayout(new GridBagLayout());

			actionLabel = new JLabel();
			actionLabel.setText("File to Execute");
			blueToActionPanel.add(actionLabel, gridBagConstraints);

			int row = 0;

			blueToRedUnchangedField = addRowToPanel(blueToActionPanel, row++, Job.BLUE, Job.RED, Job.BUILD_UNCHANGED);
			blueToRedChangedField = addRowToPanel(blueToActionPanel, row++, Job.BLUE, Job.RED, Job.BUILD_CHANGED);
			blueToRedAnimeUnchangedField = addRowToPanel(blueToActionPanel, row++, Job.BLUE, Job.RED_ANIME, Job.BUILD_UNCHANGED);
			blueToRedAnimeChangedField = addRowToPanel(blueToActionPanel, row++, Job.BLUE, Job.RED_ANIME, Job.BUILD_CHANGED);
			blueAnimeToRedUnchangedField = addRowToPanel(blueToActionPanel, row++, Job.BLUE_ANIME, Job.RED, Job.BUILD_UNCHANGED);
			blueAnimeToRedChangedField = addRowToPanel(blueToActionPanel, row++, Job.BLUE_ANIME, Job.RED, Job.BUILD_CHANGED);
			blueAnimeToRedAnimeUnchangedField = addRowToPanel(blueToActionPanel, row++, Job.BLUE_ANIME, Job.RED_ANIME, Job.BUILD_UNCHANGED);
			blueAnimeToRedAnimeChangedField = addRowToPanel(blueToActionPanel, row++, Job.BLUE_ANIME, Job.RED_ANIME, Job.BUILD_CHANGED);
			blueToYellowUnchangedField = addRowToPanel(blueToActionPanel, row++, Job.BLUE, Job.YELLOW, Job.BUILD_UNCHANGED);
			blueToYellowChangedField = addRowToPanel(blueToActionPanel, row++, Job.BLUE, Job.YELLOW, Job.BUILD_CHANGED);
			blueToYellowAnimeUnchangedField = addRowToPanel(blueToActionPanel, row++, Job.BLUE, Job.YELLOW_ANIME, Job.BUILD_UNCHANGED);
			blueToYellowAnimeChangedField = addRowToPanel(blueToActionPanel, row++, Job.BLUE, Job.YELLOW_ANIME, Job.BUILD_CHANGED);
			blueAnimeToYellowUnchangedField = addRowToPanel(blueToActionPanel, row++, Job.BLUE_ANIME, Job.YELLOW, Job.BUILD_UNCHANGED);
			blueAnimeToYellowChangedField = addRowToPanel(blueToActionPanel, row++, Job.BLUE_ANIME, Job.YELLOW, Job.BUILD_CHANGED);
			blueAnimeToYellowAnimeUnchangedField = addRowToPanel(blueToActionPanel, row++, Job.BLUE_ANIME, Job.YELLOW_ANIME, Job.BUILD_UNCHANGED);
			blueAnimeToYellowAnimeChangedField = addRowToPanel(blueToActionPanel, row++, Job.BLUE_ANIME, Job.YELLOW_ANIME, Job.BUILD_CHANGED);
			blueToBlueUnchangedField = addRowToPanel(blueToActionPanel, row++, Job.BLUE, Job.BLUE, Job.BUILD_UNCHANGED);
			blueToBlueChangedField = addRowToPanel(blueToActionPanel, row++, Job.BLUE, Job.BLUE, Job.BUILD_CHANGED);
			blueToBlueAnimeUnchangedField = addRowToPanel(blueToActionPanel, row++, Job.BLUE, Job.BLUE_ANIME, Job.BUILD_UNCHANGED);
			blueToBlueAnimeChangedField = addRowToPanel(blueToActionPanel, row++, Job.BLUE, Job.BLUE_ANIME, Job.BUILD_CHANGED);
			blueAnimeToBlueUnchangedField = addRowToPanel(blueToActionPanel, row++, Job.BLUE_ANIME, Job.BLUE, Job.BUILD_UNCHANGED);
			blueAnimeToBlueChangedField = addRowToPanel(blueToActionPanel, row++, Job.BLUE_ANIME, Job.BLUE, Job.BUILD_CHANGED);
			blueAnimeToBlueAnimeUnchangedField = addRowToPanel(blueToActionPanel, row++, Job.BLUE_ANIME, Job.BLUE_ANIME, Job.BUILD_UNCHANGED);
			blueAnimeToBlueAnimeChangedField = addRowToPanel(blueToActionPanel, row++, Job.BLUE_ANIME, Job.BLUE_ANIME, Job.BUILD_CHANGED);
			blueToGreyUnchangedField = addRowToPanel(blueToActionPanel, row++, Job.BLUE, Job.GREY, Job.BUILD_UNCHANGED);
			blueToGreyChangedField = addRowToPanel(blueToActionPanel, row++, Job.BLUE, Job.GREY, Job.BUILD_CHANGED);
			blueAnimeToGreyUnchangedField = addRowToPanel(blueToActionPanel, row++, Job.BLUE_ANIME, Job.GREY, Job.BUILD_UNCHANGED);
			blueAnimeToGreyChangedField = addRowToPanel(blueToActionPanel, row++, Job.BLUE_ANIME, Job.GREY, Job.BUILD_CHANGED);		
		}
		return blueToActionPanel;
	}

	/**
	 * This method initializes greyToActionPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getGreyToActionPanel() {
		if (greyToActionPanel == null) {

			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 4;
			gridBagConstraints.gridy = 0;
			greyToActionPanel = new JPanel();
			greyToActionPanel.setLayout(new GridBagLayout());

			actionLabel = new JLabel();
			actionLabel.setText("File to Execute");
			greyToActionPanel.add(actionLabel, gridBagConstraints);

			int row = 0;

			greyToRedUnchangedField = addRowToPanel(greyToActionPanel, row++, Job.GREY, Job.RED, Job.BUILD_UNCHANGED);
			greyToRedChangedField = addRowToPanel(greyToActionPanel, row++, Job.GREY, Job.RED, Job.BUILD_CHANGED);
			greyToRedAnimeUnchangedField = addRowToPanel(greyToActionPanel, row++, Job.GREY, Job.RED_ANIME, Job.BUILD_UNCHANGED);
			greyToRedAnimeChangedField = addRowToPanel(greyToActionPanel, row++, Job.GREY, Job.RED_ANIME, Job.BUILD_CHANGED);
			greyToYellowUnchangedField = addRowToPanel(greyToActionPanel, row++, Job.GREY, Job.YELLOW, Job.BUILD_UNCHANGED);
			greyToYellowChangedField = addRowToPanel(greyToActionPanel, row++, Job.GREY, Job.YELLOW, Job.BUILD_CHANGED);
			greyToYellowAnimeUnchangedField = addRowToPanel(greyToActionPanel, row++, Job.GREY, Job.YELLOW_ANIME, Job.BUILD_UNCHANGED);
			greyToYellowAnimeChangedField = addRowToPanel(greyToActionPanel, row++, Job.GREY, Job.YELLOW_ANIME, Job.BUILD_CHANGED);
			greyToBlueUnchangedField = addRowToPanel(greyToActionPanel, row++, Job.GREY, Job.BLUE, Job.BUILD_UNCHANGED);
			greyToBlueChangedField = addRowToPanel(greyToActionPanel, row++, Job.GREY, Job.BLUE, Job.BUILD_CHANGED);
			greyToBlueAnimeUnchangedField = addRowToPanel(greyToActionPanel, row++, Job.GREY, Job.BLUE_ANIME, Job.BUILD_UNCHANGED);
			greyToBlueAnimeChangedField = addRowToPanel(greyToActionPanel, row++, Job.GREY, Job.BLUE_ANIME, Job.BUILD_CHANGED);
			greyToGreyUnchangedField = addRowToPanel(greyToActionPanel, row++, Job.GREY, Job.GREY, Job.BUILD_UNCHANGED);
			greyToGreyChangedField = addRowToPanel(greyToActionPanel, row++, Job.GREY, Job.GREY, Job.BUILD_CHANGED);
		}
		return greyToActionPanel;
	}
	
	private void updateConfigurationPanelFromPreferences() {
		updateToField(redToRedUnchangedField, Job.RED, Job.RED, Job.BUILD_UNCHANGED);
		updateToField(redToRedChangedField, Job.RED, Job.RED, Job.BUILD_CHANGED);
		updateToField(redToRedAnimeUnchangedField, Job.RED, Job.RED_ANIME, Job.BUILD_UNCHANGED);
		updateToField(redToRedAnimeChangedField, Job.RED, Job.RED_ANIME, Job.BUILD_CHANGED);
		updateToField(redAnimeToRedUnchangedField, Job.RED_ANIME, Job.RED, Job.BUILD_UNCHANGED);
		updateToField(redAnimeToRedChangedField, Job.RED_ANIME, Job.RED, Job.BUILD_CHANGED);
		updateToField(redAnimeToRedAnimeUnchangedField, Job.RED_ANIME, Job.RED_ANIME, Job.BUILD_UNCHANGED);
		updateToField(redAnimeToRedAnimeChangedField, Job.RED_ANIME, Job.RED_ANIME, Job.BUILD_CHANGED);
		updateToField(redToYellowUnchangedField, Job.RED, Job.YELLOW, Job.BUILD_UNCHANGED);
		updateToField(redToYellowChangedField, Job.RED, Job.YELLOW, Job.BUILD_CHANGED);
		updateToField(redToYellowAnimeUnchangedField, Job.RED, Job.YELLOW_ANIME, Job.BUILD_UNCHANGED);
		updateToField(redToYellowAnimeChangedField, Job.RED, Job.YELLOW_ANIME, Job.BUILD_CHANGED);
		updateToField(redAnimeToYellowUnchangedField, Job.RED_ANIME, Job.YELLOW, Job.BUILD_UNCHANGED);
		updateToField(redAnimeToYellowChangedField, Job.RED_ANIME, Job.YELLOW, Job.BUILD_CHANGED);
		updateToField(redAnimeToYellowAnimeUnchangedField, Job.RED_ANIME, Job.YELLOW_ANIME, Job.BUILD_UNCHANGED);
		updateToField(redAnimeToYellowAnimeChangedField, Job.RED_ANIME, Job.YELLOW_ANIME, Job.BUILD_CHANGED);
		updateToField(redToBlueUnchangedField, Job.RED, Job.BLUE, Job.BUILD_UNCHANGED);
		updateToField(redToBlueChangedField, Job.RED, Job.BLUE, Job.BUILD_CHANGED);
		updateToField(redToBlueAnimeUnchangedField, Job.RED, Job.BLUE_ANIME, Job.BUILD_UNCHANGED);
		updateToField(redToBlueAnimeChangedField, Job.RED, Job.BLUE_ANIME, Job.BUILD_CHANGED);
		updateToField(redAnimeToBlueUnchangedField, Job.RED_ANIME, Job.BLUE, Job.BUILD_UNCHANGED);
		updateToField(redAnimeToBlueChangedField, Job.RED_ANIME, Job.BLUE, Job.BUILD_CHANGED);
		updateToField(redAnimeToBlueAnimeUnchangedField, Job.RED_ANIME, Job.BLUE_ANIME, Job.BUILD_UNCHANGED);
		updateToField(redAnimeToBlueAnimeChangedField, Job.RED_ANIME, Job.BLUE_ANIME, Job.BUILD_CHANGED);
		updateToField(redToGreyUnchangedField, Job.RED, Job.GREY, Job.BUILD_UNCHANGED);
		updateToField(redToGreyChangedField, Job.RED, Job.GREY, Job.BUILD_CHANGED);
		updateToField(redAnimeToGreyChangedField, Job.RED_ANIME, Job.GREY, Job.BUILD_CHANGED);
		updateToField(redAnimeToGreyUnchangedField, Job.RED_ANIME, Job.GREY, Job.BUILD_UNCHANGED);
		updateToField(yellowToRedUnchangedField, Job.YELLOW, Job.RED, Job.BUILD_UNCHANGED);
		updateToField(yellowToRedChangedField, Job.YELLOW, Job.RED, Job.BUILD_CHANGED);
		updateToField(yellowToRedAnimeUnchangedField, Job.YELLOW, Job.RED_ANIME, Job.BUILD_UNCHANGED);
		updateToField(yellowToRedAnimeChangedField, Job.YELLOW, Job.RED_ANIME, Job.BUILD_CHANGED);
		updateToField(yellowAnimeToRedUnchangedField, Job.YELLOW_ANIME, Job.RED, Job.BUILD_UNCHANGED);
		updateToField(yellowAnimeToRedChangedField, Job.YELLOW_ANIME, Job.RED, Job.BUILD_CHANGED);
		updateToField(yellowAnimeToRedAnimeUnchangedField, Job.YELLOW_ANIME, Job.RED_ANIME, Job.BUILD_UNCHANGED);
		updateToField(yellowAnimeToRedAnimeChangedField, Job.YELLOW_ANIME, Job.RED_ANIME, Job.BUILD_CHANGED);
		updateToField(yellowToYellowUnchangedField, Job.YELLOW, Job.YELLOW, Job.BUILD_UNCHANGED);
		updateToField(yellowToYellowChangedField, Job.YELLOW, Job.YELLOW, Job.BUILD_CHANGED);
		updateToField(yellowToYellowAnimeUnchangedField, Job.YELLOW, Job.YELLOW_ANIME, Job.BUILD_UNCHANGED);
		updateToField(yellowToYellowAnimeChangedField, Job.YELLOW, Job.YELLOW_ANIME, Job.BUILD_CHANGED);
		updateToField(yellowAnimeToYellowUnchangedField, Job.YELLOW_ANIME, Job.YELLOW, Job.BUILD_UNCHANGED);
		updateToField(yellowAnimeToYellowChangedField, Job.YELLOW_ANIME, Job.YELLOW, Job.BUILD_CHANGED);
		updateToField(yellowAnimeToYellowAnimeUnchangedField, Job.YELLOW_ANIME, Job.YELLOW_ANIME, Job.BUILD_UNCHANGED);
		updateToField(yellowAnimeToYellowAnimeChangedField, Job.YELLOW_ANIME, Job.YELLOW_ANIME, Job.BUILD_CHANGED);
		updateToField(yellowToBlueUnchangedField, Job.YELLOW, Job.BLUE, Job.BUILD_UNCHANGED);
		updateToField(yellowToBlueChangedField, Job.YELLOW, Job.BLUE, Job.BUILD_CHANGED);
		updateToField(yellowToBlueAnimeUnchangedField, Job.YELLOW, Job.BLUE_ANIME, Job.BUILD_UNCHANGED);
		updateToField(yellowToBlueAnimeChangedField, Job.YELLOW, Job.BLUE_ANIME, Job.BUILD_CHANGED);
		updateToField(yellowAnimeToBlueUnchangedField, Job.YELLOW_ANIME, Job.BLUE, Job.BUILD_UNCHANGED);
		updateToField(yellowAnimeToBlueChangedField, Job.YELLOW_ANIME, Job.BLUE, Job.BUILD_CHANGED);
		updateToField(yellowAnimeToBlueAnimeUnchangedField, Job.YELLOW_ANIME, Job.BLUE_ANIME, Job.BUILD_UNCHANGED);
		updateToField(yellowAnimeToBlueAnimeChangedField, Job.YELLOW_ANIME, Job.BLUE_ANIME, Job.BUILD_CHANGED);
		updateToField(yellowToGreyUnchangedField, Job.YELLOW, Job.GREY, Job.BUILD_UNCHANGED);
		updateToField(yellowToGreyChangedField, Job.YELLOW, Job.GREY, Job.BUILD_CHANGED);
		updateToField(yellowAnimeToGreyUnchangedField, Job.YELLOW_ANIME, Job.GREY, Job.BUILD_UNCHANGED);
		updateToField(yellowAnimeToGreyChangedField, Job.YELLOW_ANIME, Job.GREY, Job.BUILD_CHANGED);
		updateToField(blueToRedUnchangedField, Job.BLUE, Job.RED, Job.BUILD_UNCHANGED);
		updateToField(blueToRedChangedField, Job.BLUE, Job.RED, Job.BUILD_CHANGED);
		updateToField(blueToRedAnimeUnchangedField, Job.BLUE, Job.RED_ANIME, Job.BUILD_UNCHANGED);
		updateToField(blueToRedAnimeChangedField, Job.BLUE, Job.RED_ANIME, Job.BUILD_CHANGED);
		updateToField(blueAnimeToRedUnchangedField, Job.BLUE_ANIME, Job.RED, Job.BUILD_UNCHANGED);
		updateToField(blueAnimeToRedChangedField, Job.BLUE_ANIME, Job.RED, Job.BUILD_CHANGED);
		updateToField(blueAnimeToRedAnimeUnchangedField, Job.BLUE_ANIME, Job.RED_ANIME, Job.BUILD_UNCHANGED);
		updateToField(blueAnimeToRedAnimeChangedField, Job.BLUE_ANIME, Job.RED_ANIME, Job.BUILD_CHANGED);
		updateToField(blueToYellowUnchangedField, Job.BLUE, Job.YELLOW, Job.BUILD_UNCHANGED);
		updateToField(blueToYellowChangedField, Job.BLUE, Job.YELLOW, Job.BUILD_CHANGED);
		updateToField(blueToYellowAnimeUnchangedField, Job.BLUE, Job.YELLOW_ANIME, Job.BUILD_UNCHANGED);
		updateToField(blueToYellowAnimeChangedField, Job.BLUE, Job.YELLOW_ANIME, Job.BUILD_CHANGED);
		updateToField(blueAnimeToYellowUnchangedField, Job.BLUE_ANIME, Job.YELLOW, Job.BUILD_UNCHANGED);
		updateToField(blueAnimeToYellowChangedField, Job.BLUE_ANIME, Job.YELLOW, Job.BUILD_CHANGED);
		updateToField(blueAnimeToYellowAnimeUnchangedField, Job.BLUE_ANIME, Job.YELLOW_ANIME, Job.BUILD_UNCHANGED);
		updateToField(blueAnimeToYellowAnimeChangedField, Job.BLUE_ANIME, Job.YELLOW_ANIME, Job.BUILD_CHANGED);
		updateToField(blueToBlueUnchangedField, Job.BLUE, Job.BLUE, Job.BUILD_UNCHANGED);
		updateToField(blueToBlueChangedField, Job.BLUE, Job.BLUE, Job.BUILD_CHANGED);
		updateToField(blueToBlueAnimeUnchangedField, Job.BLUE, Job.BLUE_ANIME, Job.BUILD_UNCHANGED);
		updateToField(blueToBlueAnimeChangedField, Job.BLUE, Job.BLUE_ANIME, Job.BUILD_CHANGED);
		updateToField(blueAnimeToBlueUnchangedField, Job.BLUE_ANIME, Job.BLUE, Job.BUILD_UNCHANGED);
		updateToField(blueAnimeToBlueChangedField, Job.BLUE_ANIME, Job.BLUE, Job.BUILD_CHANGED);
		updateToField(blueAnimeToBlueAnimeUnchangedField, Job.BLUE_ANIME, Job.BLUE_ANIME, Job.BUILD_UNCHANGED);
		updateToField(blueAnimeToBlueAnimeChangedField, Job.BLUE_ANIME, Job.BLUE_ANIME, Job.BUILD_CHANGED);
		updateToField(blueToGreyUnchangedField, Job.BLUE, Job.GREY, Job.BUILD_UNCHANGED);
		updateToField(blueToGreyChangedField, Job.BLUE, Job.GREY, Job.BUILD_CHANGED);
		updateToField(blueAnimeToGreyUnchangedField, Job.BLUE_ANIME, Job.GREY, Job.BUILD_UNCHANGED);
		updateToField(blueAnimeToGreyChangedField, Job.BLUE_ANIME, Job.GREY, Job.BUILD_CHANGED);
		updateToField(greyToRedUnchangedField, Job.GREY, Job.RED, Job.BUILD_UNCHANGED);
		updateToField(greyToRedChangedField, Job.GREY, Job.RED, Job.BUILD_CHANGED);
		updateToField(greyToRedAnimeUnchangedField, Job.GREY, Job.RED_ANIME, Job.BUILD_UNCHANGED);
		updateToField(greyToRedAnimeChangedField, Job.GREY, Job.RED_ANIME, Job.BUILD_CHANGED);
		updateToField(greyToYellowUnchangedField, Job.GREY, Job.YELLOW, Job.BUILD_UNCHANGED);
		updateToField(greyToYellowChangedField, Job.GREY, Job.YELLOW, Job.BUILD_CHANGED);
		updateToField(greyToYellowAnimeUnchangedField, Job.GREY, Job.YELLOW_ANIME, Job.BUILD_UNCHANGED);
		updateToField(greyToYellowAnimeChangedField, Job.GREY, Job.YELLOW_ANIME, Job.BUILD_CHANGED);
		updateToField(greyToBlueUnchangedField, Job.GREY, Job.BLUE, Job.BUILD_UNCHANGED);
		updateToField(greyToBlueChangedField, Job.GREY, Job.BLUE, Job.BUILD_CHANGED);
		updateToField(greyToBlueAnimeUnchangedField, Job.GREY, Job.BLUE_ANIME, Job.BUILD_UNCHANGED);
		updateToField(greyToBlueAnimeChangedField, Job.GREY, Job.BLUE_ANIME, Job.BUILD_CHANGED);
		updateToField(greyToGreyUnchangedField, Job.GREY, Job.GREY, Job.BUILD_UNCHANGED);
		updateToField(greyToGreyChangedField, Job.GREY, Job.GREY, Job.BUILD_CHANGED);
	}
	
	private void updatePreferencesFromConfiguration() {
		updateFromField(redToRedUnchangedField, Job.RED, Job.RED, Job.BUILD_UNCHANGED);
		updateFromField(redToRedChangedField, Job.RED, Job.RED, Job.BUILD_CHANGED);
		updateFromField(redToRedAnimeUnchangedField, Job.RED, Job.RED_ANIME, Job.BUILD_UNCHANGED);
		updateFromField(redToRedAnimeChangedField, Job.RED, Job.RED_ANIME, Job.BUILD_CHANGED);
		updateFromField(redAnimeToRedUnchangedField, Job.RED_ANIME, Job.RED, Job.BUILD_UNCHANGED);
		updateFromField(redAnimeToRedChangedField, Job.RED_ANIME, Job.RED, Job.BUILD_CHANGED);
		updateFromField(redAnimeToRedAnimeUnchangedField, Job.RED_ANIME, Job.RED_ANIME, Job.BUILD_UNCHANGED);
		updateFromField(redAnimeToRedAnimeChangedField, Job.RED_ANIME, Job.RED_ANIME, Job.BUILD_CHANGED);
		updateFromField(redToYellowUnchangedField, Job.RED, Job.YELLOW, Job.BUILD_UNCHANGED);
		updateFromField(redToYellowChangedField, Job.RED, Job.YELLOW, Job.BUILD_CHANGED);
		updateFromField(redToYellowAnimeUnchangedField, Job.RED, Job.YELLOW_ANIME, Job.BUILD_UNCHANGED);
		updateFromField(redToYellowAnimeChangedField, Job.RED, Job.YELLOW_ANIME, Job.BUILD_CHANGED);
		updateFromField(redAnimeToYellowUnchangedField, Job.RED_ANIME, Job.YELLOW, Job.BUILD_UNCHANGED);
		updateFromField(redAnimeToYellowChangedField, Job.RED_ANIME, Job.YELLOW, Job.BUILD_CHANGED);
		updateFromField(redAnimeToYellowAnimeUnchangedField, Job.RED_ANIME, Job.YELLOW_ANIME, Job.BUILD_UNCHANGED);
		updateFromField(redAnimeToYellowAnimeChangedField, Job.RED_ANIME, Job.YELLOW_ANIME, Job.BUILD_CHANGED);
		updateFromField(redToBlueUnchangedField, Job.RED, Job.BLUE, Job.BUILD_UNCHANGED);
		updateFromField(redToBlueChangedField, Job.RED, Job.BLUE, Job.BUILD_CHANGED);
		updateFromField(redToBlueAnimeUnchangedField, Job.RED, Job.BLUE_ANIME, Job.BUILD_UNCHANGED);
		updateFromField(redToBlueAnimeChangedField, Job.RED, Job.BLUE_ANIME, Job.BUILD_CHANGED);
		updateFromField(redAnimeToBlueUnchangedField, Job.RED_ANIME, Job.BLUE, Job.BUILD_UNCHANGED);
		updateFromField(redAnimeToBlueChangedField, Job.RED_ANIME, Job.BLUE, Job.BUILD_CHANGED);
		updateFromField(redAnimeToBlueAnimeUnchangedField, Job.RED_ANIME, Job.BLUE_ANIME, Job.BUILD_UNCHANGED);
		updateFromField(redAnimeToBlueAnimeChangedField, Job.RED_ANIME, Job.BLUE_ANIME, Job.BUILD_CHANGED);
		updateFromField(redToGreyUnchangedField, Job.RED, Job.GREY, Job.BUILD_UNCHANGED);
		updateFromField(redToGreyChangedField, Job.RED, Job.GREY, Job.BUILD_CHANGED);
		updateFromField(redAnimeToGreyChangedField, Job.RED_ANIME, Job.GREY, Job.BUILD_CHANGED);
		updateFromField(redAnimeToGreyUnchangedField, Job.RED_ANIME, Job.GREY, Job.BUILD_UNCHANGED);
		updateFromField(yellowToRedUnchangedField, Job.YELLOW, Job.RED, Job.BUILD_UNCHANGED);
		updateFromField(yellowToRedChangedField, Job.YELLOW, Job.RED, Job.BUILD_CHANGED);
		updateFromField(yellowToRedAnimeUnchangedField, Job.YELLOW, Job.RED_ANIME, Job.BUILD_UNCHANGED);
		updateFromField(yellowToRedAnimeChangedField, Job.YELLOW, Job.RED_ANIME, Job.BUILD_CHANGED);
		updateFromField(yellowAnimeToRedUnchangedField, Job.YELLOW_ANIME, Job.RED, Job.BUILD_UNCHANGED);
		updateFromField(yellowAnimeToRedChangedField, Job.YELLOW_ANIME, Job.RED, Job.BUILD_CHANGED);
		updateFromField(yellowAnimeToRedAnimeUnchangedField, Job.YELLOW_ANIME, Job.RED_ANIME, Job.BUILD_UNCHANGED);
		updateFromField(yellowAnimeToRedAnimeChangedField, Job.YELLOW_ANIME, Job.RED_ANIME, Job.BUILD_CHANGED);
		updateFromField(yellowToYellowUnchangedField, Job.YELLOW, Job.YELLOW, Job.BUILD_UNCHANGED);
		updateFromField(yellowToYellowChangedField, Job.YELLOW, Job.YELLOW, Job.BUILD_CHANGED);
		updateFromField(yellowToYellowAnimeUnchangedField, Job.YELLOW, Job.YELLOW_ANIME, Job.BUILD_UNCHANGED);
		updateFromField(yellowToYellowAnimeChangedField, Job.YELLOW, Job.YELLOW_ANIME, Job.BUILD_CHANGED);
		updateFromField(yellowAnimeToYellowUnchangedField, Job.YELLOW_ANIME, Job.YELLOW, Job.BUILD_UNCHANGED);
		updateFromField(yellowAnimeToYellowChangedField, Job.YELLOW_ANIME, Job.YELLOW, Job.BUILD_CHANGED);
		updateFromField(yellowAnimeToYellowAnimeUnchangedField, Job.YELLOW_ANIME, Job.YELLOW_ANIME, Job.BUILD_UNCHANGED);
		updateFromField(yellowAnimeToYellowAnimeChangedField, Job.YELLOW_ANIME, Job.YELLOW_ANIME, Job.BUILD_CHANGED);
		updateFromField(yellowToBlueUnchangedField, Job.YELLOW, Job.BLUE, Job.BUILD_UNCHANGED);
		updateFromField(yellowToBlueChangedField, Job.YELLOW, Job.BLUE, Job.BUILD_CHANGED);
		updateFromField(yellowToBlueAnimeUnchangedField, Job.YELLOW, Job.BLUE_ANIME, Job.BUILD_UNCHANGED);
		updateFromField(yellowToBlueAnimeChangedField, Job.YELLOW, Job.BLUE_ANIME, Job.BUILD_CHANGED);
		updateFromField(yellowAnimeToBlueUnchangedField, Job.YELLOW_ANIME, Job.BLUE, Job.BUILD_UNCHANGED);
		updateFromField(yellowAnimeToBlueChangedField, Job.YELLOW_ANIME, Job.BLUE, Job.BUILD_CHANGED);
		updateFromField(yellowAnimeToBlueAnimeUnchangedField, Job.YELLOW_ANIME, Job.BLUE_ANIME, Job.BUILD_UNCHANGED);
		updateFromField(yellowAnimeToBlueAnimeChangedField, Job.YELLOW_ANIME, Job.BLUE_ANIME, Job.BUILD_CHANGED);
		updateFromField(yellowToGreyUnchangedField, Job.YELLOW, Job.GREY, Job.BUILD_UNCHANGED);
		updateFromField(yellowToGreyChangedField, Job.YELLOW, Job.GREY, Job.BUILD_CHANGED);
		updateFromField(yellowAnimeToGreyUnchangedField, Job.YELLOW_ANIME, Job.GREY, Job.BUILD_UNCHANGED);
		updateFromField(yellowAnimeToGreyChangedField, Job.YELLOW_ANIME, Job.GREY, Job.BUILD_CHANGED);
		updateFromField(blueToRedUnchangedField, Job.BLUE, Job.RED, Job.BUILD_UNCHANGED);
		updateFromField(blueToRedChangedField, Job.BLUE, Job.RED, Job.BUILD_CHANGED);
		updateFromField(blueToRedAnimeUnchangedField, Job.BLUE, Job.RED_ANIME, Job.BUILD_UNCHANGED);
		updateFromField(blueToRedAnimeChangedField, Job.BLUE, Job.RED_ANIME, Job.BUILD_CHANGED);
		updateFromField(blueAnimeToRedUnchangedField, Job.BLUE_ANIME, Job.RED, Job.BUILD_UNCHANGED);
		updateFromField(blueAnimeToRedChangedField, Job.BLUE_ANIME, Job.RED, Job.BUILD_CHANGED);
		updateFromField(blueAnimeToRedAnimeUnchangedField, Job.BLUE_ANIME, Job.RED_ANIME, Job.BUILD_UNCHANGED);
		updateFromField(blueAnimeToRedAnimeChangedField, Job.BLUE_ANIME, Job.RED_ANIME, Job.BUILD_CHANGED);
		updateFromField(blueToYellowUnchangedField, Job.BLUE, Job.YELLOW, Job.BUILD_UNCHANGED);
		updateFromField(blueToYellowChangedField, Job.BLUE, Job.YELLOW, Job.BUILD_CHANGED);
		updateFromField(blueToYellowAnimeUnchangedField, Job.BLUE, Job.YELLOW_ANIME, Job.BUILD_UNCHANGED);
		updateFromField(blueToYellowAnimeChangedField, Job.BLUE, Job.YELLOW_ANIME, Job.BUILD_CHANGED);
		updateFromField(blueAnimeToYellowUnchangedField, Job.BLUE_ANIME, Job.YELLOW, Job.BUILD_UNCHANGED);
		updateFromField(blueAnimeToYellowChangedField, Job.BLUE_ANIME, Job.YELLOW, Job.BUILD_CHANGED);
		updateFromField(blueAnimeToYellowAnimeUnchangedField, Job.BLUE_ANIME, Job.YELLOW_ANIME, Job.BUILD_UNCHANGED);
		updateFromField(blueAnimeToYellowAnimeChangedField, Job.BLUE_ANIME, Job.YELLOW_ANIME, Job.BUILD_CHANGED);
		updateFromField(blueToBlueUnchangedField, Job.BLUE, Job.BLUE, Job.BUILD_UNCHANGED);
		updateFromField(blueToBlueChangedField, Job.BLUE, Job.BLUE, Job.BUILD_CHANGED);
		updateFromField(blueToBlueAnimeUnchangedField, Job.BLUE, Job.BLUE_ANIME, Job.BUILD_UNCHANGED);
		updateFromField(blueToBlueAnimeChangedField, Job.BLUE, Job.BLUE_ANIME, Job.BUILD_CHANGED);
		updateFromField(blueAnimeToBlueUnchangedField, Job.BLUE_ANIME, Job.BLUE, Job.BUILD_UNCHANGED);
		updateFromField(blueAnimeToBlueChangedField, Job.BLUE_ANIME, Job.BLUE, Job.BUILD_CHANGED);
		updateFromField(blueAnimeToBlueAnimeUnchangedField, Job.BLUE_ANIME, Job.BLUE_ANIME, Job.BUILD_UNCHANGED);
		updateFromField(blueAnimeToBlueAnimeChangedField, Job.BLUE_ANIME, Job.BLUE_ANIME, Job.BUILD_CHANGED);
		updateFromField(blueToGreyUnchangedField, Job.BLUE, Job.GREY, Job.BUILD_UNCHANGED);
		updateFromField(blueToGreyChangedField, Job.BLUE, Job.GREY, Job.BUILD_CHANGED);
		updateFromField(blueAnimeToGreyUnchangedField, Job.BLUE_ANIME, Job.GREY, Job.BUILD_UNCHANGED);
		updateFromField(blueAnimeToGreyChangedField, Job.BLUE_ANIME, Job.GREY, Job.BUILD_CHANGED);
		updateFromField(greyToRedUnchangedField, Job.GREY, Job.RED, Job.BUILD_UNCHANGED);
		updateFromField(greyToRedChangedField, Job.GREY, Job.RED, Job.BUILD_CHANGED);
		updateFromField(greyToRedAnimeUnchangedField, Job.GREY, Job.RED_ANIME, Job.BUILD_UNCHANGED);
		updateFromField(greyToRedAnimeChangedField, Job.GREY, Job.RED_ANIME, Job.BUILD_CHANGED);
		updateFromField(greyToYellowUnchangedField, Job.GREY, Job.YELLOW, Job.BUILD_UNCHANGED);
		updateFromField(greyToYellowChangedField, Job.GREY, Job.YELLOW, Job.BUILD_CHANGED);
		updateFromField(greyToYellowAnimeUnchangedField, Job.GREY, Job.YELLOW_ANIME, Job.BUILD_UNCHANGED);
		updateFromField(greyToYellowAnimeChangedField, Job.GREY, Job.YELLOW_ANIME, Job.BUILD_CHANGED);
		updateFromField(greyToBlueUnchangedField, Job.GREY, Job.BLUE, Job.BUILD_UNCHANGED);
		updateFromField(greyToBlueChangedField, Job.GREY, Job.BLUE, Job.BUILD_CHANGED);
		updateFromField(greyToBlueAnimeUnchangedField, Job.GREY, Job.BLUE_ANIME, Job.BUILD_UNCHANGED);
		updateFromField(greyToBlueAnimeChangedField, Job.GREY, Job.BLUE_ANIME, Job.BUILD_CHANGED);
		updateFromField(greyToGreyUnchangedField, Job.GREY, Job.GREY, Job.BUILD_UNCHANGED);
		updateFromField(greyToGreyChangedField, Job.GREY, Job.GREY, Job.BUILD_CHANGED);
	}
	
	private void updateToField(final JTextField field, final Integer colourFrom, final Integer colourTo, final Integer buildType) {
		FileExecutor action = (FileExecutor) prefs.getAction(colourFrom, colourTo, buildType);
		if (action != null) {
			field.setText(action.getFileToExecute());
			field.invalidate();
		}
	}
	
	private void updateFromField(final JTextField field, final Integer colourFrom, final Integer colourTo, final Integer buildType) {
		prefs.setAction(colourFrom, colourTo, buildType, field.getText());
	}
	
	private void updatePreferencesFromUIConfiguration() {
		prefs.setShowAnimatedBuilds(showAnimatedBuildCB.isSelected());
		prefs.setShowHealthIcon(showHealthCB.isSelected());
		prefs.setShowPopupNotifications(showPopupNotificationCB.isSelected());
	}
	
	private void updateUIConfigurationFromPreferences() {
		showAnimatedBuildCB.setSelected(prefs.isShowAnimatedBuilds());
		showHealthCB.setSelected(prefs.isShowHealthIcon());
		showPopupNotificationCB.setSelected(prefs.isShowPopupNotifications());
	}
	
	public void setModel(Model model) {
		this.model = model;
		updateServerListModel(model);
	}
	
	public void updateServerListModel(Model model) {
		if (serverListModel == null) {
			serverListModel = new ServerListModel(model);
			serverList.setModel(serverListModel);
			serverList.setSelectedIndices(new int[0]);
			serverLocationField.setEnabled(false);
			serverNameField.setEnabled(false);
			serverList.repaint();
		}
		serverListModel.setModel(model);
	}
	
	public void setPreferences(Preferences prefs) {
		this.prefs = prefs;
		updateField.setText(Integer.toString(prefs.getUpdateFrequency()));
	}
	
	public void updateResults() {
		if (model.getServerModelSize() > 0) {
			Server server = model.getServerAt(0);
			updateResults(server);
			getDescriptionEditorPane().setText(server.getDescription());
			String colour = model.getWorstColour(false);
			int red = model.getNumberOfRedJobs();
			int yellow = model.getNumberOfYellowJobs();
			int blue = model.getNumberOfBlueJobs();
			int grey = model.getNumberOfGreyJobs();
			int building = model.getNumberOfBuildingJobs();
			setWorstCaseColour(colour);
			updateOverallStatusPanel(colour, red, yellow, blue, grey, building);
		}
	}

	/**
	 * This method initializes serverNamePanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getServerNamePanel() {
		if (serverNamePanel == null) {
			serverNamePanel = new JPanel();
			serverNamePanel.setLayout(null);
			serverNamePanel.setPreferredSize(new Dimension(200, 200));
			serverNamePanel.add(serverNameLabel, null);
			serverNamePanel.add(serverLocationLabel, null);
			serverNamePanel.add(getServerNameField(), null);
			serverNamePanel.add(getServerLocationField(), null);
		}
		return serverNamePanel;
	}

	/**
	 * This method initializes serverChangesApplyPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getServerChangesApplyPanel() {
		if (serverChangesApplyPanel == null) {
			serverChangesApplyPanel = new JPanel();
			serverChangesApplyPanel.setLayout(new BorderLayout());
			serverChangesApplyPanel.add(getApplyServerChangesButton(), BorderLayout.EAST);
		}
		return serverChangesApplyPanel;
	}

	/**
	 * This method initializes applyServerChangesButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getApplyServerChangesButton() {
		if (applyServerChangesButton == null) {
			applyServerChangesButton = new JButton();
			applyServerChangesButton.setText("Apply Changes");
			applyServerChangesButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int index = serverList.getSelectedIndex();
					if (index != -1) {
						Server server = model.getServerAt(index);
						server.setName(serverNameField.getText());
						server.setUrl(serverLocationField.getText());
						serverListModel.objectChanged(index);
					}
					int newFrequency = Integer.parseInt(updateField.getText());
					if (newFrequency != prefs.getUpdateFrequency() && newFrequency > 0){
						prefs.setUpdateFrequency(newFrequency);
						HudsonTrayApp.getHudsonTrayAppInstance().scheduleTimer(newFrequency * 60000, false);
					}
				}
			});
		}
		return applyServerChangesButton;
	}

	/**
	 * This method initializes uiConfigurationPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getUiConfigurationPanel() {
		if (uiConfigurationPanel == null) {
			GridLayout gridLayout2 = new GridLayout();
			gridLayout2.setRows(2);
			gridLayout2.setColumns(1);
			uiConfigurationPanel = new JPanel();
			uiConfigurationPanel.setLayout(gridLayout2);
			uiConfigurationPanel.setName("uiConfigurationPanel");
			uiConfigurationPanel.add(getTrayIconConfigurationPanel(), null);
		}
		return uiConfigurationPanel;
	}

	/**
	 * This method initializes trayIconConfigurationPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getTrayIconConfigurationPanel() {
		if (trayIconConfigurationPanel == null) {
			showPopupNotificationLabel = new JLabel();
			showPopupNotificationLabel.setText("Show Popup Notifications");
			showPopupNotificationLabel.setToolTipText("Note: Messages will show for Java Exceptions regardless of this setting");
			showAnimatedBuildLabel = new JLabel();
			showAnimatedBuildLabel.setText("Show Animation when Building");
			showHealthLabel = new JLabel();
			showHealthLabel.setText("Show Health Icons on System Tray");
			GridLayout gridLayout3 = new GridLayout();
			gridLayout3.setRows(3);
			gridLayout3.setHgap(0);
			gridLayout3.setColumns(2);
			trayIconConfigurationPanel = new JPanel();
			trayIconConfigurationPanel.setLayout(gridLayout3);
			trayIconConfigurationPanel.setBorder(BorderFactory.createTitledBorder(null, "Tray Icon Configuration", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			trayIconConfigurationPanel.add(showHealthLabel, null);
			trayIconConfigurationPanel.add(getShowHealthCB(), null);
			trayIconConfigurationPanel.add(showAnimatedBuildLabel, null);
			trayIconConfigurationPanel.add(getShowAnimatedBuildCB(), null);
			trayIconConfigurationPanel.add(showPopupNotificationLabel, null);
			trayIconConfigurationPanel.add(getShowPopupNotificationCB(), null);
		}
		return trayIconConfigurationPanel;
	}

	/**
	 * This method initializes showHealthCB	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getShowHealthCB() {
		if (showHealthCB == null) {
			showHealthCB = new JCheckBox();
			showHealthCB.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					updatePreferencesFromUIConfiguration();
					HudsonTrayApp.getHudsonTrayAppInstance().updateTrayIcon();
				}
			});
		}
		return showHealthCB;
	}

	/**
	 * This method initializes showAnimatedBuildCB	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getShowAnimatedBuildCB() {
		if (showAnimatedBuildCB == null) {
			showAnimatedBuildCB = new JCheckBox();
			showAnimatedBuildCB.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					updatePreferencesFromUIConfiguration();
					HudsonTrayApp.getHudsonTrayAppInstance().updateTrayIcon();
				}
			});
		}
		return showAnimatedBuildCB;
	}

	/**
	 * This method initializes showPopupNotificationCB	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getShowPopupNotificationCB() {
		if (showPopupNotificationCB == null) {
			showPopupNotificationCB = new JCheckBox();
			showPopupNotificationCB.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					updatePreferencesFromUIConfiguration();
				}
			});
		}
		return showPopupNotificationCB;
	}
}  //  @jve:decl-index=0:visual-constraint="0,-42"
