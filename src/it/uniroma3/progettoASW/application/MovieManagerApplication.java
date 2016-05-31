package it.uniroma3.progettoASW.application;

import java.util.*;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
//import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
//import com.google.common.collect.ImmutableSet;

import it.uniroma3.progettoASW.manager.*;

@ApplicationPath("/")
public class MovieManagerApplication extends Application{
	
	 @Override
	    public Set<Class<?>> getClasses() {
	        final Set<Class<?>> classes = new HashSet<>();
	        // register root resource
	        classes.add(MovieResource.class);
	        classes.add(MovieContainer.class);
	        return classes;
	    }

//	    @Override
//	    /* Risolve il problema del Provider JSON non trovato alla prima richiesta.
//	     * Vedi https://java.net/jira/browse/GLASSFISH-21141 */
//		public Set<Object> getSingletons() {
//			ObjectMapper mapper = new ObjectMapper();
//			mapper.registerModule(new JaxbAnnotationModule());
//			return ImmutableSet
//	  				.<Object> builder()
//					.add(new JacksonJaxbJsonProvider(mapper, JacksonJaxbJsonProvider.DEFAULT_ANNOTATIONS)).build();
//		}
	
	

}
