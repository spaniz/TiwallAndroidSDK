package agents;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import dataprovider.RequestManager;
import dataprovider.Response;
import models.CategoryModel;
import params.CategoryListParams;

/**
 * Created by Farzane on 1/17/2018.
 */

public class CategoryAgent extends BaseAgent {
    Context context;
    public interface TaskListener {
        public void onFinished(ArrayList<CategoryModel> categoryModel);
    }

    public TaskListener activityTaskListener;

    public CategoryAgent(Context context, TaskListener activityTaskListener) {
        //TODO remove / from servicename or version or any other shits
        serviceName = "pages/";
        this.context = context;
        this.activityTaskListener = activityTaskListener;
    }
    public void get(CategoryListParams categoryListParams) {
        methodName = "categories";
        String url = urlGenerator(categoryListParams.createHashMap());
        Log.i("url",url);
        RequestManager requestManager = new RequestManager(context, new RequestManager.TaskListener() {
            @Override
            public void onFinished(Response result) {
                if (result.data != null && !result.data.isEmpty() && !result.data.equals("null")) {
                    try {
                        activityTaskListener.onFinished(CategoryModel.parseArray(new JSONArray(result.data)));
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
