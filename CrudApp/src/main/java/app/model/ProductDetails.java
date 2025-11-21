package app.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
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

    @NotBlank(message = "Product name is required")
    @Column(name = "name", nullable = false)
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Expiration date is required")
    @Column(name = "expiration_date", nullable = false)
    private Date expirationDate;

    @NotBlank(message = "Manufacturer name is required")
    @Column(name = "manufacturer", nullable = false)
    private String manufacturer;

    @Positive(message = "Price must be greater than 0")
    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "available", nullable = false)
    private boolean available;


}