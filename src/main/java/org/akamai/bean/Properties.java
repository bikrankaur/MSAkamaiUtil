package org.akamai.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Properties {
	
	private String lastModified;
	private String name;
	private List<TrafficTargets> trafficTargets;
	private List<LivenessTests> livenessTests;
	private int dynamicTTL;
	private boolean useComputedTargets;
	private boolean ipv6;
	
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
	/**
	 * @return the dynamicTTL
	 */
	public int getDynamicTTL() {
		return dynamicTTL;
	}
	/**
	 * @param dynamicTTL the dynamicTTL to set
	 */
	public void setDynamicTTL(int dynamicTTL) {
		this.dynamicTTL = dynamicTTL;
	}
	/**
	 * @return the useComputedTargets
	 */
	public boolean isUseComputedTargets() {
		return useComputedTargets;
	}
	/**
	 * @param useComputedTargets the useComputedTargets to set
	 */
	public void setUseComputedTargets(boolean useComputedTargets) {
		this.useComputedTargets = useComputedTargets;
	}
	/**
	 * @return the ipv6
	 */
	public boolean isIpv6() {
		return ipv6;
	}
	/**
	 * @param ipv6 the ipv6 to set
	 */
	public void setIpv6(boolean ipv6) {
		this.ipv6 = ipv6;
	}

	
}