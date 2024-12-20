package proof.api.store.payment.service;

import org.springframework.cloud.openfeign.FeignClient;

import proof.api.store.payment.model.Dto.OrdenDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "productClient", url = "${store.api.url}")
public interface OrdenClient {

    @GetMapping("/{orderId}")
    public OrdenDto getOrderById(@PathVariable Long orderId);
}
