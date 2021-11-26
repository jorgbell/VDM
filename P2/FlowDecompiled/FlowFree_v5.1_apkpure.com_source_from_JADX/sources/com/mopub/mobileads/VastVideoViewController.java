package com.mopub.mobileads;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.media.AudioAttributesCompat;
import androidx.media2.common.SessionPlayer;
import androidx.media2.common.UriMediaItem;
import androidx.media2.player.MediaPlayer;
import androidx.media2.player.PlaybackParams;
import androidx.media2.widget.VideoView;
import com.mopub.common.ExternalViewabilitySessionManager;
import com.mopub.common.VideoEvent;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.factories.VideoViewFactory;
import java.lang.reflect.Field;
import java.util.Set;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

@Mockable
/* compiled from: VastVideoViewController.kt */
public class VastVideoViewController extends BaseVideoViewController {
    public static final String CURRENT_POSITION = "current_position";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int DEFAULT_VIDEO_DURATION_FOR_CLOSE_BUTTON = 5000;
    public static final int MAX_VIDEO_DURATION_FOR_CLOSE_BUTTON = 16000;
    public static final String RESUMED_VAST_CONFIG = "resumed_vast_config";
    public static final String VAST_VIDEO_CONFIG = "vast_video_config";
    public static final int WEBVIEW_PADDING = 16;
    private final Activity activity;
    public VastVideoGradientStripWidget bottomGradientStripWidget;
    private final View.OnTouchListener clickThroughListener;
    public VastVideoCloseButtonWidget closeButtonWidget;
    private final VastVideoViewCountdownRunnable countdownRunnable;
    private final VideoCtaButtonWidget ctaButtonWidget;
    /* access modifiers changed from: private */
    public final ExternalViewabilitySessionManager externalViewabilitySessionManager;
    private final Bundle extras;
    private boolean hasCompanionAd;
    public View iconView;
    private boolean isCalibrationDone;
    private boolean isClosing;
    private boolean isComplete;
    private final MediaPlayer mediaPlayer;
    private final PlayerCallback playerCallback = new PlayerCallback();
    public VastVideoProgressBarWidget progressBarWidget;
    private final VastVideoViewProgressRunnable progressCheckerRunnable;
    public RadialCountdownWidget radialCountdownWidget;
    private final Bundle savedInstanceState;
    private int seekerPositionOnPause;
    private boolean shouldAllowClose;
    private int showCloseButtonDelay;
    public VastVideoGradientStripWidget topGradientStripWidget;
    /* access modifiers changed from: private */
    public Set<VastCompanionAdConfig> vastCompanionAdConfigs;
    private final VastIconConfig vastIconConfig;
    private final VastVideoConfig vastVideoConfig;
    private boolean videoError;
    /* access modifiers changed from: private */
    public final VideoView videoView;

    @VisibleForTesting
    public static /* synthetic */ void getBottomGradientStripWidget$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getClickThroughListener$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getCloseButtonWidget$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getCtaButtonWidget$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getHasCompanionAd$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getIconView$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getProgressBarWidget$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getRadialCountdownWidget$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getShouldAllowClose$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getShowCloseButtonDelay$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getTopGradientStripWidget$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getVastIconConfig$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getVastVideoConfig$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void isCalibrationDone$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void isClosing$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void isComplete$annotations() {
    }

    public Activity getActivity() {
        return this.activity;
    }

    public Bundle getExtras() {
        return this.extras;
    }

