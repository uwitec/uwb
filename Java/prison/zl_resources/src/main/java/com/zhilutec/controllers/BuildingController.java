package com.zhilutec.controllers;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zhilutec.common.result.Result;
import com.zhilutec.common.result.ResultCode;
import com.zhilutec.services.IBuildingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/building")
@EnableAutoConfiguration
@Api(value = "Building")
public class BuildingController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	private IBuildingService buildingService;


	@ApiOperation(value = "查询楼栋信息", notes = "查询楼栋信息<br><hr/>", response = String.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "{}", value = "{}", required = false, dataType = "String", paramType = "body", defaultValue = "") })
	@RequestMapping(value = "/queryCode", method = { RequestMethod.POST }, produces = "application/json;charset=UTF-8")
	public String queryCode(HttpServletRequest request, HttpServletResponse response,
			@RequestBody String requestBody) {		
		logger.info("=====RequestBody:" + requestBody);		
		try {
			return buildingService.queryResult(requestBody);
		} catch (Exception e) {
			e.printStackTrace();
			Result rs = Result.error(ResultCode.UNKNOW_ERR.getCode(), "查询楼栋信息出现异常");
			return rs.toJSONString();
		}
	}

	
}
