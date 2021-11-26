package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcvu implements zzauf {
    private static zzdww zzb(String str) {
        if ("native".equals(str)) {
            return zzdww.NATIVE;
        }
        if ("javascript".equals(str)) {
            return zzdww.JAVASCRIPT;
        }
        return zzdww.NONE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzdwv zzl(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = -1104128070(0xffffffffbe3057ba, float:-0.17220965)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x002a
            r1 = 1318088141(0x4e906dcd, float:1.2115575E9)
            if (r0 == r1) goto L_0x0020
            r1 = 1988248512(0x768243c0, float:1.3210405E33)
            if (r0 == r1) goto L_0x0016
            goto L_0x0034
        L_0x0016:
            java.lang.String r0 = "onePixel"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = 2
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "definedByJavascript"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = 1
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "beginToRender"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = 0
            goto L_0x0035
        L_0x0034:
            r4 = -1
        L_0x0035:
            if (r4 == 0) goto L_0x0044
            if (r4 == r3) goto L_0x0041
            if (r4 == r2) goto L_0x003e
            com.google.android.gms.internal.ads.zzdwv r4 = com.google.android.gms.internal.ads.zzdwv.UNSPECIFIED
            return r4
        L_0x003e:
            com.google.android.gms.internal.ads.zzdwv r4 = com.google.android.gms.internal.ads.zzdwv.ONE_PIXEL
            return r4
        L_0x0041:
            com.google.android.gms.internal.ads.zzdwv r4 = com.google.android.gms.internal.ads.zzdwv.DEFINED_BY_JAVASCRIPT
            return r4
        L_0x0044:
            com.google.android.gms.internal.ads.zzdwv r4 = com.google.android.gms.internal.ads.zzdwv.BEGIN_TO_RENDER
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcvu.zzl(java.lang.String):com.google.android.gms.internal.ads.zzdwv");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzdwt zzm(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = -382745961(0xffffffffe92fc297, float:-1.3280059E25)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x002a
            r1 = 112202875(0x6b0147b, float:6.6233935E-35)
            if (r0 == r1) goto L_0x0020
            r1 = 714893483(0x2a9c68ab, float:2.7783795E-13)
            if (r0 == r1) goto L_0x0016
            goto L_0x0034
        L_0x0016:
            java.lang.String r0 = "nativeDisplay"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = 1
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "video"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = 2
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "htmlDisplay"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = 0
            goto L_0x0035
        L_0x0034:
            r4 = -1
        L_0x0035:
            if (r4 == 0) goto L_0x0043
            if (r4 == r3) goto L_0x0040
            if (r4 == r2) goto L_0x003d
            r4 = 0
            return r4
        L_0x003d:
            com.google.android.gms.internal.ads.zzdwt r4 = com.google.android.gms.internal.ads.zzdwt.VIDEO
            return r4
        L_0x0040:
            com.google.android.gms.internal.ads.zzdwt r4 = com.google.android.gms.internal.ads.zzdwt.NATIVE_DISPLAY
            return r4
        L_0x0043:
            com.google.android.gms.internal.ads.zzdwt r4 = com.google.android.gms.internal.ads.zzdwt.HTML_DISPLAY
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcvu.zzm(java.lang.String):com.google.android.gms.internal.ads.zzdwt");
    }

    public final boolean zza(Context context) {
        if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzdi)).booleanValue()) {
            zzbbk.zzi("Omid flag is disabled");
            return false;
        } else if (zzdwm.zzb()) {
            return true;
        } else {
            if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzdk)).booleanValue()) {
                zzdwm.zza(context);
                return zzdwm.zzb();
            }
            zzdwm.zzc("1.3.3-google_20200416", context);
            return true;
        }
    }

    public final String zzc(Context context) {
        if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzdi)).booleanValue()) {
            return null;
        }
        return "a.1.3.3-google_20200416";
    }

    public final IObjectWrapper zzd(String str, WebView webView, String str2, String str3, String str4) {
        return zze(str, webView, "", "javascript", str4, "Google");
    }

    public final IObjectWrapper zze(String str, WebView webView, String str2, String str3, String str4, String str5) {
        if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzdi)).booleanValue() || !zzdwm.zzb()) {
            return null;
        }
        zzdwx zza = zzdwx.zza(str5, str);
        zzdww zzb = zzb("javascript");
        zzdww zzb2 = zzb(str4);
        if (zzb == zzdww.NONE) {
            return null;
        }
        return ObjectWrapper.wrap(zzdwo.zzf(zzdwp.zzb(zzb, zzb2, true), zzdwq.zza(zza, webView, "")));
    }

    public final IObjectWrapper zzf(String str, WebView webView, String str2, String str3, String str4, zzauh zzauh, zzaug zzaug, String str5) {
        if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzdi)).booleanValue() || !zzdwm.zzb()) {
            return null;
        }
        zzdwx zza = zzdwx.zza("Google", str);
        zzdww zzb = zzb("javascript");
        zzdwt zzm = zzm(zzaug.toString());
        zzdww zzdww = zzdww.NONE;
        if (zzb == zzdww) {
            zzbbk.zzi("Omid html session error; Unable to parse impression owner: javascript");
            return null;
        } else if (zzm == null) {
            String valueOf = String.valueOf(zzaug);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 56);
            sb.append("Omid html session error; Unable to parse creative type: ");
            sb.append(valueOf);
            zzbbk.zzi(sb.toString());
            return null;
        } else {
            zzdww zzb2 = zzb(str4);
            if (zzm == zzdwt.VIDEO && zzb2 == zzdww) {
                String valueOf2 = String.valueOf(str4);
                zzbbk.zzi(valueOf2.length() != 0 ? "Omid html session error; Video events owner unknown for video creative: ".concat(valueOf2) : new String("Omid html session error; Video events owner unknown for video creative: "));
                return null;
            }
            return ObjectWrapper.wrap(zzdwo.zzf(zzdwp.zza(zzm, zzl(zzauh.toString()), zzb, zzb2, true), zzdwq.zzb(zza, webView, str5, "")));
        }
    }

    public final IObjectWrapper zzg(String str, WebView webView, String str2, String str3, String str4, String str5, zzauh zzauh, zzaug zzaug, String str6) {
        if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzdi)).booleanValue() || !zzdwm.zzb()) {
            return null;
        }
        zzdwx zza = zzdwx.zza(str5, str);
        zzdww zzb = zzb("javascript");
        zzdww zzb2 = zzb(str4);
        zzdwt zzm = zzm(zzaug.toString());
        zzdww zzdww = zzdww.NONE;
        if (zzb == zzdww) {
            zzbbk.zzi("Omid js session error; Unable to parse impression owner: javascript");
            return null;
        } else if (zzm == null) {
            String valueOf = String.valueOf(zzaug);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 54);
            sb.append("Omid js session error; Unable to parse creative type: ");
            sb.append(valueOf);
            zzbbk.zzi(sb.toString());
            return null;
        } else if (zzm == zzdwt.VIDEO && zzb2 == zzdww) {
            String valueOf2 = String.valueOf(str4);
            zzbbk.zzi(valueOf2.length() != 0 ? "Omid js session error; Video events owner unknown for video creative: ".concat(valueOf2) : new String("Omid js session error; Video events owner unknown for video creative: "));
            return null;
        } else {
            return ObjectWrapper.wrap(zzdwo.zzf(zzdwp.zza(zzm, zzl(zzauh.toString()), zzb, zzb2, true), zzdwq.zzc(zza, webView, str6, "")));
        }
    }

    public final void zzh(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzdi)).booleanValue() && zzdwm.zzb()) {
            Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
            if (unwrap instanceof zzdwo) {
                ((zzdwo) unwrap).zza();
            }
        }
    }

    public final void zzi(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzdi)).booleanValue() && zzdwm.zzb()) {
            Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
            if (unwrap instanceof zzdwo) {
                ((zzdwo) unwrap).zzc();
            }
        }
    }

    public final void zzj(IObjectWrapper iObjectWrapper, View view) {
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzdi)).booleanValue() && zzdwm.zzb()) {
            Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
            if (unwrap instanceof zzdwo) {
                ((zzdwo) unwrap).zzb(view);
            }
        }
    }

    public final void zzk(IObjectWrapper iObjectWrapper, View view) {
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzdi)).booleanValue() && zzdwm.zzb()) {
            Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
            if (unwrap instanceof zzdwo) {
                zzdwo zzdwo = (zzdwo) unwrap;
                if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzdn)).booleanValue()) {
                    zzdwo.zzd(view, zzdwu.NOT_VISIBLE, "Ad overlay");
                } else {
                    zzdwo.zze(view);
                }
            }
        }
    }
}
