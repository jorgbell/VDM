package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@3.0.3 */
public final class ConsumeParams {
    /* access modifiers changed from: private */
    public String zza;

    /* compiled from: com.android.billingclient:billing@@3.0.3 */
    public static final class Builder {
        private String zza;

        /* synthetic */ Builder(zzan zzan) {
        }

        public ConsumeParams build() {
            String str = this.zza;
            if (str != null) {
                ConsumeParams consumeParams = new ConsumeParams((zzan) null);
                String unused = consumeParams.zza = str;
                return consumeParams;
            }
            throw new IllegalArgumentException("Purchase token must be set");
        }

        public Builder setPurchaseToken(String str) {
            this.zza = str;
            return this;
        }
    }

    /* synthetic */ ConsumeParams(zzan zzan) {
    }

    public static Builder newBuilder() {
        return new Builder((zzan) null);
    }

    public String getPurchaseToken() {
        return this.zza;
    }
}
