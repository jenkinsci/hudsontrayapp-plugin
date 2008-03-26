package org.hudson.trayapp.gui.tray.grey;

import java.awt.TrayIcon;
import java.awt.image.BufferedImage;

import org.hudson.trayapp.gui.tray.HudsonTrayIconHelper;
import org.hudson.trayapp.gui.tray.Images;
import org.hudson.trayapp.gui.tray.HudsonTrayIconHelper.AnimatedImage;

public class GreyAnime80Plus extends AnimatedImage{
	public GreyAnime80Plus(TrayIcon trayIcon) {
		super(Images.GREY, Images.H80PL, trayIcon);
	}
}
