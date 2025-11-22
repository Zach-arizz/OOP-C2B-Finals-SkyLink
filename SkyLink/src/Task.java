// FINALIZED
import java.util.Date;

public class Task {
    // Properties (Fields)
    private final String taskId;
    private final String description;
    private final Date dueDate;
    private TaskStatus status;
    private final long assignedToId;

    // Constructor
    public Task(String description, Date dueDate, long assignedToId) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Task description cannot be null or empty.");
        }
        if (dueDate == null) {
            throw new IllegalArgumentException("Due date must not be null.");
        }
        if (assignedToId <= 0) {
            throw new IllegalArgumentException("Assigned ID must be positive.");
        }
        this.taskId = "TASK-" + System.nanoTime();
        this.description = description.trim();
        this.dueDate = dueDate;
        this.assignedToId = assignedToId;
        this.status = TaskStatus.PENDING;
    }

    // Methods
    public void updateStatus (TaskStatus newStatus) {
        if (newStatus == null) {
            System.err.println("Cannot update task status to null.");
            return;
        }

        if (this.status != newStatus) {
            this.status = newStatus;
        }
    }

    // Getters and Setters
    public String getTaskId() {
        return taskId;
    }

    public String getDescription() {
        return description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public long getAssignedToId() {
        return assignedToId;
    }
}