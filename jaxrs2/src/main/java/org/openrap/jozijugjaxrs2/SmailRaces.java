package org.openrap.jozijugjaxrs2;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.ws.rs.PathParam;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import org.openrap.jozijugjaxrs2.domain.RaceBean;
import org.openrap.jozijugjaxrs2.domain.RaceBettingResult;


@Path("snailbetting/{raceNumber}")
public class SmailRaces {

    private static ConcurrentHashMap<Long, RaceBean> data = hardCodedData();

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Collection<RaceBean> allRaces(@QueryParam("raceNumber") Long raceNumber) {
        return data.values();
    }

    @GET
    @Path("/bet")
    @Produces(MediaType.APPLICATION_XML)
    public RaceBettingResult placeBet(@NotNull @PathParam("raceNumber") Long raceNumber, @NotNull @QueryParam("raceId") String raceId, @NotNull @Min(message="Min bet is 10 cents", value=10) @QueryParam("amountCents") Integer amountCents) {

//        logAuditForBetRequest(raceNumber, raceId, amountCents);

//        The below is replaced by JAXRS bean validation 1.1 , parm validations        
//        if (raceNumber == null) {
//            throw new WebApplicationException(new IllegalArgumentException("You did not specify a raceNumber"),400);
//        }
//        if (raceId == null) {
//            throw new WebApplicationException(new IllegalArgumentException("You did not specify a raceId"),400);
//        }
//        if (amountCents == null) {
//            throw new WebApplicationException(new IllegalArgumentException("You did not specify a amountCents"),400);
//        }
//        if (amountCents < 10) {
//            throw new WebApplicationException(new IllegalArgumentException("Please specify a amountCents greater than 10 cents"),400);
//        }

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
