package unipa.fooddelivery.controllers;

import java.util.*;
import javax.servlet.http.*;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import unipa.fooddelivery.*;

@Controller
@RequestMapping(value = "reservation")
public class ReservationController {

	Hashtable<Long, Integer> dishesIDs = new Hashtable<>();

	@GetMapping()
	public ModelAndView getReservationView(HttpSession session) {

        var mav = new ModelAndView("index");
		var dishes = Utilities.getDishesFromIDs(dishesIDs);

		if(session.getAttribute("reservation") == null)
			session.setAttribute("reservation", dishesIDs);

        var previousReservations = DataBase.getInstance().getReservations();

        var anyDish = dishes.entrySet().stream().findFirst();

        if(anyDish.isPresent())
        {
            var dish = anyDish.get();
            var restaurant = dish.getKey().getRestaurant();
            mav.addObject("restaurant", restaurant);
        }

		
		mav.addObject("path", "reservation");
        mav.addObject("reservation", dishes); // Da non confondere con reservation in sessione...
        mav.addObject("reservations", previousReservations);
		return mav;
	}

	@GetMapping(value = "add/{id}")
    public String addDish(@PathVariable("id") long id, HttpServletRequest request, HttpSession session) {
		var optionalDish = DataBase.getInstance().getDishes().stream().filter(x -> x.getId() == id).findFirst();

		if(optionalDish.isPresent())
		{
			var dishId = optionalDish.get().getId();

			if(dishesIDs.get(dishId) == null)
				dishesIDs.put(dishId, 1);
			else
			{
				var count = dishesIDs.remove(dishId);
				dishesIDs.put(dishId, ++count);
			}
		}

		session.setAttribute("reservation", dishesIDs);
		var referer = request.getHeader("Referer");
		return "redirect:" + referer;
	}

	@RequestMapping(value = "sub/{id}")
	public String subtractDish(@PathVariable("id") long id, HttpServletRequest request, HttpSession session) {
		var optionalDish = DataBase.getInstance().getDishes().stream().filter(x -> x.getId() == id).findFirst();

		if(optionalDish.isPresent())
		{
			var dishId = optionalDish.get().getId();

			if(dishesIDs.get(dishId) != null)
			{
				var count = dishesIDs.remove(dishId);

				if(count > 1)
					dishesIDs.put(dishId, --count);
			}
		}

		session.setAttribute("reservation", dishesIDs);
		var referer = request.getHeader("Referer");
    	return "redirect:" + referer;
	}

	@RequestMapping(value = "del/{id}")
	public String deleteDish(@PathVariable("id") long id, HttpServletRequest request, HttpSession session) {
		var optionalDish = DataBase.getInstance().getDishes().stream().filter(x -> x.getId() == id).findFirst();

		if(optionalDish.isPresent())
		{
			var dishId = optionalDish.get().getId();

			if(dishesIDs.get(dishId) != null)
				dishesIDs.remove(dishId);
		}

		session.setAttribute("reservation", dishesIDs);
		var referer = request.getHeader("Referer");
    	return "redirect:" + referer;
	}


	public static boolean checkIfBusinessLogicValid(Hashtable<Long, Integer> dishesIDs)
	{
		var dishes = Utilities.getDishesFromIDs(dishesIDs).entrySet();
		return dishes.stream()
					 .map(x -> x.getKey().getRestaurant().getId())
					 .distinct()
					 .count() <= 1;
	}
}