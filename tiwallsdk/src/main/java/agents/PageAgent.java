package agents;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import dataprovider.RequestManager;
import dataprovider.Response;
import models.PageModel;
import params.PageDetailParams;
import params.PageListParams;
import params.PaginationParams;

/**
 * Created by 110 on 07/01/2018.
 */

public class PageAgent extends BaseAgent {

    Context context;
    public HashMap<String, String> listQueryString;

    public interface TaskListener {
        public void onFinished(ArrayList<PageModel> pageList);

        public void onFinished(PageModel page);
    }

    public TaskListener activityTaskListener;

    public PageAgent(Context context, TaskListener activityTaskListener) {
        //TODO remove / from servicename or version or any other shits
        serviceName = "pages/";
        this.context = context;
        this.activityTaskListener = activityTaskListener;
    }

    //get List Page
    public void get(PaginationParams paginationParams, PageListParams pageListParams) {
        methodName = "list";

        listQueryString = new HashMap<>();
        listQueryString.putAll(paginationParams.createHashMap());
        listQueryString.putAll(pageListParams.createHashMap());
        String url = urlGenerator(listQueryString);

        RequestManager requestManager = new RequestManager(context, new RequestManager.TaskListener() {
            @Override
            public void onFinished(Response result) {
                if (result.data != null && !result.data.isEmpty() && !result.data.equals("null")) {
                    try {
                        activityTaskListener.onFinished(PageModel.parseArray(new JSONArray(result.data)));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                //TODO
            }
        });
        requestManager.invoke(url, RequestManager.ReqType.GET, false);
    }

    //get Detail
    public void get(PageDetailParams pageDetailParams) {

        methodName = "get";

        String url = urlGenerator(pageDetailParams.createHash(pageDetailParams));
        RequestManager requestManager = new RequestManager(context, new RequestManager.TaskListener() {
            @Override
            public void onFinished(Response result) {
                Log.e("method", result.data + "****");
                if (result.data != null && !result.data.isEmpty() && !result.data.equals("null")) {
                    try {
                        activityTaskListener.onFinished(PageModel.parse(new JSONObject(result.data)));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                //TODO
            }
        });
        requestManager.invoke(url, RequestManager.ReqType.GET, false);
    }


}

