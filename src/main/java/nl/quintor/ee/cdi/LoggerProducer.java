package nl.quintor.ee.cdi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.lang.reflect.Field;

@ApplicationScoped
public class LoggerProducer {

    @Produces
    public Logger getLogger(InjectionPoint ip) {
         Field field = (Field) ip.getMember();
        return LoggerFactory.getLogger(field.getDeclaringClass());
    }
}
