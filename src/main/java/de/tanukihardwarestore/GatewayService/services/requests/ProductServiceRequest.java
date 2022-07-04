package de.tanukihardwarestore.GatewayService.services.requests;

public class ProductServiceRequest {

    private String userID;

    public ProductServiceRequest(String userID) {

        this.userID = userID;
    }

    public String getUserID() {
        return userID;
    }
}
