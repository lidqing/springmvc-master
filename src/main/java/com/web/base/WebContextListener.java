package com.web.base;

import javax.servlet.ServletContextEvent;

import org.apache.log4j.Logger;
import org.springframework.web.context.ContextLoaderListener;

public class WebContextListener extends ContextLoaderListener{

	Logger logger = Logger.getLogger(WebContextListener.class);
	
	public WebContextListener() {
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
		//初始化本地变量
		logger.info(" -- WebContextListener logger info -- ");
		System.out.println("初始化本地变量....");
		
	}

	

}
