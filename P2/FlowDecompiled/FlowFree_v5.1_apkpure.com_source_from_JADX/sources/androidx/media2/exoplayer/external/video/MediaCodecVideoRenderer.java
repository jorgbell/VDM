package androidx.media2.exoplayer.external.video;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Surface;
import androidx.media2.exoplayer.external.BaseRenderer;
import androidx.media2.exoplayer.external.ExoPlaybackException;
import androidx.media2.exoplayer.external.Format;
import androidx.media2.exoplayer.external.FormatHolder;
import androidx.media2.exoplayer.external.decoder.DecoderCounters;
import androidx.media2.exoplayer.external.decoder.DecoderInputBuffer;
import androidx.media2.exoplayer.external.drm.DrmInitData;
import androidx.media2.exoplayer.external.drm.DrmSessionManager;
import androidx.media2.exoplayer.external.drm.FrameworkMediaCrypto;
import androidx.media2.exoplayer.external.mediacodec.MediaCodecInfo;
import androidx.media2.exoplayer.external.mediacodec.MediaCodecRenderer;
import androidx.media2.exoplayer.external.mediacodec.MediaCodecSelector;
import androidx.media2.exoplayer.external.mediacodec.MediaCodecUtil;
import androidx.media2.exoplayer.external.mediacodec.MediaFormatUtil;
import androidx.media2.exoplayer.external.util.Assertions;
import androidx.media2.exoplayer.external.util.Log;
import androidx.media2.exoplayer.external.util.MimeTypes;
import androidx.media2.exoplayer.external.util.TraceUtil;
import androidx.media2.exoplayer.external.util.Util;
import androidx.media2.exoplayer.external.video.VideoRendererEventListener;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public class MediaCodecVideoRenderer extends MediaCodecRenderer {
    private static final int[] STANDARD_LONG_EDGE_VIDEO_PX = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private static boolean deviceNeedsSetOutputSurfaceWorkaround;
    private static boolean evaluatedDeviceNeedsSetOutputSurfaceWorkaround;
    private final long allowedJoiningTimeMs;
    private int buffersInCodecCount;
    private CodecMaxValues codecMaxValues;
    private boolean codecNeedsSetOutputSurfaceWorkaround;
    private int consecutiveDroppedFrameCount;
    private final Context context;
    private int currentHeight;
    private float currentPixelWidthHeightRatio;
    private int currentUnappliedRotationDegrees;
    private int currentWidth;
    private final boolean deviceNeedsNoPostProcessWorkaround;
    private long droppedFrameAccumulationStartTimeMs;
    private int droppedFrames;
    private Surface dummySurface;
    private final VideoRendererEventListener.EventDispatcher eventDispatcher;
    private VideoFrameMetadataListener frameMetadataListener;
    private final VideoFrameReleaseTimeHelper frameReleaseTimeHelper;
    private long initialPositionUs;
    private long joiningDeadlineMs;
    private long lastInputTimeUs;
    private long lastRenderTimeUs;
    private final int maxDroppedFramesToNotify;
    private long outputStreamOffsetUs;
    private int pendingOutputStreamOffsetCount;
    private final long[] pendingOutputStreamOffsetsUs;
    private final long[] pendingOutputStreamSwitchTimesUs;
    private float pendingPixelWidthHeightRatio;
    private int pendingRotationDegrees;
    private boolean renderedFirstFrame;
    private int reportedHeight;
    private float reportedPixelWidthHeightRatio;
    private int reportedUnappliedRotationDegrees;
    private int reportedWidth;
    private int scalingMode;
    private Surface surface;
    private boolean tunneling;
    private int tunnelingAudioSessionId;
    OnFrameRenderedListenerV23 tunnelingOnFrameRenderedListener;

    private static boolean isBufferLate(long j) {
        return j < -30000;
    }

    private static boolean isBufferVeryLate(long j) {
        return j < -500000;
    }

    public MediaCodecVideoRenderer(Context context2, MediaCodecSelector mediaCodecSelector, long j, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean z, Handler handler, VideoRendererEventListener videoRendererEventListener, int i) {
        this(context2, mediaCodecSelector, j, drmSessionManager, z, false, handler, videoRendererEventListener, i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MediaCodecVideoRenderer(Context context2, MediaCodecSelector mediaCodecSelector, long j, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean z, boolean z2, Handler handler, VideoRendererEventListener videoRendererEventListener, int i) {
        super(2, mediaCodecSelector, drmSessionManager, z, z2, 30.0f);
        this.allowedJoiningTimeMs = j;
        this.maxDroppedFramesToNotify = i;
        Context applicationContext = context2.getApplicationContext();
        this.context = applicationContext;
        this.frameReleaseTimeHelper = new VideoFrameReleaseTimeHelper(applicationContext);
        this.eventDispatcher = new VideoRendererEventListener.EventDispatcher(handler, videoRendererEventListener);
        this.deviceNeedsNoPostProcessWorkaround = deviceNeedsNoPostProcessWorkaround();
        this.pendingOutputStreamOffsetsUs = new long[10];
        this.pendingOutputStreamSwitchTimesUs = new long[10];
        this.outputStreamOffsetUs = -9223372036854775807L;
        this.lastInputTimeUs = -9223372036854775807L;
        this.joiningDeadlineMs = -9223372036854775807L;
        this.currentWidth = -1;
        this.currentHeight = -1;
        this.currentPixelWidthHeightRatio = -1.0f;
        this.pendingPixelWidthHeightRatio = -1.0f;
        this.scalingMode = 1;
        clearReportedVideoSize();
    }

    /* access modifiers changed from: protected */
    public int supportsFormat(MediaCodecSelector mediaCodecSelector, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, Format format) throws MediaCodecUtil.DecoderQueryException {
        int i = 0;
        if (!MimeTypes.isVideo(format.sampleMimeType)) {
            return 0;
        }
        DrmInitData drmInitData = format.drmInitData;
        boolean z = drmInitData != null;
        List<MediaCodecInfo> decoderInfos = getDecoderInfos(mediaCodecSelector, format, z, false);
        if (z && decoderInfos.isEmpty()) {
            decoderInfos = getDecoderInfos(mediaCodecSelector, format, false, false);
        }
        if (decoderInfos.isEmpty()) {
            return 1;
        }
        if (!BaseRenderer.supportsFormatDrm(drmSessionManager, drmInitData)) {
            return 2;
        }
        MediaCodecInfo mediaCodecInfo = decoderInfos.get(0);
        boolean isFormatSupported = mediaCodecInfo.isFormatSupported(format);
        int i2 = mediaCodecInfo.isSeamlessAdaptationSupported(format) ? 16 : 8;
        if (isFormatSupported) {
            List<MediaCodecInfo> decoderInfos2 = getDecoderInfos(mediaCodecSelector, format, z, true);
            if (!decoderInfos2.isEmpty()) {
                MediaCodecInfo mediaCodecInfo2 = decoderInfos2.get(0);
                if (mediaCodecInfo2.isFormatSupported(format) && mediaCodecInfo2.isSeamlessAdaptationSupported(format)) {
                    i = 32;
                }
            }
        }
        return (isFormatSupported ? 4 : 3) | i2 | i;
    }

    /* access modifiers changed from: protected */
    public List<MediaCodecInfo> getDecoderInfos(MediaCodecSelector mediaCodecSelector, Format format, boolean z) throws MediaCodecUtil.DecoderQueryException {
        return getDecoderInfos(mediaCodecSelector, format, z, this.tunneling);
    }

    private static List<MediaCodecInfo> getDecoderInfos(MediaCodecSelector mediaCodecSelector, Format format, boolean z, boolean z2) throws MediaCodecUtil.DecoderQueryException {
        Pair<Integer, Integer> codecProfileAndLevel;
        List<MediaCodecInfo> decoderInfosSortedByFormatSupport = MediaCodecUtil.getDecoderInfosSortedByFormatSupport(mediaCodecSelector.getDecoderInfos(format.sampleMimeType, z, z2), format);
        if ("video/dolby-vision".equals(format.sampleMimeType) && (codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format.codecs)) != null) {
            int intValue = ((Integer) codecProfileAndLevel.first).intValue();
            if (intValue == 4 || intValue == 8) {
                decoderInfosSortedByFormatSupport.addAll(mediaCodecSelector.getDecoderInfos("video/hevc", z, z2));
            } else if (intValue == 9) {
                decoderInfosSortedByFormatSupport.addAll(mediaCodecSelector.getDecoderInfos("video/avc", z, z2));
            }
        }
        return Collections.unmodifiableList(decoderInfosSortedByFormatSupport);
    }

    /* access modifiers changed from: protected */
    public void onEnabled(boolean z) throws ExoPlaybackException {
        super.onEnabled(z);
        int i = this.tunnelingAudioSessionId;
        int i2 = getConfiguration().tunnelingAudioSessionId;
        this.tunnelingAudioSessionId = i2;
        this.tunneling = i2 != 0;
        if (i2 != i) {
            releaseCodec();
        }
        this.eventDispatcher.enabled(this.decoderCounters);
        this.frameReleaseTimeHelper.enable();
    }

    /* access modifiers changed from: protected */
    public void onStreamChanged(Format[] formatArr, long j) throws ExoPlaybackException {
        if (this.outputStreamOffsetUs == -9223372036854775807L) {
            this.outputStreamOffsetUs = j;
        } else {
            int i = this.pendingOutputStreamOffsetCount;
            long[] jArr = this.pendingOutputStreamOffsetsUs;
            if (i == jArr.length) {
                long j2 = jArr[i - 1];
                StringBuilder sb = new StringBuilder(65);
                sb.append("Too many stream changes, so dropping offset: ");
                sb.append(j2);
                Log.m16w("MediaCodecVideoRenderer", sb.toString());
            } else {
                this.pendingOutputStreamOffsetCount = i + 1;
            }
            long[] jArr2 = this.pendingOutputStreamOffsetsUs;
            int i2 = this.pendingOutputStreamOffsetCount;
            jArr2[i2 - 1] = j;
            this.pendingOutputStreamSwitchTimesUs[i2 - 1] = this.lastInputTimeUs;
        }
        super.onStreamChanged(formatArr, j);
    }

    /* access modifiers changed from: protected */
    public void onPositionReset(long j, boolean z) throws ExoPlaybackException {
        super.onPositionReset(j, z);
        clearRenderedFirstFrame();
        this.initialPositionUs = -9223372036854775807L;
        this.consecutiveDroppedFrameCount = 0;
        this.lastInputTimeUs = -9223372036854775807L;
        int i = this.pendingOutputStreamOffsetCount;
        if (i != 0) {
            this.outputStreamOffsetUs = this.pendingOutputStreamOffsetsUs[i - 1];
            this.pendingOutputStreamOffsetCount = 0;
        }
        if (z) {
            setJoiningDeadlineMs();
        } else {
            this.joiningDeadlineMs = -9223372036854775807L;
        }
    }

    public boolean isReady() {
        Surface surface2;
        if (super.isReady() && (this.renderedFirstFrame || (((surface2 = this.dummySurface) != null && this.surface == surface2) || getCodec() == null || this.tunneling))) {
            this.joiningDeadlineMs = -9223372036854775807L;
            return true;
        } else if (this.joiningDeadlineMs == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.joiningDeadlineMs) {
                return true;
            }
            this.joiningDeadlineMs = -9223372036854775807L;
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void onStarted() {
        super.onStarted();
        this.droppedFrames = 0;
        this.droppedFrameAccumulationStartTimeMs = SystemClock.elapsedRealtime();
        this.lastRenderTimeUs = SystemClock.elapsedRealtime() * 1000;
    }

    /* access modifiers changed from: protected */
    public void onStopped() {
        this.joiningDeadlineMs = -9223372036854775807L;
        maybeNotifyDroppedFrames();
        super.onStopped();
    }

    /* access modifiers changed from: protected */
    public void onDisabled() {
        this.lastInputTimeUs = -9223372036854775807L;
        this.outputStreamOffsetUs = -9223372036854775807L;
        this.pendingOutputStreamOffsetCount = 0;
        clearReportedVideoSize();
        clearRenderedFirstFrame();
        this.frameReleaseTimeHelper.disable();
        this.tunnelingOnFrameRenderedListener = null;
        try {
            super.onDisabled();
        } finally {
            this.eventDispatcher.disabled(this.decoderCounters);
        }
    }

    /* access modifiers changed from: protected */
    public void onReset() {
        try {
            super.onReset();
            Surface surface2 = this.dummySurface;
            if (surface2 != null) {
                if (this.surface == surface2) {
                    this.surface = null;
                }
                surface2.release();
                this.dummySurface = null;
            }
        } catch (Throwable th) {
            if (this.dummySurface != null) {
                Surface surface3 = this.surface;
                Surface surface4 = this.dummySurface;
                if (surface3 == surface4) {
                    this.surface = null;
                }
                surface4.release();
                this.dummySurface = null;
            }
            throw th;
        }
    }

    public void handleMessage(int i, Object obj) throws ExoPlaybackException {
        if (i == 1) {
            setSurface((Surface) obj);
        } else if (i == 4) {
            this.scalingMode = ((Integer) obj).intValue();
            MediaCodec codec = getCodec();
            if (codec != null) {
                codec.setVideoScalingMode(this.scalingMode);
            }
        } else if (i == 6) {
            this.frameMetadataListener = (VideoFrameMetadataListener) obj;
        } else {
            super.handleMessage(i, obj);
        }
    }

    private void setSurface(Surface surface2) throws ExoPlaybackException {
        if (surface2 == null) {
            Surface surface3 = this.dummySurface;
            if (surface3 != null) {
                surface2 = surface3;
            } else {
                MediaCodecInfo codecInfo = getCodecInfo();
                if (codecInfo != null && shouldUseDummySurface(codecInfo)) {
                    surface2 = DummySurface.newInstanceV17(this.context, codecInfo.secure);
                    this.dummySurface = surface2;
                }
            }
        }
        if (this.surface != surface2) {
            this.surface = surface2;
            int state = getState();
            MediaCodec codec = getCodec();
            if (codec != null) {
                if (Util.SDK_INT < 23 || surface2 == null || this.codecNeedsSetOutputSurfaceWorkaround) {
                    releaseCodec();
                    maybeInitCodec();
                } else {
                    setOutputSurfaceV23(codec, surface2);
                }
            }
            if (surface2 == null || surface2 == this.dummySurface) {
                clearReportedVideoSize();
                clearRenderedFirstFrame();
                return;
            }
            maybeRenotifyVideoSizeChanged();
            clearRenderedFirstFrame();
            if (state == 2) {
                setJoiningDeadlineMs();
            }
        } else if (surface2 != null && surface2 != this.dummySurface) {
            maybeRenotifyVideoSizeChanged();
            maybeRenotifyRenderedFirstFrame();
        }
    }

    /* access modifiers changed from: protected */
    public boolean shouldInitCodec(MediaCodecInfo mediaCodecInfo) {
        return this.surface != null || shouldUseDummySurface(mediaCodecInfo);
    }

    /* access modifiers changed from: protected */
    public boolean getCodecNeedsEosPropagation() {
        return this.tunneling;
    }

    /* access modifiers changed from: protected */
    public void configureCodec(MediaCodecInfo mediaCodecInfo, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto, float f) throws MediaCodecUtil.DecoderQueryException {
        CodecMaxValues codecMaxValues2 = getCodecMaxValues(mediaCodecInfo, format, getStreamFormats());
        this.codecMaxValues = codecMaxValues2;
        MediaFormat mediaFormat = getMediaFormat(format, codecMaxValues2, f, this.deviceNeedsNoPostProcessWorkaround, this.tunnelingAudioSessionId);
        if (this.surface == null) {
            Assertions.checkState(shouldUseDummySurface(mediaCodecInfo));
            if (this.dummySurface == null) {
                this.dummySurface = DummySurface.newInstanceV17(this.context, mediaCodecInfo.secure);
            }
            this.surface = this.dummySurface;
        }
        mediaCodec.configure(mediaFormat, this.surface, mediaCrypto, 0);
        if (Util.SDK_INT >= 23 && this.tunneling) {
            this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListenerV23(mediaCodec);
        }
    }

    /* access modifiers changed from: protected */
    public int canKeepCodec(MediaCodec mediaCodec, MediaCodecInfo mediaCodecInfo, Format format, Format format2) {
        if (!mediaCodecInfo.isSeamlessAdaptationSupported(format, format2, true)) {
            return 0;
        }
        int i = format2.width;
        CodecMaxValues codecMaxValues2 = this.codecMaxValues;
        if (i > codecMaxValues2.width || format2.height > codecMaxValues2.height || getMaxInputSize(mediaCodecInfo, format2) > this.codecMaxValues.inputSize) {
            return 0;
        }
        return format.initializationDataEquals(format2) ? 3 : 2;
    }

    /* access modifiers changed from: protected */
    public void releaseCodec() {
        try {
            super.releaseCodec();
        } finally {
            this.buffersInCodecCount = 0;
        }
    }

    /* access modifiers changed from: protected */
    public boolean flushOrReleaseCodec() {
        try {
            return super.flushOrReleaseCodec();
        } finally {
            this.buffersInCodecCount = 0;
        }
    }

    /* access modifiers changed from: protected */
    public float getCodecOperatingRateV23(float f, Format format, Format[] formatArr) {
        float f2 = -1.0f;
        for (Format format2 : formatArr) {
            float f3 = format2.frameRate;
            if (f3 != -1.0f) {
                f2 = Math.max(f2, f3);
            }
        }
        if (f2 == -1.0f) {
            return -1.0f;
        }
        return f2 * f;
    }

    /* access modifiers changed from: protected */
    public void onCodecInitialized(String str, long j, long j2) {
        this.eventDispatcher.decoderInitialized(str, j, j2);
        this.codecNeedsSetOutputSurfaceWorkaround = codecNeedsSetOutputSurfaceWorkaround(str);
    }

    /* access modifiers changed from: protected */
    public void onInputFormatChanged(FormatHolder formatHolder) throws ExoPlaybackException {
        super.onInputFormatChanged(formatHolder);
        Format format = formatHolder.format;
        this.eventDispatcher.inputFormatChanged(format);
        this.pendingPixelWidthHeightRatio = format.pixelWidthHeightRatio;
        this.pendingRotationDegrees = format.rotationDegrees;
    }

    /* access modifiers changed from: protected */
    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        this.buffersInCodecCount++;
        this.lastInputTimeUs = Math.max(decoderInputBuffer.timeUs, this.lastInputTimeUs);
        if (Util.SDK_INT < 23 && this.tunneling) {
            onProcessedTunneledBuffer(decoderInputBuffer.timeUs);
        }
    }

    /* access modifiers changed from: protected */
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int i;
        int i2;
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        if (z) {
            i = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            i = mediaFormat.getInteger("width");
        }
        if (z) {
            i2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            i2 = mediaFormat.getInteger("height");
        }
        processOutputFormat(mediaCodec, i, i2);
    }

    /* access modifiers changed from: protected */
    public boolean processOutputBuffer(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z, Format format) throws ExoPlaybackException {
        long j4 = j;
        long j5 = j2;
        MediaCodec mediaCodec2 = mediaCodec;
        int i3 = i;
        long j6 = j3;
        if (this.initialPositionUs == -9223372036854775807L) {
            this.initialPositionUs = j4;
        }
        long j7 = j6 - this.outputStreamOffsetUs;
        if (z) {
            skipOutputBuffer(mediaCodec2, i3, j7);
            return true;
        }
        long j8 = j6 - j4;
        if (this.surface != this.dummySurface) {
            long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
            boolean z2 = getState() == 2;
            if (!this.renderedFirstFrame || (z2 && shouldForceRenderOutputBuffer(j8, elapsedRealtime - this.lastRenderTimeUs))) {
                long nanoTime = System.nanoTime();
                notifyFrameMetadataListener(j7, nanoTime, format);
                if (Util.SDK_INT >= 21) {
                    renderOutputBufferV21(mediaCodec, i, j7, nanoTime);
                    return true;
                }
                renderOutputBuffer(mediaCodec2, i3, j7);
                return true;
            }
            if (z2 && j4 != this.initialPositionUs) {
                long nanoTime2 = System.nanoTime();
                long adjustReleaseTime = this.frameReleaseTimeHelper.adjustReleaseTime(j6, ((j8 - (elapsedRealtime - j5)) * 1000) + nanoTime2);
                long j9 = (adjustReleaseTime - nanoTime2) / 1000;
                if (shouldDropBuffersToKeyframe(j9, j5) && maybeDropBuffersToKeyframe(mediaCodec, i, j7, j)) {
                    return false;
                }
                if (shouldDropOutputBuffer(j9, j5)) {
                    dropOutputBuffer(mediaCodec2, i3, j7);
                    return true;
                } else if (Util.SDK_INT >= 21) {
                    if (j9 < 50000) {
                        notifyFrameMetadataListener(j7, adjustReleaseTime, format);
                        renderOutputBufferV21(mediaCodec, i, j7, adjustReleaseTime);
                        return true;
                    }
                } else if (j9 < 30000) {
                    if (j9 > 11000) {
                        try {
                            Thread.sleep((j9 - 10000) / 1000);
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                            return false;
                        }
                    }
                    notifyFrameMetadataListener(j7, adjustReleaseTime, format);
                    renderOutputBuffer(mediaCodec2, i3, j7);
                    return true;
                }
            }
            return false;
        } else if (!isBufferLate(j8)) {
            return false;
        } else {
            skipOutputBuffer(mediaCodec2, i3, j7);
            return true;
        }
    }

    private void processOutputFormat(MediaCodec mediaCodec, int i, int i2) {
        this.currentWidth = i;
        this.currentHeight = i2;
        float f = this.pendingPixelWidthHeightRatio;
        this.currentPixelWidthHeightRatio = f;
        if (Util.SDK_INT >= 21) {
            int i3 = this.pendingRotationDegrees;
            if (i3 == 90 || i3 == 270) {
                this.currentWidth = i2;
                this.currentHeight = i;
                this.currentPixelWidthHeightRatio = 1.0f / f;
            }
        } else {
            this.currentUnappliedRotationDegrees = this.pendingRotationDegrees;
        }
        mediaCodec.setVideoScalingMode(this.scalingMode);
    }

    private void notifyFrameMetadataListener(long j, long j2, Format format) {
        VideoFrameMetadataListener videoFrameMetadataListener = this.frameMetadataListener;
        if (videoFrameMetadataListener != null) {
            videoFrameMetadataListener.onVideoFrameAboutToBeRendered(j, j2, format);
        }
    }

    /* access modifiers changed from: protected */
    public void onProcessedTunneledBuffer(long j) {
        Format updateOutputFormatForTime = updateOutputFormatForTime(j);
        if (updateOutputFormatForTime != null) {
            processOutputFormat(getCodec(), updateOutputFormatForTime.width, updateOutputFormatForTime.height);
        }
        maybeNotifyVideoSizeChanged();
        maybeNotifyRenderedFirstFrame();
        onProcessedOutputBuffer(j);
    }

    /* access modifiers changed from: protected */
    public void onProcessedOutputBuffer(long j) {
        this.buffersInCodecCount--;
        while (true) {
            int i = this.pendingOutputStreamOffsetCount;
            if (i != 0 && j >= this.pendingOutputStreamSwitchTimesUs[0]) {
                long[] jArr = this.pendingOutputStreamOffsetsUs;
                this.outputStreamOffsetUs = jArr[0];
                int i2 = i - 1;
                this.pendingOutputStreamOffsetCount = i2;
                System.arraycopy(jArr, 1, jArr, 0, i2);
                long[] jArr2 = this.pendingOutputStreamSwitchTimesUs;
                System.arraycopy(jArr2, 1, jArr2, 0, this.pendingOutputStreamOffsetCount);
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean shouldDropOutputBuffer(long j, long j2) {
        return isBufferLate(j);
    }

    /* access modifiers changed from: protected */
    public boolean shouldDropBuffersToKeyframe(long j, long j2) {
        return isBufferVeryLate(j);
    }

    /* access modifiers changed from: protected */
    public boolean shouldForceRenderOutputBuffer(long j, long j2) {
        return isBufferLate(j) && j2 > 100000;
    }

    /* access modifiers changed from: protected */
    public void skipOutputBuffer(MediaCodec mediaCodec, int i, long j) {
        TraceUtil.beginSection("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        TraceUtil.endSection();
        this.decoderCounters.skippedOutputBufferCount++;
    }

    /* access modifiers changed from: protected */
    public void dropOutputBuffer(MediaCodec mediaCodec, int i, long j) {
        TraceUtil.beginSection("dropVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        TraceUtil.endSection();
        updateDroppedBufferCounters(1);
    }

    /* access modifiers changed from: protected */
    public boolean maybeDropBuffersToKeyframe(MediaCodec mediaCodec, int i, long j, long j2) throws ExoPlaybackException {
        int skipSource = skipSource(j2);
        if (skipSource == 0) {
            return false;
        }
        this.decoderCounters.droppedToKeyframeCount++;
        updateDroppedBufferCounters(this.buffersInCodecCount + skipSource);
        flushOrReinitializeCodec();
        return true;
    }

    /* access modifiers changed from: protected */
    public void updateDroppedBufferCounters(int i) {
        DecoderCounters decoderCounters = this.decoderCounters;
        decoderCounters.droppedBufferCount += i;
        this.droppedFrames += i;
        int i2 = this.consecutiveDroppedFrameCount + i;
        this.consecutiveDroppedFrameCount = i2;
        decoderCounters.maxConsecutiveDroppedBufferCount = Math.max(i2, decoderCounters.maxConsecutiveDroppedBufferCount);
        int i3 = this.maxDroppedFramesToNotify;
        if (i3 > 0 && this.droppedFrames >= i3) {
            maybeNotifyDroppedFrames();
        }
    }

    /* access modifiers changed from: protected */
    public void renderOutputBuffer(MediaCodec mediaCodec, int i, long j) {
        maybeNotifyVideoSizeChanged();
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        TraceUtil.endSection();
        this.lastRenderTimeUs = SystemClock.elapsedRealtime() * 1000;
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        maybeNotifyRenderedFirstFrame();
    }

    /* access modifiers changed from: protected */
    @TargetApi(21)
    public void renderOutputBufferV21(MediaCodec mediaCodec, int i, long j, long j2) {
        maybeNotifyVideoSizeChanged();
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j2);
        TraceUtil.endSection();
        this.lastRenderTimeUs = SystemClock.elapsedRealtime() * 1000;
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        maybeNotifyRenderedFirstFrame();
    }

    private boolean shouldUseDummySurface(MediaCodecInfo mediaCodecInfo) {
        return Util.SDK_INT >= 23 && !this.tunneling && !codecNeedsSetOutputSurfaceWorkaround(mediaCodecInfo.name) && (!mediaCodecInfo.secure || DummySurface.isSecureSupported(this.context));
    }

    private void setJoiningDeadlineMs() {
        this.joiningDeadlineMs = this.allowedJoiningTimeMs > 0 ? SystemClock.elapsedRealtime() + this.allowedJoiningTimeMs : -9223372036854775807L;
    }

    private void clearRenderedFirstFrame() {
        MediaCodec codec;
        this.renderedFirstFrame = false;
        if (Util.SDK_INT >= 23 && this.tunneling && (codec = getCodec()) != null) {
            this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListenerV23(codec);
        }
    }

    /* access modifiers changed from: package-private */
    public void maybeNotifyRenderedFirstFrame() {
        if (!this.renderedFirstFrame) {
            this.renderedFirstFrame = true;
            this.eventDispatcher.renderedFirstFrame(this.surface);
        }
    }

    private void maybeRenotifyRenderedFirstFrame() {
        if (this.renderedFirstFrame) {
            this.eventDispatcher.renderedFirstFrame(this.surface);
        }
    }

    private void clearReportedVideoSize() {
        this.reportedWidth = -1;
        this.reportedHeight = -1;
        this.reportedPixelWidthHeightRatio = -1.0f;
        this.reportedUnappliedRotationDegrees = -1;
    }

    private void maybeNotifyVideoSizeChanged() {
        int i = this.currentWidth;
        if (i != -1 || this.currentHeight != -1) {
            if (this.reportedWidth != i || this.reportedHeight != this.currentHeight || this.reportedUnappliedRotationDegrees != this.currentUnappliedRotationDegrees || this.reportedPixelWidthHeightRatio != this.currentPixelWidthHeightRatio) {
                this.eventDispatcher.videoSizeChanged(i, this.currentHeight, this.currentUnappliedRotationDegrees, this.currentPixelWidthHeightRatio);
                this.reportedWidth = this.currentWidth;
                this.reportedHeight = this.currentHeight;
                this.reportedUnappliedRotationDegrees = this.currentUnappliedRotationDegrees;
                this.reportedPixelWidthHeightRatio = this.currentPixelWidthHeightRatio;
            }
        }
    }

    private void maybeRenotifyVideoSizeChanged() {
        int i = this.reportedWidth;
        if (i != -1 || this.reportedHeight != -1) {
            this.eventDispatcher.videoSizeChanged(i, this.reportedHeight, this.reportedUnappliedRotationDegrees, this.reportedPixelWidthHeightRatio);
        }
    }

    private void maybeNotifyDroppedFrames() {
        if (this.droppedFrames > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.eventDispatcher.droppedFrames(this.droppedFrames, elapsedRealtime - this.droppedFrameAccumulationStartTimeMs);
            this.droppedFrames = 0;
            this.droppedFrameAccumulationStartTimeMs = elapsedRealtime;
        }
    }

    @TargetApi(23)
    private static void setOutputSurfaceV23(MediaCodec mediaCodec, Surface surface2) {
        mediaCodec.setOutputSurface(surface2);
    }

    @TargetApi(21)
    private static void configureTunnelingV21(MediaFormat mediaFormat, int i) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i);
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"InlinedApi"})
    public MediaFormat getMediaFormat(Format format, CodecMaxValues codecMaxValues2, float f, boolean z, int i) {
        Pair<Integer, Integer> codecProfileAndLevel;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", format.sampleMimeType);
        mediaFormat.setInteger("width", format.width);
        mediaFormat.setInteger("height", format.height);
        MediaFormatUtil.setCsdBuffers(mediaFormat, format.initializationData);
        MediaFormatUtil.maybeSetFloat(mediaFormat, "frame-rate", format.frameRate);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "rotation-degrees", format.rotationDegrees);
        MediaFormatUtil.maybeSetColorInfo(mediaFormat, format.colorInfo);
        if ("video/dolby-vision".equals(format.sampleMimeType) && (codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format.codecs)) != null) {
            MediaFormatUtil.maybeSetInteger(mediaFormat, "profile", ((Integer) codecProfileAndLevel.first).intValue());
        }
        mediaFormat.setInteger("max-width", codecMaxValues2.width);
        mediaFormat.setInteger("max-height", codecMaxValues2.height);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "max-input-size", codecMaxValues2.inputSize);
        if (Util.SDK_INT >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f != -1.0f) {
                mediaFormat.setFloat("operating-rate", f);
            }
        }
        if (z) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i != 0) {
            configureTunnelingV21(mediaFormat, i);
        }
        return mediaFormat;
    }

    /* access modifiers changed from: protected */
    public CodecMaxValues getCodecMaxValues(MediaCodecInfo mediaCodecInfo, Format format, Format[] formatArr) throws MediaCodecUtil.DecoderQueryException {
        int codecMaxInputSize;
        int i = format.width;
        int i2 = format.height;
        int maxInputSize = getMaxInputSize(mediaCodecInfo, format);
        if (formatArr.length == 1) {
            if (!(maxInputSize == -1 || (codecMaxInputSize = getCodecMaxInputSize(mediaCodecInfo, format.sampleMimeType, format.width, format.height)) == -1)) {
                maxInputSize = Math.min((int) (((float) maxInputSize) * 1.5f), codecMaxInputSize);
            }
            return new CodecMaxValues(i, i2, maxInputSize);
        }
        boolean z = false;
        for (Format format2 : formatArr) {
            if (mediaCodecInfo.isSeamlessAdaptationSupported(format, format2, false)) {
                int i3 = format2.width;
                z |= i3 == -1 || format2.height == -1;
                i = Math.max(i, i3);
                i2 = Math.max(i2, format2.height);
                maxInputSize = Math.max(maxInputSize, getMaxInputSize(mediaCodecInfo, format2));
            }
        }
        if (z) {
            StringBuilder sb = new StringBuilder(66);
            sb.append("Resolutions unknown. Codec max resolution: ");
            sb.append(i);
            sb.append("x");
            sb.append(i2);
            Log.m16w("MediaCodecVideoRenderer", sb.toString());
            Point codecMaxSize = getCodecMaxSize(mediaCodecInfo, format);
            if (codecMaxSize != null) {
                i = Math.max(i, codecMaxSize.x);
                i2 = Math.max(i2, codecMaxSize.y);
                maxInputSize = Math.max(maxInputSize, getCodecMaxInputSize(mediaCodecInfo, format.sampleMimeType, i, i2));
                StringBuilder sb2 = new StringBuilder(57);
                sb2.append("Codec max resolution adjusted to: ");
                sb2.append(i);
                sb2.append("x");
                sb2.append(i2);
                Log.m16w("MediaCodecVideoRenderer", sb2.toString());
            }
        }
        return new CodecMaxValues(i, i2, maxInputSize);
    }

    private static Point getCodecMaxSize(MediaCodecInfo mediaCodecInfo, Format format) throws MediaCodecUtil.DecoderQueryException {
        int i = format.height;
        int i2 = format.width;
        boolean z = i > i2;
        int i3 = z ? i : i2;
        if (z) {
            i = i2;
        }
        float f = ((float) i) / ((float) i3);
        for (int i4 : STANDARD_LONG_EDGE_VIDEO_PX) {
            int i5 = (int) (((float) i4) * f);
            if (i4 <= i3 || i5 <= i) {
                break;
            }
            if (Util.SDK_INT >= 21) {
                int i6 = z ? i5 : i4;
                if (!z) {
                    i4 = i5;
                }
                Point alignVideoSizeV21 = mediaCodecInfo.alignVideoSizeV21(i6, i4);
                if (mediaCodecInfo.isVideoSizeAndRateSupportedV21(alignVideoSizeV21.x, alignVideoSizeV21.y, (double) format.frameRate)) {
                    return alignVideoSizeV21;
                }
            } else {
                int ceilDivide = Util.ceilDivide(i4, 16) * 16;
                int ceilDivide2 = Util.ceilDivide(i5, 16) * 16;
                if (ceilDivide * ceilDivide2 <= MediaCodecUtil.maxH264DecodableFrameSize()) {
                    int i7 = z ? ceilDivide2 : ceilDivide;
                    if (!z) {
                        ceilDivide = ceilDivide2;
                    }
                    return new Point(i7, ceilDivide);
                }
            }
        }
        return null;
    }

    private static int getMaxInputSize(MediaCodecInfo mediaCodecInfo, Format format) {
        if (format.maxInputSize == -1) {
            return getCodecMaxInputSize(mediaCodecInfo, format.sampleMimeType, format.width, format.height);
        }
        int size = format.initializationData.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += format.initializationData.get(i2).length;
        }
        return format.maxInputSize + i;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int getCodecMaxInputSize(androidx.media2.exoplayer.external.mediacodec.MediaCodecInfo r5, java.lang.String r6, int r7, int r8) {
        /*
            r0 = -1
            if (r7 == r0) goto L_0x00a2
            if (r8 != r0) goto L_0x0007
            goto L_0x00a2
        L_0x0007:
            r6.hashCode()
            int r1 = r6.hashCode()
            r2 = 4
            r3 = 3
            r4 = 2
            switch(r1) {
                case -1664118616: goto L_0x004d;
                case -1662541442: goto L_0x0042;
                case 1187890754: goto L_0x0037;
                case 1331836730: goto L_0x002c;
                case 1599127256: goto L_0x0021;
                case 1599127257: goto L_0x0016;
                default: goto L_0x0014;
            }
        L_0x0014:
            r6 = -1
            goto L_0x0057
        L_0x0016:
            java.lang.String r1 = "video/x-vnd.on2.vp9"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x001f
            goto L_0x0014
        L_0x001f:
            r6 = 5
            goto L_0x0057
        L_0x0021:
            java.lang.String r1 = "video/x-vnd.on2.vp8"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x002a
            goto L_0x0014
        L_0x002a:
            r6 = 4
            goto L_0x0057
        L_0x002c:
            java.lang.String r1 = "video/avc"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0035
            goto L_0x0014
        L_0x0035:
            r6 = 3
            goto L_0x0057
        L_0x0037:
            java.lang.String r1 = "video/mp4v-es"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0040
            goto L_0x0014
        L_0x0040:
            r6 = 2
            goto L_0x0057
        L_0x0042:
            java.lang.String r1 = "video/hevc"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x004b
            goto L_0x0014
        L_0x004b:
            r6 = 1
            goto L_0x0057
        L_0x004d:
            java.lang.String r1 = "video/3gpp"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0056
            goto L_0x0014
        L_0x0056:
            r6 = 0
        L_0x0057:
            switch(r6) {
                case 0: goto L_0x0099;
                case 1: goto L_0x0096;
                case 2: goto L_0x0099;
                case 3: goto L_0x005b;
                case 4: goto L_0x0099;
                case 5: goto L_0x0096;
                default: goto L_0x005a;
            }
        L_0x005a:
            return r0
        L_0x005b:
            java.lang.String r6 = androidx.media2.exoplayer.external.util.Util.MODEL
            java.lang.String r1 = "BRAVIA 4K 2015"
            boolean r1 = r1.equals(r6)
            if (r1 != 0) goto L_0x0095
            java.lang.String r1 = androidx.media2.exoplayer.external.util.Util.MANUFACTURER
            java.lang.String r2 = "Amazon"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0084
            java.lang.String r1 = "KFSOWI"
            boolean r1 = r1.equals(r6)
            if (r1 != 0) goto L_0x0095
            java.lang.String r1 = "AFTS"
            boolean r6 = r1.equals(r6)
            if (r6 == 0) goto L_0x0084
            boolean r5 = r5.secure
            if (r5 == 0) goto L_0x0084
            goto L_0x0095
        L_0x0084:
            r5 = 16
            int r6 = androidx.media2.exoplayer.external.util.Util.ceilDivide(r7, r5)
            int r7 = androidx.media2.exoplayer.external.util.Util.ceilDivide(r8, r5)
            int r6 = r6 * r7
            int r6 = r6 * 16
            int r7 = r6 * 16
            goto L_0x009b
        L_0x0095:
            return r0
        L_0x0096:
            int r7 = r7 * r8
            goto L_0x009c
        L_0x0099:
            int r7 = r7 * r8
        L_0x009b:
            r2 = 2
        L_0x009c:
            int r7 = r7 * 3
            int r2 = r2 * 2
            int r7 = r7 / r2
            return r7
        L_0x00a2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media2.exoplayer.external.video.MediaCodecVideoRenderer.getCodecMaxInputSize(androidx.media2.exoplayer.external.mediacodec.MediaCodecInfo, java.lang.String, int, int):int");
    }

    private static boolean deviceNeedsNoPostProcessWorkaround() {
        return "NVIDIA".equals(Util.MANUFACTURER);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:392:0x05fb, code lost:
        r2 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:393:0x05fc, code lost:
        switch(r2) {
            case 0: goto L_0x0600;
            case 1: goto L_0x0600;
            case 2: goto L_0x0600;
            case 3: goto L_0x0600;
            case 4: goto L_0x0600;
            case 5: goto L_0x0600;
            case 6: goto L_0x0600;
            case 7: goto L_0x0600;
            case 8: goto L_0x0600;
            case 9: goto L_0x0600;
            case 10: goto L_0x0600;
            case 11: goto L_0x0600;
            case 12: goto L_0x0600;
            case 13: goto L_0x0600;
            case 14: goto L_0x0600;
            case 15: goto L_0x0600;
            case 16: goto L_0x0600;
            case 17: goto L_0x0600;
            case 18: goto L_0x0600;
            case 19: goto L_0x0600;
            case 20: goto L_0x0600;
            case 21: goto L_0x0600;
            case 22: goto L_0x0600;
            case 23: goto L_0x0600;
            case 24: goto L_0x0600;
            case 25: goto L_0x0600;
            case 26: goto L_0x0600;
            case 27: goto L_0x0600;
            case 28: goto L_0x0600;
            case 29: goto L_0x0600;
            case 30: goto L_0x0600;
            case 31: goto L_0x0600;
            case 32: goto L_0x0600;
            case 33: goto L_0x0600;
            case 34: goto L_0x0600;
            case 35: goto L_0x0600;
            case 36: goto L_0x0600;
            case 37: goto L_0x0600;
            case 38: goto L_0x0600;
            case 39: goto L_0x0600;
            case 40: goto L_0x0600;
            case 41: goto L_0x0600;
            case 42: goto L_0x0600;
            case 43: goto L_0x0600;
            case 44: goto L_0x0600;
            case 45: goto L_0x0600;
            case 46: goto L_0x0600;
            case 47: goto L_0x0600;
            case 48: goto L_0x0600;
            case 49: goto L_0x0600;
            case 50: goto L_0x0600;
            case 51: goto L_0x0600;
            case 52: goto L_0x0600;
            case 53: goto L_0x0600;
            case 54: goto L_0x0600;
            case 55: goto L_0x0600;
            case 56: goto L_0x0600;
            case 57: goto L_0x0600;
            case 58: goto L_0x0600;
            case 59: goto L_0x0600;
            case 60: goto L_0x0600;
            case 61: goto L_0x0600;
            case 62: goto L_0x0600;
            case 63: goto L_0x0600;
            case 64: goto L_0x0600;
            case 65: goto L_0x0600;
            case 66: goto L_0x0600;
            case 67: goto L_0x0600;
            case 68: goto L_0x0600;
            case 69: goto L_0x0600;
            case 70: goto L_0x0600;
            case 71: goto L_0x0600;
            case 72: goto L_0x0600;
            case 73: goto L_0x0600;
            case 74: goto L_0x0600;
            case 75: goto L_0x0600;
            case 76: goto L_0x0600;
            case 77: goto L_0x0600;
            case 78: goto L_0x0600;
            case 79: goto L_0x0600;
            case 80: goto L_0x0600;
            case 81: goto L_0x0600;
            case 82: goto L_0x0600;
            case 83: goto L_0x0600;
            case 84: goto L_0x0600;
            case 85: goto L_0x0600;
            case 86: goto L_0x0600;
            case 87: goto L_0x0600;
            case 88: goto L_0x0600;
            case 89: goto L_0x0600;
            case 90: goto L_0x0600;
            case 91: goto L_0x0600;
            case 92: goto L_0x0600;
            case 93: goto L_0x0600;
            case 94: goto L_0x0600;
            case 95: goto L_0x0600;
            case 96: goto L_0x0600;
            case 97: goto L_0x0600;
            case 98: goto L_0x0600;
            case 99: goto L_0x0600;
            case 100: goto L_0x0600;
            case 101: goto L_0x0600;
            case 102: goto L_0x0600;
            case 103: goto L_0x0600;
            case 104: goto L_0x0600;
            case 105: goto L_0x0600;
            case 106: goto L_0x0600;
            case 107: goto L_0x0600;
            case 108: goto L_0x0600;
            case 109: goto L_0x0600;
            case 110: goto L_0x0600;
            case 111: goto L_0x0600;
            case 112: goto L_0x0600;
            case 113: goto L_0x0600;
            case 114: goto L_0x0600;
            case 115: goto L_0x0600;
            case 116: goto L_0x0600;
            case 117: goto L_0x0600;
            case 118: goto L_0x0600;
            case 119: goto L_0x0600;
            case 120: goto L_0x0600;
            case 121: goto L_0x0600;
            case 122: goto L_0x0600;
            case 123: goto L_0x0600;
            default: goto L_0x05ff;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:395:0x0600, code lost:
        deviceNeedsSetOutputSurfaceWorkaround = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:396:0x0602, code lost:
        r1 = androidx.media2.exoplayer.external.util.Util.MODEL;
        r2 = r1.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:397:0x060b, code lost:
        if (r2 == 2006354) goto L_0x061d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:399:0x0610, code lost:
        if (r2 == 2006367) goto L_0x0613;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:402:0x0619, code lost:
        if (r1.equals("AFTN") == false) goto L_0x0626;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:403:0x061b, code lost:
        r0 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:405:0x0623, code lost:
        if (r1.equals("AFTA") == false) goto L_0x0626;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:407:0x0626, code lost:
        r0 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:408:0x0627, code lost:
        if (r0 == 0) goto L_0x062c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:409:0x0629, code lost:
        if (r0 == 1) goto L_0x062c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:411:0x062c, code lost:
        deviceNeedsSetOutputSurfaceWorkaround = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean codecNeedsSetOutputSurfaceWorkaround(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "OMX.google"
            boolean r7 = r7.startsWith(r0)
            r0 = 0
            if (r7 == 0) goto L_0x000a
            return r0
        L_0x000a:
            java.lang.Class<androidx.media2.exoplayer.external.video.MediaCodecVideoRenderer> r7 = androidx.media2.exoplayer.external.video.MediaCodecVideoRenderer.class
            monitor-enter(r7)
            boolean r1 = evaluatedDeviceNeedsSetOutputSurfaceWorkaround     // Catch:{ all -> 0x0634 }
            if (r1 != 0) goto L_0x0630
            int r1 = androidx.media2.exoplayer.external.util.Util.SDK_INT     // Catch:{ all -> 0x0634 }
            r2 = 27
            r3 = 1
            if (r1 > r2) goto L_0x002e
            java.lang.String r4 = "dangal"
            java.lang.String r5 = androidx.media2.exoplayer.external.util.Util.DEVICE     // Catch:{ all -> 0x0634 }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x0634 }
            if (r4 != 0) goto L_0x002a
            java.lang.String r4 = "HWEML"
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x0634 }
            if (r4 == 0) goto L_0x002e
        L_0x002a:
            deviceNeedsSetOutputSurfaceWorkaround = r3     // Catch:{ all -> 0x0634 }
            goto L_0x062e
        L_0x002e:
            if (r1 < r2) goto L_0x0032
            goto L_0x062e
        L_0x0032:
            java.lang.String r1 = androidx.media2.exoplayer.external.util.Util.DEVICE     // Catch:{ all -> 0x0634 }
            int r4 = r1.hashCode()     // Catch:{ all -> 0x0634 }
            r5 = -1
            switch(r4) {
                case -2144781245: goto L_0x05f0;
                case -2144781185: goto L_0x05e5;
                case -2144781160: goto L_0x05da;
                case -2097309513: goto L_0x05cf;
                case -2022874474: goto L_0x05c4;
                case -1978993182: goto L_0x05b9;
                case -1978990237: goto L_0x05ae;
                case -1936688988: goto L_0x05a3;
                case -1936688066: goto L_0x0598;
                case -1936688065: goto L_0x058c;
                case -1931988508: goto L_0x0580;
                case -1696512866: goto L_0x0574;
                case -1680025915: goto L_0x0568;
                case -1615810839: goto L_0x055c;
                case -1554255044: goto L_0x0550;
                case -1481772737: goto L_0x0544;
                case -1481772730: goto L_0x0538;
                case -1481772729: goto L_0x052c;
                case -1320080169: goto L_0x0520;
                case -1217592143: goto L_0x0514;
                case -1180384755: goto L_0x0508;
                case -1139198265: goto L_0x04fc;
                case -1052835013: goto L_0x04f0;
                case -993250464: goto L_0x04e5;
                case -965403638: goto L_0x04d9;
                case -958336948: goto L_0x04cd;
                case -879245230: goto L_0x04c1;
                case -842500323: goto L_0x04b5;
                case -821392978: goto L_0x04aa;
                case -797483286: goto L_0x049e;
                case -794946968: goto L_0x0492;
                case -788334647: goto L_0x0486;
                case -782144577: goto L_0x047a;
                case -575125681: goto L_0x046e;
                case -521118391: goto L_0x0462;
                case -430914369: goto L_0x0456;
                case -290434366: goto L_0x044a;
                case -282781963: goto L_0x043e;
                case -277133239: goto L_0x0432;
                case -173639913: goto L_0x0426;
                case -56598463: goto L_0x041a;
                case 2126: goto L_0x040e;
                case 2564: goto L_0x0402;
                case 2715: goto L_0x03f6;
                case 2719: goto L_0x03ea;
                case 3483: goto L_0x03de;
                case 73405: goto L_0x03d2;
                case 75739: goto L_0x03c6;
                case 76779: goto L_0x03ba;
                case 78669: goto L_0x03ae;
                case 79305: goto L_0x03a2;
                case 80618: goto L_0x0396;
                case 88274: goto L_0x038a;
                case 98846: goto L_0x037e;
                case 98848: goto L_0x0372;
                case 99329: goto L_0x0366;
                case 101481: goto L_0x035a;
                case 1513190: goto L_0x034f;
                case 1514184: goto L_0x0344;
                case 1514185: goto L_0x0339;
                case 2436959: goto L_0x032d;
                case 2463773: goto L_0x0321;
                case 2464648: goto L_0x0315;
                case 2689555: goto L_0x0309;
                case 3154429: goto L_0x02fd;
                case 3284551: goto L_0x02f1;
                case 3351335: goto L_0x02e5;
                case 3386211: goto L_0x02d9;
                case 41325051: goto L_0x02cd;
                case 55178625: goto L_0x02c1;
                case 61542055: goto L_0x02b6;
                case 65355429: goto L_0x02aa;
                case 66214468: goto L_0x029e;
                case 66214470: goto L_0x0292;
                case 66214473: goto L_0x0286;
                case 66215429: goto L_0x027a;
                case 66215431: goto L_0x026e;
                case 66215433: goto L_0x0262;
                case 66216390: goto L_0x0256;
                case 76402249: goto L_0x024a;
                case 76404105: goto L_0x023e;
                case 76404911: goto L_0x0232;
                case 80963634: goto L_0x0226;
                case 82882791: goto L_0x021a;
                case 98715550: goto L_0x020e;
                case 102844228: goto L_0x0202;
                case 165221241: goto L_0x01f7;
                case 182191441: goto L_0x01eb;
                case 245388979: goto L_0x01df;
                case 287431619: goto L_0x01d3;
                case 307593612: goto L_0x01c7;
                case 308517133: goto L_0x01bb;
                case 316215098: goto L_0x01af;
                case 316215116: goto L_0x01a3;
                case 316246811: goto L_0x0197;
                case 316246818: goto L_0x018b;
                case 407160593: goto L_0x017f;
                case 507412548: goto L_0x0173;
                case 793982701: goto L_0x0167;
                case 794038622: goto L_0x015b;
                case 794040393: goto L_0x014f;
                case 835649806: goto L_0x0143;
                case 917340916: goto L_0x0138;
                case 958008161: goto L_0x012c;
                case 1060579533: goto L_0x0120;
                case 1150207623: goto L_0x0114;
                case 1176899427: goto L_0x0108;
                case 1280332038: goto L_0x00fc;
                case 1306947716: goto L_0x00f0;
                case 1349174697: goto L_0x00e4;
                case 1522194893: goto L_0x00d8;
                case 1691543273: goto L_0x00cc;
                case 1709443163: goto L_0x00c0;
                case 1865889110: goto L_0x00b4;
                case 1906253259: goto L_0x00a8;
                case 1977196784: goto L_0x009c;
                case 2006372676: goto L_0x0090;
                case 2029784656: goto L_0x0084;
                case 2030379515: goto L_0x0078;
                case 2033393791: goto L_0x006c;
                case 2047190025: goto L_0x0060;
                case 2047252157: goto L_0x0056;
                case 2048319463: goto L_0x004a;
                case 2048855701: goto L_0x003e;
                default: goto L_0x003c;
            }     // Catch:{ all -> 0x0634 }
        L_0x003c:
            goto L_0x05fb
        L_0x003e:
            java.lang.String r2 = "HWWAS-H"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 54
            goto L_0x05fc
        L_0x004a:
            java.lang.String r2 = "HWVNS-H"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 53
            goto L_0x05fc
        L_0x0056:
            java.lang.String r4 = "ELUGA_Prim"
            boolean r1 = r1.equals(r4)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            goto L_0x05fc
        L_0x0060:
            java.lang.String r2 = "ELUGA_Note"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 26
            goto L_0x05fc
        L_0x006c:
            java.lang.String r2 = "ASUS_X00AD_2"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 11
            goto L_0x05fc
        L_0x0078:
            java.lang.String r2 = "HWCAM-H"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 52
            goto L_0x05fc
        L_0x0084:
            java.lang.String r2 = "HWBLN-H"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 51
            goto L_0x05fc
        L_0x0090:
            java.lang.String r2 = "BRAVIA_ATV3_4K"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 15
            goto L_0x05fc
        L_0x009c:
            java.lang.String r2 = "Infinix-X572"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 57
            goto L_0x05fc
        L_0x00a8:
            java.lang.String r2 = "PB2-670M"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 85
            goto L_0x05fc
        L_0x00b4:
            java.lang.String r2 = "santoni"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 101(0x65, float:1.42E-43)
            goto L_0x05fc
        L_0x00c0:
            java.lang.String r2 = "iball8735_9806"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 56
            goto L_0x05fc
        L_0x00cc:
            java.lang.String r2 = "CPH1609"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 19
            goto L_0x05fc
        L_0x00d8:
            java.lang.String r2 = "woods_f"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 117(0x75, float:1.64E-43)
            goto L_0x05fc
        L_0x00e4:
            java.lang.String r2 = "htc_e56ml_dtul"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 49
            goto L_0x05fc
        L_0x00f0:
            java.lang.String r2 = "EverStar_S"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 29
            goto L_0x05fc
        L_0x00fc:
            java.lang.String r2 = "hwALE-H"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 50
            goto L_0x05fc
        L_0x0108:
            java.lang.String r2 = "itel_S41"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 59
            goto L_0x05fc
        L_0x0114:
            java.lang.String r2 = "LS-5017"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 65
            goto L_0x05fc
        L_0x0120:
            java.lang.String r2 = "panell_d"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 81
            goto L_0x05fc
        L_0x012c:
            java.lang.String r2 = "j2xlteins"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 60
            goto L_0x05fc
        L_0x0138:
            java.lang.String r2 = "A7000plus"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 7
            goto L_0x05fc
        L_0x0143:
            java.lang.String r2 = "manning"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 67
            goto L_0x05fc
        L_0x014f:
            java.lang.String r2 = "GIONEE_WBL7519"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 47
            goto L_0x05fc
        L_0x015b:
            java.lang.String r2 = "GIONEE_WBL7365"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 46
            goto L_0x05fc
        L_0x0167:
            java.lang.String r2 = "GIONEE_WBL5708"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 45
            goto L_0x05fc
        L_0x0173:
            java.lang.String r2 = "QM16XE_U"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 99
            goto L_0x05fc
        L_0x017f:
            java.lang.String r2 = "Pixi5-10_4G"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 91
            goto L_0x05fc
        L_0x018b:
            java.lang.String r2 = "TB3-850M"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 109(0x6d, float:1.53E-43)
            goto L_0x05fc
        L_0x0197:
            java.lang.String r2 = "TB3-850F"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 108(0x6c, float:1.51E-43)
            goto L_0x05fc
        L_0x01a3:
            java.lang.String r2 = "TB3-730X"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 107(0x6b, float:1.5E-43)
            goto L_0x05fc
        L_0x01af:
            java.lang.String r2 = "TB3-730F"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 106(0x6a, float:1.49E-43)
            goto L_0x05fc
        L_0x01bb:
            java.lang.String r2 = "A7020a48"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 9
            goto L_0x05fc
        L_0x01c7:
            java.lang.String r2 = "A7010a48"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 8
            goto L_0x05fc
        L_0x01d3:
            java.lang.String r2 = "griffin"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 48
            goto L_0x05fc
        L_0x01df:
            java.lang.String r2 = "marino_f"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 68
            goto L_0x05fc
        L_0x01eb:
            java.lang.String r2 = "CPY83_I00"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 20
            goto L_0x05fc
        L_0x01f7:
            java.lang.String r2 = "A2016a40"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 5
            goto L_0x05fc
        L_0x0202:
            java.lang.String r2 = "le_x6"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 64
            goto L_0x05fc
        L_0x020e:
            java.lang.String r2 = "i9031"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 55
            goto L_0x05fc
        L_0x021a:
            java.lang.String r2 = "X3_HK"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 119(0x77, float:1.67E-43)
            goto L_0x05fc
        L_0x0226:
            java.lang.String r2 = "V23GB"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 112(0x70, float:1.57E-43)
            goto L_0x05fc
        L_0x0232:
            java.lang.String r2 = "Q4310"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 97
            goto L_0x05fc
        L_0x023e:
            java.lang.String r2 = "Q4260"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 95
            goto L_0x05fc
        L_0x024a:
            java.lang.String r2 = "PRO7S"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 93
            goto L_0x05fc
        L_0x0256:
            java.lang.String r2 = "F3311"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 36
            goto L_0x05fc
        L_0x0262:
            java.lang.String r2 = "F3215"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 35
            goto L_0x05fc
        L_0x026e:
            java.lang.String r2 = "F3213"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 34
            goto L_0x05fc
        L_0x027a:
            java.lang.String r2 = "F3211"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 33
            goto L_0x05fc
        L_0x0286:
            java.lang.String r2 = "F3116"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 32
            goto L_0x05fc
        L_0x0292:
            java.lang.String r2 = "F3113"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 31
            goto L_0x05fc
        L_0x029e:
            java.lang.String r2 = "F3111"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 30
            goto L_0x05fc
        L_0x02aa:
            java.lang.String r2 = "E5643"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 24
            goto L_0x05fc
        L_0x02b6:
            java.lang.String r2 = "A1601"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 4
            goto L_0x05fc
        L_0x02c1:
            java.lang.String r2 = "Aura_Note_2"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 12
            goto L_0x05fc
        L_0x02cd:
            java.lang.String r2 = "MEIZU_M5"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 69
            goto L_0x05fc
        L_0x02d9:
            java.lang.String r2 = "p212"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 78
            goto L_0x05fc
        L_0x02e5:
            java.lang.String r2 = "mido"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 71
            goto L_0x05fc
        L_0x02f1:
            java.lang.String r2 = "kate"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 63
            goto L_0x05fc
        L_0x02fd:
            java.lang.String r2 = "fugu"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 38
            goto L_0x05fc
        L_0x0309:
            java.lang.String r2 = "XE2X"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 120(0x78, float:1.68E-43)
            goto L_0x05fc
        L_0x0315:
            java.lang.String r2 = "Q427"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 96
            goto L_0x05fc
        L_0x0321:
            java.lang.String r2 = "Q350"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 94
            goto L_0x05fc
        L_0x032d:
            java.lang.String r2 = "P681"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 79
            goto L_0x05fc
        L_0x0339:
            java.lang.String r2 = "1714"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 2
            goto L_0x05fc
        L_0x0344:
            java.lang.String r2 = "1713"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 1
            goto L_0x05fc
        L_0x034f:
            java.lang.String r2 = "1601"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 0
            goto L_0x05fc
        L_0x035a:
            java.lang.String r2 = "flo"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 37
            goto L_0x05fc
        L_0x0366:
            java.lang.String r2 = "deb"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 23
            goto L_0x05fc
        L_0x0372:
            java.lang.String r2 = "cv3"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 22
            goto L_0x05fc
        L_0x037e:
            java.lang.String r2 = "cv1"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 21
            goto L_0x05fc
        L_0x038a:
            java.lang.String r2 = "Z80"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 123(0x7b, float:1.72E-43)
            goto L_0x05fc
        L_0x0396:
            java.lang.String r2 = "QX1"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 100
            goto L_0x05fc
        L_0x03a2:
            java.lang.String r2 = "PLE"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 92
            goto L_0x05fc
        L_0x03ae:
            java.lang.String r2 = "P85"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 80
            goto L_0x05fc
        L_0x03ba:
            java.lang.String r2 = "MX6"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 72
            goto L_0x05fc
        L_0x03c6:
            java.lang.String r2 = "M5c"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 66
            goto L_0x05fc
        L_0x03d2:
            java.lang.String r2 = "JGZ"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 61
            goto L_0x05fc
        L_0x03de:
            java.lang.String r2 = "mh"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 70
            goto L_0x05fc
        L_0x03ea:
            java.lang.String r2 = "V5"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 113(0x71, float:1.58E-43)
            goto L_0x05fc
        L_0x03f6:
            java.lang.String r2 = "V1"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 111(0x6f, float:1.56E-43)
            goto L_0x05fc
        L_0x0402:
            java.lang.String r2 = "Q5"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 98
            goto L_0x05fc
        L_0x040e:
            java.lang.String r2 = "C1"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 16
            goto L_0x05fc
        L_0x041a:
            java.lang.String r2 = "woods_fn"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 118(0x76, float:1.65E-43)
            goto L_0x05fc
        L_0x0426:
            java.lang.String r2 = "ELUGA_A3_Pro"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 25
            goto L_0x05fc
        L_0x0432:
            java.lang.String r2 = "Z12_PRO"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 122(0x7a, float:1.71E-43)
            goto L_0x05fc
        L_0x043e:
            java.lang.String r2 = "BLACK-1X"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 13
            goto L_0x05fc
        L_0x044a:
            java.lang.String r2 = "taido_row"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 105(0x69, float:1.47E-43)
            goto L_0x05fc
        L_0x0456:
            java.lang.String r2 = "Pixi4-7_3G"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 90
            goto L_0x05fc
        L_0x0462:
            java.lang.String r2 = "GIONEE_GBL7360"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 41
            goto L_0x05fc
        L_0x046e:
            java.lang.String r2 = "GiONEE_CBL7513"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 39
            goto L_0x05fc
        L_0x047a:
            java.lang.String r2 = "OnePlus5T"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 77
            goto L_0x05fc
        L_0x0486:
            java.lang.String r2 = "whyred"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 116(0x74, float:1.63E-43)
            goto L_0x05fc
        L_0x0492:
            java.lang.String r2 = "watson"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 115(0x73, float:1.61E-43)
            goto L_0x05fc
        L_0x049e:
            java.lang.String r2 = "SVP-DTV15"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 103(0x67, float:1.44E-43)
            goto L_0x05fc
        L_0x04aa:
            java.lang.String r2 = "A7000-a"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 6
            goto L_0x05fc
        L_0x04b5:
            java.lang.String r2 = "nicklaus_f"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 74
            goto L_0x05fc
        L_0x04c1:
            java.lang.String r2 = "tcl_eu"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 110(0x6e, float:1.54E-43)
            goto L_0x05fc
        L_0x04cd:
            java.lang.String r2 = "ELUGA_Ray_X"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 28
            goto L_0x05fc
        L_0x04d9:
            java.lang.String r2 = "s905x018"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 104(0x68, float:1.46E-43)
            goto L_0x05fc
        L_0x04e5:
            java.lang.String r2 = "A10-70F"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 3
            goto L_0x05fc
        L_0x04f0:
            java.lang.String r2 = "namath"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 73
            goto L_0x05fc
        L_0x04fc:
            java.lang.String r2 = "Slate_Pro"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 102(0x66, float:1.43E-43)
            goto L_0x05fc
        L_0x0508:
            java.lang.String r2 = "iris60"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 58
            goto L_0x05fc
        L_0x0514:
            java.lang.String r2 = "BRAVIA_ATV2"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 14
            goto L_0x05fc
        L_0x0520:
            java.lang.String r2 = "GiONEE_GBL7319"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 40
            goto L_0x05fc
        L_0x052c:
            java.lang.String r2 = "panell_dt"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 84
            goto L_0x05fc
        L_0x0538:
            java.lang.String r2 = "panell_ds"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 83
            goto L_0x05fc
        L_0x0544:
            java.lang.String r2 = "panell_dl"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 82
            goto L_0x05fc
        L_0x0550:
            java.lang.String r2 = "vernee_M5"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 114(0x72, float:1.6E-43)
            goto L_0x05fc
        L_0x055c:
            java.lang.String r2 = "Phantom6"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 89
            goto L_0x05fc
        L_0x0568:
            java.lang.String r2 = "ComioS1"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 17
            goto L_0x05fc
        L_0x0574:
            java.lang.String r2 = "XT1663"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 121(0x79, float:1.7E-43)
            goto L_0x05fc
        L_0x0580:
            java.lang.String r2 = "AquaPowerM"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 10
            goto L_0x05fc
        L_0x058c:
            java.lang.String r2 = "PGN611"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 88
            goto L_0x05fc
        L_0x0598:
            java.lang.String r2 = "PGN610"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 87
            goto L_0x05fc
        L_0x05a3:
            java.lang.String r2 = "PGN528"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 86
            goto L_0x05fc
        L_0x05ae:
            java.lang.String r2 = "NX573J"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 76
            goto L_0x05fc
        L_0x05b9:
            java.lang.String r2 = "NX541J"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 75
            goto L_0x05fc
        L_0x05c4:
            java.lang.String r2 = "CP8676_I02"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 18
            goto L_0x05fc
        L_0x05cf:
            java.lang.String r2 = "K50a40"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 62
            goto L_0x05fc
        L_0x05da:
            java.lang.String r2 = "GIONEE_SWW1631"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 44
            goto L_0x05fc
        L_0x05e5:
            java.lang.String r2 = "GIONEE_SWW1627"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 43
            goto L_0x05fc
        L_0x05f0:
            java.lang.String r2 = "GIONEE_SWW1609"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x05fb
            r2 = 42
            goto L_0x05fc
        L_0x05fb:
            r2 = -1
        L_0x05fc:
            switch(r2) {
                case 0: goto L_0x0600;
                case 1: goto L_0x0600;
                case 2: goto L_0x0600;
                case 3: goto L_0x0600;
                case 4: goto L_0x0600;
                case 5: goto L_0x0600;
                case 6: goto L_0x0600;
                case 7: goto L_0x0600;
                case 8: goto L_0x0600;
                case 9: goto L_0x0600;
                case 10: goto L_0x0600;
                case 11: goto L_0x0600;
                case 12: goto L_0x0600;
                case 13: goto L_0x0600;
                case 14: goto L_0x0600;
                case 15: goto L_0x0600;
                case 16: goto L_0x0600;
                case 17: goto L_0x0600;
                case 18: goto L_0x0600;
                case 19: goto L_0x0600;
                case 20: goto L_0x0600;
                case 21: goto L_0x0600;
                case 22: goto L_0x0600;
                case 23: goto L_0x0600;
                case 24: goto L_0x0600;
                case 25: goto L_0x0600;
                case 26: goto L_0x0600;
                case 27: goto L_0x0600;
                case 28: goto L_0x0600;
                case 29: goto L_0x0600;
                case 30: goto L_0x0600;
                case 31: goto L_0x0600;
                case 32: goto L_0x0600;
                case 33: goto L_0x0600;
                case 34: goto L_0x0600;
                case 35: goto L_0x0600;
                case 36: goto L_0x0600;
                case 37: goto L_0x0600;
                case 38: goto L_0x0600;
                case 39: goto L_0x0600;
                case 40: goto L_0x0600;
                case 41: goto L_0x0600;
                case 42: goto L_0x0600;
                case 43: goto L_0x0600;
                case 44: goto L_0x0600;
                case 45: goto L_0x0600;
                case 46: goto L_0x0600;
                case 47: goto L_0x0600;
                case 48: goto L_0x0600;
                case 49: goto L_0x0600;
                case 50: goto L_0x0600;
                case 51: goto L_0x0600;
                case 52: goto L_0x0600;
                case 53: goto L_0x0600;
                case 54: goto L_0x0600;
                case 55: goto L_0x0600;
                case 56: goto L_0x0600;
                case 57: goto L_0x0600;
                case 58: goto L_0x0600;
                case 59: goto L_0x0600;
                case 60: goto L_0x0600;
                case 61: goto L_0x0600;
                case 62: goto L_0x0600;
                case 63: goto L_0x0600;
                case 64: goto L_0x0600;
                case 65: goto L_0x0600;
                case 66: goto L_0x0600;
                case 67: goto L_0x0600;
                case 68: goto L_0x0600;
                case 69: goto L_0x0600;
                case 70: goto L_0x0600;
                case 71: goto L_0x0600;
                case 72: goto L_0x0600;
                case 73: goto L_0x0600;
                case 74: goto L_0x0600;
                case 75: goto L_0x0600;
                case 76: goto L_0x0600;
                case 77: goto L_0x0600;
                case 78: goto L_0x0600;
                case 79: goto L_0x0600;
                case 80: goto L_0x0600;
                case 81: goto L_0x0600;
                case 82: goto L_0x0600;
                case 83: goto L_0x0600;
                case 84: goto L_0x0600;
                case 85: goto L_0x0600;
                case 86: goto L_0x0600;
                case 87: goto L_0x0600;
                case 88: goto L_0x0600;
                case 89: goto L_0x0600;
                case 90: goto L_0x0600;
                case 91: goto L_0x0600;
                case 92: goto L_0x0600;
                case 93: goto L_0x0600;
                case 94: goto L_0x0600;
                case 95: goto L_0x0600;
                case 96: goto L_0x0600;
                case 97: goto L_0x0600;
                case 98: goto L_0x0600;
                case 99: goto L_0x0600;
                case 100: goto L_0x0600;
                case 101: goto L_0x0600;
                case 102: goto L_0x0600;
                case 103: goto L_0x0600;
                case 104: goto L_0x0600;
                case 105: goto L_0x0600;
                case 106: goto L_0x0600;
                case 107: goto L_0x0600;
                case 108: goto L_0x0600;
                case 109: goto L_0x0600;
                case 110: goto L_0x0600;
                case 111: goto L_0x0600;
                case 112: goto L_0x0600;
                case 113: goto L_0x0600;
                case 114: goto L_0x0600;
                case 115: goto L_0x0600;
                case 116: goto L_0x0600;
                case 117: goto L_0x0600;
                case 118: goto L_0x0600;
                case 119: goto L_0x0600;
                case 120: goto L_0x0600;
                case 121: goto L_0x0600;
                case 122: goto L_0x0600;
                case 123: goto L_0x0600;
                default: goto L_0x05ff;
            }     // Catch:{ all -> 0x0634 }
        L_0x05ff:
            goto L_0x0602
        L_0x0600:
            deviceNeedsSetOutputSurfaceWorkaround = r3     // Catch:{ all -> 0x0634 }
        L_0x0602:
            java.lang.String r1 = androidx.media2.exoplayer.external.util.Util.MODEL     // Catch:{ all -> 0x0634 }
            int r2 = r1.hashCode()     // Catch:{ all -> 0x0634 }
            r4 = 2006354(0x1e9d52, float:2.811501E-39)
            if (r2 == r4) goto L_0x061d
            r0 = 2006367(0x1e9d5f, float:2.811519E-39)
            if (r2 == r0) goto L_0x0613
            goto L_0x0626
        L_0x0613:
            java.lang.String r0 = "AFTN"
            boolean r0 = r1.equals(r0)     // Catch:{ all -> 0x0634 }
            if (r0 == 0) goto L_0x0626
            r0 = 1
            goto L_0x0627
        L_0x061d:
            java.lang.String r2 = "AFTA"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0634 }
            if (r1 == 0) goto L_0x0626
            goto L_0x0627
        L_0x0626:
            r0 = -1
        L_0x0627:
            if (r0 == 0) goto L_0x062c
            if (r0 == r3) goto L_0x062c
            goto L_0x062e
        L_0x062c:
            deviceNeedsSetOutputSurfaceWorkaround = r3     // Catch:{ all -> 0x0634 }
        L_0x062e:
            evaluatedDeviceNeedsSetOutputSurfaceWorkaround = r3     // Catch:{ all -> 0x0634 }
        L_0x0630:
            monitor-exit(r7)     // Catch:{ all -> 0x0634 }
            boolean r7 = deviceNeedsSetOutputSurfaceWorkaround
            return r7
        L_0x0634:
            r0 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0634 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media2.exoplayer.external.video.MediaCodecVideoRenderer.codecNeedsSetOutputSurfaceWorkaround(java.lang.String):boolean");
    }

    protected static final class CodecMaxValues {
        public final int height;
        public final int inputSize;
        public final int width;

        public CodecMaxValues(int i, int i2, int i3) {
            this.width = i;
            this.height = i2;
            this.inputSize = i3;
        }
    }

    @TargetApi(23)
    private final class OnFrameRenderedListenerV23 implements MediaCodec.OnFrameRenderedListener {
        private OnFrameRenderedListenerV23(MediaCodec mediaCodec) {
            mediaCodec.setOnFrameRenderedListener(this, new Handler());
        }

        public void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
            MediaCodecVideoRenderer mediaCodecVideoRenderer = MediaCodecVideoRenderer.this;
            if (this == mediaCodecVideoRenderer.tunnelingOnFrameRenderedListener) {
                mediaCodecVideoRenderer.onProcessedTunneledBuffer(j);
            }
        }
    }
}
