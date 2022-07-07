package de.tanukihardwarestore.GatewayService.controller;

import de.tanukihardwarestore.GatewayService.model.RawProduct;
import de.tanukihardwarestore.GatewayService.model.PCComponent;
import de.tanukihardwarestore.GatewayService.model.PricedProduct;
import de.tanukihardwarestore.GatewayService.services.ProductBuilder;
import de.tanukihardwarestore.GatewayService.services.RabbitServiceImpl;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class APIController {


    @Autowired
    private RabbitServiceImpl rabbitService;

    @GetMapping("/products")
    public List<PricedProduct> getAllProcuts() {
        return null;
    }

    @GetMapping("/products/{id}")
    public PricedProduct getAProduct(@PathVariable long id) {
        return null;
    }

    @GetMapping("/components")
    public List<PCComponent> getAllComponents() {
        return null;
    }

    @GetMapping("/components/{id}")
    public PCComponent getOneComponent(@PathVariable Long id) {
        return null;
    }


    @PostMapping("/products/create")
    public void postProduct(RawProduct rawProduct) {
    }

    @GetMapping("/rabbit")
    public List<PCComponent> getRabbit() {
        List<PCComponent> pcComponent = rabbitService.getAllComponents();
        System.out.println("GOT COMPONENT IN GETMAPPING FROM BACKEND: "+pcComponent);
        return pcComponent;
    }
}
