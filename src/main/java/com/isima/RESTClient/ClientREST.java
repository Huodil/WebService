package com.isima.RESTClient;

import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

@Path("client")
public class ClientREST {

    ClientConfig config = new ClientConfig();

    Client client = ClientBuilder.newClient(config);

    @GET
    @Path("/lidouh")
    @Produces(MediaType.TEXT_HTML)
    public String getServiceLidouh() {
        String uri_lidouh ="https://tp-soa-lidouh.herokuapp.com/myresource/lidouh";



        WebTarget target = client.target(uri_lidouh);

        String response_lidouh = target.request().accept(MediaType.TEXT_HTML).get(String.class);


        return response_lidouh;

    }
    @GET
    @Path("/achkour")
    @Produces(MediaType.TEXT_HTML)
    public String getServiceAchkour(){
        String uri_achkour = "https://heroku-soa-tp2.herokuapp.com/myresource/introduction?name=ACHKOUR";

        WebTarget target1 = client.target(uri_achkour);
        String response_achkour = target1.request().accept(MediaType.TEXT_HTML).get(String.class);

        return response_achkour;
    }



/*    public static void main(String[] args) {
        String uri ="https://serene-springs-52486.herokuapp.com/myresource/lidouh";
        String url = "https://heroku-soa-tp2.herokuapp.com/myresource/introduction?name=ACHKOUR";
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        WebTarget target = client.target(uri);
        WebTarget target1 = client.target(url);

        String responses = target.request().accept(MediaType.TEXT_HTML).get(String.class);
        String response = target1.request().accept(MediaType.TEXT_HTML).get(String.class);

        System.out.println(responses);
        System.out.println(response);
    }*/
}
