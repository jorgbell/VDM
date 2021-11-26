package androidx.media2.exoplayer.external;

import androidx.media2.exoplayer.external.source.ClippingMediaPeriod;
import androidx.media2.exoplayer.external.source.EmptySampleStream;
import androidx.media2.exoplayer.external.source.MediaPeriod;
import androidx.media2.exoplayer.external.source.MediaSource;
import androidx.media2.exoplayer.external.source.SampleStream;
import androidx.media2.exoplayer.external.source.TrackGroupArray;
import androidx.media2.exoplayer.external.trackselection.TrackSelection;
import androidx.media2.exoplayer.external.trackselection.TrackSelectionArray;
import androidx.media2.exoplayer.external.trackselection.TrackSelector;
import androidx.media2.exoplayer.external.trackselection.TrackSelectorResult;
import androidx.media2.exoplayer.external.upstream.Allocator;
import androidx.media2.exoplayer.external.util.Assertions;
import androidx.media2.exoplayer.external.util.Log;

final class MediaPeriodHolder {
    public boolean hasEnabledTracks;
    public MediaPeriodInfo info;
    private final boolean[] mayRetainStreamFlags;
    public final MediaPeriod mediaPeriod;
    private final MediaSource mediaSource;
    private MediaPeriodHolder next;
    public boolean prepared;
    private final RendererCapabilities[] rendererCapabilities;
    private long rendererPositionOffsetUs;
    public final SampleStream[] sampleStreams;
    private TrackGroupArray trackGroups;
    private final TrackSelector trackSelector;
    private TrackSelectorResult trackSelectorResult;
    public final Object uid;

    public MediaPeriodHolder(RendererCapabilities[] rendererCapabilitiesArr, long j, TrackSelector trackSelector2, Allocator allocator, MediaSource mediaSource2, MediaPeriodInfo mediaPeriodInfo) {
        this.rendererCapabilities = rendererCapabilitiesArr;
        long j2 = mediaPeriodInfo.startPositionUs;
        this.rendererPositionOffsetUs = j - j2;
        this.trackSelector = trackSelector2;
        this.mediaSource = mediaSource2;
        MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodInfo.f7id;
        this.uid = mediaPeriodId.periodUid;
        this.info = mediaPeriodInfo;
        this.sampleStreams = new SampleStream[rendererCapabilitiesArr.length];
        this.mayRetainStreamFlags = new boolean[rendererCapabilitiesArr.length];
        this.mediaPeriod = createMediaPeriod(mediaPeriodId, mediaSource2, allocator, j2, mediaPeriodInfo.endPositionUs);
    }

    public long toRendererTime(long j) {
        return j + getRendererOffset();
    }

    public long toPeriodTime(long j) {
        return j - getRendererOffset();
    }

    public long getRendererOffset() {
        return this.rendererPositionOffsetUs;
    }

    public long getStartPositionRendererTime() {
        return this.info.startPositionUs + this.rendererPositionOffsetUs;
    }

    public boolean isFullyBuffered() {
        return this.prepared && (!this.hasEnabledTracks || this.mediaPeriod.getBufferedPositionUs() == Long.MIN_VALUE);
    }

    public long getBufferedPositionUs() {
        if (!this.prepared) {
            return this.info.startPositionUs;
        }
        long bufferedPositionUs = this.hasEnabledTracks ? this.mediaPeriod.getBufferedPositionUs() : Long.MIN_VALUE;
        return bufferedPositionUs == Long.MIN_VALUE ? this.info.durationUs : bufferedPositionUs;
    }

    public long getNextLoadPositionUs() {
        if (!this.prepared) {
            return 0;
        }
        return this.mediaPeriod.getNextLoadPositionUs();
    }

