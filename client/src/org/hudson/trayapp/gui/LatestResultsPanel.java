package org.hudson.trayapp.gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;

import java.util.List;
import java.util.Vector;

import org.hudson.trayapp.model.Model;


public class LatestResultsPanel extends JPanel {

	private JPanel resultsTopPanel = null;
	private JLabel resultsOverallLabel = null;
	private JPanel statusPanel = null;
	private JLabel statusLabel = null;
	private JPanel statusOverviewPane = null;
	private JLabel failedStatusLabel = null;
	private JLabel unstableStatusLabel = null;
	private JLabel stableStatusLabel = null;
	private JLabel disabledStatusLabel = null;
	private JLabel buildingStatusLabel = null;
	private JScrollPane resultsTableScrollPane = null;
	private JPanel resultsTablePanel = null;
	
	private List listServerResultsPanel = null;
	/**
	 * This method initializes 
	 * 
	 */
	public LatestResultsPanel() {
		super();
		listServerResultsPanel = new Vector();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 */
	private void initialize() {
        this.setLayout(new BorderLayout());
        this.add(getResultsTopPanel(), BorderLayout.NORTH);
        this.add(getResultsTableScrollPane(), BorderLayout.CENTER);
			
	}

	/**
	 * This method initializes resultsTopPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getResultsTopPanel() {
		if (resultsTopPanel == null) {
			resultsOverallLabel = new JLabel();
			resultsOverallLabel.setIcon(new ImageIcon(getClass().getResource("/org/hudson/trayapp/gui/icons/48x48/red.gif")));
			resultsOverallLabel.setText("Overall Status");
			resultsTopPanel = new JPanel();
			resultsTopPanel.setLayout(new BorderLayout());
			resultsTopPanel.add(resultsOverallLabel, java.awt.BorderLayout.WEST);
			resultsTopPanel.add(getStatusPanel(), java.awt.BorderLayout.CENTER);
		}
		return resultsTopPanel;
	}

	/**
	 * This method initializes statusPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getStatusPanel() {
		if (statusPanel == null) {
			buildingStatusLabel = new JLabel();
			buildingStatusLabel.setHorizontalAlignment(SwingConstants.CENTER);
			buildingStatusLabel.setText("5 job(s) building");
			statusLabel = new JLabel();
			statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
			statusLabel.setText("Status Overview");
			statusPanel = new JPanel();
			statusPanel.setLayout(new BorderLayout());
			statusPanel.add(statusLabel, java.awt.BorderLayout.NORTH);
			statusPanel.add(getStatusOverviewPane(), java.awt.BorderLayout.CENTER);
			statusPanel.add(buildingStatusLabel, java.awt.BorderLayout.SOUTH);
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
			disabledStatusLabel.setIcon(new ImageIcon(getClass().getResource("/org/hudson/trayapp/gui/icons/16x16/grey.gif")));
			disabledStatusLabel.setText("4 job(s) disabled");
			stableStatusLabel = new JLabel();
			stableStatusLabel.setIcon(new ImageIcon(getClass().getResource("/org/hudson/trayapp/gui/icons/16x16/blue.gif")));
			stableStatusLabel.setText("3 job(s) stable");
			unstableStatusLabel = new JLabel();
			unstableStatusLabel.setIcon(new ImageIcon(getClass().getResource("/org/hudson/trayapp/gui/icons/16x16/yellow.gif")));
			unstableStatusLabel.setText("2 job(s) unstable");
			failedStatusLabel = new JLabel();
			failedStatusLabel.setIcon(new ImageIcon(getClass().getResource("/org/hudson/trayapp/gui/icons/16x16/red.gif")));
			failedStatusLabel.setText("1 job(s) failed");
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
	 * This method initializes resultsTablePanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getResultsTablePanel() {
		if (resultsTablePanel == null) {
			resultsTablePanel = new JPanel();
			resultsTablePanel.setLayout(new BoxLayout(getResultsTablePanel(), BoxLayout.Y_AXIS));
		}
		return resultsTablePanel;
	}

	public void setWorstCaseColour(String colour) {
		resultsOverallLabel.setIcon(new ImageIcon(getClass().getResource("/org/hudson/trayapp/gui/icons/48x48/" + colour +".gif")));
	}
	
	public void setModel(Model model) {
		updateOveralHealth(model);
		changeServerResultsToSize(model.getServerModelSize());
		for (int i = 0; i < model.getServerModelSize(); i++) {
			ServerResultsPanel srp = (ServerResultsPanel) listServerResultsPanel.get(i);
			srp.setServer(model.getServerAt(i));
		}
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
	
	public void updateOveralHealth(Model model) {
		String colour = model.getWorstColour(false);
		int red = model.getNumberOfRedJobs();
		int yellow = model.getNumberOfYellowJobs();
		int blue = model.getNumberOfBlueJobs();
		int grey = model.getNumberOfGreyJobs();
		int building = model.getNumberOfBuildingJobs();
		setWorstCaseColour(colour);
		updateOverallStatusPanel(colour, red, yellow, blue, grey, building);
	}
	
	private void changeServerResultsToSize(int size) {
		if (size != listServerResultsPanel.size() && size >= 0) {
			while (size < listServerResultsPanel.size()) {
				ServerResultsPanel srp = (ServerResultsPanel) listServerResultsPanel.remove(listServerResultsPanel.size() - 1);
				getResultsTablePanel().remove(srp);
			}
			while (size > listServerResultsPanel.size()) {
				ServerResultsPanel srp = new ServerResultsPanel();
				listServerResultsPanel.add(srp);
				getResultsTablePanel().add(srp);
			}
		}
	}

}
