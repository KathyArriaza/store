package proof.api.store.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proof.api.store.orders.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
