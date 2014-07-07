package org.daniels.examples.notification.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.daniels.examples.notification.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@Aspect
public class NotifyAspect {
	private final transient Log logger = LogFactory.getLog(NotifyAspect.class);
	
	@Autowired
	private SimpMessagingTemplate template;
	
	private static final String TOPIC = "/topic/greetings";
	
	@Pointcut("@annotation(org.daniels.examples.notification.aspect.NotifyClients)")
    public void notifyPointcut() {}
	
	@Pointcut("execution(* org.daniels.examples.controller.**.*(..))")
    public void methodPointcut() {}
	
	@After("methodPointcut() && notifyPointcut()") 
    public void notifyClients() throws Throwable {
		logger.info(">>> NotifiyAspect - notifyClients");
        template.convertAndSend(TOPIC, new Message("2 >>>> it works with AspectJ interception!"));
    }
}
