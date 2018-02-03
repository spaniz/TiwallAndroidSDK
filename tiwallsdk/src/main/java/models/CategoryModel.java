package models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Farzane on 1/17/2018.
 */

public class CategoryModel {
     public String key;
     public String text;
     public String color;
     public String image;


    public static CategoryModel parse(JSONObject categoryJson){
        CategoryModel categoryModel=new CategoryModel();
        categoryModel.key=categoryJson.optString("key");
        categoryModel.text=categoryJson.optString("text");
        categoryModel.color=categoryJson.optString("color");
        categoryModel.image=categoryJson.optString("image");
        return categoryModel;
    }

    public static ArrayList<CategoryModel> parseArray(JSONArray categoryJsonArray) {
        ArrayList<CategoryModel> categoryModelArrayList = new ArrayList<>();
        for (int i = 0; i < categoryJsonArray.length(); i++) {
            try {
                categoryModelArrayList.add(CategoryModel.parse((JSONObject) categoryJsonArray.get(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return categoryModelArrayList;
    }
}
