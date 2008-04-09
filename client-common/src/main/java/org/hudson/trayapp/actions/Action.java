package org.hudson.trayapp.actions;

import java.io.IOException;
import java.io.Writer;

import org.w3c.dom.NodeList;

public interface Action {
	public abstract void fireAction(Integer colourFrom, Integer colourTo, Integer buildChanged);
	
	public abstract void writeXML(Writer w) throws IOException;
	
	public abstract void process(NodeList nodes);
}
