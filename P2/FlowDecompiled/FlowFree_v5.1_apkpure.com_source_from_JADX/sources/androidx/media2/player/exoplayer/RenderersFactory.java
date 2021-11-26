package androidx.media2.player.exoplayer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import androidx.media2.exoplayer.external.Renderer;
import androidx.media2.exoplayer.external.audio.AudioRendererEventListener;
import androidx.media2.exoplayer.external.audio.AudioSink;
import androidx.media2.exoplayer.external.audio.MediaCodecAudioRenderer;
import androidx.media2.exoplayer.external.drm.DrmSessionManager;
import androidx.media2.exoplayer.external.drm.FrameworkMediaCrypto;
import androidx.media2.exoplayer.external.mediacodec.MediaCodecSelector;
import androidx.media2.exoplayer.external.metadata.MetadataOutput;
import androidx.media2.exoplayer.external.metadata.MetadataRenderer;
import androidx.media2.exoplayer.external.text.TextOutput;
import androidx.media2.exoplayer.external.video.MediaCodecVideoRenderer;
import androidx.media2.exoplayer.external.video.VideoRendererEventListener;

@SuppressLint({"RestrictedApi"})
final class RenderersFactory implements androidx.media2.exoplayer.external.RenderersFactory {
    private final AudioSink mAudioSink;
    private final Context mContext;
    private final TextRenderer mTextRenderer;

    RenderersFactory(Context context, AudioSink audioSink, TextRenderer textRenderer) {
        this.mContext = context;
        this.mAudioSink = audioSink;
        this.mTextRenderer = textRenderer;
    }

    public Renderer[] createRenderers(Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager) {
        Context context = this.mContext;
        MediaCodecSelector mediaCodecSelector = MediaCodecSelector.DEFAULT;
        DrmSessionManager<FrameworkMediaCrypto> drmSessionManager2 = drmSessionManager;
        Handler handler2 = handler;
        return new Renderer[]{new MediaCodecVideoRenderer(context, mediaCodecSelector, 5000, drmSessionManager2, false, handler2, videoRendererEventListener, 50), new MediaCodecAudioRenderer(this.mContext, mediaCodecSelector, drmSessionManager2, false, handler2, audioRendererEventListener, this.mAudioSink), this.mTextRenderer, new MetadataRenderer(metadataOutput, handler.getLooper(), new Id3MetadataDecoderFactory())};
    }
}
