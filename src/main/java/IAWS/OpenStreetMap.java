package IAWS;

import org.glassfish.jersey.client.ClientResponse;
import org.glassfish.jersey.jaxb.internal.XmlJaxbElementProvider;
import org.glassfish.jersey.jsonp.JsonProcessingFeature;
import org.junit.Test;

import javax.json.Json;
import javax.json.JsonArray;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Micka on 12/04/2016.
 */
public class OpenStreetMap {
    private static final String API_URI = "http://api.openstreetmap.org/api/0.6/permissions/";

    public static void getAdr(String adr) {

        final Client client = ClientBuilder.newClient();
        WebTarget target = client.target(API_URI);
        System.out.println(target.path("rest").path("hello").request().accept(MediaType.TEXT_PLAIN).get(String.class));
    }

    @Test
    public void getEvalsTest() {
        OpenStreetMap.getAdr("");
    }
}
