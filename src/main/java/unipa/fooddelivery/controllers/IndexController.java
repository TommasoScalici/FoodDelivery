package unipa.fooddelivery.controllers;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {
    
    @RequestMapping(value = "/")
    public String getIndex() {
        return "index";
    }
}