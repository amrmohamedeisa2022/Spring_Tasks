package app.controller;

import app.model.Product;
import app.model.ProductDetails;
import app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    @Autowired
    private ProductService service;


    @GetMapping("/")
    public String listProducts(Model model) {
        model.addAttribute("productsList", service.getAllProducts());
        return "homePage";
    }


    @GetMapping("/addProduct")
    public String addProduct(Model model) {
        model.addAttribute("detailsModel", new ProductDetails());
        return "addProductForm";
    }


    @PostMapping("/processAddProduct")
    public String processAddProduct(@ModelAttribute("productModel") Product product) {
        service.insert(product);
        return "redirect:/";
    }


    @GetMapping("/updateProduct")
    public String updateProduct(@RequestParam("id") int id, Model model) {
        Product p = service.findById(id);
        ProductDetails details = p.getDetails();
        model.addAttribute("detailsModel", details);
        return "updateDetailsForm";
    }



    @PostMapping("/processUpdateProductForm")
    public String processUpdateProduct(@ModelAttribute("productModel") Product product) {
        service.insert(product);
        return "redirect:/";
    }


    @GetMapping("/showProductDetails")
    public String showDetails(@RequestParam("id") int id, Model model) {
        Product p = service.findById(id);
        model.addAttribute("productModel", p);
        return "viewDetailsPage";
    }


    @GetMapping("/deleteProduct")
    public String deleteProduct(@RequestParam("id") int id) {
        service.deletebyId(id);
        return "redirect:/";
    }
}
