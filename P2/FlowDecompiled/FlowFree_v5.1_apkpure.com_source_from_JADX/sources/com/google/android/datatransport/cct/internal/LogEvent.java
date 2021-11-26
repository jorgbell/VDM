package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.AutoValue_LogEvent;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class LogEvent {

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract LogEvent build();

        public abstract Builder setEventCode(Integer num);

        public abstract Builder setEventTimeMs(long j);

        public abstract Builder setEventUptimeMs(long j);

        public abstract Builder setNetworkConnectionInfo(NetworkConnectionInfo networkConnectionInfo);

        /* access modifiers changed from: package-private */
        public abstract Builder setSourceExtension(byte[] bArr);

        /* access modifiers changed from: package-private */
        public abstract Builder setSourceExtensionJsonProto3(String str);

        public abstract Builder setTimezoneOffsetSeconds(long j);
    }

    public abstract Integer getEventCode();

    public abstract long getEventTimeMs();

    public abstract long getEventUptimeMs();

    public abstract NetworkConnectionInfo getNetworkConnectionInfo();

    public abstract byte[] getSourceExtension();

    public abstract String getSourceExtensionJsonProto3();

    public abstract long getTimezoneOffsetSeconds();

    public static Builder protoBuilder(byte[] bArr) {
        Builder builder = builder();
        builder.setSourceExtension(bArr);
        return builder;
    }

    public static Builder jsonBuilder(String str) {
        Builder builder = builder();
        builder.setSourceExtensionJsonProto3(str);
        return builder;
    }

    private static Builder builder() {
        return new AutoValue_LogEvent.Builder();
    }
}
