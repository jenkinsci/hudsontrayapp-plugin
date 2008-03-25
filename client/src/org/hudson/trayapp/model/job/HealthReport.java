package org.hudson.trayapp.model.job;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class HealthReport {

	private int score = -1;
	private String description = "";
	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	public static HealthReport process(Node node) {
		HealthReport report = new HealthReport();
		report.process(node.getChildNodes());
		return report;
	}

	private void process(NodeList nodes) {
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			String name = node.getNodeName();
			String value = node.getTextContent();
			if (name.equals("description")) {
				description = value;
			} else if (name.equals("score")) {
				score = Integer.parseInt(value);
			}
		}
	}

	public HealthReport clone() {
		HealthReport report = new HealthReport();
		report.score = score;
		report.description = description;
		return report;
	}

}
