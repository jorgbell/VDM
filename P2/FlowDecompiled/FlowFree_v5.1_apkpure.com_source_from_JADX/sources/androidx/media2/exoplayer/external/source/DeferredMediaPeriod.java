package androidx.media2.exoplayer.external.source;

import androidx.media2.exoplayer.external.SeekParameters;
import androidx.media2.exoplayer.external.source.MediaPeriod;
import androidx.media2.exoplayer.external.source.MediaSource;
import androidx.media2.exoplayer.external.trackselection.TrackSelection;
import androidx.media2.exoplayer.external.upstream.Allocator;
import androidx.media2.exoplayer.external.util.Util;
import java.io.IOException;

public final class DeferredMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
    private final Allocator allocator;
    private MediaPeriod.Callback callback;

    /* renamed from: id */
    public final MediaSource.MediaPeriodId f16id;
    private PrepareErrorListener listener;
    private MediaPeriod mediaPeriod;
    public final MediaSource mediaSource;
    private boolean notifiedPrepareError;
    private long preparePositionOverrideUs = -9223372036854775807L;
    private long preparePositionUs;

    public interface PrepareErrorListener {
        void onPrepareError(MediaSource.MediaPeriodId mediaPeriodId, IOException iOException);
    }

    public DeferredMediaPeriod(MediaSource mediaSource2, MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator2, long j) {
        this.f16id = mediaPeriodId;
        this.allocator = allocator2;
        this.mediaSource = mediaSource2;
        this.preparePositionUs = j;
    }

    public long getPreparePositionUs() {
        return this.preparePositionUs;
    }

    public void overridePreparePositionUs(long j) {
        this.preparePositionOverrideUs = j;
    }

    public void createPeriod(MediaSource.MediaPeriodId mediaPeriodId) {
        long preparePositionWithOverride = getPreparePositionWithOverride(this.preparePositionUs);
        MediaPeriod createPeriod = this.mediaSource.createPeriod(mediaPeriodId, this.allocator, preparePositionWithOverride);
        this.mediaPeriod = createPeriod;
        if (this.callback != null) {
            createPeriod.prepare(this, preparePositionWithOverride);
        }
    }

    public void releasePeriod() {
        MediaPeriod mediaPeriod2 = this.mediaPeriod;
        if (mediaPeriod2 != null) {
            this.mediaSource.releasePeriod(mediaPeriod2);
        }
    }

    public void prepare(MediaPeriod.Callback callback2, long j) {
        this.callback = callback2;
        MediaPeriod mediaPeriod2 = this.mediaPeriod;
        if (mediaPeriod2 != null) {
            mediaPeriod2.prepare(this, getPreparePositionWithOverride(this.preparePositionUs));
        }
    }

    public void maybeThrowPrepareError() throws IOException {
        try {
            MediaPeriod mediaPeriod2 = this.mediaPeriod;
            if (mediaPeriod2 != null) {
                mediaPeriod2.maybeThrowPrepareError();
            } else {
                this.mediaSource.maybeThrowSourceInfoRefreshError();
            }
        } catch (IOException e) {
            PrepareErrorListener prepareErrorListener = this.listener;
            if (prepareErrorListener == null) {
                throw e;
            } else if (!this.notifiedPrepareError) {
                this.notifiedPrepareError = true;
                prepareErrorListener.onPrepareError(this.f16id, e);
            }
        }
    }

    public TrackGroupArray getTrackGroups() {
        MediaPeriod mediaPeriod2 = this.mediaPeriod;
        Util.castNonNull(mediaPeriod2);
        return mediaPeriod2.getTrackGroups();
    }

    public long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        long j2;
        long j3 = this.preparePositionOverrideUs;
        if (j3 == -9223372036854775807L || j != this.preparePositionUs) {
            j2 = j;
        } else {
            this.preparePositionOverrideUs = -9223372036854775807L;
            j2 = j3;
        }
        MediaPeriod mediaPeriod2 = this.mediaPeriod;
        Util.castNonNull(mediaPeriod2);
        return mediaPeriod2.selectTracks(trackSelectionArr, zArr, sampleStreamArr, zArr2, j2);
    }

    public void discardBuffer(long j, boolean z) {
        MediaPeriod mediaPeriod2 = this.mediaPeriod;
        Util.castNonNull(mediaPeriod2);
        mediaPeriod2.discardBuffer(j, z);
    }

    public long readDiscontinuity() {
        MediaPeriod mediaPeriod2 = this.mediaPeriod;
        Util.castNonNull(mediaPeriod2);
        return mediaPeriod2.readDiscontinuity();
    }

    public long getBufferedPositionUs() {
        MediaPeriod mediaPeriod2 = this.mediaPeriod;
        Util.castNonNull(mediaPeriod2);
        return mediaPeriod2.getBufferedPositionUs();
    }

    public long seekToUs(long j) {
        MediaPeriod mediaPeriod2 = this.mediaPeriod;
        Util.castNonNull(mediaPeriod2);
        return mediaPeriod2.seekToUs(j);
    }

    public long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        MediaPeriod mediaPeriod2 = this.mediaPeriod;
        Util.castNonNull(mediaPeriod2);
        return mediaPeriod2.getAdjustedSeekPositionUs(j, seekParameters);
    }

    public long getNextLoadPositionUs() {
        MediaPeriod mediaPeriod2 = this.mediaPeriod;
        Util.castNonNull(mediaPeriod2);
        return mediaPeriod2.getNextLoadPositionUs();
    }

    public void reevaluateBuffer(long j) {
        MediaPeriod mediaPeriod2 = this.mediaPeriod;
        Util.castNonNull(mediaPeriod2);
        mediaPeriod2.reevaluateBuffer(j);
    }

    public boolean continueLoading(long j) {
        MediaPeriod mediaPeriod2 = this.mediaPeriod;
        return mediaPeriod2 != null && mediaPeriod2.continueLoading(j);
    }

    public void onContinueLoadingRequested(MediaPeriod mediaPeriod2) {
        MediaPeriod.Callback callback2 = this.callback;
        Util.castNonNull(callback2);
        callback2.onContinueLoadingRequested(this);
    }

    public void onPrepared(MediaPeriod mediaPeriod2) {
        MediaPeriod.Callback callback2 = this.callback;
        Util.castNonNull(callback2);
        callback2.onPrepared(this);
    }

    private long getPreparePositionWithOverride(long j) {
        long j2 = this.preparePositionOverrideUs;
        return j2 != -9223372036854775807L ? j2 : j;
    }
}
