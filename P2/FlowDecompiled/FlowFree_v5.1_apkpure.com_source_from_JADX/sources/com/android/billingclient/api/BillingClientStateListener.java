package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@3.0.3 */
public interface BillingClientStateListener {
    void onBillingServiceDisconnected();

    void onBillingSetupFinished(BillingResult billingResult);
}
