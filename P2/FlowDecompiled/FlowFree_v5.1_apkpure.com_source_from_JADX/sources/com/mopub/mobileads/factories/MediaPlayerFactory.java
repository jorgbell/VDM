package com.mopub.mobileads.factories;

import android.content.Context;
import androidx.media2.player.MediaPlayer;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MediaPlayerFactory.kt */
public class MediaPlayerFactory {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static MediaPlayerFactory instance = new MediaPlayerFactory();

    /* compiled from: MediaPlayerFactory.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MediaPlayerFactory getInstance() {
            return MediaPlayerFactory.instance;
        }

        public final void setInstance(MediaPlayerFactory mediaPlayerFactory) {
            Intrinsics.checkNotNullParameter(mediaPlayerFactory, "<set-?>");
            MediaPlayerFactory.instance = mediaPlayerFactory;
        }

        public final MediaPlayer create(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return getInstance().internalCreate(context);
        }
    }

    public MediaPlayer internalCreate(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new MediaPlayer(context);
    }
}