    public void handlePrepared(float f, Timeline timeline) throws ExoPlaybackException {
        this.prepared = true;
        this.trackGroups = this.mediaPeriod.getTrackGroups();
        TrackSelectorResult selectTracks = selectTracks(f, timeline);
        Assertions.checkNotNull(selectTracks);
        long applyTrackSelection = applyTrackSelection(selectTracks, this.info.startPositionUs, false);
        long j = this.rendererPositionOffsetUs;
        MediaPeriodInfo mediaPeriodInfo = this.info;
        this.rendererPositionOffsetUs = j + (mediaPeriodInfo.startPositionUs - applyTrackSelection);
        this.info = mediaPeriodInfo.copyWithStartPositionUs(applyTrackSelection);
    }

    public void reevaluateBuffer(long j) {
        Assertions.checkState(isLoadingMediaPeriod());
        if (this.prepared) {
            this.mediaPeriod.reevaluateBuffer(toPeriodTime(j));
        }
    }

    public void continueLoading(long j) {
        Assertions.checkState(isLoadingMediaPeriod());
        this.mediaPeriod.continueLoading(toPeriodTime(j));
    }

    public TrackSelectorResult selectTracks(float f, Timeline timeline) throws ExoPlaybackException {
        TrackSelectorResult selectTracks = this.trackSelector.selectTracks(this.rendererCapabilities, getTrackGroups(), this.info.f7id, timeline);
        if (selectTracks.isEquivalent(this.trackSelectorResult)) {
            return null;
        }
        for (TrackSelection trackSelection : selectTracks.selections.getAll()) {
            if (trackSelection != null) {
                trackSelection.onPlaybackSpeed(f);
            }
        }
        return selectTracks;
    }

    public long applyTrackSelection(TrackSelectorResult trackSelectorResult2, long j, boolean z) {
        return applyTrackSelection(trackSelectorResult2, j, z, new boolean[this.rendererCapabilities.length]);
    }

