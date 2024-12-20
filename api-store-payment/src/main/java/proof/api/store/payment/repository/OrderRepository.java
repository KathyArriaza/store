package proof.api.store.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proof.api.store.payment.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
