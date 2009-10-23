package hudsontrayapp;

import hudson.Extension;
import hudson.model.RootAction;

@Extension
public class TrayAppAction implements RootAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getDisplayName() {
		return "Launch Tray App";
	}

	public String getIconFileName() {
		return "/plugin/hudsontrayapp/images/trayicon.png";
	}

	public String getUrlName() {
		return "plugin/hudsontrayapp/launch";
	}
}
