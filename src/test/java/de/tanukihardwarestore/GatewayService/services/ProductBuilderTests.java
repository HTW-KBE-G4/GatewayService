package de.tanukihardwarestore.GatewayService.services;

import de.tanukihardwarestore.GatewayService.model.PCComponent;
import de.tanukihardwarestore.GatewayService.model.PricedProduct;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ProductBuilderTests {

    final ProductBuilder builder = new ProductBuilder(new MockRabbitServiceImpl());

    @Test
    public void getOneProductTest() {
        PricedProduct product = builder.getOneProduct("0",2,"USD");

        System.out.println(product);
        //Product has components and converted price
        Assertions.assertEquals(3,product.getComponents().size());
        Assertions.assertEquals(MockRabbitServiceImpl.conversionFactor*3*MockRabbitServiceImpl.unconvertedUVP,product.getUvp());

        //Components are also in a converted state
        Assertions.assertEquals(product.getComponents().iterator().next().getUvp(),MockRabbitServiceImpl.unconvertedUVP*MockRabbitServiceImpl.conversionFactor);
    }

    @Test
    public void getAllProductsTest() {
        List<PricedProduct> products = builder.getAllProducts("0","USD");

        //Product has components and converted price
        Assertions.assertEquals(3,products.size());
        Assertions.assertEquals(MockRabbitServiceImpl.conversionFactor*3*MockRabbitServiceImpl.unconvertedUVP,products.get(1).getUvp());

        //Components are also in a converted state
        Assertions.assertEquals(products.get(1).getComponents().iterator().next().getUvp(),MockRabbitServiceImpl.unconvertedUVP*MockRabbitServiceImpl.conversionFactor);
    }

    @Test
    public void getOneComponentTest() {
        PCComponent component = builder.getOneComponent(1L,"USD");

        Assertions.assertEquals(MockRabbitServiceImpl.unconvertedUVP*MockRabbitServiceImpl.conversionFactor, component.getUvp());
    }

    @Test
    public void getAllComponentsTest() {
        List<PCComponent> component = builder.getAllComponents("USD");

        Assertions.assertEquals(MockRabbitServiceImpl.unconvertedUVP*MockRabbitServiceImpl.conversionFactor, component.get(1).getUvp());
    }


}
