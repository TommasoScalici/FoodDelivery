package unipa.fooddelivery.controllers;

import java.util.Hashtable;

import javax.servlet.http.*;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import unipa.fooddelivery.Utilities;

@Controller
@RequestMapping("{orderType}/payment")
public class PaymentController {

    @GetMapping()
    public ModelAndView getPaymentView(@PathVariable("orderType") final String orderType, HttpSession session) {
        var mav = new ModelAndView("index");

        if (orderType.equals("reservation")) {
            var dishes = Utilities.getDishesFromIDs((Hashtable<Long, Integer>)session.getAttribute("reservation"));
            mav.addObject("reservation", dishes);
        }

        if (orderType.equals("order")) {
            var dishes = Utilities.getDishesFromIDs((Hashtable<Long, Integer>)session.getAttribute("shoppingcart"));
            mav.addObject("shoppingcart", dishes);
        }

        mav.addObject("path", "payment");
        mav.addObject("orderType", orderType);

        return mav;
    }
}