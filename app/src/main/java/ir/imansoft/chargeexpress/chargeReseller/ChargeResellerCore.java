package ir.imansoft.chargeexpress.chargeReseller;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

/**
 * Android ZarinPal SDK Library v0.1 Project.
 * Created by ImanX on 12/2/16.
 * Copyright Alireza Tarazani All Rights Reserved.
 */
public class ChargeResellerCore {

    private Context     context;
    private HTTPRequest onlineRequest;
    private USSDRequest ussdRequest;

    public ChargeResellerCore(Context context, HTTPRequest chargeResellerRequest) {
        this.context = context;
        this.onlineRequest = chargeResellerRequest;
    }

    public ChargeResellerCore(Context context, USSDRequest ussdRequest) {
        this.context = context;
        this.ussdRequest = ussdRequest;
    }


    public void payment() {

        if (this.ussdRequest != null) {
            dialUssd();
        } else {

        }

    }


    private void dialUssd() {
        Log.i("TAG ussd command" , this.ussdRequest.getCommandUssd());
        Uri ussdCommand = Uri.parse("tel:" + this.ussdRequest.getCommandUssd());
        this.context.startActivity(new Intent(Intent.ACTION_CALL, ussdCommand));
    }
}


