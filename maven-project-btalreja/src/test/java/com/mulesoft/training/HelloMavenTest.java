package com.mulesoft.training;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.mule.api.MuleEvent;
import org.mule.tck.junit4.FunctionalTestCase;
import org.mule.tck.junit4.rule.DynamicPort;

public class HelloMavenTest extends FunctionalTestCase {
	
	@Rule
	public DynamicPort myPort=new DynamicPort("http.port");

    @Test
    public void mavenFlowReturnsHelloMaven() throws Exception {
    	System.out.println("Test Case 1:Dynamic Port:"+myPort.getNumber()+"\n\n" );
        runFlowAndExpect("mavenFlow", "Hello Maven");
    }
    
    @Test
    public void retrieveFlightsAddsAppropriateHeader() throws Exception {
      System.out.println("Test Case 2: Dynamic Port:"+myPort.getNumber()+"\n\n" );
      MuleEvent event = runFlow("retrieveFlights");
      String contentType = event.getMessage().getOutboundProperty("Content-Type");
      assertEquals("application/json", contentType);
    }
    
    
    @Override
    protected String[] getConfigFiles() {
        String[] files= {"maven-project-btalreja.xml","common-resources.xml"};
        return files;
    }

}
