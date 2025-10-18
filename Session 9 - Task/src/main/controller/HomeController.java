package main.controller;

import main.model.Employee;
import main.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/")
    public String showHomePage(Model model) {

        model.addAttribute(  "employee", new Employee());

        return "homePage";
    }

    @PostMapping("/processform")
    public String Login(@Valid @ModelAttribute ("employee") Employee employee, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(e -> System.out.println(e.getDefaultMessage()));
            return "homePage";
        }

        employeeService.saveEmployee(employee);
        model.addAttribute("employee", employee);

        return "resultPage";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        StringTrimmerEditor stringTrimmer = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, stringTrimmer);
    }
}
