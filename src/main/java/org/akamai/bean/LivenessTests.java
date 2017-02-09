package org.akamai.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LivenessTests {
	
	private boolean disableNonstandardPortWarning;
	private String hostHeader;
	private boolean httpError3xx;
	private boolean httpError4xx;
	private boolean httpError5xx;
	private String name;
	private String requestString;
	private String responseString;
	private int testInterval;
	private String testObject;
	private int testObjectPort;
	private String testObjectProtocol;
	private String testObjectUsername;
	private String testObjectPassword;
	private int testTimeout;
	private String sslClientCertificate;
	private String sslClientPrivateKey;
	public boolean isDisableNonstandardPortWarning() {
		return disableNonstandardPortWarning;
	}
	public void setDisableNonstandardPortWarning(boolean disableNonstandardPortWarning) {
		this.disableNonstandardPortWarning = disableNonstandardPortWarning;
	}
	public String getHostHeader() {
		return hostHeader;
	}
	public void setHostHeader(String hostHeader) {
		this.hostHeader = hostHeader;
	}
	public boolean isHttpError3xx() {
		return httpError3xx;
	}
	public void setHttpError3xx(boolean httpError3xx) {
		this.httpError3xx = httpError3xx;
	}
	public boolean isHttpError4xx() {
		return httpError4xx;
	}
	public void setHttpError4xx(boolean httpError4xx) {
		this.httpError4xx = httpError4xx;
	}
	public boolean isHttpError5xx() {
		return httpError5xx;
	}
	public void setHttpError5xx(boolean httpError5xx) {
		this.httpError5xx = httpError5xx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRequestString() {
		return requestString;
	}
	public void setRequestString(String requestString) {
		this.requestString = requestString;
	}
	public String getResponseString() {
		return responseString;
	}
	public void setResponseString(String responseString) {
		this.responseString = responseString;
	}
	public int getTestInterval() {
		return testInterval;
	}
	public void setTestInterval(int testInterval) {
		this.testInterval = testInterval;
	}
	public String getTestObject() {
		return testObject;
	}
	public void setTestObject(String testObject) {
		this.testObject = testObject;
	}
	public int getTestObjectPort() {
		return testObjectPort;
	}
	public void setTestObjectPort(int testObjectPort) {
		this.testObjectPort = testObjectPort;
	}
	public String getTestObjectProtocol() {
		return testObjectProtocol;
	}
	public void setTestObjectProtocol(String testObjectProtocol) {
		this.testObjectProtocol = testObjectProtocol;
	}
	public String getTestObjectUsername() {
		return testObjectUsername;
	}
	public void setTestObjectUsername(String testObjectUsername) {
		this.testObjectUsername = testObjectUsername;
	}
	public String getTestObjectPassword() {
		return testObjectPassword;
	}
	public void setTestObjectPassword(String testObjectPassword) {
		this.testObjectPassword = testObjectPassword;
	}
	public int getTestTimeout() {
		return testTimeout;
	}
	public void setTestTimeout(int testTimeout) {
		this.testTimeout = testTimeout;
	}
	public String getSslClientCertificate() {
		return sslClientCertificate;
	}
	public void setSslClientCertificate(String sslClientCertificate) {
		this.sslClientCertificate = sslClientCertificate;
	}
	public String getSslClientPrivateKey() {
		return sslClientPrivateKey;
	}
	public void setSslClientPrivateKey(String sslClientPrivateKey) {
		this.sslClientPrivateKey = sslClientPrivateKey;
	}
	
	
}