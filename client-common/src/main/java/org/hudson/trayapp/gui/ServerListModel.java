package org.hudson.trayapp.gui;

import javax.swing.AbstractListModel;

import org.hudson.trayapp.model.Model;

public class ServerListModel extends AbstractListModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Model model;
	
	public ServerListModel(Model model) {
		setModel(model);
	}
	
	public void setModel(Model model) {
		this.model = model;
	}

	public Object getElementAt(int index) {
		return model.getServerAt(index).getName();
	}
	
	public int getSize() {
		return model.getServerModelSize();
	}

	public void objectAdded(int index) {
		fireIntervalAdded(this, index, index);
	}
	
	public void objectRemoved(int index) {
		fireIntervalRemoved(this, index, index);
	}
	
	public void objectChanged(int index) {
		fireContentsChanged(this, index, index);
	}
}
