package params;

import android.util.Log;

import java.util.HashMap;

/**
 * Created by 110 on 13/01/2018.
 */

public class PaginationParams {
    public Integer count;
    public Integer offset;
    public Integer order_token;

    public PaginationParams(Integer count, Integer offset,Integer order_token) {
        this.count = count;
        this.offset = offset;
        this.order_token=order_token;
    }
    public HashMap<String, String> createHashMap() {
        HashMap<String, String> queryString = new HashMap<String, String>();
<<<<<<< HEAD
        if(this.count != null)
            queryString.put("count", String.valueOf(this.count));
        if(this.offset != null)
            queryString.put("offset", String.valueOf(this.offset));
=======
        if(this.count != null) queryString.put("count", String.valueOf(this.count));
        if(this.offset != null) queryString.put("offset", String.valueOf(this.offset));
        if(this.order_token != null) queryString.put("order_token", String.valueOf(this.order_token));
>>>>>>> 5c5034275b0504f12a7942300ff73ff10d50b641
        return queryString;
    }
}
