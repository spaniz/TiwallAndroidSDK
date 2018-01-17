package models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by 110 on 10/01/2018.
 */

public class PageSpecModel {
    public Integer duration;
    public ChannelSummaryListModel director;
    public ChannelSummaryListModel cast;
    public ChannelSummaryListModel writer;
    public ChannelSummaryListModel producer;
    public ChannelSummaryListModel translator;
    public String designer;
    public String dramaturge;
    public ChannelSummaryListModel othercast;
    public Integer min_age;


    public static PageSpecModel parseSpec(JSONObject pageSpecJson) {

        PageSpecModel pageSpecModel = new PageSpecModel();
        pageSpecModel.duration = pageSpecJson.optInt("duration");
        pageSpecModel.director = ChannelSummaryListModel.parse(pageSpecJson.optJSONObject("director"));
        pageSpecModel.cast = ChannelSummaryListModel.parse(pageSpecJson.optJSONObject("cast"));
        pageSpecModel.writer = ChannelSummaryListModel.parse(pageSpecJson.optJSONObject("writer"));
        pageSpecModel.producer = ChannelSummaryListModel.parse(pageSpecJson.optJSONObject("producer"));
        pageSpecModel.translator = ChannelSummaryListModel.parse(pageSpecJson.optJSONObject("translator"));
        pageSpecModel.designer = pageSpecJson.optString("designer");
        pageSpecModel.dramaturge = pageSpecJson.optString("dramaturge");
        pageSpecModel.othercast = ChannelSummaryListModel.parse(pageSpecJson.optJSONObject("othercast"));
        pageSpecModel.min_age = pageSpecJson.optInt("min_age");
        return pageSpecModel;
    }

}
