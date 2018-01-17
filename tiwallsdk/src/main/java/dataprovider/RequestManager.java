package dataprovider;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.nsun.tiwall.tiwallsdk.R;

import utilities.Utilities;

/**
 * Created by 110 on 07/01/2018.
 */

public class RequestManager {
    public enum ReqType {
        GET("GET"),
        POST("POST"),;

        ReqType(String type) {
        }
    }
    private Context context;


    public interface TaskListener {
        public void onFinished(Response result);
    }

    TaskListener agentTaskListener;

    public RequestManager(Context context, TaskListener agentTaskListener) {
        this.context = context;
        this.agentTaskListener = agentTaskListener;
    }

    //TODO add params and cachFlag
    public void invoke(String url, ReqType Method, Boolean cacheFlag) {
        //TODO
        if (!evaluateCache(url)) {
            if (Utilities.checkNetworkConnection(context)) {
                CloudAgent.TaskListener reqManagerTaskListener = new CloudAgent.TaskListener() {
                    @Override
                    public void onFinished(String result) {
//                    //TODO save to cache
//                    CacheManager cacheManager = new CacheManager(context);
//                    cacheManager.insert(url, result);
                        //TODO
                        Response response = new Response(context, result);
                        agentTaskListener.onFinished(response);
                    }
                };
                CloudAgent crt = new CloudAgent(reqManagerTaskListener);
                crt.execute(url, String.valueOf(ReqType.GET), String.valueOf(cacheFlag));
            }
            //TODO
            else
                Toast.makeText(context, "ارتباط برقرار نشد!", Toast.LENGTH_LONG).show();
        }  //TODO read from cache
    }

    public Boolean evaluateCache(String url) {
        //TODO
        return false;
    }

    public String loadFromCache(String url) {
        //TODO
        return url;
    }

    public String saveToCache(String url) {
        //TODO
        return url;
    }
}