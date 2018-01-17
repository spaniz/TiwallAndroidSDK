package models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by 110 on 10/01/2018.
 */

public class TimeModel {
    public JSONArray list;
    public String text;

    public TimeModel parse(JSONObject timeJson)  {

        TimeModel timeModel=new TimeModel();
        if(timeJson!=null){
            timeModel.list=timeJson.optJSONArray("list");
            ArrayList<Integer> timeList=new ArrayList<>();
            if(  timeModel.list!=null){
                for(int i=0;i<timeModel.list.length();i++){
                    try {
                        timeList.add((Integer) timeModel.list.get(i));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            timeModel.text=timeJson.optString("text");

        }
        return timeModel;
    }
}
