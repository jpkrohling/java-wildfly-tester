package de.kroehling.wildfly.tracing.example;

import org.eclipse.microprofile.opentracing.Traced;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.logging.Logger;

/**
 * This is a regular synchronous stateless EJB. It demonstrates how to get the span context for the span it's wrapped
 * on. This can be used to pass down the call chain, create child spans or add baggage items.
 *
 * @author Juraci Paixão Kröhling
 */
@Stateless
@Traced
public class OrderService {
    private static final Logger log = Logger.getLogger(OrderService.class.getName());

    @Resource
    EJBContext ctx;

    @Inject
    InventoryService inventoryService;

    public void processOrderPlacement() {
        log.info("Placing order");
        inventoryService.changeInventory();
    }
}
