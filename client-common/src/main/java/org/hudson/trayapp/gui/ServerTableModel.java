package org.hudson.trayapp.gui;

import java.util.Iterator;

import javax.swing.table.AbstractTableModel;

import org.hudson.trayapp.model.Job;
import org.hudson.trayapp.model.Server;

public class ServerTableModel extends AbstractTableModel {

	private Server server = null;
	
	public ServerTableModel(Server server) {
		this.server = server;
	}
	
	public void setServer(Server server) {
		this.server = server;
		fireTableStructureChanged();
	}
	
	/**
	 * The columns will be Colour, Name, URL
	 * @return
	 */
	public int getColumnCount() {
		return 4;
	}

	/**
	 * The total number of jobs
	 * @return
	 */
	public int getRowCount() {
		return server.getJobs().size();
	}

	/**
	 * The columns will be Colour, Name, URL
	 */
	public Object getValueAt(int row, int column) {
		Iterator iterJob = server.getJobs().iterator();
		Job job = null;
		int i = 0;
		while(iterJob.hasNext()) {
			job = (Job) iterJob.next();
			if (i == row) {
				break;
			} else {
				job = null;
			}
			i++;
		}
		// The job will be null always, except where we have found the correct row
		if (job == null)
			return null;
		
		switch(column) {
		case 0:
			return job.getColour();
		case 1:
			return new Integer(job.getWorstHealthScore());

		case 2:
			return job.getName();

		case 3:
			return job.getUrl();
		default:
			return null;
		}
	}

	public Class getColumnClass(int columnIndex) {
		switch(columnIndex) {
		case 0:
			return String.class;
		case 1:
			return Integer.class;
		case 2:
			return String.class;
		default:
			return String.class;
		}
	}

	/**
	 * The columns will be Colour, Name, URL
	 */
	public String getColumnName(int column) {
		switch(column) {
		case 0:
			return "";
		case 1:
			return "";
		case 2:
			return "Name";
		default:
			return null;
		}
	}

}