    public long applyTrackSelection(TrackSelectorResult trackSelectorResult2, long j, boolean z, boolean[] zArr) {
        TrackSelectorResult trackSelectorResult3 = trackSelectorResult2;
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= trackSelectorResult3.length) {
                break;
            }
            boolean[] zArr2 = this.mayRetainStreamFlags;
            if (z || !trackSelectorResult2.isEquivalent(this.trackSelectorResult, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        disassociateNoSampleRenderersWithEmptySampleStream(this.sampleStreams);
        disableTrackSelectionsInResult();
        this.trackSelectorResult = trackSelectorResult3;
        enableTrackSelectionsInResult();
        TrackSelectionArray trackSelectionArray = trackSelectorResult3.selections;
        long selectTracks = this.mediaPeriod.selectTracks(trackSelectionArray.getAll(), this.mayRetainStreamFlags, this.sampleStreams, zArr, j);
        associateNoSampleRenderersWithEmptySampleStream(this.sampleStreams);
        this.hasEnabledTracks = false;
        int i2 = 0;
        while (true) {
            SampleStream[] sampleStreamArr = this.sampleStreams;
            if (i2 >= sampleStreamArr.length) {
                return selectTracks;
            }
            if (sampleStreamArr[i2] != null) {
                Assertions.checkState(trackSelectorResult2.isRendererEnabled(i2));
                if (this.rendererCapabilities[i2].getTrackType() != 6) {
                    this.hasEnabledTracks = true;
                }
            } else {
                Assertions.checkState(trackSelectionArray.get(i2) == null);
            }
            i2++;
        }
    }

    public void release() {
        disableTrackSelectionsInResult();
        this.trackSelectorResult = null;
        releaseMediaPeriod(this.info.endPositionUs, this.mediaSource, this.mediaPeriod);
    }

    public void setNext(MediaPeriodHolder mediaPeriodHolder) {
        if (mediaPeriodHolder != this.next) {
            disableTrackSelectionsInResult();
            this.next = mediaPeriodHolder;
            enableTrackSelectionsInResult();
        }
    }

    public MediaPeriodHolder getNext() {
        return this.next;
    }

    public TrackGroupArray getTrackGroups() {
        TrackGroupArray trackGroupArray = this.trackGroups;
        Assertions.checkNotNull(trackGroupArray);
        return trackGroupArray;
    }

    public TrackSelectorResult getTrackSelectorResult() {
        TrackSelectorResult trackSelectorResult2 = this.trackSelectorResult;
        Assertions.checkNotNull(trackSelectorResult2);
        return trackSelectorResult2;
    }

    private void enableTrackSelectionsInResult() {
        TrackSelectorResult trackSelectorResult2 = this.trackSelectorResult;
        if (isLoadingMediaPeriod() && trackSelectorResult2 != null) {
            for (int i = 0; i < trackSelectorResult2.length; i++) {
                boolean isRendererEnabled = trackSelectorResult2.isRendererEnabled(i);
                TrackSelection trackSelection = trackSelectorResult2.selections.get(i);
                if (isRendererEnabled && trackSelection != null) {
                    trackSelection.enable();
                }
            }
        }
    }

    private void disableTrackSelectionsInResult() {
        TrackSelectorResult trackSelectorResult2 = this.trackSelectorResult;
        if (isLoadingMediaPeriod() && trackSelectorResult2 != null) {
            for (int i = 0; i < trackSelectorResult2.length; i++) {
                boolean isRendererEnabled = trackSelectorResult2.isRendererEnabled(i);
                TrackSelection trackSelection = trackSelectorResult2.selections.get(i);
                if (isRendererEnabled && trackSelection != null) {
                    trackSelection.disable();
                }
            }
        }
    }

    private void disassociateNoSampleRenderersWithEmptySampleStream(SampleStream[] sampleStreamArr) {
        int i = 0;
        while (true) {
            RendererCapabilities[] rendererCapabilitiesArr = this.rendererCapabilities;
            if (i < rendererCapabilitiesArr.length) {
                if (rendererCapabilitiesArr[i].getTrackType() == 6) {
                    sampleStreamArr[i] = null;
                }
                i++;
            } else {
                return;
            }
        }
    }

    private void associateNoSampleRenderersWithEmptySampleStream(SampleStream[] sampleStreamArr) {
        TrackSelectorResult trackSelectorResult2 = this.trackSelectorResult;
        Assertions.checkNotNull(trackSelectorResult2);
        TrackSelectorResult trackSelectorResult3 = trackSelectorResult2;
        int i = 0;
        while (true) {
            RendererCapabilities[] rendererCapabilitiesArr = this.rendererCapabilities;
            if (i < rendererCapabilitiesArr.length) {
                if (rendererCapabilitiesArr[i].getTrackType() == 6 && trackSelectorResult3.isRendererEnabled(i)) {
                    sampleStreamArr[i] = new EmptySampleStream();
                }
                i++;
            } else {
                return;
            }
        }
    }

    private boolean isLoadingMediaPeriod() {
        return this.next == null;
    }

    private static MediaPeriod createMediaPeriod(MediaSource.MediaPeriodId mediaPeriodId, MediaSource mediaSource2, Allocator allocator, long j, long j2) {
        MediaPeriod createPeriod = mediaSource2.createPeriod(mediaPeriodId, allocator, j);
        return (j2 == -9223372036854775807L || j2 == Long.MIN_VALUE) ? createPeriod : new ClippingMediaPeriod(createPeriod, true, 0, j2);
    }

    private static void releaseMediaPeriod(long j, MediaSource mediaSource2, MediaPeriod mediaPeriod2) {
        if (j == -9223372036854775807L || j == Long.MIN_VALUE) {
            mediaSource2.releasePeriod(mediaPeriod2);
            return;
        }
        try {
            mediaSource2.releasePeriod(((ClippingMediaPeriod) mediaPeriod2).mediaPeriod);
        } catch (RuntimeException e) {
            Log.m14e("MediaPeriodHolder", "Period release failed.", e);
        }
    }
}
