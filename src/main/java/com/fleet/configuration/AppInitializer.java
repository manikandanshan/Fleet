package com.fleet.configuration;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
public class AppInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer implements WebApplicationInitializer {

	public AppInitializer() {
		
	}

	public void onStartup(ServletContext servletContext) throws ServletException {
		 
		
		super.onStartup(servletContext);
		servletContext.addListener(new SessionListener());
        /*AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(AppConfig.class);
        ctx.setServletContext(container);
        ServletRegistration.Dynamic servlet = container.addServlet(
                "dispatcher", new DispatcherServlet(ctx));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");*/
    }
	@Override
	protected Class<?>[] getRootConfigClasses() {
	return null;
	}
	@Override
	protected Class<?>[] getServletConfigClasses() {
	return new Class<?>[] { AppConfig.class };
	}
	@Override
	protected String[] getServletMappings() {
	return new String[] { "/" };
	}
	@Override
	protected Filter[] getServletFilters() {
	return new Filter[] { new HiddenHttpMethodFilter() };
	}
	
}
