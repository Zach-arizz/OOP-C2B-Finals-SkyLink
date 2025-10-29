import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class SystemAdmin extends Person {
    private String adminId;
    private List<String> privileges;
    private Date lastBackupTimestamp;
    private boolean twoFactorEnabled;

    public SystemAdmin(long id, String firstname, String lastname, String contactNumber, String email, String address, String adminId) {
        super(id, firstname, lastname, contactNumber, email, address);

        this.adminId = adminId;
        this.privileges = new ArrayList<>();
        this.lastBackupTimestamp = null;
        this.twoFactorEnabled = false;
    }

    public void createUserAccount(String username, String role) {
        System.out.println("Creating User Account...");
    }

    public void deactivateUserAccount (String userId) {
        System.out.println("Deactivating User Account...");
    }

    public void performDatabaseBackup() {
        this.lastBackupTimestamp = new Date();
        System.out.println("Performing Database Backup...");
    }

    public void restoreDatabaseFromBackup(Date backupDate) {
        System.out.println("Restoring Database from Backup...");
    }

    public void configureSystemSetting(String key, String value) {
        System.out.println("Configuring System Settings...");
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public List<String> getPrivileges() {
        return privileges;
    }

    public void addPrivilege(String privilege) {
        this.privileges.add(privilege);
    }

    public Date getLastBackupTimestamp() {
        return lastBackupTimestamp;
    }

    public boolean isTwoFactorEnabled() {
        return twoFactorEnabled;
    }

    public void setTwoFactorEnabled(boolean twoFactorEnabled) {
        this.twoFactorEnabled = twoFactorEnabled;
    }
}
