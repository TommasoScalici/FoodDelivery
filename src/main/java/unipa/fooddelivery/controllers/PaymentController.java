package unipa.fooddelivery.controllers;

import java.time.*;
import java.util.*;

import javax.servlet.http.*;

import org.springframework.format.annotation.*;
import org.springframework.format.annotation.DateTimeFormat.*;
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
            var restaurant = dishes.entrySet().stream().findFirst().get().getKey().getRestaurant();

            reservation = new Reservation();
            reservation.setCustomer((Customer)session.getAttribute("user"));
            reservation.setDishesOrdered(dishes);
            reservation.setRestaurant(restaurant);

            mav.addObject("reservation", reservation);
        }

        if (orderType.equals("order")) {

            var dishes = Utilities.getDishesFromIDs((Hashtable<Long, Integer>)session.getAttribute("shoppingcart"));

            order = new Order();
            var deliveryFee = 1 + (5 - 1) * random.nextDouble();

            order.setCustomer((Customer)session.getAttribute("user"));
            order.setDishesOrdered(dishes);
            order.setDeliveryFee(deliveryFee);

            mav.addObject("order", order);
        }

        mav.addObject("path", "payment");
        mav.addObject("orderType", orderType);
        
        return mav;
    }

    @PostMapping("order/result")
    public @ResponseBody ModelAndView postOrderPaymentResultView(
        @RequestParam(value = "paymentmethod") final PaymentMethod paymentMethod,
        @RequestParam(value = "deliverydate") @DateTimeFormat(iso = ISO.DATE_TIME) final LocalDateTime deliveryDate,
        HttpSession session
    ) {
        session.removeAttribute("shoppingcart");
        
        order.setPaymentMethod(paymentMethod);
        order.setDeliveryDate(deliveryDate);
        order.setOrderDate(LocalDateTime.now());

        DataBase.getInstance().getOrders().add(order);
        DataBase.getInstance().saveChangesForEntity(Order.class);

        var mav = new ModelAndView("index");
        mav.addObject("path", "ordersuccess");
        return mav;
    }

    @PostMapping("reservation/result")
    public @ResponseBody ModelAndView postReservationPaymentResultView(
        @RequestParam(value = "paymentmethod") final PaymentMethod paymentMethod,
        @RequestParam(value = "reservationdate") @DateTimeFormat(iso = ISO.DATE_TIME) final LocalDateTime reservationDate,
        @RequestParam(value = "seatsnumber") final int seatsNumber,
        HttpSession session
    ) {
        session.removeAttribute("reservation");

        reservation.setPaymentMethod(paymentMethod);
        reservation.setReservationDate(reservationDate);
        reservation.setSeatsNumber(seatsNumber);

        var mav = new ModelAndView("index");
        mav.addObject("path", "reservationsuccess");
        return mav;
    }
}