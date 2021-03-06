package org.akamai.helper;

import org.akamai.bean.GtmResources;
import org.akamai.bean.GtmResponse;
import org.akamai.bean.LivenessTests;
import org.akamai.bean.Properties;
import org.akamai.bean.TrafficTargets;
import org.akamai.configurations.Configurations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AkamaiHelper {
	
	@Autowired
	private Configurations configObj;
	
	public GtmResponse setGtmResponse(ResponseEntity<Properties> response1) {
		GtmResponse gtm = new GtmResponse();
		gtm.setName(response1.getBody().getName());
		gtm.setLastModified(response1.getBody().getLastModified());
		final java.util.List<TrafficTargets> trafficList = response1.getBody().getTrafficTargets();
		for (final TrafficTargets trafficTargets : trafficList) {
			if (trafficTargets.getDatacenterId() == configObj.getDataCenterH5()) {
				gtm.setProd(trafficTargets.getWeight());
			}
			if (trafficTargets.getDatacenterId() == configObj.getDataCenterH8()) {
				gtm.setBurst(trafficTargets.getWeight());
			}

		}

		return gtm;
	}
	
	public GtmResponse setGtmSwitchResponse(ResponseEntity<GtmResources> response1) {
		GtmResponse gtm = new GtmResponse();
		gtm.setName(response1.getBody().getResource().getName());
		gtm.setLastModified(response1.getBody().getResource().getLastModified());
		final java.util.List<TrafficTargets> trafficList = response1.getBody().getResource().getTrafficTargets();
		for (final TrafficTargets trafficTargets : trafficList) {
			if (trafficTargets.getDatacenterId() == configObj.getDataCenterH5()) {
				gtm.setProd(trafficTargets.getWeight());
			}
			if (trafficTargets.getDatacenterId() == configObj.getDataCenterH8()) {
				gtm.setBurst(trafficTargets.getWeight());
			}

		}

		return gtm;
	}
	
	/**
	 * @param entity
	 * @param restTemplate
	 * @return
	 */
	public GtmResponse invokeApi(HttpEntity<String> entity, RestTemplate restTemplate, String url, HttpMethod httpMethod) {
		ResponseEntity<Properties> apiResponse = restTemplate.exchange(url, httpMethod, entity, Properties.class);
		GtmResponse gtm = setGtmResponse(apiResponse);
		return gtm;
		
	}
	
	/**
	 * @param entity
	 * @param restTemplate
	 * @return
	 */
	public GtmResponse invokeApiForGtmChange(HttpEntity<String> entity, RestTemplate restTemplate, String url, HttpMethod httpMethod) {
		ResponseEntity<GtmResources> apiResponse = restTemplate.exchange(url, httpMethod, entity, GtmResources.class);
		GtmResponse gtm = setGtmSwitchResponse(apiResponse);
		return gtm;
		
	}
	
	

	/**
	 * @return
	 */
	public LivenessTests setLivenessTest() {
		LivenessTests livenessTests = new LivenessTests();
		livenessTests.setDisableNonstandardPortWarning(false);
		livenessTests.setHttpError3xx(true);
		livenessTests.setHttpError4xx(true);
		livenessTests.setHttpError5xx(true);
		livenessTests.setName("Liveness Test");
		livenessTests.setRequestString(null);
		livenessTests.setResponseString(null);
		livenessTests.setTestInterval(60);
		livenessTests.setTestObject("/f5hc/gtm_liveness_check.gif");
		livenessTests.setTestObjectPort(80);
		livenessTests.setTestObjectProtocol("HTTP");
		livenessTests.setTestObjectUsername(null);
		livenessTests.setTestObjectPassword(null);
		livenessTests.setTestTimeout(25);
		livenessTests.setSslClientCertificate(null);
		livenessTests.setSslClientPrivateKey(null);
		return livenessTests;
	}


}
