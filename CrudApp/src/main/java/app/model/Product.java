package app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column( name="name",nullable = false)
    @NotBlank(message = "Product Name is Required")
    private String name;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    @Valid
    private ProductDetails productDetails;
}
