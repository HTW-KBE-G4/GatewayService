package de.tanukihardwarestore.GatewayService.services.requests;

public class ProductServiceRequestSingle extends ProductServiceRequest {
    private long productID;

    public ProductServiceRequestSingle(String userID, long productID) {
        super(userID);
        this.productID = productID;
    }

    public long getProductID() {
        return productID;
    }
}
