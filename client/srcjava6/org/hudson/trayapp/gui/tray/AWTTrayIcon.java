package org.hudson.trayapp.gui.tray;

import java.awt.AWTException;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;

import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;

public class AWTTrayIcon extends TrayIconImplementation {

	private TrayIcon trayIcon;
	private TrayIconMouseListenerWithJPopupMenu mouseListener;
	
	public AWTTrayIcon(ImageIcon icon) {
		super(icon);
		trayIcon = new TrayIcon(icon.getImage());
		try {
			SystemTray.getSystemTray().add(trayIcon);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		mouseListener = new TrayIconMouseListenerWithJPopupMenu();
		trayIcon.addMouseListener(mouseListener);
		System.out.println("AWTTrayIcon");
	}
	
	@Override
	public void addActionListener(ActionListener listener) {
		trayIcon.addActionListener(listener);
	}

	@Override
	public void displayMessage(String caption, String message, int type) {
		MessageType messageType = TrayIcon.MessageType.NONE;
		switch (type) {
		case TrayIconImplementation.INFO_MESSAGE_TYPE:
			messageType = TrayIcon.MessageType.INFO;
			break;
		case TrayIconImplementation.WARNING_MESSAGE_TYPE:
			messageType = TrayIcon.MessageType.WARNING;
			break;
		case TrayIconImplementation.ERROR_MESSAGE_TYPE:
			messageType = TrayIcon.MessageType.ERROR;
			break;
		}
		trayIcon.displayMessage(caption, message, messageType);
	}

	@Override
	public void setIcon(ImageIcon icon) {
		trayIcon.setImage(icon.getImage());
	}

	@Override
	public void setIconAutoSize(boolean autoSize) {
		trayIcon.setImageAutoSize(autoSize);
	}

	@Override
	public void setPopupMenu(JPopupMenu popupmenu) {
		mouseListener.popupMenu = popupmenu;
	}

	@Override
	public void setToolTip(String tooltip) {
		trayIcon.setToolTip(tooltip);
	}
	
	public void browse(final URI uri) throws Exception {
		new Thread(new Runnable() {
			public void run() {
				try {
					Desktop.getDesktop().browse(uri);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}, "browse launch thread " + uri.toString()).start();
	}
	
	private class TrayIconMouseListenerWithJPopupMenu implements MouseListener{
		
		private JPopupMenu popupMenu = null;

		@Override
		public void mouseClicked(MouseEvent e) { }

		@Override
		public void mouseEntered(MouseEvent e) { }

		@Override
		public void mouseExited(MouseEvent e) { }

		@Override
		public void mousePressed(MouseEvent e) {
			if (e.isPopupTrigger() && popupMenu != null) {
				popupMenu.setLocation(e.getX(), e.getY());
				popupMenu.setInvoker(popupMenu);
				popupMenu.setVisible(true);
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if (e.isPopupTrigger() && popupMenu != null) {
				popupMenu.setLocation(e.getX(), e.getY());
				popupMenu.setInvoker(popupMenu);
				popupMenu.setVisible(true);
			}
		}
	}
}
