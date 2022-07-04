package de.tanukihardwarestore.GatewayService.services.requests;

public class CurrencyServiceRequest {

    private String inputCurrency;
    private String expectedCurrency;
    private double value;

    public CurrencyServiceRequest(String inputCurrency, String expectedCurrency, double value) {
        this.inputCurrency = inputCurrency;
        this.expectedCurrency = expectedCurrency;
        this.value = value;
    }

    public String getInputCurrency() {
        return inputCurrency;
    }

    public String getExpectedCurrency() {
        return expectedCurrency;
    }

    public double getValue() {
        return value;
    }
}
