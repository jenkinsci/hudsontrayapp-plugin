package org.hudson.trayapp.gui.tray.blue;

import java.awt.TrayIcon;

import org.hudson.trayapp.gui.tray.HudsonTrayIconHelper;
import org.hudson.trayapp.gui.tray.Images;
import org.hudson.trayapp.gui.tray.HudsonTrayIconHelper.StaticImage;

public class Blue extends StaticImage{

	public Blue(TrayIcon trayIcon) {
		super(Images.BLUE, trayIcon);
	}
}
