package org.openrap.jozijugjaxrs2.filters;

import java.security.Principal;
import java.util.List;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;

@Provider
public class LogAuditForBetRequestFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) {
        log(requestContext);
    }

    void log(ContainerRequestContext requestContext) {
        SecurityContext securityContext = requestContext.getSecurityContext();
        String authentication = securityContext.getAuthenticationScheme();
        Principal userPrincipal = securityContext.getUserPrincipal();
        UriInfo uriInfo = requestContext.getUriInfo();
        String method = requestContext.getMethod();
        List<Object> matchedResources = uriInfo.getMatchedResources();
        //...
    }
}
