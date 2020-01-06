package unipa.fooddelivery.controllers;

import unipa.fooddelivery.*;
import unipa.fooddelivery.models.*;

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
        var user = session.getAttribute("user");

        if(!(user instanceof Customer) || !(user instanceof DeliveryMan))
        {
            // Qui in teoria dovrebbe dare errore, ma come?
        }
            
        var orders = DataBase.getInstance().getOrders();

        
        mav.addObject("path", "orders");
        mav.addObject("orders", orders);
        return mav;
    }
}