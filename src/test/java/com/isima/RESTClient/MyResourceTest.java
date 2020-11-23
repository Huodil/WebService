package com.isima.RESTClient;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.isima.RESTClient.MyResource;

public class MyResourceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(MyResource.class);
    }

    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
    @Test
    public void testgetURL() {

        String texte = "initial";

        final String responseMsg = target("/myresource/initial").request().get(String.class);
        assertEquals("<html><body>Hello!<h1><br>"+texte+"\n</h1></body></html>", responseMsg);

    }
}
