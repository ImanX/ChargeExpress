package ir.imansoft.chargeexpress.global;

import android.app.Application;

/**
 * Android ZarinPal SDK Library v0.1 Project.
 * Created by ImanX on 12/2/16.
 * Copyright Alireza Tarazani All Rights Reserved.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationResource.init(this);
    }
}
