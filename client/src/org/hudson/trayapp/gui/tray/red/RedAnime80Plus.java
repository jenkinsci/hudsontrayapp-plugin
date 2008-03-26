package org.hudson.trayapp.gui.tray.red;

import java.awt.TrayIcon;
import java.awt.image.BufferedImage;

import org.hudson.trayapp.gui.tray.HudsonTrayIconHelper;
import org.hudson.trayapp.gui.tray.Images;
import org.hudson.trayapp.gui.tray.HudsonTrayIconHelper.AnimatedImage;

public class RedAnime80Plus extends AnimatedImage{
	public RedAnime80Plus(TrayIcon trayIcon) {
		super(Images.RED, Images.H80PL, trayIcon);
	}
}
		