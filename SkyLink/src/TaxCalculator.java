public class TaxCalculator {
    // Properties (Fields)
    private double baseTaxRate;
    private double airportFeeRate;
    private double fuelSurchargeRate;

    // Constructor
    public TaxCalculator(double base, double airport, double surcharge) {
        if (base < 0 || airport < 0 || surcharge < 0) {
            throw new IllegalArgumentException("Tax and fee rates cannot be negative.");
        }

        this.baseTaxRate = base;
        this.airportFeeRate = airport;
        this.fuelSurchargeRate = surcharge;
    }

    // Methods
    public double calculateTotalTax(double baseFare) {
        if (baseFare < 0) {
            System.err.println("Base fare must be non-negative.");
            return 0.0;
        }
        return calculateAirportFee(baseFare) + calculateFuelSurcharge(baseFare) + (baseFare * baseTaxRate);
    }

    public double calculateAirportFee(double baseFare) {
        if (baseFare < 0) return 0.0;
        return baseFare * airportFeeRate;
    }

    public double calculateFuelSurcharge(double baseFare) {
        if (baseFare < 0) return 0.0;
        return baseFare * fuelSurchargeRate;
    }

    public void updateTaxRates(double base, double airport, double surcharge) {
        if (base < 0 || airport < 0 || surcharge < 0) {
            System.err.println("Update failed: New tax and fee rates cannot be negative.");
            return;
        }

        this.baseTaxRate = base;
        this.airportFeeRate = airport;
        this.fuelSurchargeRate = surcharge;
        System.out.println("Tax rates updated successfully.");
    }

    // Getters and Setters
    public double getBaseTaxRate() {
        return baseTaxRate;
    }

    public void setBaseTaxRate(double baseTaxRate) {
        if (baseTaxRate < 0) {
            System.err.println("Base tax rate cannot be negative.");
            return;
        }
        this.baseTaxRate = baseTaxRate;
    }

    public double getAirportFeeRate() {
        return airportFeeRate;
    }

    public void setAirportFeeRate(double airportFeeRate) {
        if (airportFeeRate < 0) {
            System.err.println("Airport fee rate cannot be negative.");
            return;
        }
        this.airportFeeRate = airportFeeRate;
    }

    public double getFuelSurchargeRate() {
        return fuelSurchargeRate;
    }

    public void setFuelSurchargeRate(double fuelSurchargeRate) {
        if (fuelSurchargeRate < 0) {
            System.err.println("Fuel surcharge rate cannot be negative.");
            return;
        }
        this.fuelSurchargeRate = fuelSurchargeRate;
    }
}