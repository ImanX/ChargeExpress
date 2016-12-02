package ir.imansoft.chargeexpress.activities;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import ir.imansoft.chargeexpress.R;
import ir.imansoft.chargeexpress.chargeReseller.ChargeResellerCore;
import ir.imansoft.chargeexpress.chargeReseller.USSDRequest;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        USSDRequest ussdRequest = new USSDRequest();
        ussdRequest.setAmount((long) 1000);
        ussdRequest.setMobile("0935510600fix");
        ussdRequest.setOperatorType(USSDRequest.OperatorType.MCI);
        ussdRequest.setReuestType(USSDRequest.RequestTypes.Topup);


        final ChargeResellerCore core = new ChargeResellerCore(this, ussdRequest);


        requestPermission(Manifest.permission.CALL_PHONE, new RequestPermissionListener() {
            @Override
            public void onAllowPermission() {
                core.payment();
            }

            @Override
            public void onDeniedPermission(String permission) {
                Toast.makeText(getApplicationContext(), "no set Permission: " + permission, Toast.LENGTH_LONG).show();
            }
        });

    }
}
