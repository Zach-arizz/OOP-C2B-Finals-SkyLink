// FINALIZED
public abstract class Person {
    // Properties (Fields)
    private final long id;
    private String firstName;
    private String lastName;
    private String contactNumber;
    private String email;
    private String address;

    // Constructor
    public Person(long id, String firstName, String lastName, String contactNumber, String email, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
        this.email = email;
        this.address = address;
    }

    // Methods
    public abstract String getRoleDescription();

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public void updateContact(String contactNumber, String email) {
        if (contactNumber != null && !contactNumber.trim().isEmpty()) {
            this.contactNumber = contactNumber.trim();
        } else {
            System.err.println("Contact number cannot be empty.");
            return;
        }
        if (email != null && !email.trim().isEmpty()) {
            this.email = email.trim();
        } else {
            System.err.println("Email cannot be empty.");
            return;
        }
        System.out.println("Contact information updated for " + getFullName());
    }

    public String getContactInfo() {
        return "Email: " + this.email + ", Phone: " + this.contactNumber;
    }

    public void setAddress(String address) {
        if (address != null && !address.trim().isEmpty()) {
            this.address = address.trim();
            System.out.println("Address updated for " + getFullName());
        } else {
            System.err.println("Address cannot be empty.");
        }
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName != null && !firstName.trim().isEmpty()) {
            this.firstName = firstName.trim();
        } else {
            System.err.println("First name cannot be empty.");
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName != null && !lastName.trim().isEmpty()) {
            this.lastName = lastName.trim();
        } else {
            System.err.println("Last name cannot be empty.");
        }
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}