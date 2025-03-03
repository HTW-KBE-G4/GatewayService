package de.tanukihardwarestore.GatewayService.services;

import de.tanukihardwarestore.GatewayService.model.PCComponent;
import de.tanukihardwarestore.GatewayService.model.RawProduct;
import de.tanukihardwarestore.GatewayService.model.RawerProduct;

import java.util.List;

public interface RabbitService {

    public List<RawProduct> getAllProducts(String userID);

    public RawProduct getOneProduct(String userID, long productID);

    public List<PCComponent> getAllComponents();

    public PCComponent getOneComponent(long componentID);

    public void postProduct(RawProduct product);

    public double calculatePrice(List<PCComponent> components);

    public double calculateCurrency(double value, String inputCurrency, String expectedCurrency);
}
