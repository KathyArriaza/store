package proof.api.store.payment.service;

import org.springframework.stereotype.Service;
import proof.api.store.payment.model.Dto.OrdenDto;

@Service
public class OrdenService {
    private final OrdenClient ordenClient;

    public OrdenService(OrdenClient ordenClient) {
        this.ordenClient = ordenClient;
    }
    public OrdenDto getOrderById(Long id) {
        return ordenClient.getOrderById(id);
    }
}
