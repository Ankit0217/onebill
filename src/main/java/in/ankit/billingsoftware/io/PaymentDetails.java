package in.ankit.billingsoftware.io;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.services.s3.endpoints.internal.Value;

@Embeddable
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PaymentDetails {
    private String razorpayOrderId;
    private String razorpayPaymentId;
    private String razorpaySignature;
    private PaymentStatus status;

    public enum PaymentStatus {
        PENDING, COMPLETED, FAILED
    }
}
