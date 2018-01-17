package models;

import org.json.JSONObject;

/**
 * Created by 110 on 10/01/2018.
 */

public class LocationModel {
    public float latitude;
    public float longitude;
    public String latlong;

    public static LocationModel parse(JSONObject locationJson){
        LocationModel locationModel=new LocationModel();
        if(locationJson!=null){
            locationModel.latitude=locationJson.optLong("latitude");
            locationModel.longitude=locationJson.optLong("longitude");
            locationModel.latlong=locationJson.optString("latlong");
        }
        return locationModel;
    }
}
