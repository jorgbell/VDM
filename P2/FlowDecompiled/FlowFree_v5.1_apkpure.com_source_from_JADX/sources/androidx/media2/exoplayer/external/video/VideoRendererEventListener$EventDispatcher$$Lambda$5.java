package androidx.media2.exoplayer.external.video;

import android.view.Surface;
import androidx.media2.exoplayer.external.video.VideoRendererEventListener;

final /* synthetic */ class VideoRendererEventListener$EventDispatcher$$Lambda$5 implements Runnable {
    private final VideoRendererEventListener.EventDispatcher arg$1;
    private final Surface arg$2;

    VideoRendererEventListener$EventDispatcher$$Lambda$5(VideoRendererEventListener.EventDispatcher eventDispatcher, Surface surface) {
        this.arg$1 = eventDispatcher;
        this.arg$2 = surface;
    }

    public void run() {
        this.arg$1.mo5633x44bb7f11(this.arg$2);
    }
}
