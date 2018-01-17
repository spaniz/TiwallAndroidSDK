package agents;

import android.content.Context;
import android.util.Log;

import com.nsun.tiwall.tiwallsdk.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import dataprovider.RequestManager;
import dataprovider.Response;
import models.News;

/**
 * Created by 110 on 07/01/2018.
 */

public class NewsAgent extends BaseAgent {

Context context;

    public interface TaskListener {
        public void onFinished(ArrayList<News> newsArrayList);
        public void onFinished(News news);
    }
    public TaskListener activityTaskListener;
    public NewsAgent(Context context , TaskListener activityTaskListener) {
        serviceName = "news/";
        this.context = context;
        versionName = context.getResources().getString(R.string.version1);
        this.activityTaskListener = activityTaskListener;
    }


    public void getNewsList() {
        methodName = "getLatestNews";
        String url = urlGenerator(null);

        RequestManager requestManager = new RequestManager(context, new RequestManager.TaskListener() {
            @Override
            public void onFinished(Response result) {
                Log.e("method",result.data+"****");
                if (result.data != null && !result.data.isEmpty() && !result.data.equals("null")) {
                    try {
                        activityTaskListener.onFinished(News.parseArray(new JSONArray(result.data)));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        requestManager.invoke( url, RequestManager.ReqType.GET,false);
    }


}

