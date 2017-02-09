/**
 * 
 */
package org.akamai.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author bkaur2
 *
 */
@Component
@ConfigurationProperties(prefix="org.ops4_0.constants")
public class Configurations {

	private String port;
	private String host;
	private String akamaiCreds;
	private String akamaiStageCs;
	private String akamaiStageCommerceApi;
	private String akamaiStageStore;
	private String akamaiStageAsset2;
	private String akamaiStageAsset1;
	private String akamaiStage;
	private String akamaiCheckCs;
	private String akamaiCheckCommerceApi;
	private String akamaiCheckStore;
	private String akamaiCheckAsset2;
	private String akamaiCheckAsset1;
	private String akamaiCheck;
	private String akamaiCs;
	private String akamaiCommerceApi;
	private String akamaiStore;
	private String akamaiAsset2;
	private String akamaiAsset1;
	private String akamaiWww;
	private String akamaiShopSearch;
	private String StagetargetServerCsH5;
	private String StagetargetServerCsH8;
	private String StagetargetServerStoreH5;
	private String StagetargetServerStoreH8;
	private String StagetargetServerStageH5;
	private String StagetargetServerStageH8;
	private String StagetargetServerCommerceApiH5;
	private String StagetargetServerCommerceApiH8;
	private String StagetargetServerAsset2H5;
	private String StagetargetServerAsset2H8;
	private String StagetargetServerAsset1H5;
	private String StagetargetServerAsset1H8;
	
	private String TargetServerCsH5;
	private String TargetServerCsH8;
	private String TargetServerStoreH5;
	private String TargetServerStoreH8;
	private String TargetServerH5;
	private String TargetServerH8;
	private String TargetServerCommerceApiH5;
	private String TargetServerCommerceApiH8;
	private String TargetServerAsset2H5;
	private String TargetServerAsset2H8;
	private String TargetServerAsset1H5;
	private String TargetServerAsset1H8;
	private String TargetServerShopSearchH5;
	private String TargetServerShopSearchH8;

	public String getStagetargetServerCsH5() {
		return StagetargetServerCsH5;
	}

	public void setStagetargetServerCsH5(String stagetargetServerCsH5) {
		StagetargetServerCsH5 = stagetargetServerCsH5;
	}

	public String getStagetargetServerCsH8() {
		return StagetargetServerCsH8;
	}

	public void setStagetargetServerCsH8(String stagetargetServerCsH8) {
		StagetargetServerCsH8 = stagetargetServerCsH8;
	}

	public String getStagetargetServerStoreH5() {
		return StagetargetServerStoreH5;
	}

	public void setStagetargetServerStoreH5(String stagetargetServerStoreH5) {
		StagetargetServerStoreH5 = stagetargetServerStoreH5;
	}

	public String getStagetargetServerStageH5() {
		return StagetargetServerStageH5;
	}

	public void setStagetargetServerStageH5(String stagetargetServerStageH5) {
		StagetargetServerStageH5 = stagetargetServerStageH5;
	}

	public String getStagetargetServerStageH8() {
		return StagetargetServerStageH8;
	}

	public void setStagetargetServerStageH8(String stagetargetServerStageH8) {
		StagetargetServerStageH8 = stagetargetServerStageH8;
	}

	public String getStagetargetServerCommerceApiH5() {
		return StagetargetServerCommerceApiH5;
	}

	public void setStagetargetServerCommerceApiH5(String stagetargetServerCommerceApiH5) {
		StagetargetServerCommerceApiH5 = stagetargetServerCommerceApiH5;
	}

	public String getStagetargetServerCommerceApiH8() {
		return StagetargetServerCommerceApiH8;
	}

	public void setStagetargetServerCommerceApiH8(String stagetargetServerCommerceApiH8) {
		StagetargetServerCommerceApiH8 = stagetargetServerCommerceApiH8;
	}

	public String getStagetargetServerAsset2H5() {
		return StagetargetServerAsset2H5;
	}

	public void setStagetargetServerAsset2H5(String stagetargetServerAsset2H5) {
		StagetargetServerAsset2H5 = stagetargetServerAsset2H5;
	}

