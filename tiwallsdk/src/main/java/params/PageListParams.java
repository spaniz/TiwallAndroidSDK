package params;

import android.util.Log;

import java.util.HashMap;

/**
 * Created by 110 on 13/01/2018.
 */
public class PageListParams {
    public Integer tag_id;

    public PageListParams(Integer tag_id) {
        this.tag_id = tag_id;
    }

    public HashMap<String, String> createHashMap() {
        HashMap<String, String> queryString = new HashMap<String, String>();
        if(this.tag_id != null) queryString.put("tag", String.valueOf(this.tag_id));
        return queryString;

    }
}
