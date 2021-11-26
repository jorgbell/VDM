package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.internal.ads.zzaaa;
import com.google.android.gms.internal.ads.zzaeq;
import com.google.android.gms.internal.ads.zzbbk;
import com.google.android.gms.internal.ads.zzefw;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzan {
    protected String zza = "";
    private final Object zzb = new Object();
    @GuardedBy("lock")
    private String zzc = "";
    @GuardedBy("lock")
    private String zzd = "";
    @GuardedBy("lock")
    private boolean zze = false;

    protected static final String zzh(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", zzs.zzc().zze(context, str2));
        zzefw<String> zzb2 = new zzbe(context).zzb(0, str, hashMap, (byte[]) null);
        try {
            return zzb2.get((long) ((Integer) zzaaa.zzc().zzb(zzaeq.zzcV)).intValue(), TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            String valueOf = String.valueOf(str);
            zzbbk.zzg(valueOf.length() != 0 ? "Timeout while retrieving a response from: ".concat(valueOf) : new String("Timeout while retrieving a response from: "), e);
            zzb2.cancel(true);
            return null;
        } catch (InterruptedException e2) {
            String valueOf2 = String.valueOf(str);
            zzbbk.zzg(valueOf2.length() != 0 ? "Interrupted while retrieving a response from: ".concat(valueOf2) : new String("Interrupted while retrieving a response from: "), e2);
            zzb2.cancel(true);
            return null;
        } catch (Exception e3) {
            String valueOf3 = String.valueOf(str);
            zzbbk.zzg(valueOf3.length() != 0 ? "Error retrieving a response from: ".concat(valueOf3) : new String("Error retrieving a response from: "), e3);
            return null;
        }
    }

    private final void zzi(Context context, String str, String str2) {
        zzs.zzc();
        zzr.zzV(context, zzj(context, (String) zzaaa.zzc().zzb(zzaeq.zzcR), str, str2));
    }

    private final Uri zzj(Context context, String str, String str2, String str3) {
        String str4;
        String str5;
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        synchronized (this.zzb) {
            if (TextUtils.isEmpty(this.zzc)) {
                zzs.zzc();
                try {
                    str5 = new String(IOUtils.readInputStreamFully(context.openFileInput("debug_signals_id.txt"), true), "UTF-8");
                } catch (IOException unused) {
                    zzbbk.zzd("Error reading from internal storage.");
                    str5 = "";
                }
                this.zzc = str5;
                if (TextUtils.isEmpty(str5)) {
                    zzs.zzc();
                    this.zzc = UUID.randomUUID().toString();
                    zzs.zzc();
                    String str6 = this.zzc;
                    try {
                        FileOutputStream openFileOutput = context.openFileOutput("debug_signals_id.txt", 0);
                        openFileOutput.write(str6.getBytes("UTF-8"));
                        openFileOutput.close();
                    } catch (Exception e) {
                        zzbbk.zzg("Error writing to file in internal storage.", e);
                    }
                }
            }
            str4 = this.zzc;
        }
        buildUpon.appendQueryParameter("linkedDeviceId", str4);
        buildUpon.appendQueryParameter("adSlotPath", str2);
        buildUpon.appendQueryParameter("afmaVersion", str3);
        return buildUpon.build();
    }

    public final void zza(Context context, String str, String str2) {
        String zzh = zzh(context, zzj(context, (String) zzaaa.zzc().zzb(zzaeq.zzcS), str, str2).toString(), str2);
        if (TextUtils.isEmpty(zzh)) {
            zzbbk.zzd("Not linked for in app preview.");
        } else {
            try {
                JSONObject jSONObject = new JSONObject(zzh.trim());
                String optString = jSONObject.optString("gct");
                this.zza = jSONObject.optString("status");
                synchronized (this.zzb) {
                    this.zzd = optString;
                }
                if ("2".equals(this.zza)) {
                    zzbbk.zzd("Creative is not pushed for this device.");
                    zzg(context, "There was no creative pushed from DFP to the device.", false, false);
                    return;
                } else if ("1".equals(this.zza)) {
                    zzbbk.zzd("The app is not linked for creative preview.");
                    zzi(context, str, str2);
                    return;
                } else if ("0".equals(this.zza)) {
                    zzbbk.zzd("Device is linked for in app preview.");
                    zzg(context, "The device is successfully linked for creative preview.", false, true);
                    return;
                } else {
                    return;
                }
            } catch (JSONException e) {
                zzbbk.zzj("Fail to get in app preview response json.", e);
            }
        }
        zzg(context, "In-app preview failed to load because of a system error. Please try again later.", true, true);
    }

    public final void zzb(Context context, String str, String str2, String str3) {
        boolean zzf = zzf();
        String zzh = zzh(context, zzj(context, (String) zzaaa.zzc().zzb(zzaeq.zzcT), str, str2).toString(), str2);
        if (TextUtils.isEmpty(zzh)) {
            zzbbk.zzd("Not linked for debug signals.");
        } else {
            try {
                boolean equals = "1".equals(new JSONObject(zzh.trim()).optString("debug_mode"));
                synchronized (this.zzb) {
                    this.zze = equals;
                }
                if (equals) {
                    if (!zzf && !TextUtils.isEmpty(str3)) {
                        zzd(context, str2, str3, str);
                    }
                    zzbbk.zzd("Device is linked for debug signals.");
                    zzg(context, "The device is successfully linked for troubleshooting.", false, true);
                    return;
                }
            } catch (JSONException e) {
                zzbbk.zzj("Fail to get debug mode response json.", e);
            }
        }
        zzi(context, str, str2);
    }

    public final boolean zzc(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || !zzs.zzm().zzf()) {
            return false;
        }
        zzbbk.zzd("Sending troubleshooting signals to the server.");
        zzd(context, str, str2, str3);
        return true;
    }

    public final void zzd(Context context, String str, String str2, String str3) {
        Uri.Builder buildUpon = zzj(context, (String) zzaaa.zzc().zzb(zzaeq.zzcU), str3, str).buildUpon();
        buildUpon.appendQueryParameter("debugData", str2);
        zzs.zzc();
        zzr.zzL(context, str, buildUpon.build().toString());
    }

    public final String zze() {
        String str;
        synchronized (this.zzb) {
            str = this.zzd;
        }
        return str;
    }

    public final boolean zzf() {
        boolean z;
        synchronized (this.zzb) {
            z = this.zze;
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public final void zzg(Context context, String str, boolean z, boolean z2) {
        if (!(context instanceof Activity)) {
            zzbbk.zzh("Can not create dialog without Activity Context");
        } else {
            zzr.zza.post(new zzam(this, context, str, z, z2));
        }
    }
}
