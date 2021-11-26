package com.vungle.warren.tasks;

import android.os.Bundle;
import com.vungle.warren.log.LogManager;

public class SendLogsJob implements Job {
    static final String TAG = "SendLogsJob";
    private LogManager logManager;

    public SendLogsJob(LogManager logManager2) {
        this.logManager = logManager2;
    }

    public static JobInfo makeJobInfo() {
        JobInfo jobInfo = new JobInfo(TAG);
        jobInfo.setPriority(2);
        return jobInfo;
    }

    public int onRunJob(Bundle bundle, JobRunner jobRunner) {
        this.logManager.sendSdkLogs();
        return 0;
    }
}
