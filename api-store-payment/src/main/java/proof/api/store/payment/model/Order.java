package proof.api.store.payment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Orders")
@Data
public class Order {
    @Id
    @JsonProperty("id")
    private Long id;
    @JsonProperty("total")
    private Double total;
}
