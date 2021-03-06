package org.daniels.examples.notification.config;

import org.daniels.examples.notification.aspect.NotifyAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackages = { "org.daniels.examples.notification" }, 
	excludeFilters = { @ComponentScan.Filter(value = Controller.class, type = FilterType.ANNOTATION) })
@ImportResource("classpath*:/applicationContext.xml")
@EnableAspectJAutoProxy
public class AppConfig {
	
	@Bean
	public NotifyAspect notifyAspect() {
	    return new NotifyAspect();
	}
	
}
