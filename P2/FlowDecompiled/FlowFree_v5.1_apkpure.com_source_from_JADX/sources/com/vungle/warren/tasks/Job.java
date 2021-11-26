package com.vungle.warren.tasks;

import android.os.Bundle;

public interface Job {
    int onRunJob(Bundle bundle, JobRunner jobRunner);
}
