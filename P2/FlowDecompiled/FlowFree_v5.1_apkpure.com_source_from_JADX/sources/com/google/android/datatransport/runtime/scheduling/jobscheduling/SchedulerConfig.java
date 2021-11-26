package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AutoValue_SchedulerConfig_ConfigValue;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.auto.value.AutoValue;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@AutoValue
public abstract class SchedulerConfig {

    public enum Flag {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING
    }

    /* access modifiers changed from: package-private */
    public abstract Clock getClock();

    /* access modifiers changed from: package-private */
    public abstract Map<Priority, ConfigValue> getValues();

    @AutoValue
    public static abstract class ConfigValue {

        @AutoValue.Builder
        public static abstract class Builder {
            public abstract ConfigValue build();

            public abstract Builder setDelta(long j);

            public abstract Builder setFlags(Set<Flag> set);

            public abstract Builder setMaxAllowedDelay(long j);
        }

        /* access modifiers changed from: package-private */
        public abstract long getDelta();

        /* access modifiers changed from: package-private */
        public abstract Set<Flag> getFlags();

        /* access modifiers changed from: package-private */
        public abstract long getMaxAllowedDelay();

        public static Builder builder() {
            AutoValue_SchedulerConfig_ConfigValue.Builder builder = new AutoValue_SchedulerConfig_ConfigValue.Builder();
            builder.setFlags(Collections.emptySet());
            return builder;
        }
    }

    public static SchedulerConfig getDefault(Clock clock) {
        Builder builder = builder();
        Priority priority = Priority.DEFAULT;
        ConfigValue.Builder builder2 = ConfigValue.builder();
        builder2.setDelta(30000);
        builder2.setMaxAllowedDelay(86400000);
        builder.addConfig(priority, builder2.build());
        Priority priority2 = Priority.HIGHEST;
        ConfigValue.Builder builder3 = ConfigValue.builder();
        builder3.setDelta(1000);
        builder3.setMaxAllowedDelay(86400000);
        builder.addConfig(priority2, builder3.build());
        Priority priority3 = Priority.VERY_LOW;
        ConfigValue.Builder builder4 = ConfigValue.builder();
        builder4.setDelta(86400000);
        builder4.setMaxAllowedDelay(86400000);
        builder4.setFlags(immutableSetOf(Flag.NETWORK_UNMETERED, Flag.DEVICE_IDLE));
        builder.addConfig(priority3, builder4.build());
        builder.setClock(clock);
        return builder.build();
    }

    public static Builder builder() {
        return new Builder();
    }

    static SchedulerConfig create(Clock clock, Map<Priority, ConfigValue> map) {
        return new AutoValue_SchedulerConfig(clock, map);
    }

    public static class Builder {
        private Clock clock;
        private Map<Priority, ConfigValue> values = new HashMap();

        public Builder setClock(Clock clock2) {
            this.clock = clock2;
            return this;
        }

        public Builder addConfig(Priority priority, ConfigValue configValue) {
            this.values.put(priority, configValue);
            return this;
        }

        public SchedulerConfig build() {
            Objects.requireNonNull(this.clock, "missing required property: clock");
            if (this.values.keySet().size() >= Priority.values().length) {
                Map<Priority, ConfigValue> map = this.values;
                this.values = new HashMap();
                return SchedulerConfig.create(this.clock, map);
            }
            throw new IllegalStateException("Not all priorities have been configured");
        }
    }

    public long getScheduleDelay(Priority priority, long j, int i) {
        long time = j - getClock().getTime();
        ConfigValue configValue = getValues().get(priority);
        return Math.min(Math.max(adjustedExponentialBackoff(i, configValue.getDelta()), time), configValue.getMaxAllowedDelay());
    }

    private long adjustedExponentialBackoff(int i, long j) {
        int i2 = i - 1;
        double max = Math.max(1.0d, Math.log(10000.0d) / Math.log((double) ((j > 1 ? j : 2) * ((long) i2))));
        double pow = Math.pow(3.0d, (double) i2);
        double d = (double) j;
        Double.isNaN(d);
        return (long) (pow * d * max);
    }

    public JobInfo.Builder configureJob(JobInfo.Builder builder, Priority priority, long j, int i) {
        builder.setMinimumLatency(getScheduleDelay(priority, j, i));
        populateFlags(builder, getValues().get(priority).getFlags());
        return builder;
    }

    private void populateFlags(JobInfo.Builder builder, Set<Flag> set) {
        if (set.contains(Flag.NETWORK_UNMETERED)) {
            builder.setRequiredNetworkType(2);
        } else {
            builder.setRequiredNetworkType(1);
        }
        if (set.contains(Flag.DEVICE_CHARGING)) {
            builder.setRequiresCharging(true);
        }
        if (set.contains(Flag.DEVICE_IDLE)) {
            builder.setRequiresDeviceIdle(true);
        }
    }

    private static <T> Set<T> immutableSetOf(T... tArr) {
        return Collections.unmodifiableSet(new HashSet(Arrays.asList(tArr)));
    }
}
