package main.controller;

import main.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class HomeController {

    @RequestMapping("/")
   public String home(Model model) {
       model.addAttribute("user", new User());
       return "homePage";
   }


    @RequestMapping("/processForm")
    public String login(@ModelAttribute ("user") User user, Model model) {

model.addAttribute("user", user);
        return "resultPage";
   }
}
