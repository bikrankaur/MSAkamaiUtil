package org.akamai.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AkamaiResponse {
	
	private List<GtmResponse> response;
	private String enviornment;
	
	/**
	 * @return the response
	 */
	public List<GtmResponse> getResponse() {
		return response;
	}
	/**
	 * @param response the response to set
	 */
	public void setResponse(List<GtmResponse> response) {
		this.response = response;
	}
	/**
	 * @return the enviornment
	 */
	public String getEnviornment() {
		return enviornment;
	}
	/**
	 * @param name the enviornment to set
	 */
	public void setEnviornment(String enviornment) {
		this.enviornment = enviornment;
	}

	
}