	public String getStagetargetServerAsset2H8() {
		return StagetargetServerAsset2H8;
	}

	public void setStagetargetServerAsset2H8(String stagetargetServerAsset2H8) {
		StagetargetServerAsset2H8 = stagetargetServerAsset2H8;
	}

	public String getStagetargetServerAsset1H5() {
		return StagetargetServerAsset1H5;
	}

	public void setStagetargetServerAsset1H5(String stagetargetServerAsset1H5) {
		StagetargetServerAsset1H5 = stagetargetServerAsset1H5;
	}

	public String getStagetargetServerAsset1H8() {
		return StagetargetServerAsset1H8;
	}

	public void setStagetargetServerAsset1H8(String stagetargetServerAsset1H8) {
		StagetargetServerAsset1H8 = stagetargetServerAsset1H8;
	}

	public void setAkamaiAsset1(String akamaiAsset1) {
	}

	public String getAkamaiCs() {
		return akamaiCs;
	}

	public void setAkamaiCs(String akamaiCs) {
		this.akamaiCs = akamaiCs;
	}

	public String getAkamaiCommerceApi() {
		return akamaiCommerceApi;
	}

	public void setAkamaiCommerceApi(String akamaiCommerceApi) {
		this.akamaiCommerceApi = akamaiCommerceApi;
	}

	public String getAkamaiStore() {
		return akamaiStore;
	}

	public void setAkamaiStore(String akamaiStore) {
		this.akamaiStore = akamaiStore;
	}

	public String getAkamaiAsset2() {
		return akamaiAsset2;
	}

	public void setAkamaiAsset2(String akamaiAsset2) {
		this.akamaiAsset2 = akamaiAsset2;
	}

	public String getAkamaiWww() {
		return akamaiWww;
	}

	public void setAkamaiWww(String akamaiWww) {
		this.akamaiWww = akamaiWww;
	}

	public String getAkamaiStageCs() {
		return akamaiStageCs;
	}

	public void setAkamaiStageCs(String akamaiStageCs) {
		this.akamaiStageCs = akamaiStageCs;
	}

	public String getAkamaiStageCommerceApi() {
		return akamaiStageCommerceApi;
	}

	public void setAkamaiStageCommerceApi(String akamaiStageCommerceApi) {
		this.akamaiStageCommerceApi = akamaiStageCommerceApi;
	}

	public String getAkamaiStageStore() {
		return akamaiStageStore;
	}

	public void setAkamaiStageStore(String akamaiStageStore) {
		this.akamaiStageStore = akamaiStageStore;
	}

	public String getAkamaiStageAsset2() {
		return akamaiStageAsset2;
	}

	public void setAkamaiStageAsset2(String akamaiStageAsset2) {
		this.akamaiStageAsset2 = akamaiStageAsset2;
	}

	public String getAkamaiStageAsset1() {
		return akamaiStageAsset1;
	}

	public void setAkamaiStageAsset1(String akamaiStageAsset1) {
		this.akamaiStageAsset1 = akamaiStageAsset1;
	}

	public String getAkamaiStage() {
		return akamaiStage;
	}

	public void setAkamaiStage(String akamaiStage) {
		this.akamaiStage = akamaiStage;
	}

	

