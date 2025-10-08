package main.controller;

import main.model.User;
import main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String showHomePage() {
        return "homePage";
    }

    @PostMapping("/saveUser")
    public String saveUser(HttpServletRequest request, User user, Model model) {

        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setEmail(request.getParameter("email"));
        user.setDateOfBirth(Date.valueOf(request.getParameter("dateOfBirth")));
        user.setCity(request.getParameter("city"));

    userService.saveUser(user);
        model.addAttribute("user", user);

        return "resultPage";
    }
}
