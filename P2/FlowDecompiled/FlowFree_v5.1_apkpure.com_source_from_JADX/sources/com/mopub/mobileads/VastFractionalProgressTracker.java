package com.mopub.mobileads;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mopub.mobileads.VastTracker;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VastFractionalProgressTracker.kt */
public final class VastFractionalProgressTracker extends VastTracker implements Comparable<VastFractionalProgressTracker> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Pattern percentagePattern = Pattern.compile("((\\d{1,2})|(100))%");
    @SerializedName("tracking_fraction")
    @Expose
    private final float trackingFraction;

    public final float getTrackingFraction() {
        return this.trackingFraction;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VastFractionalProgressTracker(float f, String str, VastTracker.MessageType messageType, boolean z) {
        super(str, messageType, z);
        Intrinsics.checkNotNullParameter(str, "content");
        Intrinsics.checkNotNullParameter(messageType, "messageType");
        this.trackingFraction = f;
    }

    /* compiled from: VastFractionalProgressTracker.kt */
    public static final class Builder {
        private final String content;
        private boolean isRepeatable;
        private VastTracker.MessageType messageType = VastTracker.MessageType.TRACKING_URL;
        private final float trackingFraction;

        public static /* synthetic */ Builder copy$default(Builder builder, String str, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                str = builder.content;
            }
            if ((i & 2) != 0) {
                f = builder.trackingFraction;
            }
            return builder.copy(str, f);
        }

        public final Builder copy(String str, float f) {
            Intrinsics.checkNotNullParameter(str, "content");
            return new Builder(str, f);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Builder)) {
                return false;
            }
            Builder builder = (Builder) obj;
            return Intrinsics.areEqual(this.content, builder.content) && Float.compare(this.trackingFraction, builder.trackingFraction) == 0;
        }

        public int hashCode() {
            String str = this.content;
            return ((str != null ? str.hashCode() : 0) * 31) + Float.floatToIntBits(this.trackingFraction);
        }

        public String toString() {
            return "Builder(content=" + this.content + ", trackingFraction=" + this.trackingFraction + ")";
        }

        public Builder(String str, float f) {
            Intrinsics.checkNotNullParameter(str, "content");
            this.content = str;
            this.trackingFraction = f;
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

        public final VastFractionalProgressTracker build() {
            return new VastFractionalProgressTracker(this.trackingFraction, this.content, this.messageType, this.isRepeatable);
        }
    }

    /* compiled from: VastFractionalProgressTracker.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isPercentageTracker(String str) {
            if ((str == null || str.length() == 0) || !VastFractionalProgressTracker.percentagePattern.matcher(str).matches()) {
                return false;
            }
            return true;
        }

        public final Integer parsePercentageOffset(String str, int i) {
            String replace$default;
            if (str == null || (replace$default = StringsKt__StringsJVMKt.replace$default(str, "%", "", false, 4, (Object) null)) == null) {
                return null;
            }
            return Integer.valueOf((int) ((float) Math.rint((double) ((((float) i) * Float.parseFloat(replace$default)) / 100.0f))));
        }
    }

    public int compareTo(VastFractionalProgressTracker vastFractionalProgressTracker) {
        Intrinsics.checkNotNullParameter(vastFractionalProgressTracker, "other");
        return Float.compare(this.trackingFraction, vastFractionalProgressTracker.trackingFraction);
    }

    public String toString() {
        return this.trackingFraction + ": " + getContent();
    }
}
