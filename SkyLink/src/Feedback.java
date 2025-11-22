// FINALIZED
public class Feedback {
    // Properties (Fields)
    private final String feedbackId;
    private final Passenger passenger;
    private int rating;
    private String comments;
    private boolean actionable;

    // Constructor
    public Feedback(String id, Passenger p, int rating, String comments) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Feedback ID cannot be null or empty.");
        }
        if (p == null) {
            throw new IllegalArgumentException("Passenger must be provided.");
        }
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5.");
        }
        if (comments == null || comments.trim().isEmpty()) {
            System.out.println("Warning: Feedback created without comments.");
            this.comments = "";
        } else {
            this.comments = comments.trim();
        }

        this.feedbackId = id.trim();
        this.passenger = p;
        this.rating = rating;
        this.actionable = isActionable();
    }

    // Methods
    public void updateFeedback(String comments, int rating) {
        if (rating < 1 || rating > 5) {
            System.err.println("Update failed: Rating must be between 1 and 5.");
            return;
        }
        if (comments != null) {
            this.comments = comments.trim();
        }
        this.rating = rating;
        this.actionable = isActionable(); // Update state when rating changes
        System.out.println("Feedback " + feedbackId + " updated. New rating: " + rating);
    }

    public String summarizeFeedback() {
        return "Rating: " + rating + "/5 - " + comments;
    }

    public boolean isActionable() {
        return this.rating < 3;
    }

    public void routeToDepartment(String department) {
        if (department == null || department.trim().isEmpty()) {
            System.err.println("Cannot route feedback: Department name is invalid.");
            return;
        }
        System.out.println("Routing feedback " + feedbackId + " to " + department.trim());
    }

    // Getters and Setters
    public String getFeedbackId() {
        return feedbackId;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if (rating < 1 || rating > 5) {
            System.err.println("Rating must be between 1 and 5.");
            return;
        }
        this.rating = rating;
        this.actionable = isActionable();
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        if (comments == null) {
            this.comments = "";
        } else {
            this.comments = comments.trim();
        }
    }
}