	/**
	 * @return the port
	 */
	public String getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(String port) {
		this.port = port;
	}

	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * @param host the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}


	/**
	 * @return the akamaiCreds
	 */
	public String getAkamaiCreds() {
		return akamaiCreds;
	}

	/**
	 * @param akamaiCreds the akamaiCreds to set
	 */
	public void setAkamaiCreds(String akamaiCreds) {
		this.akamaiCreds = akamaiCreds;
	}

	/**
	 * @return the akamaiShopSearch
	 */
	public String getAkamaiShopSearch() {
		return akamaiShopSearch;
	}

	/**
	 * @param akamaiShopSearch the akamaiShopSearch to set
	 */
	public void setAkamaiShopSearch(String akamaiShopSearch) {
		this.akamaiShopSearch = akamaiShopSearch;
	}

	/**
	 * @return the stagetargetServerStoreH8
	 */
	public String getStagetargetServerStoreH8() {
		return StagetargetServerStoreH8;
	}

	/**
	 * @param stagetargetServerStoreH8 the stagetargetServerStoreH8 to set
	 */
	public void setStagetargetServerStoreH8(String stagetargetServerStoreH8) {
		StagetargetServerStoreH8 = stagetargetServerStoreH8;
	}
	
	/**
	 * @return the akamaiAsset1
	 */
	public String getAkamaiAsset1() {
		return akamaiAsset1;
	}

	/**
	 * @return the akamaiCheckCs
	 */
	public String getAkamaiCheckCs() {
		return akamaiCheckCs;
	}

	/**
	 * @param akamaiCheckCs the akamaiCheckCs to set
	 */
	public void setAkamaiCheckCs(String akamaiCheckCs) {
		this.akamaiCheckCs = akamaiCheckCs;
	}

	/**
	 * @return the akamaiCheckCommerceApi
	 */
	public String getAkamaiCheckCommerceApi() {
		return akamaiCheckCommerceApi;
	}

	/**
	 * @param akamaiCheckCommerceApi the akamaiCheckCommerceApi to set
	 */
	public void setAkamaiCheckCommerceApi(String akamaiCheckCommerceApi) {
		this.akamaiCheckCommerceApi = akamaiCheckCommerceApi;
	}

	/**
	 * @return the akamaiCheckStore
	 */
	public String getAkamaiCheckStore() {
		return akamaiCheckStore;
	}

	/**
	 * @param akamaiCheckStore the akamaiCheckStore to set
	 */
	public void setAkamaiCheckStore(String akamaiCheckStore) {
		this.akamaiCheckStore = akamaiCheckStore;
	}

	/**
	 * @return the akamaiCheckAsset2
	 */
	public String getAkamaiCheckAsset2() {
		return akamaiCheckAsset2;
	}

	/**
	 * @param akamaiCheckAsset2 the akamaiCheckAsset2 to set
	 */
	public void setAkamaiCheckAsset2(String akamaiCheckAsset2) {
		this.akamaiCheckAsset2 = akamaiCheckAsset2;
	}

	/**
	 * @return the akamaiCheckAsset1
	 */
	public String getAkamaiCheckAsset1() {
		return akamaiCheckAsset1;
	}

	/**
	 * @param akamaiCheckAsset1 the akamaiCheckAsset1 to set
	 */
	public void setAkamaiCheckAsset1(String akamaiCheckAsset1) {
		this.akamaiCheckAsset1 = akamaiCheckAsset1;
	}

	/**
	 * @return the akamaiCheck
	 */
	public String getAkamaiCheck() {
		return akamaiCheck;
	}

	/**
	 * @param akamaiCheck the akamaiCheck to set
	 */
	public void setAkamaiCheck(String akamaiCheck) {
		this.akamaiCheck = akamaiCheck;
	}

	/**
	 * @return the targetServerCsH5
	 */
	public String getTargetServerCsH5() {
		return TargetServerCsH5;
	}

	/**
	 * @param targetServerCsH5 the targetServerCsH5 to set
	 */
	public void setTargetServerCsH5(String targetServerCsH5) {
		TargetServerCsH5 = targetServerCsH5;
	}

	/**
	 * @return the targetServerCsH8
	 */
	public String getTargetServerCsH8() {
		return TargetServerCsH8;
	}

	/**
	 * @param targetServerCsH8 the targetServerCsH8 to set
	 */
	public void setTargetServerCsH8(String targetServerCsH8) {
		TargetServerCsH8 = targetServerCsH8;
	}

	/**
	 * @return the targetServerStoreH5
	 */
	public String getTargetServerStoreH5() {
		return TargetServerStoreH5;
	}

	/**
	 * @param targetServerStoreH5 the targetServerStoreH5 to set
	 */
	public void setTargetServerStoreH5(String targetServerStoreH5) {
		TargetServerStoreH5 = targetServerStoreH5;
	}

	/**
	 * @return the targetServerStoreH8
	 */
	public String getTargetServerStoreH8() {
		return TargetServerStoreH8;
	}

	/**
	 * @param targetServerStoreH8 the targetServerStoreH8 to set
	 */
	public void setTargetServerStoreH8(String targetServerStoreH8) {
		TargetServerStoreH8 = targetServerStoreH8;
	}

	/**
	 * @return the targetServerH5
	 */
	public String getTargetServerH5() {
		return TargetServerH5;
	}

	/**
	 * @param targetServerH5 the targetServerH5 to set
	 */
	public void setTargetServerH5(String targetServerH5) {
		TargetServerH5 = targetServerH5;
	}

	/**
	 * @return the targetServerH8
	 */
	public String getTargetServerH8() {
		return TargetServerH8;
	}

	/**
	 * @param targetServerH8 the targetServerH8 to set
	 */
	public void setTargetServerH8(String targetServerH8) {
		TargetServerH8 = targetServerH8;
	}

	/**
	 * @return the targetServerCommerceApiH5
	 */
	public String getTargetServerCommerceApiH5() {
		return TargetServerCommerceApiH5;
	}

	/**
	 * @param targetServerCommerceApiH5 the targetServerCommerceApiH5 to set
	 */
	public void setTargetServerCommerceApiH5(String targetServerCommerceApiH5) {
		TargetServerCommerceApiH5 = targetServerCommerceApiH5;
	}

	/**
	 * @return the targetServerCommerceApiH8
	 */
	public String getTargetServerCommerceApiH8() {
		return TargetServerCommerceApiH8;
	}

	/**
	 * @param targetServerCommerceApiH8 the targetServerCommerceApiH8 to set
	 */
	public void setTargetServerCommerceApiH8(String targetServerCommerceApiH8) {
		TargetServerCommerceApiH8 = targetServerCommerceApiH8;
	}

	/**
	 * @return the targetServerAsset2H5
	 */
	public String getTargetServerAsset2H5() {
		return TargetServerAsset2H5;
	}

	/**
	 * @param targetServerAsset2H5 the targetServerAsset2H5 to set
	 */
	public void setTargetServerAsset2H5(String targetServerAsset2H5) {
		TargetServerAsset2H5 = targetServerAsset2H5;
	}

	/**
	 * @return the targetServerAsset2H8
	 */
	public String getTargetServerAsset2H8() {
		return TargetServerAsset2H8;
	}

	/**
	 * @param targetServerAsset2H8 the targetServerAsset2H8 to set
	 */
	public void setTargetServerAsset2H8(String targetServerAsset2H8) {
		TargetServerAsset2H8 = targetServerAsset2H8;
	}

	/**
	 * @return the targetServerAsset1H5
	 */
	public String getTargetServerAsset1H5() {
		return TargetServerAsset1H5;
	}

	/**
	 * @param targetServerAsset1H5 the targetServerAsset1H5 to set
	 */
	public void setTargetServerAsset1H5(String targetServerAsset1H5) {
		TargetServerAsset1H5 = targetServerAsset1H5;
	}

	/**
	 * @return the targetServerAsset1H8
	 */
	public String getTargetServerAsset1H8() {
		return TargetServerAsset1H8;
	}

	/**
	 * @param targetServerAsset1H8 the targetServerAsset1H8 to set
	 */
	public void setTargetServerAsset1H8(String targetServerAsset1H8) {
		TargetServerAsset1H8 = targetServerAsset1H8;
	}

	/**
	 * @return the targetServerShopSearchH5
	 */
	public String getTargetServerShopSearchH5() {
		return TargetServerShopSearchH5;
	}

	/**
	 * @param targetServerShopSearchH5 the targetServerShopSearchH5 to set
	 */
	public void setTargetServerShopSearchH5(String targetServerShopSearchH5) {
		TargetServerShopSearchH5 = targetServerShopSearchH5;
	}

	/**
	 * @return the targetServerShopSearchH8
	 */
	public String getTargetServerShopSearchH8() {
		return TargetServerShopSearchH8;
	}

	/**
	 * @param targetServerShopSearchH8 the targetServerShopSearchH8 to set
	 */
	public void setTargetServerShopSearchH8(String targetServerShopSearchH8) {
		TargetServerShopSearchH8 = targetServerShopSearchH8;
	}


}
