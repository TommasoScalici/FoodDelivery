package unipa.fooddelivery.controllers;

import javax.servlet.http.*;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import unipa.fooddelivery.*;

@Controller
public class LoginController 
{

    @GetMapping(value = "/login")
    public ModelAndView getLoginView() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("path", "login");
        return mav;
    }

    @GetMapping(value = "/logout")
    public ModelAndView getLogoutView(HttpSession session) {
        session.removeAttribute("user");
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("path", "logout");
        return mav;
    }

    @PostMapping(value = "/login/result")
    public @ResponseBody ModelAndView getLoginResultView(@RequestParam(value="username") final String username, 
                                                         @RequestParam(value="password") final String password,
                                                         HttpSession session) {
        var users = DataBase.getInstance().getCustomers();

        try {
            
            var user = users.stream()
                            .filter(x -> x.getUsername().equals(username) && x.getPassword().equals(password))
                            .findFirst();

            if(user.isPresent())
            {
                ModelAndView mav = new ModelAndView("redirect:/");
                session.setAttribute("user", user.get());
                return mav;
            }
            else
            {
                var mav = new ModelAndView("index");
                mav.addObject("path", "login");
                mav.addObject("showerror", true);
                return mav;
            }
        }    

        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}