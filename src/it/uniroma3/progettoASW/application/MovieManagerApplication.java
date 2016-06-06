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
	        classes.add(MovieResource.class);
	        classes.add(MovieContainer.class);
	        return classes;
	    }	

}
