package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.ads.AdService;
import com.google.android.gms.ads.impl.R$string;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.util.zzbh;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcvs extends zzaty {
    private final Context zza;
    private final zzcni zzb;
    private final zzbbp zzc;
    private final zzcvk zzd;
    private final zzdvo zze;

    public zzcvs(Context context, zzcvk zzcvk, zzbbp zzbbp, zzcni zzcni, zzdvo zzdvo) {
        this.zza = context;
        this.zzb = zzcni;
        this.zzc = zzbbp;
        this.zzd = zzcvk;
        this.zze = zzdvo;
    }

    public static void zzc(Activity activity, zzm zzm, zzbh zzbh, zzcvk zzcvk, zzcni zzcni, zzdvo zzdvo, String str, String str2) {
        String str3;
        String str4;
        String str5;
        String str6;
        zzs.zzc();
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, zzs.zze().zzm());
        Resources zzf = zzs.zzg().zzf();
        if (zzf == null) {
            str3 = "Open ad when you're back online.";
        } else {
            str3 = zzf.getString(R$string.offline_opt_in_title);
        }
        AlertDialog.Builder title = builder.setTitle(str3);
        if (zzf == null) {
            str4 = "We'll send you a notification with a link to the advertiser site.";
        } else {
            str4 = zzf.getString(R$string.offline_opt_in_message);
        }
        AlertDialog.Builder message = title.setMessage(str4);
        if (zzf == null) {
            str5 = "OK";
        } else {
            str5 = zzf.getString(R$string.offline_opt_in_confirm);
        }
        AlertDialog.Builder positiveButton = message.setPositiveButton(str5, new zzcvn(zzcni, activity, zzdvo, zzcvk, str, zzbh, str2, zzf, zzm));
        if (zzf == null) {
            str6 = "No thanks";
        } else {
            str6 = zzf.getString(R$string.offline_opt_in_decline);
        }
        zzcvk zzcvk2 = zzcvk;
        String str7 = str;
        zzcni zzcni2 = zzcni;
        Activity activity2 = activity;
        zzdvo zzdvo2 = zzdvo;
        zzm zzm2 = zzm;
        positiveButton.setNegativeButton(str6, new zzcvo(zzcvk2, str7, zzcni2, activity2, zzdvo2, zzm2)).setOnCancelListener(new zzcvp(zzcvk2, str7, zzcni2, activity2, zzdvo2, zzm2));
        builder.create().show();
    }

    public static void zzd(Context context, zzcni zzcni, zzdvo zzdvo, zzcvk zzcvk, String str, String str2) {
        zzh(context, zzcni, zzdvo, zzcvk, str, str2, new HashMap());
    }

    public static void zzh(Context context, zzcni zzcni, zzdvo zzdvo, zzcvk zzcvk, String str, String str2, Map<String, String> map) {
        String str3;
        String str4 = "offline";
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzfI)).booleanValue()) {
            zzdvn zza2 = zzdvn.zza(str2);
            zza2.zzc("gqi", str);
            zzs.zzc();
            if (true == zzr.zzH(context)) {
                str4 = "online";
            }
            zza2.zzc("device_connectivity", str4);
            zza2.zzc("event_timestamp", String.valueOf(zzs.zzj().currentTimeMillis()));
            for (Map.Entry next : map.entrySet()) {
                zza2.zzc((String) next.getKey(), (String) next.getValue());
            }
            str3 = zzdvo.zzb(zza2);
        } else {
            zzcnh zza3 = zzcni.zza();
            zza3.zzc("gqi", str);
            zza3.zzc("action", str2);
            zzs.zzc();
            if (true == zzr.zzH(context)) {
                str4 = "online";
            }
            zza3.zzc("device_connectivity", str4);
            zza3.zzc("event_timestamp", String.valueOf(zzs.zzj().currentTimeMillis()));
            for (Map.Entry next2 : map.entrySet()) {
                zza3.zzc((String) next2.getKey(), (String) next2.getValue());
            }
            str3 = zza3.zze();
        }
        zzcvk.zze(new zzcvm(zzs.zzj().currentTimeMillis(), str, str3, 2));
    }

    private final void zzi(String str, String str2, Map<String, String> map) {
        zzh(this.zza, this.zzb, this.zze, this.zzd, str, str2, map);
    }

    public final void zze(Intent intent) {
        String stringExtra = intent.getStringExtra("offline_notification_action");
        if (stringExtra.equals("offline_notification_clicked") || stringExtra.equals("offline_notification_dismissed")) {
            String stringExtra2 = intent.getStringExtra("gws_query_id");
            String stringExtra3 = intent.getStringExtra("uri");
            zzs.zzc();
            boolean zzH = zzr.zzH(this.zza);
            HashMap hashMap = new HashMap();
            char c = 2;
            if (stringExtra.equals("offline_notification_clicked")) {
                hashMap.put("offline_notification_action", "offline_notification_clicked");
                if (true == zzH) {
                    c = 1;
                }
                hashMap.put("obvs", String.valueOf(Build.VERSION.SDK_INT));
                hashMap.put("olaih", String.valueOf(stringExtra3.startsWith("http")));
                try {
                    Context context = this.zza;
                    Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(stringExtra3);
                    if (launchIntentForPackage == null) {
                        launchIntentForPackage = new Intent("android.intent.action.VIEW");
                        launchIntentForPackage.setData(Uri.parse(stringExtra3));
                    }
                    launchIntentForPackage.addFlags(268435456);
                    context.startActivity(launchIntentForPackage);
                    hashMap.put("olaa", "olas");
                } catch (ActivityNotFoundException unused) {
                    hashMap.put("olaa", "olaf");
                }
            } else {
                hashMap.put("offline_notification_action", "offline_notification_dismissed");
            }
            zzi(stringExtra2, "offline_notification_action", hashMap);
            try {
                SQLiteDatabase writableDatabase = this.zzd.getWritableDatabase();
                if (c == 1) {
                    this.zzd.zzb(writableDatabase, this.zzc, stringExtra2);
                } else {
                    zzcvk.zzi(writableDatabase, stringExtra2);
                }
            } catch (SQLiteException e) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 51);
                sb.append("Failed to get writable offline buffering database: ");
                sb.append(valueOf);
                zzbbk.zzf(sb.toString());
            }
        }
    }

    public final void zzf(IObjectWrapper iObjectWrapper, String str, String str2) {
        String str3;
        String str4;
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzs.zzc();
        if (PlatformVersion.isAtLeastO()) {
            NotificationChannel notificationChannel = new NotificationChannel("offline_notification_channel", "AdMob Offline Notifications", 2);
            notificationChannel.setShowBadge(false);
            ((NotificationManager) context.getSystemService(NotificationManager.class)).createNotificationChannel(notificationChannel);
        }
        Intent intent = new Intent();
        intent.setClass(context, AdService.class);
        intent.setAction("offline_notification_clicked");
        intent.putExtra("offline_notification_action", "offline_notification_clicked");
        intent.putExtra("gws_query_id", str2);
        intent.putExtra("uri", str);
        int i = zzebr.zza;
        PendingIntent zza2 = zzebr.zza(context, 0, intent, i | 1073741824, 0);
        Intent intent2 = new Intent();
        intent2.setClass(context, AdService.class);
        intent2.setAction("offline_notification_dismissed");
        intent2.putExtra("offline_notification_action", "offline_notification_dismissed");
        intent2.putExtra("gws_query_id", str2);
        PendingIntent zza3 = zzebr.zza(context, 0, intent2, i | 1073741824, 0);
        Resources zzf = zzs.zzg().zzf();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "offline_notification_channel");
        if (zzf == null) {
            str3 = "View the ad you saved when you were offline";
        } else {
            str3 = zzf.getString(R$string.offline_notification_title);
        }
        builder.setContentTitle(str3);
        if (zzf == null) {
            str4 = "Tap to open ad";
        } else {
            str4 = zzf.getString(R$string.offline_notification_text);
        }
        builder.setContentText(str4);
        builder.setAutoCancel(true);
        builder.setDeleteIntent(zza3);
        builder.setContentIntent(zza2);
        builder.setSmallIcon(context.getApplicationInfo().icon);
        ((NotificationManager) context.getSystemService("notification")).notify(str2, 54321, builder.build());
        zzi(str2, "offline_notification_impression", new HashMap());
    }

    public final void zzg() {
        this.zzd.zza(new zzcve(this.zzc));
    }
}
