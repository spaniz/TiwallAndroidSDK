package models;

import org.json.JSONObject;

/**
 * Created by 110 on 10/01/2018.
 */

public class VenueModel {
    public Integer id;
    public String title;
    public String tel;
    public String address;
    public LocationModel location;
    public Integer channel_id;

    public static VenueModel parse(JSONObject venueJson){
        VenueModel venueModel=new VenueModel();
            venueModel.id = venueJson.optInt("id");
            venueModel.title = venueJson.optString("title");
            venueModel.tel = venueJson.optString("tel");
            venueModel.address = venueJson.optString("address");
            venueModel.location = LocationModel.parse(venueJson.optJSONObject("location"));
            venueModel.channel_id = venueJson.optInt("channel_id");
        return  venueModel;
    }
}
