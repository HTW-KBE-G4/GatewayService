package de.tanukihardwarestore.GatewayService.services;

import de.tanukihardwarestore.GatewayService.config.RabbitConfig;
import de.tanukihardwarestore.GatewayService.model.PCComponent;
import de.tanukihardwarestore.GatewayService.model.RawProduct;
import de.tanukihardwarestore.GatewayService.services.requests.CreateProductRequest;
import de.tanukihardwarestore.GatewayService.services.requests.CurrencyServiceRequest;
import de.tanukihardwarestore.GatewayService.services.requests.ProductServiceRequest;
import de.tanukihardwarestore.GatewayService.services.requests.ProductServiceRequestSingle;
import de.tanukihardwarestore.GatewayService.services.results.ComponentQueueResult;
import de.tanukihardwarestore.GatewayService.services.results.CurrencyServiceResult;
import de.tanukihardwarestore.GatewayService.services.results.PriceServiceResult;
import de.tanukihardwarestore.GatewayService.services.results.ProductServiceResult;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RabbitServiceImpl implements RabbitService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public List<RawProduct> getAllProducts(String userID) {
        ProductServiceRequest request = new ProductServiceRequest(userID);

        ProductServiceResult result = (ProductServiceResult) rabbitTemplate.convertSendAndReceive(RabbitConfig.PRODUCT_QUEUE_NAME, request);

        return result.getProductList();
    }

    @Override
    public RawProduct getOneProduct(String userID, long productID) {
        ProductServiceRequest request = new ProductServiceRequestSingle(userID, productID);

        ProductServiceResult result = (ProductServiceResult) rabbitTemplate.convertSendAndReceive(RabbitConfig.PRODUCT_QUEUE_NAME, request);

        return result.getProductList().get(0);
    }

    @Override
    public List<PCComponent> getAllComponents() {
        ComponentQueueResult result = (ComponentQueueResult) rabbitTemplate.convertSendAndReceive(RabbitConfig.COMPONENT_QUEUE_NAME, "GET ALL");

        return result.getPcComponentList();
    }

    @Override
    public PCComponent getOneComponent(long componentID) {
        PCComponent pcComponent = (PCComponent) rabbitTemplate.convertSendAndReceive(RabbitConfig.COMPONENT_QUEUE_NAME, "GET "+componentID);

        return pcComponent;
    }

    @Override
    public void postProduct(RawProduct product, String userID) {
        CreateProductRequest request = new CreateProductRequest(product, userID);

        rabbitTemplate.convertAndSend(RabbitConfig.PRODUCT_QUEUE_NAME, RabbitConfig.PRODUCT_QUEUE_NAME, request);
    }

    @Override
    public double calculatePrice(List<PCComponent> components) {
        PriceServiceResult result = (PriceServiceResult) rabbitTemplate.convertSendAndReceive(RabbitConfig.PRICE_QUEUE_NAME, components);

        return result.getTotal();
    }

    @Override
    public double calculateCurrency(double value, String inputCurrency, String expectedCurrency) {
        CurrencyServiceRequest request = new CurrencyServiceRequest(inputCurrency, expectedCurrency, value);
        CurrencyServiceResult result = (CurrencyServiceResult) rabbitTemplate.convertSendAndReceive(RabbitConfig.CURRENCY_QUEUE_NAME, request);

        return result.getPrice();
    }
}
