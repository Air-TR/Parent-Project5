package com.tr.p5.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 拦截器管理类
 * 
 * @author taorun
 * @date 2017年11月21日 下午5:19:41
 *
 */

@Configuration
public class WebMvc extends WebMvcConfigurerAdapter {
	
	@Autowired
	private Interceptor1 interceptor1;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	
        /**
         * 以下拦截器可以复制多个同时使用
         */
        registry.addInterceptor(interceptor1)
        		.addPathPatterns(		// 添加拦截
        				new String[] { "/**" })
        		.excludePathPatterns(	// 排除拦截
        				new String[] {
    						"/swagger-resources/**",
    						"/staff/login"
        				});
        
    }

}
