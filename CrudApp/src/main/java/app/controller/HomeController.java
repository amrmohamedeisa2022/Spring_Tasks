package app.controller;

import app.model.Product;
import app.model.ProductDetails;
import app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ProductService productService;


    @GetMapping
    public String homePage(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "homePage";
    }



    @GetMapping("/addProductForm")
    public String showAddForm(Model model) {

        Product product = new Product();
        ProductDetails details = new ProductDetails();

        details.setManufacturer("");
        details.setPrice(null);
        details.setExpirationDate(new Date());
        details.setAvailable(false);

        product.setProductDetails(details);
        model.addAttribute("product", product);
        return "addProductForm";
    }


    @PostMapping("/saveProduct")
    public String saveProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult,Model model) {

        if (bindingResult.hasErrors()) {
            return "addProductForm";
        }

        ProductDetails details = product.getProductDetails();
        details.setProduct(product);

        productService.addProduct(product);
        return "redirect:/";
    }



    @GetMapping("/showProductDetails")
    public String showProductDetails(@Valid @RequestParam("id") int id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "viewDetailsPage";
    }

    @GetMapping("/showUpdateForm")
    public String showUpdateForm(@RequestParam("id") int id, Model model) {
        Product product = productService.getProductById(id);


        if (product.getProductDetails() != null) {
            product.getProductDetails().setProduct(product);
        }

        model.addAttribute("product", product);
        return "updateDetailsForm";
    }


    @PostMapping("/updateProduct")
    public String updateProduct(
            @Valid @ModelAttribute("product") Product product,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "updateDetailsForm";
        }

        product.getProductDetails().setProduct(product);

        productService.updateProduct(product);
        return "redirect:/";
    }

    @GetMapping("/deleteProduct")
    public String deleteProduct(@RequestParam("id") int id) {
        productService.deleteProduct(id);
        return "redirect:/";
    }
}
