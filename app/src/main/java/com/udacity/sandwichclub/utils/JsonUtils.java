package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    final static String MAIN_OBJECT = "name";
    final static String MAIN_NAME = "mainName";
    final static String ALSO_KNOWN_AS = "alsoKnownAs";
    final static String PLACE_OF_ORIGIN = "placeOfOrigin";
    final static String DESCRIPTION = "description";
    final static String IMAGE_URL = "image";
    final static String INCREDIENTS = "ingredients";


    public static Sandwich parseSandwichJson(String json) {

        Sandwich sandwich = new Sandwich();
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject nameObject = jsonObject.getJSONObject(MAIN_OBJECT);
            sandwich.setMainName(nameObject.getString(MAIN_NAME));
            JSONArray alsoKnownAs = nameObject.getJSONArray(ALSO_KNOWN_AS);
            List<String> also = new ArrayList<>();
            for (int i = 0; i < alsoKnownAs.length(); i++) {
                also.add(alsoKnownAs.getString(i));
            }
            sandwich.setAlsoKnownAs(also);
            sandwich.setPlaceOfOrigin(jsonObject.getString(PLACE_OF_ORIGIN));
            sandwich.setDescription(jsonObject.getString(DESCRIPTION));
            sandwich.setImage(jsonObject.getString(IMAGE_URL));
            JSONArray jsonArray = jsonObject.getJSONArray(INCREDIENTS);
            List<String> incredietns = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                incredietns.add(jsonArray.getString(i));
            }
            sandwich.setIngredients(incredietns);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return sandwich;
    }
}
