package in.ankit.billingsoftware.io;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.services.s3.endpoints.internal.Value;

import java.util.SplittableRandom;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentVerificationRequest {

    private String razorpayOrderId;
    private String razorpayPaymentId;
    private String razorpaySignature;
    private String orderId;
}