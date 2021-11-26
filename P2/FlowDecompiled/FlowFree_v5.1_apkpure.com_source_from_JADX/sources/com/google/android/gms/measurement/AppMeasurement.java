package com.google.android.gms.measurement;

import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzfp;
import com.google.android.gms.measurement.internal.zzgl;
import com.google.android.gms.measurement.internal.zzhs;
import com.unity3d.ads.metadata.MediationMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Deprecated
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
public class AppMeasurement {
    private static volatile AppMeasurement zza;
    private final zzfp zzb;
    private final zzhs zzc;

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
    public static class ConditionalUserProperty {
        @Keep
        public boolean mActive;
        @RecentlyNonNull
        @Keep
        public String mAppId;
        @Keep
        public long mCreationTimestamp;
        @RecentlyNonNull
        @Keep
        public String mExpiredEventName;
        @RecentlyNonNull
        @Keep
        public Bundle mExpiredEventParams;
        @RecentlyNonNull
        @Keep
        public String mName;
        @RecentlyNonNull
        @Keep
        public String mOrigin;
        @Keep
        public long mTimeToLive;
        @RecentlyNonNull
        @Keep
        public String mTimedOutEventName;
        @RecentlyNonNull
        @Keep
        public Bundle mTimedOutEventParams;
        @RecentlyNonNull
        @Keep
        public String mTriggerEventName;
        @Keep
        public long mTriggerTimeout;
        @RecentlyNonNull
        @Keep
        public String mTriggeredEventName;
        @RecentlyNonNull
        @Keep
        public Bundle mTriggeredEventParams;
        @Keep
        public long mTriggeredTimestamp;
        @RecentlyNonNull
        @Keep
        public Object mValue;

        public ConditionalUserProperty() {
        }

        ConditionalUserProperty(Bundle bundle) {
            Class cls = Long.class;
            Class cls2 = String.class;
            Preconditions.checkNotNull(bundle);
            this.mAppId = (String) zzgl.zzb(bundle, "app_id", cls2, null);
            this.mOrigin = (String) zzgl.zzb(bundle, "origin", cls2, null);
            this.mName = (String) zzgl.zzb(bundle, MediationMetaData.KEY_NAME, cls2, null);
            this.mValue = zzgl.zzb(bundle, "value", Object.class, null);
            this.mTriggerEventName = (String) zzgl.zzb(bundle, "trigger_event_name", cls2, null);
            this.mTriggerTimeout = ((Long) zzgl.zzb(bundle, "trigger_timeout", cls, 0L)).longValue();
            this.mTimedOutEventName = (String) zzgl.zzb(bundle, "timed_out_event_name", cls2, null);
            this.mTimedOutEventParams = (Bundle) zzgl.zzb(bundle, "timed_out_event_params", Bundle.class, null);
            this.mTriggeredEventName = (String) zzgl.zzb(bundle, "triggered_event_name", cls2, null);
            this.mTriggeredEventParams = (Bundle) zzgl.zzb(bundle, "triggered_event_params", Bundle.class, null);
            this.mTimeToLive = ((Long) zzgl.zzb(bundle, "time_to_live", cls, 0L)).longValue();
            this.mExpiredEventName = (String) zzgl.zzb(bundle, "expired_event_name", cls2, null);
            this.mExpiredEventParams = (Bundle) zzgl.zzb(bundle, "expired_event_params", Bundle.class, null);
            this.mActive = ((Boolean) zzgl.zzb(bundle, "active", Boolean.class, Boolean.FALSE)).booleanValue();
            this.mCreationTimestamp = ((Long) zzgl.zzb(bundle, "creation_timestamp", cls, 0L)).longValue();
            this.mTriggeredTimestamp = ((Long) zzgl.zzb(bundle, "triggered_timestamp", cls, 0L)).longValue();
        }

        /* access modifiers changed from: package-private */
        public final Bundle zza() {
            Bundle bundle = new Bundle();
            String str = this.mAppId;
            if (str != null) {
                bundle.putString("app_id", str);
            }
            String str2 = this.mOrigin;
            if (str2 != null) {
                bundle.putString("origin", str2);
            }
            String str3 = this.mName;
            if (str3 != null) {
                bundle.putString(MediationMetaData.KEY_NAME, str3);
            }
            Object obj = this.mValue;
            if (obj != null) {
                zzgl.zza(bundle, obj);
            }
            String str4 = this.mTriggerEventName;
            if (str4 != null) {
                bundle.putString("trigger_event_name", str4);
            }
            bundle.putLong("trigger_timeout", this.mTriggerTimeout);
            String str5 = this.mTimedOutEventName;
            if (str5 != null) {
                bundle.putString("timed_out_event_name", str5);
            }
            Bundle bundle2 = this.mTimedOutEventParams;
            if (bundle2 != null) {
                bundle.putBundle("timed_out_event_params", bundle2);
            }
            String str6 = this.mTriggeredEventName;
            if (str6 != null) {
                bundle.putString("triggered_event_name", str6);
            }
            Bundle bundle3 = this.mTriggeredEventParams;
            if (bundle3 != null) {
                bundle.putBundle("triggered_event_params", bundle3);
            }
            bundle.putLong("time_to_live", this.mTimeToLive);
            String str7 = this.mExpiredEventName;
            if (str7 != null) {
                bundle.putString("expired_event_name", str7);
            }
            Bundle bundle4 = this.mExpiredEventParams;
            if (bundle4 != null) {
                bundle.putBundle("expired_event_params", bundle4);
            }
            bundle.putLong("creation_timestamp", this.mCreationTimestamp);
            bundle.putBoolean("active", this.mActive);
            bundle.putLong("triggered_timestamp", this.mTriggeredTimestamp);
            return bundle;
        }
    }

