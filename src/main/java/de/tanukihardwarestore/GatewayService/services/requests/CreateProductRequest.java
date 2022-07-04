package de.tanukihardwarestore.GatewayService.services.requests;

import de.tanukihardwarestore.GatewayService.model.RawProduct;

public class CreateProductRequest {
    private RawProduct product;
    private String userID;

    public CreateProductRequest(RawProduct product, String userID) {
        this.product = product;
        this.userID = userID;
    }

    public RawProduct getProduct() {
        return product;
    }

    public String getUserID() {
        return userID;
    }
}
