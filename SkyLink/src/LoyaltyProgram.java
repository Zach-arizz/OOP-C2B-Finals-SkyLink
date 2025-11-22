// FINALIZED
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

public class LoyaltyProgram {
    // Properties (Fields)
    private final String programId;
    private String programName;
    private final Map<String, LoyaltyAccount> members;
    private final List<Reward> rewardsCatalog;
    private int pointExpiryDays;

    // Constructor
    public LoyaltyProgram(String id, String name, int expiry) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Program ID cannot be null or empty.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Program name cannot be null or empty.");
        }
        if (expiry <= 0) {
            throw new IllegalArgumentException("Point expiry days must be positive.");
        }

        this.programId = id.trim();
        this.programName = name.trim();
        this.pointExpiryDays = expiry;
        this.members = new HashMap<>();
        this.rewardsCatalog = new ArrayList<>();
    }

    // Methods
    public LoyaltyAccount enrollMember(Passenger passenger) {
        if (passenger == null) {
            System.err.println("Cannot enroll a null passenger.");
            return null;
        }

        String pId = String.valueOf(passenger.getId());

        if (this.members.containsKey(pId)) {
            System.out.println("Passenger is already enrolled.");
            return this.members.get(pId);
        }
        LoyaltyAccount account = new LoyaltyAccount(pId, this.programId);
        this.members.put(pId, account);
        System.out.println("Passenger " + pId + " enrolled successfully.");
        return account;
    }

    public void addPoints(String passengerId, int points) {
        if (points <= 0) {
            System.err.println("Points to add must be positive.");
            return;
        }

        LoyaltyAccount account = getAccount(passengerId);
        if (account != null) {
            account.addPoints(points);
            System.out.println(points + " points added to account " + passengerId);
        } else {
            System.err.println("Member account not found for ID: " + passengerId);
        }
    }

    public boolean redeemPoints(String passengerId, String rewardId) {
        if (rewardId == null || rewardId.trim().isEmpty()) {
            System.err.println("Reward ID cannot be empty.");
            return false;
        }

        LoyaltyAccount account = getAccount(passengerId);
        if (account != null) {
            System.out.println("Attempting to redeem reward " + rewardId + " for member " + passengerId);
            return true;
        }
        return false;
    }

    public LoyaltyAccount getAccount(String passengerId) {
        if (passengerId == null || passengerId.trim().isEmpty()) {
            return null;
        }
        return this.members.get(passengerId);
    }

    // Getters and Setters
    public String getProgramId() {
        return programId;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        if (programName == null || programName.trim().isEmpty()) {
            System.err.println("Program name cannot be set to null or empty.");
            return;
        }
        this.programName = programName.trim();
    }

    public Map<String, LoyaltyAccount> getMembers() {
        return Collections.unmodifiableMap(members);
    }

    public List<Reward> getRewardsCatalog() {
        return Collections.unmodifiableList(rewardsCatalog);
    }

    public int getPointExpiryDays() {
        return pointExpiryDays;
    }

    public void setPointExpiryDays(int pointExpiryDays) {
        if (pointExpiryDays <= 0) {
            System.err.println("Point expiry days must be positive.");
            return;
        }
        this.pointExpiryDays = pointExpiryDays;
    }
}