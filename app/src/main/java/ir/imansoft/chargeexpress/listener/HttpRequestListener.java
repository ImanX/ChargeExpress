package ir.imansoft.chargeexpress.listener;

import org.json.JSONObject;

/**
 * Created by ImanX on 6/3/2016.
 */
public interface HttpRequestListener {
    void onSuccessResponse(JSONObject jsonObject, String contentResponse);

    void onFailureResponse(int httpStatusCode, String dataError);
}
