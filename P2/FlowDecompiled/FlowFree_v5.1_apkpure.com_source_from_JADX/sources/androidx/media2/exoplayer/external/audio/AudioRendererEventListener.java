package androidx.media2.exoplayer.external.audio;

import android.os.Handler;
import androidx.media2.exoplayer.external.Format;
import androidx.media2.exoplayer.external.decoder.DecoderCounters;
import androidx.media2.exoplayer.external.util.Assertions;

public interface AudioRendererEventListener {
    void onAudioDecoderInitialized(String str, long j, long j2);

    void onAudioDisabled(DecoderCounters decoderCounters);

    void onAudioEnabled(DecoderCounters decoderCounters);

    void onAudioInputFormatChanged(Format format);

    void onAudioSessionId(int i);

    void onAudioSinkUnderrun(int i, long j, long j2);

    public static final class EventDispatcher {
        private final Handler handler;
        private final AudioRendererEventListener listener;

        public EventDispatcher(Handler handler2, AudioRendererEventListener audioRendererEventListener) {
            Handler handler3;
            if (audioRendererEventListener != null) {
                Assertions.checkNotNull(handler2);
                handler3 = handler2;
            } else {
                handler3 = null;
            }
            this.handler = handler3;
            this.listener = audioRendererEventListener;
        }

        public void enabled(DecoderCounters decoderCounters) {
            if (this.listener != null) {
                this.handler.post(new AudioRendererEventListener$EventDispatcher$$Lambda$0(this, decoderCounters));
            }
        }

        /* access modifiers changed from: package-private */
        public final /* synthetic */ void lambda$enabled$0$AudioRendererEventListener$EventDispatcher(DecoderCounters decoderCounters) {
            this.listener.onAudioEnabled(decoderCounters);
        }

        public void decoderInitialized(String str, long j, long j2) {
            if (this.listener != null) {
                this.handler.post(new AudioRendererEventListener$EventDispatcher$$Lambda$1(this, str, j, j2));
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$decoderInitialized$1$AudioRendererEventListener$EventDispatcher */
        public final /* synthetic */ void mo4426xba417f1c(String str, long j, long j2) {
            this.listener.onAudioDecoderInitialized(str, j, j2);
        }

        public void inputFormatChanged(Format format) {
            if (this.listener != null) {
                this.handler.post(new AudioRendererEventListener$EventDispatcher$$Lambda$2(this, format));
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$inputFormatChanged$2$AudioRendererEventListener$EventDispatcher */
        public final /* synthetic */ void mo4429x2eadf638(Format format) {
            this.listener.onAudioInputFormatChanged(format);
        }

        public void audioTrackUnderrun(int i, long j, long j2) {
            if (this.listener != null) {
                this.handler.post(new AudioRendererEventListener$EventDispatcher$$Lambda$3(this, i, j, j2));
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$audioTrackUnderrun$3$AudioRendererEventListener$EventDispatcher */
        public final /* synthetic */ void mo4425xe45e91e2(int i, long j, long j2) {
            this.listener.onAudioSinkUnderrun(i, j, j2);
        }

        public void disabled(DecoderCounters decoderCounters) {
            decoderCounters.ensureUpdated();
            if (this.listener != null) {
                this.handler.post(new AudioRendererEventListener$EventDispatcher$$Lambda$4(this, decoderCounters));
            }
        }

        /* access modifiers changed from: package-private */
        public final /* synthetic */ void lambda$disabled$4$AudioRendererEventListener$EventDispatcher(DecoderCounters decoderCounters) {
            decoderCounters.ensureUpdated();
            this.listener.onAudioDisabled(decoderCounters);
        }

        public void audioSessionId(int i) {
            if (this.listener != null) {
                this.handler.post(new AudioRendererEventListener$EventDispatcher$$Lambda$5(this, i));
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$audioSessionId$5$AudioRendererEventListener$EventDispatcher */
        public final /* synthetic */ void mo4424xc1c634cd(int i) {
            this.listener.onAudioSessionId(i);
        }
    }
}
