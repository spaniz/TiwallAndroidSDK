package models;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by 110 on 10/01/2018.
 */

public class PageModel {

    public Integer id;
    public String urn;

    public enum PageType {
        performance("performance"),
        exhibition("exhibition"),
        training("training"),
        conference("conference"),
        tour("tour"),
        event("event"),
        membership("membership"),
        book("book"),
        film("film"),
        music_album("music_album"),
        music_track("music_track"),
        product("product");

        private String pageTypeValue;

        PageType(String value) {
            this.pageTypeValue = value;
        }
    }

    public PageType type;

    public enum PageBehavior {
        event("event"),
        product("product");
        private String pageBehaviorValue;
        PageBehavior(String value) {
            this.pageBehaviorValue = value;
        }
    }
    public PageBehavior behavior;
    public String title;
    public String title_prefix;
    public Price price;
    public static class Price {
        public String text;
        public String desc;
        public ArrayList<Integer> priceList;
        public static Price parse(JSONObject priceJson) throws JSONException {
            Price price = new Price();
            price.text = priceJson.optString("text");
            price.desc = priceJson.optString("desc");
            JSONArray list = priceJson.optJSONArray("list");
            price.priceList = new ArrayList<>();
            for (int i = 0; i < list.length(); i++) {
                price.priceList.add((Integer) list.get(i));
            }
            return price;
        }
    }
    public Discount discount;
    public static class Discount {
        public String text;
        public static Discount parse(JSONObject discountJson) {
            Discount discount = new Discount();
            discount.text = discountJson.optString("text");
            return discount;
        }
    }
    public PageSpecModel spec;
    public Has has;
    public static class Has {
        public Boolean sale;
        public Boolean discount;
        public Boolean child_pages;
        public Boolean news;
        public Boolean photoalbum;
        public Boolean podcast;
        public Boolean video;
        public static Has parse(JSONObject hasJson) {
            Has has = new Has();
            has.sale = hasJson.optBoolean("sale");
            has.discount = hasJson.optBoolean("discount");
            has.child_pages = hasJson.optBoolean("child_pages");
            has.news = hasJson.optBoolean("news");
            has.photoalbum = hasJson.optBoolean("photoalbum");
            has.podcast = hasJson.optBoolean("podcast");
            has.video = hasJson.optBoolean("video");
            return has;
        }
    }
    public SaleModel sale;
    public SubjectModel subject;
    public ImageModel image;
    public ImageModel cover;
    public Integer parent_id;
    public String promo_desc;
    public String short_desc;
    public String desc;
    public static PageModel parse(JSONObject pageJson) {
        PageModel page = new PageModel();
        page.id = pageJson.optInt("id");
        page.urn = pageJson.optString("urn");
        page.type = PageType.valueOf(pageJson.optString("type"));
        page.behavior = PageBehavior.valueOf(pageJson.optString("behavior"));
        page.title = pageJson.optString("title");
        page.title_prefix = pageJson.optString("title_prefix");
        try {
            page.price = Price.parse(pageJson.getJSONObject("price"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            page.discount = Discount.parse(pageJson.getJSONObject("discount"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            //TODO pageespecModel null value for eventSepc
            switch (page.behavior){
                case event:
                   // page.spec = (EventSpecModel) page.spec;
                    page.spec = EventSpecModel.parse(pageJson.getJSONObject("spec"));
                    break;
                case product:
                    page.spec = PageSpecModel.parseSpec(pageJson.getJSONObject("spec"));
                    break;
                default:
                    page.spec = PageSpecModel.parseSpec(pageJson.getJSONObject("spec"));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            page.has = Has.parse(pageJson.getJSONObject("has"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            page.sale = SaleModel.parse(pageJson.getJSONObject("sale"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            page.subject = SubjectModel.parse(pageJson.getJSONObject("subject"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            page.image = ImageModel.parse(pageJson.getJSONObject("image"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            page.cover = ImageModel.parse(pageJson.getJSONObject("cover"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        page.parent_id = pageJson.optInt("parent_id");
        page.promo_desc = pageJson.optString("promo_desc");
        page.short_desc = pageJson.optString("short_desc");
        page.desc = pageJson.optString("desc");
        return page;
    }
    public static ArrayList<PageModel> parseArray(JSONArray pageJsonArray) {
        ArrayList<PageModel> pageArrayList = new ArrayList<>();
        for (int i = 0; i < pageJsonArray.length(); i++) {
            try {
                pageArrayList.add(PageModel.parse((JSONObject) pageJsonArray.get(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return pageArrayList;
    }
}