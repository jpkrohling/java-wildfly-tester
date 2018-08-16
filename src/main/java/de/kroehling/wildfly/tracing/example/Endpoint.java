package de.kroehling.wildfly.tracing.example;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * This is a regular JAX-RS endpoint with EJB capabilities. We use the EJB capability to specify an interceptor,
 * so that every method on this class is wrapped on its own span. If the OpenTracing JAX-RS integration is being used,
 * it would be a good idea to not have the interceptor at this level, to avoid having too much "noise".
 *
 * @author Juraci Paixão Kröhling
 */
@Path("/order")
@Stateless
public class Endpoint {
    @Inject
    AccountService accountService;

    @Inject
    OrderService orderService;

    @POST
    @Path("/")
    public String placeOrder() {
        accountService.sendNotification();
        orderService.processOrderPlacement();
        return "Order placed";
    }

}
