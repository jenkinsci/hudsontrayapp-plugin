package hudsontrayapp;

import hudson.model.Action;

public class TrayAppAction implements Action{
	
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
