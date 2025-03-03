package de.tanukihardwarestore.GatewayService.services.results;

import de.tanukihardwarestore.GatewayService.model.RawProduct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductServiceResult implements Serializable {

    private List<RawProduct> productList;
}
