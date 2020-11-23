package com.isima.RESTClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("/{texte}")
    @Produces(MediaType.TEXT_HTML)
    public String getURL(@PathParam("texte") String texte) {

        return "<html><body>Hello!<h1><br>"+texte+ "\n</h1></body></html>";

    }
}
