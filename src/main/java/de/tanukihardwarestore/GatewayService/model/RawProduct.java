package de.tanukihardwarestore.GatewayService.model;

import java.io.Serializable;
import java.util.Set;

public class RawProduct implements Serializable {

    private Long productID;
    private String name;
    private Set<PCComponent> components;
    private String imageURL;




    public RawProduct(Long productID, String name, Set<PCComponent> components, String imageURL) {
        this.name = name;
        this.components = components;
    }

    public Set<PCComponent> getComponents() {
        return components;
    }

    public String getName() {
        return name;
    }

    public Long getProductID() {
        return productID;
    }

    public String getImageURL() {
        return imageURL;
    }
}
