package com.mopub.mobileads;

import android.os.Handler;
import com.mopub.common.VideoEvent;
import com.mopub.mobileads.VastFractionalProgressTracker;
import com.mopub.mobileads.VastTracker;
import com.mopub.network.TrackingRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Mockable
/* compiled from: VastVideoViewProgressRunnable.kt */
public class VastVideoViewProgressRunnable extends RepeatingHandlerRunnable {
    private final VastVideoConfig vastVideoConfig;
    private final VastVideoViewController videoViewController;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VastTracker.MessageType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[VastTracker.MessageType.TRACKING_URL.ordinal()] = 1;
            iArr[VastTracker.MessageType.QUARTILE_EVENT.ordinal()] = 2;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VastVideoViewProgressRunnable(VastVideoViewController vastVideoViewController, VastVideoConfig vastVideoConfig2, Handler handler) {
        super(handler);
        Intrinsics.checkNotNullParameter(vastVideoViewController, "videoViewController");
        Intrinsics.checkNotNullParameter(vastVideoConfig2, "vastVideoConfig");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.videoViewController = vastVideoViewController;
        this.vastVideoConfig = vastVideoConfig2;
        ArrayList arrayList = new ArrayList();
        VastFractionalProgressTracker.Builder builder = new VastFractionalProgressTracker.Builder(VideoEvent.AD_VIDEO_FIRST_QUARTILE.name(), 0.25f);
        VastTracker.MessageType messageType = VastTracker.MessageType.QUARTILE_EVENT;
        arrayList.add(builder.messageType(messageType).build());
        arrayList.add(new VastFractionalProgressTracker.Builder(VideoEvent.AD_VIDEO_MIDPOINT.name(), 0.5f).messageType(messageType).build());
        arrayList.add(new VastFractionalProgressTracker.Builder(VideoEvent.AD_VIDEO_THIRD_QUARTILE.name(), 0.75f).messageType(messageType).build());
        vastVideoConfig2.addFractionalTrackers(arrayList);
    }

    public void doWork() {
        int duration = this.videoViewController.getDuration();
        int currentPosition = this.videoViewController.getCurrentPosition();
        this.videoViewController.updateProgressBar();
        if (duration > 0) {
            List<VastTracker> untriggeredTrackersBefore = this.vastVideoConfig.getUntriggeredTrackersBefore(currentPosition, duration);
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = untriggeredTrackersBefore.iterator();
            while (true) {
                String str = null;
                if (it.hasNext()) {
                    VastTracker vastTracker = (VastTracker) it.next();
                    vastTracker.setTracked();
                    int i = WhenMappings.$EnumSwitchMapping$0[vastTracker.getMessageType().ordinal()];
                    if (i == 1) {
                        str = vastTracker.getContent();
                    } else if (i == 2) {
                        this.videoViewController.handleViewabilityQuartileEvent(vastTracker.getContent());
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (str != null) {
                        arrayList.add(str);
                    }
                } else {
                    if (!(!arrayList.isEmpty())) {
                        arrayList = null;
                    }
                    if (arrayList != null) {
                        VastMacroHelper withContentPlayHead = new VastMacroHelper(arrayList).withAssetUri(this.videoViewController.getNetworkMediaFileUrl()).withContentPlayHead(Integer.valueOf(currentPosition));
                        Intrinsics.checkNotNullExpressionValue(withContentPlayHead, "VastMacroHelper(it)\n    …PlayHead(currentPosition)");
                        TrackingRequest.makeTrackingHttpRequest((Iterable<String>) withContentPlayHead.getUris(), this.videoViewController.getContext());
                    }
                    this.videoViewController.handleIconDisplay(currentPosition);
                    return;
                }
            }
        }
    }
}
