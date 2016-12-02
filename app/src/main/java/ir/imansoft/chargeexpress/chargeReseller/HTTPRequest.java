package ir.imansoft.chargeexpress.chargeReseller;


import java.util.HashMap;

import ir.imansoft.chargeexpress.global.ApplicationResource;

/**
 * Android ZarinPal SDK Library v0.1 Project.
 * Created by ImanX on 12/2/16.
 * Copyright Alireza Tarazani All Rights Reserved.
 */
public class HTTPRequest {


    private static final String TOPUP_URL       = "http://chr724.ir/services/v3/EasyCharge/topup";
    private static final String BUY_PRODUCT_URL = "http://chr724.ir/services/v3/EasyCharge/BuyProduct";
    private static final String BILL_URL        = "http://chr724.ir/services/v3/EasyCharge/bill";
    private static final String WEB_SERVICE_ID  = ApplicationResource.getInstance().getChargeResellerWebserviceId();
    private static final String REDIRECT_URL    = "";
    private static final String SCRIPT_VERSION  = "Android";
    private static final String OUTPUT_TYPE     = "json";


    private String operatorType;
    private String URLRequestType;
    private Long   amount;
    private String mobile;
    private String email;
    private String issuer;


    public enum OperatorTypes {
        MTN,
        RTL,
        MCI,
        MTN_AMAZING
    }


    public enum RequestTypes {
        Topup,
        BuyProduct,
        Bill
    }

    public enum Issuer {
        Mellat,
        Saman,
        ZarinPal,
    }


    public void setOperatorType(OperatorTypes type) {

        if (type == OperatorTypes.MTN) {
            this.operatorType = "MTN";
        }

        if (type == OperatorTypes.MCI) {
            this.operatorType = "MCI";
        }

        if (type == OperatorTypes.MTN_AMAZING) {
            this.operatorType = "MTN!";
        }

        if (type == OperatorTypes.RTL) {
            this.operatorType = "RTL";
        }
    }

    public void setRequestType(RequestTypes type) {

        if (type == RequestTypes.Topup) {
            this.URLRequestType = TOPUP_URL;
        }

        if (type == RequestTypes.BuyProduct) {
            this.URLRequestType = BUY_PRODUCT_URL;
        }

        if (type == RequestTypes.Bill) {
            this.URLRequestType = BILL_URL;
        }
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setIssuer(Issuer issuer) {
        this.issuer = issuer.toString();
    }

    public HashMap<String, String> getRequestParameters() {
        HashMap<String, String> p = new HashMap<>();
        p.put("type", this.operatorType);
        p.put("amount", this.amount.toString());
        p.put("cellphone", this.mobile);
        p.put("email", this.email);
        p.put("issuer", this.issuer);
        p.put("webserviceid", WEB_SERVICE_ID);
        p.put("redirectUrl", REDIRECT_URL);
        p.put("scriptVersion", SCRIPT_VERSION);
        p.put("redirectToPage", "true");
        p.put("firstOutputType", OUTPUT_TYPE);
        p.put("secondOutputType", OUTPUT_TYPE);
        return p;
    }
}
