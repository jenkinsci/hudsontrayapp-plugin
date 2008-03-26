package org.hudson.trayapp.gui.tray.yellow;

import java.awt.TrayIcon;
import java.awt.image.BufferedImage;

import org.hudson.trayapp.gui.tray.HudsonTrayIconHelper;
import org.hudson.trayapp.gui.tray.Images;
import org.hudson.trayapp.gui.tray.HudsonTrayIconHelper.AnimatedImage;

public class YellowAnime extends AnimatedImage{
	public YellowAnime(TrayIcon trayIcon) {
		super(Images.YELLOW, trayIcon);
	}
}
