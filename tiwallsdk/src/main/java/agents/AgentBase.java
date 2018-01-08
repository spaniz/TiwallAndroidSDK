package agents;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 110 on 07/01/2018.
 */

public class AgentBase {
    String scheme = "https://";
    String baseUrl = "api.tiwall.com/";
    String versionName = "v1/";
    String serviceName;
    String methodName;

    public String urlGenerator(HashMap<String, String> queryStringHashMap) {
        String queryString = "";
        if (queryStringHashMap != null && !queryStringHashMap.isEmpty()) {
            queryString = "?" + queryString;
            for (Map.Entry<String, String> entry : queryStringHashMap.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                queryString = queryString + "&" + key + "=" + value;
            }
        }
        return scheme + baseUrl + versionName + serviceName + methodName + queryString;
    }
}
