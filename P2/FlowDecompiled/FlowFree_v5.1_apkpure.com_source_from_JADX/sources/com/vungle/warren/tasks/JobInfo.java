package com.vungle.warren.tasks;

import android.os.Bundle;
import android.util.Log;

public class JobInfo implements Cloneable {
    private long delay;
    private Bundle extras = new Bundle();
    private long nextRescheduleTimeout;
    private int priority = 2;
    private int requiredNetworkType = 0;
    private int reschedulePolicy = 1;
    private long rescheduleTimeout;
    private final String tag;
    private boolean updateCurrent;

    public JobInfo(String str) {
        this.tag = str;
    }

    public JobInfo setUpdateCurrent(boolean z) {
        this.updateCurrent = z;
        return this;
    }

    public JobInfo setExtras(Bundle bundle) {
        if (bundle != null) {
            this.extras = bundle;
        }
        return this;
    }

    public JobInfo setDelay(long j) {
        this.delay = j;
        return this;
    }

    public JobInfo setReschedulePolicy(long j, int i) {
        this.rescheduleTimeout = j;
        this.reschedulePolicy = i;
        return this;
    }

    public JobInfo setPriority(int i) {
        this.priority = i;
        return this;
    }

    public String getJobTag() {
        return this.tag;
    }

    public Bundle getExtras() {
        return this.extras;
    }

    public long getDelay() {
        return this.delay;
    }

    public long makeNextRescedule() {
        long j = this.rescheduleTimeout;
        if (j == 0) {
            return 0;
        }
        long j2 = this.nextRescheduleTimeout;
        if (j2 == 0) {
            this.nextRescheduleTimeout = j;
        } else if (this.reschedulePolicy == 1) {
            this.nextRescheduleTimeout = j2 * 2;
        }
        return this.nextRescheduleTimeout;
    }

    public boolean getUpdateCurrent() {
        return this.updateCurrent;
    }

    public int getPriority() {
        return this.priority;
    }

    public JobInfo copy() {
        try {
            return (JobInfo) super.clone();
        } catch (CloneNotSupportedException e) {
            Log.e("JobInfo", Log.getStackTraceString(e));
            return null;
        }
    }

    public int getRequiredNetworkType() {
        return this.requiredNetworkType;
    }

    public JobInfo setRequiredNetworkType(int i) {
        this.requiredNetworkType = i;
        return this;
    }
}
