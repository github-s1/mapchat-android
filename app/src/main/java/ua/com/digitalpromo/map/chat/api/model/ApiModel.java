package ua.com.digitalpromo.map.chat.api.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ales_san on 8/26/14.
 */
public interface ApiModel {
    public void parse(JSONObject o) throws JSONException;
}
