package org.hudson.trayapp.model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.hudson.trayapp.gui.tray.TrayIconImplementation;
import org.hudson.trayapp.model.job.Build;
import org.hudson.trayapp.model.job.HealthReport;
import org.hudson.trayapp.util.XMLHelper;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Job {

	private static final long serialVersionUID = 1L;

	private String name;
	private String url;
	private Integer colour;
	private Build lastBuild;
	private Build lastFailedBuild;
	private Build lastSuccessfulBuild;

	private List healthReports = new Vector();

	public final static Integer RED = new Integer(1);

	public final static Integer RED_ANIME = new Integer(2);

	public final static Integer YELLOW = new Integer(3);

	public final static Integer YELLOW_ANIME = new Integer(4);

	public final static Integer BLUE = new Integer(5);

	public final static Integer BLUE_ANIME = new Integer(6);

	public final static Integer GREY = new Integer(7);

	public final static Integer BUILD_CHANGED = new Integer(8);

	public final static Integer BUILD_UNCHANGED = new Integer(9);

	private final static Map COLOURSTOSTRING = new HashMap();

	static {
		COLOURSTOSTRING.put(RED, "red");
		COLOURSTOSTRING.put(RED_ANIME, "red_anime");
		COLOURSTOSTRING.put(YELLOW, "yellow");
		COLOURSTOSTRING.put(YELLOW_ANIME, "yellow_anime");
		COLOURSTOSTRING.put(BLUE, "blue");
		COLOURSTOSTRING.put(BLUE_ANIME, "blue_anime");
		COLOURSTOSTRING.put(GREY, "grey");
	}

	public static Job process(Node node) {
		Job job = new Job();
		job.process(node.getChildNodes());
		return job;
	}

	private void process(NodeList nodes) {
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			String name = node.getNodeName();
			String value = XMLHelper.getTextContent(node);
			if (name.equals("name")) {
				this.name = value;
			} else if (name.equals("url")) {
				url = value;
			} else if (name.equals("color")) {
				if (value.equals("disabled")) {
					value = "grey";
				}
				if (value.equals("aborted")) {
					value = "grey";
				}
				if (value.equals("aborted_anime")) {
					value = "grey";
				}
				colour = convertColour(value);
			} else if (name.equals("lastBuild")) {
				lastBuild = Build.process(node);
			} else if (name.equals("lastFailedBuild")) {
				lastFailedBuild = Build.process(node);
			} else if (name.equals("lastSuccessfulBuild")) {
				lastSuccessfulBuild = Build.process(node);
			} else if (name.equals("healthReport")) {
				healthReports.add(HealthReport.process(node));
			}
		}
	}

	public void update() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			InputSource inputSource = new InputSource(url);
			Document document = builder.parse(inputSource);

			healthReports.clear();
			process(document.getChildNodes());

		} catch (ParserConfigurationException e) {
			TrayIconImplementation.displayException("Job Update Exception", "Updating Job " + name, e);
		} catch (IOException e) {
			TrayIconImplementation.displayException("Job Update Exception", "Updating Job " + name, e);
		} catch (SAXException e) {
			TrayIconImplementation.displayException("Job Update Exception", "Updating Job " + name, e);
		}
	}

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}
	
	/**
	 * Note this method is far from complete. Right now it encapsulates " "'s with %20's and that's it.
	 * @return
	 */
	public String getRFC2396CompliantURL() { return getRFC2396CompliantURL(url); }
	public static String getRFC2396CompliantURL(String url) {
		return url.replaceAll(" ", "%20");
	}

	public String getColour() {
		return getColour(colour);
	}

	public static String getColour(Integer colour) {
		return (String) COLOURSTOSTRING.get(colour);
	}

	public Object clone() {
		Job jobReturn = new Job();
		jobReturn.colour = colour;
		jobReturn.name = name;
		jobReturn.url = url;
		if (lastBuild != null)
			jobReturn.lastBuild = (Build) lastBuild.clone();
		if (lastFailedBuild != null)
			jobReturn.lastFailedBuild = (Build) lastFailedBuild.clone();
		if (lastSuccessfulBuild != null)
			jobReturn.lastSuccessfulBuild = (Build) lastSuccessfulBuild.clone();
		Iterator iterReports = healthReports.iterator();
		while (iterReports.hasNext()) {
			jobReturn.healthReports.add(((HealthReport) iterReports.next()).clone());
		}
		return jobReturn;
	}

	public int hashCode() {
		return url.hashCode();
	}

	/**
	 * Note this will only test equality based upon the URL. If you want to test complete equality, you must call equalsState()
	 * @return
	 */
	public boolean equals(Object o) {
		if (o instanceof Job) {
			Job job = (Job) o;
			return url.equals(job.url);
		}
		return false;
	}

