package proof.api.store.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proof.api.store.payment.model.Payment;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
