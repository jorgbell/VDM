package com.google.firebase.crashlytics.ndk;

import java.io.File;

class NdkCrashFilesManager implements CrashFilesManager {
    private final File rootPath;

    NdkCrashFilesManager(File file) {
        this.rootPath = file;
    }

    public boolean hasSessionFileDirectory(String str) {
        return new File(this.rootPath, str).exists();
    }

    public File getSessionFileDirectory(String str) {
        return prepareDirectory(new File(this.rootPath, str));
    }

    public void deleteSessionFilesDirectory(String str) {
        recursiveDelete(new File(this.rootPath, str));
    }

    private static File prepareDirectory(File file) {
        if (file == null) {
            return null;
        }
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    private static void recursiveDelete(File file) {
        if (file.isDirectory()) {
            for (File recursiveDelete : file.listFiles()) {
                recursiveDelete(recursiveDelete);
            }
        }
        file.delete();
    }
}
