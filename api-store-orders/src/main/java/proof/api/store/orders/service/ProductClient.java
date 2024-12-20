package proof.api.store.orders.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import proof.api.store.orders.model.Product;
import proof.api.store.orders.model.dto.ProductDto;

@FeignClient(name = "productClient", url = "${store.api.url}")
public interface ProductClient {
    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id);

}
