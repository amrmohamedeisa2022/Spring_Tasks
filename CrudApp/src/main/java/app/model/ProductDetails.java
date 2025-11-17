package app.model;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetails {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "name")
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "expiration_date")
    private Date expirationDate;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "price")
    private double price;

    @Column(name = "available")
    private boolean available;

    public ProductDetails(boolean available, Date expirationDate, String manufacturer, String name, double price, Product product) {
        this.available = available;
        this.expirationDate = expirationDate;
        this.manufacturer = manufacturer;
        this.name = name;
        this.price = price;
        this.product = product;
    }
}