    public AppMeasurement(zzfp zzfp) {
        Preconditions.checkNotNull(zzfp);
        this.zzb = zzfp;
        this.zzc = null;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    @androidx.annotation.RecentlyNonNull
    @java.lang.Deprecated
    @androidx.annotation.Keep
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.measurement.AppMeasurement getInstance(@androidx.annotation.RecentlyNonNull android.content.Context r14) {
        /*
            com.google.android.gms.measurement.AppMeasurement r0 = zza
            if (r0 != 0) goto L_0x005d
            java.lang.Class<com.google.android.gms.measurement.AppMeasurement> r0 = com.google.android.gms.measurement.AppMeasurement.class
            monitor-enter(r0)
            com.google.android.gms.measurement.AppMeasurement r1 = zza     // Catch:{ all -> 0x005a }
            if (r1 != 0) goto L_0x0058
            r1 = 0
            java.lang.String r2 = "com.google.firebase.analytics.FirebaseAnalytics"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x0032 }
            r3 = 2
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{  }
            java.lang.Class<android.content.Context> r5 = android.content.Context.class
            r6 = 0
            r4[r6] = r5     // Catch:{  }
            java.lang.Class<android.os.Bundle> r5 = android.os.Bundle.class
            r7 = 1
            r4[r7] = r5     // Catch:{  }
            java.lang.String r5 = "getScionFrontendApiImplementation"
            java.lang.reflect.Method r2 = r2.getDeclaredMethod(r5, r4)     // Catch:{  }
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{  }
            r3[r6] = r14     // Catch:{  }
            r3[r7] = r1     // Catch:{  }
            java.lang.Object r2 = r2.invoke(r1, r3)     // Catch:{  }
            com.google.android.gms.measurement.internal.zzhs r2 = (com.google.android.gms.measurement.internal.zzhs) r2     // Catch:{  }
            goto L_0x0033
        L_0x0032:
            r2 = r1
        L_0x0033:
            if (r2 == 0) goto L_0x003d
            com.google.android.gms.measurement.AppMeasurement r14 = new com.google.android.gms.measurement.AppMeasurement     // Catch:{ all -> 0x005a }
            r14.<init>((com.google.android.gms.measurement.internal.zzhs) r2)     // Catch:{ all -> 0x005a }
            zza = r14     // Catch:{ all -> 0x005a }
            goto L_0x0058
        L_0x003d:
            com.google.android.gms.internal.measurement.zzz r13 = new com.google.android.gms.internal.measurement.zzz     // Catch:{ all -> 0x005a }
            r3 = 0
            r5 = 0
            r7 = 1
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r2 = r13
            r2.<init>(r3, r5, r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x005a }
            com.google.android.gms.measurement.internal.zzfp r14 = com.google.android.gms.measurement.internal.zzfp.zzC(r14, r13, r1)     // Catch:{ all -> 0x005a }
            com.google.android.gms.measurement.AppMeasurement r1 = new com.google.android.gms.measurement.AppMeasurement     // Catch:{ all -> 0x005a }
            r1.<init>((com.google.android.gms.measurement.internal.zzfp) r14)     // Catch:{ all -> 0x005a }
            zza = r1     // Catch:{ all -> 0x005a }
        L_0x0058:
            monitor-exit(r0)     // Catch:{ all -> 0x005a }
            goto L_0x005d
        L_0x005a:
            r14 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x005a }
            throw r14
        L_0x005d:
            com.google.android.gms.measurement.AppMeasurement r14 = zza
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.AppMeasurement.getInstance(android.content.Context):com.google.android.gms.measurement.AppMeasurement");
    }

    @Keep
    public void beginAdUnitExposure(@RecentlyNonNull String str) {
        zzhs zzhs = this.zzc;
        if (zzhs != null) {
            zzhs.zzl(str);
            return;
        }
        Preconditions.checkNotNull(this.zzb);
        this.zzb.zzB().zza(str, this.zzb.zzay().elapsedRealtime());
    }

    @Keep
    public void clearConditionalUserProperty(@RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull Bundle bundle) {
        zzhs zzhs = this.zzc;
        if (zzhs != null) {
            zzhs.zzo(str, str2, bundle);
            return;
        }
        Preconditions.checkNotNull(this.zzb);
        this.zzb.zzk().zzO(str, str2, bundle);
    }

    @Keep
    public void endAdUnitExposure(@RecentlyNonNull String str) {
        zzhs zzhs = this.zzc;
        if (zzhs != null) {
            zzhs.zzm(str);
            return;
        }
        Preconditions.checkNotNull(this.zzb);
        this.zzb.zzB().zzb(str, this.zzb.zzay().elapsedRealtime());
    }

    @Keep
    public long generateEventId() {
        zzhs zzhs = this.zzc;
        if (zzhs != null) {
            return zzhs.zzk();
        }
        Preconditions.checkNotNull(this.zzb);
        return this.zzb.zzl().zzd();
    }

    @RecentlyNonNull
    @Keep
    public String getAppInstanceId() {
        zzhs zzhs = this.zzc;
        if (zzhs != null) {
            return zzhs.zzi();
        }
        Preconditions.checkNotNull(this.zzb);
        return this.zzb.zzk().zzD();
    }

    @RecentlyNonNull
    @Keep
    public List<ConditionalUserProperty> getConditionalUserProperties(@RecentlyNonNull String str, @RecentlyNonNull String str2) {
        List<Bundle> list;
        int i;
        zzhs zzhs = this.zzc;
        if (zzhs != null) {
            list = zzhs.zzp(str, str2);
        } else {
            Preconditions.checkNotNull(this.zzb);
            list = this.zzb.zzk().zzP(str, str2);
        }
        if (list == null) {
            i = 0;
        } else {
            i = list.size();
        }
        ArrayList arrayList = new ArrayList(i);
        for (Bundle conditionalUserProperty : list) {
            arrayList.add(new ConditionalUserProperty(conditionalUserProperty));
        }
        return arrayList;
    }

    @RecentlyNonNull
    @Keep
    public String getCurrentScreenClass() {
        zzhs zzhs = this.zzc;
        if (zzhs != null) {
            return zzhs.zzh();
        }
        Preconditions.checkNotNull(this.zzb);
        return this.zzb.zzk().zzS();
    }

    @RecentlyNonNull
    @Keep
    public String getCurrentScreenName() {
        zzhs zzhs = this.zzc;
        if (zzhs != null) {
            return zzhs.zzg();
        }
        Preconditions.checkNotNull(this.zzb);
        return this.zzb.zzk().zzR();
    }

    @RecentlyNonNull
    @Keep
    public String getGmpAppId() {
        zzhs zzhs = this.zzc;
        if (zzhs != null) {
            return zzhs.zzj();
        }
        Preconditions.checkNotNull(this.zzb);
        return this.zzb.zzk().zzT();
    }

    @Keep
    public int getMaxUserProperties(@RecentlyNonNull String str) {
        zzhs zzhs = this.zzc;
        if (zzhs != null) {
            return zzhs.zzq(str);
        }
        Preconditions.checkNotNull(this.zzb);
        this.zzb.zzk().zzL(str);
        return 25;
    }

    /* access modifiers changed from: protected */
    @RecentlyNonNull
    @Keep
    public Map<String, Object> getUserProperties(@RecentlyNonNull String str, @RecentlyNonNull String str2, boolean z) {
        zzhs zzhs = this.zzc;
        if (zzhs != null) {
            return zzhs.zzc(str, str2, z);
        }
        Preconditions.checkNotNull(this.zzb);
        return this.zzb.zzk().zzQ(str, str2, z);
    }

    @Keep
    public void logEventInternal(@RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull Bundle bundle) {
        zzhs zzhs = this.zzc;
        if (zzhs != null) {
            zzhs.zza(str, str2, bundle);
            return;
        }
        Preconditions.checkNotNull(this.zzb);
        this.zzb.zzk().zzs(str, str2, bundle);
    }

    @Keep
    public void setConditionalUserProperty(@RecentlyNonNull ConditionalUserProperty conditionalUserProperty) {
        Preconditions.checkNotNull(conditionalUserProperty);
        zzhs zzhs = this.zzc;
        if (zzhs != null) {
            zzhs.zzn(conditionalUserProperty.zza());
            return;
        }
        Preconditions.checkNotNull(this.zzb);
        this.zzb.zzk().zzM(conditionalUserProperty.zza());
    }

    public AppMeasurement(zzhs zzhs) {
        Preconditions.checkNotNull(zzhs);
        this.zzc = zzhs;
        this.zzb = null;
    }
}
