package org.hudson.trayapp.gui.tray.yellow;

import java.awt.TrayIcon;

import org.hudson.trayapp.gui.tray.HudsonTrayIconHelper;
import org.hudson.trayapp.gui.tray.Images;
import org.hudson.trayapp.gui.tray.HudsonTrayIconHelper.StaticImage;

public class Yellow extends StaticImage{

	public Yellow(TrayIcon trayIcon) {
		super(Images.YELLOW, trayIcon);
	}
}
