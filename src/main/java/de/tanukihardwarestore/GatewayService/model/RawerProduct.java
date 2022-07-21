package de.tanukihardwarestore.GatewayService.model;

import java.io.Serializable;
import java.util.Set;

public class RawerProduct implements Serializable {

    private String name;

    private Set<PCComponent> components;

    public RawerProduct(String name, Set<PCComponent> components) {
        this.name = name;
        this.components = components;
    }

    public RawerProduct() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<PCComponent> getComponents() {
        return components;
    }

    public void setComponents(Set<PCComponent> components) {
        this.components = components;
    }
}
