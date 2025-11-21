import java.util.Date;

public record RewardInfo(String rewardId, String name, RewardType type, int requiredPoints, int currentStock,
                         Date expirationDate) {
    // Constructor
    public RewardInfo {
        if (rewardId == null || rewardId.trim().isEmpty()) {
            throw new IllegalArgumentException("Reward ID is required.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name is required.");
        }
        if (type == null) {
            throw new IllegalArgumentException("Reward type must be specified.");
        }
        if (requiredPoints <= 0) {
            throw new IllegalArgumentException("Required points must be positive.");
        }
        if (currentStock < 0) {
            throw new IllegalArgumentException("Current stock cannot be negative.");
        }
    }

    // Methods
    public boolean isExpired() {
        if (expirationDate == null) {
            return false;
        }
        return expirationDate.before(new Date());
    }
}