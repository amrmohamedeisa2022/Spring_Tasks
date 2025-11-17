package app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "product",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ProductDetails details;

    public Product(ProductDetails details, String name) {
        this.details = details;
        this.name = name;
    }
}
