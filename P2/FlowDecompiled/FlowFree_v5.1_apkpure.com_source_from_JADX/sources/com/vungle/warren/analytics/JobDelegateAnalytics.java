package com.vungle.warren.analytics;

import com.google.gson.JsonObject;
import com.vungle.warren.tasks.AnalyticsJob;
import com.vungle.warren.tasks.JobRunner;

public class JobDelegateAnalytics implements AdAnalytics {
    private final JobRunner jobRunner;

    public JobDelegateAnalytics(JobRunner jobRunner2) {
        this.jobRunner = jobRunner2;
    }

    public String[] ping(String[] strArr) {
        this.jobRunner.execute(AnalyticsJob.makeJob(1, (String) null, strArr));
        return new String[0];
    }

    /* renamed from: ri */
    public void mo27243ri(JsonObject jsonObject) {
        this.jobRunner.execute(AnalyticsJob.makeJob(0, jsonObject.toString(), (String[]) null));
    }
}
