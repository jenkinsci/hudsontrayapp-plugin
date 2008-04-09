package org.hudson.trayapp.model;

import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Iterator;
import java.util.Vector;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Model{

	public final static String[] colours = {"red_anime","red","yellow_anime","yellow","blue_anime","blue","disabled_anime","disabled","aborted_anime","aborted"};
	
	private List servers;
	private List previousServers;

	public Model() {
		servers = new Vector();
		previousServers = new Vector();
	}

	public Object clone() {
		Model modelReturn = new Model();
		Iterator iterator = servers.iterator();
		while (iterator.hasNext()) {
			Server server = (Server) iterator.next();
			modelReturn.servers.add(server.clone());
		}
		return modelReturn;
	}

	public int getServerModelSize() {
		return servers.size();
	}

	public Server getServerAt(int index) {
		return (Server) servers.get(index);
	}
	
	public int getServerIndex(String url) {
		return getServerIndex(url, false);
	}
	
	public int getServerIndex(String url, boolean previous) {
		Iterator iterServers;
		if (previous)
			iterServers = previousServers.iterator();
		else
			iterServers = servers.iterator();
		int i = 0;
		while (iterServers.hasNext()) {
			if (url.equals(((Server) iterServers.next()).getURL()))
				return i;
			i++;
		}
		return -1;
	}

	public void addServer(String url, String name) {
		servers.add(new Server(url, name));
	}

	public void removeServer(String url) {
		int index = getServerIndex(url);
		if (index != -1) {
			servers.remove(index);
		}
	}

	public boolean containsServer(String url) {
		return getServerIndex(url) != -1;
	}
	
	public void update() {
		/*
		 * Firstly we need to take a backup of the existing server state. This will
		 * enable us to decide what actions we need to take once we've updated.
		 */
		previousServers.clear();
		Iterator iterServers = servers.iterator();
		while (iterServers.hasNext()) {
			Server server = (Server) iterServers.next();
			previousServers.add(server.clone());
		}
		/*
		 * Now we'll process an update on all the servers
		 */
		iterServers = servers.iterator();
		while (iterServers.hasNext()) {
			Server server = (Server) iterServers.next();
			if (server.getURL().length() > 0) {
				server.update();
			}
		}
	}
	
	/**
	 * This method will pull all of the worst jobs from each server, returning the
	 * worst of the worst jobs overall. I.e. if you have 3 servers, and each server has 1 job
	 * each, and that the 3 jobs in total are blue, yellow, and red, it will return the job
	 * from the server that has the red job.
	 * @param fromPrevious This flag should be set to true, if you want to get the worst jobs
	 * from the previous update, or false if you want the current worst jobs.
	 * @return This returns a collection (never null) of jobs that are the worst jobs overall.
	 */
	public List getWorstJobs(boolean fromPrevious) {
		Vector vecWorst = new Vector();
		int worstCase = -1;
		Iterator serveriter;
		if (fromPrevious) {
			serveriter = previousServers.iterator();
		} else {
			serveriter = servers.iterator();
		}
		while (serveriter.hasNext()) {
			Server server = (Server) serveriter.next();
			String colour = server.getColour();
			// Note, the first time this runs, the previous colour will be null
			if (colour != null) {
				for (int i = 0; worstCase != i && i < Model.colours.length; i++) {
					if (colour.equals(Model.colours[i])) {
						worstCase = i;
						vecWorst.clear();
					}
				}
				if (colour.equals(Model.colours[worstCase])) {
					Job[] jobs = server.getWorstJobs();
					for (int i = 0; i < jobs.length; i++) {
						vecWorst.add(jobs[i]);
					}
				}
			}
		}
		return vecWorst;
	}
	
	public int getWorstJobsWorstHealth() {
		List worstJobs = getWorstJobs(false);
		int health = 101;
		for (int i = 0; i < worstJobs.size(); i++) {
			int jobHealth = ((Job) worstJobs.get(i)).getWorstHealthScore();
			if (jobHealth != -1) {
				health = Math.min(health, jobHealth);
			}
		}
		if (health == 101){
			health = -1;
		}
		return health;
	}
	
	/**
	 * This method will return the worst colour as a string across all of the servers.
	 * @param fromPrevious This flag should be set to true, if you want to get the worst colour
	 * from the previous update, or false if you want the current worst colour.
	 * @return This returns the current/previous worst colour, or "grey" if there are no jobs/servers defined
	 */
	public String getWorstColour(boolean fromPrevious) {
		Collection jobs = getWorstJobs(fromPrevious);
		if (jobs.isEmpty()) {
			return "grey";
		} else {
			return ((Job) jobs.iterator().next()).getColour();
		}
	}
	
	/**
	 * This method will examine the previous and current states, and determine whether or not
	 * the build has changed. It uses a couple of stages to determine this, see the returns
	 * declaration below: 
	 * @return If any servers in the previous list aren't in the new list, this will return true.\n
	 * If any of the current servers aren't in the previous list, this will return true.\n
	 * If any of the previous worst jobs aren't in the new worst jobs list, this will return true.\n
	 * If any of the current previous jobs aren't in the previous worst jobs list, this will return true.\n
	 * If after checking the above, nothing has changed, then it will inspect each job, and check
	 * the build numbers. If any of the build numbers have changed, then this will return true.\n
	 * Otherwise, this will return false
	 */
	public boolean getBuildChanged() {
		//If any servers in the previous list aren't in the new list, this will return true
		Iterator iterServerEntries = previousServers.iterator();
		while (iterServerEntries.hasNext()) {
			if (getServerIndex(((Server) iterServerEntries.next()).getURL(), false) == -1) {
				// We have at least one server that has been removed, return true.
				return true;
			}
		}
		
		//If any of the current servers aren't in the previous list, this will return true.
		iterServerEntries = servers.iterator();
		while (iterServerEntries.hasNext()) {
			if (getServerIndex(((Server) iterServerEntries.next()).getURL(), true) == -1) {
				// We have at least one server that has been added, return true.
				return true;
			}
		}

		// If any of the previous worst jobs aren't in the new worst jobs list, this will return true.
		if (getJobsLeftWorstBuild().size() > 0)
			return true;
		// If any of the current previous jobs aren't in the previous worst jobs list, this will return true.
		if (getJobsJoinedWorstBuild().size() > 0)
			return true;
		/*
		 * If after checking the above, nothing has changed, then it will inspect each job, and check
		 * the build numbers. If any of the build numbers have changed, then this will return true.\n
		*/
		Collection jobsPrevious = getWorstJobs(true);
		Collection jobsCurrent = getWorstJobs(false);
		Map mapPrevious = new HashMap(jobsPrevious.size());
		Iterator iterJobs = jobsPrevious.iterator();
		while (iterJobs.hasNext()) {
			Job job = (Job) iterJobs.next();
			mapPrevious.put(job.getUrl(), job);
		}
		iterJobs = jobsCurrent.iterator();
		while (iterJobs.hasNext()) {
			Job jobCurrent = (Job) iterJobs.next();
			Job jobPrevious = (Job) mapPrevious.get(jobCurrent.getUrl());
			if (jobCurrent.getLastBuild() == null && jobPrevious.getLastBuild() != null) {
				// we have a mismatch between builds, this is a change
				return true;
			} else if (jobCurrent.getLastBuild() != null && jobPrevious.getLastBuild() == null) {
				// we have a mismatch between builds, this is a change
				return true;
			} else if (jobCurrent.getLastBuild() != null && jobPrevious.getLastBuild() != null && jobCurrent.getLastBuild().getNumber() != jobPrevious.getLastBuild().getNumber()) {
				/*
				 * We have at least one job in the worst job list that has changed it's build number
				 * thus we'll return true.
				 */
				return true;
			}
		}
		// Otherwise, this will return false
		return false;
	}
	
	public List getJobsLeftWorstBuild() {
		List lstReturn = new Vector();
		Collection jobsPrevious = getWorstJobs(true);
		Collection jobsCurrent = getWorstJobs(false);
		
		Iterator iterJobs = jobsPrevious.iterator();
		while (iterJobs.hasNext()) {
			Job job = (Job) iterJobs.next();
			if (!(jobsCurrent.contains(job))) {
				lstReturn.add(job);
			}
		}
		return lstReturn;
	}
	
	public List getJobsJoinedWorstBuild() {
		List lstReturn = new Vector();
		Collection jobsPrevious = getWorstJobs(true);
		Collection jobsCurrent = getWorstJobs(false);
		
		// If any of the previous worst jobs aren't in the new worst jobs list, this will return true.
		Iterator iterJobs = jobsCurrent.iterator();
		while (iterJobs.hasNext()) {
			Job job = (Job) iterJobs.next();
			if (!(jobsPrevious.contains(job))) {
				// We have at least one Job that has moved out of the worst job list, return true.
				lstReturn.add(job);
			}
		}
		return lstReturn;
	}
	
	public void writeXML(Writer w) throws IOException {
		w.write("<model>");
		Iterator iterServers = servers.iterator();
		while (iterServers.hasNext()) {
			((Server) iterServers.next()).writeXML(w);
		}
		w.write("</model>");
	}
	
	public void process(NodeList nodes) {
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			String name = node.getNodeName();
			if (name.equals("model")) {
				process(node.getChildNodes());
			} else if (name.equals("server")) {
				Server server = new Server();
				server.process(node.getChildNodes());
				servers.add(server);
			}
		}
	}
	

	
	/**
	 * This method will traverse all of the Jobs, and determine the total
	 * of all of the jobs that share the same colour that you pass in
	 * @param colour The colour you want to get a count for.
	 * @return The total number of jobs that are the same state as the colour provided
	 */
	public int getNumberOfJobsWithColour(String colour) {
		int iReturn = 0;
		Iterator serveriter = servers.iterator();
		while (serveriter.hasNext()) {
			iReturn += ((Server) serveriter.next()).getNumberOfJobsWithColour(colour);
		}
		return iReturn;
	}
	
	/**
	 * This method is provided as a convenience method to determine the total
	 * number of jobs that are currently red (this includes those building).
	 * @return The total number of jobs that are in a Red state (including those building).
	 */
	public int getNumberOfRedJobs() {
		return getNumberOfJobsWithColour("red") + getNumberOfJobsWithColour("red_anime");
	}
	
	/**
	 * This method is provided as a convenience method to determine the total
	 * number of jobs that are currently yellow (this includes those building).
	 * @return The total number of jobs that are in a Yellow state (including those building).
	 */
	public int getNumberOfYellowJobs() {
		return getNumberOfJobsWithColour("yellow") + getNumberOfJobsWithColour("yellow_anime");
	}
	
	/**
	 * This method is provided as a convenience method to determine the total
	 * number of jobs that are currently blue (this includes those building).
	 * @return The total number of jobs that are in a Blue state (including those building).
	 */
	public int getNumberOfBlueJobs() {
		return getNumberOfJobsWithColour("blue") + getNumberOfJobsWithColour("blue_anime");
	}
	
	/**
	 * This method is provided as a convenience method to determine the total
	 * number of jobs that are currently grey.
	 * @return The total number of jobs that are in a grey state.
	 */
	public int getNumberOfGreyJobs() {
		return getNumberOfJobsWithColour("grey");
	}
	
	/**
	 * This method is provided as a convenience method to determine the total
	 * number of jobs that are currently building.
	 * @return The total number of jobs that are building.
	 */
	public int getNumberOfBuildingJobs() {
		return getNumberOfJobsWithColour("red_anime")	+ getNumberOfJobsWithColour("yellow_anime")
		 												+ getNumberOfJobsWithColour("blue_anime");
	}
}
