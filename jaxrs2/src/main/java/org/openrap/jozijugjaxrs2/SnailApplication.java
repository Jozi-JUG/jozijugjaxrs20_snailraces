
package org.openrap.jozijugjaxrs2;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.server.ServerProperties;

@ApplicationPath("rest/*")
public class SnailApplication extends Application {

    @Override
    public Map<String, Object> getProperties() {

        Map<String,Object> props = new HashMap<>();
        props.put(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
        return props;
    }



}
