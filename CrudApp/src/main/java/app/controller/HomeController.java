package app.controller;

import app.model.Product;
import app.model.ProductDetails;
import app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ProductService productService;

    // عرض الصفحة الرئيسية
    @GetMapping
    public String homePage(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "homePage"; // JSP → /WEB-INF/view/homePage.jsp
    }

    // عرض فورم إضافة منتج
    @GetMapping("/addProductForm")
    public String showAddForm(Model model) {
        Product product = new Product();
        ProductDetails details = new ProductDetails();

        // تهيئة قيم افتراضية لتجنب null
        details.setAvailable(false);
        details.setPrice(null);
        details.setManufacturer("");
        details.setName("");
        details.setExpirationDate(new Date());

        product.setProductDetails(details);
        model.addAttribute("product", product);
        return "addProductForm";
    }


    @PostMapping("/saveProduct")
    public String saveProduct(@Valid @ModelAttribute("product") Product product) {

        ProductDetails details = product.getProductDetails();

        if (details == null) {
            details = new ProductDetails();
            product.setProductDetails(details);
        }

        // اربط الاتجاهين
        details.setProduct(product);

        // خلي اسم التفاصيل = اسم المنتج
        details.setName(product.getName());

        productService.addProduct(product);

        return "redirect:/";
    }



    // عرض تفاصيل منتج معين
    @GetMapping("/showProductDetails")
    public String showProductDetails(@Valid @RequestParam("id") int id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "viewDetailsPage"; // JSP → /WEB-INF/view/viewProductDetails.jsp
    }

    @GetMapping("/showUpdateForm")
    public String showUpdateForm(@RequestParam("id") int id, Model model) {
        Product product = productService.getProductById(id);

        // مهم جدًا لإعادة الربط
        if (product.getProductDetails() != null) {
            product.getProductDetails().setProduct(product);
        }

        model.addAttribute("product", product);
        return "updateDetailsForm";
    }


    @PostMapping("/updateProduct")
    public String updateProduct(@ModelAttribute("product") Product product) {

        // اربط الـ ProductDetails مرة تانية بالـ Product
        if (product.getProductDetails() != null) {
            product.getProductDetails().setProduct(product);
        }

        // خليه ياخد نفس اسم المنتج الأساسي
        product.getProductDetails().setName(product.getName());

        productService.updateProduct(product);
        return "redirect:/";
    }




    // حذف منتج
    @GetMapping("/deleteProduct")
    public String deleteProduct(@RequestParam("id") int id) {
        productService.deleteProduct(id);
        return "redirect:/";
    }
}
