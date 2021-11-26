package com.google.android.gms.ads.internal.util;

import android.content.Context;
import androidx.annotation.RecentlyNonNull;
import androidx.work.Configuration;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import com.google.android.gms.ads.internal.offline.buffering.OfflineNotificationPoster;
import com.google.android.gms.ads.internal.offline.buffering.OfflinePingSender;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbbk;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public class WorkManagerUtil extends zzbg {
    private static void zzb(Context context) {
        try {
            WorkManager.initialize(context.getApplicationContext(), new Configuration.Builder().build());
        } catch (IllegalStateException unused) {
        }
    }

    public final boolean zze(@RecentlyNonNull IObjectWrapper iObjectWrapper, @RecentlyNonNull String str, @RecentlyNonNull String str2) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzb(context);
        Constraints.Builder builder = new Constraints.Builder();
        builder.setRequiredNetworkType(NetworkType.CONNECTED);
        Constraints build = builder.build();
        Data.Builder builder2 = new Data.Builder();
        builder2.putString("uri", str);
        builder2.putString("gws_query_id", str2);
        Data build2 = builder2.build();
        OneTimeWorkRequest.Builder builder3 = new OneTimeWorkRequest.Builder(OfflineNotificationPoster.class);
        builder3.setConstraints(build);
        OneTimeWorkRequest.Builder builder4 = builder3;
        builder4.setInputData(build2);
        OneTimeWorkRequest.Builder builder5 = builder4;
        builder5.addTag("offline_notification_work");
        try {
            WorkManager.getInstance(context).enqueue((WorkRequest) (OneTimeWorkRequest) builder5.build());
            return true;
        } catch (IllegalStateException e) {
            zzbbk.zzj("Failed to instantiate WorkManager.", e);
            return false;
        }
    }

    public final void zzf(@RecentlyNonNull IObjectWrapper iObjectWrapper) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzb(context);
        try {
            WorkManager instance = WorkManager.getInstance(context);
            instance.cancelAllWorkByTag("offline_ping_sender_work");
            Constraints.Builder builder = new Constraints.Builder();
            builder.setRequiredNetworkType(NetworkType.CONNECTED);
            Constraints build = builder.build();
            OneTimeWorkRequest.Builder builder2 = new OneTimeWorkRequest.Builder(OfflinePingSender.class);
            builder2.setConstraints(build);
            OneTimeWorkRequest.Builder builder3 = builder2;
            builder3.addTag("offline_ping_sender_work");
            instance.enqueue((WorkRequest) (OneTimeWorkRequest) builder3.build());
        } catch (IllegalStateException e) {
            zzbbk.zzj("Failed to instantiate WorkManager.", e);
        }
    }
}
