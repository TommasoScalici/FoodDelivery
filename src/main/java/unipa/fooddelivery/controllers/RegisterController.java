package unipa.fooddelivery.controllers;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import unipa.fooddelivery.DataBase;
import unipa.fooddelivery.models.*;

@Controller

public class RegisterController {

    @GetMapping(value = "/register")
    public ModelAndView getRegistervView() {
        var mav = new ModelAndView("index");
        mav.addObject("path", "register");
        return mav;
    }

    @PostMapping(value = "/register/result")
    public @ResponseBody ModelAndView getRegisterResultView(
        @RequestParam(value = "username") final String username,
        @RequestParam(value = "password") final String password, @RequestParam(value = "name") final String name,
        @RequestParam(value = "surname") final String surname,
        @RequestParam(value = "birthdate") @DateTimeFormat(pattern = "yyyy-MM-dd") final Date birthdate,
        @RequestParam(value = "address") final String address, @RequestParam(value = "email") final String email,
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