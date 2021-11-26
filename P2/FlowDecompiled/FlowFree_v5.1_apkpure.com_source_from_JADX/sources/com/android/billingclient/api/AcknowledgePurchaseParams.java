package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@3.0.3 */
public final class AcknowledgePurchaseParams {
    /* access modifiers changed from: private */
    public String zza;

    /* compiled from: com.android.billingclient:billing@@3.0.3 */
    public static final class Builder {
        private String zza;

        /* synthetic */ Builder(zza zza2) {
        }

        public AcknowledgePurchaseParams build() {
            String str = this.zza;
            if (str != null) {
                AcknowledgePurchaseParams acknowledgePurchaseParams = new AcknowledgePurchaseParams((zza) null);
                String unused = acknowledgePurchaseParams.zza = str;
                return acknowledgePurchaseParams;
            }
            throw new IllegalArgumentException("Purchase token must be set");
        }

        public Builder setPurchaseToken(String str) {
            this.zza = str;
            return this;
        }
    }

    /* synthetic */ AcknowledgePurchaseParams(zza zza2) {
    }

    public static Builder newBuilder() {
        return new Builder((zza) null);
    }

    public String getPurchaseToken() {
        return this.zza;
    }
}
