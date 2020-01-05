package unipa.fooddelivery;

import java.io.*;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;

import unipa.fooddelivery.models.*;

public class CustomMapDishKeySerializer extends JsonSerializer<Dish> {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void serialize(Dish value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        var writer = new StringWriter();
        mapper.writeValue(writer, value.getId());
        gen.writeFieldName(writer.toString());
    }
}
