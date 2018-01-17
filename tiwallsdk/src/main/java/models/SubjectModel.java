package models;

import org.json.JSONObject;

/**
 * Created by 110 on 10/01/2018.
 */

public class SubjectModel {
    public Integer id;
    public String urn;
    public String parent_id;

    public static SubjectModel parse(JSONObject subjectJson){
        SubjectModel subjectModel=new SubjectModel();
            subjectModel.id=subjectJson.optInt("id");
            subjectModel.urn=subjectJson.optString("urn");
            subjectModel.parent_id=subjectJson.optString("parent_id");
        return subjectModel;
    }
}
