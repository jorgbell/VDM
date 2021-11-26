package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import com.mopub.mobileads.ChartboostShared;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdtc implements zzdtb {
    private final Object[] zza;

    public zzdtc(zzys zzys, String str, int i, String str2, zzzd zzzd) {
        HashSet hashSet = new HashSet(Arrays.asList(str2.split(",")));
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        arrayList.add(str);
        if (hashSet.contains("networkType")) {
            arrayList.add(Integer.valueOf(i));
        }
        if (hashSet.contains("birthday")) {
            arrayList.add(Long.valueOf(zzys.zzb));
        }
        if (hashSet.contains("extras")) {
            arrayList.add(zza(zzys.zzc));
        } else if (hashSet.contains("npa")) {
            arrayList.add(zzys.zzc.getString("npa"));
        }
        if (hashSet.contains("gender")) {
            arrayList.add(Integer.valueOf(zzys.zzd));
        }
        if (hashSet.contains("keywords")) {
            List<String> list = zzys.zze;
            if (list != null) {
                arrayList.add(list.toString());
            } else {
                arrayList.add((Object) null);
            }
        }
        if (hashSet.contains("isTestDevice")) {
            arrayList.add(Boolean.valueOf(zzys.zzf));
        }
        if (hashSet.contains("tagForChildDirectedTreatment")) {
            arrayList.add(Integer.valueOf(zzys.zzg));
        }
        if (hashSet.contains("manualImpressionsEnabled")) {
            arrayList.add(Boolean.valueOf(zzys.zzh));
        }
        if (hashSet.contains("publisherProvidedId")) {
            arrayList.add(zzys.zzi);
        }
        if (hashSet.contains(ChartboostShared.LOCATION_KEY)) {
            Location location = zzys.zzk;
            if (location != null) {
                arrayList.add(location.toString());
            } else {
                arrayList.add((Object) null);
            }
        }
        if (hashSet.contains("contentUrl")) {
            arrayList.add(zzys.zzl);
        }
        if (hashSet.contains("networkExtras")) {
            arrayList.add(zza(zzys.zzm));
        }
        if (hashSet.contains("customTargeting")) {
            arrayList.add(zza(zzys.zzn));
        }
        if (hashSet.contains("categoryExclusions")) {
            List<String> list2 = zzys.zzo;
            if (list2 != null) {
                arrayList.add(list2.toString());
            } else {
                arrayList.add((Object) null);
            }
        }
        if (hashSet.contains("requestAgent")) {
            arrayList.add(zzys.zzp);
        }
        if (hashSet.contains("requestPackage")) {
            arrayList.add(zzys.zzq);
        }
        if (hashSet.contains("isDesignedForFamilies")) {
            arrayList.add(Boolean.valueOf(zzys.zzr));
        }
        if (hashSet.contains("tagForUnderAgeOfConsent")) {
            arrayList.add(Integer.valueOf(zzys.zzt));
        }
        if (hashSet.contains("maxAdContentRating")) {
            arrayList.add(zzys.zzu);
        }
        if (hashSet.contains(AdUnitActivity.EXTRA_ORIENTATION)) {
            if (zzzd != null) {
                arrayList.add(Integer.valueOf(zzzd.zza));
            } else {
                arrayList.add((Object) null);
            }
        }
        this.zza = arrayList.toArray();
    }

    private static String zza(Bundle bundle) {
        String str;
        if (bundle == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        while (it.hasNext()) {
            Object obj = bundle.get((String) it.next());
            if (obj == null) {
                str = "null";
            } else if (obj instanceof Bundle) {
                str = zza((Bundle) obj);
            } else {
                str = obj.toString();
            }
            sb.append(str);
        }
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzdtc)) {
            return false;
        }
        return Arrays.equals(this.zza, ((zzdtc) obj).zza);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final String toString() {
        int hashCode = Arrays.hashCode(this.zza);
        String arrays = Arrays.toString(this.zza);
        StringBuilder sb = new StringBuilder(String.valueOf(arrays).length() + 22);
        sb.append("[PoolKey#");
        sb.append(hashCode);
        sb.append(" ");
        sb.append(arrays);
        sb.append("]");
        return sb.toString();
    }
}
