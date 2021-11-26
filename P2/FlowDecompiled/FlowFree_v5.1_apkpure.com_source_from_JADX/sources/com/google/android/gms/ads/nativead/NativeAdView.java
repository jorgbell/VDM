package com.google.android.gms.ads.nativead;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaaa;
import com.google.android.gms.internal.ads.zzadc;
import com.google.android.gms.internal.ads.zzaeq;
import com.google.android.gms.internal.ads.zzahh;
import com.google.android.gms.internal.ads.zzaho;
import com.google.android.gms.internal.ads.zzbbk;
import com.google.android.gms.internal.ads.zzzy;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class NativeAdView extends FrameLayout {
    @NotOnlyInitialized
    private final FrameLayout zza;
    @NotOnlyInitialized
    private final zzaho zzb = zzf();

    private final void zzd(String str, View view) {
        zzaho zzaho = this.zzb;
        if (zzaho != null) {
            try {
                zzaho.zzb(str, ObjectWrapper.wrap(view));
            } catch (RemoteException e) {
                zzbbk.zzg("Unable to call setAssetView on delegate", e);
            }
        }
    }

    private final FrameLayout zze(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(frameLayout);
        return frameLayout;
    }

    @RequiresNonNull({"overlayFrame"})
    private final zzaho zzf() {
        if (isInEditMode()) {
            return null;
        }
        return zzzy.zzb().zzd(this.zza.getContext(), this, this.zza);
    }

    public final void addView(@RecentlyNonNull View view, int i, @RecentlyNonNull ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.zza);
    }

    public final void bringChildToFront(@RecentlyNonNull View view) {
        super.bringChildToFront(view);
        FrameLayout frameLayout = this.zza;
        if (frameLayout != view) {
            super.bringChildToFront(frameLayout);
        }
    }

    public final boolean dispatchTouchEvent(@RecentlyNonNull MotionEvent motionEvent) {
        zzaho zzaho;
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzbQ)).booleanValue() && (zzaho = this.zzb) != null) {
            try {
                zzaho.zzbw(ObjectWrapper.wrap(motionEvent));
            } catch (RemoteException e) {
                zzbbk.zzg("Unable to call handleTouchEvent on delegate", e);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @RecentlyNullable
    public AdChoicesView getAdChoicesView() {
        View zza2 = zza("3011");
        if (zza2 instanceof AdChoicesView) {
            return (AdChoicesView) zza2;
        }
        return null;
    }

    @RecentlyNullable
    public final View getAdvertiserView() {
        return zza("3005");
    }

    @RecentlyNullable
    public final View getBodyView() {
        return zza("3004");
    }

    @RecentlyNullable
    public final View getCallToActionView() {
        return zza("3002");
    }

    @RecentlyNullable
    public final View getHeadlineView() {
        return zza("3001");
    }

    @RecentlyNullable
    public final View getIconView() {
        return zza("3003");
    }

    @RecentlyNullable
    public final View getImageView() {
        return zza("3008");
    }

    @RecentlyNullable
    public final MediaView getMediaView() {
        View zza2 = zza("3010");
        if (zza2 instanceof MediaView) {
            return (MediaView) zza2;
        }
        if (zza2 == null) {
            return null;
        }
        zzbbk.zzd("View is not an instance of MediaView");
        return null;
    }

    @RecentlyNullable
    public final View getPriceView() {
        return zza("3007");
    }

    @RecentlyNullable
    public final View getStarRatingView() {
        return zza("3009");
    }

    @RecentlyNullable
    public final View getStoreView() {
        return zza("3006");
    }

    public final void onVisibilityChanged(@RecentlyNonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        zzaho zzaho = this.zzb;
        if (zzaho != null) {
            try {
                zzaho.zzf(ObjectWrapper.wrap(view), i);
            } catch (RemoteException e) {
                zzbbk.zzg("Unable to call onVisibilityChanged on delegate", e);
            }
        }
    }

    public final void removeAllViews() {
        super.removeAllViews();
        super.addView(this.zza);
    }

    public final void removeView(@RecentlyNonNull View view) {
        if (this.zza != view) {
            super.removeView(view);
        }
    }

    public void setAdChoicesView(AdChoicesView adChoicesView) {
        zzd("3011", adChoicesView);
    }

    public final void setAdvertiserView(View view) {
        zzd("3005", view);
    }

    public final void setBodyView(View view) {
        zzd("3004", view);
    }

    public final void setCallToActionView(View view) {
        zzd("3002", view);
    }

    public final void setClickConfirmingView(View view) {
        zzaho zzaho = this.zzb;
        if (zzaho != null) {
            try {
                zzaho.zzg(ObjectWrapper.wrap(view));
            } catch (RemoteException e) {
                zzbbk.zzg("Unable to call setClickConfirmingView on delegate", e);
            }
        }
    }

    public final void setHeadlineView(View view) {
        zzd("3001", view);
    }

    public final void setIconView(View view) {
        zzd("3003", view);
    }

    public final void setImageView(View view) {
        zzd("3008", view);
    }

    public final void setMediaView(MediaView mediaView) {
        zzd("3010", mediaView);
        if (mediaView != null) {
            mediaView.zza(new zzb(this));
            mediaView.zzb(new zzc(this));
        }
    }

    /* JADX WARNING: type inference failed for: r2v2, types: [com.google.android.gms.dynamic.IObjectWrapper, java.lang.Object] */
    public void setNativeAd(@RecentlyNonNull NativeAd nativeAd) {
        zzaho zzaho = this.zzb;
        if (zzaho != null) {
            try {
                zzaho.zzd(nativeAd.zza());
            } catch (RemoteException e) {
                zzbbk.zzg("Unable to call setNativeAd on delegate", e);
            }
        }
    }

    public final void setPriceView(View view) {
        zzd("3007", view);
    }

    public final void setStarRatingView(View view) {
        zzd("3009", view);
    }

    public final void setStoreView(View view) {
        zzd("3006", view);
    }

    /* access modifiers changed from: protected */
    @RecentlyNullable
    public final View zza(@RecentlyNonNull String str) {
        zzaho zzaho = this.zzb;
        if (zzaho != null) {
            try {
                IObjectWrapper zzc = zzaho.zzc(str);
                if (zzc != null) {
                    return (View) ObjectWrapper.unwrap(zzc);
                }
            } catch (RemoteException e) {
                zzbbk.zzg("Unable to call getAssetView on delegate", e);
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(ImageView.ScaleType scaleType) {
        zzaho zzaho = this.zzb;
        if (zzaho != null && scaleType != null) {
            try {
                zzaho.zzbv(ObjectWrapper.wrap(scaleType));
            } catch (RemoteException e) {
                zzbbk.zzg("Unable to call setMediaViewImageScaleType on delegate", e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(MediaContent mediaContent) {
        zzaho zzaho = this.zzb;
        if (zzaho != null) {
            try {
                if (mediaContent instanceof zzadc) {
                    zzaho.zzbx(((zzadc) mediaContent).zza());
                } else if (mediaContent == null) {
                    zzaho.zzbx((zzahh) null);
                } else {
                    zzbbk.zzd("Use MediaContent provided by NativeAd.getMediaContent");
                }
            } catch (RemoteException e) {
                zzbbk.zzg("Unable to call setMediaContent on delegate", e);
            }
        }
    }

    public NativeAdView(@RecentlyNonNull Context context, @RecentlyNonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zza = zze(context);
    }

    public NativeAdView(@RecentlyNonNull Context context, @RecentlyNonNull AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zza = zze(context);
    }
}
