package de.tanukihardwarestore.GatewayService.services.requests;

import lombok.Setter;

import java.io.Serializable;

@Setter
public class ProductServiceRequest implements Serializable {

    private String userID;

    public ProductServiceRequest(String userID) {

        this.userID = userID;
    }

    public ProductServiceRequest() {}

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
