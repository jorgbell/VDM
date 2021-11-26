package androidx.media2.exoplayer.external.video;

import android.os.Handler;
import android.view.Surface;
import androidx.media2.exoplayer.external.Format;
import androidx.media2.exoplayer.external.decoder.DecoderCounters;
import androidx.media2.exoplayer.external.util.Assertions;

public interface VideoRendererEventListener {
    void onDroppedFrames(int i, long j);

    void onRenderedFirstFrame(Surface surface);

    void onVideoDecoderInitialized(String str, long j, long j2);

    void onVideoDisabled(DecoderCounters decoderCounters);

    void onVideoEnabled(DecoderCounters decoderCounters);

    void onVideoInputFormatChanged(Format format);

    void onVideoSizeChanged(int i, int i2, int i3, float f);

    public static final class EventDispatcher {
        private final Handler handler;
        private final VideoRendererEventListener listener;

        public EventDispatcher(Handler handler2, VideoRendererEventListener videoRendererEventListener) {
            Handler handler3;
            if (videoRendererEventListener != null) {
                Assertions.checkNotNull(handler2);
                handler3 = handler2;
            } else {
                handler3 = null;
            }
            this.handler = handler3;
            this.listener = videoRendererEventListener;
        }

        public void enabled(DecoderCounters decoderCounters) {
            if (this.listener != null) {
                this.handler.post(new VideoRendererEventListener$EventDispatcher$$Lambda$0(this, decoderCounters));
            }
        }

        /* access modifiers changed from: package-private */
        public final /* synthetic */ void lambda$enabled$0$VideoRendererEventListener$EventDispatcher(DecoderCounters decoderCounters) {
            this.listener.onVideoEnabled(decoderCounters);
        }

        public void decoderInitialized(String str, long j, long j2) {
            if (this.listener != null) {
                this.handler.post(new VideoRendererEventListener$EventDispatcher$$Lambda$1(this, str, j, j2));
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$decoderInitialized$1$VideoRendererEventListener$EventDispatcher */
        public final /* synthetic */ void mo5628x9a08f997(String str, long j, long j2) {
            this.listener.onVideoDecoderInitialized(str, j, j2);
        }

        public void inputFormatChanged(Format format) {
            if (this.listener != null) {
                this.handler.post(new VideoRendererEventListener$EventDispatcher$$Lambda$2(this, format));
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$inputFormatChanged$2$VideoRendererEventListener$EventDispatcher */
        public final /* synthetic */ void mo5632xe7570b3(Format format) {
            this.listener.onVideoInputFormatChanged(format);
        }

        public void droppedFrames(int i, long j) {
            if (this.listener != null) {
                this.handler.post(new VideoRendererEventListener$EventDispatcher$$Lambda$3(this, i, j));
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$droppedFrames$3$VideoRendererEventListener$EventDispatcher */
        public final /* synthetic */ void mo5630xf7e95759(int i, long j) {
            this.listener.onDroppedFrames(i, j);
        }

        public void videoSizeChanged(int i, int i2, int i3, float f) {
            if (this.listener != null) {
                this.handler.post(new VideoRendererEventListener$EventDispatcher$$Lambda$4(this, i, i2, i3, f));
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$videoSizeChanged$4$VideoRendererEventListener$EventDispatcher */
        public final /* synthetic */ void mo5634x6ff94f6c(int i, int i2, int i3, float f) {
            this.listener.onVideoSizeChanged(i, i2, i3, f);
        }

        public void renderedFirstFrame(Surface surface) {
            if (this.listener != null) {
                this.handler.post(new VideoRendererEventListener$EventDispatcher$$Lambda$5(this, surface));
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$renderedFirstFrame$5$VideoRendererEventListener$EventDispatcher */
        public final /* synthetic */ void mo5633x44bb7f11(Surface surface) {
            this.listener.onRenderedFirstFrame(surface);
        }

        public void disabled(DecoderCounters decoderCounters) {
            decoderCounters.ensureUpdated();
            if (this.listener != null) {
                this.handler.post(new VideoRendererEventListener$EventDispatcher$$Lambda$6(this, decoderCounters));
            }
        }

        /* access modifiers changed from: package-private */
        public final /* synthetic */ void lambda$disabled$6$VideoRendererEventListener$EventDispatcher(DecoderCounters decoderCounters) {
            decoderCounters.ensureUpdated();
            this.listener.onVideoDisabled(decoderCounters);
        }
    }
}
