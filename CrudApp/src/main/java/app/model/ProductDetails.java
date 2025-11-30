package app.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "product_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @NotNull(message = "Expiration date is required")
    @Future(message = "Expiration date must be in the future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "expiration_date", nullable = false)
    private Date expirationDate;


    @NotBlank(message = "Manufacturer name is required")
    @Size(min = 2, message = "Manufacturer name must be at least 2 characters")
    @Column(name = "manufacturer", nullable = false)
    private String manufacturer;


    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than 0")
    @Column(name = "price", nullable = false)
    private Double price;


    @Column(name = "available", nullable = false)
    private boolean available;
}
