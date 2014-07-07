package org.daniels.examples.notification.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "org.daniels.examples.notification.controller" })
public class WebAppConfig extends WebMvcConfigurerAdapter {
	private final transient Log logger = LogFactory.getLog(WebAppConfig.class);
	
	public WebAppConfig(){
		logger.info("WebAppConfig");
	}
	
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
	    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	    //resolver.setPrefix("/WEB-INF/pages/");
	    resolver.setPrefix("/");
	    resolver.setSuffix(".jsp");
	    return resolver;
	}
}
