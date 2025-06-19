package com.ccstudent.mscliente.config;

import jakarta.servlet.annotation.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserApiConfig {
    @Bean
    public ServletRegistrationBean<WebServlet> h2ConsoleServletRegistration() {
        ServletRegistrationBean<WebServlet> registration = new ServletRegistrationBean<>(new WebServlet());
        registration.addUrlMappings("/h2-console/*");
        registration.addInitParameter("webAllowOthers", "false");
        return registration;
    }
}