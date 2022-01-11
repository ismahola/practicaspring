package com.example.demo.component;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component("Componentes")
public class Componentes {

	private static final Log LOG = LogFactory.getLog(Componentes.class);
	
	public void error(String error) {
		
		LOG.error(error);
		
	}
	
	public void info(String info) {
		
		LOG.info(info);
		
	}
	
}
