package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.util.zzbx;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbfc implements zzakp<zzbdp> {
    private boolean zza;

    private static int zzb(Context context, Map<String, String> map, String str, int i) {
        String str2 = map.get(str);
        if (str2 == null) {
            return i;
        }
        try {
            zzzy.zza();
            return zzbbd.zzs(context, Integer.parseInt(str2));
        } catch (NumberFormatException unused) {
            StringBuilder sb = new StringBuilder(str.length() + 34 + str2.length());
            sb.append("Could not parse ");
            sb.append(str);
            sb.append(" in a video GMSG: ");
            sb.append(str2);
            zzbbk.zzi(sb.toString());
            return i;
        }
    }

    private static void zzc(zzbdf zzbdf, Map<String, String> map) {
        String str = map.get("minBufferMs");
        String str2 = map.get("maxBufferMs");
        String str3 = map.get("bufferForPlaybackMs");
        String str4 = map.get("bufferForPlaybackAfterRebufferMs");
        String str5 = map.get("socketReceiveBufferSize");
        if (str != null) {
            try {
                zzbdf.zzv(Integer.parseInt(str));
            } catch (NumberFormatException unused) {
                zzbbk.zzi(String.format("Could not parse buffer parameters in loadControl video GMSG: (%s, %s)", new Object[]{str, str2}));
                return;
            }
        }
        if (str2 != null) {
            zzbdf.zzw(Integer.parseInt(str2));
        }
        if (str3 != null) {
            zzbdf.zzx(Integer.parseInt(str3));
        }
        if (str4 != null) {
            zzbdf.zzy(Integer.parseInt(str4));
        }
        if (str5 != null) {
            zzbdf.zzz(Integer.parseInt(str5));
        }
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        int i;
        int i2;
        int i3;
        String str;
        String str2;
        String str3;
        String str4;
        zzbdp zzbdp = (zzbdp) obj;
        String str5 = (String) map.get("action");
        if (str5 == null) {
            zzbbk.zzi("Action missing from video GMSG.");
            return;
        }
        if (zzbbk.zzm(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String jSONObject2 = jSONObject.toString();
            StringBuilder sb = new StringBuilder(str5.length() + 13 + String.valueOf(jSONObject2).length());
            sb.append("Video GMSG: ");
            sb.append(str5);
            sb.append(" ");
            sb.append(jSONObject2);
            zzbbk.zzd(sb.toString());
        }
        if ("background".equals(str5)) {
            String str6 = (String) map.get("color");
            if (TextUtils.isEmpty(str6)) {
                zzbbk.zzi("Color parameter missing from background video GMSG.");
                return;
            }
            try {
                zzbdp.setBackgroundColor(Color.parseColor(str6));
            } catch (IllegalArgumentException unused) {
                zzbbk.zzi("Invalid color parameter in background video GMSG.");
            }
        } else if ("playerBackground".equals(str5)) {
            String str7 = (String) map.get("color");
            if (TextUtils.isEmpty(str7)) {
                zzbbk.zzi("Color parameter missing from playerBackground video GMSG.");
                return;
            }
            try {
                zzbdp.zzw(Color.parseColor(str7));
            } catch (IllegalArgumentException unused2) {
                zzbbk.zzi("Invalid color parameter in playerBackground video GMSG.");
            }
        } else {
            if ("decoderProps".equals(str5)) {
                String str8 = (String) map.get("mimeTypes");
                if (str8 == null) {
                    zzbbk.zzi("No MIME types specified for decoder properties inspection.");
                    HashMap hashMap = new HashMap();
                    hashMap.put("event", "decoderProps");
                    hashMap.put("error", "missingMimeTypes");
                    zzbdp.zze("onVideoEvent", hashMap);
                    return;
                }
                HashMap hashMap2 = new HashMap();
                for (String str9 : str8.split(",")) {
                    hashMap2.put(str9, zzbx.zza(str9.trim()));
                }
                HashMap hashMap3 = new HashMap();
                hashMap3.put("event", "decoderProps");
                hashMap3.put("mimeTypes", hashMap2);
                zzbdp.zze("onVideoEvent", hashMap3);
                return;
            }
            zzbdg zzf = zzbdp.zzf();
            if (zzf == null) {
                zzbbk.zzi("Could not get underlay container for a video GMSG.");
                return;
            }
            boolean equals = "new".equals(str5);
            boolean equals2 = "position".equals(str5);
            if (equals || equals2) {
                Context context = zzbdp.getContext();
                int zzb = zzb(context, map, "x", 0);
                int zzb2 = zzb(context, map, "y", 0);
                int zzb3 = zzb(context, map, "w", -1);
                zzaei zzaei = zzaeq.zzcf;
                if (!((Boolean) zzaaa.zzc().zzb(zzaei)).booleanValue()) {
                    i = Math.min(zzb3, zzbdp.zzz() - zzb);
                } else if (zzb3 == -1) {
                    i = zzbdp.zzz();
                } else {
                    i = Math.min(zzb3, zzbdp.zzz());
                }
                int zzb4 = zzb(context, map, "h", -1);
                if (!((Boolean) zzaaa.zzc().zzb(zzaei)).booleanValue()) {
                    i2 = Math.min(zzb4, zzbdp.zzy() - zzb2);
                } else if (zzb4 == -1) {
                    i2 = zzbdp.zzy();
                } else {
                    i2 = Math.min(zzb4, zzbdp.zzy());
                }
                int i4 = i2;
                try {
                    i3 = Integer.parseInt((String) map.get("player"));
                } catch (NumberFormatException unused3) {
                    i3 = 0;
                }
                boolean parseBoolean = Boolean.parseBoolean((String) map.get("spherical"));
                if (!equals || zzf.zzc() != null) {
                    zzf.zza(zzb, zzb2, i, i4);
                    return;
                }
                zzf.zzb(zzb, zzb2, i, i4, i3, parseBoolean, new zzbdo((String) map.get("flags")));
                zzbdf zzc = zzf.zzc();
                if (zzc != null) {
                    zzc(zzc, map);
                    return;
                }
                return;
            }
            zzbhb zzh = zzbdp.zzh();
            if (zzh != null) {
                if ("timeupdate".equals(str5)) {
                    String str10 = (String) map.get("currentTime");
                    if (str10 == null) {
                        zzbbk.zzi("currentTime parameter missing from timeupdate video GMSG.");
                        return;
                    }
                    try {
                        zzh.zzd(Float.parseFloat(str10));
                        return;
                    } catch (NumberFormatException unused4) {
                        if (str10.length() != 0) {
                            str4 = "Could not parse currentTime parameter from timeupdate video GMSG: ".concat(str10);
                        } else {
                            str4 = new String("Could not parse currentTime parameter from timeupdate video GMSG: ");
                        }
                        zzbbk.zzi(str4);
                        return;
                    }
                } else if ("skip".equals(str5)) {
                    zzh.zzr();
                    return;
                }
            }
            zzbdf zzc2 = zzf.zzc();
            if (zzc2 == null) {
                HashMap hashMap4 = new HashMap();
                hashMap4.put("event", "no_video_view");
                zzbdp.zze("onVideoEvent", hashMap4);
            } else if ("click".equals(str5)) {
                Context context2 = zzbdp.getContext();
                int zzb5 = zzb(context2, map, "x", 0);
                int zzb6 = zzb(context2, map, "y", 0);
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float) zzb5, (float) zzb6, 0);
                zzc2.zzA(obtain);
                obtain.recycle();
            } else if ("currentTime".equals(str5)) {
                String str11 = (String) map.get("time");
                if (str11 == null) {
                    zzbbk.zzi("Time parameter missing from currentTime video GMSG.");
                    return;
                }
                try {
                    zzc2.zzr((int) (Float.parseFloat(str11) * 1000.0f));
                } catch (NumberFormatException unused5) {
                    if (str11.length() != 0) {
                        str3 = "Could not parse time parameter from currentTime video GMSG: ".concat(str11);
                    } else {
                        str3 = new String("Could not parse time parameter from currentTime video GMSG: ");
                    }
                    zzbbk.zzi(str3);
                }
            } else if ("hide".equals(str5)) {
                zzc2.setVisibility(4);
            } else if ("load".equals(str5)) {
                zzc2.zzo();
            } else if ("loadControl".equals(str5)) {
                zzc(zzc2, map);
            } else if ("muted".equals(str5)) {
                if (Boolean.parseBoolean((String) map.get("muted"))) {
                    zzc2.zzs();
                } else {
                    zzc2.zzt();
                }
            } else if ("pause".equals(str5)) {
                zzc2.zzp();
            } else if ("play".equals(str5)) {
                zzc2.zzq();
            } else if ("show".equals(str5)) {
                zzc2.setVisibility(0);
            } else if ("src".equals(str5)) {
                String str12 = (String) map.get("src");
                Integer num = null;
                if (map.containsKey("periodicReportIntervalMs")) {
                    try {
                        num = Integer.valueOf(Integer.parseInt((String) map.get("periodicReportIntervalMs")));
                    } catch (NumberFormatException unused6) {
                        String str13 = (String) map.get("periodicReportIntervalMs");
                        StringBuilder sb2 = new StringBuilder(String.valueOf(str13).length() + 65);
                        sb2.append("Video gmsg invalid numeric parameter 'periodicReportIntervalMs': ");
                        sb2.append(str13);
                        zzbbk.zzi(sb2.toString());
                    }
                }
                String[] strArr = {str12};
                String str14 = (String) map.get("demuxed");
                if (str14 != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(str14);
                        String[] strArr2 = new String[jSONArray.length()];
                        for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                            strArr2[i5] = jSONArray.getString(i5);
                        }
                        strArr = strArr2;
                    } catch (JSONException unused7) {
                        if (str14.length() != 0) {
                            str2 = "Malformed demuxed URL list for playback: ".concat(str14);
                        } else {
                            str2 = new String("Malformed demuxed URL list for playback: ");
                        }
                        zzbbk.zzi(str2);
                        strArr = new String[]{str12};
                    }
                }
                if (num != null) {
                    zzbdp.zzo(num.intValue());
                }
                zzc2.zzm(str12, strArr);
            } else if ("touchMove".equals(str5)) {
                Context context3 = zzbdp.getContext();
                zzc2.zzn((float) zzb(context3, map, "dx", 0), (float) zzb(context3, map, "dy", 0));
                if (!this.zza) {
                    zzbdp.zzl();
                    this.zza = true;
                }
            } else if ("volume".equals(str5)) {
                String str15 = (String) map.get("volume");
                if (str15 == null) {
                    zzbbk.zzi("Level parameter missing from volume video GMSG.");
                    return;
                }
                try {
                    zzc2.zzu(Float.parseFloat(str15));
                } catch (NumberFormatException unused8) {
                    if (str15.length() != 0) {
                        str = "Could not parse volume parameter from volume video GMSG: ".concat(str15);
                    } else {
                        str = new String("Could not parse volume parameter from volume video GMSG: ");
                    }
                    zzbbk.zzi(str);
                }
            } else if ("watermark".equals(str5)) {
                zzc2.zzB();
            } else {
                zzbbk.zzi(str5.length() != 0 ? "Unknown video action: ".concat(str5) : new String("Unknown video action: "));
            }
        }
    }
}
