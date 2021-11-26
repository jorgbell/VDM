package com.mopub.common;

import android.view.View;
import com.iab.omid.library.mopub.adsession.AdEvents;
import com.iab.omid.library.mopub.adsession.AdSession;
import com.iab.omid.library.mopub.adsession.CreativeType;
import com.iab.omid.library.mopub.adsession.Owner;
import com.iab.omid.library.mopub.adsession.media.InteractionType;
import com.iab.omid.library.mopub.adsession.media.MediaEvents;
import com.iab.omid.library.mopub.adsession.media.PlayerState;
import com.mopub.common.ViewabilityTracker;
import java.util.Set;

class ViewabilityTrackerVideo extends ViewabilityTracker {
    private MediaEvents mediaEvents;

    static ViewabilityTracker createVastVideoTracker(View view, Set<ViewabilityVendor> set) throws IllegalArgumentException {
        AdSession createAdSession = ViewabilityTracker.createAdSession(CreativeType.VIDEO, set, Owner.NATIVE);
        return new ViewabilityTrackerVideo(createAdSession, AdEvents.createAdEvents(createAdSession), view);
    }

    private ViewabilityTrackerVideo(AdSession adSession, AdEvents adEvents, View view) throws IllegalArgumentException, IllegalStateException {
        this(adSession, adEvents, view, MediaEvents.createMediaEvents(adSession));
    }

    @VisibleForTesting
    ViewabilityTrackerVideo(AdSession adSession, AdEvents adEvents, View view, MediaEvents mediaEvents2) throws IllegalArgumentException, IllegalStateException {
        super(adSession, adEvents, view);
        this.mediaEvents = mediaEvents2;
        log("ViewabilityTrackerVideo() sesseionId:" + this.sessionID);
    }

    public void startTracking() {
        log("ViewabilityTrackerVideo.startTracking() sesseionId: " + this.sessionID);
        changeState(ViewabilityTracker.STATE.STARTED_VIDEO);
    }

    public void videoPrepared(float f) {
        log("videoPrepared() duration= " + f);
        if (!isTracking()) {
            log("videoPrepared() not tracking yet: " + this.sessionID);
            return;
        }
        this.mediaEvents.start(f, 1.0f);
    }

    public void trackVideo(VideoEvent videoEvent) {
        if (!isTracking()) {
            log("trackVideo() skip event: " + videoEvent.name());
            return;
        }
        log("trackVideo() event: " + videoEvent.name() + " " + this.sessionID);
        switch (C24941.$SwitchMap$com$mopub$common$VideoEvent[videoEvent.ordinal()]) {
            case 1:
                trackImpression();
                return;
            case 2:
                this.mediaEvents.pause();
                return;
            case 3:
                this.mediaEvents.resume();
                return;
            case 4:
                this.mediaEvents.skipped();
                return;
            case 5:
                this.mediaEvents.adUserInteraction(InteractionType.CLICK);
                return;
            case 6:
                this.mediaEvents.skipped();
                return;
            case 7:
                this.mediaEvents.bufferStart();
                return;
            case 8:
                this.mediaEvents.bufferFinish();
                return;
            case 9:
                this.mediaEvents.firstQuartile();
                return;
            case 10:
                this.mediaEvents.midpoint();
                return;
            case 11:
                this.mediaEvents.thirdQuartile();
                return;
            case 12:
                this.mediaEvents.complete();
                return;
            case 13:
                this.mediaEvents.playerStateChange(PlayerState.FULLSCREEN);
                return;
            case 14:
                this.mediaEvents.playerStateChange(PlayerState.NORMAL);
                return;
            case 15:
                this.mediaEvents.volumeChange(1.0f);
                return;
            default:
                return;
        }
    }

    /* renamed from: com.mopub.common.ViewabilityTrackerVideo$1 */
    static /* synthetic */ class C24941 {
        static final /* synthetic */ int[] $SwitchMap$com$mopub$common$VideoEvent;

        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.mopub.common.VideoEvent[] r0 = com.mopub.common.VideoEvent.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$mopub$common$VideoEvent = r0
                com.mopub.common.VideoEvent r1 = com.mopub.common.VideoEvent.AD_IMPRESSED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$mopub$common$VideoEvent     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mopub.common.VideoEvent r1 = com.mopub.common.VideoEvent.AD_PAUSED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$mopub$common$VideoEvent     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.mopub.common.VideoEvent r1 = com.mopub.common.VideoEvent.AD_RESUMED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$mopub$common$VideoEvent     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.mopub.common.VideoEvent r1 = com.mopub.common.VideoEvent.AD_SKIPPED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$mopub$common$VideoEvent     // Catch:{ NoSuchFieldError -> 0x003e }
                com.mopub.common.VideoEvent r1 = com.mopub.common.VideoEvent.AD_CLICK_THRU     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$mopub$common$VideoEvent     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.mopub.common.VideoEvent r1 = com.mopub.common.VideoEvent.RECORD_AD_ERROR     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$mopub$common$VideoEvent     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.mopub.common.VideoEvent r1 = com.mopub.common.VideoEvent.AD_BUFFER_START     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$mopub$common$VideoEvent     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.mopub.common.VideoEvent r1 = com.mopub.common.VideoEvent.AD_BUFFER_END     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$mopub$common$VideoEvent     // Catch:{ NoSuchFieldError -> 0x006c }
                com.mopub.common.VideoEvent r1 = com.mopub.common.VideoEvent.AD_VIDEO_FIRST_QUARTILE     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$mopub$common$VideoEvent     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.mopub.common.VideoEvent r1 = com.mopub.common.VideoEvent.AD_VIDEO_MIDPOINT     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$mopub$common$VideoEvent     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.mopub.common.VideoEvent r1 = com.mopub.common.VideoEvent.AD_VIDEO_THIRD_QUARTILE     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$mopub$common$VideoEvent     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.mopub.common.VideoEvent r1 = com.mopub.common.VideoEvent.AD_COMPLETE     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$com$mopub$common$VideoEvent     // Catch:{ NoSuchFieldError -> 0x009c }
                com.mopub.common.VideoEvent r1 = com.mopub.common.VideoEvent.AD_FULLSCREEN     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$com$mopub$common$VideoEvent     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.mopub.common.VideoEvent r1 = com.mopub.common.VideoEvent.AD_NORMAL     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = $SwitchMap$com$mopub$common$VideoEvent     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.mopub.common.VideoEvent r1 = com.mopub.common.VideoEvent.AD_VOLUME_CHANGE     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mopub.common.ViewabilityTrackerVideo.C24941.<clinit>():void");
        }
    }
}
