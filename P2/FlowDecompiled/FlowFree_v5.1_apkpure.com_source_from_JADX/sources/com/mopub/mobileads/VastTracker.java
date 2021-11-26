package com.mopub.mobileads;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VastTracker.kt */
public class VastTracker implements Serializable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @SerializedName("content")
    @Expose
    private final String content;
    @SerializedName("is_repeatable")
    @Expose
    private final boolean isRepeatable;
    private boolean isTracked;
    @SerializedName("message_type")
    @Expose
    private final MessageType messageType;

    /* compiled from: VastTracker.kt */
    public enum MessageType {
        TRACKING_URL,
        QUARTILE_EVENT
    }

    public VastTracker(String str, MessageType messageType2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "content");
        Intrinsics.checkNotNullParameter(messageType2, "messageType");
        this.content = str;
        this.messageType = messageType2;
        this.isRepeatable = z;
    }

    public final String getContent() {
        return this.content;
    }

    public final MessageType getMessageType() {
        return this.messageType;
    }

    public final boolean isRepeatable() {
        return this.isRepeatable;
    }

    /* compiled from: VastTracker.kt */
    public static final class Builder {
        private final String content;
        private boolean isRepeatable;
        private MessageType messageType = MessageType.TRACKING_URL;

        public static /* synthetic */ Builder copy$default(Builder builder, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = builder.content;
            }
            return builder.copy(str);
        }

        public final Builder copy(String str) {
            Intrinsics.checkNotNullParameter(str, "content");
            return new Builder(str);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Builder) && Intrinsics.areEqual(this.content, ((Builder) obj).content);
            }
            return true;
        }

        public int hashCode() {
            String str = this.content;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Builder(content=" + this.content + ")";
        }

        public Builder(String str) {
            Intrinsics.checkNotNullParameter(str, "content");
            this.content = str;
        }

        public final Builder messageType(MessageType messageType2) {
            Intrinsics.checkNotNullParameter(messageType2, "messageType");
            this.messageType = messageType2;
            return this;
        }

        public final Builder isRepeatable(boolean z) {
            this.isRepeatable = z;
            return this;
        }

        public final VastTracker build() {
            return new VastTracker(this.content, this.messageType, this.isRepeatable);
        }
    }

    /* compiled from: VastTracker.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final boolean isTracked() {
        return this.isTracked;
    }

    public final void setTracked() {
        this.isTracked = true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VastTracker)) {
            return false;
        }
        VastTracker vastTracker = (VastTracker) obj;
        return !(Intrinsics.areEqual(this.content, vastTracker.content) ^ true) && this.messageType == vastTracker.messageType && this.isRepeatable == vastTracker.isRepeatable && this.isTracked == vastTracker.isTracked;
    }

    public int hashCode() {
        return (((((this.content.hashCode() * 31) + this.messageType.hashCode()) * 31) + C$r8$backportedMethods$utility$Boolean$1$hashCode.hashCode(this.isRepeatable)) * 31) + C$r8$backportedMethods$utility$Boolean$1$hashCode.hashCode(this.isTracked);
    }

    public String toString() {
        return "VastTracker(content='" + this.content + "', messageType=" + this.messageType + ", " + "isRepeatable=" + this.isRepeatable + ", isTracked=" + this.isTracked + ')';
    }
}
