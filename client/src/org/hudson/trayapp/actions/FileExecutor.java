package org.hudson.trayapp.actions;

import java.awt.TrayIcon;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import org.hudson.trayapp.HudsonTrayApp;
import org.hudson.trayapp.model.Job;
import org.iharder.Base64;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FileExecutor implements Action {

	private String fileToExecute = "";

	public void fireAction(Integer colourFrom, Integer colourTo, Integer buildChanged) {
		if (fileToExecute != null && fileToExecute.length() > 0) {
			try {
				Runtime.getRuntime().exec(fileToExecute);
			} catch (Exception e) {
				String buildChangedText = buildChanged.intValue() == Job.BUILD_CHANGED.intValue() ? "Build Changed" : "Build Unchanged";
				HudsonTrayApp.getHudsonTrayAppInstance().getTray().showMessage("Error running file", "FileExecutor Action:\n"
						+ Job.getColour(colourFrom) + "->" + Job.getColour(colourTo) + ":" + buildChangedText + "\n"
						+ fileToExecute + "\n"
						+ "Exception thrown when running this file:\n"
						+ e.getLocalizedMessage(),
						TrayIcon.MessageType.ERROR
				);
			}
		}
	}
	
	public void setFileToExecute(String fileToExecute) {
		this.fileToExecute = fileToExecute;
	}
	public String getFileToExecute() {
		return fileToExecute;
	}

	public boolean equals(Object other) {
		if (other instanceof FileExecutor) {
			FileExecutor otherExecutor = (FileExecutor) other;
			return fileToExecute.equals(otherExecutor.fileToExecute);
		}
		return false;
	}

	public void writeXML(Writer w) throws IOException {
		w.write("<fileToExecute>");
		w.write("<file>"); w.write(Base64.encodeBytes(fileToExecute.getBytes("UTF-8"))); w.write("</file>");
		w.write("</fileToExecute>");
	}

	public void process(NodeList nodes) {
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			String name = node.getNodeName();
			String value = node.getTextContent();
			if (name.equals("fileToExecute")) {
				process(node.getChildNodes());
			} else if (name.equals("file")) {
				try {
					fileToExecute = new String(Base64.decode(value), "UTF-8");
				} catch (UnsupportedEncodingException e) {
					System.err.println(e.getLocalizedMessage());
				}
			}
		}
	}
}
