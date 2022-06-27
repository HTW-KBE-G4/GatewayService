package de.tanukihardwarestore.GatewayService.services;

import de.tanukihardwarestore.GatewayService.model.PCComponent;
import de.tanukihardwarestore.GatewayService.model.PricedProduct;

import java.util.List;

public interface ProductBuilderService {

    public List<PricedProduct> getAllProducts(String userID, String currency);

    public PricedProduct getOneProduct(String userID, long productID, String currency);

    public List<PCComponent> getAllComponents(String currency);

    public PCComponent getOneComponent(long componentID, String currency);
}
