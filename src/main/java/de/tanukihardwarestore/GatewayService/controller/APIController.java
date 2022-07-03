package de.tanukihardwarestore.GatewayService.controller;

import de.tanukihardwarestore.GatewayService.model.RawProduct;
import de.tanukihardwarestore.GatewayService.model.PCComponent;
import de.tanukihardwarestore.GatewayService.model.PricedProduct;
import de.tanukihardwarestore.GatewayService.services.ProductBuilderService;
import de.tanukihardwarestore.GatewayService.services.RabbitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class APIController {

    // Remove! Just for testing purposes
    @GetMapping("/")
    public String index(Principal principal) {
        return principal.getName();
    }

    /*
    @Autowired
    private ProductBuilderService productBuilderService;

    @Autowired
    private RabbitService rabbitService;

    @GetMapping("/products")
    public List<PricedProduct> getAllProducts(@RequestParam String currency, Principal principal) {
        return this.productBuilderService.getAllProducts(principal.getName(), currency);
    }

    @GetMapping("/products/{id}")
    public PricedProduct getAProduct(@PathVariable long id, @RequestParam String currency, Principal principal) {
        return this.productBuilderService.getOneProduct(principal.getName(), id, currency);
    }

    @GetMapping("/components")
    public List<PCComponent> getAllComponents(@RequestParam String currency) {
        return this.productBuilderService.getAllComponents(currency);
    }

    @GetMapping("/components/{id}")
    public PCComponent getOneComponent(@PathVariable long id, @RequestParam String currency) {
        return this.productBuilderService.getOneComponent(id, currency);
    }


    @PostMapping("/products/create")
    public void postProduct(RawProduct rawProduct, Principal principal) {
        // Maybe return product or at least a boolean
        this.rabbitService.postProduct(rawProduct, principal.getName());
    }

    */
}
