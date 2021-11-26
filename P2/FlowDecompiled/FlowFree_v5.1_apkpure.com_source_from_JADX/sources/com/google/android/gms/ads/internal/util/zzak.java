package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.internal.ads.zzaaa;
import com.google.android.gms.internal.ads.zzaeq;
import com.google.android.gms.internal.ads.zzbbk;
import com.google.android.gms.internal.ads.zzbbw;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzak {
    private final Context zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private int zzf;
    private int zzg;
    private PointF zzh;
    private PointF zzi;
    private Handler zzj;
    private Runnable zzk;

    public zzak(Context context) {
        this.zzf = 0;
        this.zzk = new zzae(this);
        this.zza = context;
        this.zzg = ViewConfiguration.get(context).getScaledTouchSlop();
        zzs.zzq().zza();
        this.zzj = zzs.zzq().zzb();
    }

    private final boolean zzl(float f, float f2, float f3, float f4) {
        return Math.abs(this.zzh.x - f) < ((float) this.zzg) && Math.abs(this.zzh.y - f2) < ((float) this.zzg) && Math.abs(this.zzi.x - f3) < ((float) this.zzg) && Math.abs(this.zzi.y - f4) < ((float) this.zzg);
    }

    private static final int zzm(List<String> list, String str, boolean z) {
        list.add(str);
        return list.size() - 1;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(100);
        sb.append("{Dialog: ");
        sb.append(this.zzb);
        sb.append(",DebugSignal: ");
        sb.append(this.zze);
        sb.append(",AFMA Version: ");
        sb.append(this.zzd);
        sb.append(",Ad Unit ID: ");
        sb.append(this.zzc);
        sb.append("}");
        return sb.toString();
    }

    public final void zza(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        int historySize = motionEvent.getHistorySize();
        int pointerCount = motionEvent.getPointerCount();
        if (actionMasked == 0) {
            this.zzf = 0;
            this.zzh = new PointF(motionEvent.getX(0), motionEvent.getY(0));
            return;
        }
        int i = this.zzf;
        if (i != -1) {
            if (i == 0) {
                if (actionMasked == 5) {
                    this.zzf = 5;
                    this.zzi = new PointF(motionEvent.getX(1), motionEvent.getY(1));
                    this.zzj.postDelayed(this.zzk, ((Long) zzaaa.zzc().zzb(zzaeq.zzcQ)).longValue());
                }
            } else if (i == 5) {
                if (pointerCount == 2) {
                    if (actionMasked == 2) {
                        boolean z = false;
                        for (int i2 = 0; i2 < historySize; i2++) {
                            z |= !zzl(motionEvent.getHistoricalX(0, i2), motionEvent.getHistoricalY(0, i2), motionEvent.getHistoricalX(1, i2), motionEvent.getHistoricalY(1, i2));
                        }
                        if (zzl(motionEvent.getX(), motionEvent.getY(), motionEvent.getX(1), motionEvent.getY(1)) && !z) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                this.zzf = -1;
                this.zzj.removeCallbacks(this.zzk);
            }
        }
    }

    public final void zzb() {
        try {
            if (this.zza instanceof Activity) {
                String str = "Creative Preview (Enabled)";
                if (true == TextUtils.isEmpty(zzs.zzm().zze())) {
                    str = "Creative Preview";
                }
                String str2 = "Troubleshooting (Enabled)";
                if (true != zzs.zzm().zzf()) {
                    str2 = "Troubleshooting";
                }
                ArrayList arrayList = new ArrayList();
                int zzm = zzm(arrayList, "Ad Information", true);
                int zzm2 = zzm(arrayList, str, true);
                int zzm3 = zzm(arrayList, str2, true);
                AlertDialog.Builder builder = new AlertDialog.Builder(this.zza, zzs.zze().zzm());
                builder.setTitle("Select a Debug Mode").setItems((CharSequence[]) arrayList.toArray(new String[0]), new zzaf(this, zzm, zzm2, zzm3));
                builder.create().show();
                return;
            }
            zzbbk.zzh("Can not create dialog without Activity Context");
        } catch (WindowManager.BadTokenException e) {
            zze.zzb("", e);
        }
    }

    public final void zzc(String str) {
        this.zzc = str;
    }

    public final void zzd(String str) {
        this.zzd = str;
    }

    public final void zze(String str) {
        this.zzb = str;
    }

    public final void zzf(String str) {
        this.zze = str;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzg() {
        zzs.zzm().zzb(this.zza, this.zzc, this.zzd, this.zze);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh() {
        zzs.zzm().zza(this.zza, this.zzc, this.zzd);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(String str, DialogInterface dialogInterface, int i) {
        zzs.zzc();
        zzr.zzN(this.zza, Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", str), "Share via"));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzj(int i, int i2, int i3, DialogInterface dialogInterface, int i4) {
        if (i4 == i) {
            if (!(this.zza instanceof Activity)) {
                zzbbk.zzh("Can not create dialog without Activity Context");
                return;
            }
            String str = this.zzb;
            String str2 = "No debug information";
            if (!TextUtils.isEmpty(str)) {
                Uri build = new Uri.Builder().encodedQuery(str.replaceAll("\\+", "%20")).build();
                StringBuilder sb = new StringBuilder();
                zzs.zzc();
                Map<String, String> zzP = zzr.zzP(build);
                for (String next : zzP.keySet()) {
                    sb.append(next);
                    sb.append(" = ");
                    sb.append(zzP.get(next));
                    sb.append("\n\n");
                }
                String trim = sb.toString().trim();
                if (!TextUtils.isEmpty(trim)) {
                    str2 = trim;
                }
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this.zza);
            builder.setMessage(str2);
            builder.setTitle("Ad Information");
            builder.setPositiveButton("Share", new zzag(this, str2));
            builder.setNegativeButton("Close", zzah.zza);
            builder.create().show();
        } else if (i4 == i2) {
            zzbbk.zzd("Debug mode [Creative Preview] selected.");
            zzbbw.zza.execute(new zzai(this));
        } else if (i4 == i3) {
            zzbbk.zzd("Debug mode [Troubleshooting] selected.");
            zzbbw.zza.execute(new zzaj(this));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzk() {
        this.zzf = 4;
        zzb();
    }

    public zzak(Context context, String str) {
        this(context);
        this.zzb = str;
    }
}
