package org.hudson.trayapp.gui.tray.red;

import org.hudson.trayapp.gui.tray.Images;
import org.hudson.trayapp.gui.tray.HudsonTrayIconHelper.AnimatedImage;
import org.jdesktop.jdic.tray.TrayIcon;

public class RedAnime extends AnimatedImage{
	public RedAnime(TrayIcon trayIcon) {
		super(Images.RED, trayIcon);
	}
}
