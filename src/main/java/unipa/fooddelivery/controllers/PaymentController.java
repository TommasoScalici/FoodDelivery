package unipa.fooddelivery.controllers;

import java.util.*;

import javax.servlet.http.*;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import unipa.fooddelivery.*;
import unipa.fooddelivery.models.*;

@Controller
@RequestMapping("{orderType}/payment")
public class PaymentController {

    private Order order;
    private Reservation reservation;
    private Random random = new Random();

    @GetMapping()
    @SuppressWarnings("unchecked")
    public ModelAndView getPaymentView(@PathVariable("orderType") final String orderType, HttpSession session) {
        var mav = new ModelAndView("index");

        

        if (orderType.equals("reservation")) {
            var dishes = Utilities.getDishesFromIDs((Hashtable<Long, Integer>)session.getAttribute("reservation"));
            reservation = new Reservation();
            reservation.setDishesOrdered(dishes);
            mav.addObject("reservation", reservation);
        }

        if (orderType.equals("order")) {
            var dishes = Utilities.getDishesFromIDs((Hashtable<Long, Integer>)session.getAttribute("shoppingcart"));

            order = new Order();
            var deliveryFee = 1 + (5 - 1) * random.nextDouble();

            order.setDishesOrdered(dishes);
            order.setDeliveryFee(deliveryFee);

            mav.addObject("order", order);
        }

        mav.addObject("path", "payment");
        mav.addObject("orderType", orderType);
        
        return mav;
    }
}