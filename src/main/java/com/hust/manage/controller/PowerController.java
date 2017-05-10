package com.hust.manage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hust.manage.model.Power;
import com.hust.manage.service.PowerService;
import com.hust.manage.util.ResultUtil;

@Controller
@RequestMapping("/power")
public class PowerController {

	@Autowired
	private PowerService powerService;

	@ResponseBody
	@RequestMapping("/selectAllPower")
	public Object selectAllPower(@RequestParam(value = "pageStart", required = true) int pageStart,
			@RequestParam(value = "pageLimit", required = true) int pageLimit, HttpServletRequest request) {
		List<Power> powers = powerService.selectAllPower(pageStart, pageLimit);
		if (null == powers || powers.size() == 0) {
			return ResultUtil.errorWithMsg("empty is empty");
		}
		return ResultUtil.success(powers);
	}

	@ResponseBody
	@RequestMapping("/selectPowerByName")
	public Object selectPowerByName(@RequestParam(value = "powerName", required = true) String powerName,
			@RequestParam(value = "pageStart", required = true) int pageStart,
			@RequestParam(value = "pageLimit", required = true) int pageLimit, HttpServletRequest request) {
		List<Power> element = powerService.selectPowerByLikePowerName(powerName);
		if (null == element || element.size() == 0) {
			return ResultUtil.errorWithMsg("power table not have this powerName");
		}
		return ResultUtil.success(element);
	}

	@ResponseBody
	@RequestMapping("/insertPower")
	public Object insertPower(@RequestBody Power power, HttpServletRequest request) {
		boolean status = powerService.insertPower(power);
		if (status == false) {
			return ResultUtil.errorWithMsg("power table have this power");
		}
		return ResultUtil.success("insert data success");
	}

	@ResponseBody
	@RequestMapping("/deletePowerById")
	public Object deletePowerById(@RequestParam(value = "powerId", required = true) int powerId,
			HttpServletRequest request) {
		boolean status = powerService.deletePowerById(powerId);
		if (status == false) {
			return ResultUtil.errorWithMsg("power/rolepower table not have this power");
		}
		return ResultUtil.success("delete data success");
	}

	@ResponseBody
	@RequestMapping("/updatePowerInfo")
	public Object updatePowerInfo(@RequestBody Power power, HttpServletRequest request) {
		boolean status = powerService.updatePower(power);
		if (status == false) {
			return ResultUtil.errorWithMsg("powerName has exist or power update error");
		}
		return ResultUtil.success("update power success");
	}
}
