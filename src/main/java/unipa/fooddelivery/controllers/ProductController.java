package unipa.fooddelivery.controllers;

import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import unipa.fooddelivery.models.*;

@Controller
@RequestMapping(value = "product")
public class ProductController {

	@GetMapping(value = "/dish")
	public String index(ModelMap modelMap) {
		ProductList productList = new ProductList();
		modelMap.put("products", productList.findAll());
		return "product/index";
	}

}