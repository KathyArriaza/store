package proof.api.store.orders.service;

import org.springframework.stereotype.Service;
import proof.api.store.orders.model.Product;
import proof.api.store.orders.model.dto.ProductDto;

@Service
public class ProductService {
    private final ProductClient productClient;

    public ProductService(ProductClient productClient) {
        this.productClient = productClient;
    }


    public ProductDto getProductById(Long id) {
        return productClient.getProductById(id);
    }

}
