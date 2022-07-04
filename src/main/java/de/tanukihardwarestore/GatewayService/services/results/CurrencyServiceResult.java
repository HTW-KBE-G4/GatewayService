package de.tanukihardwarestore.GatewayService.services.results;

public class CurrencyServiceResult {

    private final double price;
    private final String currency;

    public CurrencyServiceResult(double price, String currency) {
        this.price = price;
        this.currency = currency;
    }

    public double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }
}
