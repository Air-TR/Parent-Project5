package com.tr.p5.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.tr.common.exception.MyException;
import com.tr.common.result.ResultEnum;
import com.tr.p5.entity.Staff;

/**
 * 拦截器1
 * 
 * @author taorun
 * @date 2017年11月21日 下午5:15:12
 *
 */

@Component
public class Interceptor1 extends HandlerInterceptorAdapter {
	
	/**
	 * 为localDevelop 设置默认值为false
	 * 默认值在配置文件中没有相关配置时生效，配置文件中配置了相关值会覆盖此处设置的默认值
	 */
	@Value(value = "${local.develop:false}")
	private boolean localDevelop;
	
	public static final String SESSION_ATTR_USER = "user";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    		if (handler instanceof HandlerMethod) {
			Staff staff = (Staff) request.getSession().getAttribute(SESSION_ATTR_USER);
			if (staff == null) {
				if (!localDevelop) {
					throw new MyException(ResultEnum.NO_LOGIN);
				}
			}
		}
        return true; // 只有返回true才会继续向下执行，返回false取消当前请求
    }

}
