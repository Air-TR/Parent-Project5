package com.tr.common.result;

public enum ResultEnum {

	UNKNOWN_ERROR(-1, "未知错误"),
	DAO_EXCEPTION(-2, "Database访问异常"),
    SUCCESS(0, "成功"),
    FAIL(1, "失败"),
    NO_LOGIN(2, "未登录"),
    LOGIN_FAIL(3, "登录失败，用户名或密码不正确"),
    PARAM_NULL(4, "必要参数为空"),
    MY_EXCEPTION_TEST(101, "自定义异常报错测试"),
    ;
	
	private Integer code;
	
	private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
