package org.akamai.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GtmProperties {
	private String handoutMode;
	private String scoreAggregationType;
	private List<LivenessTests> livenessTests;
	private List<TrafficTargets> trafficTargets;
	private String type;
	private String name;
	private int dynamicTTL;
	private boolean useComputedTargets;
	private boolean ipv6;
	
	public GtmProperties() {
		super();
	}


	public String getHandoutMode() {
		return handoutMode;
	}



	public void setHandoutMode(String handoutMode) {
		this.handoutMode = handoutMode;
	}



	public String getScoreAggregationType() {
		return scoreAggregationType;
	}



	public void setScoreAggregationType(String scoreAggregationType) {
		this.scoreAggregationType = scoreAggregationType;
	}




	public List<TrafficTargets> getTrafficTargets() {
		return trafficTargets;
	}


	public void setTrafficTargets(List<TrafficTargets> trafficTargets) {
		this.trafficTargets = trafficTargets;
	}


	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}
	


	@Override
	public String toString() {
		return "GTM [handoutMode=" + handoutMode + ", name=" + name + "]";
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
