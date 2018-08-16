package de.kroehling.wildfly.tracing.example;

import org.eclipse.microprofile.opentracing.Traced;

import javax.ejb.Stateless;
import java.util.logging.Logger;

/**
 * This is the final call in the chain. This is an asynchronous stateless EJB, which obtains the span context
 * via a method parameter. This bean is not intercepted in any way by us, so, the span context received is exactly
 * the same as what was sent by the caller.
 *
 * @author Juraci Paixão Kröhling
 */
@Stateless
@Traced
public class InventoryNotificationService {
    private static final Logger log = Logger.getLogger(InventoryNotificationService.class.getName());

    public void sendNotification() {
        log.info("Sending an inventory change notification");
    }
}
