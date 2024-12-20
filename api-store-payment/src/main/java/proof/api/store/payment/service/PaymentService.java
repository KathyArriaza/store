package proof.api.store.payment.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.stereotype.Service;
import proof.api.store.payment.model.Dto.OrdenDto;
import proof.api.store.payment.model.Order;
import proof.api.store.payment.model.Payment;
import proof.api.store.payment.model.PaymentMethod;
import proof.api.store.payment.repository.OrderRepository;
import proof.api.store.payment.repository.PaymentRepository;

import java.util.List;

@Service
public class PaymentService {
    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;
    private final OrdenClient ordenClient;

    @Autowired
    public PaymentService(OrderRepository orderRepository, PaymentRepository paymentRepository, OrdenClient ordenClient) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
        this.ordenClient = ordenClient;

    }

    @Transactional
    public Payment createPayment(Long orderId, String paymentMethod, String status) {

        OrdenDto orderDto = ordenClient.getOrderById(orderId);
        Order order = new Order();
        order.setId(orderDto.getId());
        order.setTotal(orderDto.getTotal());
        Order savedOrder = orderRepository.save(order);


        Payment payment = Payment.builder()
                .order(savedOrder)
                .paymentMethod(PaymentMethod.valueOf(paymentMethod))
                .Status(status)
                .build();
        paymentRepository.save(payment);

        return payment;
    }

    public Payment getPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId)
                .orElseThrow(() -> new IllegalArgumentException("Payment not found with ID: " + paymentId));
    }

}
