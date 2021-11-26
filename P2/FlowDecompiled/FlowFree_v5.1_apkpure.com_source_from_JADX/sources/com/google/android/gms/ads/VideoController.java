package com.google.android.gms.ads;

import android.os.RemoteException;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzacj;
import com.google.android.gms.internal.ads.zzadx;
import com.google.android.gms.internal.ads.zzbbk;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class VideoController {
    private final Object zza = new Object();
    @GuardedBy("lock")
    private zzacj zzb;
    @GuardedBy("lock")
    private VideoLifecycleCallbacks zzc;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
    public static abstract class VideoLifecycleCallbacks {
        public void onVideoEnd() {
        }

        public void onVideoMute(boolean z) {
        }

        public void onVideoPause() {
        }

        public void onVideoPlay() {
        }

        public void onVideoStart() {
        }
    }

    public void setVideoLifecycleCallbacks(@RecentlyNonNull VideoLifecycleCallbacks videoLifecycleCallbacks) {
        Preconditions.checkNotNull(videoLifecycleCallbacks, "VideoLifecycleCallbacks may not be null.");
        synchronized (this.zza) {
            this.zzc = videoLifecycleCallbacks;
            zzacj zzacj = this.zzb;
            if (zzacj != null) {
                try {
                    zzacj.zzl(new zzadx(videoLifecycleCallbacks));
                } catch (RemoteException e) {
                    zzbbk.zzg("Unable to call setVideoLifecycleCallbacks on video controller.", e);
                }
            }
        }
    }

    public final void zza(zzacj zzacj) {
        synchronized (this.zza) {
            this.zzb = zzacj;
            VideoLifecycleCallbacks videoLifecycleCallbacks = this.zzc;
            if (videoLifecycleCallbacks != null) {
                setVideoLifecycleCallbacks(videoLifecycleCallbacks);
            }
        }
    }

    public final zzacj zzb() {
        zzacj zzacj;
        synchronized (this.zza) {
            zzacj = this.zzb;
        }
        return zzacj;
    }
}
