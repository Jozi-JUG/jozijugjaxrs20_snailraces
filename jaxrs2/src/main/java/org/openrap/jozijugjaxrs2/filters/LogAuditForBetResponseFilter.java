package org.openrap.jozijugjaxrs2.filters;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

@Provider
public class LogAuditForBetResponseFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
        log(responseContext);
    }
    void log(ContainerResponseContext responseContext) {
        MultivaluedMap<String, String> stringHeaders = responseContext.getStringHeaders();
        Object entity = responseContext.getEntity();
    //...
    }
}
