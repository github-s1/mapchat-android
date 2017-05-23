package ua.com.digitalpromo.map.chat.api.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ales_san on 10/16/14.
 */
public class Model {

    protected String getString(JSONObject o, String key) throws JSONException {
        String string = o.optString(key);
        if (string == null || string.equals("null")) {
            return null;
        } else return string;
    }

    protected Integer getInt(JSONObject o, String key) throws JSONException {
        return o.optInt(key);
    }
}
