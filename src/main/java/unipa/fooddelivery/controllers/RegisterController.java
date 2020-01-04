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
@RequestMapping("register")
public class RegisterController {

    @GetMapping()
    public ModelAndView getRegistervView() {
        var mav = new ModelAndView("index");
        mav.addObject("path", "register");
        return mav;
    }

    @PostMapping(value = "result")
    public @ResponseBody ModelAndView getRegisterResultView(
        @RequestParam(value = "username") final String username,
        @RequestParam(value = "password") final String password, @RequestParam(value = "name") final String name,
        @RequestParam(value = "surname") final String surname,
        @RequestParam(value = "birthdate") @DateTimeFormat(pattern = "yyyy-MM-dd") final Date birthdate,
        @RequestParam(value = "country") final String country,
        @RequestParam(value = "city") final String city,
        @RequestParam(value = "province") final String province,
        @RequestParam(value = "street") final String street,
        @RequestParam(value = "number") final String number,
        @RequestParam(value = "zip") final String zip,
        @RequestParam(value = "email") final String email,
        @RequestParam(value = "telephonenumber") final String telephoneNumber,
        @RequestParam(value = "registrationtype") final String registrationType,
        HttpSession session) {

        var mav = new ModelAndView("redirect:/");
        var address = new Address(country, city, province, street, number, zip);
        var user = User.getFactory(registrationType);

        user.setUsername(username);
        user.setPassword(password);
        user.setAddress(address);
        user.setBirthdate(birthdate);
        user.setEmail(email);
        user.setName(name);
        user.setSurname(surname);
        user.setTelephoneNumber(telephoneNumber);

        switch (registrationType) {
            case "Customer":
                DataBase.getInstance().getCustomers().add((Customer)user);
                DataBase.getInstance().saveChangesForEntity(Customer.class);
                break;
            case "DeliveryMan":
                DataBase.getInstance().getDeliverymen().add((DeliveryMan)user);
                DataBase.getInstance().saveChangesForEntity(DeliveryMan.class);
                break;
            case "RestaurantOwner":
                DataBase.getInstance().getRestaurantOwners().add((RestaurantOwner)user);
                DataBase.getInstance().saveChangesForEntity(RestaurantOwner.class);
                break;
            default:
                return mav;
        }
  
        session.setAttribute("user", user);
        return mav;
    }
}