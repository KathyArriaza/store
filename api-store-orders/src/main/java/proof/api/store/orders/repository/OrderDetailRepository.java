package proof.api.store.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proof.api.store.orders.model.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
