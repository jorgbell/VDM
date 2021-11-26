package com.noodlecake.lib.process;

import android.os.Process;

public class AppProcess {
    public static void terminateProcess() {
        Process.killProcess(Process.myPid());
    }
}
