package cn.jpush.api.examples;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jiguang.common.resp.DefaultResult;
import cn.jpush.api.JPushClient;
import cn.jpush.api.device.AliasDeviceListResult;
import cn.jpush.api.device.OnlineStatus;
import cn.jpush.api.device.TagAliasResult;

public class DeviceExample {
	protected static final Logger LOG = LoggerFactory.getLogger(DeviceExample.class);

	private static final String appKey = "bc3e3f625657139c672774fc";
	private static final String masterSecret = "541028d05f453d728595670e";
	private static final String TAG1 = "tag1";
	private static final String ALIAS1 = "868153020188221";
	private static final String REGISTRATION_ID1 = "18071adc03318d49fc4";

	private static JPushClient jpushClient = new JPushClient(masterSecret, appKey);

	public static void main(String[] args) {
		// testGetDeviceTagAlias();
		// testGetUserOnlineStatus();
//		deleteAlias();// 删除别名
//		getAliasDeviceList();
		getDeviceTagAlias();
	}

	public static void testGetDeviceTagAlias() {
		try {
			TagAliasResult result = jpushClient.getDeviceTagAlias(REGISTRATION_ID1);

			LOG.info(result.alias);
			LOG.info(result.tags.toString());

		} catch (APIConnectionException e) {
			LOG.error("Connection error. Should retry later. ", e);

		} catch (APIRequestException e) {
			LOG.error("Error response from JPush server. Should review and fix it. ", e);
			LOG.info("HTTP Status: " + e.getStatus());
			LOG.info("Error Code: " + e.getErrorCode());
			LOG.info("Error Message: " + e.getErrorMessage());
		}
	}

	public static void testGetUserOnlineStatus() {
		try {
			Map<String, OnlineStatus> result = jpushClient.getUserOnlineStatus(REGISTRATION_ID1);

			LOG.info(result.get(REGISTRATION_ID1).toString());
		} catch (APIConnectionException e) {
			LOG.error("Connection error. Should retry later. ", e);
		} catch (APIRequestException e) {
			LOG.error("Error response from JPush server. Should review and fix it. ", e);
			LOG.info("HTTP Status: " + e.getStatus());
			LOG.info("Error Code: " + e.getErrorCode());
			LOG.info("Error Message: " + e.getErrorMessage());
		}
	}

	public static void testBindMobile() {
		try {
			DefaultResult result = jpushClient.bindMobile(REGISTRATION_ID1, "13000000000");
			LOG.info("Got result " + result);
		} catch (APIConnectionException e) {
			LOG.error("Connection error. Should retry later. ", e);
		} catch (APIRequestException e) {
			LOG.error("Error response from JPush server. Should review and fix it. ", e);
			LOG.info("HTTP Status: " + e.getStatus());
			LOG.info("Error Code: " + e.getErrorCode());
			LOG.info("Error Message: " + e.getErrorMessage());
		}
	}

	// 删除别名
	public static void deleteAlias() {
		try {
			DefaultResult result = jpushClient.deleteAlias(ALIAS1, "android");
			LOG.info("Got result " + result);
		} catch (APIConnectionException e) {
			LOG.error("Connection error. Should retry later. ", e);
		} catch (APIRequestException e) {
			LOG.error("Error response from JPush server. Should review and fix it. ", e);
			LOG.info("HTTP Status: " + e.getStatus());
			LOG.info("Error Code: " + e.getErrorCode());
			LOG.info("Error Message: " + e.getErrorMessage());
		}
	}

	// 获取用户别名
	public static void getDeviceTagAlias() {
		try {
			TagAliasResult result = jpushClient.getDeviceTagAlias(REGISTRATION_ID1);
			LOG.info("Got result " + result);
		} catch (APIConnectionException e) {
			LOG.error("Connection error. Should retry later. ", e);
		} catch (APIRequestException e) {
			LOG.error("Error response from JPush server. Should review and fix it. ", e);
			LOG.info("HTTP Status: " + e.getStatus());
			LOG.info("Error Code: " + e.getErrorCode());
			LOG.info("Error Message: " + e.getErrorMessage());
		}
	}
	//
	public static void getAliasDeviceList() {
		try {
			AliasDeviceListResult result = jpushClient.getAliasDeviceList(ALIAS1,"android");
			LOG.info("Got result " + result);
		} catch (APIConnectionException e) {
			LOG.error("Connection error. Should retry later. ", e);
		} catch (APIRequestException e) {
			LOG.error("Error response from JPush server. Should review and fix it. ", e);
			LOG.info("HTTP Status: " + e.getStatus());
			LOG.info("Error Code: " + e.getErrorCode());
			LOG.info("Error Message: " + e.getErrorMessage());
		}
	}
}
