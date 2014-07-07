package org.daniels.examples.notification.config;

import org.daniels.examples.notification.aspect.NotifyAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = { "org.daniels.examples" })
@EnableAspectJAutoProxy
public class AppConfig {
	
	@Bean
	public NotifyAspect notifyAspect() {
	    return new NotifyAspect();
	}
	
}
