package de.tanukihardwarestore.GatewayService.services.results;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyServiceResult implements Serializable {

    private double price;
    private String currency;

}