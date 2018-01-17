package dataprovider;

import android.app.Service;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

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

    Response(Context context, String result) {
        this.context=context;

        try {
            JSONObject responseJsonObject = new JSONObject(result);
            if (result != null && !result.isEmpty() && !result.equals("null")) {
                if (getCheckStatus(responseJsonObject).equals(true)) {
                    this.data = responseJsonObject.optString(context.getString(R.string.response_data));
                }
                else  if(getCheckStatus(responseJsonObject).equals(false)){
                    error = new Error();
                    error.setCode(responseJsonObject.optString(context.getString(R.string.response_error_code)));
                    error.setMessage(responseJsonObject.optString(context.getString(R.string.response_error_message)));
                }
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
    public Boolean getCheckStatus(JSONObject responseJsonObject){
            this.ok = responseJsonObject.optBoolean(context.getString(R.string.response_ok));
            if (this.ok.equals(true)) {
                checkStatus = true;
            } else {
                checkStatus = false;
            }
        return checkStatus;
    }

}

