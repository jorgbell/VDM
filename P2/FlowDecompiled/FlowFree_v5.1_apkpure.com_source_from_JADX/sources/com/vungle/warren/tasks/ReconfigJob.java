package com.vungle.warren.tasks;

import android.os.Bundle;

public class ReconfigJob implements Job {
    public static final String TAG = "com.vungle.warren.tasks.ReconfigJob";
    private ReconfigCall reconfigCall;

    public interface ReconfigCall {
        void reConfigVungle();
    }

    public ReconfigJob(ReconfigCall reconfigCall2) {
        this.reconfigCall = reconfigCall2;
    }

    public static JobInfo makeJobInfo(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("appId", str);
        JobInfo jobInfo = new JobInfo(TAG);
        jobInfo.setExtras(bundle);
        jobInfo.setUpdateCurrent(true);
        jobInfo.setPriority(4);
        return jobInfo;
    }

    public int onRunJob(Bundle bundle, JobRunner jobRunner) {
        if (bundle.getString("appId", (String) null) == null) {
            return 1;
        }
        this.reconfigCall.reConfigVungle();
        return 0;
    }
}
