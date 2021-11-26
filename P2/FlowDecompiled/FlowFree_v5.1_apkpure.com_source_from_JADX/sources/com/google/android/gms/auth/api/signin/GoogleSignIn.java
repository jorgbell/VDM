package com.google.android.gms.auth.api.signin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.api.signin.internal.zzi;
import com.google.android.gms.auth.api.signin.internal.zzq;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
public final class GoogleSignIn {
    public static GoogleSignInClient getClient(Context context, GoogleSignInOptions googleSignInOptions) {
        Preconditions.checkNotNull(googleSignInOptions);
        return new GoogleSignInClient(context, googleSignInOptions);
    }

    public static GoogleSignInClient getClient(Activity activity, GoogleSignInOptions googleSignInOptions) {
        Preconditions.checkNotNull(googleSignInOptions);
        return new GoogleSignInClient(activity, googleSignInOptions);
    }

    public static Task<GoogleSignInAccount> getSignedInAccountFromIntent(Intent intent) {
        GoogleSignInResult signInResultFromIntent = zzi.getSignInResultFromIntent(intent);
        if (signInResultFromIntent == null) {
            return Tasks.forException(ApiExceptionUtil.fromStatus(Status.RESULT_INTERNAL_ERROR));
        }
        GoogleSignInAccount signInAccount = signInResultFromIntent.getSignInAccount();
        if (!signInResultFromIntent.getStatus().isSuccess() || signInAccount == null) {
            return Tasks.forException(ApiExceptionUtil.fromStatus(signInResultFromIntent.getStatus()));
        }
        return Tasks.forResult(signInAccount);
    }

    public static GoogleSignInAccount getLastSignedInAccount(Context context) {
        return zzq.zzd(context).zzr();
    }
}
