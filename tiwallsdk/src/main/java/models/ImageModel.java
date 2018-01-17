package models;

import org.json.JSONObject;

/**
 * Created by 110 on 10/01/2018.
 */

public class ImageModel {
    public String thumb_url;
    public String normal_url;
    public String big_url;

    public static ImageModel parse(JSONObject imageJson){
        ImageModel imageModel=new ImageModel();
            imageModel.thumb_url=imageJson.optString("thumb_url");
            imageModel.normal_url=imageJson.optString("normal_url");
            imageModel.big_url=imageJson.optString("big_url");
        return imageModel;
    }
}
