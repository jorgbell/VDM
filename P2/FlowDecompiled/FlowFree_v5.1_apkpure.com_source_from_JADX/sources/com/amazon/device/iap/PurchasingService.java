package com.amazon.device.iap;

import android.content.Context;
import android.util.Log;
import com.amazon.device.iap.internal.C0524d;
import com.amazon.device.iap.internal.C0525e;
import com.amazon.device.iap.model.FulfillmentResult;
import com.amazon.device.iap.model.RequestId;
import java.util.Set;

public final class PurchasingService {
    public static final boolean IS_SANDBOX_MODE = C0525e.m168a();
    public static final String SDK_VERSION = "2.0.76.4";
    private static final String TAG = "PurchasingService";

    private PurchasingService() {
        String str = TAG;
        Log.i(str, "In-App Purchasing SDK initializing. SDK Version 2.0.76.4, IS_SANDBOX_MODE: " + IS_SANDBOX_MODE);
    }

    public static void registerListener(Context context, PurchasingListener purchasingListener) {
        C0524d.m156d().mo7498a(context, purchasingListener);
    }

    public static RequestId getUserData() {
        return C0524d.m156d().mo7501c();
    }

    public static RequestId purchase(String str) {
        return C0524d.m156d().mo7494a(str);
    }

    public static RequestId getProductData(Set<String> set) {
        return C0524d.m156d().mo7495a(set);
    }

    public static RequestId getPurchaseUpdates(boolean z) {
        return C0524d.m156d().mo7496a(z);
    }

    public static void notifyFulfillment(String str, FulfillmentResult fulfillmentResult) {
        C0524d.m156d().mo7499a(str, fulfillmentResult);
    }
}
