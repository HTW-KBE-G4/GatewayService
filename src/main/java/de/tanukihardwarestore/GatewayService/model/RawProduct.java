package de.tanukihardwarestore.GatewayService.model;

import java.util.Set;

public class RawProduct {

    private String name;
    private Set<PCComponent> components;






    public RawProduct(String name, Set<PCComponent> components) {
        this.name = name;
        this.components = components;
    }

    public Set<PCComponent> getComponents() {
        return components;
    }

    public String getName() {
        return name;
    }
}
