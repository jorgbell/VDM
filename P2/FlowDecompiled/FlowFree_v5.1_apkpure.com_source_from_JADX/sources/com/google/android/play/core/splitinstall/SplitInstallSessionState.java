package com.google.android.play.core.splitinstall;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import java.util.List;

public abstract class SplitInstallSessionState {
    /* renamed from: d */
    public static SplitInstallSessionState m5405d(Bundle bundle) {
        return new C2152a(bundle.getInt("session_id"), bundle.getInt("status"), bundle.getInt("error_code"), bundle.getLong("bytes_downloaded"), bundle.getLong("total_bytes_to_download"), bundle.getStringArrayList("module_names"), bundle.getStringArrayList("languages"), (PendingIntent) bundle.getParcelable("user_confirmation_intent"), bundle.getParcelableArrayList("split_file_intents"));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract List<String> mo22159a();

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract List<String> mo22160b();

    public abstract long bytesDownloaded();

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public abstract List<Intent> mo22162c();

    public abstract int errorCode();

    @Deprecated
    public abstract PendingIntent resolutionIntent();

    public abstract int sessionId();

    public abstract int status();

    public abstract long totalBytesToDownload();
}
