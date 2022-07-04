package de.tanukihardwarestore.GatewayService.services.results;

public class PriceServiceResult {

    private double total;

    public PriceServiceResult(double total) {
        this.total = total;
    }

    public double getTotal() {
        return total;
    }
}
