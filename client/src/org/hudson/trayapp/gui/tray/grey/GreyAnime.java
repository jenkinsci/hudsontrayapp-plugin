package org.hudson.trayapp.gui.tray.grey;

import java.awt.TrayIcon;
import java.awt.image.BufferedImage;

import org.hudson.trayapp.gui.tray.HudsonTrayIconHelper;
import org.hudson.trayapp.gui.tray.Images;
import org.hudson.trayapp.gui.tray.HudsonTrayIconHelper.AnimatedImage;

public class GreyAnime extends AnimatedImage{
	public GreyAnime(TrayIcon trayIcon) {
		super(Images.GREY, trayIcon);
	}
}
