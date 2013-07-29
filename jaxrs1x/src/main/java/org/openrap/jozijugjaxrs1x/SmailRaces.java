package org.openrap.jozijugjaxrs1x;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import javax.ws.rs.PathParam;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import org.openrap.jozijugjaxrs1x.domain.RaceBean;
import org.openrap.jozijugjaxrs1x.domain.RaceBettingResult;

@Path("snailbetting/{raceNumber}")
public class SmailRaces {

    private static ConcurrentHashMap<Long, RaceBean> data = hardCodedData();

    @GET
    public Collection<RaceBean> allRaces(@QueryParam("raceNumber") Long raceNumber) {
        return data.values();
    }

    @GET
    @Path("/bet")
    public RaceBettingResult placeBet(@PathParam("raceNumber") Long raceNumber, @QueryParam("raceId") String raceId, @QueryParam("amountCents") Integer amountCents) {

        logAuditForBetRequest(raceNumber, raceId, amountCents);

        if (raceNumber == null) {
            throw new WebApplicationException(new IllegalArgumentException("You did not specify a raceNumber"),400);
        }
        if (raceId == null) {
            throw new WebApplicationException(new IllegalArgumentException("You did not specify a raceId"),400);
        }
        if (amountCents == null) {
            throw new WebApplicationException(new IllegalArgumentException("You did not specify a amountCents"),400);
        }
        if (amountCents < 10) {
            throw new WebApplicationException(new IllegalArgumentException("Please specify a amountCents greater than 10 cents"),400);
        }

        RaceBean race = data.get(raceNumber);
        if (race == null) {
            throw new WebApplicationException(new IllegalArgumentException("could not find race " + raceNumber),400);
        }
        logAuditForBetResponse(raceNumber, raceId, amountCents);

        return new RaceBettingResult(race);



    }

    /* Other Restful VERBS
     @POST
     @DELETE
     */

    private void logAuditForBetRequest(Long raceNumber, String raceId, Integer amountCents) {
        
    }

    private void logAuditForBetResponse(Long raceNumber, String raceId, Integer amountCents) {

    }

    private static ConcurrentHashMap<Long, RaceBean> hardCodedData() {
        ConcurrentHashMap<Long, RaceBean> map = new ConcurrentHashMap<>();
        map.put(1L, new RaceBean(1L,"Super Snail"));
        map.put(2L, new RaceBean(2L,"Mr Hard Core Snail"));
        map.put(3L, new RaceBean(3L,"Hope Snail"));
        return map;
    }
}
