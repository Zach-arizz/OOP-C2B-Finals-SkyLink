import java.util.List;
import java.util.ArrayList;

class ShiftSchedule {}
class EmploymentStatus {}
class Task {}

public class Staff extends Person {

    private String staffId;
    private String role;
    private ShiftSchedule shiftSchedule;
    private EmploymentStatus employmentStatus;

    public Staff(long id, String firstName, String lastName, String contactNumber, String email, String address, String staffId, String role, ShiftSchedule shiftSchedule, EmploymentStatus employmentStatus) {
        super(id, firstName, lastName, contactNumber, email, address);

        this.staffId = staffId;
        this.role = role;
        this.shiftSchedule = shiftSchedule;
        this.employmentStatus = employmentStatus;
    }

    public boolean clockIn() {
        System.out.println(getFullName() + " has clocked in for their shift.");
        return true;
    }

    public boolean clockOut() {
        System.out.println(getFullName() + " has clocked out. See you next time!");
        return true;
    }

    public void updateShift(ShiftSchedule schedule) {
        this.shiftSchedule = schedule;
        System.out.println(getFullName() + "'s shift schedule has been updated.");
    }

    public List<Task> getAssignedTasks() {
        System.out.println(getFullName() + " currently has no assigned tasks.");
        return new ArrayList<>();
    }

    public void reportIssue(String issue) {
        System.out.println(getFullName() + " reported an issue: " + issue);
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ShiftSchedule getShiftSchedule() {
        return shiftSchedule;
    }

    public EmploymentStatus getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(EmploymentStatus employmentStatus) {
        this.employmentStatus = employmentStatus;
    }
}
