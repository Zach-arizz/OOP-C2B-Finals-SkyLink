// FINALIZED
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

public class DiscountManager {
    // Properties (Fields)
    private final Map<String, Double> promoDiscountRates;
    private final LoyaltyProgram loyaltyProgram;
    private static final double POINT_VALUE = 0.01;

    // Constructor
    public DiscountManager(LoyaltyProgram loyaltyProgram) {
        if (loyaltyProgram == null) {
            throw new IllegalArgumentException("LoyaltyProgram must be provided.");
        }
        this.loyaltyProgram = loyaltyProgram;
        this.promoDiscountRates = new HashMap<>();
    }

    // Methods
    public double applyPromoCode(String code, double baseAmount) {
        if (baseAmount <= 0.0) {
            System.err.println("Base amount must be positive.");
            return 0.0;
        }

        if (validatePromoCode(code)) {
            double rate = promoDiscountRates.get(code);
            rate = Math.min(Math.max(rate, 0.0), 1.0);
            double discount = baseAmount * rate;
            System.out.println("Promo code " + code + " applied: " + (rate * 100) + "% discount.");
            return discount;
        }
        System.out.println("Promo code " + code + " is invalid or expired.");
        return 0.0;
    }

    public double applyLoyaltyPoints(Passenger passenger, double amount) {
        if (passenger == null || amount <= 0.0) {
            System.err.println("Cannot apply points: Passenger invalid or amount non-positive.");
            return 0.0;
        }
        int points = passenger.getLoyaltyPoints();
        double maxDiscountFromPoints = points * POINT_VALUE;
        double finalDiscount = Math.min(maxDiscountFromPoints, amount);
        System.out.printf("Points available: %d. Maximum discount: $%.2f. Applied discount: $%.2f.%n",
                points, maxDiscountFromPoints, finalDiscount);
        return finalDiscount;
    }

    public boolean validatePromoCode(String code) {
        if (code == null || code.trim().isEmpty()) {
            return false;
        }
        return promoDiscountRates.containsKey(code.trim());
    }

    public void addPromoCode(String code, double discountRate) {
        if (code == null || code.trim().isEmpty() || discountRate <= 0.0 || discountRate > 1.0) {
            System.err.println("Invalid promo code or discount rate (must be between 0.0 and 1.0).");
            return;
        }
        this.promoDiscountRates.put(code.trim(), discountRate);
        System.out.println("Promo code " + code.trim() + " added with rate " + (discountRate * 100) + "%.");
    }

    // Getters and Setters
    public Map<String, Double> getPromoDiscountRates() {
        return Collections.unmodifiableMap(promoDiscountRates);
    }

    public LoyaltyProgram getLoyaltyProgram() {
        return loyaltyProgram;
    }

    public static double getPointValue() {
        return POINT_VALUE;
    }
}