    public Bundle getSavedInstanceState() {
        return this.savedInstanceState;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public VastVideoViewController(android.app.Activity r17, android.os.Bundle r18, android.os.Bundle r19, long r20, com.mopub.mobileads.BaseVideoViewController.BaseVideoViewControllerListener r22) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r22
            java.lang.String r4 = "activity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r4)
            java.lang.String r4 = "extras"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r4)
            java.lang.String r4 = "baseListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r4)
            java.lang.Long r4 = java.lang.Long.valueOf(r20)
            r0.<init>(r1, r4, r3)
            r0.activity = r1
            r0.extras = r2
            r1 = r19
            r0.savedInstanceState = r1
            com.mopub.mobileads.factories.MediaPlayerFactory$Companion r1 = com.mopub.mobileads.factories.MediaPlayerFactory.Companion
            android.content.Context r2 = r16.getContext()
            java.lang.String r3 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            androidx.media2.player.MediaPlayer r1 = r1.create(r2)
            r0.mediaPlayer = r1
            com.mopub.mobileads.VastVideoViewController$PlayerCallback r1 = new com.mopub.mobileads.VastVideoViewController$PlayerCallback
            r1.<init>()
            r0.playerCallback = r1
            r1 = -1
            r0.seekerPositionOnPause = r1
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            r0.vastCompanionAdConfigs = r2
            com.mopub.common.ExternalViewabilitySessionManager r2 = com.mopub.common.ExternalViewabilitySessionManager.create()
            java.lang.String r3 = "ExternalViewabilitySessionManager.create()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r0.externalViewabilitySessionManager = r2
            r3 = 5000(0x1388, float:7.006E-42)
            r0.showCloseButtonDelay = r3
            android.os.Bundle r3 = r16.getSavedInstanceState()
            r4 = 0
            if (r3 == 0) goto L_0x0065
            java.lang.String r5 = "resumed_vast_config"
            java.io.Serializable r3 = r3.getSerializable(r5)
            goto L_0x0066
        L_0x0065:
            r3 = r4
        L_0x0066:
            boolean r5 = r3 instanceof com.mopub.mobileads.VastVideoConfig
            if (r5 != 0) goto L_0x006b
            r3 = r4
        L_0x006b:
            com.mopub.mobileads.VastVideoConfig r3 = (com.mopub.mobileads.VastVideoConfig) r3
            android.os.Bundle r5 = r16.getExtras()
            java.lang.String r6 = "com_mopub_ad_data"
            android.os.Parcelable r5 = r5.getParcelable(r6)
            com.mopub.mobileads.AdData r5 = (com.mopub.mobileads.AdData) r5
            if (r3 == 0) goto L_0x007d
            r6 = r3
            goto L_0x008d
        L_0x007d:
            com.mopub.mobileads.VastVideoConfig$Companion r6 = com.mopub.mobileads.VastVideoConfig.Companion
            if (r5 == 0) goto L_0x02c9
            java.lang.String r7 = r5.getVastVideoConfigString()
            if (r7 == 0) goto L_0x02bd
            com.mopub.mobileads.VastVideoConfig r6 = r6.fromVastVideoConfigString(r7)
            if (r6 == 0) goto L_0x02b1
        L_0x008d:
            r0.vastVideoConfig = r6
            if (r5 == 0) goto L_0x00a0
            com.mopub.mobileads.VastVideoConfig r6 = r16.getVastVideoConfig()
            int r5 = r5.getRewardedDurationSeconds()
            int r5 = r5 * 1000
            r6.setCountdownTimerDuration(r5)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
        L_0x00a0:
            if (r3 == 0) goto L_0x00b8
            android.os.Bundle r3 = r16.getSavedInstanceState()
            if (r3 == 0) goto L_0x00b2
            java.lang.String r4 = "current_position"
            int r3 = r3.getInt(r4, r1)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
        L_0x00b2:
            if (r4 == 0) goto L_0x00b8
            int r1 = r4.intValue()
        L_0x00b8:
            r0.seekerPositionOnPause = r1
            com.mopub.mobileads.VastVideoConfig r1 = r16.getVastVideoConfig()
            java.lang.String r1 = r1.getDiskMediaFileUrl()
            if (r1 == 0) goto L_0x02a5
            com.mopub.mobileads.VastVideoConfig r1 = r16.getVastVideoConfig()
            java.util.Set r1 = r1.getVastCompanionAdConfigs()
            r0.vastCompanionAdConfigs = r1
            boolean r1 = r1.isEmpty()
            r3 = 1
            if (r1 == 0) goto L_0x0124
            com.mopub.mobileads.VastVideoConfig r1 = r16.getVastVideoConfig()
            java.lang.String r1 = r1.getDiskMediaFileUrl()
            if (r1 == 0) goto L_0x0127
            com.mopub.mobileads.VastResource r7 = new com.mopub.mobileads.VastResource
            com.mopub.mobileads.VastResource$Type r4 = com.mopub.mobileads.VastResource.Type.BLURRED_LAST_FRAME
            com.mopub.mobileads.VastResource$CreativeType r5 = com.mopub.mobileads.VastResource.CreativeType.IMAGE
            r6 = -1
            r8 = -1
            r17 = r7
            r18 = r1
            r19 = r4
            r20 = r5
            r21 = r6
            r22 = r8
            r17.<init>(r18, r19, r20, r21, r22)
            java.util.Set<com.mopub.mobileads.VastCompanionAdConfig> r1 = r0.vastCompanionAdConfigs
            com.mopub.mobileads.VastCompanionAdConfig r12 = new com.mopub.mobileads.VastCompanionAdConfig
            r5 = -1
            com.mopub.mobileads.VastVideoConfig r4 = r16.getVastVideoConfig()
            java.lang.String r8 = r4.getClickThroughUrl()
            com.mopub.mobileads.VastVideoConfig r4 = r16.getVastVideoConfig()
            java.util.ArrayList r9 = r4.getClickTrackers()
            java.util.List r10 = java.util.Collections.emptyList()
            java.lang.String r4 = "Collections.emptyList()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r4)
            com.mopub.mobileads.VastVideoConfig r4 = r16.getVastVideoConfig()
            java.lang.String r11 = r4.getCustomCtaText()
            r4 = r12
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            r1.add(r12)
            goto L_0x0127
        L_0x0124:
            r0.setHasCompanionAd(r3)
        L_0x0127:
            com.mopub.mobileads.VastVideoConfig r1 = r16.getVastVideoConfig()
            com.mopub.mobileads.VastIconConfig r1 = r1.getVastIconConfig()
            r0.vastIconConfig = r1
            com.mopub.mobileads.VastVideoViewController$8 r1 = new com.mopub.mobileads.VastVideoViewController$8
            r1.<init>(r0)
            r0.clickThroughListener = r1
            android.view.ViewGroup r1 = r16.getLayout()
            r4 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r1.setBackgroundColor(r4)
            android.app.Activity r1 = r16.getActivity()
            r4 = 0
            androidx.media2.widget.VideoView r1 = r0.createVideoView(r1, r4)
            r0.videoView = r1
            r1.requestFocus()
            com.mopub.mobileads.VastVideoConfig r5 = r16.getVastVideoConfig()
            java.util.Set r5 = r5.getViewabilityVendors()
            r2.createVideoSession(r1, r5)
            java.util.Set<com.mopub.mobileads.VastCompanionAdConfig> r5 = r0.vastCompanionAdConfigs
            boolean r5 = r5.isEmpty()
            r5 = r5 ^ r3
            com.mopub.mobileads.VastVideoGradientStripWidget r14 = new com.mopub.mobileads.VastVideoGradientStripWidget
            android.content.Context r7 = r16.getContext()
            android.graphics.drawable.GradientDrawable$Orientation r8 = android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM
            r10 = 0
            r11 = 6
            android.view.ViewGroup r6 = r16.getLayout()
            java.lang.String r9 = "layout"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r9)
            int r12 = r6.getId()
            r13 = 1
            r6 = r14
            r9 = r5
            r6.<init>(r7, r8, r9, r10, r11, r12, r13)
            android.view.ViewGroup r6 = r16.getLayout()
            r6.addView(r14)
            com.mopub.common.ViewabilityObstruction r15 = com.mopub.common.ViewabilityObstruction.OVERLAY
            r2.registerVideoObstruction(r14, r15)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            r0.setTopGradientStripWidget(r14)
            com.mopub.mobileads.VastVideoProgressBarWidget r6 = new com.mopub.mobileads.VastVideoProgressBarWidget
            android.content.Context r7 = r16.getContext()
            r6.<init>(r7)
            int r1 = r1.getId()
            r6.setAnchorId(r1)
            r1 = 4
            r6.setVisibility(r1)
            android.view.ViewGroup r7 = r16.getLayout()
            r7.addView(r6)
            com.mopub.common.ViewabilityObstruction r7 = com.mopub.common.ViewabilityObstruction.PROGRESS_BAR
            r2.registerVideoObstruction(r6, r7)
            r0.setProgressBarWidget(r6)
            com.mopub.mobileads.VastVideoGradientStripWidget r14 = new com.mopub.mobileads.VastVideoGradientStripWidget
            android.content.Context r7 = r16.getContext()
            android.graphics.drawable.GradientDrawable$Orientation r8 = android.graphics.drawable.GradientDrawable.Orientation.BOTTOM_TOP
            r10 = 8
            r11 = 2
            com.mopub.mobileads.VastVideoProgressBarWidget r6 = r16.getProgressBarWidget()
            int r12 = r6.getId()
            r13 = 0
            r6 = r14
            r6.<init>(r7, r8, r9, r10, r11, r12, r13)
            android.view.ViewGroup r6 = r16.getLayout()
            r6.addView(r14)
            r2.registerVideoObstruction(r14, r15)
            r0.setBottomGradientStripWidget(r14)
            com.mopub.mobileads.RadialCountdownWidget r6 = new com.mopub.mobileads.RadialCountdownWidget
            android.content.Context r7 = r16.getContext()
            r6.<init>(r7)
            r6.setVisibility(r1)
            android.view.ViewGroup r1 = r16.getLayout()
            r1.addView(r6)
            com.mopub.common.ViewabilityObstruction r1 = com.mopub.common.ViewabilityObstruction.COUNTDOWN_TIMER
            r2.registerVideoObstruction(r6, r1)
            com.mopub.mobileads.VastVideoViewController$12$1 r1 = com.mopub.mobileads.VastVideoViewController$12$1.INSTANCE
            r6.setOnTouchListener(r1)
            com.mopub.mobileads.VastVideoViewController$12$2 r1 = com.mopub.mobileads.VastVideoViewController$12$2.INSTANCE
            r6.setOnClickListener(r1)
            r0.setRadialCountdownWidget(r6)
            com.mopub.mobileads.VideoCtaButtonWidget r1 = new com.mopub.mobileads.VideoCtaButtonWidget
            android.content.Context r6 = r16.getContext()
            com.mopub.mobileads.VastVideoConfig r7 = r16.getVastVideoConfig()
            java.lang.String r7 = r7.getClickThroughUrl()
            if (r7 == 0) goto L_0x0212
            int r7 = r7.length()
            if (r7 != 0) goto L_0x0213
        L_0x0212:
            r4 = 1
        L_0x0213:
            r3 = r3 ^ r4
            r1.<init>(r6, r5, r3)
            android.view.ViewGroup r3 = r16.getLayout()
            r3.addView(r1)
            com.mopub.common.ViewabilityObstruction r3 = com.mopub.common.ViewabilityObstruction.CTA_BUTTON
            r2.registerVideoObstruction(r1, r3)
            com.mopub.mobileads.VastVideoConfig r3 = r16.getVastVideoConfig()
            java.lang.String r3 = r3.getCustomCtaText()
            if (r3 == 0) goto L_0x0230
            r1.updateCtaText(r3)
        L_0x0230:
            android.view.View$OnTouchListener r3 = r16.getClickThroughListener()
            r1.setOnTouchListener(r3)
            r0.ctaButtonWidget = r1
            com.mopub.mobileads.VastVideoCloseButtonWidget r1 = new com.mopub.mobileads.VastVideoCloseButtonWidget
            android.content.Context r3 = r16.getContext()
            r1.<init>(r3)
            r3 = 8
            r1.setVisibility(r3)
            android.view.ViewGroup r3 = r16.getLayout()
            r3.addView(r1)
            com.mopub.common.ViewabilityObstruction r3 = com.mopub.common.ViewabilityObstruction.CLOSE_BUTTON
            r2.registerVideoObstruction(r1, r3)
            com.mopub.mobileads.VastVideoViewController$$special$$inlined$also$lambda$3 r2 = new com.mopub.mobileads.VastVideoViewController$$special$$inlined$also$lambda$3
            r2.<init>(r0)
            r1.setOnTouchListenerToContent(r2)
            com.mopub.mobileads.VastVideoConfig r2 = r16.getVastVideoConfig()
            java.lang.String r2 = r2.getCustomSkipText()
            if (r2 == 0) goto L_0x0268
            r1.updateCloseButtonText(r2)
        L_0x0268:
            com.mopub.mobileads.VastVideoConfig r2 = r16.getVastVideoConfig()
            java.lang.String r2 = r2.getCustomCloseIconUrl()
            if (r2 == 0) goto L_0x0275
            r1.updateCloseButtonIcon(r2)
        L_0x0275:
            r0.setCloseButtonWidget(r1)
            com.mopub.mobileads.VastVideoConfig r1 = r16.getVastVideoConfig()
            boolean r1 = r1.isRewarded()
            if (r1 != 0) goto L_0x0289
            com.mopub.mobileads.VideoCtaButtonWidget r1 = r16.getCtaButtonWidget()
            r1.notifyVideoSkippable()
        L_0x0289:
            android.os.Handler r1 = new android.os.Handler
            android.os.Looper r2 = android.os.Looper.getMainLooper()
            r1.<init>(r2)
            com.mopub.mobileads.VastVideoViewProgressRunnable r2 = new com.mopub.mobileads.VastVideoViewProgressRunnable
            com.mopub.mobileads.VastVideoConfig r3 = r16.getVastVideoConfig()
            r2.<init>(r0, r3, r1)
            r0.progressCheckerRunnable = r2
            com.mopub.mobileads.VastVideoViewCountdownRunnable r2 = new com.mopub.mobileads.VastVideoViewCountdownRunnable
            r2.<init>(r0, r1)
            r0.countdownRunnable = r2
            return
        L_0x02a5:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "VastVideoConfig does not have a video disk path"
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x02b1:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "VastVideoConfig is invalid"
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x02bd:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "VastVideoConfigByteArray is null"
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x02c9:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "AdData is invalid"
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.mobileads.VastVideoViewController.<init>(android.app.Activity, android.os.Bundle, android.os.Bundle, long, com.mopub.mobileads.BaseVideoViewController$BaseVideoViewControllerListener):void");
    }

    /* compiled from: VastVideoViewController.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public MediaPlayer getMediaPlayer() {
        return this.mediaPlayer;
    }

    public PlayerCallback getPlayerCallback() {
        return this.playerCallback;
    }

    public VastVideoConfig getVastVideoConfig() {
        return this.vastVideoConfig;
    }

    public VastIconConfig getVastIconConfig() {
        return this.vastIconConfig;
    }

    public View getIconView() {
        View view = this.iconView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        throw null;
    }

    public void setIconView(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.iconView = view;
    }

    public View.OnTouchListener getClickThroughListener() {
        return this.clickThroughListener;
    }

    public VastVideoGradientStripWidget getTopGradientStripWidget() {
        VastVideoGradientStripWidget vastVideoGradientStripWidget = this.topGradientStripWidget;
        if (vastVideoGradientStripWidget != null) {
            return vastVideoGradientStripWidget;
        }
        Intrinsics.throwUninitializedPropertyAccessException("topGradientStripWidget");
        throw null;
    }

    public void setTopGradientStripWidget(VastVideoGradientStripWidget vastVideoGradientStripWidget) {
        Intrinsics.checkNotNullParameter(vastVideoGradientStripWidget, "<set-?>");
        this.topGradientStripWidget = vastVideoGradientStripWidget;
    }

    public VastVideoGradientStripWidget getBottomGradientStripWidget() {
        VastVideoGradientStripWidget vastVideoGradientStripWidget = this.bottomGradientStripWidget;
        if (vastVideoGradientStripWidget != null) {
            return vastVideoGradientStripWidget;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bottomGradientStripWidget");
        throw null;
    }

    public void setBottomGradientStripWidget(VastVideoGradientStripWidget vastVideoGradientStripWidget) {
        Intrinsics.checkNotNullParameter(vastVideoGradientStripWidget, "<set-?>");
        this.bottomGradientStripWidget = vastVideoGradientStripWidget;
    }

    public VastVideoProgressBarWidget getProgressBarWidget() {
        VastVideoProgressBarWidget vastVideoProgressBarWidget = this.progressBarWidget;
        if (vastVideoProgressBarWidget != null) {
            return vastVideoProgressBarWidget;
        }
        Intrinsics.throwUninitializedPropertyAccessException("progressBarWidget");
        throw null;
    }

    public void setProgressBarWidget(VastVideoProgressBarWidget vastVideoProgressBarWidget) {
        Intrinsics.checkNotNullParameter(vastVideoProgressBarWidget, "<set-?>");
        this.progressBarWidget = vastVideoProgressBarWidget;
    }

    public RadialCountdownWidget getRadialCountdownWidget() {
        RadialCountdownWidget radialCountdownWidget2 = this.radialCountdownWidget;
        if (radialCountdownWidget2 != null) {
            return radialCountdownWidget2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("radialCountdownWidget");
        throw null;
    }

    public void setRadialCountdownWidget(RadialCountdownWidget radialCountdownWidget2) {
        Intrinsics.checkNotNullParameter(radialCountdownWidget2, "<set-?>");
        this.radialCountdownWidget = radialCountdownWidget2;
    }

    public VideoCtaButtonWidget getCtaButtonWidget() {
        return this.ctaButtonWidget;
    }

    public VastVideoCloseButtonWidget getCloseButtonWidget() {
        VastVideoCloseButtonWidget vastVideoCloseButtonWidget = this.closeButtonWidget;
        if (vastVideoCloseButtonWidget != null) {
            return vastVideoCloseButtonWidget;
        }
        Intrinsics.throwUninitializedPropertyAccessException("closeButtonWidget");
        throw null;
    }

    public void setCloseButtonWidget(VastVideoCloseButtonWidget vastVideoCloseButtonWidget) {
        Intrinsics.checkNotNullParameter(vastVideoCloseButtonWidget, "<set-?>");
        this.closeButtonWidget = vastVideoCloseButtonWidget;
    }

    public boolean isComplete() {
        return this.isComplete;
    }

    public void setComplete(boolean z) {
        this.isComplete = z;
    }

    public boolean getShouldAllowClose() {
        return this.shouldAllowClose;
    }

    public void setShouldAllowClose(boolean z) {
        this.shouldAllowClose = z;
    }

    public int getShowCloseButtonDelay() {
        return this.showCloseButtonDelay;
    }

    public void setShowCloseButtonDelay(int i) {
        this.showCloseButtonDelay = i;
    }

    public boolean isCalibrationDone() {
        return this.isCalibrationDone;
    }

    public void setCalibrationDone(boolean z) {
        this.isCalibrationDone = z;
    }

    public boolean isClosing() {
        return this.isClosing;
    }

    public void setClosing(boolean z) {
        this.isClosing = z;
    }

    public boolean getHasCompanionAd() {
        return this.hasCompanionAd;
    }

    public void setHasCompanionAd(boolean z) {
        this.hasCompanionAd = z;
    }

    public boolean getVideoError() {
        return this.videoError;
    }

    public void setVideoError(boolean z) {
        this.videoError = z;
    }

    public String getNetworkMediaFileUrl() {
        return getVastVideoConfig().getNetworkMediaFileUrl();
    }

    /* access modifiers changed from: private */
    public void adjustSkipOffset() {
        int duration = getDuration();
        if (getVastVideoConfig().isRewarded()) {
            if (getHasCompanionAd()) {
                duration = getVastVideoConfig().getCountdownTimerDuration();
            } else if (duration > getVastVideoConfig().getCountdownTimerDuration()) {
                duration = getVastVideoConfig().getCountdownTimerDuration();
            }
            setShowCloseButtonDelay(duration);
            return;
        }
        if (duration < 16000) {
            setShowCloseButtonDelay(duration);
        }
        try {
            Integer skipOffsetMillis = getVastVideoConfig().getSkipOffsetMillis(duration);
            if (skipOffsetMillis != null) {
                setShowCloseButtonDelay(skipOffsetMillis.intValue());
            }
        } catch (NumberFormatException unused) {
            MoPubLog.SdkLogEvent sdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
            MoPubLog.log(sdkLogEvent, "Failed to parse skipoffset " + getVastVideoConfig().getSkipOffset());
        }
    }

    private VideoView createVideoView(Context context, int i) {
        VideoView create = VideoViewFactory.Companion.create(context);
        Executor mainExecutor = ContextCompat.getMainExecutor(context);
        PlaybackParams.Builder builder = new PlaybackParams.Builder();
        builder.setAudioFallbackMode(0);
        builder.setSpeed(1.0f);
        PlaybackParams build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlaybackParams.Builder()….0f)\n            .build()");
        getMediaPlayer().setPlaybackParams(build);
        AudioAttributesCompat.Builder builder2 = new AudioAttributesCompat.Builder();
        builder2.setUsage(1);
        builder2.setContentType(3);
        getMediaPlayer().setAudioAttributes(builder2.build());
        getMediaPlayer().registerPlayerCallback(mainExecutor, getPlayerCallback());
        create.removeView(create.getMediaControlView());
        create.setId(View.generateViewId());
        create.setPlayer(getMediaPlayer());
        create.setOnTouchListener(getClickThroughListener());
        MediaPlayer mediaPlayer2 = getMediaPlayer();
        mediaPlayer2.setMediaItem(new UriMediaItem.Builder(Uri.parse(getVastVideoConfig().getDiskMediaFileUrl())).build());
        mediaPlayer2.prepare().addListener(new VastVideoViewController$createVideoView$$inlined$run$lambda$1(mediaPlayer2, this, mainExecutor), mainExecutor);
        return create;
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        VastVideoConfig vastVideoConfig2 = getVastVideoConfig();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        vastVideoConfig2.handleImpression(context, getCurrentPosition());
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        if (!this.externalViewabilitySessionManager.isTracking()) {
            this.externalViewabilitySessionManager.startSession();
        }
        startRunnables();
        if (this.seekerPositionOnPause > 0) {
            Intrinsics.checkNotNullExpressionValue(getMediaPlayer().seekTo((long) this.seekerPositionOnPause, 3), "mediaPlayer.seekTo(seeke…MediaPlayer.SEEK_CLOSEST)");
        } else if (!isComplete()) {
            getMediaPlayer().play();
        }
        if (this.seekerPositionOnPause != -1 && !isComplete()) {
            VastVideoConfig vastVideoConfig2 = getVastVideoConfig();
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            vastVideoConfig2.handleResume(context, this.seekerPositionOnPause);
        }
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"RestrictedApi", "VisibleForTests"})
    public void onPause() {
        stopRunnables();
        this.seekerPositionOnPause = getCurrentPosition();
        getMediaPlayer().pause();
        try {
            Field declaredField = MediaPlayer.class.getDeclaredField("mAudioFocusHandler");
            Intrinsics.checkNotNullExpressionValue(declaredField, "audioFocusHandlerField");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(getMediaPlayer());
            obj.getClass().getMethod("close", new Class[0]).invoke(obj, new Object[0]);
        } catch (Exception e) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM_WITH_THROWABLE, "Unable to call close() on the AudioFocusHandler due to an exception.", e);
        }
        if (!isComplete()) {
            VastVideoConfig vastVideoConfig2 = getVastVideoConfig();
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            vastVideoConfig2.handlePause(context, this.seekerPositionOnPause);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        stopRunnables();
        this.externalViewabilitySessionManager.endSession();
    }

    /* access modifiers changed from: protected */
    public View getVideoView() {
        return this.videoView;
    }

    public boolean backButtonEnabled() {
        return getShouldAllowClose();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (isClosing() && i == 1 && i2 == -1) {
            getBaseVideoViewControllerListener().onVideoFinish(getCurrentPosition());
        }
    }

    public void handleViewabilityQuartileEvent(String str) {
        Intrinsics.checkNotNullParameter(str, "enumValue");
        VideoEvent valueOf = VideoEvent.valueOf(str);
        if (valueOf != null) {
            this.externalViewabilitySessionManager.recordVideoEvent(valueOf, getCurrentPosition());
        }
    }

    public int getDuration() {
        return (int) getMediaPlayer().getDuration();
    }

    public int getCurrentPosition() {
        return (int) getMediaPlayer().getCurrentPosition();
    }

    public static /* synthetic */ void updateCountdown$default(VastVideoViewController vastVideoViewController, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            vastVideoViewController.updateCountdown(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateCountdown");
    }

    public void updateCountdown(boolean z) {
        if (isCalibrationDone()) {
            getRadialCountdownWidget().updateCountdownProgress(getShowCloseButtonDelay(), getCurrentPosition());
        }
        if (z || getCurrentPosition() >= getShowCloseButtonDelay()) {
            getRadialCountdownWidget().setVisibility(8);
            getCloseButtonWidget().setVisibility(0);
            setShouldAllowClose(true);
            getCtaButtonWidget().notifyVideoSkippable();
        }
    }

    public void updateProgressBar() {
        getProgressBarWidget().updateProgress(getCurrentPosition());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0086, code lost:
        if (r3 != null) goto L_0x0092;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleIconDisplay(int r8) {
        /*
            r7 = this;
            com.mopub.mobileads.VastIconConfig r0 = r7.getVastIconConfig()
            if (r0 == 0) goto L_0x00d4
            int r0 = r0.getOffsetMS()
            if (r8 >= r0) goto L_0x000d
            return
        L_0x000d:
            android.view.View r1 = r7.iconView
            if (r1 != 0) goto L_0x009c
            com.mopub.mobileads.VastIconConfig r1 = r7.getVastIconConfig()
            r2 = 0
            if (r1 == 0) goto L_0x0089
            android.content.Context r3 = r7.getContext()
            com.mopub.mobileads.VastResource r4 = r1.getVastResource()
            com.mopub.mobileads.VastWebView r3 = com.mopub.mobileads.VastWebView.createView(r3, r4)
            java.lang.String r4 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            com.mopub.mobileads.VastVideoViewController$handleIconDisplay$$inlined$let$lambda$1 r4 = new com.mopub.mobileads.VastVideoViewController$handleIconDisplay$$inlined$let$lambda$1
            r4.<init>(r1, r7)
            r3.setVastWebViewClickListener(r4)
            com.mopub.mobileads.VastVideoViewController$handleIconDisplay$$inlined$let$lambda$2 r4 = new com.mopub.mobileads.VastVideoViewController$handleIconDisplay$$inlined$let$lambda$2
            r4.<init>(r1, r7)
            r3.setWebViewClient(r4)
            com.mopub.mobileads.VastIconConfig r4 = r7.getVastIconConfig()
            if (r4 == 0) goto L_0x005f
            android.widget.RelativeLayout$LayoutParams r4 = new android.widget.RelativeLayout$LayoutParams
            int r5 = r1.getWidth()
            float r5 = (float) r5
            android.content.Context r6 = r7.getContext()
            int r5 = com.mopub.common.util.Dips.asIntPixels(r5, r6)
            int r1 = r1.getHeight()
            float r1 = (float) r1
            android.content.Context r6 = r7.getContext()
            int r1 = com.mopub.common.util.Dips.asIntPixels(r1, r6)
            r4.<init>(r5, r1)
            goto L_0x0060
        L_0x005f:
            r4 = 0
        L_0x0060:
            r1 = 12
            float r1 = (float) r1
            android.content.Context r5 = r7.getContext()
            int r5 = com.mopub.common.util.Dips.dipsToIntPixels(r1, r5)
            android.content.Context r6 = r7.getContext()
            int r1 = com.mopub.common.util.Dips.dipsToIntPixels(r1, r6)
            if (r4 == 0) goto L_0x0078
            r4.setMargins(r5, r1, r2, r2)
        L_0x0078:
            android.view.ViewGroup r1 = r7.getLayout()
            r1.addView(r3, r4)
            com.mopub.common.ExternalViewabilitySessionManager r1 = r7.externalViewabilitySessionManager
            com.mopub.common.ViewabilityObstruction r4 = com.mopub.common.ViewabilityObstruction.INDUSTRY_ICON
            r1.registerVideoObstruction(r3, r4)
            if (r3 == 0) goto L_0x0089
            goto L_0x0092
        L_0x0089:
            android.view.View r3 = new android.view.View
            android.content.Context r1 = r7.getContext()
            r3.<init>(r1)
        L_0x0092:
            r7.setIconView(r3)
            android.view.View r1 = r7.getIconView()
            r1.setVisibility(r2)
        L_0x009c:
            java.lang.String r1 = r7.getNetworkMediaFileUrl()
            if (r1 == 0) goto L_0x00b4
            com.mopub.mobileads.VastIconConfig r2 = r7.getVastIconConfig()
            if (r2 == 0) goto L_0x00b4
            android.content.Context r3 = r7.getContext()
            java.lang.String r4 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r2.handleImpression(r3, r8, r1)
        L_0x00b4:
            com.mopub.mobileads.VastIconConfig r1 = r7.getVastIconConfig()
            if (r1 == 0) goto L_0x00d4
            java.lang.Integer r1 = r1.getDurationMS()
            if (r1 == 0) goto L_0x00d4
            int r1 = r1.intValue()
            int r0 = r0 + r1
            if (r8 < r0) goto L_0x00d4
            android.view.View r8 = r7.iconView
            if (r8 == 0) goto L_0x00d4
            android.view.View r8 = r7.getIconView()
            r0 = 8
            r8.setVisibility(r0)
        L_0x00d4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.mobileads.VastVideoViewController.handleIconDisplay(int):void");
    }

    public void handleExitTrackers() {
        int currentPosition = getCurrentPosition();
        if (isComplete() || currentPosition >= getDuration()) {
            VastVideoConfig vastVideoConfig2 = getVastVideoConfig();
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            vastVideoConfig2.handleComplete(context, getDuration());
        } else {
            this.externalViewabilitySessionManager.recordVideoEvent(VideoEvent.AD_SKIPPED, currentPosition);
            VastVideoConfig vastVideoConfig3 = getVastVideoConfig();
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            vastVideoConfig3.handleSkip(context2, currentPosition);
        }
        VastVideoConfig vastVideoConfig4 = getVastVideoConfig();
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        vastVideoConfig4.handleClose(context3, getDuration());
    }

    private void startRunnables() {
        this.progressCheckerRunnable.startRepeating(50);
        this.countdownRunnable.startRepeating(250);
    }

    /* access modifiers changed from: private */
    public void stopRunnables() {
        this.progressCheckerRunnable.stop();
        this.countdownRunnable.stop();
    }

    /* compiled from: VastVideoViewController.kt */
    public final class PlayerCallback extends MediaPlayer.PlayerCallback {
        private boolean complete;

        private final String playerStateToString(int i) {
            return i != 0 ? i != 1 ? i != 2 ? i != 3 ? "UNKNOWN" : "PLAYER_STATE_ERROR" : "PLAYER_STATE_PLAYING" : "PLAYER_STATE_PAUSED" : "PLAYER_STATE_IDLE";
        }

        public PlayerCallback() {
        }

        public final boolean getComplete() {
            return this.complete;
        }

        public final void setComplete(boolean z) {
            this.complete = z;
        }

        public void onPlayerStateChanged(SessionPlayer sessionPlayer, int i) {
            Intrinsics.checkNotNullParameter(sessionPlayer, "player");
            super.onPlayerStateChanged(sessionPlayer, i);
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        MoPubLog.SdkLogEvent sdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
                        MoPubLog.log(sdkLogEvent, "Player state changed to " + playerStateToString(i));
                        return;
                    }
                    VastVideoViewController.this.externalViewabilitySessionManager.recordVideoEvent(VideoEvent.RECORD_AD_ERROR, VastVideoViewController.this.getCurrentPosition());
                    VastVideoViewController.this.stopRunnables();
                    VastVideoViewController.this.updateCountdown(true);
                    VastVideoViewController.this.videoError(false);
                    VastVideoViewController.this.setVideoError(true);
                    VastVideoConfig vastVideoConfig = VastVideoViewController.this.getVastVideoConfig();
                    Context context = VastVideoViewController.this.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    vastVideoConfig.handleError(context, VastErrorCode.GENERAL_LINEAR_AD_ERROR, VastVideoViewController.this.getCurrentPosition());
                } else if (VastVideoViewController.this.externalViewabilitySessionManager.hasImpressionOccurred()) {
                    VastVideoViewController.this.externalViewabilitySessionManager.recordVideoEvent(VideoEvent.AD_RESUMED, VastVideoViewController.this.getCurrentPosition());
                } else {
                    VastVideoViewController.this.externalViewabilitySessionManager.trackImpression();
                }
            } else if (VastVideoViewController.this.externalViewabilitySessionManager.hasImpressionOccurred()) {
                VastVideoViewController.this.externalViewabilitySessionManager.recordVideoEvent(VideoEvent.AD_PAUSED, VastVideoViewController.this.getCurrentPosition());
            }
        }

        public void onPlaybackCompleted(SessionPlayer sessionPlayer) {
            Intrinsics.checkNotNullParameter(sessionPlayer, "player");
            VastVideoViewController.this.stopRunnables();
            VastVideoViewController.updateCountdown$default(VastVideoViewController.this, false, 1, (Object) null);
            VastVideoViewController.this.setComplete(true);
            if (!VastVideoViewController.this.getVideoError() && VastVideoViewController.this.getVastVideoConfig().getRemainingProgressTrackerCount() == 0) {
                VastVideoViewController.this.externalViewabilitySessionManager.recordVideoEvent(VideoEvent.AD_COMPLETE, VastVideoViewController.this.getCurrentPosition());
                VastVideoConfig vastVideoConfig = VastVideoViewController.this.getVastVideoConfig();
                Context context = VastVideoViewController.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                vastVideoConfig.handleComplete(context, VastVideoViewController.this.getCurrentPosition());
            }
            VastVideoViewController.this.videoView.setVisibility(4);
            VastVideoViewController.this.getProgressBarWidget().setVisibility(8);
            VastVideoViewController vastVideoViewController = VastVideoViewController.this;
            if (vastVideoViewController.iconView != null) {
                vastVideoViewController.getIconView().setVisibility(8);
            }
            VastVideoViewController.this.getTopGradientStripWidget().notifyVideoComplete();
            VastVideoViewController.this.getBottomGradientStripWidget().notifyVideoComplete();
            VastVideoViewController.this.getCtaButtonWidget().notifyVideoComplete();
            VastVideoViewController.this.getCloseButtonWidget().notifyVideoComplete();
            VastVideoViewController vastVideoViewController2 = VastVideoViewController.this;
            vastVideoViewController2.videoCompleted(true, vastVideoViewController2.getDuration());
        }

        public void onSeekCompleted(SessionPlayer sessionPlayer, long j) {
            Intrinsics.checkNotNullParameter(sessionPlayer, "player");
            VastVideoViewController.this.getMediaPlayer().play();
        }
    }
}
