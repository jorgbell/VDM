package com.android.billingclient.api;

import android.app.Activity;
import android.content.Context;
import com.android.billingclient.api.Purchase;

/* compiled from: com.android.billingclient:billing@@3.0.3 */
public abstract class BillingClient {

    /* compiled from: com.android.billingclient:billing@@3.0.3 */
    public static final class Builder {
        private boolean zza;
        private final Context zzb;
        private PurchasesUpdatedListener zzc;

        /* synthetic */ Builder(Context context, zzf zzf) {
            this.zzb = context;
        }

        public BillingClient build() {
            Context context = this.zzb;
            if (context != null) {
                PurchasesUpdatedListener purchasesUpdatedListener = this.zzc;
                if (purchasesUpdatedListener == null) {
                    throw new IllegalArgumentException("Please provide a valid listener for purchases updates.");
                } else if (this.zza) {
                    return new BillingClientImpl((String) null, true, context, purchasesUpdatedListener);
                } else {
                    throw new IllegalArgumentException("Support for pending purchases must be enabled. Enable this by calling 'enablePendingPurchases()' on BillingClientBuilder.");
                }
            } else {
                throw new IllegalArgumentException("Please provide a valid Context.");
            }
        }

        public Builder enablePendingPurchases() {
            this.zza = true;
            return this;
        }

        public Builder setListener(PurchasesUpdatedListener purchasesUpdatedListener) {
            this.zzc = purchasesUpdatedListener;
            return this;
        }
    }

    public static Builder newBuilder(Context context) {
        return new Builder(context, (zzf) null);
    }

    public abstract void acknowledgePurchase(AcknowledgePurchaseParams acknowledgePurchaseParams, AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener);

    public abstract void consumeAsync(ConsumeParams consumeParams, ConsumeResponseListener consumeResponseListener);

    public abstract void endConnection();

    public abstract boolean isReady();

    public abstract BillingResult launchBillingFlow(Activity activity, BillingFlowParams billingFlowParams);

    public abstract Purchase.PurchasesResult queryPurchases(String str);

    public abstract void querySkuDetailsAsync(SkuDetailsParams skuDetailsParams, SkuDetailsResponseListener skuDetailsResponseListener);

    public abstract void startConnection(BillingClientStateListener billingClientStateListener);
}
