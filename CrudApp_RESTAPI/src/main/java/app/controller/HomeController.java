package app.controller;

import app.exception.IllegalValueException;
import app.exception.ProductNotFoundException;
import app.model.Product;
import app.model.ProductDetails;
import app.service.ProductService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Api(tags = "Product Management", description = "Operations pertaining to products in AmazonApp")
@RestController
@RequestMapping("/products")
public class HomeController {

    @Autowired
  private ProductService productService;

    @PostMapping("/product")
    @ApiOperation(value = "Add a new product", notes = "Creates a product along with its details")
    public ResponseEntity<Product> insertProduct(@Valid @RequestBody Product product) {

        if (product.getProductDetails() != null) {
            product.getProductDetails().setProduct(product);
        }

        Product savedProduct = productService.addProduct(product);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedProduct);
    }


    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable int id,
            @Valid @RequestBody Product product) {

        if (product.getId() != id) {
            throw new IllegalArgumentException("Product ID mismatch between path and body");
        }

        if (product.getProductDetails() != null) {
            product.getProductDetails().setProduct(product);
        }

        Product updatedProduct = productService.updateProduct(product);

        return ResponseEntity.ok(updatedProduct);
    }


    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid product ID");
        }

        productService.deleteProduct(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();

        return ResponseEntity.ok(products);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid product ID");
        }

        Product product = productService.getProductById(id);

        return ResponseEntity.ok(product);
    }

    @GetMapping("/products/name")
    public ResponseEntity<Product> getProductByName(@RequestParam String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid product name");
        }

        Product product = productService.getProductByName(name);
        return ResponseEntity.ok(product);
    }










}


