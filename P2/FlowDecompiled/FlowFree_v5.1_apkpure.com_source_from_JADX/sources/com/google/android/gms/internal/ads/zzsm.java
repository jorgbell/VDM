package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzsm {
    private final int zza;
    private final zzsj zzb = new zzso();

    public zzsm(int i) {
        this.zza = i;
    }

    public final String zza(ArrayList<String> arrayList) {
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            sb.append(arrayList.get(i).toLowerCase(Locale.US));
            sb.append(10);
        }
        String[] split = sb.toString().split("\n");
        if (split.length == 0) {
            return "";
        }
        zzsl zzsl = new zzsl();
        PriorityQueue priorityQueue = new PriorityQueue(this.zza, new zzsk(this));
        for (String zzb2 : split) {
            String[] zzb3 = zzsn.zzb(zzb2, false);
            if (zzb3.length != 0) {
                zzsr.zza(zzb3, this.zza, 6, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                zzsl.zzb.write(this.zzb.zza(((zzsq) it.next()).zzb));
            } catch (IOException e) {
                zzbbk.zzg("Error while writing hash to byteStream", e);
            }
        }
        return zzsl.toString();
    }
}
