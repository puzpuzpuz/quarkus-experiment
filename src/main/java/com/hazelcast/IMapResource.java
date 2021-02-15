package com.hazelcast;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.CompletionStage;

@Path("/api")
public class IMapResource {

    @Inject
    HazelcastInstance hazelcastInstance;

    @POST
    @Path("/{map}/{key}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public CompletionStage<String> createMapEntry(
            @PathParam("map") String map,
            @PathParam("key") String key,
            String value
    ) {
        IMap<String, String> imap = hazelcastInstance.getMap(map);
        return imap.setAsync(key, value)
                .thenApplyAsync(v -> "updated");
    }
}
