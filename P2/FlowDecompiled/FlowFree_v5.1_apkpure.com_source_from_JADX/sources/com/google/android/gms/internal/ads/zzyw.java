package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzyw {
    public static final zzyw zza = new zzyw();

    protected zzyw() {
    }

    public final zzys zza(Context context, zzacq zzacq) {
        List list;
        Context context2;
        String str;
        zzacq zzacq2 = zzacq;
        Date zza2 = zzacq.zza();
        long time = zza2 != null ? zza2.getTime() : -1;
        String zzb = zzacq.zzb();
        int zzd = zzacq.zzd();
        Set<String> zze = zzacq.zze();
        if (!zze.isEmpty()) {
            list = Collections.unmodifiableList(new ArrayList(zze));
            context2 = context;
        } else {
            context2 = context;
            list = null;
        }
        boolean zzm = zzacq2.zzm(context2);
        Location zzf = zzacq.zzf();
        Bundle zzh = zzacq2.zzh(AdMobAdapter.class);
        if (zzacq.zzt() == null) {
            String zzj = zzacq.zzj();
            SearchAdRequest zzl = zzacq.zzl();
            if (zzl == null) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext != null) {
                    String packageName = applicationContext.getPackageName();
                    zzzy.zza();
                    str = zzbbd.zzl(Thread.currentThread().getStackTrace(), packageName);
                } else {
                    str = null;
                }
                boolean zzs = zzacq.zzs();
                RequestConfiguration zzm2 = zzacy.zza().zzm();
                return new zzys(8, time, zzh, zzd, list, zzm, Math.max(zzacq.zzp(), zzm2.getTagForChildDirectedTreatment()), false, zzj, (zzadu) null, zzf, zzb, zzacq.zzo(), zzacq.zzq(), Collections.unmodifiableList(new ArrayList(zzacq.zzr())), zzacq.zzk(), str, zzs, (zzyk) null, Math.max(-1, zzm2.getTagForUnderAgeOfConsent()), (String) Collections.max(Arrays.asList(new String[]{null, zzm2.getMaxAdContentRating()}), zzyv.zza), zzacq.zzc(), zzacq.zzu());
            }
            new zzadu(zzl);
            throw null;
        }
        zzzy.zzf();
        zzacq.zzt().getQueryInfo();
        throw null;
    }
}
