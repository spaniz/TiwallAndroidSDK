package models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by 110 on 10/01/2018.
 */

public class ChannelSummaryListModel {
    public JSONArray list;
    public String text;

    public static ChannelSummaryListModel parse(JSONObject channelSummaryListJson)  {

        ChannelSummaryListModel channelSummaryListModel=new ChannelSummaryListModel();
        if(channelSummaryListJson!=null) {
            channelSummaryListModel.list = channelSummaryListJson.optJSONArray("list");
            ArrayList<String> channelSummaryList = new ArrayList<>();
            if (channelSummaryListModel.list != null) {
                for (int i = 0; i < channelSummaryListModel.list.length(); i++) {
                    try {
                        channelSummaryList.add((String) channelSummaryListModel.list.get(i));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        if (channelSummaryListModel.text != null) {
            channelSummaryListModel.text=channelSummaryListJson.optString("text");
        }
        return channelSummaryListModel;
    }
}
