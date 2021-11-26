package com.google.firebase.crashlytics.ndk;

import java.io.File;

interface CrashFilesManager {
    void deleteSessionFilesDirectory(String str);

    File getSessionFileDirectory(String str);

    boolean hasSessionFileDirectory(String str);
}
