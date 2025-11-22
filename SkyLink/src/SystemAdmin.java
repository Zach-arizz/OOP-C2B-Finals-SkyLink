// FINALIZED
import java.util.List;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;

public class SystemAdmin extends Person {
    // Properties (Fields)
    private final List<String> privileges;
    private Date lastBackupTimestamp;
    private boolean twoFactorEnabled;

    // Constructor
    public SystemAdmin(long id, String firstName, String lastName, String contactNumber, String email, String address) {
        super(id, firstName, lastName, contactNumber, email, address);
        this.privileges = new ArrayList<>();
        this.twoFactorEnabled = true;
    }

    // Methods
    @Override
    public String getRoleDescription() {
        return "System Admin (ID: " + this.getId() + ", 2FA: " + (this.twoFactorEnabled ? "Enabled" : "Disabled") + ")";
    }

    public void createUserAccount(String username, String role) {
        if (username == null || username.trim().isEmpty() || role == null || role.trim().isEmpty()) {
            System.err.println("Cannot create user: Username and role must not be empty.");
            return;
        }
        System.out.println("Creating user account: " + username.trim() + " with role " + role.trim() + ".");
    }

    public void deactivateUserAccount(String userId) {
        if (userId == null || userId.trim().isEmpty()) {
            System.err.println("Cannot deactivate user: User ID must not be empty.");
            return;
        }
        System.out.println("Deactivating user account ID: " + userId.trim() + ".");
    }

    public void performDatabaseBackup() {
        this.lastBackupTimestamp = new Date();
        System.out.println("Database backup performed at " + this.lastBackupTimestamp);
    }

    public void restoreDatabaseFromBackup(Date backupDate) {
        if (backupDate == null) {
            System.err.println("Cannot restore database: Backup date is null.");
            return;
        }
        System.out.println("Restoring database from backup dated: " + backupDate);
    }

    public void configureSystemSetting(String key, String value) {
        if (key == null || key.trim().isEmpty() || value == null) {
            System.err.println("Cannot configure setting: Key must not be empty and value must not be null.");
            return;
        }
        System.out.println("Configuring system setting: Key=" + key.trim() + ", Value=" + value);
    }

    // Getters and Setters
    public List<String> getPrivileges() {
        return Collections.unmodifiableList(privileges);
    }

    public Date getLastBackupTimestamp() {
        return lastBackupTimestamp;
    }

    public void setLastBackupTimestamp(Date lastBackupTimestamp) {
        if (lastBackupTimestamp == null) {
            System.err.println("Backup timestamp cannot be set to null.");
            return;
        }
        this.lastBackupTimestamp = lastBackupTimestamp;
    }

    public boolean isTwoFactorEnabled() {
        return twoFactorEnabled;
    }

    public void setTwoFactorEnabled(boolean twoFactorEnabled) {
        this.twoFactorEnabled = twoFactorEnabled;
    }
}