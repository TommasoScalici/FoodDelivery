package unipa.fooddelivery.controllers;

import java.io.*;
import java.util.*;

import javax.servlet.http.*;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;

import org.springframework.format.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import unipa.fooddelivery.*;
import unipa.fooddelivery.models.*;

@Controller

public class RegisterController {

    @GetMapping(value = "/register")
    public ModelAndView getRegistervView() {
        ModelAndView mav = new ModelAndView("index");
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
        HttpSession session)
        throws JsonGenerationException, JsonMappingException, IOException {

        var mav = new ModelAndView("redirect:/");
        var customer = new Customer(username, password);
        customer.setAddress(address);
        customer.setBirthdate(birthdate);
        customer.setEmail(email);
        customer.setName(name);
        customer.setSurname(surname);
        customer.setTelephoneNumber(telephoneNumber);

        session.setAttribute("user", customer);

        var customers = DataBase.getInstance().getCustomers();
        customers.add(customer);
        var objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("./src/main/resources/static/json/customers.json"), customers);

        return mav;
    }


    


    
}