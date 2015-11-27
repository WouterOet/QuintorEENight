package nl.quintor.ee.jaxrs;

import javax.ws.rs.NameBinding;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@NameBinding
public @interface LoggedRequest {
}
