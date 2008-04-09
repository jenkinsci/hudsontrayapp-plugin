package org.hudson.trayapp.gui;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
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
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

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
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.event.ListDataListener;
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
import javax.swing.JTextArea;

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
	private LatestResultsPanel resultsPanel = null;
	private ConfigurationPanel configurationPanel = null;
	private Model model = null;  //  @jve:decl-index=0:
	private JPanel aboutPanel = null;
	private JLabel hudsonTrayAppLabel = null;
	private JPanel versionInformationPanel = null;
	private JLabel versionLabel = null;
	private JPanel licenseInformationPanel = null;
	private JTextArea licenseInformationTextArea = null;
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
		this.setTitle("Hudson Tray Application");
		
		addWindowStateListener(new WindowStateListener() {

			public void windowStateChanged(WindowEvent e) {
				if (e.getID() == WindowEvent.WINDOW_STATE_CHANGED && e.getNewState() == Frame.ICONIFIED) {
					setVisible(false);
					setState(Frame.NORMAL);
					dispose();
				}
			}	
		});
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
			mainTabbedPane.setName("");
			mainTabbedPane.addTab("Latest Results", null, getResultsPanel(), null);
			mainTabbedPane.addTab("Configuration", null, getConfigurationPanel(), null);
			mainTabbedPane.addTab("About", null, getAboutPanel(), null);
		}
		return mainTabbedPane;
	}

	/**
	 * This method initializes resultsPanel
	 *
	 * @return org.hudson.trayapp.gui.LatestResultsPanel
	 */
	private LatestResultsPanel getResultsPanel() {
		if (resultsPanel == null) {
			resultsPanel = new LatestResultsPanel();
		}
		return resultsPanel;
	}

	/**
	 * This method initializes configurationPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private ConfigurationPanel getConfigurationPanel() {
		if (configurationPanel == null) {
			configurationPanel = new ConfigurationPanel();
		}
		return configurationPanel;
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
	
	public void setModel(Model model) {
		this.model = model;
		getConfigurationPanel().updateServerListModel(model);
	}
	
	public void setPreferences(Preferences prefs) {
		getConfigurationPanel().setPreferences(prefs);
	}
	
	public void updateResults() {
		if (model.getServerModelSize() > 0) {
			Server server = model.getServerAt(0);
			getResultsPanel().setModel(model);
		}
	}

	/**
	 * This method initializes aboutPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getAboutPanel() {
		if (aboutPanel == null) {
			hudsonTrayAppLabel = new JLabel();
			hudsonTrayAppLabel.setText("Hudson Tray Application");
			hudsonTrayAppLabel.setHorizontalTextPosition(SwingConstants.CENTER);
			hudsonTrayAppLabel.setHorizontalAlignment(SwingConstants.CENTER);
			aboutPanel = new JPanel();
			aboutPanel.setLayout(new BorderLayout());
			aboutPanel.add(getVersionInformationPanel(), BorderLayout.NORTH);
			aboutPanel.add(getLicenseInformationPanel(), BorderLayout.CENTER);
		}
		return aboutPanel;
	}

	/**
	 * This method initializes versionInformationPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getVersionInformationPanel() {
		if (versionInformationPanel == null) {
			versionLabel = new JLabel();
			versionLabel.setText("Version: " + HudsonTrayApp.VERSION);
			versionLabel.setHorizontalTextPosition(SwingConstants.CENTER);
			versionLabel.setHorizontalAlignment(SwingConstants.CENTER);
			versionInformationPanel = new JPanel();
			versionInformationPanel.setLayout(new BorderLayout());
			versionInformationPanel.add(hudsonTrayAppLabel, BorderLayout.CENTER);
			versionInformationPanel.add(versionLabel, BorderLayout.SOUTH);
		}
		return versionInformationPanel;
	}

	/**
	 * This method initializes licenseInformationPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getLicenseInformationPanel() {
		if (licenseInformationPanel == null) {
			licenseInformationPanel = new JPanel();
			licenseInformationPanel.setLayout(new BorderLayout());
			licenseInformationPanel.add(getLicenseInformationTextArea(), BorderLayout.CENTER);
		}
		return licenseInformationPanel;
	}

	/**
	 * This method initializes licenseInformationTextArea	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getLicenseInformationTextArea() {
		if (licenseInformationTextArea == null) {
			licenseInformationTextArea = new JTextArea();
			licenseInformationTextArea.setEditable(false);
			licenseInformationTextArea.setText("Hudson Tray Application\n\nAuthors:\nDavid Hayes\n\nLicense:\nGPLv3 (http://www.gnu.org/licenses/gpl.html) - Compatible with Hudson's MIT License\n\nContributory Code:\nBase64 - iHarder.net (Public Domain)\nTableSorter - Sun JDK 1.4.2_17 Demo (Public Domain)\njdic - jdic.dev.java.net (LGPL)");
		}
		return licenseInformationTextArea;
	}
}  //  @jve:decl-index=0:visual-constraint="0,-42"
