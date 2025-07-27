package in.ankit.billingsoftware.service;

import com.razorpay.RazorpayException;
import in.ankit.billingsoftware.io.RazorpayOrderResponse;

public interface RazorpayService {
    RazorpayOrderResponse createOrder(Double amount, String currency) throws RazorpayException;

}
