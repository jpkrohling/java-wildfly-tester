package de.kroehling.wildfly.tracing.example;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import org.eclipse.microprofile.opentracing.Traced;

/**
 * This is a simple synchronous EJB, without any knowledge about span context or other OpenTracing semantics. All it
 * does is specify an interceptor and it's shown as the child of a parent span.
 *
 * @author Juraci Paixão Kröhling
 */
@Stateless
@Traced
public class AccountService {
    private static final Logger log = Logger.getLogger(AccountService.class.getName());

    public void sendNotification() {
        log.info("Notifying the account owner about a new order");
    }
}
