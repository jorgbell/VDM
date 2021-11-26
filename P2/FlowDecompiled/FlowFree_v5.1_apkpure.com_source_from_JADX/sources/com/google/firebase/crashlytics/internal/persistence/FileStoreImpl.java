package com.google.firebase.crashlytics.internal.persistence;

import android.content.Context;
import com.google.firebase.crashlytics.internal.Logger;
import java.io.File;

public class FileStoreImpl implements FileStore {
    private final Context context;

    public FileStoreImpl(Context context2) {
        this.context = context2;
    }

    public File getFilesDir() {
        return prepare(new File(this.context.getFilesDir(), ".com.google.firebase.crashlytics"));
    }

    public String getFilesDirPath() {
        return new File(this.context.getFilesDir(), ".com.google.firebase.crashlytics").getPath();
    }

    /* access modifiers changed from: package-private */
    public File prepare(File file) {
        if (file == null) {
            Logger.getLogger().mo22339w("Null File");
            return null;
        } else if (file.exists() || file.mkdirs()) {
            return file;
        } else {
            Logger.getLogger().mo22339w("Couldn't create file");
            return null;
        }
    }
}
