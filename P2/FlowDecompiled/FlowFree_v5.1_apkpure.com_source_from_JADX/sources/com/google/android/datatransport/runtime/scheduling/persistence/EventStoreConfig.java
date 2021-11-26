package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.AutoValue_EventStoreConfig;
import com.google.auto.value.AutoValue;

@AutoValue
abstract class EventStoreConfig {
    static final EventStoreConfig DEFAULT;

    /* access modifiers changed from: package-private */
    public abstract int getCriticalSectionEnterTimeoutMs();

    /* access modifiers changed from: package-private */
    public abstract long getEventCleanUpAge();

    /* access modifiers changed from: package-private */
    public abstract int getLoadBatchSize();

    /* access modifiers changed from: package-private */
    public abstract int getMaxBlobByteSizePerRow();

    /* access modifiers changed from: package-private */
    public abstract long getMaxStorageSizeInBytes();

    EventStoreConfig() {
    }

    static {
        Builder builder = builder();
        builder.setMaxStorageSizeInBytes(10485760);
        builder.setLoadBatchSize(200);
        builder.setCriticalSectionEnterTimeoutMs(10000);
        builder.setEventCleanUpAge(604800000);
        builder.setMaxBlobByteSizePerRow(81920);
        DEFAULT = builder.build();
    }

    static Builder builder() {
        return new AutoValue_EventStoreConfig.Builder();
    }

    @AutoValue.Builder
    static abstract class Builder {
        /* access modifiers changed from: package-private */
        public abstract EventStoreConfig build();

        /* access modifiers changed from: package-private */
        public abstract Builder setCriticalSectionEnterTimeoutMs(int i);

        /* access modifiers changed from: package-private */
        public abstract Builder setEventCleanUpAge(long j);

        /* access modifiers changed from: package-private */
        public abstract Builder setLoadBatchSize(int i);

        /* access modifiers changed from: package-private */
        public abstract Builder setMaxBlobByteSizePerRow(int i);

        /* access modifiers changed from: package-private */
        public abstract Builder setMaxStorageSizeInBytes(long j);

        Builder() {
        }
    }
}
