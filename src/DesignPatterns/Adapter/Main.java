package DesignPatterns.Adapter;

public class Main {
    public static void main(String[] args) {

        CurrencyExchangeCommand command = new CurrencyExchangeCommand(
                new EuroAdapter()
        );
        command.execute();
    }
}

// ------------ Part of a library ------------
class EuroConverterLibrary {
    public double convertUsdToEuro(double usdAmount) {
        return usdAmount * 0.93; // Example conversion rate
    }
}
// -------------------------------------------

class CurrencyExchangeCommand {
    private CurrencyConverter converter;
    public CurrencyExchangeCommand(CurrencyConverter converter) {
        this.converter = converter;
    }

    public void execute() {
        double usdAmount = 100.0; // Example amount in USD
        double convertedAmount = this.converter.convertUsd(usdAmount);
        System.out.println("Converted $100 USD to " + convertedAmount + " EUR");
    }
}

interface CurrencyConverter {
    double convertUsd(double usdAmount);
}

class UsdToCadConverter implements CurrencyConverter {
    @Override
    public double convertUsd(double usdAmount) {
        return usdAmount * 1.25;
    }
}

// Adapter for the EuroConverterLibrary
class EuroAdapter implements CurrencyConverter {
    private EuroConverterLibrary euroConverter = new EuroConverterLibrary();

    @Override
    public double convertUsd(double usdAmount) {
        return euroConverter.convertUsdToEuro(usdAmount);
    }
}
