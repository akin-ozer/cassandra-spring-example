package akin.cassexample.demo.controlllers;

import akin.cassexample.demo.domains.formhelpers.CustomerImpl;
import akin.cassexample.demo.services.NameGetterService;
import akin.cassexample.demo.services.NameSetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;


@Controller
public class CustomerController {

    NameGetterService nameGetterService;
    NameSetterService nameSetterService;

    @Autowired
    public CustomerController(NameGetterService nameGetterService, NameSetterService nameSetterService) {
        this.nameGetterService = nameGetterService;
        this.nameSetterService = nameSetterService;
    }

    @GetMapping({"/"," ",""})
    public String get(Model model){
        model.addAttribute("customerImpl", new CustomerImpl());
        model.addAttribute("customer", nameGetterService.findAll());
        return "index";
    }

    @PostMapping({"/",""," "})
    public String set(@ModelAttribute CustomerImpl customerImpl){
        UUID id = UUID.randomUUID();
        customerImpl.setId(id);
        nameSetterService.addCustomer(customerImpl.getId(), customerImpl.getFirstName(),customerImpl.getLastName());
        return "redirect:/";
    }


}

