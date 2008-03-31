package org.hudson.trayapp.gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.JList;
import java.awt.Dimension;
import java.awt.CardLayout;
import javax.swing.BorderFactory;
import javax.swing.border.EtchedBorder;
import javax.swing.JFileChooser;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListDataListener;

import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

import org.hudson.trayapp.HudsonTrayApp;
import org.hudson.trayapp.actions.FileExecutor;
import org.hudson.trayapp.model.Job;
import org.hudson.trayapp.model.Model;
import org.hudson.trayapp.model.Preferences;
import org.hudson.trayapp.model.Server;

public class ConfigurationPanel extends JPanel {

	private JSplitPane configurationSplitPane = null;
	private JList configurationList = null;
	private JPanel configurationRightPanel = null;
	private JPanel serverConfigurationPane = null;
	private JPanel serverConfigurationTopPane = null;
	private JPanel serverPanel = null;
	private JPanel spacingPanel = null;
	private JList serverList = null;
	private JLabel topLabel = null;
	private JLabel westLabel = null;
	private JLabel eastLabel = null;
	private JPanel bottomPanel = null;
	private JButton addServerButton = null;
	private JButton removeServerButton = null;
	private JPanel serverDetailsPane = null;
	private JPanel serverNamePanel = null;
	private JLabel serverNameLabel = null;
	private JLabel serverLocationLabel = null;
	private JTextField serverNameField = null;
	private JTextField serverLocationField = null;
	private JPanel serverChangesApplyPanel = null;
	private JButton applyServerChangesButton = null;
	private JPanel updatePanel = null;
	private JLabel updateFrequencyLabel = null;
	private JPanel updateFrequencyPanel = null;
	private JTextField updateField = null;
	private JLabel updateFrequencyTimeScaleLabel = null;
	private JLabel updateFrequencyEveryLabel = null;
	private JPanel actionConfigurationPanel = null;
	private JTabbedPane actionTabbedPane = null;
	private JPanel redToActionPanel = null;
	private JLabel actionLabel = null;
	private JPanel yellowToActionPanel = null;
	private JLabel actionLabel1 = null;
	private JPanel blueToActionPanel = null;
	private JLabel actionLabel2 = null;
	private JPanel greyToActionPanel = null;
	private JLabel actionLabel3 = null;
	private JPanel uiConfigurationPanel = null;
	private JPanel trayIconConfigurationPanel = null;
	private JLabel showHealthLabel = null;
	private JCheckBox showHealthCB = null;
	private JLabel showAnimatedBuildLabel = null;
	private JCheckBox showAnimatedBuildCB = null;
	private JLabel showPopupNotificationLabel = null;
	private JCheckBox showPopupNotificationCB = null;
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
	private JPanel configurationBottomPanel = null;

	private Preferences prefs = null;
	private Model model = null;
	private ServerListModel serverListModel = null;
	
