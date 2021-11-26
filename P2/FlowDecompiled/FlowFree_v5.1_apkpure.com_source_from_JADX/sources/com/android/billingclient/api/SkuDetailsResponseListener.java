package com.android.billingclient.api;

import java.util.List;

/* compiled from: com.android.billingclient:billing@@3.0.3 */
public interface SkuDetailsResponseListener {
    void onSkuDetailsResponse(BillingResult billingResult, List<SkuDetails> list);
}
