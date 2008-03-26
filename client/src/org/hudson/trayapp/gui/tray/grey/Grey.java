package org.hudson.trayapp.gui.tray.grey;

import java.awt.TrayIcon;

import org.hudson.trayapp.gui.tray.HudsonTrayIconHelper;
import org.hudson.trayapp.gui.tray.Images;
import org.hudson.trayapp.gui.tray.HudsonTrayIconHelper.StaticImage;

public class Grey extends StaticImage{

	public Grey(TrayIcon trayIcon) {
		super(Images.GREY, trayIcon);
	}
}
