package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.view.View;
import androidx.core.app.NotificationManagerCompat;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.overlay.zzu;
import com.google.android.gms.ads.internal.util.zzbh;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.internal.ads.zzang;
import com.google.android.gms.internal.ads.zzbfw;
import com.google.android.gms.internal.ads.zzbgf;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzbhh;
import com.google.android.gms.internal.ads.zzbhl;
import com.google.android.gms.internal.ads.zzbho;
import com.google.android.gms.internal.ads.zzbhq;
import com.google.android.gms.internal.ads.zzyi;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzala<T extends zzyi & zzbfw & zzbgf & zzang & zzbhc & zzbhh & zzbhl & zzbho & zzbhq> implements zzakp<T> {
    private final zzb zza;
    private final zzcni zzb;
    private final zzdvo zzc;
    private final zzbbp zzd;
    private final zzate zze;
    private final zzcvk zzf;
    private zzu zzg = null;

    public zzala(zzb zzb2, zzate zzate, zzcvk zzcvk, zzcni zzcni, zzdvo zzdvo) {
        this.zza = zzb2;
        this.zze = zzate;
        this.zzf = zzcvk;
        this.zzb = zzcni;
        this.zzc = zzdvo;
        this.zzd = new zzbbp((String) null);
    }

    public static boolean zzc(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    public static int zzd(Map<String, String> map) {
        String str = map.get("o");
        if (str == null) {
            return -1;
        }
        if ("p".equalsIgnoreCase(str)) {
            return 7;
        }
        if ("l".equalsIgnoreCase(str)) {
            return 6;
        }
        if ("c".equalsIgnoreCase(str)) {
            return zzs.zze().zzh();
        }
        return -1;
    }

    static Uri zze(Context context, zzfh zzfh, Uri uri, View view, Activity activity) {
        if (zzfh == null) {
            return uri;
        }
        try {
            if (zzfh.zzf(uri)) {
                return zzfh.zze(uri, context, view, activity);
            }
            return uri;
        } catch (zzfi unused) {
            return uri;
        } catch (Exception e) {
            zzs.zzg().zzg(e, "OpenGmsgHandler.maybeAddClickSignalsToUri");
            return uri;
        }
    }

    static Uri zzf(Uri uri) {
        try {
            if (uri.getQueryParameter("aclk_ms") != null) {
                return uri.buildUpon().appendQueryParameter("aclk_upms", String.valueOf(SystemClock.uptimeMillis())).build();
            }
        } catch (UnsupportedOperationException e) {
            String valueOf = String.valueOf(uri.toString());
            zzbbk.zzg(valueOf.length() != 0 ? "Error adding click uptime parameter to url: ".concat(valueOf) : new String("Error adding click uptime parameter to url: "), e);
        }
        return uri;
    }

    private final boolean zzh(T t, Context context, String str, String str2) {
        String str3 = str2;
        zzs.zzc();
        boolean zzH = zzr.zzH(context);
        zzs.zzc();
        zzbh zzC = zzr.zzC(context);
        zzcni zzcni = this.zzb;
        if (zzcni != null) {
            zzcvs.zzd(context, zzcni, this.zzc, this.zzf, str2, "offline_open");
        }
        zzbgf zzbgf = (zzbgf) t;
        boolean z = zzbgf.zzP().zzg() && zzbgf.zzj() == null;
        if (zzH) {
            this.zzf.zzc(this.zzd, str3);
            return false;
        }
        zzs.zzc();
        if (NotificationManagerCompat.from(context).areNotificationsEnabled() && zzC != null && !z) {
            if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzfA)).booleanValue()) {
                if (zzbgf.zzP().zzg()) {
                    zzcvs.zzc(zzbgf.zzj(), (zzm) null, zzC, this.zzf, this.zzb, this.zzc, str2, str);
                } else {
                    ((zzbhl) t).zzaJ(zzC, this.zzf, this.zzb, this.zzc, str2, str, zzs.zze().zzh());
                }
                zzcni zzcni2 = this.zzb;
                if (zzcni2 != null) {
                    zzcvs.zzd(context, zzcni2, this.zzc, this.zzf, str2, "dialog_impression");
                }
                t.onAdClicked();
                return true;
            }
        }
        this.zzf.zzd(str3);
        if (this.zzb != null) {
            HashMap hashMap = new HashMap();
            zzs.zzc();
            if (!NotificationManagerCompat.from(context).areNotificationsEnabled()) {
                hashMap.put("dialog_not_shown_reason", "notifications_disabled");
            } else if (zzC == null) {
                hashMap.put("dialog_not_shown_reason", "work_manager_unavailable");
            } else {
                if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzfA)).booleanValue()) {
                    hashMap.put("dialog_not_shown_reason", "notification_flow_disabled");
                } else if (z) {
                    hashMap.put("dialog_not_shown_reason", "fullscreen_no_activity");
                }
            }
            zzcvs.zzh(context, this.zzb, this.zzc, this.zzf, str2, "dialog_not_shown", hashMap);
        }
        return false;
    }

    private final void zzi(T t, Intent intent) {
        try {
            ((zzbhl) t).zzaF(new zzc(intent, this.zzg));
        } catch (ActivityNotFoundException e) {
            zzbbk.zzi(e.getMessage());
        }
    }

    private final void zzj(boolean z) {
        zzate zzate = this.zze;
        if (zzate != null) {
            zzate.zzb(z);
        }
    }

    /* access modifiers changed from: private */
    public final void zzk(int i) {
        if (this.zzb != null) {
            if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzfI)).booleanValue()) {
                zzdvo zzdvo = this.zzc;
                zzdvn zza2 = zzdvn.zza("cct_action");
                zza2.zzc("cct_open_status", zzafn.zza(i));
                zzdvo.zza(zza2);
                return;
            }
            zzcnh zza3 = this.zzb.zza();
            zza3.zzc("action", "cct_action");
            zza3.zzc("cct_open_status", zzafn.zza(i));
            zza3.zzd();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0294, code lost:
        if (com.google.android.gms.internal.ads.zzakz.zzb(r12, r4, r6, r9) == null) goto L_0x0296;
     */
    /* renamed from: zzb */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r23, java.util.Map<java.lang.String, java.lang.String> r24) {
        /*
            r22 = this;
            r1 = r22
            r2 = r23
            r3 = r24
            java.lang.String r0 = "u"
            java.lang.Object r4 = r3.get(r0)
            java.lang.String r4 = (java.lang.String) r4
            r5 = r2
            com.google.android.gms.internal.ads.zzbgf r5 = (com.google.android.gms.internal.ads.zzbgf) r5
            android.content.Context r6 = r5.getContext()
            r7 = 1
            java.lang.String r4 = com.google.android.gms.internal.ads.zzazv.zza(r4, r6, r7)
            java.lang.String r6 = "a"
            java.lang.Object r6 = r3.get(r6)
            java.lang.String r6 = (java.lang.String) r6
            if (r6 != 0) goto L_0x002a
            java.lang.String r0 = "Action missing from an open GMSG."
            com.google.android.gms.internal.ads.zzbbk.zzi(r0)
            return
        L_0x002a:
            com.google.android.gms.ads.internal.zzb r8 = r1.zza
            if (r8 == 0) goto L_0x003b
            boolean r8 = r8.zzb()
            if (r8 == 0) goto L_0x0035
            goto L_0x003b
        L_0x0035:
            com.google.android.gms.ads.internal.zzb r0 = r1.zza
            r0.zzc(r4)
            return
        L_0x003b:
            com.google.android.gms.internal.ads.zzdqo r8 = r5.zzF()
            com.google.android.gms.internal.ads.zzdqr r9 = r5.zzaB()
            r10 = 0
            java.lang.String r11 = ""
            if (r8 == 0) goto L_0x004f
            if (r9 == 0) goto L_0x004f
            boolean r8 = r8.zzad
            java.lang.String r11 = r9.zzb
            goto L_0x0050
        L_0x004f:
            r8 = 0
        L_0x0050:
            java.lang.String r9 = "expand"
            boolean r9 = r9.equalsIgnoreCase(r6)
            if (r9 == 0) goto L_0x0076
            boolean r0 = r5.zzW()
            if (r0 == 0) goto L_0x0064
            java.lang.String r0 = "Cannot expand WebView that is already expanded."
            com.google.android.gms.internal.ads.zzbbk.zzi(r0)
            return
        L_0x0064:
            r1.zzj(r10)
            r0 = r2
            com.google.android.gms.internal.ads.zzbhl r0 = (com.google.android.gms.internal.ads.zzbhl) r0
            boolean r2 = zzc(r24)
            int r3 = zzd(r24)
            r0.zzaG(r2, r3)
            return
        L_0x0076:
            java.lang.String r9 = "webapp"
            boolean r9 = r9.equalsIgnoreCase(r6)
            if (r9 == 0) goto L_0x00b1
            r1.zzj(r10)
            if (r4 == 0) goto L_0x0092
            r0 = r2
            com.google.android.gms.internal.ads.zzbhl r0 = (com.google.android.gms.internal.ads.zzbhl) r0
            boolean r2 = zzc(r24)
            int r3 = zzd(r24)
            r0.zzaH(r2, r3, r4)
            return
        L_0x0092:
            r0 = r2
            com.google.android.gms.internal.ads.zzbhl r0 = (com.google.android.gms.internal.ads.zzbhl) r0
            boolean r2 = zzc(r24)
            int r4 = zzd(r24)
            java.lang.String r5 = "html"
            java.lang.Object r5 = r3.get(r5)
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r6 = "baseurl"
            java.lang.Object r3 = r3.get(r6)
            java.lang.String r3 = (java.lang.String) r3
            r0.zzaI(r2, r4, r5, r3)
            return
        L_0x00b1:
            java.lang.String r9 = "chrome_custom_tab"
            boolean r9 = r9.equalsIgnoreCase(r6)
            if (r9 == 0) goto L_0x01a6
            android.content.Context r9 = r5.getContext()
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r12 = com.google.android.gms.internal.ads.zzaeq.zzcJ
            com.google.android.gms.internal.ads.zzaeo r13 = com.google.android.gms.internal.ads.zzaaa.zzc()
            java.lang.Object r12 = r13.zzb(r12)
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 != 0) goto L_0x00d1
            goto L_0x01a6
        L_0x00d1:
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r12 = com.google.android.gms.internal.ads.zzaeq.zzcP
            com.google.android.gms.internal.ads.zzaeo r13 = com.google.android.gms.internal.ads.zzaaa.zzc()
            java.lang.Object r12 = r13.zzb(r12)
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L_0x00ea
            java.lang.String r9 = "User opt out chrome custom tab."
            com.google.android.gms.ads.internal.util.zze.zza(r9)
            goto L_0x01a6
        L_0x00ea:
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r12 = com.google.android.gms.internal.ads.zzaeq.zzcN
            com.google.android.gms.internal.ads.zzaeo r13 = com.google.android.gms.internal.ads.zzaaa.zzc()
            java.lang.Object r12 = r13.zzb(r12)
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 != 0) goto L_0x00fd
            goto L_0x0139
        L_0x00fd:
            com.google.android.gms.internal.ads.zzaei<java.lang.String> r12 = com.google.android.gms.internal.ads.zzaeq.zzcO
            com.google.android.gms.internal.ads.zzaeo r13 = com.google.android.gms.internal.ads.zzaaa.zzc()
            java.lang.Object r12 = r13.zzb(r12)
            java.lang.String r12 = (java.lang.String) r12
            boolean r13 = r12.isEmpty()
            if (r13 != 0) goto L_0x01a6
            if (r9 == 0) goto L_0x01a6
            java.lang.String r9 = r9.getPackageName()
            r13 = 59
            com.google.android.gms.internal.ads.zzeby r13 = com.google.android.gms.internal.ads.zzeby.zzb(r13)
            com.google.android.gms.internal.ads.zzecq r13 = com.google.android.gms.internal.ads.zzecq.zza(r13)
            java.lang.Iterable r12 = r13.zzb(r12)
            java.util.Iterator r12 = r12.iterator()
        L_0x0127:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x01a6
            java.lang.Object r13 = r12.next()
            java.lang.String r13 = (java.lang.String) r13
            boolean r13 = r13.equals(r9)
            if (r13 == 0) goto L_0x0127
        L_0x0139:
            r1.zzj(r7)
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 == 0) goto L_0x014c
            java.lang.String r0 = "Cannot open browser with null or empty url"
            com.google.android.gms.internal.ads.zzbbk.zzi(r0)
            r0 = 7
            r1.zzk(r0)
            return
        L_0x014c:
            android.net.Uri r0 = android.net.Uri.parse(r4)
            android.content.Context r3 = r5.getContext()
            com.google.android.gms.internal.ads.zzfh r4 = r5.zzU()
            android.view.View r6 = r5.zzH()
            android.app.Activity r7 = r5.zzj()
            android.net.Uri r0 = zze(r3, r4, r0, r6, r7)
            android.net.Uri r0 = zzf(r0)
            if (r8 == 0) goto L_0x017d
            com.google.android.gms.internal.ads.zzcvk r3 = r1.zzf
            if (r3 == 0) goto L_0x017d
            android.content.Context r3 = r5.getContext()
            java.lang.String r4 = r0.toString()
            boolean r3 = r1.zzh(r2, r3, r4, r11)
            if (r3 == 0) goto L_0x017d
            return
        L_0x017d:
            com.google.android.gms.internal.ads.zzakx r3 = new com.google.android.gms.internal.ads.zzakx
            r3.<init>(r1)
            r1.zzg = r3
            com.google.android.gms.internal.ads.zzbhl r2 = (com.google.android.gms.internal.ads.zzbhl) r2
            com.google.android.gms.ads.internal.overlay.zzc r14 = new com.google.android.gms.ads.internal.overlay.zzc
            r4 = 0
            java.lang.String r5 = r0.toString()
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            com.google.android.gms.ads.internal.overlay.zzu r0 = r1.zzg
            com.google.android.gms.dynamic.IObjectWrapper r0 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r0)
            android.os.IBinder r12 = r0.asBinder()
            r13 = 1
            r3 = r14
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r2.zzaF(r14)
            return
        L_0x01a6:
            java.lang.String r9 = "app"
            boolean r9 = r9.equalsIgnoreCase(r6)
            r12 = 0
            if (r9 == 0) goto L_0x0313
            java.lang.String r9 = "system_browser"
            java.lang.Object r9 = r3.get(r9)
            java.lang.String r9 = (java.lang.String) r9
            java.lang.String r13 = "true"
            boolean r9 = r13.equalsIgnoreCase(r9)
            if (r9 == 0) goto L_0x0313
            r1.zzj(r7)
            android.content.Context r4 = r5.getContext()
            com.google.android.gms.internal.ads.zzfh r6 = r5.zzU()
            android.view.View r9 = r5.zzH()
            java.lang.String r13 = "activity"
            java.lang.Object r13 = r4.getSystemService(r13)
            android.app.ActivityManager r13 = (android.app.ActivityManager) r13
            java.lang.Object r0 = r3.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            boolean r14 = android.text.TextUtils.isEmpty(r0)
            if (r14 == 0) goto L_0x01e4
            goto L_0x02f4
        L_0x01e4:
            android.net.Uri r0 = android.net.Uri.parse(r0)
            android.net.Uri r0 = zze(r4, r6, r0, r9, r12)
            android.net.Uri r0 = zzf(r0)
            java.lang.String r14 = "use_first_package"
            java.lang.Object r14 = r3.get(r14)
            java.lang.String r14 = (java.lang.String) r14
            boolean r14 = java.lang.Boolean.parseBoolean(r14)
            java.lang.String r15 = "use_running_process"
            java.lang.Object r15 = r3.get(r15)
            java.lang.String r15 = (java.lang.String) r15
            boolean r15 = java.lang.Boolean.parseBoolean(r15)
            java.lang.String r12 = "use_custom_tabs"
            java.lang.Object r3 = r3.get(r12)
            java.lang.String r3 = (java.lang.String) r3
            boolean r3 = java.lang.Boolean.parseBoolean(r3)
            if (r3 != 0) goto L_0x022a
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzaeq.zzcH
            com.google.android.gms.internal.ads.zzaeo r12 = com.google.android.gms.internal.ads.zzaaa.zzc()
            java.lang.Object r3 = r12.zzb(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x0229
            goto L_0x022a
        L_0x0229:
            r7 = 0
        L_0x022a:
            java.lang.String r3 = r0.getScheme()
            java.lang.String r12 = "http"
            boolean r3 = r12.equalsIgnoreCase(r3)
            java.lang.String r10 = "https"
            if (r3 == 0) goto L_0x0245
            android.net.Uri$Builder r3 = r0.buildUpon()
            android.net.Uri$Builder r3 = r3.scheme(r10)
            android.net.Uri r12 = r3.build()
            goto L_0x025d
        L_0x0245:
            java.lang.String r3 = r0.getScheme()
            boolean r3 = r10.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x025c
            android.net.Uri$Builder r3 = r0.buildUpon()
            android.net.Uri$Builder r3 = r3.scheme(r12)
            android.net.Uri r12 = r3.build()
            goto L_0x025d
        L_0x025c:
            r12 = 0
        L_0x025d:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            android.content.Intent r0 = com.google.android.gms.internal.ads.zzakz.zza(r0, r4, r6, r9)
            android.content.Intent r10 = com.google.android.gms.internal.ads.zzakz.zza(r12, r4, r6, r9)
            if (r7 == 0) goto L_0x0278
            com.google.android.gms.ads.internal.zzs.zzc()
            com.google.android.gms.ads.internal.util.zzr.zzu(r4, r0)
            com.google.android.gms.ads.internal.zzs.zzc()
            com.google.android.gms.ads.internal.util.zzr.zzu(r4, r10)
        L_0x0278:
            android.content.pm.ResolveInfo r7 = com.google.android.gms.internal.ads.zzakz.zzc(r0, r3, r4, r6, r9)
            if (r7 == 0) goto L_0x0284
            android.content.Intent r12 = com.google.android.gms.internal.ads.zzakz.zzd(r0, r7, r4, r6, r9)
            goto L_0x02f4
        L_0x0284:
            if (r10 == 0) goto L_0x0296
            android.content.pm.ResolveInfo r7 = com.google.android.gms.internal.ads.zzakz.zzb(r10, r4, r6, r9)
            if (r7 == 0) goto L_0x0296
            android.content.Intent r12 = com.google.android.gms.internal.ads.zzakz.zzd(r0, r7, r4, r6, r9)
            android.content.pm.ResolveInfo r7 = com.google.android.gms.internal.ads.zzakz.zzb(r12, r4, r6, r9)
            if (r7 != 0) goto L_0x02f4
        L_0x0296:
            int r7 = r3.size()
            if (r7 != 0) goto L_0x029d
            goto L_0x02f3
        L_0x029d:
            if (r15 == 0) goto L_0x02e5
            if (r13 == 0) goto L_0x02e5
            java.util.List r7 = r13.getRunningAppProcesses()
            if (r7 == 0) goto L_0x02e5
            int r10 = r3.size()
            r12 = 0
        L_0x02ac:
            if (r12 >= r10) goto L_0x02e5
            java.lang.Object r13 = r3.get(r12)
            android.content.pm.ResolveInfo r13 = (android.content.pm.ResolveInfo) r13
            java.util.Iterator r15 = r7.iterator()
        L_0x02b8:
            int r16 = r12 + 1
            boolean r18 = r15.hasNext()
            if (r18 == 0) goto L_0x02e2
            java.lang.Object r16 = r15.next()
            r24 = r7
            r7 = r16
            android.app.ActivityManager$RunningAppProcessInfo r7 = (android.app.ActivityManager.RunningAppProcessInfo) r7
            java.lang.String r7 = r7.processName
            r18 = r10
            android.content.pm.ActivityInfo r10 = r13.activityInfo
            java.lang.String r10 = r10.packageName
            boolean r7 = r7.equals(r10)
            if (r7 == 0) goto L_0x02dd
            android.content.Intent r12 = com.google.android.gms.internal.ads.zzakz.zzd(r0, r13, r4, r6, r9)
            goto L_0x02f4
        L_0x02dd:
            r7 = r24
            r10 = r18
            goto L_0x02b8
        L_0x02e2:
            r12 = r16
            goto L_0x02ac
        L_0x02e5:
            if (r14 == 0) goto L_0x02f3
            r7 = 0
            java.lang.Object r3 = r3.get(r7)
            android.content.pm.ResolveInfo r3 = (android.content.pm.ResolveInfo) r3
            android.content.Intent r12 = com.google.android.gms.internal.ads.zzakz.zzd(r0, r3, r4, r6, r9)
            goto L_0x02f4
        L_0x02f3:
            r12 = r0
        L_0x02f4:
            if (r8 == 0) goto L_0x030f
            com.google.android.gms.internal.ads.zzcvk r0 = r1.zzf
            if (r0 == 0) goto L_0x030f
            if (r12 == 0) goto L_0x030f
            android.content.Context r0 = r5.getContext()
            android.net.Uri r3 = r12.getData()
            java.lang.String r3 = r3.toString()
            boolean r0 = r1.zzh(r2, r0, r3, r11)
            if (r0 == 0) goto L_0x030f
            return
        L_0x030f:
            r1.zzi(r2, r12)
            return
        L_0x0313:
            java.lang.String r0 = "open_app"
            boolean r0 = r0.equalsIgnoreCase(r6)
            java.lang.String r9 = "p"
            if (r0 == 0) goto L_0x0376
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzaeq.zzfs
            com.google.android.gms.internal.ads.zzaeo r4 = com.google.android.gms.internal.ads.zzaaa.zzc()
            java.lang.Object r0 = r4.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0330
            return
        L_0x0330:
            r1.zzj(r7)
            java.lang.Object r0 = r3.get(r9)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x0341
            java.lang.String r0 = "Package name missing from open app action."
            com.google.android.gms.internal.ads.zzbbk.zzi(r0)
            return
        L_0x0341:
            if (r8 == 0) goto L_0x0353
            com.google.android.gms.internal.ads.zzcvk r3 = r1.zzf
            if (r3 == 0) goto L_0x0353
            android.content.Context r3 = r5.getContext()
            boolean r3 = r1.zzh(r2, r3, r0, r11)
            if (r3 != 0) goto L_0x0352
            goto L_0x0353
        L_0x0352:
            return
        L_0x0353:
            android.content.Context r3 = r5.getContext()
            android.content.pm.PackageManager r3 = r3.getPackageManager()
            if (r3 != 0) goto L_0x0363
            java.lang.String r0 = "Cannot get package manager from open app action."
            com.google.android.gms.internal.ads.zzbbk.zzi(r0)
            return
        L_0x0363:
            android.content.Intent r0 = r3.getLaunchIntentForPackage(r0)
            if (r0 == 0) goto L_0x0375
            com.google.android.gms.internal.ads.zzbhl r2 = (com.google.android.gms.internal.ads.zzbhl) r2
            com.google.android.gms.ads.internal.overlay.zzc r3 = new com.google.android.gms.ads.internal.overlay.zzc
            com.google.android.gms.ads.internal.overlay.zzu r4 = r1.zzg
            r3.<init>(r0, r4)
            r2.zzaF(r3)
        L_0x0375:
            return
        L_0x0376:
            r1.zzj(r7)
            java.lang.String r0 = "intent_url"
            java.lang.Object r0 = r3.get(r0)
            r10 = r0
            java.lang.String r10 = (java.lang.String) r10
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            if (r0 != 0) goto L_0x03aa
            r12 = 0
            android.content.Intent r0 = android.content.Intent.parseUri(r10, r12)     // Catch:{ URISyntaxException -> 0x038e }
            goto L_0x03ac
        L_0x038e:
            r0 = move-exception
            r13 = r0
            java.lang.String r0 = java.lang.String.valueOf(r10)
            java.lang.String r10 = "Error parsing the url: "
            int r14 = r0.length()
            if (r14 == 0) goto L_0x03a1
            java.lang.String r0 = r10.concat(r0)
            goto L_0x03a6
        L_0x03a1:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r10)
        L_0x03a6:
            com.google.android.gms.internal.ads.zzbbk.zzg(r0, r13)
            goto L_0x03ab
        L_0x03aa:
            r12 = 0
        L_0x03ab:
            r0 = 0
        L_0x03ac:
            if (r0 == 0) goto L_0x03ff
            android.net.Uri r10 = r0.getData()
            if (r10 == 0) goto L_0x03ff
            android.net.Uri r10 = r0.getData()
            android.net.Uri r13 = android.net.Uri.EMPTY
            boolean r13 = r13.equals(r10)
            if (r13 != 0) goto L_0x03ff
            android.content.Context r13 = r5.getContext()
            com.google.android.gms.internal.ads.zzfh r14 = r5.zzU()
            android.view.View r15 = r5.zzH()
            android.app.Activity r7 = r5.zzj()
            android.net.Uri r7 = zze(r13, r14, r10, r15, r7)
            android.net.Uri r7 = zzf(r7)
            java.lang.String r10 = r0.getType()
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x03fc
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r10 = com.google.android.gms.internal.ads.zzaeq.zzft
            com.google.android.gms.internal.ads.zzaeo r13 = com.google.android.gms.internal.ads.zzaaa.zzc()
            java.lang.Object r10 = r13.zzb(r10)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x03fc
            java.lang.String r10 = r0.getType()
            r0.setDataAndType(r7, r10)
            goto L_0x03ff
        L_0x03fc:
            r0.setData(r7)
        L_0x03ff:
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r7 = com.google.android.gms.internal.ads.zzaeq.zzfE
            com.google.android.gms.internal.ads.zzaeo r10 = com.google.android.gms.internal.ads.zzaaa.zzc()
            java.lang.Object r7 = r10.zzb(r7)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            java.lang.String r10 = "event_id"
            if (r7 == 0) goto L_0x0423
            java.lang.String r7 = "intent_async"
            boolean r6 = r7.equalsIgnoreCase(r6)
            if (r6 == 0) goto L_0x0423
            boolean r6 = r3.containsKey(r10)
            if (r6 == 0) goto L_0x0423
            r7 = 1
            goto L_0x0424
        L_0x0423:
            r7 = 0
        L_0x0424:
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            if (r7 == 0) goto L_0x0432
            com.google.android.gms.internal.ads.zzaky r12 = new com.google.android.gms.internal.ads.zzaky
            r12.<init>(r1, r6, r3, r2)
            r1.zzg = r12
        L_0x0432:
            java.lang.String r12 = "openIntentAsync"
            if (r0 == 0) goto L_0x046f
            if (r8 == 0) goto L_0x0462
            com.google.android.gms.internal.ads.zzcvk r4 = r1.zzf
            if (r4 == 0) goto L_0x0462
            android.content.Context r4 = r5.getContext()
            android.net.Uri r5 = r0.getData()
            java.lang.String r5 = r5.toString()
            boolean r4 = r1.zzh(r2, r4, r5, r11)
            if (r4 == 0) goto L_0x0462
            if (r7 == 0) goto L_0x0461
            java.lang.Object r0 = r3.get(r10)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            r6.put(r0, r3)
            r0 = r2
            com.google.android.gms.internal.ads.zzang r0 = (com.google.android.gms.internal.ads.zzang) r0
            r0.zze(r12, r6)
        L_0x0461:
            return
        L_0x0462:
            com.google.android.gms.internal.ads.zzbhl r2 = (com.google.android.gms.internal.ads.zzbhl) r2
            com.google.android.gms.ads.internal.overlay.zzc r3 = new com.google.android.gms.ads.internal.overlay.zzc
            com.google.android.gms.ads.internal.overlay.zzu r4 = r1.zzg
            r3.<init>(r0, r4)
            r2.zzaF(r3)
            return
        L_0x046f:
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 != 0) goto L_0x0495
            android.net.Uri r0 = android.net.Uri.parse(r4)
            android.content.Context r4 = r5.getContext()
            com.google.android.gms.internal.ads.zzfh r13 = r5.zzU()
            android.view.View r14 = r5.zzH()
            android.app.Activity r15 = r5.zzj()
            android.net.Uri r0 = zze(r4, r13, r0, r14, r15)
            android.net.Uri r0 = zzf(r0)
            java.lang.String r4 = r0.toString()
        L_0x0495:
            r15 = r4
            if (r8 == 0) goto L_0x04ba
            com.google.android.gms.internal.ads.zzcvk r0 = r1.zzf
            if (r0 == 0) goto L_0x04ba
            android.content.Context r0 = r5.getContext()
            boolean r0 = r1.zzh(r2, r0, r15, r11)
            if (r0 == 0) goto L_0x04ba
            if (r7 == 0) goto L_0x04b9
            java.lang.Object r0 = r3.get(r10)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            r6.put(r0, r3)
            r0 = r2
            com.google.android.gms.internal.ads.zzang r0 = (com.google.android.gms.internal.ads.zzang) r0
            r0.zze(r12, r6)
        L_0x04b9:
            return
        L_0x04ba:
            r0 = r2
            com.google.android.gms.internal.ads.zzbhl r0 = (com.google.android.gms.internal.ads.zzbhl) r0
            com.google.android.gms.ads.internal.overlay.zzc r2 = new com.google.android.gms.ads.internal.overlay.zzc
            java.lang.String r4 = "i"
            java.lang.Object r4 = r3.get(r4)
            r14 = r4
            java.lang.String r14 = (java.lang.String) r14
            java.lang.String r4 = "m"
            java.lang.Object r4 = r3.get(r4)
            r16 = r4
            java.lang.String r16 = (java.lang.String) r16
            java.lang.Object r4 = r3.get(r9)
            r17 = r4
            java.lang.String r17 = (java.lang.String) r17
            java.lang.String r4 = "c"
            java.lang.Object r4 = r3.get(r4)
            r18 = r4
            java.lang.String r18 = (java.lang.String) r18
            java.lang.String r4 = "f"
            java.lang.Object r4 = r3.get(r4)
            r19 = r4
            java.lang.String r19 = (java.lang.String) r19
            java.lang.String r4 = "e"
            java.lang.Object r3 = r3.get(r4)
            r20 = r3
            java.lang.String r20 = (java.lang.String) r20
            com.google.android.gms.ads.internal.overlay.zzu r3 = r1.zzg
            r13 = r2
            r21 = r3
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21)
            r0.zzaF(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzala.zza(com.google.android.gms.internal.ads.zzyi, java.util.Map):void");
    }
}
