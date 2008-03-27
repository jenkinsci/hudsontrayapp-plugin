package org.hudson.trayapp.gui.tray.yellow;

import org.hudson.trayapp.gui.tray.Images;
import org.hudson.trayapp.gui.tray.HudsonTrayIconHelper.AnimatedImage;
import org.jdesktop.jdic.tray.TrayIcon;

public class YellowAnime extends AnimatedImage{
	public YellowAnime(TrayIcon trayIcon) {
		super(Images.YELLOW, trayIcon);
	}
}
