package com.mopub.common;

import android.os.SystemClock;
import com.mopub.common.logging.MoPubLog;

public class DoubleTimeTracker {
    private long interval;
    private final Clock mClock;
    private long startedTimestamp;
    private volatile State state;

    public interface Clock {
        long elapsedRealTime();
    }

    private enum State {
        STARTED,
        PAUSED
    }

    public DoubleTimeTracker() {
        this(new SystemClockClock());
    }

    @VisibleForTesting
    public DoubleTimeTracker(Clock clock) {
        this.mClock = clock;
        this.state = State.PAUSED;
    }

    public synchronized void start() {
        State state2 = this.state;
        State state3 = State.STARTED;
        if (state2 == state3) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "DoubleTimeTracker already started.");
            return;
        }
        this.state = state3;
        this.startedTimestamp = this.mClock.elapsedRealTime();
    }

    public synchronized void pause() {
        State state2 = this.state;
        State state3 = State.PAUSED;
        if (state2 == state3) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "DoubleTimeTracker already paused.");
            return;
        }
        this.interval += computeIntervalDiff();
        this.startedTimestamp = 0;
        this.state = state3;
    }

    public synchronized double getInterval() {
        return (double) (this.interval + computeIntervalDiff());
    }

    private synchronized long computeIntervalDiff() {
        if (this.state == State.PAUSED) {
            return 0;
        }
        return this.mClock.elapsedRealTime() - this.startedTimestamp;
    }

    private static class SystemClockClock implements Clock {
        private SystemClockClock() {
        }

        public long elapsedRealTime() {
            return SystemClock.elapsedRealtime();
        }
    }
}
