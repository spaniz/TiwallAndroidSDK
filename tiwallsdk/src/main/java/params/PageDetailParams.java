package params;

import android.util.Log;

import java.util.HashMap;

/**
 * Created by 110 on 13/01/2018.
 */

public class PageDetailParams {
    public Integer page_id;


    public PageDetailParams( Integer page_id) {
        this.page_id = page_id;
    }


    public HashMap<String, String> createHash(PageDetailParams pageDetailParams){
        HashMap<String, String> queryString = new HashMap<String, String>();
        queryString.put("id", String.valueOf(pageDetailParams.page_id));
        return queryString;

    }

}
