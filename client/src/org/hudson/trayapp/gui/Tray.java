package org.hudson.trayapp.gui;
import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.hudson.trayapp.HudsonTrayApp;
import org.hudson.trayapp.model.Job;

public class Tray {
	final private SystemTray tray;
	final private TrayIcon trayIcon;

	private final static Image BLUE_ANIME = Toolkit.getDefaultToolkit().getImage(Tray.class.getResource("/org/hudson/trayapp/gui/icons/tray/blue_anime.gif"));
	private final static Image BLUE = Toolkit.getDefaultToolkit().getImage(Tray.class.getResource("/org/hudson/trayapp/gui/icons/tray/blue.gif"));
	private final static Image GREY_ANIME = Toolkit.getDefaultToolkit().getImage(Tray.class.getResource("/org/hudson/trayapp/gui/icons/tray/grey_anime.gif"));
	private final static Image GREY = Toolkit.getDefaultToolkit().getImage(Tray.class.getResource("/org/hudson/trayapp/gui/icons/tray/grey.gif"));
	private final static Image RED_ANIME = Toolkit.getDefaultToolkit().getImage(Tray.class.getResource("/org/hudson/trayapp/gui/icons/tray/red_anime.gif"));
	private final static Image RED = Toolkit.getDefaultToolkit().getImage(Tray.class.getResource("/org/hudson/trayapp/gui/icons/tray/red.gif"));
	private final static Image YELLOW_ANIME = Toolkit.getDefaultToolkit().getImage(Tray.class.getResource("/org/hudson/trayapp/gui/icons/tray/yellow_anime.gif"));
	private final static Image YELLOW = Toolkit.getDefaultToolkit().getImage(Tray.class.getResource("/org/hudson/trayapp/gui/icons/tray/yellow.gif"));
	
	private final static Map<String, Image> COLOURSTOICONS = new HashMap<String, Image>(8);
	static {
		COLOURSTOICONS.put(Job.getColour(Job.BLUE), BLUE);
		COLOURSTOICONS.put(Job.getColour(Job.BLUE_ANIME), BLUE_ANIME);
		COLOURSTOICONS.put(Job.getColour(Job.GREY), GREY);
//		COLOURSTOICONS.put(Job.getColour(Job.GREY_ANIME), GREY_ANIME);
		COLOURSTOICONS.put(Job.getColour(Job.RED), RED);
		COLOURSTOICONS.put(Job.getColour(Job.RED_ANIME), RED_ANIME);
		COLOURSTOICONS.put(Job.getColour(Job.YELLOW), YELLOW);
		COLOURSTOICONS.put(Job.getColour(Job.YELLOW_ANIME), YELLOW_ANIME);
		
	}
	public Tray() {
		if (SystemTray.isSupported()) {
			tray = SystemTray.getSystemTray();
			Image image;
			image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/org/hudson/trayapp/gui/icons/tray/hudson.png"));
			MouseListener mouseListener = new MouseListener() {

		        public void mouseClicked(MouseEvent e) {
		            System.out.println("Tray Icon - Mouse clicked!");
		        }

		        public void mouseEntered(MouseEvent e) {
		            System.out.println("Tray Icon - Mouse entered!");
		        }

		        public void mouseExited(MouseEvent e) {
		            System.out.println("Tray Icon - Mouse exited!");
		        }

		        public void mousePressed(MouseEvent e) {
		            System.out.println("Tray Icon - Mouse pressed!");
		        }

		        public void mouseReleased(MouseEvent e) {
		            System.out.println("Tray Icon - Mouse released!");
		        }
		    };

		    trayIcon = new TrayIcon(image);
		    setToolTip("");
		    rebuildPopupMenu(new Vector<Job>(0));

		    ActionListener actionListener = new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		        	showMainWindow();
//		            trayIcon.displayMessage("Action Event",
//		                "An Action Event Has Been Performed!",
//		                TrayIcon.MessageType.INFO);
		        }
		    };

		    trayIcon.setImageAutoSize(true);
		    trayIcon.addActionListener(actionListener);
		    trayIcon.addMouseListener(mouseListener);

		    try {
		    	tray.add(trayIcon);
		    } catch (AWTException e) {
		        System.err.println("TrayIcon could not be added.");
		    }
		} else {
			trayIcon = null;
			tray = null;
		}
	}

	public void showMainWindow() {
		MainFrame.getMainFrameInstance().setVisible(true);
	}

	public void setWorstCaseColour(String colour) {
		//trayIcon.setImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/org/hudson/trayapp/gui/icons/16x16/" + colour + ".gif")));
		trayIcon.setImage(COLOURSTOICONS.get(colour));
	}
	
	public void showMessage(String caption, String message, MessageType type) {
		trayIcon.displayMessage(caption, message, type);
	}
	
	public void setToolTip(String tooltip) {
		trayIcon.setToolTip("Hudson Tray Application\n" + tooltip);
	}
	
	public void rebuildPopupMenu(List<Job> jobs) {
		PopupMenu popup = new PopupMenu();
		if (jobs.size() > 0) {
			for (int i = 0; i < jobs.size(); i++) {
				Job job = jobs.get(i);
				ActionListener jobPopupListener = new ActionListener() {
					private Job jobLink = null;
					public ActionListener prepare(final Job job) {
						jobLink = job;
						return this;
					}
					public void actionPerformed(ActionEvent e) {
						try{
							Desktop.getDesktop().browse(new URI(jobLink.getRFC2396CompliantURL()));
						} catch (URISyntaxException er) {
							showMessage("Could not launch web page", "Tried to launch:\n" + jobLink.getUrl() + "\n" + er.getLocalizedMessage(), TrayIcon.MessageType.ERROR);
						} catch (IOException er) {
							showMessage("Could not launch web page", "Tried to launch:\n" + jobLink.getUrl() + "\n" + er.getLocalizedMessage(), TrayIcon.MessageType.ERROR);
						}
					}
				}.prepare(job);
				MenuItem jobMenuItem = new MenuItem(job.getName());
				jobMenuItem.addActionListener(jobPopupListener);
				popup.add(jobMenuItem);
			}
			popup.addSeparator();
		}
	    
	    ActionListener exitListener = new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	HudsonTrayApp.getHudsonTrayAppInstance().write();
	            System.out.println("Exiting...");
	            System.exit(0);
	        }
	    };

	    ActionListener openFrameListener = new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		showMainWindow();
	    	}
	    };
	    
	    ActionListener updatedListener = new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		HudsonTrayApp.getHudsonTrayAppInstance().update();
	    	}
	    };

	    MenuItem openFrameItem = new MenuItem("Open Application");
	    openFrameItem.addActionListener(openFrameListener);
	    popup.add(openFrameItem);

	    MenuItem updateItem = new MenuItem("Fetch Update");
	    updateItem.addActionListener(updatedListener);
	    popup.add(updateItem);

	    MenuItem defaultItem = new MenuItem("Exit");
	    defaultItem.addActionListener(exitListener);
	    popup.add(defaultItem);
	    
	    trayIcon.setPopupMenu(popup);
	}
}
