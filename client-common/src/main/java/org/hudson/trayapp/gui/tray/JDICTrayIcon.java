package org.hudson.trayapp.gui.tray;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;

import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;

import org.jdesktop.jdic.desktop.Desktop;
import org.jdesktop.jdic.desktop.DesktopException;
import org.jdesktop.jdic.tray.SystemTray;
import org.jdesktop.jdic.tray.TrayIcon;

public class JDICTrayIcon extends TrayIconImplementation {
	
	private TrayIcon trayIcon;
	
	public JDICTrayIcon(ImageIcon icon) {
		super(icon);
		trayIcon = new TrayIcon(icon);
		SystemTray.getDefaultSystemTray().addTrayIcon(trayIcon);
		System.out.println("JDICTrayIcon");
	}

	public void addActionListener(ActionListener listener) {
		trayIcon.addActionListener(listener);
	}

	public void displayMessage(String caption, String message, int type) {
		int messageType = 0;
		switch (type) {
		case TrayIconImplementation.INFO_MESSAGE_TYPE:
			messageType = TrayIcon.INFO_MESSAGE_TYPE;
			break;
		case TrayIconImplementation.WARNING_MESSAGE_TYPE:
			messageType = TrayIcon.WARNING_MESSAGE_TYPE;
			break;
		case TrayIconImplementation.ERROR_MESSAGE_TYPE:
			messageType = TrayIcon.ERROR_MESSAGE_TYPE;
			break;
		}
		trayIcon.displayMessage(caption, message, messageType);
	}

	public void setIcon(ImageIcon icon) {
		trayIcon.setIcon(icon);
	}

	public void setIconAutoSize(boolean autoSize) {
		trayIcon.setIconAutoSize(autoSize);
	}

	public void setPopupMenu(JPopupMenu popupmenu) {
		trayIcon.setPopupMenu(popupmenu);
	}

	public void setToolTip(String tooltip) {
		trayIcon.setToolTip(tooltip);
	}
	public void browse(final URI uri) throws Exception {
		new Thread(new Runnable() {
			public void run() {
				try {
					Desktop.browse(uri.toURL());
				} catch (DesktopException e) {
					TrayIconImplementation.displayException("Browse Exception", "Couldn't launch " + uri.toString(), e);
				} catch (MalformedURLException e) {
					TrayIconImplementation.displayException("Browse Exception", "Couldn't launch " + uri.toString(), e);
				}
			}
		}, "browse launch thread " + uri.toString()).start();
	}
}
