package params;

import android.util.Log;

import java.util.HashMap;

/**
 * Created by 110 on 13/01/2018.
 */
public class PageListParams {
    public String cat;
    public Integer tag_id;
    public String type;
    public String criteria;
    public Integer parent_id;
    public Boolean with_sale;
    public Boolean detail;

    public PageListParams(String cat,Integer tag_id,String type,String criteria,Integer parent_id,Boolean with_sale,Boolean detail )
    {
        this.cat=cat;
        this.tag_id = tag_id;
        this.type=type;
        this.criteria=criteria;
        this.parent_id=parent_id;
        this.with_sale=with_sale;
        this.detail=detail;
    }

    public HashMap<String, String> createHashMap() {
        HashMap<String, String> queryString = new HashMap<String, String>();
        if(this.cat != null) queryString.put("cat", String.valueOf(this.cat));
        if(this.tag_id != null) queryString.put("tag", String.valueOf(this.tag_id));
        if(this.type != null) queryString.put("type", String.valueOf(this.type));
        if(this.criteria != null) queryString.put("criteria", String.valueOf(this.criteria));
        if(this.parent_id != null) queryString.put("parent_id", String.valueOf(this.parent_id));
        if(this.with_sale != null) queryString.put("with_sale", String.valueOf(this.with_sale));
        if(this.detail != null) queryString.put("detail", String.valueOf(this.detail));
        return queryString;

    }
}
