package org.akamai.controller;

import java.util.ArrayList;

import org.akamai.bean.AkamaiResponse;
import org.akamai.bean.GtmResponse;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

@RestController
public class GtmDetailsController {
	private static final Logger log = LoggerFactory.getLogger(GtmDetailsController.class);

	@Autowired
	private Configurations configObj;
	
	@Autowired
	private AkamaiHelper akamaiHelper;

	
	@RequestMapping(path="/gtmDetails/{env}")
	public String getGtmDetails(@PathVariable String env) {
		
		String Creds = configObj.getAkamaiCreds();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Basic " + Creds);
		headers.set("Accept", "application/json");
		headers.set("Content-Type", "application/json");

		HttpEntity<String> entity = new HttpEntity<String>(headers);
		String akamaiResponseJson = null;
		RestTemplate restTemplate = new RestTemplate();
		GtmResponse gtm = null;
		GtmResponse gtm1 = null;
		GtmResponse gtm2 = null;
		GtmResponse gtm3 = null;
		GtmResponse gtm4 = null;
		GtmResponse gtm5 = null;
		GtmResponse gtm6 = null;
		if (env.equalsIgnoreCase("stage")) {

			gtm = akamaiHelper.invokeApi(entity, restTemplate, configObj.getAkamaiStageCommerceApi(), HttpMethod.GET);
			gtm1 = akamaiHelper.invokeApi(entity, restTemplate, configObj.getAkamaiStage(), HttpMethod.GET);
			gtm2 = akamaiHelper.invokeApi(entity, restTemplate, configObj.getAkamaiStageAsset1(), HttpMethod.GET);
			gtm3 = akamaiHelper.invokeApi(entity, restTemplate, configObj.getAkamaiStageAsset2(), HttpMethod.GET);
			gtm4 = akamaiHelper.invokeApi(entity, restTemplate, configObj.getAkamaiStageCs(), HttpMethod.GET);
			gtm5 = akamaiHelper.invokeApi(entity, restTemplate, configObj.getAkamaiStageStore(), HttpMethod.GET);
			gtm6 = akamaiHelper.invokeApi(entity, restTemplate, configObj.getAkamaiStageShopSearch(), HttpMethod.GET);

		} else if (env.equalsIgnoreCase("check")) {

			gtm = akamaiHelper.invokeApi(entity, restTemplate, configObj.getAkamaiCheckCommerceApi(), HttpMethod.GET);
			gtm1 = akamaiHelper.invokeApi(entity, restTemplate, configObj.getAkamaiCheck(), HttpMethod.GET);
			gtm2 = akamaiHelper.invokeApi(entity, restTemplate, configObj.getAkamaiCheckAsset1(), HttpMethod.GET);
			gtm3 = akamaiHelper.invokeApi(entity, restTemplate, configObj.getAkamaiCheckAsset2(), HttpMethod.GET);
			gtm4 = akamaiHelper.invokeApi(entity, restTemplate, configObj.getAkamaiCheckCs(), HttpMethod.GET);
			gtm5 = akamaiHelper.invokeApi(entity, restTemplate, configObj.getAkamaiCheckStore(), HttpMethod.GET);

		} else if (env.equalsIgnoreCase("prod")) {
			
			gtm = akamaiHelper.invokeApi(entity, restTemplate, configObj.getAkamaiCommerceApi(), HttpMethod.GET);
			gtm1 = akamaiHelper.invokeApi(entity, restTemplate, configObj.getAkamaiWww(), HttpMethod.GET);
			gtm2 = akamaiHelper.invokeApi(entity, restTemplate, configObj.getAkamaiAsset1(), HttpMethod.GET);
			gtm3 = akamaiHelper.invokeApi(entity, restTemplate, configObj.getAkamaiAsset2(), HttpMethod.GET);
			gtm4 = akamaiHelper.invokeApi(entity, restTemplate, configObj.getAkamaiCs(), HttpMethod.GET);
			gtm5 = akamaiHelper.invokeApi(entity, restTemplate, configObj.getAkamaiStore(), HttpMethod.GET);
			gtm6 = akamaiHelper.invokeApi(entity, restTemplate, configObj.getAkamaiShopSearch(), HttpMethod.GET);
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
		Gson gson = new Gson();
		log.info("Response JSON for gtm: " + gson.toJson(akamaiResponse));
		akamaiResponseJson = gson.toJson(akamaiResponse);
		log.info("response - " + akamaiResponse);
		return akamaiResponseJson;

	}


	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}
