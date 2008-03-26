package org.hudson.trayapp.gui.tray.yellow;

import java.awt.TrayIcon;

import org.hudson.trayapp.gui.tray.HudsonTrayIconHelper;
import org.hudson.trayapp.gui.tray.Images;
import org.hudson.trayapp.gui.tray.HudsonTrayIconHelper.StaticImage;

public class Yellow80Plus extends StaticImage{

	public Yellow80Plus(TrayIcon trayIcon) {
		super(Images.YELLOW, Images.H80PL, trayIcon);
	}
}
