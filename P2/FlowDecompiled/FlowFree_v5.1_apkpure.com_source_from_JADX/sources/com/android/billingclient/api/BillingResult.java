package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@3.0.3 */
public final class BillingResult {
    /* access modifiers changed from: private */
    public int zza;
    /* access modifiers changed from: private */
    public String zzb;

    /* compiled from: com.android.billingclient:billing@@3.0.3 */
    public static class Builder {
        private int zza;
        private String zzb = "";

        /* synthetic */ Builder(zzal zzal) {
        }

        public BillingResult build() {
            BillingResult billingResult = new BillingResult();
            int unused = billingResult.zza = this.zza;
            String unused2 = billingResult.zzb = this.zzb;
            return billingResult;
        }

        public Builder setDebugMessage(String str) {
            this.zzb = str;
            return this;
        }

        public Builder setResponseCode(int i) {
            this.zza = i;
            return this;
        }
    }

    public static Builder newBuilder() {
        return new Builder((zzal) null);
    }

    public String getDebugMessage() {
        return this.zzb;
    }

    public int getResponseCode() {
        return this.zza;
    }
}
