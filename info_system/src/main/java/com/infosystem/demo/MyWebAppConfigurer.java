package com.infosystem.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.*;
import com.infosystem.demo.interceptor.MyInterceptor;

/**
 * Class MyWebAppConfigurer
 *
 *
 * @version        1.0, 17/09/30
 * @author         datapps
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {

        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        interceptorRegistry.addInterceptor(new MyInterceptor())
                           .addPathPatterns("/**")
                           .excludePathPatterns("/login**",
                                                "/validateCode",
                                                "/vaildUser",
                                                "/admin",
                                                "/checkValidateCodeYesOrNot",
                                                "/vaildUserAdmin",
                                                "/adminLogin",
                                                "/forgotpassword",
                                                "/resetPassword/**");
        super.addInterceptors(interceptorRegistry);
    }

    /*@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/home/**").addResourceLocations("file:/infosystem/home/");
        super.addResourceHandlers(registry);
    }*/

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("/login.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        super.configurePathMatch(configurer);
        configurer.setUseSuffixPatternMatch(false);
    }
}