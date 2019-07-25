package com.atguigu.springboot.config;

import com.atguigu.springboot.compent.LoginHandlerInterCeptor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.*;

@SpringBootConfiguration
public class MyConfig implements WebMvcConfigurer{

    @Override
    //拦截器
    public void addInterceptors(InterceptorRegistry registry) {
        //addPathPatterns拦截路径
        //excludePathPatterns不拦截路径
        registry.addInterceptor(new MyInterceptors()).addPathPatterns("/hello").excludePathPatterns("/success");
        registry.addInterceptor(new LoginHandlerInterCeptor()).addPathPatterns("/**")

               .excludePathPatterns("index.html","/","/user/login");
        //多个拦截器就添加多个
        //registry.addInterceptor(new MyInterceptors()).addPathPatterns("/hello").excludePathPatterns("/success");
    }

    @Override
    //视图映射器
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送/hello请求来到view
        registry.addViewController("/main.html") .setViewName("dashboard");
        registry.addViewController("/index.html") .setViewName("login");
//        registry.addViewController("/add.html").setViewName("add");

    }

    private class MyInterceptors implements HandlerInterceptor {
    }
}
