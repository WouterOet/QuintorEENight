package nl.quintor.ee.cdi;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class PropertiesProducer {

    private Map<String, String> values = new HashMap<>();

    @PostConstruct
    private void init() {
        values.put("a", "a");
        values.put("timeout", "1500");
    }

    @Produces
    @Property
    public String getProperty(InjectionPoint ip) {
        Field field = (Field) ip.getMember();
        Property annotation = field.getAnnotation(Property.class);
        return values.get(annotation.name());
    }
}
