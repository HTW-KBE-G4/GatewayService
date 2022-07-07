package de.tanukihardwarestore.GatewayService.model;

import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Setter
@NoArgsConstructor
public class RawProduct implements Serializable {

    private Long product_id;
    private String name;
    private Set<PCComponent> components;
    private String image_url;

    public RawProduct(Long product_id, String name, Set<PCComponent> components, String image_url) {
        this.name = name;
        this.components = components;
        this.image_url = image_url;
    }

    public Set<PCComponent> getComponents() {
        return components;
    }

    public String getName() {
        return name;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public void setComponents(Set<PCComponent> components) {
        this.components = components;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }
}
