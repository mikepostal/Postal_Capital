package com.bannershallmark.config;

import static com.bannershallmark.util.Constants.Development.ON_SERVER;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;

import com.bannershallmark.util.Constants.Development;

/**
 * @author Niravdas
 */
@Configuration
public class WebEnvironmentInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		System.out.println("servletContext.getContextPath() :: " + servletContext.getContextPath());
		if(ON_SERVER) {
			String url = servletContext.getContextPath();
			if(Development.LIVE_URL.equalsIgnoreCase(url)) {
				servletContext.setInitParameter("envName", ".live");
			} else {
				servletContext.setInitParameter("envName", ".dev");
			}
		} else {
			servletContext.setInitParameter("envName", "");
		}
	}
}
