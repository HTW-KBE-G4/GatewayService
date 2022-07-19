package de.tanukihardwarestore.GatewayService.services;

import de.tanukihardwarestore.GatewayService.model.PCComponent;
import de.tanukihardwarestore.GatewayService.model.RawProduct;

import java.util.*;

public class MockRabbitServiceImpl implements RabbitService {

    public static final float unconvertedUVP = 1;
    public static final float conversionFactor = 2;

    PCComponent component1 = new PCComponent(1L,"type","model","manufacturer",unconvertedUVP,"description","releasedate",0,"component1",1L,"image");
    PCComponent component2 = new PCComponent(2L,"type","model","manufacturer",unconvertedUVP,"description","releasedate",0,"component2",1L,"image");
    PCComponent component3 = new PCComponent(3L,"type","model","manufacturer",unconvertedUVP,"description","releasedate",0,"component3",1L,"image");

    List<PCComponent> components = Arrays.asList(component1,component2,component3);
    Set<PCComponent> componentSet = new HashSet<>(components);

    RawProduct product1 = new RawProduct(1L,"product1","image",componentSet,"0");
    RawProduct product2 = new RawProduct(2L,"product2","image",componentSet,"0");
    RawProduct product3 = new RawProduct(3L,"product3","image",componentSet,"0");

    List<RawProduct> products = Arrays.asList(product1, product2, product3);

    @Override
    public List<RawProduct> getAllProducts(String userID) {

        return products;
    }

    @Override
    public RawProduct getOneProduct(String userID, long productID) {
        return switch ((int) productID) {
            case 1 -> product1;
            case 2 -> product2;
            case 3 -> product3;
            default -> null;
        };
    }

    @Override
    public List<PCComponent> getAllComponents() {
        return components;
    }

    @Override
    public PCComponent getOneComponent(long componentID) {
        return switch ((int) componentID) {
            case 1 -> component1;
            case 2 -> component2;
            case 3 -> component3;
            default -> null;
        };
    }

    @Override
    public void postProduct(RawProduct product, String userID) {
            //Not needed
    }

    @Override
    public double calculatePrice(List<PCComponent> components) {
        float price = 0;
        for(PCComponent component: components) {
            price = price+component.getUvp();
        }

        return price;
    }

    @Override
    public double calculateCurrency(double value, String inputCurrency, String expectedCurrency) {
        if(value == unconvertedUVP*conversionFactor) {
            return value;
        } else {
            return value * conversionFactor;
        }
    }
}
