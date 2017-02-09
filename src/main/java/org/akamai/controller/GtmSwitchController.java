package org.akamai.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import org.akamai.bean.AkamaiResponse;
import org.akamai.bean.GtmProperties;
import org.akamai.bean.GtmResponse;
import org.akamai.bean.LivenessTests;
import org.akamai.bean.TrafficTargets;
import org.akamai.configurations.Configurations;
import org.akamai.helper.AkamaiHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

@RestController
public class GtmSwitchController {
	private static final Logger log = LoggerFactory.getLogger(GtmSwitchController.class);

	@Autowired
	private Configurations configObj;
	
	@Autowired
	private AkamaiHelper akamaiHelper;


	@RequestMapping(path="/setGtmSwitch/{env}", method=RequestMethod.POST)
	public String changeGtm(@PathVariable String env, @RequestParam String domain, @RequestParam String ratio) {
		String plainCreds = configObj.getAkamaiCreds();

		byte[] plainCredsBytes = plainCreds.getBytes();
		byte[] base64CredsBytes = Base64.getEncoder().encode(plainCredsBytes);
		String base64Creds = new String(base64CredsBytes);

		log.info("base64Creds - " + base64Creds);

		MultiValueMap<String, String> headerMap = new LinkedMultiValueMap<String, String>(1);
		headerMap.add("Content-Type", "application/json");
		headerMap.add("Accept", "application/json");
		headerMap.add("Authorization", "Basic " + base64Creds);
		
		GtmProperties properties = new GtmProperties();
		properties.setHandoutMode("normal");
		properties.setScoreAggregationType("worst");

		properties.setType("weighted-round-robin");

		Gson gson = new Gson();

		String akamaiResponseJson = null;
		RestTemplate restTemplate = new RestTemplate();
		GtmResponse gtm = null;
		GtmResponse gtm1 = null;
		GtmResponse gtm2 = null;
		GtmResponse gtm3 = null;
		GtmResponse gtm4 = null;
		GtmResponse gtm5 = null;
		// GtmResponse gtm6 = null;

		final List<LivenessTests> livenessTestsList = new ArrayList<LivenessTests>();
		LivenessTests livenessTests = akamaiHelper.setLivenessTest();
		String[] gtmValue = ratio.split(":");
		List<String> list = Arrays.asList(gtmValue);
		if (env.equalsIgnoreCase("stage")) {
			livenessTests.setHostHeader("www.stage.marksandspencer.com");
			livenessTestsList.add(livenessTests);
			properties.setLivenessTests(livenessTestsList);
			String[] domain1 = domain.split(",");
			for (String api : domain1) {
				if (api.equalsIgnoreCase("commerceapi")) {
					final List<TrafficTargets> trafficList = new ArrayList<TrafficTargets>();
					String serverH5 = configObj.getStagetargetServerCommerceApiH5();
					String serverH8 = configObj.getStagetargetServerCommerceApiH8();
					TrafficTargets trafficTargets = setTrafficTargets(3131, Integer.parseInt(list.get(0)), serverH5);
					TrafficTargets trafficTargets1 = setTrafficTargets(3132, Integer.parseInt(list.get(1)), serverH8);
					trafficList.add(trafficTargets);
					trafficList.add(trafficTargets1);
					properties.setTrafficTargets(trafficList);
					properties.setName("stage.commerce-api");
					String requestBody = gson.toJson(properties);
					HttpEntity<String> entity = new HttpEntity<String>(requestBody, headerMap);
					gtm = akamaiHelper.invokeApi(entity, restTemplate, configObj.getAkamaiStageCommerceApi(),
							HttpMethod.PUT);
				} else if (api.equalsIgnoreCase("cs")) {
					final List<TrafficTargets> trafficList = new ArrayList<TrafficTargets>();
					String serverH5 = configObj.getStagetargetServerCsH5();
					String serverH8 = configObj.getStagetargetServerCsH8();
					TrafficTargets trafficTargets = setTrafficTargets(3131, Integer.parseInt(list.get(0)), serverH5);
					TrafficTargets trafficTargets1 = setTrafficTargets(3132, Integer.parseInt(list.get(1)), serverH8);
					trafficList.add(trafficTargets);
					trafficList.add(trafficTargets1);
					properties.setTrafficTargets(trafficList);
					properties.setName("stage.cs");
					String requestBody = gson.toJson(properties);
					HttpEntity<String> entity = new HttpEntity<String>(requestBody, headerMap);
					gtm1 = akamaiHelper.invokeApi(entity, restTemplate, configObj.getAkamaiStageCs(), HttpMethod.PUT);
				} else if (api.equalsIgnoreCase("store")) {
					final List<TrafficTargets> trafficList = new ArrayList<TrafficTargets>();
					String serverH5 = configObj.getStagetargetServerStoreH5();
					String serverH8 = configObj.getStagetargetServerStoreH8();
					TrafficTargets trafficTargets = setTrafficTargets(3131, Integer.parseInt(list.get(0)), serverH5);
					TrafficTargets trafficTargets1 = setTrafficTargets(3132, Integer.parseInt(list.get(1)), serverH8);
					trafficList.add(trafficTargets);
					trafficList.add(trafficTargets1);
					properties.setTrafficTargets(trafficList);
					properties.setName("stage.store");
					String requestBody = gson.toJson(properties);
					HttpEntity<String> entity = new HttpEntity<String>(requestBody, headerMap);
					gtm2 = akamaiHelper.invokeApi(entity, restTemplate, configObj.getAkamaiStageStore(),
							HttpMethod.PUT);
				} else if (api.equalsIgnoreCase("Asset1")) {
					final List<TrafficTargets> trafficList = new ArrayList<TrafficTargets>();
					String serverH5 = configObj.getStagetargetServerAsset1H5();
					String serverH8 = configObj.getStagetargetServerAsset1H8();
					TrafficTargets trafficTargets = setTrafficTargets(3131, Integer.parseInt(list.get(0)), serverH5);
					TrafficTargets trafficTargets1 = setTrafficTargets(3132, Integer.parseInt(list.get(1)), serverH8);
					trafficList.add(trafficTargets);
					trafficList.add(trafficTargets1);
					properties.setTrafficTargets(trafficList);
					properties.setName("stage.int-asset1");
					String requestBody = gson.toJson(properties);
					HttpEntity<String> entity = new HttpEntity<String>(requestBody, headerMap);
					gtm3 = akamaiHelper.invokeApi(entity, restTemplate, configObj.getAkamaiStageAsset1(),
							HttpMethod.PUT);
				} else if (api.equalsIgnoreCase("Asset2")) {
					final List<TrafficTargets> trafficList = new ArrayList<TrafficTargets>();
					String serverH5 = configObj.getStagetargetServerAsset2H5();
					String serverH8 = configObj.getStagetargetServerAsset2H8();
					TrafficTargets trafficTargets = setTrafficTargets(3131, Integer.parseInt(list.get(0)), serverH5);
					TrafficTargets trafficTargets1 = setTrafficTargets(3132, Integer.parseInt(list.get(1)), serverH8);
					trafficList.add(trafficTargets);
					trafficList.add(trafficTargets1);
					properties.setTrafficTargets(trafficList);
					properties.setName("stage.int-asset2");
					String requestBody = gson.toJson(properties);
					HttpEntity<String> entity = new HttpEntity<String>(requestBody, headerMap);
					gtm4 = akamaiHelper.invokeApi(entity, restTemplate, configObj.getAkamaiStageAsset2(),
							HttpMethod.PUT);
				} else if (api.equalsIgnoreCase("www")) {
					final List<TrafficTargets> trafficList = new ArrayList<TrafficTargets>();
					String serverH5 = configObj.getStagetargetServerStageH5();
					String serverH8 = configObj.getStagetargetServerStageH8();
					TrafficTargets trafficTargets = setTrafficTargets(3131, Integer.parseInt(list.get(0)), serverH5);
					TrafficTargets trafficTargets1 = setTrafficTargets(3132, Integer.parseInt(list.get(1)), serverH8);
					trafficList.add(trafficTargets);
					trafficList.add(trafficTargets1);
					properties.setTrafficTargets(trafficList);
					properties.setName("stage.www");
					String requestBody = gson.toJson(properties);
					HttpEntity<String> entity = new HttpEntity<String>(requestBody, headerMap);
					gtm5 = akamaiHelper.invokeApi(entity, restTemplate, configObj.getAkamaiStage(), HttpMethod.PUT);
				}

			}

		} else if (env.equalsIgnoreCase("prod")) {

			String[] domain1 = domain.split(",");
			for (String api : domain1) {
				if (api.equalsIgnoreCase("commerceapi")) {
					livenessTests.setHostHeader("commerce-api.beta.marksandspencer.com");
					livenessTestsList.add(livenessTests);
					properties.setLivenessTests(livenessTestsList);

					final List<TrafficTargets> trafficList = new ArrayList<TrafficTargets>();
					String serverH5 = configObj.getTargetServerCommerceApiH5();
					String serverH8 = configObj.getTargetServerCommerceApiH8();
					TrafficTargets trafficTargets = setTrafficTargets(3131, Integer.parseInt(list.get(0)), serverH5);
					TrafficTargets trafficTargets1 = setTrafficTargets(3132, Integer.parseInt(list.get(1)), serverH8);
					trafficList.add(trafficTargets);
					trafficList.add(trafficTargets1);
					properties.setTrafficTargets(trafficList);
					properties.setName("commerce-api");

					String requestBody = gson.toJson(properties);
					HttpEntity<String> entity = new HttpEntity<String>(requestBody, headerMap);
					gtm = akamaiHelper.invokeApi(entity, restTemplate, configObj.getAkamaiCommerceApi(),
							HttpMethod.PUT);
				} else if (api.equalsIgnoreCase("cs")) {
					livenessTests.setHostHeader("cs.beta.marksandspencer.com");
					livenessTestsList.add(livenessTests);
					properties.setLivenessTests(livenessTestsList);
					final List<TrafficTargets> trafficList = new ArrayList<TrafficTargets>();
					String serverH5 = configObj.getTargetServerCsH5();
					String serverH8 = configObj.getTargetServerCsH8();
					TrafficTargets trafficTargets = setTrafficTargets(3131, Integer.parseInt(list.get(0)), serverH5);
					TrafficTargets trafficTargets1 = setTrafficTargets(3132, Integer.parseInt(list.get(1)), serverH8);
					trafficList.add(trafficTargets);
					trafficList.add(trafficTargets1);
					properties.setTrafficTargets(trafficList);
					properties.setName("cs");
					String requestBody = gson.toJson(properties);
					HttpEntity<String> entity = new HttpEntity<String>(requestBody, headerMap);
					gtm1 = akamaiHelper.invokeApi(entity, restTemplate, configObj.getAkamaiCs(), HttpMethod.PUT);
				} else if (api.equalsIgnoreCase("store")) {
					livenessTests.setHostHeader("store.beta.marksandspencer.com");
					livenessTestsList.add(livenessTests);
					properties.setLivenessTests(livenessTestsList);

					final List<TrafficTargets> trafficList = new ArrayList<TrafficTargets>();
					String serverH5 = configObj.getTargetServerStoreH5();
					String serverH8 = configObj.getTargetServerStoreH8();
					TrafficTargets trafficTargets = setTrafficTargets(3131, Integer.parseInt(list.get(0)), serverH5);
					TrafficTargets trafficTargets1 = setTrafficTargets(3132, Integer.parseInt(list.get(1)), serverH8);
					trafficList.add(trafficTargets);
					trafficList.add(trafficTargets1);
					properties.setTrafficTargets(trafficList);
					properties.setName("store");
					String requestBody = gson.toJson(properties);
					HttpEntity<String> entity = new HttpEntity<String>(requestBody, headerMap);
					gtm2 = akamaiHelper.invokeApi(entity, restTemplate, configObj.getAkamaiStore(), HttpMethod.PUT);
				} else if (api.equalsIgnoreCase("asset1")) {
					livenessTests.setHostHeader("int-asset1.beta.marksandspencer.com");
					livenessTestsList.add(livenessTests);
					properties.setLivenessTests(livenessTestsList);

					final List<TrafficTargets> trafficList = new ArrayList<TrafficTargets>();
					String serverH5 = configObj.getTargetServerAsset1H5();
					String serverH8 = configObj.getTargetServerAsset1H8();
					TrafficTargets trafficTargets = setTrafficTargets(3131, Integer.parseInt(list.get(0)), serverH5);
					TrafficTargets trafficTargets1 = setTrafficTargets(3132, Integer.parseInt(list.get(1)), serverH8);
					trafficList.add(trafficTargets);
					trafficList.add(trafficTargets1);
					properties.setTrafficTargets(trafficList);
					properties.setName("int-asset1");
					String requestBody = gson.toJson(properties);
					HttpEntity<String> entity = new HttpEntity<String>(requestBody, headerMap);
					gtm3 = akamaiHelper.invokeApi(entity, restTemplate, configObj.getAkamaiAsset1(), HttpMethod.PUT);
				} else if (api.equalsIgnoreCase("asset2")) {
					livenessTests.setHostHeader("int-asset2.beta.marksandspencer.com");
					livenessTestsList.add(livenessTests);
					properties.setLivenessTests(livenessTestsList);

					final List<TrafficTargets> trafficList = new ArrayList<TrafficTargets>();
					String serverH5 = configObj.getTargetServerAsset2H5();
					String serverH8 = configObj.getTargetServerAsset2H8();
					TrafficTargets trafficTargets = setTrafficTargets(3131, Integer.parseInt(list.get(0)), serverH5);
					TrafficTargets trafficTargets1 = setTrafficTargets(3132, Integer.parseInt(list.get(1)), serverH8);
					trafficList.add(trafficTargets);
					trafficList.add(trafficTargets1);
					properties.setTrafficTargets(trafficList);
					properties.setName("int-asset2");
					String requestBody = gson.toJson(properties);
					HttpEntity<String> entity = new HttpEntity<String>(requestBody, headerMap);
					gtm4 = akamaiHelper.invokeApi(entity, restTemplate, configObj.getAkamaiAsset2(), HttpMethod.PUT);
				} else if (api.equalsIgnoreCase("www")) {
					livenessTests.setHostHeader("www.beta.marksandspencer.com");
					livenessTestsList.add(livenessTests);
					properties.setLivenessTests(livenessTestsList);

					final List<TrafficTargets> trafficList = new ArrayList<TrafficTargets>();
					String serverH5 = configObj.getTargetServerH5();
					String serverH8 = configObj.getTargetServerH8();
					TrafficTargets trafficTargets = setTrafficTargets(3131, Integer.parseInt(list.get(0)), serverH5);
					TrafficTargets trafficTargets1 = setTrafficTargets(3132, Integer.parseInt(list.get(1)), serverH8);
					trafficList.add(trafficTargets);
					trafficList.add(trafficTargets1);
					properties.setTrafficTargets(trafficList);
					properties.setName("www");
					String requestBody = gson.toJson(properties);
					HttpEntity<String> entity = new HttpEntity<String>(requestBody, headerMap);
					gtm5 = akamaiHelper.invokeApi(entity, restTemplate, configObj.getAkamaiWww(), HttpMethod.PUT);
				} else if (api.equalsIgnoreCase("shopSearch")) {
					livenessTests.setHostHeader("commerce-api.beta.marksandspencer.com");
					livenessTests.setTestObjectPort(443);
					livenessTestsList.add(livenessTests);
					properties.setLivenessTests(livenessTestsList);

					final List<TrafficTargets> trafficList = new ArrayList<TrafficTargets>();
					String serverH5 = configObj.getTargetServerShopSearchH5();
					String serverH8 = configObj.getTargetServerShopSearchH8();
					TrafficTargets trafficTargets = setTrafficTargets(3131, Integer.parseInt(list.get(0)), serverH5);
					TrafficTargets trafficTargets1 = setTrafficTargets(3132, Integer.parseInt(list.get(1)), serverH8);
					trafficList.add(trafficTargets);
					trafficList.add(trafficTargets1);
					properties.setTrafficTargets(trafficList);
					properties.setName("prod.shopsearch");
					String requestBody = gson.toJson(properties);
					HttpEntity<String> entity = new HttpEntity<String>(requestBody, headerMap);
					gtm5 = akamaiHelper.invokeApi(entity, restTemplate, configObj.getAkamaiShopSearch(),
							HttpMethod.PUT);
				}

			}

		}

		final ArrayList<GtmResponse> GtmResponseList = new ArrayList<GtmResponse>();
		GtmResponseList.add(gtm);
		GtmResponseList.add(gtm1);
		GtmResponseList.add(gtm2);
		GtmResponseList.add(gtm3);
		GtmResponseList.add(gtm4);
		GtmResponseList.add(gtm5);
		AkamaiResponse akamaiResponse = new AkamaiResponse();
		akamaiResponse.setEnviornment(env);
		akamaiResponse.setResponse(GtmResponseList);
		return akamaiResponseJson;

	}



	/**
	 * @param list
	 * @param trafficTargets
	 */
	private TrafficTargets setTrafficTargets(int hall, int weight, String serverValue) {
		TrafficTargets trafficTargets = new TrafficTargets();
		trafficTargets.setDatacenterId(hall);
		trafficTargets.setWeight(weight);
		trafficTargets.setEnabled("true");
		String servers[] = {serverValue};
		trafficTargets.setServers(servers);
		return trafficTargets;
	}


	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}
