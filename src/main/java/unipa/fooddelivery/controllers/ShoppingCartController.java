package unipa.fooddelivery.controllers;

import java.util.*;
import java.util.Map.*;
import javax.servlet.http.*;

import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import unipa.fooddelivery.DataBase;
import unipa.fooddelivery.models.*;

@Controller
@RequestMapping(value = "/shoppingcart")
public class ShoppingCartController {

	Hashtable<Long, Integer> dishesIDs = new Hashtable<>();

	@GetMapping()
	public ModelAndView index(HttpSession session) {

		Hashtable<Dish, Integer> dishes = getDishesFromSession(session);

		var mav = new ModelAndView("index");
		mav.addObject("path", "shoppingcart");
		mav.addObject("shoppingcart", dishes); // Da non confondere con shoppingcart in sessione...
		return mav;
	}

	@GetMapping(value = "/add/{id}")
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

			var dishes = getDishesFromSession(session);
			if(!checkIfBusinessLogicValid(dishes.entrySet()))
			{
				dishesIDs.remove(dishId);
				session.setAttribute("error", "error");
			}
		}

		session.setAttribute("shoppingcart", dishesIDs);
		var referer = request.getHeader("Referer");
		return "redirect:" + referer;
	}

	@RequestMapping(value = "/sub/{id}")
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

		session.setAttribute("shoppingcart", dishesIDs);
		var referer = request.getHeader("Referer");
    	return "redirect:" + referer;
	}

	@RequestMapping(value = "/del/{id}")
	public String deleteDish(@PathVariable("id") long id, HttpServletRequest request, HttpSession session) {
		var optionalDish = DataBase.getInstance().getDishes().stream().filter(x -> x.getId() == id).findFirst();

		if(optionalDish.isPresent())
		{
			var dishId = optionalDish.get().getId();

			if(dishesIDs.get(dishId) != null)
				dishesIDs.remove(dishId);
		}

		session.setAttribute("shoppingcart", dishesIDs);
		var referer = request.getHeader("Referer");
    	return "redirect:" + referer;
	}


	private boolean checkIfBusinessLogicValid(Set<Entry<Dish, Integer>> dishes)
	{
		var count = dishes.stream()
					 .map(x -> x.getKey().getRestaurant().getId())
					 .distinct()
					 .count();
		return count <= 3;
	}

	private Hashtable<Dish, Integer> getDishesFromSession(HttpSession session)
	{
		Hashtable<Dish, Integer> dishes = new Hashtable<>();
		var dishesFromDB = DataBase.getInstance().getDishes();

		if(session.getAttribute("shoppingcart") == null)
			session.setAttribute("shoppingcart", dishesIDs);
			
		dishesIDs.forEach((k, v) -> {
			var optionalDish = dishesFromDB.stream().filter(x -> x.getId() == k).findFirst();

			if(optionalDish.isPresent())
				dishes.put(optionalDish.get(), v);
		});

		return dishes;
	}
}