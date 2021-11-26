package com.mopub.mobileads;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mopub.mobileads.VastTracker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VideoViewabilityTracker.kt */
public class VideoViewabilityTracker extends VastTracker {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @SerializedName("percent_viewable")
    @Expose
    private final int percentViewable;
    @SerializedName("playtime_ms")
    @Expose
    private final int viewablePlaytimeMS;

    public final int getViewablePlaytimeMS() {
        return this.viewablePlaytimeMS;
    }

    public final int getPercentViewable() {
        return this.percentViewable;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VideoViewabilityTracker(int i, int i2, String str, VastTracker.MessageType messageType, boolean z) {
        super(str, messageType, z);
        Intrinsics.checkNotNullParameter(str, "content");
        Intrinsics.checkNotNullParameter(messageType, "messageType");
        this.viewablePlaytimeMS = i;
        this.percentViewable = i2;
    }

    /* compiled from: VideoViewabilityTracker.kt */
    public static final class Builder {
        private final String content;
        private boolean isRepeatable;
        private VastTracker.MessageType messageType = VastTracker.MessageType.TRACKING_URL;
        private final int percentViewable;
        private final int viewablePlaytimeMS;

        public static /* synthetic */ Builder copy$default(Builder builder, String str, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = builder.content;
            }
            if ((i3 & 2) != 0) {
                i = builder.viewablePlaytimeMS;
            }
            if ((i3 & 4) != 0) {
                i2 = builder.percentViewable;
            }
            return builder.copy(str, i, i2);
        }

        public final int component2() {
            return this.viewablePlaytimeMS;
        }

        public final int component3() {
            return this.percentViewable;
        }

        public final Builder copy(String str, int i, int i2) {
            Intrinsics.checkNotNullParameter(str, "content");
            return new Builder(str, i, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Builder)) {
                return false;
            }
            Builder builder = (Builder) obj;
            return Intrinsics.areEqual(this.content, builder.content) && this.viewablePlaytimeMS == builder.viewablePlaytimeMS && this.percentViewable == builder.percentViewable;
        }

        public int hashCode() {
            String str = this.content;
            return ((((str != null ? str.hashCode() : 0) * 31) + this.viewablePlaytimeMS) * 31) + this.percentViewable;
        }

        public String toString() {
            return "Builder(content=" + this.content + ", viewablePlaytimeMS=" + this.viewablePlaytimeMS + ", percentViewable=" + this.percentViewable + ")";
        }

        public Builder(String str, int i, int i2) {
            Intrinsics.checkNotNullParameter(str, "content");
            this.content = str;
            this.viewablePlaytimeMS = i;
            this.percentViewable = i2;
        }

        public final int getViewablePlaytimeMS() {
            return this.viewablePlaytimeMS;
        }

        public final int getPercentViewable() {
            return this.percentViewable;
        }

        public final Builder messageType(VastTracker.MessageType messageType2) {
            Intrinsics.checkNotNullParameter(messageType2, "messageType");
            this.messageType = messageType2;
            return this;
        }

        public final Builder isRepeatable(boolean z) {
            this.isRepeatable = z;
            return this;
        }

        public final VideoViewabilityTracker build() {
            return new VideoViewabilityTracker(this.viewablePlaytimeMS, this.percentViewable, this.content, this.messageType, this.isRepeatable);
        }
    }

    /* compiled from: VideoViewabilityTracker.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
