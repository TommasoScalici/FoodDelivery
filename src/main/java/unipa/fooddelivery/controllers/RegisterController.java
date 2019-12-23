package unipa.fooddelivery.controllers;

import java.util.*;

import javax.servlet.http.*;

import org.springframework.format.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import unipa.fooddelivery.DataBase;
import unipa.fooddelivery.models.*;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @GetMapping()
    public ModelAndView getRegistervView() {
        var mav = new ModelAndView("index");
        mav.addObject("path", "register");
        return mav;
    }

    @PostMapping(value = "/result")
    public @ResponseBody ModelAndView getRegisterResultView(
        @RequestParam(value = "username") final String username,
        @RequestParam(value = "password") final String password, @RequestParam(value = "name") final String name,
        @RequestParam(value = "surname") final String surname,
        @RequestParam(value = "birthdate") @DateTimeFormat(pattern = "yyyy-MM-dd") final Date birthdate,
        @RequestParam(value = "address") final String address, 
        @RequestParam(value = "email") final String email,
        @RequestParam(value = "telephonenumber") final String telephoneNumber,
        HttpSession session) {

        var mav = new ModelAndView("redirect:/");
        var customer = new Customer(username, password);
        customer.setAddress(address);
        customer.setBirthdate(birthdate);
        customer.setEmail(email);
        customer.setName(name);
        customer.setSurname(surname);
        customer.setTelephoneNumber(telephoneNumber);

        session.setAttribute("user", customer);

        DataBase.getInstance().getCustomers().add(customer);
        DataBase.getInstance().saveChangesForEntity(Customer.class);

        return mav;
    }
}