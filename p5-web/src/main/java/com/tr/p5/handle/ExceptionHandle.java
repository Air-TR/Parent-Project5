package com.tr.p5.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tr.p5.exception.MyException;
import com.tr.p5.result.Result;
import com.tr.p5.result.ResultEnum;

/**
 * 统一异常处理
 * 
 * @author taorun
 * @date 2017年11月21日 下午2:36:37
 *
 */

@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

	@ExceptionHandler(Exception.class)
    @ResponseBody
    public Result<?> handle(Exception e) {
        if (e instanceof MyException) {
            MyException myException = (MyException) e;
            return Result.fail(myException.getCode(), myException.getMessage());
        } else {
            logger.error("[系统异常]", e);
            return Result.fail(ResultEnum.UNKNOWN_ERROR.getCode(), e.getMessage());
        }
    }

}
