package proof.api.store.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import proof.api.store.orders.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
