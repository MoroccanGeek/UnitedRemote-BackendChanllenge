package com.saberhamza.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 
 * @author Hamaz SABER
 *
 */
public class AppDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * 
	 * @return The configuration for root application context (non-webinfrastructure) configuration. 
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	/**
	 * 
	 * @return The configuration for the Servlet application context.
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {AppConfig.class};
	}

	/**
	 * 
	 * @return Specify the servlet mapping(s) for DispatcherServletapplication context (Spring MVC infrastructure) configuration.
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
