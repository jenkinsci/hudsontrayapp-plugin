package org.hudson.trayapp.gui.tray.grey;

import org.hudson.trayapp.gui.tray.Images;
import org.hudson.trayapp.gui.tray.HudsonTrayIconHelper.AnimatedImage;
import org.jdesktop.jdic.tray.TrayIcon;

public class GreyAnime extends AnimatedImage{
	public GreyAnime(TrayIcon trayIcon) {
		super(Images.GREY, trayIcon);
	}
}
