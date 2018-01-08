package models;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by 110 on 07/01/2018.
 */

public class News {
    public String id;
    public String type;
    public String rootitr;
    public String title;
    public String urn;
    public String url;
    public String publishDatetime;
    public String image;
    public String audioUrl;
    public String videoUrl;
    public String subjectId;
    public String body;
    public String pageId;
    public String pagetitle;
    public String pageUrn;
    public String pagetitlePrefix;
    public String src;
    public String duration;
    public String publishDatetimeString;
    public String imagetStringhumb;
    public String imageBig;

    public String id_label = "id";
    public String type_label = "type";
    public String rootitr_label = "rootitr";
    public String title_label = "title";
    public String urn_label = "urn";
    public String url_label = "url";
    public String publishDatetime_label = "publish_datetime";
    public String image_label = "image";
    public String audioUrl_label = "audio_url";
    public String videoUrl_label = "video_url";
    public String subjectId_label = "subject_id";
    public String body_label = "body";
    public String pageId_label = "pageId";
    public String pagetitle_label = "pageTitle";
    public String pageUrn_label = "pageUrn";
    public String pagetitlePrefix_label = "pageTitlePrefix";
    public String src_label = "src";
    public String duration_label = "duration";
    public String publish_datetime_string_label = "publish_datetime_string";
    public String image_thumb_label = "image_thumb";
    public String image_big_label = "image_big";

    public void parse(JSONObject newsElement) {

        id = newsElement.optString(id_label);
        type = newsElement.optString(type_label);
        rootitr = newsElement.optString(rootitr_label);
        title = newsElement.optString(title_label);
        urn = newsElement.optString(urn_label);
        url = newsElement.optString(url_label);
        publishDatetime = newsElement.optString(publishDatetime_label);
        image = newsElement.optString(image_label);
        audioUrl = newsElement.optString(audioUrl_label);
        videoUrl = newsElement.optString(videoUrl_label);
        subjectId = newsElement.optString(subjectId_label);
        body = newsElement.optString(body_label);
        pageId = newsElement.optString(pageId_label);
        pagetitle = newsElement.optString(pagetitle_label);
        pageUrn = newsElement.optString(pageUrn_label);
        pagetitlePrefix = newsElement.optString(pagetitlePrefix_label);
        src = newsElement.optString(src_label);
        duration = newsElement.optString(duration_label);
        publishDatetimeString = newsElement.optString(publish_datetime_string_label);
        imagetStringhumb = newsElement.optString(image_thumb_label);
        imageBig = newsElement.optString(image_big_label);
    }

    public static ArrayList<News> parseArray(JSONArray response) {
        ArrayList<News> newsList = new ArrayList<>();


        for (int i = 0; i < response.length(); i++) {
            News news = new News();
            news.parse(response.optJSONObject(i));
            newsList.add(news);
        }
        Log.e("modelNews" , newsList.get(0).title);
        return newsList;
    }

    public static News parseElement(JSONObject response) {
        News news = new News();
        news.parse(response);
        return news;
    }


}
