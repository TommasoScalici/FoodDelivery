package unipa.fooddelivery.controllers;

import javax.servlet.http.*;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import unipa.fooddelivery.*;

@Controller
public class LoginController 
{

    @GetMapping("login")
    public ModelAndView getLoginView() {
        var mav = new ModelAndView("index");
        mav.addObject("path", "login");
        return mav;
    }

    @GetMapping("logout")
    public ModelAndView getLogoutView(HttpSession session) {
        session.removeAttribute("user");
        var mav = new ModelAndView("index");
        mav.addObject("path", "logout");
        return mav;
    }

    @PostMapping("login/result")
    public @ResponseBody ModelAndView getLoginResultView(@RequestParam(value="username") final String username, 
                                                         @RequestParam(value="password") final String password,
                                                         HttpSession session) {

        var users = DataBase.getInstance().getAllUsers();

        var user = users.stream()
                        .filter(x -> x.getUsername().equals(username) && x.getPassword().equals(password))
                        .findFirst();

        if(user != null && user.isPresent())
        {
            ModelAndView mav = new ModelAndView("redirect:/");
            session.setAttribute("user", user.get());
            return mav;
        }
        else
        {
            ModelAndView mav = new ModelAndView("index");
            mav.addObject("path", "login");
            mav.addObject("showerror", true);
            return mav;
        }
    }
}