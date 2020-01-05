package unipa.fooddelivery.controllers;

import unipa.fooddelivery.*;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
@RequestMapping("order")
public class OrderController {

    @GetMapping()
    public ModelAndView getOrdersView() {

        var orders = DataBase.getInstance().getOrders();

        var mav = new ModelAndView("index");
        mav.addObject("path", "orders");
        mav.addObject("orders", orders);
        return mav;
    }
}