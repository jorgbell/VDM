package com.google.firebase.installations;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.firebase.installations.local.PersistedInstallationEntry;

class GetAuthTokenListener implements StateListener {
    private final TaskCompletionSource<InstallationTokenResult> resultTaskCompletionSource;
    private final Utils utils;

    public GetAuthTokenListener(Utils utils2, TaskCompletionSource<InstallationTokenResult> taskCompletionSource) {
        this.utils = utils2;
        this.resultTaskCompletionSource = taskCompletionSource;
    }

    public boolean onStateReached(PersistedInstallationEntry persistedInstallationEntry) {
        if (!persistedInstallationEntry.isRegistered() || this.utils.isAuthTokenExpired(persistedInstallationEntry)) {
            return false;
        }
        TaskCompletionSource<InstallationTokenResult> taskCompletionSource = this.resultTaskCompletionSource;
        InstallationTokenResult.Builder builder = InstallationTokenResult.builder();
        builder.setToken(persistedInstallationEntry.getAuthToken());
        builder.setTokenExpirationTimestamp(persistedInstallationEntry.getExpiresInSecs());
        builder.setTokenCreationTimestamp(persistedInstallationEntry.getTokenCreationEpochInSecs());
        taskCompletionSource.setResult(builder.build());
        return true;
    }

    public boolean onException(Exception exc) {
        this.resultTaskCompletionSource.trySetException(exc);
        return true;
    }
}
