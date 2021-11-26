package com.mopub.mobileads;

import androidx.media2.player.MediaPlayer;
import java.util.concurrent.Executor;

/* compiled from: VastVideoViewController.kt */
final class VastVideoViewController$createVideoView$$inlined$run$lambda$1 implements Runnable {
    final /* synthetic */ Executor $executor$inlined;
    final /* synthetic */ MediaPlayer $this_run;
    final /* synthetic */ VastVideoViewController this$0;

    VastVideoViewController$createVideoView$$inlined$run$lambda$1(MediaPlayer mediaPlayer, VastVideoViewController vastVideoViewController, Executor executor) {
        this.$this_run = mediaPlayer;
        this.this$0 = vastVideoViewController;
        this.$executor$inlined = executor;
    }

    public final void run() {
        this.this$0.externalViewabilitySessionManager.onVideoPrepared(this.$this_run.getDuration());
        this.this$0.adjustSkipOffset();
        this.this$0.getMediaPlayer().setPlayerVolume(1.0f);
        this.this$0.getBaseVideoViewControllerListener().onCompanionAdsReady(this.this$0.vastCompanionAdConfigs, (int) this.$this_run.getDuration());
        this.this$0.getProgressBarWidget().calibrateAndMakeVisible((int) this.$this_run.getDuration(), this.this$0.getShowCloseButtonDelay());
        this.this$0.getRadialCountdownWidget().calibrateAndMakeVisible(this.this$0.getShowCloseButtonDelay());
        this.this$0.getRadialCountdownWidget().updateCountdownProgress(this.this$0.getShowCloseButtonDelay(), (int) this.$this_run.getCurrentPosition());
        this.this$0.setCalibrationDone(true);
    }
}
