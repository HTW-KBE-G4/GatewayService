package de.tanukihardwarestore.GatewayService.controller;

import de.tanukihardwarestore.GatewayService.model.RawProduct;
import de.tanukihardwarestore.GatewayService.model.PCComponent;
import de.tanukihardwarestore.GatewayService.model.PricedProduct;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class APIController {

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
    public PCComponent getOneComponent() {
        return null;
    }


    @PostMapping("/products/create")
    public void postProduct(RawProduct rawProduct) {
    }


}
