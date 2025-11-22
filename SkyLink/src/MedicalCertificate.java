// FINALIZED
import java.util.Date;

public record MedicalCertificate(String certificateNumber, String issuingAuthority, String classRating, Date expirationDate) {
}
