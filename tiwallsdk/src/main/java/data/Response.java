package data;

import android.content.Context;
import android.util.Log;

import com.nsun.tiwall.tiwallsdk.R;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by 110 on 07/01/2018.
 */

public class Response {
    public String status;
    public Boolean ok;
    public String meta;
    public String data;
    public Error error;
    public   Boolean checkStatus;
    public Context context;

    Response(Context context, String result, String versionName) {
        this.context=context;

        try {
            JSONObject responseJsonObject = new JSONObject(result);
                Log.e("result","result"+result);
            if (result != null && !result.isEmpty() && !result.equals("null")) {
                // Log.e("versionName","versionName"+versionName);
                if (getCheckStatus(versionName,responseJsonObject).equals(true)) {
                    this.data = responseJsonObject.optString(context.getString(R.string.response_data));
                    if (this.data != null && !this.data.isEmpty() && !this.data.equals("null")) {
                        //  Log.e("versionresult","result"+result);
                    }
                    else{
                        //TODO error? theres no data?

                    }
                }
//                else  if(getCheckStatus(versionName,responseJsonObject).equals(false)){
//                    error = new Error();
//                    error.setCode(responseJsonObject.optString(context.getString(R.string.response_error_code)));
//                    error.setMessage(responseJsonObject.optString(context.getString(R.string.response_error_message)));
//                }
            }


            //TODO so what?!! connection fail?


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    public Boolean isSuccess(){
        if(status.equals(context.getString(R.string.response_success)))
            return true;
        else return false;
    }
    public Boolean getCheckStatus(String versionName,  JSONObject responseJsonObject){
        // Log.e("versionName11","versionName11"+versionName);
        if(versionName.equals(context.getString(R.string.version1))){
            this.status = responseJsonObject.optString(context.getString(R.string.response_status));
            if(this.status.equals(context.getString(R.string.response_success))){
                checkStatus = true;
            }else {
                checkStatus = false;
            }

        }
        if(versionName.equals(context.getString(R.string.version2))) {
            this.ok = responseJsonObject.optBoolean(context.getString(R.string.response_ok));
            if (this.ok.equals(true)) {
                checkStatus = true;
            } else {
                checkStatus = false;
            }
        }
        return checkStatus;
    }
}

