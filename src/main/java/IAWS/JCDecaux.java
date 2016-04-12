package IAWS;

import org.glassfish.jersey.client.ClientResponse;
import org.glassfish.jersey.jsonp.JsonProcessingFeature;
import org.junit.Test;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by Micka on 11/04/2016.
 */


public class JCDecaux {
    private static final String API_URI = "https://api.jcdecaux.com/vls/v1/stations/?contract=toulouse&apiKey=91a6f4728882df5fe49bba7a633ca6f452bd7b72";
    public static JsonArray getStation(String contrat) {
        final Client client = ClientBuilder.newClient();
        final WebTarget webTarget = client.register(JsonProcessingFeature.class).target(API_URI);
        try {
            // Start building a request to the targeted web resourc
           JsonArray jsonArray = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get(JsonArray.class);
           return jsonArray;

        } catch (InternalServerErrorException e) {
            // e.printStackTrace();
            System.err.println("Réponse HTTP " + e.getResponse().getStatus());
            return Json.createArrayBuilder().build(); // return a dummy array
        }
    }

   /* public static List<String> getEvals(JsonArray evalsIds) {
        List<String> res = new ArrayList<String>();

        if (evalsIds.size() == 0) {
            System.out.println("Pas d'évaluation trouvée pour l'étudiant spécifié.");
            return res;
        }

        final Client c = ClientBuilder.newClient();
        final WebTarget wt = c.target(API_URI);

        for (JsonValue jv : evalsIds) {
            if (jv instanceof JsonObject) {
                final int evalId = ((JsonObject) jv).getInt("id");
                final JsonObject jo = wt.path(EVA_RES)
                        .path(String.valueOf(evalId))
                        .request(MediaType.APPLICATION_JSON).get(JsonObject.class);
                res.add(String.format("%s : %s sur %s (coeff %s)",
                        jo.getString("titre"),
                        jo.getJsonNumber("note").doubleValue(),
                        jo.getJsonNumber("noteMax").doubleValue(),
                        jo.getJsonNumber("coeff").doubleValue()));
            }
        }
        return res;
    }*/

    @Test
    public void getEvalsTest() {
     /*   String testId = "Toulouse"; // numéro d'un étudiant
        List<String> evals = getEvals(getStation(testId));

        assertTrue(evals.size() > 0);

        for (String eval : evals) {
            System.out.println(eval);
        }*/
        JsonArray jso = JCDecaux.getStation("toulouse");
        System.out.println(jso.toString());
    }
}
