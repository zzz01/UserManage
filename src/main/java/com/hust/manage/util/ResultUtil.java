package com.hust.manage.util;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import com.hust.manage.constant.ResultVal;

import net.sf.json.JSONObject;

public class ResultUtil {

	private static final Logger logger = LoggerFactory.getLogger(ResultUtil.class);

	public static Object success(Object result) {
		JSONObject object = new JSONObject();
		object.put("status", HttpStatus.OK);
		object.put("result", result);
		logger.info("status:{},result:{}", HttpStatus.OK, result.toString());
		return object;
	}

	public static Object successWithOutMsg() {
		JSONObject object = new JSONObject();
		object.put("status", HttpStatus.OK);
		logger.info("status:{},result:{}", HttpStatus.OK, StringUtils.EMPTY);
		return null;
	}

	public static Object successWithOutStatus(Object result) {
		JSONObject object = new JSONObject();
		object.put("result", result);
		logger.info("status:{},result:{}", StringUtils.EMPTY, result.toString());
		return object;
	}

	public static Object unknowError() {
		JSONObject object = new JSONObject();
		object.put("status", ResultVal.ERROR_CODE);
		object.put("result", ResultVal.UNKNOW_ERROR);
		logger.info("status:{},result:{}", ResultVal.ERROR_CODE, ResultVal.UNKNOW_ERROR);
		return object;
	}

	public static Object errorWithMsg(Object Msg) {
		JSONObject object = new JSONObject();
		object.put("status", ResultVal.ERROR_CODE);
		object.put("result", Msg);
		logger.info("status:{},result:{}", ResultVal.ERROR_CODE, Msg.toString());
		return null;
	}
}
