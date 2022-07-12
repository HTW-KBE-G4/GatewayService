package de.tanukihardwarestore.GatewayService.services.requests;

import com.fasterxml.jackson.annotation.JsonGetter;
import de.tanukihardwarestore.GatewayService.model.RawProduct;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class CreateProductRequest implements Serializable {
    private RawProduct product;
    private String userID;

    public CreateProductRequest(RawProduct product, String userID) {
        this.product = product;
        this.userID = userID;
    }
}
