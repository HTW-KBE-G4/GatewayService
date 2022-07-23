package de.tanukihardwarestore.GatewayService.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.tanukihardwarestore.GatewayService.config.RabbitConfig;
import de.tanukihardwarestore.GatewayService.model.PCComponent;
import de.tanukihardwarestore.GatewayService.model.RawProduct;
import de.tanukihardwarestore.GatewayService.model.RawerProduct;
import de.tanukihardwarestore.GatewayService.services.requests.*;
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

    private ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public List<RawProduct> getAllProducts(String userID) {
        ProductServiceRequest request = new ProductServiceRequest(userID);

        String result = (String) rabbitTemplate.convertSendAndReceive(RabbitConfig.PRODUCT_QUEUE_NAME, request);
        ProductServiceResult productServiceResult;

        try {
            productServiceResult = objectMapper.readValue(result, ProductServiceResult.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return productServiceResult.getProductList();
    }

    @Override
    public RawProduct getOneProduct(String userID, long productID) {
        ProductServiceRequestSingle request = new ProductServiceRequestSingle(userID, productID);

        String result = (String) rabbitTemplate.convertSendAndReceive(RabbitConfig.SINGLE_PRODUCT_QUEUE, request);
        RawProduct rawProduct;

        try {
            rawProduct = objectMapper.readValue(result, RawProduct.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return rawProduct;
    }

    @Override
    public List<PCComponent> getAllComponents() {
        String result = (String) rabbitTemplate.convertSendAndReceive(RabbitConfig.COMPONENT_QUEUE_NAME, new GetAllComponentsRequest("GET ALL"));
        ComponentQueueResult componentQueueResult = new ComponentQueueResult();

        try {
            System.out.println("[Gateway-Service]: getAllComponents got String: " + result);
            componentQueueResult = objectMapper.readValue(result, ComponentQueueResult.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return componentQueueResult.getPcComponentList();
    }

    @Override
    public PCComponent getOneComponent(long componentID) {
        GetOneComponentRequest request = new GetOneComponentRequest(componentID);

        String result = (String) rabbitTemplate.convertSendAndReceive(RabbitConfig.SINGLE_COMPONENT_QUEUE, request);

        PCComponent pcComponent;

        try {
            pcComponent = objectMapper.readValue(result, PCComponent.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return pcComponent;
    }

    @Override
    public void postProduct(RawProduct product) {
        System.out.println("RabbitService: postProduct: got raw Product: "+product);
        String resultString = (String) rabbitTemplate.convertSendAndReceive(RabbitConfig.CREATE_PRODUCT_QUEUE, RabbitConfig.CREATE_PRODUCT_QUEUE, product);
        System.out.println("Got String vom postProduct: "+resultString);
    }

    @Override
    public double calculatePrice(List<PCComponent> components) {
        String result = (String) rabbitTemplate.convertSendAndReceive(RabbitConfig.PRICE_QUEUE_NAME, components);
        PriceServiceResult priceServiceResult;
        try {
            priceServiceResult = objectMapper.readValue(result, PriceServiceResult.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return priceServiceResult.getTotal();
    }

    @Override
    public double calculateCurrency(double value, String inputCurrency, String expectedCurrency) {
        CurrencyServiceRequest request = new CurrencyServiceRequest(inputCurrency, expectedCurrency, value);
        String result = (String) rabbitTemplate.convertSendAndReceive(RabbitConfig.CURRENCY_QUEUE_NAME, request);
        CurrencyServiceResult currencyServiceResult;
        try {
            currencyServiceResult = objectMapper.readValue(result, CurrencyServiceResult.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return currencyServiceResult.getPrice();
    }
}
