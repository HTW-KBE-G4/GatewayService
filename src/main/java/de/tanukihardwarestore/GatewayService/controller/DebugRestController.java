package de.tanukihardwarestore.GatewayService.controller;

import de.tanukihardwarestore.GatewayService.model.PCComponent;
import de.tanukihardwarestore.GatewayService.model.PricedProduct;
import de.tanukihardwarestore.GatewayService.model.RawProduct;
import de.tanukihardwarestore.GatewayService.services.RabbitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/raw")
public class DebugRestController {

    @Autowired
    private RabbitServiceImpl rabbitService;

    @GetMapping("/component/{id}")
    public PCComponent getOneComponent(@PathVariable long id) {
        return rabbitService.getOneComponent(id);
    }

    @GetMapping("/components")
    public List<PCComponent> getAllComponents() {
        return rabbitService.getAllComponents();
    }

    @GetMapping("/product/{id}")
    public RawProduct getOneProduct(@PathVariable long id) {
        return rabbitService.getOneProduct("0", id);
    }

    @GetMapping("/products")
    public List<RawProduct> getAllProducts() {
        return rabbitService.getAllProducts("0");
    }
}