	/**
	 * This method initializes 
	 * 
	 */
	public ConfigurationPanel() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 */
	private void initialize() {
        this.setLayout(new BorderLayout());
        this.add(getConfigurationSplitPane(), BorderLayout.CENTER);
        this.add(getConfigurationBottomPanel(), BorderLayout.SOUTH);
			
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
			configurationList.setModel(new javax.swing.ListModel(){
			  final String[] SA=new String[]{"Server","Actions","UI Config"};
			  public void addListDataListener(  ListDataListener l){
			  }
			  public Object getElementAt(  int index){
			    return SA[index];
			  }
			  public int getSize(){
			    return 3;
			  }
			  public void removeListDataListener(  ListDataListener l){
			  }
			}
			);
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
	 * This method initializes serverConfigurationPane	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getServerConfigurationPane() {
		if (serverConfigurationPane == null) {
			serverConfigurationPane = new JPanel();
			serverConfigurationPane.setLayout(new BorderLayout());
			serverConfigurationPane.add(getServerConfigurationTopPane(), java.awt.BorderLayout.CENTER);
			serverConfigurationPane.add(getUpdatePanel(), java.awt.BorderLayout.SOUTH);
			serverConfigurationPane.setName("Servers");
		}
		return serverConfigurationPane;
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
			serverConfigurationTopPane = new JPanel();
			serverConfigurationTopPane.setLayout(borderLayout1);
			serverConfigurationTopPane.add(getServerPanel(), java.awt.BorderLayout.CENTER);
		}
		return serverConfigurationTopPane;
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
			serverPanel.setBorder(BorderFactory.createTitledBorder(null, "Servers", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			serverPanel.add(getSpacingPanel(), java.awt.BorderLayout.WEST);
			serverPanel.add(getServerDetailsPane(), java.awt.BorderLayout.CENTER);
		}
		return serverPanel;
	}

	/**
	 * This method initializes spacingPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getSpacingPanel() {
		if (spacingPanel == null) {
			eastLabel = new JLabel();
			eastLabel.setPreferredSize(new Dimension(5, 5));
			eastLabel.setText("");
			westLabel = new JLabel();
			westLabel.setPreferredSize(new Dimension(5, 5));
			westLabel.setText("");
			topLabel = new JLabel();
			topLabel.setPreferredSize(new Dimension(5, 5));
			topLabel.setText("");
			spacingPanel = new JPanel();
			spacingPanel.setLayout(new BorderLayout());
			spacingPanel.add(getServerList(), java.awt.BorderLayout.CENTER);
			spacingPanel.add(topLabel, java.awt.BorderLayout.NORTH);
			spacingPanel.add(westLabel, java.awt.BorderLayout.WEST);
			spacingPanel.add(eastLabel, java.awt.BorderLayout.EAST);
			spacingPanel.add(getBottomPanel(), java.awt.BorderLayout.SOUTH);
		}
		return spacingPanel;
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
					int index = serverList.locationToIndex(e.getPoint());
					if (index != -1 && index < model.getServerModelSize()) {
						Server server = model.getServerAt(index);
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
				}
			});
		}
		return serverList;
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
			bottomPanel.add(getAddServerButton(), java.awt.BorderLayout.WEST);
			bottomPanel.add(getRemoveServerButton(), java.awt.BorderLayout.EAST);
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
	 * This method initializes serverDetailsPane	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getServerDetailsPane() {
		if (serverDetailsPane == null) {
			serverDetailsPane = new JPanel();
			serverDetailsPane.setLayout(new BorderLayout());
			serverDetailsPane.add(getServerNamePanel(), java.awt.BorderLayout.CENTER);
			serverDetailsPane.add(getServerChangesApplyPanel(), java.awt.BorderLayout.SOUTH);
		}
		return serverDetailsPane;
	}

	/**
	 * This method initializes serverNamePanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getServerNamePanel() {
		if (serverNamePanel == null) {
			serverLocationLabel = new JLabel();
			serverLocationLabel.setBounds(new Rectangle(8, 40, 90, 16));
			serverLocationLabel.setText("Server Location");
			serverNameLabel = new JLabel();
			serverNameLabel.setBounds(new Rectangle(8, 12, 74, 16));
			serverNameLabel.setText("Server Name");
			serverNamePanel = new JPanel();
			serverNamePanel.setLayout(null);
			serverNamePanel.add(serverNameLabel, null);
			serverNamePanel.add(serverLocationLabel, null);
			serverNamePanel.add(getServerNameField(), null);
			serverNamePanel.add(getServerLocationField(), null);
		}
		return serverNamePanel;
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
	 * This method initializes serverChangesApplyPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getServerChangesApplyPanel() {
		if (serverChangesApplyPanel == null) {
			serverChangesApplyPanel = new JPanel();
			serverChangesApplyPanel.setLayout(new BorderLayout());
			serverChangesApplyPanel.add(getApplyServerChangesButton(), java.awt.BorderLayout.EAST);
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
	 * This method initializes updatePanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getUpdatePanel() {
		if (updatePanel == null) {
			updateFrequencyLabel = new JLabel();
			updateFrequencyLabel.setText("Frequency of Update");
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
	 * This method initializes updateFrequencyPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getUpdateFrequencyPanel() {
		if (updateFrequencyPanel == null) {
			updateFrequencyEveryLabel = new JLabel();
			updateFrequencyEveryLabel.setText("every");
			updateFrequencyTimeScaleLabel = new JLabel();
			updateFrequencyTimeScaleLabel.setText("minutes");
			BorderLayout borderLayout = new BorderLayout();
			borderLayout.setHgap(3);
			updateFrequencyPanel = new JPanel();
			updateFrequencyPanel.setLayout(borderLayout);
			updateFrequencyPanel.add(getUpdateField(), java.awt.BorderLayout.CENTER);
			updateFrequencyPanel.add(updateFrequencyTimeScaleLabel, java.awt.BorderLayout.EAST);
			updateFrequencyPanel.add(updateFrequencyEveryLabel, java.awt.BorderLayout.WEST);
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
		}
		return updateField;
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
			actionConfigurationPanel.setBorder(BorderFactory.createTitledBorder(null, "Actions", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			actionConfigurationPanel.add(getActionTabbedPane(), java.awt.BorderLayout.CENTER);
			actionConfigurationPanel.setName("Actions");
		}
		return actionConfigurationPanel;
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
			uiConfigurationPanel.add(getTrayIconConfigurationPanel(), null);
			uiConfigurationPanel.setName("UI Configuration");
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
			showPopupNotificationLabel.setToolTipText("Note: Messages will show for Java Exceptions regardless of this setting");
			showPopupNotificationLabel.setText("Show Popup Notifications");
			showAnimatedBuildLabel = new JLabel();
			showAnimatedBuildLabel.setText("Show Animation when Building");
			showHealthLabel = new JLabel();
			showHealthLabel.setText("Show Health Icons on System Tray");
			GridLayout gridLayout3 = new GridLayout();
			gridLayout3.setRows(3);
			gridLayout3.setHgap(0);
			gridLayout3.setColumns(2);
			trayIconConfigurationPanel = new JPanel();
			trayIconConfigurationPanel.setBorder(BorderFactory.createTitledBorder(null, "Tray Icon Configuration", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			trayIconConfigurationPanel.setLayout(gridLayout3);
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
	
	public void updateServerListModel(Model model) {
		this.model = model;
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
}
