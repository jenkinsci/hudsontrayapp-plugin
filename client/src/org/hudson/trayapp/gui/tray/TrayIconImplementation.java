package org.hudson.trayapp.gui.tray;

import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;

public abstract class TrayIconImplementation {
	
	private static TrayIconImplementation TRAYICON;
	
	public final static int ERROR_MESSAGE_TYPE = 1;
	public final static int WARNING_MESSAGE_TYPE = 2;
	public final static int INFO_MESSAGE_TYPE = 3;

	public TrayIconImplementation(ImageIcon img) {
		TRAYICON = this;
	}
	
	public abstract void setIconAutoSize(boolean autoSize);
	
	public abstract void addActionListener(ActionListener listener);
	
	public abstract void displayMessage(String caption, String message, int type);
	
	public abstract void setToolTip(String tooltip);
	
	public abstract void setPopupMenu(JPopupMenu popupmenu);
	
	public abstract void setIcon(ImageIcon icon);
	
	public abstract void browse(final URI uri) throws Exception;
	
	public static void displayException(String title, String message, Exception e) {
		TRAYICON.displayMessage(title, message + "\nException:" + e.toString(), ERROR_MESSAGE_TYPE);
	}
}
