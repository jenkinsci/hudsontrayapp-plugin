package org.hudson.trayapp.gui.tray.grey;

import org.hudson.trayapp.gui.tray.Images;
import org.hudson.trayapp.gui.tray.TrayIconImplementation;
import org.hudson.trayapp.gui.tray.HudsonTrayIconHelper.AnimatedImage;

public class GreyAnime extends AnimatedImage{
	public GreyAnime(TrayIconImplementation trayIcon) {
		super(Images.GREY, trayIcon);
	}
}
