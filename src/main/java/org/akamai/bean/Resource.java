package org.akamai.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Resource {
	
	private String lastModified;
	private String name;
	private List<TrafficTargets> trafficTargets;
	private List<LivenessTests> livenessTests;
	
	/**
	 * @return the lastModified
	 */
	public String getLastModified() {
		return lastModified;
	}
	/**
	 * @param lastModified the lastModified to set
	 */
	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the trafficTargets
	 */
	public List<TrafficTargets> getTrafficTargets() {
		return trafficTargets;
	}
	/**
	 * @param trafficTargets the trafficTargets to set
	 */
	public void setTrafficTargets(List<TrafficTargets> trafficTargets) {
		this.trafficTargets = trafficTargets;
	}
	/**
	 * @return the livenessTests
	 */
	public List<LivenessTests> getLivenessTests() {
		return livenessTests;
	}
	/**
	 * @param livenessTests the livenessTests to set
	 */
	public void setLivenessTests(List<LivenessTests> livenessTests) {
		this.livenessTests = livenessTests;
	}

	
	
}