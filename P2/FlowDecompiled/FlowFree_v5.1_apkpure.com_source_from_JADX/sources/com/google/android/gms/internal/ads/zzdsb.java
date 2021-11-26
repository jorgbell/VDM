package com.google.android.gms.internal.ads;

import android.os.IBinder;
import com.google.android.gms.ads.internal.util.zzap;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdsb {
    public static zzym zza(Throwable th) {
        if (th instanceof zzcwa) {
            zzcwa zzcwa = (zzcwa) th;
            return zzc(zzcwa.zza(), zzcwa.zzb());
        } else if (th instanceof zzcql) {
            if (th.getMessage() == null) {
                return zzd(((zzcql) th).zza(), (String) null, (zzym) null);
            }
            return zzd(((zzcql) th).zza(), th.getMessage(), (zzym) null);
        } else if (!(th instanceof zzap)) {
            return zzd(1, (String) null, (zzym) null);
        } else {
            zzap zzap = (zzap) th;
            return new zzym(zzap.zza(), zzecs.zza(zzap.getMessage()), "com.google.android.gms.ads", (zzym) null, (IBinder) null);
        }
    }

    public static zzym zzb(Throwable th, zzcwb zzcwb) {
        zzym zzym;
        zzym zza = zza(th);
        int i = zza.zza;
        if ((i == 3 || i == 0) && (zzym = zza.zzd) != null && !zzym.zzc.equals("com.google.android.gms.ads")) {
            zza.zzd = null;
        }
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzfx)).booleanValue() && zzcwb != null) {
            zza.zze = zzcwb.zzc();
        }
        return zza;
    }

    public static zzym zzc(int i, zzym zzym) {
        if (i != 0) {
            if (i == 8) {
                if (((Integer) zzaaa.zzc().zzb(zzaeq.zzfu)).intValue() > 0) {
                    return zzym;
                }
                i = 8;
            }
            return zzd(i, (String) null, zzym);
        }
        throw null;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004b, code lost:
        r4 = "No fill.";
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzym zzd(int r8, java.lang.String r9, com.google.android.gms.internal.ads.zzym r10) {
        /*
            java.lang.String r0 = "No fill."
            r1 = 0
            if (r9 != 0) goto L_0x0051
            int r9 = r8 + -1
            if (r8 == 0) goto L_0x0050
            switch(r9) {
                case 1: goto L_0x004d;
                case 2: goto L_0x004b;
                case 3: goto L_0x0048;
                case 4: goto L_0x0045;
                case 5: goto L_0x0042;
                case 6: goto L_0x003f;
                case 7: goto L_0x003c;
                case 8: goto L_0x0039;
                case 9: goto L_0x0036;
                case 10: goto L_0x0033;
                case 11: goto L_0x000c;
                case 12: goto L_0x001e;
                case 13: goto L_0x001b;
                case 14: goto L_0x0018;
                case 15: goto L_0x0015;
                case 16: goto L_0x0012;
                case 17: goto L_0x000f;
                default: goto L_0x000c;
            }
        L_0x000c:
            java.lang.String r9 = "Internal error."
            goto L_0x0051
        L_0x000f:
            java.lang.String r9 = "Ad inspector cannot be opened because it is already open."
            goto L_0x0051
        L_0x0012:
            java.lang.String r9 = "Ad inspector cannot be opened because the device is not in test mode. See https://developers.google.com/admob/android/test-ads#enable_test_devices for more information."
            goto L_0x0051
        L_0x0015:
            java.lang.String r9 = "Ad inspector failed to load."
            goto L_0x0051
        L_0x0018:
            java.lang.String r9 = "Ad inspector had an internal error."
            goto L_0x0051
        L_0x001b:
            java.lang.String r9 = "Mismatch request IDs."
            goto L_0x0051
        L_0x001e:
            com.google.android.gms.internal.ads.zzaei<java.lang.Integer> r9 = com.google.android.gms.internal.ads.zzaeq.zzfy
            com.google.android.gms.internal.ads.zzaeo r2 = com.google.android.gms.internal.ads.zzaaa.zzc()
            java.lang.Object r9 = r2.zzb(r9)
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            if (r9 > 0) goto L_0x004b
            java.lang.String r9 = "The mediation adapter did not return an ad."
            goto L_0x0051
        L_0x0033:
            java.lang.String r9 = "The ad can not be shown when app is not in foreground."
            goto L_0x0051
        L_0x0036:
            java.lang.String r9 = "The ad has already been shown."
            goto L_0x0051
        L_0x0039:
            java.lang.String r9 = "The ad is not ready."
            goto L_0x0051
        L_0x003c:
            java.lang.String r9 = "A mediation adapter failed to show the ad."
            goto L_0x0051
        L_0x003f:
            java.lang.String r9 = "Invalid request: Invalid ad size."
            goto L_0x0051
        L_0x0042:
            java.lang.String r9 = "Invalid request: Invalid ad unit ID."
            goto L_0x0051
        L_0x0045:
            java.lang.String r9 = "Network error."
            goto L_0x0051
        L_0x0048:
            java.lang.String r9 = "App ID missing."
            goto L_0x0051
        L_0x004b:
            r4 = r0
            goto L_0x0052
        L_0x004d:
            java.lang.String r9 = "Invalid request."
            goto L_0x0051
        L_0x0050:
            throw r1
        L_0x0051:
            r4 = r9
        L_0x0052:
            int r9 = r8 + -1
            com.google.android.gms.internal.ads.zzym r0 = new com.google.android.gms.internal.ads.zzym
            if (r8 == 0) goto L_0x00e7
            r1 = 2
            r2 = 1
            r3 = 0
            r5 = 3
            switch(r9) {
                case 0: goto L_0x0091;
                case 1: goto L_0x0090;
                case 2: goto L_0x008e;
                case 3: goto L_0x0089;
                case 4: goto L_0x0087;
                case 5: goto L_0x0090;
                case 6: goto L_0x0090;
                case 7: goto L_0x0084;
                case 8: goto L_0x0087;
                case 9: goto L_0x0090;
                case 10: goto L_0x008e;
                case 11: goto L_0x0091;
                case 12: goto L_0x006d;
                case 13: goto L_0x0068;
                case 14: goto L_0x0091;
                case 15: goto L_0x0090;
                case 16: goto L_0x0087;
                case 17: goto L_0x008e;
                default: goto L_0x005f;
            }
        L_0x005f:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            switch(r8) {
                case 1: goto L_0x00ca;
                case 2: goto L_0x00c7;
                case 3: goto L_0x00c4;
                case 4: goto L_0x00c1;
                case 5: goto L_0x00be;
                case 6: goto L_0x00bb;
                case 7: goto L_0x00b8;
                case 8: goto L_0x00b5;
                case 9: goto L_0x00b2;
                case 10: goto L_0x00af;
                case 11: goto L_0x00ac;
                case 12: goto L_0x00a9;
                case 13: goto L_0x00a6;
                case 14: goto L_0x00a3;
                case 15: goto L_0x00a0;
                case 16: goto L_0x009d;
                case 17: goto L_0x009a;
                default: goto L_0x0064;
            }
        L_0x0064:
            java.lang.String r8 = "AD_INSPECTOR_ALREADY_OPEN"
            goto L_0x00cc
        L_0x0068:
            r8 = 10
            r3 = 10
            goto L_0x0091
        L_0x006d:
            com.google.android.gms.internal.ads.zzaei<java.lang.Integer> r8 = com.google.android.gms.internal.ads.zzaeq.zzfy
            com.google.android.gms.internal.ads.zzaeo r9 = com.google.android.gms.internal.ads.zzaaa.zzc()
            java.lang.Object r8 = r9.zzb(r8)
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            if (r8 > 0) goto L_0x008e
            r8 = 9
            r3 = 9
            goto L_0x0091
        L_0x0084:
            r8 = 4
            r3 = 4
            goto L_0x0091
        L_0x0087:
            r3 = 2
            goto L_0x0091
        L_0x0089:
            r8 = 8
            r3 = 8
            goto L_0x0091
        L_0x008e:
            r3 = 3
            goto L_0x0091
        L_0x0090:
            r3 = 1
        L_0x0091:
            r7 = 0
            java.lang.String r5 = "com.google.android.gms.ads"
            r2 = r0
            r6 = r10
            r2.<init>(r3, r4, r5, r6, r7)
            return r0
        L_0x009a:
            java.lang.String r8 = "AD_INSPECTOR_NOT_IN_TEST_MODE"
            goto L_0x00cc
        L_0x009d:
            java.lang.String r8 = "AD_INSPECTOR_FAILED_TO_LOAD"
            goto L_0x00cc
        L_0x00a0:
            java.lang.String r8 = "AD_INSPECTOR_INTERNAL_ERROR"
            goto L_0x00cc
        L_0x00a3:
            java.lang.String r8 = "REQUEST_ID_MISMATCH"
            goto L_0x00cc
        L_0x00a6:
            java.lang.String r8 = "MEDIATION_NO_FILL"
            goto L_0x00cc
        L_0x00a9:
            java.lang.String r8 = "INTERNAL_SHOW_ERROR"
            goto L_0x00cc
        L_0x00ac:
            java.lang.String r8 = "APP_NOT_FOREGROUND"
            goto L_0x00cc
        L_0x00af:
            java.lang.String r8 = "AD_REUSED"
            goto L_0x00cc
        L_0x00b2:
            java.lang.String r8 = "NOT_READY"
            goto L_0x00cc
        L_0x00b5:
            java.lang.String r8 = "MEDIATION_SHOW_ERROR"
            goto L_0x00cc
        L_0x00b8:
            java.lang.String r8 = "INVALID_AD_SIZE"
            goto L_0x00cc
        L_0x00bb:
            java.lang.String r8 = "INVALID_AD_UNIT_ID"
            goto L_0x00cc
        L_0x00be:
            java.lang.String r8 = "NETWORK_ERROR"
            goto L_0x00cc
        L_0x00c1:
            java.lang.String r8 = "APP_ID_MISSING"
            goto L_0x00cc
        L_0x00c4:
            java.lang.String r8 = "NO_FILL"
            goto L_0x00cc
        L_0x00c7:
            java.lang.String r8 = "INVALID_REQUEST"
            goto L_0x00cc
        L_0x00ca:
            java.lang.String r8 = "INTERNAL_ERROR"
        L_0x00cc:
            int r10 = r8.length()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            int r10 = r10 + 18
            r0.<init>(r10)
            java.lang.String r10 = "Unknown SdkError: "
            r0.append(r10)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r9.<init>(r8)
            throw r9
        L_0x00e7:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdsb.zzd(int, java.lang.String, com.google.android.gms.internal.ads.zzym):com.google.android.gms.internal.ads.zzym");
    }
}
