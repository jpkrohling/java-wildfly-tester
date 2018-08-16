package de.kroehling.wildfly.tracing.example;

import org.eclipse.microprofile.opentracing.Traced;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.logging.Logger;

/**
 * This is an asynchronous stateless EJB with spans created automatically by the interceptor. Note that the span context
 * that this method sees is <b>not</b> the same as the span context sent by the caller: the interceptor wraps this
 * method call on its own span, and replaces the span context by the context of this new span. This is done so that this
 * span context can be passed along to the next service "as is".
 *
 * @author Juraci Paixão Kröhling
 */
@Stateless
@Traced
public class InventoryService {
    private static final Logger log = Logger.getLogger(InventoryService.class.getName());

    @Inject
    InventoryNotificationService inventoryNotificationService;

    public void changeInventory() {
        log.info("Changing the inventory");
        inventoryNotificationService.sendNotification();
    }
}
