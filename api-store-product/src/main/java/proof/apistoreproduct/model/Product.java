package proof.apistoreproduct.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Product {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("description")
    private String description;
    @JsonProperty("category")
    private String category;
    @JsonProperty("image")
    private String image;
    @JsonProperty("rating")
    private Rating rating;

    @Data
    public static class Rating {
        @JsonProperty("rate")
        private Double rate;
        @JsonProperty("count")
        private Integer count;
    }
}
