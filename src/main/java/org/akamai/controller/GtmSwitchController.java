package org.akamai.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.akamai.bean.AkamaiResponse;
import org.akamai.bean.GtmProperties;
import org.akamai.bean.GtmResponse;
import org.akamai.bean.Properties;
import org.akamai.bean.TrafficTargets;
import org.akamai.configurations.Configurations;
import org.akamai.helper.AkamaiHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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
		
		String Creds = configObj.getAkamaiCreds();

		MultiValueMap<String, String> headerMap = new LinkedMultiValueMap<String, String>(1);
		headerMap.add("Content-Type", "application/json");
		headerMap.add("Accept", "application/json");
		headerMap.add("Authorization", "Basic " + Creds);
		
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
		GtmResponse gtm6 = null;

		String[] gtmValue = ratio.split(":");
		List<String> list = Arrays.asList(gtmValue);
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Basic " + Creds);
		headers.set("Accept", "application/json");
		headers.set("Content-Type", "application/json");

		HttpEntity<String> entity1 = new HttpEntity<String>(headers);
		
		if (env.equalsIgnoreCase("stage")) {
			String[] domain1 = domain.split(",");
			for (String api : domain1) {
				if (api.equalsIgnoreCase("commerceapi")) {
					String requestBody = setRequestBody(properties, gson, restTemplate, list, entity1,configObj.getAkamaiStageCommerceApi());
					HttpEntity<String> entity = new HttpEntity<String>(requestBody, headerMap);
					gtm = akamaiHelper.invokeApiForGtmChange(entity, restTemplate, configObj.getAkamaiStageCommerceApi(),
							HttpMethod.PUT);
				} else if (api.equalsIgnoreCase("cs")) {
					String requestBody = setRequestBody(properties, gson, restTemplate, list, entity1,configObj.getAkamaiStageCs());
					HttpEntity<String> entity = new HttpEntity<String>(requestBody, headerMap);
					gtm1 = akamaiHelper.invokeApiForGtmChange(entity, restTemplate, configObj.getAkamaiStageCs(), HttpMethod.PUT);
				} else if (api.equalsIgnoreCase("store")) {
					String requestBody = setRequestBody(properties, gson, restTemplate, list, entity1,configObj.getAkamaiStageStore());
					HttpEntity<String> entity = new HttpEntity<String>(requestBody, headerMap);
					gtm2 = akamaiHelper.invokeApiForGtmChange(entity, restTemplate, configObj.getAkamaiStageStore(),
							HttpMethod.PUT);
				} else if (api.equalsIgnoreCase("Asset1")) {
					String requestBody = setRequestBody(properties, gson, restTemplate, list, entity1,configObj.getAkamaiStageAsset1());
					HttpEntity<String> entity = new HttpEntity<String>(requestBody, headerMap);
					gtm3 = akamaiHelper.invokeApiForGtmChange(entity, restTemplate, configObj.getAkamaiStageAsset1(),
							HttpMethod.PUT);
				} else if (api.equalsIgnoreCase("Asset2")) {
					String requestBody = setRequestBody(properties, gson, restTemplate, list, entity1,configObj.getAkamaiStageAsset2());
					HttpEntity<String> entity = new HttpEntity<String>(requestBody, headerMap);
					gtm4 = akamaiHelper.invokeApiForGtmChange(entity, restTemplate, configObj.getAkamaiStageAsset2(),
							HttpMethod.PUT);
				} else if (api.equalsIgnoreCase("www")) {
					String requestBody = setRequestBody(properties, gson, restTemplate, list, entity1,configObj.getAkamaiStage());
					HttpEntity<String> entity = new HttpEntity<String>(requestBody, headerMap);
					gtm5 = akamaiHelper.invokeApiForGtmChange(entity, restTemplate, configObj.getAkamaiStage(), HttpMethod.PUT);
				} else if (api.equalsIgnoreCase("shopSearch")) {
					String requestBody = setRequestBody(properties, gson, restTemplate, list, entity1,configObj.getAkamaiStageShopSearch());
					HttpEntity<String> entity = new HttpEntity<String>(requestBody, headerMap);
					gtm6 = akamaiHelper.invokeApiForGtmChange(entity, restTemplate, configObj.getAkamaiStageShopSearch(), HttpMethod.PUT);
				}

			}

		} else if (env.equalsIgnoreCase("prod")) {

			String[] domain1 = domain.split(",");
			for (String api : domain1) {
				if (api.equalsIgnoreCase("commerceapi")) {
					String requestBody = setRequestBody(properties, gson, restTemplate, list, entity1,configObj.getAkamaiCommerceApi());
					HttpEntity<String> entity = new HttpEntity<String>(requestBody, headerMap);
					gtm = akamaiHelper.invokeApiForGtmChange(entity, restTemplate, configObj.getAkamaiCommerceApi(),
							HttpMethod.PUT);
				} else if (api.equalsIgnoreCase("cs")) {
					String requestBody = setRequestBody(properties, gson, restTemplate, list, entity1,configObj.getAkamaiCs());
					HttpEntity<String> entity = new HttpEntity<String>(requestBody, headerMap);
					gtm1 = akamaiHelper.invokeApiForGtmChange(entity, restTemplate, configObj.getAkamaiCs(), HttpMethod.PUT);
				} else if (api.equalsIgnoreCase("store")) {
					String requestBody = setRequestBody(properties, gson, restTemplate, list, entity1,configObj.getAkamaiStore());
					HttpEntity<String> entity = new HttpEntity<String>(requestBody, headerMap);
					gtm2 = akamaiHelper.invokeApiForGtmChange(entity, restTemplate, configObj.getAkamaiStore(),
							HttpMethod.PUT);
				} else if (api.equalsIgnoreCase("asset1")) {
					String requestBody = setRequestBody(properties, gson, restTemplate, list, entity1,configObj.getAkamaiAsset1());
					HttpEntity<String> entity = new HttpEntity<String>(requestBody, headerMap);
					gtm3 = akamaiHelper.invokeApiForGtmChange(entity, restTemplate, configObj.getAkamaiAsset1(),
							HttpMethod.PUT);
				} else if (api.equalsIgnoreCase("asset2")) {
					String requestBody = setRequestBody(properties, gson, restTemplate, list, entity1,configObj.getAkamaiAsset2());
					HttpEntity<String> entity = new HttpEntity<String>(requestBody, headerMap);
					gtm4 = akamaiHelper.invokeApiForGtmChange(entity, restTemplate, configObj.getAkamaiAsset2(),
							HttpMethod.PUT);
				} else if (api.equalsIgnoreCase("www")) {
					String requestBody = setRequestBody(properties, gson, restTemplate, list, entity1,configObj.getAkamaiWww());
					HttpEntity<String> entity = new HttpEntity<String>(requestBody, headerMap);
					gtm5 = akamaiHelper.invokeApiForGtmChange(entity, restTemplate, configObj.getAkamaiWww(), HttpMethod.PUT);
				} else if (api.equalsIgnoreCase("shopSearch")) {
					String requestBody = setRequestBody(properties, gson, restTemplate, list, entity1,configObj.getAkamaiShopSearch());
					HttpEntity<String> entity = new HttpEntity<String>(requestBody, headerMap);
					gtm6 = akamaiHelper.invokeApiForGtmChange(entity, restTemplate, configObj.getAkamaiShopSearch(), HttpMethod.PUT);
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
		GtmResponseList.add(gtm6);
		AkamaiResponse akamaiResponse = new AkamaiResponse();
		akamaiResponse.setEnviornment(env);
		akamaiResponse.setResponse(GtmResponseList);
		Gson gsonResponse = new Gson();
		log.info("Response JSON for gtm: " + gsonResponse.toJson(akamaiResponse));
		akamaiResponseJson = gsonResponse.toJson(akamaiResponse);
		log.info("response - " + akamaiResponse);
		return akamaiResponseJson;

	}



	/**
	 * @param properties
	 * @param gson
	 * @param restTemplate
	 * @param list
	 * @param entity1
	 * @return
	 */
	private String setRequestBody(GtmProperties properties, Gson gson, RestTemplate restTemplate, List<String> list,
			HttpEntity<String> entity1, String url) {
		TrafficTargets trafficTargets1 = null;
		TrafficTargets trafficTargets2 = null;
		ResponseEntity<Properties> apiResponse = restTemplate.exchange(url, HttpMethod.GET, entity1, Properties.class);
		String apiresponse = gson.toJson(apiResponse);
		log.info("apiresponse>>>>>>>>>>>>>"+apiresponse);
		final List<TrafficTargets> trafficTargetList = apiResponse.getBody().getTrafficTargets();
		properties.setLivenessTests(apiResponse.getBody().getLivenessTests());
		for (final TrafficTargets trafficTargets : trafficTargetList) {
			if (trafficTargets.getDatacenterId() == configObj.getDataCenterH5()) {
				String[] Servers = trafficTargets.getServers();
				String serverH5 = Servers[0];
				trafficTargets1 = setTrafficTargets(3131, Integer.parseInt(list.get(0)), serverH5);
			}
			if (trafficTargets.getDatacenterId() == configObj.getDataCenterH8()) {
				String[] Servers = trafficTargets.getServers();
				String serverH8 = Servers[0];
				trafficTargets2 = setTrafficTargets(3132, Integer.parseInt(list.get(1)), serverH8);
			}

		}
		final List<TrafficTargets> trafficList = new ArrayList<TrafficTargets>();
		trafficList.add(trafficTargets1);
		trafficList.add(trafficTargets2);
		properties.setTrafficTargets(trafficList);
		properties.setName(apiResponse.getBody().getName());
		properties.setDynamicTTL(apiResponse.getBody().getDynamicTTL());
		properties.setIpv6(apiResponse.getBody().isIpv6());
		properties.setUseComputedTargets(apiResponse.getBody().isUseComputedTargets());
		String requestBody = gson.toJson(properties);
		log.info("requestBody>>>>>>>>>>"+requestBody);
		return requestBody;
	}



	/**
	 * @param list
	 * @param trafficTargets
	 */
	private TrafficTargets setTrafficTargets(int hall, int weight, String serverValue) {
		TrafficTargets trafficTargets = new TrafficTargets();
		trafficTargets.setDatacenterId(hall);
		trafficTargets.setWeight(weight);
		trafficTargets.setEnabled(true);
		String servers[] = {serverValue};
		trafficTargets.setServers(servers);
		return trafficTargets;
	}


	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}
