package org.daniels.examples.jersey.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.daniels.examples.jersey.SampleService;
import org.springframework.stereotype.Component;

@Component
public class SampleServiceImpl implements SampleService {
	private final transient Log logger = LogFactory.getLog(SampleServiceImpl.class);
	
	public String save() {
		logger.info(">>>> SampleService - save action");
		
		return ">>>> SampleService - save action";

	}

}