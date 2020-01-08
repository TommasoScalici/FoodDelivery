package unipa.fooddelivery.controllers;

import unipa.fooddelivery.*;
import unipa.fooddelivery.models.*;

import java.util.stream.*;

import javax.servlet.http.*;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
@RequestMapping("order")
public class OrderController {

    @GetMapping()
    public ModelAndView getOrdersView(HttpSession session) {

        var mav = new ModelAndView("index");
        var user = (User)session.getAttribute("user");

        if(!(user instanceof Customer) || !(user instanceof DeliveryMan))
        {
            // Qui in teoria dovremmo restituire un 403 Forbidden
        }
            
        var orders = DataBase.getInstance().getOrders()
                             .stream()
                             .filter(x -> x.getCustomer().getId() == user.getId())
                             .collect(Collectors.toList());

        
        mav.addObject("path", "orders");
        mav.addObject("orders", orders);
        return mav;
    }
}