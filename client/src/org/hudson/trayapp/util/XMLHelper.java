package org.hudson.trayapp.util;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLHelper {

	public static String getTextContent(Node node) {
		String strReturn = null;
		NodeList nodes = node.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			node = nodes.item(i);
			if (node.getNodeType() == Node.TEXT_NODE) {
				strReturn = node.getNodeValue();
			}
		}
		return strReturn;
	}
}
