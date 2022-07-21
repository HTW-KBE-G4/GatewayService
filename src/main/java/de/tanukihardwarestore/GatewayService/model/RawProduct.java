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

    private String user_id;

    public RawProduct(Long id, String name, String image_url, Set<PCComponent> components, String user_id) {
        super();
        this.product_id = id;
        this.name = name;
        this.components = components;
        this.image_url = image_url;
        this.user_id = user_id;
    }

    public RawProduct(RawerProduct product, Long product_id, String image_url) {
        this.components = product.getComponents();
        this.name = product.getName();
        this.image_url = image_url;
        this.product_id = product_id;
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

    public String getUser_id() {
        return user_id;
    }
}
