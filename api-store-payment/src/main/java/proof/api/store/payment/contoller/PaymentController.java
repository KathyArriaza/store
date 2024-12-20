package proof.api.store.payment.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proof.api.store.payment.model.Dto.OrdenDto;
import proof.api.store.payment.model.Payment;
import proof.api.store.payment.service.PaymentService;

import java.util.Map;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/{orderId}")
    public Payment createPayment( @PathVariable Long orderId, @RequestBody Map<String, String> paymentRequest) {
        String paymentMethod = paymentRequest.get("paymentMethod");
        String status = paymentRequest.get("status");

        return paymentService.createPayment(orderId, paymentMethod, status);
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<?> getPaymentById(@PathVariable Long paymentId) {
        try {
            Payment payment = paymentService.getPaymentById(paymentId);
            return ResponseEntity.ok(payment);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

}
