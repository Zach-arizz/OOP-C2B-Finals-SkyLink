import java.util.Date;

public class Document {
    // Properties (Fields)
    private final String documentType;
    private final String documentNumber;
    private final String issuedCountry;
    private final String holderName;
    private final Date expirationDate;
    private boolean isVerified;
    private String verificationOfficerId;

    // Constructor
    public Document(String documentType, String documentNumber, String issuedCountry, String holderName, Date expirationDate) {
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.issuedCountry = issuedCountry;
        this.holderName = holderName;
        this.expirationDate = (expirationDate != null) ? (Date) expirationDate.clone() : null;
        this.isVerified = false;
        this.verificationOfficerId = "N/A";
    }

    // Methods
    public boolean isExpired() {
        return expirationDate != null && expirationDate.before(new Date());
    }

    // Getters and Setters
    public String getDocumentType() {
        return documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public String getIssuedCountry() {
        return issuedCountry;
    }

    public String getHolderName() {
        return holderName;
    }

    public Date getExpirationDate() {
        return (expirationDate != null) ? (Date) expirationDate.clone() : null;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        this.isVerified = verified;
    }

    public String getVerificationOfficerId() {
        return verificationOfficerId;
    }

    public void setVerificationOfficerId(String verificationOfficerId) {
        this.verificationOfficerId = verificationOfficerId;
    }
}
