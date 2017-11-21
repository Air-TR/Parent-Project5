package com.tr.p5.exception;

import com.tr.p5.result.ResultEnum;

/**
 * 自定义异常
 * 
 * @author taorun
 * @date 2017年11月21日 下午3:24:53
 *
 */

public class MyException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private Integer code;
	
    public MyException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
