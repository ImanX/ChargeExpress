package ir.imansoft.chargeexpress.chargeReseller;

import android.net.Uri;

import ir.imansoft.chargeexpress.global.ApplicationResource;

/**
 * Android ZarinPal SDK Library v0.1 Project.
 * Created by ImanX on 12/2/16.
 * Copyright Alireza Tarazani All Rights Reserved.
 */
public class USSDRequest {

    private static final String USSD_ID      = ApplicationResource.getInstance().getChargerResllerDialId();
    private static final String ROOT_USSD_ID = String.format("*788*97*%s", USSD_ID);


    private static final int TOPUP           = 1;
    private static final int CARD            = 2;
    private static final int BILL            = 3;
    private static final int INTERNET_PACKET = 4;

    private int    requestType;
    private int    operatorType;
    private String mobile;
    private Long   amount;

    public enum RequestTypes {
        Topup,
        Card,
        Bill,
        InternetPacket
    }

    public enum OperatorType {
        MCI,
        MTN,
        MTN_AMAZING,
        Wimax,
        RTL,
        TAL
    }


    public void setOperatorType(OperatorType type) {
        switch (type) {

            case MCI:
                this.operatorType = 100;
                break;

            case MTN:
                this.operatorType = 200;
                break;

            case MTN_AMAZING:
                this.operatorType = 210;
                break;

            case Wimax:
                this.operatorType = 230;
                break;

            case RTL:
                this.operatorType = 300;
                break;

            case TAL:
                this.requestType = 400;
                break;

        }
    }


    public void setReuestType(RequestTypes type) {

        if (type == RequestTypes.Topup) this.requestType = TOPUP;
        if (type == RequestTypes.Card) this.requestType = CARD;
        if (type == RequestTypes.Bill) this.requestType = BILL;
        if (type == RequestTypes.InternetPacket) this.requestType = INTERNET_PACKET;

    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }


    private String getZero(int count) {
        String zeros = "";

        while (count > 0) {
            zeros += "0";
            count--;
        }

        return zeros;
    }

    public String getCommandUssd() {
        String code = null;

        if (requestType == TOPUP) {
            code = (requestType + "" + operatorType + getZero(19) + mobile);
        }

        if (requestType == CARD) {
            code = (requestType + "" + operatorType) + getZero(30);
        }

        if (requestType == BILL) {
            code = (requestType + getZero(3) + "" + "" + getZero(4));
        }


        return (String.format("%s%s*%s%s", ROOT_USSD_ID, code, amount, Uri.encode("#")));
    }
}
