/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Attraction;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Type;

public class AttractionAdapter extends TypeAdapter<Attraction> {

    private final Gson gson;

    public AttractionAdapter(Gson gson) {
        this.gson = gson;
    }

    @Override
    public void write(JsonWriter out, Attraction attraction) throws IOException {
        if (attraction == null) {
            out.nullValue();
            return;
        }
        out.beginObject();
        out.name("type").value(attraction.getClass().getName());
        out.name("properties").jsonValue(gson.toJson(attraction));
        out.endObject();
    }

    @Override
    public Attraction read(JsonReader in) throws IOException {
        JsonObject jsonObject = JsonParser.parseReader(in).getAsJsonObject();
        String className = jsonObject.get("type").getAsString();
        JsonElement element = jsonObject.get("properties");

        try {
            Class<?> clazz = Class.forName(className);
            return gson.fromJson(element, (Type) clazz);
        } catch (ClassNotFoundException e) {
            throw new JsonParseException(e);
        }
    }
}
