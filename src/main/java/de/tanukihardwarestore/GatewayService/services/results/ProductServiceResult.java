package de.tanukihardwarestore.GatewayService.services.results;

import de.tanukihardwarestore.GatewayService.model.RawProduct;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceResult {

    private List<RawProduct> productList;

    public ProductServiceResult(List<RawProduct> productList) {
        this.productList = new ArrayList<>(productList);
    }

    public List<RawProduct> getProductList() {
        return productList;
    }
}
