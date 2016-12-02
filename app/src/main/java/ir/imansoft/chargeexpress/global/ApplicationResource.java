package ir.imansoft.chargeexpress.global;


import android.content.Context;
import android.support.v4.content.ContextCompat;

/**
 * Android ZarinPal SDK Library v0.1 Project.
 * Created by ImanX on 12/2/16.
 * Copyright Alireza Tarazani All Rights Reserved.
 */
public class ApplicationResource {

    private static final String CHARGE_RESELLER_WEBSERVICE_ID = "582b5a96-377c-4121-adf2-60a75bef3768";
    private static final String CHARGER_RESLLER_DIAL_ID       = "126135";

    private static ApplicationResource instance;
    private static Context             context;


    public static void init(Context mContext) {
        context = mContext;
    }

    public static ApplicationResource getInstance() {
        if (instance == null) {
            instance = new ApplicationResource();
        }
        return instance;
    }

    public Context getContext() {
        return context;
    }


    public int getColor(int colorRes) {
        return ContextCompat.getColor(context, colorRes);
    }

    public ApplicationStorage getStorage() {
        return ApplicationStorage.getInstance(context);
    }


    public String getChargeResellerWebserviceId() {
        return CHARGE_RESELLER_WEBSERVICE_ID;
    }

    public String getChargerResllerDialId() {
        return CHARGER_RESLLER_DIAL_ID;
    }

}
