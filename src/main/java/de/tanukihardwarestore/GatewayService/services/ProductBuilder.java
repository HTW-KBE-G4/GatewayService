package de.tanukihardwarestore.GatewayService.services;

import de.tanukihardwarestore.GatewayService.model.PCComponent;
import de.tanukihardwarestore.GatewayService.model.PricedProduct;
import de.tanukihardwarestore.GatewayService.model.RawProduct;

import java.util.LinkedList;
import java.util.List;

public class ProductBuilder implements ProductBuilderService {

    public ProductBuilder(RabbitService rabbitService) {
        this.rabbitService = rabbitService;
    }

    RabbitService rabbitService;

    @Override
    public List<PricedProduct> getAllProducts(String userID, String currency) {
        List<RawProduct> rawProducts = rabbitService.getAllProducts(userID);
        List<PricedProduct> pricedProducts = new LinkedList<PricedProduct>();
        for(RawProduct product: rawProducts) {
            pricedProducts.add(priceProduct(product,currency));
        }
        return pricedProducts;
    }

    @Override
    public PricedProduct getOneProduct(String userID, long productID, String currency) {
        RawProduct product = rabbitService.getOneProduct(userID, productID);
        return priceProduct(product,currency);
    }

    private PricedProduct priceProduct(RawProduct product, String currency) {
        LinkedList<PCComponent> components = new LinkedList<>(product.getComponents());
        for(PCComponent component: components) {
            convertCurrencyOfComponent(component, currency);
        }
        double price = rabbitService.calculatePrice(components);
        return new PricedProduct(product, price);
    }

    private PCComponent convertCurrencyOfComponent(PCComponent component, String currency) {
        component.setUvp((float)rabbitService.calculateCurrency(component.getUvp(), "USD", currency));
        return component;
    }

    @Override
    public List<PCComponent> getAllComponents(String currency) {
        List<PCComponent> components = rabbitService.getAllComponents();
        for(PCComponent component: components) {
            convertCurrencyOfComponent(component, currency);
        }
        return components;
    }

    @Override
    public PCComponent getOneComponent(long componentID, String currency) {
        PCComponent component = rabbitService.getOneComponent(componentID);
        return convertCurrencyOfComponent(component, currency);
    }
}
