package proof.api.store.orders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import proof.api.store.orders.model.Client;
import proof.api.store.orders.model.Order;
import proof.api.store.orders.model.OrderDetail;
import proof.api.store.orders.model.Product;
import proof.api.store.orders.model.dto.ProductDto;
import proof.api.store.orders.repository.ClientRepository;
import proof.api.store.orders.repository.OrderDetailRepository;
import proof.api.store.orders.repository.OrderRepository;
import proof.api.store.orders.repository.ProductRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
   private final OrderRepository orderRepository;
    @Autowired
    private final OrderDetailRepository orderDetailRepository;
    @Autowired
    private final ClientRepository clientRepository;

    private final ProductClient productClient;

    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, OrderDetailRepository orderDetailRepository, ClientRepository clientRepository, ProductClient productClient, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.clientRepository = clientRepository;
        this.productClient = productClient;
        this.productRepository = productRepository;
    }



    @Transactional
    public Order createOrder(Long clientId, List<Long> productIds) {

        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));


        double total = 0.0;
        List<OrderDetail> orderDetails = new ArrayList<>();

        for (Long productId : productIds) {

            ProductDto productDto = productClient.getProductById(productId);


            Product product = new Product();
            product.setId(productDto.getId());
            product.setTitle(productDto.getTitle());
            product.setPrice(productDto.getPrice());


            Product savedProduct = productRepository.save(product);


            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setProduct(savedProduct);
            orderDetails.add(orderDetail);


            total += savedProduct.getPrice();
        }


        Order order = Order.builder()
                .client(client)
                .status("NEW")
                .created(LocalDateTime.now())
                .total(total)
                .orderDetails(orderDetails)
                .build();


        orderDetails.forEach(detail -> detail.setOrder(order));
        orderRepository.save(order);

        return order;
    }

    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found with ID: " + orderId));
    }

}
