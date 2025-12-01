import app.model.Product;
import app.model.ProductDetails;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.*;


public class ProductApiTest {

    private RestTemplate restTemplate = new RestTemplate();
    String url = "http://localhost:8080/AmazonApp/products";

    @Test
    public void addProductTest() throws Exception {
        ProductDetails details = new ProductDetails();
        details.setPrice(100.0);
        details.setAvailable(true);
        details.setManufacturer("ABC Corp");
        details.setExpirationDate(new Date());

        Product product = new Product();
        product.setName("Book");
        product.setProductDetails(details);

        details.setProduct(product);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Product> request = new HttpEntity<>(product, headers);

        ResponseEntity<Product> response = restTemplate.postForEntity(
                url + "product",
                request,
                Product.class
        );

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Book", response.getBody().getName());
    }

    @Test
    public void getProductTest() throws Exception {

        String getUrl = url + "product/1";
        ResponseEntity<Product> response =
                restTemplate.getForEntity(getUrl, Product.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

        System.out.println("Product name: " + response.getBody().getName());
        assertEquals("Book", response.getBody().getName());
    }

    @Test
    public void updateProductTest() throws Exception {

        ProductDetails details = new ProductDetails();
        details.setPrice(200.0);
        details.setAvailable(true);
        details.setManufacturer("XYZ Corp");
        details.setExpirationDate(new Date());

        Product product = new Product();
        product.setId(1);
        product.setName("Updated Book");
        product.setProductDetails(details);

        details.setProduct(product);


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Product> request = new HttpEntity<>(product, headers);


        ResponseEntity<Product> response = restTemplate.exchange(
                url + "product/1",
                HttpMethod.PUT,
                request,
                Product.class
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Updated Book", response.getBody().getName());
        assertEquals(Optional.of(200.0), response.getBody().getProductDetails().getPrice());
    }

    @Test
    public void deleteProductTest() throws Exception {

        int productId = 1;

        ResponseEntity<Void> response = restTemplate.exchange(
                url + "product/" + productId,
                HttpMethod.DELETE,
                null,
                Void.class
        );

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        ResponseEntity<Product[]> allProductsResponse = restTemplate.getForEntity(
                url + "products",
                Product[].class
        );
        Product[] products = allProductsResponse.getBody();
        assertNotNull(products);

        boolean exists = Arrays.stream(products)
                .anyMatch(p -> p.getId() == productId);
        assertFalse(exists);
    }

    @Test
    public void getAllProductsTest() throws Exception {

        ResponseEntity<Product[]> response = restTemplate.getForEntity(
                url + "products",
                Product[].class
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        Product[] products = response.getBody();
        assertNotNull(products);
        assertTrue(products.length >= 0);
        if (products.length > 0) {
            assertNotNull(products[0].getId());
            assertNotNull(products[0].getName());
        }
    }

    @Test
    public void getProductByNameTest() throws Exception {

        String productName = "Book";
        String urlWithParam = url + "products/name?name=" + URLEncoder.encode(productName, StandardCharsets.UTF_8);
        ResponseEntity<Product> response = restTemplate.getForEntity(
                urlWithParam,
                Product.class
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(productName, response.getBody().getName());
    }





}
