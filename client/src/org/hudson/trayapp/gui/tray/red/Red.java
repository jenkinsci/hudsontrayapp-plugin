package org.hudson.trayapp.gui.tray.red;

import java.awt.TrayIcon;

import org.hudson.trayapp.gui.tray.HudsonTrayIconHelper;
import org.hudson.trayapp.gui.tray.Images;
import org.hudson.trayapp.gui.tray.HudsonTrayIconHelper.StaticImage;

public class Red extends StaticImage{

	public Red(TrayIcon trayIcon) {
		super(Images.RED, trayIcon);
	}
}
