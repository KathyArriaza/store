package proof.apistoreproduct.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import proof.apistoreproduct.exceptions.ProductNotFoundException;
import proof.apistoreproduct.model.Product;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final RestTemplate restTemplate;

    @Value("${store.api.url}")
    private String apiUrl;

    @Autowired
    public ProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public Product[] getAllProducts() {
        return restTemplate.getForObject(apiUrl, Product[].class);
    }

    public Product getProductById(Long id) {
        try {
            String url = apiUrl + "/" + id;
            Product product = restTemplate.getForObject(url, Product.class);

            if (product == null) {
                throw new ProductNotFoundException("Product not found with id: " + id);
            }

            return product;
        } catch (HttpClientErrorException.NotFound ex) {
            throw new ProductNotFoundException("Product not found with id: " + id, ex);
        } catch (RestClientException ex) {
            throw new RuntimeException("Failed to fetch product with id: " + id, ex);
        }
    }


}
