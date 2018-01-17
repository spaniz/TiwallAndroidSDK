package params;

import java.util.HashMap;

/**
 * Created by Farzane on 1/17/2018.
 */

public class CategoryListParams {
    public String mode;

    public CategoryListParams(String mode) {
        this.mode = mode;
    }

    public HashMap<String, String> createHashMap() {
        HashMap<String, String> queryString = new HashMap<String, String>();
        if (this.mode != null) queryString.put("mode", String.valueOf(this.mode));
        return queryString;
    }
}