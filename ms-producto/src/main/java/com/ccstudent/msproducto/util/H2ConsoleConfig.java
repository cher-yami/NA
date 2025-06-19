package com.ccstudent.msproducto.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class H2ConsoleConfig {
    @Bean
    public ServletRegistrationBean<WebServlet> h2ConsoleServletRegistration() {
        ServletRegistrationBean<WebServlet> registration =
                new ServletRegistrationBean<>(new WebServlet());
        registration.addUrlMappings("/h2-console/*");
        registration.addInitParameter("webAllowOthers", "false");
        return registration;
    }
}