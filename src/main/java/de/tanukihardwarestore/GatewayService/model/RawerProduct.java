package de.tanukihardwarestore.GatewayService.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RawerProduct implements Serializable {

    private String name;

    private Set<PCComponent> components;

    public RawerProduct(String name, List<PCComponent> components) {
        this.name = name;
        this.components = new HashSet<>();
        this.components.addAll(components);
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

    public void setComponents(List<PCComponent> components) {
        this.components = new HashSet<>();
        this.components.addAll(components);
    }

    @Override
    public String toString() {
        return "RawerProduct{" +
                "name='" + name + '\'' +
                ", components=" + components +
                '}';
    }
}
