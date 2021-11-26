package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.zabk;
import com.google.android.gms.common.api.internal.zacb;
import com.google.android.gms.common.api.internal.zax;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public class GoogleApi<O extends Api.ApiOptions> {
    private final Context zaa;
    private final Api<O> zac;
    private final O zad;
    private final ApiKey<O> zae;
    private final Looper zaf;
    private final int zag;
    @NotOnlyInitialized
    private final GoogleApiClient zah;
    private final StatusExceptionMapper zai;
    private final GoogleApiManager zaj;

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    public static class Settings {
        @RecentlyNonNull
        public static final Settings DEFAULT_SETTINGS = new Builder().build();
        @RecentlyNonNull
        public final StatusExceptionMapper zaa;
        @RecentlyNonNull
        public final Looper zab;

        /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
        public static class Builder {
            private StatusExceptionMapper zaa;
            private Looper zab;

            @RecentlyNonNull
            public Builder setMapper(@RecentlyNonNull StatusExceptionMapper statusExceptionMapper) {
                Preconditions.checkNotNull(statusExceptionMapper, "StatusExceptionMapper must not be null.");
                this.zaa = statusExceptionMapper;
                return this;
            }

            @RecentlyNonNull
            public Builder setLooper(@RecentlyNonNull Looper looper) {
                Preconditions.checkNotNull(looper, "Looper must not be null.");
                this.zab = looper;
                return this;
            }

            @RecentlyNonNull
            public Settings build() {
                if (this.zaa == null) {
                    this.zaa = new ApiExceptionMapper();
                }
                if (this.zab == null) {
                    this.zab = Looper.getMainLooper();
                }
                return new Settings(this.zaa, this.zab);
            }
        }

        private Settings(StatusExceptionMapper statusExceptionMapper, Account account, Looper looper) {
            this.zaa = statusExceptionMapper;
            this.zab = looper;
        }
    }

    public GoogleApi(@RecentlyNonNull Activity activity, @RecentlyNonNull Api<O> api, @RecentlyNonNull O o, @RecentlyNonNull Settings settings) {
        Preconditions.checkNotNull(activity, "Null activity is not permitted.");
        Preconditions.checkNotNull(api, "Api must not be null.");
        Preconditions.checkNotNull(settings, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context applicationContext = activity.getApplicationContext();
        this.zaa = applicationContext;
        zaa(activity);
        this.zac = api;
        this.zad = o;
        this.zaf = settings.zab;
        ApiKey<O> sharedApiKey = ApiKey.getSharedApiKey(api, o);
        this.zae = sharedApiKey;
        this.zah = new zabk(this);
        GoogleApiManager zaa2 = GoogleApiManager.zaa(applicationContext);
        this.zaj = zaa2;
        this.zag = zaa2.zab();
        this.zai = settings.zaa;
        if (!(activity instanceof GoogleApiActivity) && Looper.myLooper() == Looper.getMainLooper()) {
            zax.zaa(activity, zaa2, sharedApiKey);
        }
        zaa2.zaa((GoogleApi<?>) this);
    }

    public GoogleApi(@RecentlyNonNull Context context, @RecentlyNonNull Api<O> api, @RecentlyNonNull O o, @RecentlyNonNull Settings settings) {
        Preconditions.checkNotNull(context, "Null context is not permitted.");
        Preconditions.checkNotNull(api, "Api must not be null.");
        Preconditions.checkNotNull(settings, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context applicationContext = context.getApplicationContext();
        this.zaa = applicationContext;
        zaa(context);
        this.zac = api;
        this.zad = o;
        this.zaf = settings.zab;
        this.zae = ApiKey.getSharedApiKey(api, o);
        this.zah = new zabk(this);
        GoogleApiManager zaa2 = GoogleApiManager.zaa(applicationContext);
        this.zaj = zaa2;
        this.zag = zaa2.zab();
        this.zai = settings.zaa;
        zaa2.zaa((GoogleApi<?>) this);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GoogleApi(@androidx.annotation.RecentlyNonNull android.app.Activity r2, @androidx.annotation.RecentlyNonNull com.google.android.gms.common.api.Api<O> r3, @androidx.annotation.RecentlyNonNull O r4, @androidx.annotation.RecentlyNonNull com.google.android.gms.common.api.internal.StatusExceptionMapper r5) {
        /*
            r1 = this;
            com.google.android.gms.common.api.GoogleApi$Settings$Builder r0 = new com.google.android.gms.common.api.GoogleApi$Settings$Builder
            r0.<init>()
            r0.setMapper(r5)
            android.os.Looper r5 = r2.getMainLooper()
            r0.setLooper(r5)
            com.google.android.gms.common.api.GoogleApi$Settings r5 = r0.build()
            r1.<init>((android.app.Activity) r2, r3, r4, (com.google.android.gms.common.api.GoogleApi.Settings) r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.GoogleApi.<init>(android.app.Activity, com.google.android.gms.common.api.Api, com.google.android.gms.common.api.Api$ApiOptions, com.google.android.gms.common.api.internal.StatusExceptionMapper):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GoogleApi(@androidx.annotation.RecentlyNonNull android.content.Context r2, @androidx.annotation.RecentlyNonNull com.google.android.gms.common.api.Api<O> r3, @androidx.annotation.RecentlyNonNull O r4, @androidx.annotation.RecentlyNonNull com.google.android.gms.common.api.internal.StatusExceptionMapper r5) {
        /*
            r1 = this;
            com.google.android.gms.common.api.GoogleApi$Settings$Builder r0 = new com.google.android.gms.common.api.GoogleApi$Settings$Builder
            r0.<init>()
            r0.setMapper(r5)
            com.google.android.gms.common.api.GoogleApi$Settings r5 = r0.build()
            r1.<init>((android.content.Context) r2, r3, r4, (com.google.android.gms.common.api.GoogleApi.Settings) r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.GoogleApi.<init>(android.content.Context, com.google.android.gms.common.api.Api, com.google.android.gms.common.api.Api$ApiOptions, com.google.android.gms.common.api.internal.StatusExceptionMapper):void");
    }

    private final <A extends Api.AnyClient, T extends BaseImplementation$ApiMethodImpl<? extends Result, A>> T zaa(int i, T t) {
        t.zab();
        this.zaj.zaa(this, i, t);
        return t;
    }

    private final <TResult, A extends Api.AnyClient> Task<TResult> zaa(int i, TaskApiCall<A, TResult> taskApiCall) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zaj.zaa(this, i, taskApiCall, taskCompletionSource, this.zai);
        return taskCompletionSource.getTask();
    }

    @RecentlyNonNull
    public <A extends Api.AnyClient, T extends BaseImplementation$ApiMethodImpl<? extends Result, A>> T doRead(@RecentlyNonNull T t) {
        zaa(0, t);
        return t;
    }

    @RecentlyNonNull
    public <TResult, A extends Api.AnyClient> Task<TResult> doRead(@RecentlyNonNull TaskApiCall<A, TResult> taskApiCall) {
        return zaa(0, taskApiCall);
    }

    @RecentlyNonNull
    public <A extends Api.AnyClient, T extends BaseImplementation$ApiMethodImpl<? extends Result, A>> T doWrite(@RecentlyNonNull T t) {
        zaa(1, t);
        return t;
    }

    @RecentlyNonNull
    public <TResult, A extends Api.AnyClient> Task<TResult> doWrite(@RecentlyNonNull TaskApiCall<A, TResult> taskApiCall) {
        return zaa(1, taskApiCall);
    }

    public final Api.Client zaa(Looper looper, GoogleApiManager.zaa<O> zaa2) {
        ClientSettings build = createClientSettingsBuilder().build();
        Api.AbstractClientBuilder<?, O> zab = this.zac.zab();
        Preconditions.checkNotNull(zab);
        return zab.buildClient(this.zaa, looper, build, this.zad, (GoogleApiClient.ConnectionCallbacks) zaa2, (GoogleApiClient.OnConnectionFailedListener) zaa2);
    }

    @RecentlyNonNull
    public O getApiOptions() {
        return this.zad;
    }

    @RecentlyNonNull
    public ApiKey<O> getApiKey() {
        return this.zae;
    }

    @RecentlyNonNull
    public final int zaa() {
        return this.zag;
    }

    @RecentlyNonNull
    public GoogleApiClient asGoogleApiClient() {
        return this.zah;
    }

    @RecentlyNonNull
    public Looper getLooper() {
        return this.zaf;
    }

    @RecentlyNonNull
    public Context getApplicationContext() {
        return this.zaa;
    }

    /* access modifiers changed from: protected */
    @RecentlyNonNull
    public ClientSettings.Builder createClientSettingsBuilder() {
        Account account;
        Set<Scope> set;
        GoogleSignInAccount googleSignInAccount;
        GoogleSignInAccount googleSignInAccount2;
        ClientSettings.Builder builder = new ClientSettings.Builder();
        O o = this.zad;
        if (!(o instanceof Api.ApiOptions.HasGoogleSignInAccountOptions) || (googleSignInAccount2 = ((Api.ApiOptions.HasGoogleSignInAccountOptions) o).getGoogleSignInAccount()) == null) {
            O o2 = this.zad;
            account = o2 instanceof Api.ApiOptions.HasAccountOptions ? ((Api.ApiOptions.HasAccountOptions) o2).getAccount() : null;
        } else {
            account = googleSignInAccount2.getAccount();
        }
        builder.zaa(account);
        O o3 = this.zad;
        if (!(o3 instanceof Api.ApiOptions.HasGoogleSignInAccountOptions) || (googleSignInAccount = ((Api.ApiOptions.HasGoogleSignInAccountOptions) o3).getGoogleSignInAccount()) == null) {
            set = Collections.emptySet();
        } else {
            set = googleSignInAccount.getRequestedScopes();
        }
        builder.zaa((Collection<Scope>) set);
        builder.zaa(this.zaa.getClass().getName());
        builder.setRealClientPackageName(this.zaa.getPackageName());
        return builder;
    }

    private static String zaa(Object obj) {
        if (!PlatformVersion.isAtLeastR()) {
            return null;
        }
        try {
            return (String) Context.class.getMethod("getAttributionTag", new Class[0]).invoke(obj, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    public final zacb zaa(Context context, Handler handler) {
        return new zacb(context, handler, createClientSettingsBuilder().build());
    }
}
