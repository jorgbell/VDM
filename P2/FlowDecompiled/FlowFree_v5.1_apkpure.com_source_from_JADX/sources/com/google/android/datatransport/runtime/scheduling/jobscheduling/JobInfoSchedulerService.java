package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.util.PriorityMapping;

public class JobInfoSchedulerService extends JobService {
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }

    public boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i = jobParameters.getExtras().getInt("priority");
        int i2 = jobParameters.getExtras().getInt("attemptNumber");
        TransportRuntime.initialize(getApplicationContext());
        TransportContext.Builder builder = TransportContext.builder();
        builder.setBackendName(string);
        builder.setPriority(PriorityMapping.valueOf(i));
        if (string2 != null) {
            builder.setExtras(Base64.decode(string2, 0));
        }
        TransportRuntime.getInstance().getUploader().upload(builder.build(), i2, JobInfoSchedulerService$$Lambda$1.lambdaFactory$(this, jobParameters));
        return true;
    }
}
