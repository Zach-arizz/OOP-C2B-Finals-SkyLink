// FINALIZED
import java.util.Date;

public class LoyaltyAccount {
    // Properties (Fields)
    private final String accountId;
    private final String passengerId;
    private final String programId;
    private int pointsBalance;
    private final Date enrollmentDate;

    // Constructor
    public LoyaltyAccount(String passengerId, String programId) {
        if (passengerId == null || passengerId.trim().isEmpty()) {
            throw new IllegalArgumentException("Passenger ID is required for account creation.");
        }
        if (programId == null || programId.trim().isEmpty()) {
            throw new IllegalArgumentException("Program ID is required for account creation.");
        }
        this.accountId = "ACC-" + passengerId + "-" + System.currentTimeMillis();
        this.passengerId = passengerId.trim();
        this.programId = programId.trim();
        this.pointsBalance = 0;
        this.enrollmentDate = new Date();
    }

    // Methods
    public void addPoints(int points) {
        if (points <= 0) {
            System.err.println("Points must be positive to add.");
            return;
        }
        this.pointsBalance += points;
        System.out.println("Added " + points + " points. New balance: " + this.pointsBalance);
    }

    public boolean deductPoints(int points) {
        if (points <= 0) {
            System.err.println("Points must be positive to deduct.");
            return false;
        }
        if (this.pointsBalance >= points) {
            this.pointsBalance -= points;
            System.out.println("Deducted " + points + " points. New balance: " + this.pointsBalance);
            return true;
        } else {
            System.out.println("Deduction failed. Insufficient points (Current: " + this.pointsBalance + ").");
            return false;
        }
    }

    // Getters and Setters
    public String getAccountId() {
        return accountId;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public String getProgramId() {
        return programId;
    }

    public int getPointsBalance() {
        return pointsBalance;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }
}