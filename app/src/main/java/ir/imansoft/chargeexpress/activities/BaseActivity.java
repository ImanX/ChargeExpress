package ir.imansoft.chargeexpress.activities;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import ir.imansoft.chargeexpress.global.ApplicationResource;
import ir.imansoft.chargeexpress.global.ApplicationStorage;

/**
 * Android ZarinPal SDK Library v0.1 Project.
 * Created by ImanX on 12/2/16.
 * Copyright Alireza Tarazani All Rights Reserved.
 */
public class BaseActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE = 100;
    private RequestPermissionListener listener;

    public Activity getActivity() {
        return this;
    }

    public interface RequestPermissionListener {
        void onAllowPermission();

        void onDeniedPermission(String permission);
    }

    public ApplicationResource getApplicationResource() {
        return ApplicationResource.getInstance();
    }


    public ApplicationStorage getStorage() {
        return getApplicationResource().getStorage();
    }

    protected void requestPermission(String permission, RequestPermissionListener listener) {

        this.listener = listener;
        if (checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED) {
            this.listener.onAllowPermission();
            return;
        }
        requestPermissions(new String[]{permission}, PERMISSION_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            this.listener.onAllowPermission();
            return;
        }

        this.listener.onDeniedPermission(permissions[0]);
    }
}


