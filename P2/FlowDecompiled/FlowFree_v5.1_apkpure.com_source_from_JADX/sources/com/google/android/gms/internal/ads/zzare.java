package com.google.android.gms.internal.ads;

import android.location.Location;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzare implements NativeMediationAdRequest {
    private final Date zza;
    private final int zzb;
    private final Set<String> zzc;
    private final boolean zzd;
    private final Location zze;
    private final int zzf;
    private final zzagy zzg;
    private final List<String> zzh = new ArrayList();
    private final boolean zzi;
    private final Map<String, Boolean> zzj = new HashMap();

    public zzare(Date date, int i, Set<String> set, Location location, boolean z, int i2, zzagy zzagy, List<String> list, boolean z2, int i3, String str) {
        this.zza = date;
        this.zzb = i;
        this.zzc = set;
        this.zze = location;
        this.zzd = z;
        this.zzf = i2;
        this.zzg = zzagy;
        this.zzi = z2;
        if (list != null) {
            for (String next : list) {
                if (next.startsWith("custom:")) {
                    String[] split = next.split(":", 3);
                    if (split.length == 3) {
                        if ("true".equals(split[2])) {
                            this.zzj.put(split[1], Boolean.TRUE);
                        } else if ("false".equals(split[2])) {
                            this.zzj.put(split[1], Boolean.FALSE);
                        }
                    }
                } else {
                    this.zzh.add(next);
                }
            }
        }
    }

    @Deprecated
    public final Date getBirthday() {
        return this.zza;
    }

    @Deprecated
    public final int getGender() {
        return this.zzb;
    }

    public final Set<String> getKeywords() {
        return this.zzc;
    }

    public final Location getLocation() {
        return this.zze;
    }

    public final NativeAdOptions getNativeAdOptions() {
        zzagy zzagy = this.zzg;
        NativeAdOptions.Builder builder = new NativeAdOptions.Builder();
        if (zzagy == null) {
            return builder.build();
        }
        int i = zzagy.zza;
        if (i != 2) {
            if (i != 3) {
                if (i == 4) {
                    builder.setRequestCustomMuteThisAd(zzagy.zzg);
                    builder.setMediaAspectRatio(zzagy.zzh);
                }
                builder.setReturnUrlsForImageAssets(zzagy.zzb);
                builder.setImageOrientation(zzagy.zzc);
                builder.setRequestMultipleImages(zzagy.zzd);
                return builder.build();
            }
            zzady zzady = zzagy.zzf;
            if (zzady != null) {
                builder.setVideoOptions(new VideoOptions(zzady));
            }
        }
        builder.setAdChoicesPlacement(zzagy.zze);
        builder.setReturnUrlsForImageAssets(zzagy.zzb);
        builder.setImageOrientation(zzagy.zzc);
        builder.setRequestMultipleImages(zzagy.zzd);
        return builder.build();
    }

    public final com.google.android.gms.ads.nativead.NativeAdOptions getNativeAdRequestOptions() {
        return zzagy.zza(this.zzg);
    }

    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.zzi;
    }

    public final boolean isTesting() {
        return this.zzd;
    }

    public final boolean isUnifiedNativeAdRequested() {
        return this.zzh.contains("6");
    }

    public final int taggedForChildDirectedTreatment() {
        return this.zzf;
    }

    public final boolean zza() {
        return this.zzh.contains("3");
    }

    public final Map<String, Boolean> zzb() {
        return this.zzj;
    }
}
