public class Person {
    private long id;
    private String firstName;
    private String lastName;
    private String contactNumber;
    private String email;
    private String address;

    public Person(long id, String firstName, String lastName, String contactNumber, String email, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
        this.email = email;
        this.address = address;
    }

    public String getFullname() {
        return this.firstName + " " + this.lastName;
    }

    public void updateContact(String contactNumber, String email) {
        this.contactNumber = contactNumber;
        this.email = email;
    }

    public String getContactInfo() {
        return "Contact Number: " + this.contactNumber + "\nEmail: " + this.email;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
