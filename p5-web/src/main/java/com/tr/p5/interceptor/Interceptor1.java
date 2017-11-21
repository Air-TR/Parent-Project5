package com.tr.p5.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.tr.p5.entity.Staff;
import com.tr.p5.exception.MyException;
import com.tr.p5.result.ResultEnum;

/**
 * 拦截器1
 * 
 * @author taorun
 * @date 2017年11月21日 下午5:15:12
 *
 */
public class Interceptor1 implements HandlerInterceptor {
	
	public static final String SESSION_ATTR_USER = "user";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
    		System.out.println(request.getServletPath());
	    	System.out.println(">>>MyInterceptor1>>>>>>>在请求处理之前进行调用（Controller方法调用之前）");
    		if (handler instanceof HandlerMethod) {
			Staff staff = (Staff) request.getSession().getAttribute(SESSION_ATTR_USER);
			if (staff == null) {
				throw new MyException(ResultEnum.NO_LOGIN);
			}
		}
        return true; // 只有返回true才会继续向下执行，返回false取消当前请求
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        System.out.println(">>>MyInterceptor1>>>>>>>请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println(">>>MyInterceptor1>>>>>>>在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
    }

}
