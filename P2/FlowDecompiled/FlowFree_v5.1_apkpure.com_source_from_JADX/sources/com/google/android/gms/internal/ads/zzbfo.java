package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzs;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbfo implements zzakp<zzbdp> {
    private static final Integer zzb(Map<String, String> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(map.get(str)));
        } catch (NumberFormatException unused) {
            String str2 = map.get(str);
            StringBuilder sb = new StringBuilder(str.length() + 39 + String.valueOf(str2).length());
            sb.append("Precache invalid numeric parameter '");
            sb.append(str);
            sb.append("': ");
            sb.append(str2);
            zzbbk.zzi(sb.toString());
            return null;
        }
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzbfn zzbfn;
        zzbdp zzbdp = (zzbdp) obj;
        if (zzbbk.zzm(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String valueOf = String.valueOf(jSONObject);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 15);
            sb.append("Precache GMSG: ");
            sb.append(valueOf);
            zzbbk.zzd(sb.toString());
        }
        zzs.zzy();
        if (!map.containsKey("abort")) {
            String str = (String) map.get("src");
            Integer zzb = zzb(map, "periodicReportIntervalMs");
            Integer zzb2 = zzb(map, "exoPlayerRenderingIntervalMs");
            Integer zzb3 = zzb(map, "exoPlayerIdleIntervalMs");
            if (str != null) {
                String[] strArr = {str};
                String str2 = (String) map.get("demuxed");
                if (str2 != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(str2);
                        String[] strArr2 = new String[jSONArray.length()];
                        for (int i = 0; i < jSONArray.length(); i++) {
                            strArr2[i] = jSONArray.getString(i);
                        }
                        strArr = strArr2;
                    } catch (JSONException unused) {
                        zzbbk.zzi(str2.length() != 0 ? "Malformed demuxed URL list for precache: ".concat(str2) : new String("Malformed demuxed URL list for precache: "));
                        strArr = null;
                    }
                }
                if (strArr == null) {
                    strArr = new String[]{str};
                }
                if (zzbfg.zzc(zzbdp) != null) {
                    zzbbk.zzi("Precache task is already running.");
                    return;
                } else if (zzbdp.zzk() == null) {
                    zzbbk.zzi("Precache requires a dependency provider.");
                    return;
                } else {
                    zzbdo zzbdo = new zzbdo((String) map.get("flags"));
                    Integer zzb4 = zzb(map, "player");
                    if (zzb4 == null) {
                        zzb4 = 0;
                    }
                    if (zzb != null) {
                        zzbdp.zzo(zzb.intValue());
                    }
                    if (zzb2 != null) {
                        zzbdp.zzB(zzb2.intValue());
                    }
                    if (zzb3 != null) {
                        zzbdp.zzC(zzb3.intValue());
                    }
                    int intValue = zzb4.intValue();
                    zzbfa zzbfa = zzbdp.zzk().zzc;
                    if (intValue > 0) {
                        int zzq = zzbew.zzq();
                        if (zzq < zzbdo.zzh) {
                            zzbfn = new zzbfv(zzbdp, zzbdo);
                        } else if (zzq < zzbdo.zzb) {
                            zzbfn = new zzbft(zzbdp, zzbdo);
                        } else {
                            zzbfn = new zzbfr(zzbdp);
                        }
                    } else {
                        zzbfn = new zzbfq(zzbdp);
                    }
                    new zzbff(zzbdp, zzbfn, str, strArr).zzb();
                }
            } else {
                zzbff zzc = zzbfg.zzc(zzbdp);
                if (zzc != null) {
                    zzbfn = zzc.zzb;
                } else {
                    zzbbk.zzi("Precache must specify a source.");
                    return;
                }
            }
            Integer zzb5 = zzb(map, "minBufferMs");
            if (zzb5 != null) {
                zzbfn.zzd(zzb5.intValue());
            }
            Integer zzb6 = zzb(map, "maxBufferMs");
            if (zzb6 != null) {
                zzbfn.zzc(zzb6.intValue());
            }
            Integer zzb7 = zzb(map, "bufferForPlaybackMs");
            if (zzb7 != null) {
                zzbfn.zze(zzb7.intValue());
            }
            Integer zzb8 = zzb(map, "bufferForPlaybackAfterRebufferMs");
            if (zzb8 != null) {
                zzbfn.zzf(zzb8.intValue());
            }
        } else if (!zzbfg.zzd(zzbdp)) {
            zzbbk.zzi("Precache abort but no precache task running.");
        }
    }
}
