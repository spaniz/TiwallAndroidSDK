package data;

import android.content.Context;
import android.widget.Toast;

import com.nsun.tiwall.tiwallsdk.R;

import cloud.cloudAgent;
import utilities.Utilities;

/**
 * Created by 110 on 07/01/2018.
 */

public class RequestManager {
    private Context context;
    private String versionName;


    public interface TaskListener{
        public void onFinished(Response result);
    }
    TaskListener agentTaskListener;

    public RequestManager(Context context, TaskListener agentTaskListener, String versionName) {
        this.context = context;
        this.agentTaskListener = agentTaskListener;
        this.versionName = versionName;
    }

    public void invoke(final String url) {
        //TODO
        if (!evaluateCache(url)) {
            cloudAgent.TaskListener reqManagerTaskListener = new cloudAgent.TaskListener() {
                @Override
                public void onFinished(String result) {
//                    //TODO save to cache
//                    CacheManager cacheManager = new CacheManager(context);
//                    cacheManager.insert(url, result);

                    //TODO
                    Response response = new Response(context, result, versionName);
                    agentTaskListener.onFinished(response);
                }
            };

            if (Utilities.checkNetworkConnection(context)) {
                cloudAgent crt = new cloudAgent(reqManagerTaskListener);
                crt.execute(url);
            }
//
//            //TODO
//            else
//                Toast.makeText(context, String.valueOf(R.string.message_connetion_lost), Toast.LENGTH_LONG).show();
        } //TODO read from cache
    }

    public String invoke(String url, String[] params) {
        //TODO
        return url;
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
