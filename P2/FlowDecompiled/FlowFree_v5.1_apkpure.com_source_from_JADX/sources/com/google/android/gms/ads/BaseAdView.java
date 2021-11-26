package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.internal.ads.zzacs;
import com.google.android.gms.internal.ads.zzbbk;
import com.google.android.gms.internal.ads.zzyi;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public abstract class BaseAdView extends ViewGroup {
    @NotOnlyInitialized
    protected final zzacs zza;

    protected BaseAdView(@RecentlyNonNull Context context, int i) {
        super(context);
        this.zza = new zzacs(this, i);
    }

    public void destroy() {
        this.zza.zza();
    }

    @RecentlyNonNull
    public AdListener getAdListener() {
        return this.zza.zzb();
    }

    @RecentlyNullable
    public AdSize getAdSize() {
        return this.zza.zzc();
    }

    @RecentlyNonNull
    public String getAdUnitId() {
        return this.zza.zze();
    }

    @RecentlyNullable
    public OnPaidEventListener getOnPaidEventListener() {
        return this.zza.zzu();
    }

    @RecentlyNullable
    public ResponseInfo getResponseInfo() {
        return this.zza.zzs();
    }

    public void loadAd(@RecentlyNonNull AdRequest adRequest) {
        this.zza.zzg(adRequest.zza());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = ((i3 - i) - measuredWidth) / 2;
            int i6 = ((i4 - i2) - measuredHeight) / 2;
            childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        AdSize adSize;
        int i4 = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            try {
                adSize = getAdSize();
            } catch (NullPointerException e) {
                zzbbk.zzg("Unable to retrieve ad size.", e);
                adSize = null;
            }
            if (adSize != null) {
                Context context = getContext();
                int widthInPixels = adSize.getWidthInPixels(context);
                i3 = adSize.getHeightInPixels(context);
                i4 = widthInPixels;
            } else {
                i3 = 0;
            }
        } else {
            measureChild(childAt, i, i2);
            i4 = childAt.getMeasuredWidth();
            i3 = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(i4, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i3, getSuggestedMinimumHeight()), i2));
    }

    public void pause() {
        this.zza.zzh();
    }

    public void resume() {
        this.zza.zzj();
    }

    public void setAdListener(@RecentlyNonNull AdListener adListener) {
        this.zza.zzk(adListener);
        if (adListener == null) {
            this.zza.zzl((zzyi) null);
            return;
        }
        if (adListener instanceof zzyi) {
            this.zza.zzl((zzyi) adListener);
        }
        if (adListener instanceof AppEventListener) {
            this.zza.zzp((AppEventListener) adListener);
        }
    }

    public void setAdSize(@RecentlyNonNull AdSize adSize) {
        this.zza.zzm(adSize);
    }

    public void setAdUnitId(@RecentlyNonNull String str) {
        this.zza.zzo(str);
    }

    public void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        this.zza.zzt(onPaidEventListener);
    }

    protected BaseAdView(@RecentlyNonNull Context context, @RecentlyNonNull AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.zza = new zzacs(this, attributeSet, false, i);
    }

    protected BaseAdView(@RecentlyNonNull Context context, @RecentlyNonNull AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.zza = new zzacs(this, attributeSet, false, i2);
    }

    protected BaseAdView(@RecentlyNonNull Context context, @RecentlyNonNull AttributeSet attributeSet, int i, int i2, boolean z) {
        super(context, attributeSet, i);
        this.zza = new zzacs(this, attributeSet, z, i2);
    }

    protected BaseAdView(@RecentlyNonNull Context context, @RecentlyNonNull AttributeSet attributeSet, boolean z) {
        super(context, attributeSet);
        this.zza = new zzacs(this, attributeSet, z);
    }
}
