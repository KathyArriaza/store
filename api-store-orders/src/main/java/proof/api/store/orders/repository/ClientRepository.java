package proof.api.store.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proof.api.store.orders.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
