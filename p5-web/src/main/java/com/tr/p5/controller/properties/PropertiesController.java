package com.tr.p5.controller.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Properties")
@RestController
public class PropertiesController {
	
	@Value(value = "${my.value}")
	private String value;
	
	@ApiOperation(value = "获取配置文件中变量")
	@GetMapping("/properties/getValue")
	public String getValue() {
		return value;
	}

}
