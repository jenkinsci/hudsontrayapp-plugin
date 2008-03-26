package org.hudson.trayapp.gui.tray.yellow;

import java.awt.TrayIcon;
import java.awt.image.BufferedImage;

import org.hudson.trayapp.gui.tray.HudsonTrayIconHelper;
import org.hudson.trayapp.gui.tray.Images;
import org.hudson.trayapp.gui.tray.HudsonTrayIconHelper.AnimatedImage;

public class YellowAnime80Plus extends AnimatedImage{
	public YellowAnime80Plus(TrayIcon trayIcon) {
		super(Images.YELLOW, Images.H80PL, trayIcon);
	}
}
