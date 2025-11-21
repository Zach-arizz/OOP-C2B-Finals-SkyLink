import java.util.Collections;

public class Reward {
    // Properties (Fields)
    private final String rewardId;
    private String description;
    private final int pointsRequired;
    private int inventoryCount;
    private RewardType type;

    // Constructor
    public Reward(String rewardId, String description, int pointsRequired, int initialInventory, RewardType type) {
        if (rewardId == null || rewardId.trim().isEmpty()) {
            throw new IllegalArgumentException("Reward ID cannot be null or empty.");
        }
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null or empty.");
        }
        if (pointsRequired <= 0) {
            throw new IllegalArgumentException("Points required must be positive.");
        }
        if (initialInventory < 0) {
            throw new IllegalArgumentException("Initial inventory cannot be negative.");
        }
        if (type == null) {
            throw new IllegalArgumentException("Reward Type must be specified.");
        }

        this.rewardId = rewardId.trim();
        this.description = description.trim();
        this.pointsRequired = pointsRequired;
        this.inventoryCount = initialInventory;
        this.type = type;
    }

    // Methods
    public boolean isAvailable() {
        return this.inventoryCount > 0;
    }

    public boolean reserveForMember(String accountId) {
        if (accountId == null || accountId.trim().isEmpty()) {
            System.err.println("Cannot reserve reward: Account ID invalid.");
            return false;
        }
        if (isAvailable()) {
            // Logic to temporarily hold the reward for the account
            System.out.println("Reward " + rewardId + " reserved for account " + accountId);
            return true;
        }
        return false;
    }

    public void decrementInventory() {
        if (this.inventoryCount > 0) {
            this.inventoryCount--;
            System.out.println("Inventory decremented. Remaining: " + this.inventoryCount);
        } else {
            System.err.println("Cannot decrement inventory: Reward " + rewardId + " is out of stock.");
        }
    }

    public void restock(int amount) {
        if (amount <= 0) {
            System.err.println("Restock amount must be positive.");
            return;
        }
        this.inventoryCount += amount;
        System.out.println("Inventory restocked by " + amount + ". New total: " + this.inventoryCount);
    }

    public RewardInfo getRewardDetails() {
        System.out.println("Retrieving structured reward details.");
        return null;
    }

    // Getters and Setters
    public String getRewardId() {
        return rewardId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            System.err.println("Description cannot be set to null or empty.");
            return;
        }
        this.description = description.trim();
    }

    public int getPointsRequired() {
        return pointsRequired;
    }

    public int getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(int inventoryCount) {
        if (inventoryCount < 0) {
            System.err.println("Inventory count cannot be negative.");
            return;
        }
        this.inventoryCount = inventoryCount;
    }

    public RewardType getType() {
        return type;
    }

    public void setType(RewardType type) {
        if (type == null) {
            System.err.println("Reward Type cannot be set to null.");
            return;
        }
        this.type = type;
    }
}