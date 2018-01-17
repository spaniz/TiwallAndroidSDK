package params;

import android.util.Log;

import java.util.HashMap;

/**
 * Created by 110 on 13/01/2018.
 */

public class PaginationParams {
    public Integer count;
    public Integer offset;

    public PaginationParams(Integer count, Integer offset) {
        this.count = count;
        this.offset = offset;
    }
    public HashMap<String, String> createHashMap() {
        HashMap<String, String> queryString = new HashMap<String, String>();
        if(this.count != null)
            queryString.put("count", String.valueOf(this.count));
        if(this.offset != null)
            queryString.put("offset", String.valueOf(this.offset));
        return queryString;
    }
}
