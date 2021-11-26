package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaul;
import com.google.android.gms.internal.ads.zzbbk;
import com.google.android.gms.internal.ads.zzzy;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class AdActivity extends Activity {
    private zzaul zza;

    private final void zza() {
        zzaul zzaul = this.zza;
        if (zzaul != null) {
            try {
                zzaul.zzs();
            } catch (RemoteException e) {
                zzbbk.zzl("#007 Could not call remote method.", e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void onActivityResult(int i, int i2, @RecentlyNonNull Intent intent) {
        try {
            zzaul zzaul = this.zza;
            if (zzaul != null) {
                zzaul.zzm(i, i2, intent);
            }
        } catch (Exception e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
        super.onActivityResult(i, i2, intent);
    }

    public final void onBackPressed() {
        try {
            zzaul zzaul = this.zza;
            if (zzaul != null && !zzaul.zzg()) {
                return;
            }
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
        super.onBackPressed();
        try {
            zzaul zzaul2 = this.zza;
            if (zzaul2 != null) {
                zzaul2.zze();
            }
        } catch (RemoteException e2) {
            zzbbk.zzl("#007 Could not call remote method.", e2);
        }
    }

    public final void onConfigurationChanged(@RecentlyNonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            zzaul zzaul = this.zza;
            if (zzaul != null) {
                zzaul.zzn(ObjectWrapper.wrap(configuration));
            }
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zzaul zzg = zzzy.zzb().zzg(this);
        this.zza = zzg;
        if (zzg != null) {
            try {
                zzg.zzh(bundle);
            } catch (RemoteException e) {
                zzbbk.zzl("#007 Could not call remote method.", e);
                finish();
            }
        } else {
            zzbbk.zzl("#007 Could not call remote method.", (Throwable) null);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void onDestroy() {
        try {
            zzaul zzaul = this.zza;
            if (zzaul != null) {
                zzaul.zzq();
            }
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public final void onPause() {
        try {
            zzaul zzaul = this.zza;
            if (zzaul != null) {
                zzaul.zzl();
            }
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
            finish();
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public final void onRestart() {
        super.onRestart();
        try {
            zzaul zzaul = this.zza;
            if (zzaul != null) {
                zzaul.zzi();
            }
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void onResume() {
        super.onResume();
        try {
            zzaul zzaul = this.zza;
            if (zzaul != null) {
                zzaul.zzk();
            }
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void onSaveInstanceState(@RecentlyNonNull Bundle bundle) {
        try {
            zzaul zzaul = this.zza;
            if (zzaul != null) {
                zzaul.zzo(bundle);
            }
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public final void onStart() {
        super.onStart();
        try {
            zzaul zzaul = this.zza;
            if (zzaul != null) {
                zzaul.zzj();
            }
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void onStop() {
        try {
            zzaul zzaul = this.zza;
            if (zzaul != null) {
                zzaul.zzp();
            }
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
            finish();
        }
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public final void onUserLeaveHint() {
        super.onUserLeaveHint();
        try {
            zzaul zzaul = this.zza;
            if (zzaul != null) {
                zzaul.zzf();
            }
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void setContentView(int i) {
        super.setContentView(i);
        zza();
    }

    public final void setContentView(@RecentlyNonNull View view) {
        super.setContentView(view);
        zza();
    }

    public final void setContentView(@RecentlyNonNull View view, @RecentlyNonNull ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        zza();
    }
}
