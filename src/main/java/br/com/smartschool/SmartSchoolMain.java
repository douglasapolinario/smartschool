package br.com.smartschool;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.jaxrs.JAXRSArchive;

import br.com.smartschool.rest.HelloWorldEndpoint;

public class SmartSchoolMain {
	
	public static void main(String[] args) throws Exception {
		Container container = new Container();
		
		container.start();
		
		JAXRSArchive deployment = ShrinkWrap.create(JAXRSArchive.class);
		deployment.addClasses(HelloWorldEndpoint.class);
		deployment.addAllDependencies();
		container.deploy(deployment);
	}

}
