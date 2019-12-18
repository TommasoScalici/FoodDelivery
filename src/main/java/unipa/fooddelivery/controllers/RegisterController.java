package unipa.fooddelivery.controllers;

import java.util.Date;

import javax.servlet.http.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import unipa.fooddelivery.models.User;

@Controller

public class RegisterController 
{


    @GetMapping(value = "/register")
    public ModelAndView getRegistervView() 
    {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("path", "register");
        return mav;
    }
    
  
    @PostMapping(value = "/register/result") 
    public @ResponseBody ModelAndView getRegisterResultView(
        @RequestParam(value="username") final String username, 
        @RequestParam(value="password") final String password,
        @RequestParam(value="name") final String name, 
        @RequestParam(value="surname") final String surname,


        @RequestParam(value="birthdate") 
        @DateTimeFormat (pattern = "yyyy-mm-dd") final Date birthdate,

        
        @RequestParam(value="address") final String address,
        @RequestParam(value="email") final String email,
        @RequestParam(value="telephonenumber") final String telephoneNumber,

    HttpSession session) 
    {
        ModelAndView mav = new ModelAndView("redirect:/");
        User user = new User(username, password);
        user.setAddress(address);
        user.setBirthdate(birthdate);
        user.setEmail(email);
        user.setName(name);
        user.setSurname(surname);
        user.setTelephoneNumber(telephoneNumber);

        session.setAttribute("user", user);
        return mav;
    }


    


    
}