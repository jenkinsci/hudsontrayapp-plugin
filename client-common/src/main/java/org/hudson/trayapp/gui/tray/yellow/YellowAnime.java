package org.hudson.trayapp.gui.tray.yellow;

import org.hudson.trayapp.gui.tray.Images;
import org.hudson.trayapp.gui.tray.TrayIconImplementation;
import org.hudson.trayapp.gui.tray.HudsonTrayIconHelper.AnimatedImage;

public class YellowAnime extends AnimatedImage{
	public YellowAnime(TrayIconImplementation trayIcon) {
		super(Images.YELLOW, trayIcon);
	}
}
