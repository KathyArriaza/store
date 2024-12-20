package proof.api.store.payment.contoller;


import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import proof.api.store.payment.service.OrdenService;
import proof.api.store.payment.model.Dto.OrdenDto;

@RestController
@RequestMapping("/api/orders")
public class OrdenController {
    private final OrdenService ordenService;

    public OrdenController(OrdenService ordenService) {
        this.ordenService = ordenService;
    }

    @GetMapping("/{orderId}")
    public OrdenDto getOrderById(@PathVariable Long orderId) {
        return ordenService.getOrderById(orderId);
    }

}
