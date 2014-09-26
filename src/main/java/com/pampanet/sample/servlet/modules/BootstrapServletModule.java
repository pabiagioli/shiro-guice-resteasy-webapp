package com.pampanet.sample.servlet.modules;

import org.apache.shiro.guice.web.GuiceShiroFilter;

import com.google.inject.servlet.ServletModule;
import com.pampanet.sample.rest.SampleRestModule;
import com.pampanet.sample.servlet.config.GuiceRestEasyFilterDispatcher;
import com.pampanet.sample.shiro.modules.BootstrapShiroModule;
import com.pampanet.sample.shiro.modules.ShiroAnnotationsModule;

/**
 * This class bootstraps the application Servlet (JBoss RestEasy 3). If you want
 * the Shiro annotations to work, you will need to inject every Web Service's
 * constructor, so Guice's injector can handle the creation of the WS.
 * 
 * @see com.pampanet.sample.rest.SampleSecuredRESTWebService
 * @author pablo.biagioli
 *
 */
public class BootstrapServletModule extends ServletModule {

	// private static final String propertyPackages =
	// GenericBootstrapConstants.JERSEY_PROPERTY_PACKAGES;

	@Override
	protected void configureServlets() {
		super.configureServlets();
		// get the bootstrapping Properties file
		install(new BootstrapPropertiesModule());
		// Initialize Persistence JPA Unit of Work if present
		// install(new MyUnitOfWorkModule());
		// Initialize Apache Shiro if present
		install(new BootstrapShiroModule(getServletContext()));
		//This allows Shiro AOP Annotations http://shiro.apache.org/java-authorization-guide.html
		install(new ShiroAnnotationsModule());
		
		install(new SampleRestModule());
		filter("/*").through(GuiceShiroFilter.class);
		filter("/*").through(GuiceRestEasyFilterDispatcher.class);

	}
}
