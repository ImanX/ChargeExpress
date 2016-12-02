package ir.imansoft.chargeexpress.webService;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import ir.imansoft.chargeexpress.global.ApplicationResource;

/**
 * Android ZarinPal v3.0 Project.
 * Created by ImanX on 8/22/16.
 * Copyright Alireza Tarazani All Rights Reserved.
 */
public class HttpQueue {
    private static HttpQueue    instance;
    private static RequestQueue queue;

    public static HttpQueue getInstance() {
        if (instance == null) {
            instance = new HttpQueue();
            queue = Volley.newRequestQueue(ApplicationResource.getInstance().getContext());
        }
        return instance;
    }

    public void addToRequest(Request request) {
        queue.add(request);
    }
}
