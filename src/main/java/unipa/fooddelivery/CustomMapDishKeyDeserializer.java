package unipa.fooddelivery;

import java.io.IOException;

import com.fasterxml.jackson.databind.*;

import unipa.fooddelivery.DataBase;
import unipa.fooddelivery.models.*;

public class CustomMapDishKeyDeserializer extends KeyDeserializer {

    @Override
    public Dish deserializeKey(String key, DeserializationContext ctxt) throws IOException {
        var id = Integer.parseInt(key);
        var dish = DataBase.getInstance().getDishes().stream().filter(x -> x.getId() == id).findFirst();

        if(dish.isPresent())
            return dish.get();
        
        return null;
    }

}