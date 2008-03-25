package org.hudson.trayapp.model;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.hudson.trayapp.actions.Action;
import org.hudson.trayapp.actions.FileExecutor;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Preferences {
	
	private int updateFrequency = 5;

	private class State {
		Integer colourFrom;
		Integer colourTo;
		Integer build;

		public State(final Integer colourFrom, final Integer colourTo, final Integer build) {
			if (colourFrom == null || colourTo == null || build == null) {
				throw new NullPointerException("Actions can not be created with Null arguments");
			}
			this.colourFrom = colourFrom;
			this.colourTo = colourTo;
			this.build = build;
		}
		
		private State() {}

		public Integer getColourFrom() {
			return colourFrom;
		}

		public Integer getColourTo() {
			return colourTo;
		}

		public Integer getBuild() {
			return build;
		}

		public boolean equals(Object o) {
			if (o instanceof State) {
				State s = (State) o;
				return (
						s.colourFrom == colourFrom &&
						s.colourTo == colourTo &&
						s.build == build);
			}
			return false;
		}

		public int hashCode() {
			return colourFrom.intValue() * 10000 + colourTo.intValue() * 100 + build.intValue();
		}
		
		public void writeXML(Writer w) throws IOException{
			w.write("<state>");
			w.write("<from>"); w.write(Job.getColour(colourFrom)); w.write("</from>");
			w.write("<to>"); w.write(Job.getColour(colourTo)); w.write("</to>");
			w.write("<changed>"); w.write(build.equals(Job.BUILD_CHANGED) ? "Y": "N"); w.write("</changed>");
			Action action = Preferences.this.actions.get(this);
			action.writeXML(w);
			w.write("</state>");
		}
		
		public Action process(NodeList nodes) {
			Action actionReturn = null;
			for (int i = 0; i < nodes.getLength(); i++) {
				Node node = nodes.item(i);
				String name = node.getNodeName();
				String value = node.getTextContent();
				if (name.equals("state")) {
					process(node.getChildNodes());
				} else if (name.equals("from")) {
					colourFrom = Job.convertColour(value);
				} else if (name.equals("to")) {
					colourTo = Job.convertColour(value);
				} else if (name.equals("changed")) {
					if (value.equals("Y"))
						build = Job.BUILD_CHANGED;
					else
						build = Job.BUILD_UNCHANGED;
				} else if (name.equals("fileToExecute")) {
					actionReturn = new FileExecutor();
					actionReturn.process(node.getChildNodes());
				}
			}
			return actionReturn;
		}
	}

	private HashMap<State, Action> actions = new HashMap<State, Action>();

	public void setAction(final Integer colourFrom, final Integer colourTo, final Integer buildChanged, final String actionString) {
		FileExecutor action = new FileExecutor();
		action.setFileToExecute(actionString);
		actions.put(new State(colourFrom, colourTo, buildChanged), action);
	}

	public Action getAction(final Integer colourFrom, final Integer colourTo, final Integer buildChanged) {
		return actions.get(new State(colourFrom, colourTo, buildChanged));
	}

	public Preferences clone() {
		Preferences preferences = new Preferences();
		preferences.actions.putAll(actions);
		return preferences;
	}

	public boolean equals(Object o) {
		if (o instanceof Preferences) {
			Preferences preferences = (Preferences) o;
			Iterator<Map.Entry<State, Action>> iterator = actions.entrySet().iterator();
			boolean bool = true;
			while (bool && iterator.hasNext()) {
				Map.Entry<State, Action> entry = iterator.next();
				Action action = preferences.actions.get(entry.getKey());
				bool = entry.getValue().equals(action);
			}
			/*
			 * We can say that the two preferences are identical if after checking through every
			 * action in this preferences object, we have managed to match it to an action in the other
			 * preferences object, and that the two list of actions are the same size
			 */
			return bool && actions.size() == preferences.actions.size();
		}
		return false;
	}

	public int hashCode() {
		return actions.hashCode();
	}
	
	public void setUpdateFrequency(int frequency) {
		updateFrequency = frequency;
	}
	
	public int getUpdateFrequency() {
		return updateFrequency;
	}
	
	public void writeXML(Writer w) throws IOException {
		w.write("<preferences>");
		w.write("<updateFrequency>"); w.write(Integer.toString(updateFrequency)); w.write("</updateFrequency>");
		Iterator<Map.Entry<State, Action>> iterEntries = actions.entrySet().iterator();
		while (iterEntries.hasNext()) {
			iterEntries.next().getKey().writeXML(w);
		}
		w.write("</preferences>");
	}
	
	public void process(NodeList nodes) {
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			String name = node.getNodeName();
			String value = node.getTextContent();
			if (name.equals("preferences")) {
				process(node.getChildNodes());
			} else if (name.equals("updateFrequency")) {
				updateFrequency = Integer.parseInt(value);
			} else if (name.equals("state")) {
				State state = new State();
				Action action = state.process(node.getChildNodes());
				actions.put(state, action);
			}
		}
	}
}
