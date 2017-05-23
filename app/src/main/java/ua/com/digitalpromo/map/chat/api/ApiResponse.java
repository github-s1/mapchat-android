package ua.com.digitalpromo.map.chat.api;

/**
 * Created by ales_san on 8/26/14.
 */

import org.json.JSONObject;

/**
 * Class presenting answer from API
 */
public class ApiResponse {
    /**
     * Request which caused response
     */
    public ApiRequest request;
    /**
     * Json content of response. Can be array or object.
     */
    public JSONObject json;
    /**
     * String response from API
     */
    public String responseString;
}