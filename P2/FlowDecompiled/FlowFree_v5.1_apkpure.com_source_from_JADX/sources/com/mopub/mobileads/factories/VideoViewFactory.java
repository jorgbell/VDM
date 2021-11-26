package com.mopub.mobileads.factories;

import android.content.Context;
import androidx.media2.widget.VideoView;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VideoViewFactory.kt */
public class VideoViewFactory {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static VideoViewFactory instance = new VideoViewFactory();

    /* compiled from: VideoViewFactory.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VideoViewFactory getInstance() {
            return VideoViewFactory.instance;
        }

        public final void setInstance(VideoViewFactory videoViewFactory) {
            Intrinsics.checkNotNullParameter(videoViewFactory, "<set-?>");
            VideoViewFactory.instance = videoViewFactory;
        }

        public final VideoView create(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return getInstance().internalCreate(context);
        }
    }

    public VideoView internalCreate(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new VideoView(context);
    }
}
