package ua.com.digitalpromo.map.chat.api.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ales_san on 8/27/14.
 */
public class Response extends Model implements ApiModel {
    public boolean success;

    @Override
    public void parse(JSONObject o) throws JSONException {

        Response r = this;
        String response = o.getString("response");
        r.success = response.equals("success");
    }
}
