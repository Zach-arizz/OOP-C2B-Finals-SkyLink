public abstract class PaymentMethod {
    // Properties (Fields)
    private final String methodType;
    private boolean isAuthorized;

    // Constructor
    public PaymentMethod(String methodType) {
        if (methodType == null || methodType.trim().isEmpty()) {
            throw new IllegalArgumentException("Method type cannot be null or empty.");
        }

        this.methodType = methodType.trim();
        this.isAuthorized = false;
    }

    public abstract boolean pay(double amount);

    public void authorizePayment() {
        if (!this.isAuthorized) {
            this.isAuthorized = true;
            System.out.println("Payment method authorized: " + methodType);
        }
    }

    public void cancelAuthorization() {
        if (this.isAuthorized) {
            this.isAuthorized = false;
            System.out.println("Payment method authorization cancelled: " + methodType);
        }
    }

    // Getters and Setters
    public String getMethodType() {
        return methodType;
    }

    public boolean isAuthorized() {
        return isAuthorized;
    }
}