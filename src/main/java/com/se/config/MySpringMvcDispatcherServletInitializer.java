package com.se.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {AppConfig.class};
	}
	@Override
	protected Filter[] getServletFilters() {
		  CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		  characterEncodingFilter.setEncoding("UTF-8");
		  characterEncodingFilter.setForceEncoding(true);
		  return new Filter[] { characterEncodingFilter };
	}
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		
		return new String[] {"/"};
		
	}

}
