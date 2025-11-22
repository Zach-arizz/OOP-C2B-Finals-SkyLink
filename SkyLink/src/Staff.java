// FINALIZED
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.time.LocalTime;

public class Staff extends Person {
    // Properties (Fields)
    private String role;
    private ShiftSchedule shiftSchedule;
    private EmploymentStatus employmentStatus;
    private final List<Task> assignedTasks;

    // Constructor
    public Staff(long id, String firstName, String lastName, String contactNumber, String email, String address,
                 String role) {
        super(id, firstName, lastName, contactNumber, email, address);
        if (role == null || role.trim().isEmpty()) {
            throw new IllegalArgumentException("Role cannot be null or empty.");
        }

        this.role = role.trim();
        this.employmentStatus = EmploymentStatus.INACTIVE;
        this.assignedTasks = new ArrayList<>();
    }

    // Methods
    @Override
    public String getRoleDescription() {
        return "Staff (Role: " + this.role + ", ID: " + this.getId() + ")";
    }

    public boolean clockIn() {
        if (this.employmentStatus != EmploymentStatus.ACTIVE) {
            this.employmentStatus = EmploymentStatus.ACTIVE;
            System.out.println(this.role + " " + getLastName() + " clocked in. Status: ACTIVE.");
            return true;
        }
        return false;
    }

    public boolean clockOut() {
        if (this.employmentStatus == EmploymentStatus.ACTIVE) {
            this.employmentStatus = EmploymentStatus.INACTIVE;
            System.out.println(this.role + " " + getLastName() + " clocked out. Status: INACTIVE.");
            return true;
        }
        return false;
    }

    public void assignTask(Task task) {
        if (task == null) {
            System.err.println("Cannot assign a null task.");
            return;
        }

        if (task.getAssignedToId() == this.getId()) {
            this.assignedTasks.add(task);
            System.out.println("Task " + task.getTaskId() + " assigned to " + this.getLastName() + ".");
        } else {
            System.out.println("Error: Task is assigned to a different person.");
        }
    }

    public void updateShift(ShiftSchedule schedule) {
        if (schedule == null) {
            System.err.println("Cannot update shift with a null schedule.");
            return;
        }

        this.shiftSchedule = schedule;
        System.out.println("Shift schedule updated for " + this.role + " to " + schedule.getShiftName() + ".");
    }

    public boolean isScheduledToWork() {
        if (this.shiftSchedule == null || this.employmentStatus != EmploymentStatus.ACTIVE) {
            return false;
        }
        return this.shiftSchedule.isDuringShift(LocalTime.now());
    }

    public void reportIssue(String issue) {
        if (issue == null || issue.trim().isEmpty()) {
            System.err.println("Cannot report an empty issue.");
            return;
        }
        System.out.println(this.role + " " + getLastName() + " reported an issue: " + issue);
    }

    // Getters and Setters
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        if (role == null || role.trim().isEmpty()) {
            System.err.println("Role cannot be set to null or empty.");
            return;
        }
        this.role = role.trim();
    }

    public ShiftSchedule getShiftSchedule() {
        return shiftSchedule;
    }

    public void setShiftSchedule(ShiftSchedule shiftSchedule) {
        this.shiftSchedule = shiftSchedule;
    }

    public EmploymentStatus getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(EmploymentStatus employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public List<Task> getAssignedTasks() {
        System.out.println("Returning " + this.assignedTasks.size() + " tasks for " + this.getLastName() + ".");
        return Collections.unmodifiableList(assignedTasks);
    }
}