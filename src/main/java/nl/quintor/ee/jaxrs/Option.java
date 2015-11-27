package nl.quintor.ee.jaxrs;

import javax.validation.constraints.Size;

public class Option {

    @Size(min = 3)
    private String name;

    public Option(String name) {
        this.name = name;
    }

    public Option() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
