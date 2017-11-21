package com.tr.p5.controller.exception;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tr.p5.exception.MyException;
import com.tr.p5.result.ResultEnum;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 统一异常处理测试
 * 
 * @author taorun
 * @date 2017年11月21日 下午3:18:02
 *
 */

@Api(tags = "Exception")
@RestController
public class ExceptionController {
	
	@ApiOperation(value = "自定义异常测试")
	@GetMapping("/exception/myException")
	public void myException() {
		throw new MyException(ResultEnum.MY_EXCEPTION_TEST);
	}
	
	@ApiOperation(value = "系统异常测试")
	@GetMapping("/exception/systemException")
	public void systemException() throws Exception {
		throw new Exception();
	}

}
