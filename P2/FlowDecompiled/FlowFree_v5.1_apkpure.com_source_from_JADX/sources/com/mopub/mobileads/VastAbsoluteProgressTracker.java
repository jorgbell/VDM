package com.mopub.mobileads;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mopub.mobileads.VastTracker;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VastAbsoluteProgressTracker.kt */
public class VastAbsoluteProgressTracker extends VastTracker implements Comparable<VastAbsoluteProgressTracker> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Pattern absolutePattern = Pattern.compile("\\d{2}:\\d{2}:\\d{2}(.\\d{3})?");
    @SerializedName("tracking_ms")
    @Expose
    private final int trackingMilliseconds;

    public final int getTrackingMilliseconds() {
        return this.trackingMilliseconds;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VastAbsoluteProgressTracker(int i, String str, VastTracker.MessageType messageType, boolean z) {
        super(str, messageType, z);
        Intrinsics.checkNotNullParameter(str, "content");
        Intrinsics.checkNotNullParameter(messageType, "messageType");
        this.trackingMilliseconds = i;
    }

    /* compiled from: VastAbsoluteProgressTracker.kt */
    public static final class Builder {
        private final String content;
        private boolean isRepeatable;
        private VastTracker.MessageType messageType = VastTracker.MessageType.TRACKING_URL;
        private final int trackingMilliseconds;

        public static /* synthetic */ Builder copy$default(Builder builder, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = builder.content;
            }
            if ((i2 & 2) != 0) {
                i = builder.trackingMilliseconds;
            }
            return builder.copy(str, i);
        }

        public final Builder copy(String str, int i) {
            Intrinsics.checkNotNullParameter(str, "content");
            return new Builder(str, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Builder)) {
                return false;
            }
            Builder builder = (Builder) obj;
            return Intrinsics.areEqual(this.content, builder.content) && this.trackingMilliseconds == builder.trackingMilliseconds;
        }

        public int hashCode() {
            String str = this.content;
            return ((str != null ? str.hashCode() : 0) * 31) + this.trackingMilliseconds;
        }

        public String toString() {
            return "Builder(content=" + this.content + ", trackingMilliseconds=" + this.trackingMilliseconds + ")";
        }

        public Builder(String str, int i) {
            Intrinsics.checkNotNullParameter(str, "content");
            this.content = str;
            this.trackingMilliseconds = i;
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

        public final VastAbsoluteProgressTracker build() {
            return new VastAbsoluteProgressTracker(this.trackingMilliseconds, this.content, this.messageType, this.isRepeatable);
        }
    }

    /* compiled from: VastAbsoluteProgressTracker.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isAbsoluteTracker(String str) {
            if ((str == null || str.length() == 0) || !VastAbsoluteProgressTracker.absolutePattern.matcher(str).matches()) {
                return false;
            }
            return true;
        }

        public final Integer parseAbsoluteOffset(String str) {
            List split$default;
            if (str == null || (split$default = StringsKt__StringsKt.split$default(str, new String[]{":"}, false, 0, 6, (Object) null)) == null) {
                return null;
            }
            if (!(split$default.size() == 3)) {
                split$default = null;
            }
            if (split$default != null) {
                return Integer.valueOf((Integer.parseInt((String) split$default.get(0)) * 60 * 60 * 1000) + (Integer.parseInt((String) split$default.get(1)) * 60 * 1000) + ((int) (Float.parseFloat((String) split$default.get(2)) * ((float) 1000))));
            }
            return null;
        }
    }

    public int compareTo(VastAbsoluteProgressTracker vastAbsoluteProgressTracker) {
        Intrinsics.checkNotNullParameter(vastAbsoluteProgressTracker, "other");
        return Intrinsics.compare(this.trackingMilliseconds, vastAbsoluteProgressTracker.trackingMilliseconds);
    }

    public String toString() {
        return this.trackingMilliseconds + "ms: " + getContent();
    }
}
