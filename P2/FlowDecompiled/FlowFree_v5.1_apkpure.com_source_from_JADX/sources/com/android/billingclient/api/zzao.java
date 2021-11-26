package com.android.billingclient.api;

import android.os.Bundle;
import com.android.billingclient.api.BillingResult;
import com.google.android.gms.internal.play_billing.zza;
import java.util.ArrayList;

/* compiled from: com.android.billingclient:billing@@3.0.3 */
final class zzao {
    static BillingResult zza(Bundle bundle, String str, String str2) {
        BillingResult billingResult = zzam.zzl;
        if (bundle == null) {
            zza.zzb("BillingClient", String.format("%s got null owned items list", new Object[]{str2}));
            return billingResult;
        }
        int zzd = zza.zzd(bundle, "BillingClient");
        String zze = zza.zze(bundle, "BillingClient");
        BillingResult.Builder newBuilder = BillingResult.newBuilder();
        newBuilder.setResponseCode(zzd);
        newBuilder.setDebugMessage(zze);
        BillingResult build = newBuilder.build();
        if (zzd != 0) {
            zza.zzb("BillingClient", String.format("%s failed. Response code: %s", new Object[]{str2, Integer.valueOf(zzd)}));
            return build;
        } else if (!bundle.containsKey("INAPP_PURCHASE_ITEM_LIST") || !bundle.containsKey("INAPP_PURCHASE_DATA_LIST") || !bundle.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
            zza.zzb("BillingClient", String.format("Bundle returned from %s doesn't contain required fields.", new Object[]{str2}));
            return billingResult;
        } else {
            ArrayList<String> stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
            ArrayList<String> stringArrayList2 = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
            ArrayList<String> stringArrayList3 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
            if (stringArrayList == null) {
                zza.zzb("BillingClient", String.format("Bundle returned from %s contains null SKUs list.", new Object[]{str2}));
                return billingResult;
            } else if (stringArrayList2 == null) {
                zza.zzb("BillingClient", String.format("Bundle returned from %s contains null purchases list.", new Object[]{str2}));
                return billingResult;
            } else if (stringArrayList3 != null) {
                return zzam.zzp;
            } else {
                zza.zzb("BillingClient", String.format("Bundle returned from %s contains null signatures list.", new Object[]{str2}));
                return billingResult;
            }
        }
    }
}
