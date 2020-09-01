package com.envision.dpf.mock.config;

import com.envision.dpf.mock.filter.IPThrottlingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.cache.Cache;
import javax.servlet.Filter;

@Configuration
public class WebMVCConfiguration {

    @Autowired
    Cache cache;

    @Bean
    FilterRegistrationBean filterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(ipThrottlingFilter());
        registration.addUrlPatterns("/*");
        return registration;
    }


    @Bean
    Filter ipThrottlingFilter() {
        return new IPThrottlingFilter(cache);
    }

}
