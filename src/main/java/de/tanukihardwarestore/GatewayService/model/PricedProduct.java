package de.tanukihardwarestore.GatewayService.model;

import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@NoArgsConstructor
@Setter
public class PricedProduct implements Serializable {

    private Long product_id;

    private String name;

    private Set<PCComponent> components;

    private Double uvp;

    private String image_url;


    public PricedProduct(Long id, String name, String image_url, Set<PCComponent> components) {
        this.product_id = id;
        this.name = name;
        this.components = components;
        this.image_url = image_url;
    }

    public PricedProduct(Long id, String name, String image_url, Set<PCComponent> components, Double uvp) {
        this(id, name, image_url, components);
        this.uvp = uvp;
    }

    public PricedProduct(RawProduct rawProduct, double uvp) {
        this.product_id = rawProduct.getProduct_id();
        this.name = rawProduct.getName();
        this.components = rawProduct.getComponents();
        this.image_url = rawProduct.getImage_url();
        this.uvp = uvp;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + product_id +
                ", name='" + name + '\'' +
                ", components=" + components +
                '}';
    }

    public Long getProduct_id() {
        return product_id;
    }

    public String getName() {
        return name;
    }

    public Set<PCComponent> getComponents() { return components; }

    public String getImage_url() {
        return image_url;
    }

    public Double getUvp() {
        return uvp;
    }
}
