package proof.api.store.payment.model.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OrdenDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("total")
    private Double total;
}
