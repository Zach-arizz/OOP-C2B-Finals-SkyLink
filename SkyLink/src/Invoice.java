// FINALIZED
import java.util.Date;

public class Invoice {
    // Properties (Fields)
    private final String invoiceId;
    private final double baseAmount;
    private double taxAmount;
    private double discountedAmount;
    private final Date issueDate;

    // Constructor
    public Invoice(String invoiceId, double baseAmount) {
        if (invoiceId == null || invoiceId.trim().isEmpty()) {
            throw new IllegalArgumentException("Invoice ID cannot be null or empty.");
        }
        if (baseAmount <= 0) {
            throw new IllegalArgumentException("Base amount must be positive.");
        }

        this.invoiceId = invoiceId.trim();
        this.baseAmount = baseAmount;
        this.issueDate = new Date();
        this.taxAmount = 0.0;
        this.discountedAmount = 0.0;
    }

    // Methods
    public void generateInvoice() {
        System.out.println("--- Invoice " + invoiceId + " ---");
        printInvoiceDetails();
    }

    public void applyTax(double tax) {
        if (tax < 0) {
            System.err.println("Tax amount cannot be negative. Applying 0.0.");
            this.taxAmount = 0.0;
            return;
        }
        this.taxAmount = tax;
        System.out.println("Tax amount applied: " + tax);
    }

    public void applyDiscount(double discount) {
        if (discount < 0) {
            System.err.println("Discount cannot be negative. Applying 0.0.");
            this.discountedAmount = 0.0;
            return;
        }
        double maxDiscount = this.baseAmount;
        if (discount > maxDiscount) {
            System.out.println("Warning: Discount exceeds base amount. Capping discount at " + maxDiscount);
            this.discountedAmount = maxDiscount;
        } else {
            this.discountedAmount = discount;
        }
    }

    public void printInvoiceDetails() {
        System.out.println("Base: " + baseAmount);
        System.out.println("Tax: " + taxAmount);
        System.out.println("Discount: " + discountedAmount);
        System.out.println("Total: " + getFinalAmount());
    }

    public double getFinalAmount() {
        // Original logic: (Base + Tax) - Discount
        return (baseAmount + taxAmount) - discountedAmount;
    }

    // Getters and Setters
    public String getInvoiceId() {
        return invoiceId;
    }

    public double getBaseAmount() {
        return baseAmount;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.applyTax(taxAmount);
    }

    public double getDiscountedAmount() {
        return discountedAmount;
    }

    public void setDiscountedAmount(double discountedAmount) {
        this.applyDiscount(discountedAmount);
    }

    public Date getIssueDate() {
        return issueDate;
    }
}