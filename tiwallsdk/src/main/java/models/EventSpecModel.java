package models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by 110 on 10/01/2018.
 */

public class EventSpecModel extends PageSpecModel {
    public String start_date;
    public String end_date;
    public String start_date_text;
    public String end_date_text;
    public TimeModel time;

    public VenueModel venue;

    public static  EventSpecModel parse(JSONObject eventSpecJson){
        EventSpecModel eventSpecModel=new EventSpecModel();
        EventSpecModel.parseSpec(eventSpecJson);
        eventSpecModel.start_date=eventSpecJson.optString("start_date");
        eventSpecModel.end_date=eventSpecJson.optString("end_date");
        eventSpecModel.start_date_text=eventSpecJson.optString("start_date_text");
        eventSpecModel.end_date_text=eventSpecJson.optString("end_date_text");

        if(eventSpecJson.optJSONObject("venue")!=null)
            eventSpecModel.venue=VenueModel.parse(eventSpecJson.optJSONObject("venue"));

        return eventSpecModel;

    }


}
