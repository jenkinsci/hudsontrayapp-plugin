package org.hudson.trayapp.gui.tray.blue;

import java.awt.TrayIcon;
import java.awt.image.BufferedImage;

import org.hudson.trayapp.gui.tray.HudsonTrayIconHelper;
import org.hudson.trayapp.gui.tray.Images;
import org.hudson.trayapp.gui.tray.HudsonTrayIconHelper.AnimatedImage;

public class BlueAnime extends AnimatedImage{
	public BlueAnime(TrayIcon trayIcon) {
		super(Images.BLUE, trayIcon);
	}
}
