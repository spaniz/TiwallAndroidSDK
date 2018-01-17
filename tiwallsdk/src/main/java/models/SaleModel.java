package models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by 110 on 10/01/2018.
 */

public class SaleModel {
    public Boolean active;
    public  String method;
    public  String deliver_type;
    public  String start_datetime;
    public  String start_datetime_text;
    public  String desc;
    public  String url;

    public static SaleModel parse(JSONObject saleJson)  {
        SaleModel saleModel=new SaleModel();
            saleModel.active=saleJson.optBoolean("active");
            saleModel.method=saleJson.optString("method");
            saleModel.deliver_type=saleJson.optString("deliver_type");
            saleModel.start_datetime=saleJson.optString("start_datetime");
            saleModel.start_datetime_text=saleJson.optString("start_datetime_text");
            saleModel.desc=saleJson.optString("desc");
            saleModel.url=saleJson.optString("url");
        return  saleModel;
    }
}
