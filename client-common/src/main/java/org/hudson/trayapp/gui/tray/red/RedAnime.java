package org.hudson.trayapp.gui.tray.red;

import org.hudson.trayapp.gui.tray.Images;
import org.hudson.trayapp.gui.tray.TrayIconImplementation;
import org.hudson.trayapp.gui.tray.HudsonTrayIconHelper.AnimatedImage;

public class RedAnime extends AnimatedImage{
	public RedAnime(TrayIconImplementation trayIcon) {
		super(Images.RED, trayIcon);
	}
}
