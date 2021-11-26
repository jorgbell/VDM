package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzbs;
import com.google.android.gms.measurement.internal.zzhs;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.installations.FirebaseInstallations;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.3 */
public final class FirebaseAnalytics {
    private static volatile FirebaseAnalytics zza;
    private final zzbs zzb;

    public FirebaseAnalytics(zzbs zzbs) {
        Preconditions.checkNotNull(zzbs);
        this.zzb = zzbs;
    }

    @Keep
    public static FirebaseAnalytics getInstance(@RecentlyNonNull Context context) {
        if (zza == null) {
            synchronized (FirebaseAnalytics.class) {
                if (zza == null) {
                    zza = new FirebaseAnalytics(zzbs.zza(context, (String) null, (String) null, (String) null, (Bundle) null));
                }
            }
        }
        return zza;
    }

    @Keep
    public static zzhs getScionFrontendApiImplementation(Context context, Bundle bundle) {
        zzbs zza2 = zzbs.zza(context, (String) null, (String) null, (String) null, bundle);
        if (zza2 == null) {
            return null;
        }
        return new zzc(zza2);
    }

    @RecentlyNonNull
    @Keep
    public String getFirebaseInstanceId() {
        try {
            return (String) Tasks.await(FirebaseInstallations.getInstance().getId(), 30000, TimeUnit.MILLISECONDS);
        } catch (ExecutionException e) {
            throw new IllegalStateException(e.getCause());
        } catch (TimeoutException unused) {
            throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
        } catch (InterruptedException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public void logEvent(@RecentlyNonNull String str, Bundle bundle) {
        this.zzb.zzg(str, bundle);
    }

    @Deprecated
    @Keep
    public void setCurrentScreen(@RecentlyNonNull Activity activity, String str, String str2) {
        this.zzb.zzo(activity, str, str2);
    }

    public void setUserProperty(@RecentlyNonNull String str, String str2) {
        this.zzb.zzj((String) null, str, str2, false);
    }
}
