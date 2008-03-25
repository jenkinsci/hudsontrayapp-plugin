package org.hudson.trayapp.model.job;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Build {
	private int number;
	private String url;
	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	public static Build process(Node node) {
		Build build = new Build();
		build.process(node.getChildNodes());
		return build;
	}

	private void process(NodeList nodes) {
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			String name = node.getNodeName();
			String value = node.getTextContent();
			if (name.equals("url")) {
				url = value;
			} else if (name.equals("number")) {
				number = Integer.parseInt(value);
			}
		}
	}
	
	public Build clone() {
		Build build = new Build();
		build.number = number;
		build.url = url;
		return build;
	}
}
