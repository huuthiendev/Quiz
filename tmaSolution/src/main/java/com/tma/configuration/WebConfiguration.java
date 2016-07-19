package com.tma.configuration;

import org.h2.server.web.WebServlet;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.tma.authentication.ProcessingInterceptor;

@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter{
    @Bean
    ServletRegistrationBean h2servletRegistration(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry){
    	registry.addInterceptor(new ProcessingInterceptor()).addPathPatterns("/**").excludePathPatterns("/login");
    }  
}
