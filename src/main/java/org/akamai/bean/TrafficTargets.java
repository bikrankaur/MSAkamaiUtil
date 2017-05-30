package org.akamai.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TrafficTargets {
	
	private int datacenterId;
	private boolean enabled;
	private int weight;
	private String servers[];
	/**
	 * @return the datacenterId
	 */
	public int getDatacenterId() {
		return datacenterId;
	}
	
	/**
	 * @param datacenterId the datacenterId to set
	 */
	public void setDatacenterId(int datacenterId) {
		this.datacenterId = datacenterId;
	}
	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}
	/**
	 * @return the servers
	 */
	public String[] getServers() {
		return servers;
	}
	/**
	 * @param servers the servers to set
	 */
	public void setServers(String[] servers) {
		this.servers = servers;
	}

	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	
}