package org.hudson.trayapp.gui.tray.red;

import java.awt.TrayIcon;

import org.hudson.trayapp.gui.tray.HudsonTrayIconHelper;
import org.hudson.trayapp.gui.tray.Images;
import org.hudson.trayapp.gui.tray.HudsonTrayIconHelper.StaticImage;

public class Red80Plus extends StaticImage{
	
	public Red80Plus(TrayIcon trayIcon) {
		super(Images.RED, Images.H80PL, trayIcon);
	}
}
