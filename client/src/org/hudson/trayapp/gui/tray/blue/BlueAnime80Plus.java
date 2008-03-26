package org.hudson.trayapp.gui.tray.blue;

import java.awt.TrayIcon;
import java.awt.image.BufferedImage;

import org.hudson.trayapp.gui.tray.HudsonTrayIconHelper;
import org.hudson.trayapp.gui.tray.Images;
import org.hudson.trayapp.gui.tray.HudsonTrayIconHelper.AnimatedImage;

public class BlueAnime80Plus extends AnimatedImage{
	public BlueAnime80Plus(TrayIcon trayIcon) {
		super(Images.BLUE, Images.H80PL, trayIcon);
	}
}