//	/**
//	 * Unlike the standard equality test, which in this classes implementation simmply checks upon the URL matching, this
//	 * method will do a full compare. This was chosen so that jobs can be updated in lists simply, but tested against
//	 * each other with relative ease.
//	 * @param job
//	 * @return
//	 */
//	public boolean equals(Job job) {
//		if (job == null) return false;
//		return name.equals(job.name) && colour.equals(job.colour) && url.equals(job.url);
//	}

	/**
	 * This method will take the colour given as a string, and return the underlying Integer representing
	 * it.
	 * @param colour The colour given as a String, as Hudson would report it
	 * @return Either the Integer for the colour, or null if it couldn't be matched.
	 */
	public static Integer convertColour(String colour) {
		Iterator iterator = COLOURSTOSTRING.entrySet().iterator();

		Integer integer = null;
		while (integer == null && iterator.hasNext()) {
			Map.Entry entry = (Map.Entry) iterator.next();
			if (entry.getValue().equals(colour)) {
				integer = (Integer) entry.getKey();
			}
		}

		return integer;
	}

	/**
	 * This method will traverse all of the health reports for this job, and return the worst scoring job. If more than
	 * one healthreport provides the same score, then the list is populated with the multiple health reports suffering
	 * with this score. Note that in order to get the worst score. Note, by design, this method will not return 100%
	 * HealthReports, as this would cause a significant problem in rendering later on.
	 * @return This method will return a list that will either contain no HealthReports, indicating that the job is
	 * 100% healthy, one or many HealthReports, indicating that this job has a worst health score shared by one or
	 * many health reports, or will return null, indicating that this job does not support Health reporting. Typically
	 * this is for Hudson servers prior to build 173.
	 */
	public List getWorstHealth() {
		// The first thing we do is confirm that we even have any reports. If not return null.
		if (healthReports.size() == 0) {
			return null;
		}
		List list = new Vector();
		int score = 100;
		Iterator iterator = healthReports.iterator();
		while (iterator.hasNext()) {
			HealthReport report = (HealthReport) iterator.next();
			/*
			 * First we check to see if the report is equal to our worst case. If so, add the health report to the
			 * returning list.
			 */
			if (report.getScore() == score && report.getScore() != 100) {
				list.add(report);
			} else if (report.getScore() < score) {
				/*
				 * If we have a report score that is lower than what we already have, then we need to clear out
				 * the returning list, add this report to the now empty list, and set the score lower
				 */
				score = report.getScore();
				list.clear();
				list.add(report);
			}
		}
		return list;
	}

	/**
	 * This method will look for the worst health of the job's health reports. Note this method uses the method
	 * getWorstHealth() to identify the HealthReports that are suffering, and then interprets the results as explained
	 * in that methods JavaDoc.
	 * @return
	 */
	public int getWorstHealthScore() {
		List list = getWorstHealth();
		if (list == null) {
			return -1;
		}
		if (list.isEmpty()) {
			return 100;
		}
		// We know that the List must contain something, thus we can confidently call this final method.
		return ((HealthReport) list.get(0)).getScore();
	}

	/**
	 * @return the lastBuild
	 */
	public Build getLastBuild() {
		return lastBuild;
	}

	/**
	 * @return the lastFailedBuild
	 */
	public Build getLastFailedBuild() {
		return lastFailedBuild;
	}

	/**
	 * @return the lastSuccessfulBuild
	 */
	public Build getLastSuccessfulBuild() {
		return lastSuccessfulBuild;
	}
}
