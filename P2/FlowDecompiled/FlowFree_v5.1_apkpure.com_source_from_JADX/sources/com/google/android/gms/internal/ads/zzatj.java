package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzatj extends zzatk implements zzakp<zzbgf> {
    DisplayMetrics zza;
    int zzb = -1;
    int zzc = -1;
    int zzd = -1;
    int zze = -1;
    int zzf = -1;
    int zzg = -1;
    private final zzbgf zzh;
    private final Context zzi;
    private final WindowManager zzj;
    private final zzaeb zzk;
    private float zzl;
    private int zzm;

    public zzatj(zzbgf zzbgf, Context context, zzaeb zzaeb) {
        super(zzbgf, "");
        this.zzh = zzbgf;
        this.zzi = context;
        this.zzk = zzaeb;
        this.zzj = (WindowManager) context.getSystemService("window");
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        JSONObject jSONObject;
        zzbgf zzbgf = (zzbgf) obj;
        this.zza = new DisplayMetrics();
        Display defaultDisplay = this.zzj.getDefaultDisplay();
        defaultDisplay.getMetrics(this.zza);
        this.zzl = this.zza.density;
        this.zzm = defaultDisplay.getRotation();
        zzzy.zza();
        DisplayMetrics displayMetrics = this.zza;
        this.zzb = zzbbd.zzq(displayMetrics, displayMetrics.widthPixels);
        zzzy.zza();
        DisplayMetrics displayMetrics2 = this.zza;
        this.zzc = zzbbd.zzq(displayMetrics2, displayMetrics2.heightPixels);
        Activity zzj2 = this.zzh.zzj();
        if (zzj2 == null || zzj2.getWindow() == null) {
            this.zzd = this.zzb;
            this.zze = this.zzc;
        } else {
            zzs.zzc();
            int[] zzR = zzr.zzR(zzj2);
            zzzy.zza();
            this.zzd = zzbbd.zzq(this.zza, zzR[0]);
            zzzy.zza();
            this.zze = zzbbd.zzq(this.zza, zzR[1]);
        }
        if (this.zzh.zzP().zzg()) {
            this.zzf = this.zzb;
            this.zzg = this.zzc;
        } else {
            this.zzh.measure(0, 0);
        }
        zzk(this.zzb, this.zzc, this.zzd, this.zze, this.zzl, this.zzm);
        zzati zzati = new zzati();
        zzaeb zzaeb = this.zzk;
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        zzati.zzb(zzaeb.zzc(intent));
        zzaeb zzaeb2 = this.zzk;
        Intent intent2 = new Intent("android.intent.action.VIEW");
        intent2.setData(Uri.parse("sms:"));
        zzati.zza(zzaeb2.zzc(intent2));
        zzati.zzc(this.zzk.zzb());
        zzati.zzd(this.zzk.zza());
        zzati.zze(true);
        boolean zzf2 = zzati.zza;
        boolean zzg2 = zzati.zzb;
        boolean zzh2 = zzati.zzc;
        boolean zzi2 = zzati.zzd;
        boolean zzj3 = zzati.zze;
        zzbgf zzbgf2 = this.zzh;
        try {
            jSONObject = new JSONObject().put("sms", zzf2).put("tel", zzg2).put("calendar", zzh2).put("storePicture", zzi2).put("inlineVideo", zzj3);
        } catch (JSONException e) {
            zzbbk.zzg("Error occurred while obtaining the MRAID capabilities.", e);
            jSONObject = null;
        }
        zzbgf2.zzd("onDeviceFeaturesReceived", jSONObject);
        int[] iArr = new int[2];
        this.zzh.getLocationOnScreen(iArr);
        zzb(zzzy.zza().zza(this.zzi, iArr[0]), zzzy.zza().zza(this.zzi, iArr[1]));
        if (zzbbk.zzm(2)) {
            zzbbk.zzh("Dispatching Ready Event.");
        }
        zzg(this.zzh.zzt().zza);
    }

    public final void zzb(int i, int i2) {
        int i3;
        int i4 = 0;
        if (this.zzi instanceof Activity) {
            zzs.zzc();
            i3 = zzr.zzT((Activity) this.zzi)[0];
        } else {
            i3 = 0;
        }
        if (this.zzh.zzP() == null || !this.zzh.zzP().zzg()) {
            int width = this.zzh.getWidth();
            int height = this.zzh.getHeight();
            if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzM)).booleanValue()) {
                if (width == 0) {
                    width = this.zzh.zzP() != null ? this.zzh.zzP().zzb : 0;
                }
                if (height == 0) {
                    if (this.zzh.zzP() != null) {
                        i4 = this.zzh.zzP().zza;
                    }
                    this.zzf = zzzy.zza().zza(this.zzi, width);
                    this.zzg = zzzy.zza().zza(this.zzi, i4);
                }
            }
            i4 = height;
            this.zzf = zzzy.zza().zza(this.zzi, width);
            this.zzg = zzzy.zza().zza(this.zzi, i4);
        }
        zzi(i, i2 - i3, this.zzf, this.zzg);
        this.zzh.zzR().zzC(i, i2);
    }
}
