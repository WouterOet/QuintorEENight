package nl.quintor.ee.cdi;

import org.slf4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class EventListener {

    @Inject
    Logger log;

    public void listen(@Observes String event) {
        log.info("Received event {}", event);
    }
}
