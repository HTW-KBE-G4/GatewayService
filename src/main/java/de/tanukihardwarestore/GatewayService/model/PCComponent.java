package de.tanukihardwarestore.GatewayService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
public class PCComponent implements Serializable {

    private Long component_id;

    private String type;

    private String model;

    private String description;

    private String manufacturer;

    private String releaseDate;

    private Float uvp;

    private float weight;

    private String productName;

    private Long ean;

    private String imageURL;

    public PCComponent(Long id, String type, String model, String manufacturer, float uvp, String description,
                       String releaseDate, float weight, String productName, Long ean, String imageURL) {
        this.component_id = id;
        this.model = model;
        this.description = description;
        this.releaseDate = releaseDate;
        this.manufacturer = manufacturer;
        this.uvp = uvp;
        this.type = type;
        this.weight = weight;
        this.productName = productName;
        this.ean = ean;
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "PCComponent{" +
                "id=" + component_id +
                ", type='" + type + '\'' +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", uvp='" + uvp + '\'' +
                ", weight='" + weight + '\'' +
                ", productName='" + productName + '\'' +
                ", ean='" + ean + '\'' +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setEan(Long ean) {
        this.ean = ean;
    }

    public float getWeight() { return weight; }

    public String getProductName() { return productName; }

    public Long getEan() { return ean; }

    public String getImageURL() { return imageURL; }

    public Long getComponent_id() {
        return component_id;
    }

    public void setComponent_id(Long component_id) {
        this.component_id = component_id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public float getUvp() {
        return uvp;
    }

    public void setUvp(float uvp) {
        this.uvp = uvp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUvp(Float uvp) {
        this.uvp = uvp;
    }
}
