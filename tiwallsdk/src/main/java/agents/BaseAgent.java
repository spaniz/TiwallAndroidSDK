package agents;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 110 on 07/01/2018.
 */

public class BaseAgent {
    String scheme = "https://";
    String baseUrl = "api.tiwall.com/";
    //versionName = context.getResources().getString(R.string.version1);
    String versionName = "v2/";
    String serviceName;
    String methodName;

    public String urlGenerator(HashMap<String, String> queryStringHashMap) {
        StringBuilder queryStringSB = new StringBuilder("");
        if (queryStringHashMap != null && !queryStringHashMap.isEmpty()) {
            queryStringSB.append("?");
            for (Map.Entry<String, String> entry : queryStringHashMap.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                queryStringSB.append("&").append(key).append("=").append(value);
            }
        }
        return new StringBuilder(scheme).append(baseUrl).append(versionName).append(serviceName).append(methodName).append(queryStringSB).toString();
    }
}