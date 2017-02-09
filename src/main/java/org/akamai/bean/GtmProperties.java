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

}
