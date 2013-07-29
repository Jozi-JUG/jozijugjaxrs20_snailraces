
package org.openrap.jozijugjaxrs2.client;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import org.openrap.jozijugjaxrs2.domain.RaceBettingResult;

public class SmailRacesClient {
    public static void main(String []args){
        javax.ws.rs.client.Client c = ClientBuilder.newClient();

        RaceBettingResult r = c.target("http://localhost:8080/jozijugjaxrs2/rest/snailbetting/{raceNumber}/bet/").resolveTemplate("raceNumber", 2).queryParam("raceId", 1).queryParam("amountCents", 100).request(MediaType.APPLICATION_XML).get(RaceBettingResult.class);

        System.out.println(r.toString());
    }
}
