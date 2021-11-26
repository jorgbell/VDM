package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.games.internal.zzf;
import com.google.android.gms.internal.games.zzaq;
import com.google.android.gms.internal.games.zzdg;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public final class Games {
    @RecentlyNonNull
    @Deprecated
    public static final Api<GamesOptions> API;
    static final Api.ClientKey<zzf> CLIENT_KEY;
    private static final Api.AbstractClientBuilder<zzf, GamesOptions> zzaf;
    private static final Api.AbstractClientBuilder<zzf, GamesOptions> zzag;

    /* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
    private static abstract class zza extends Api.AbstractClientBuilder<zzf, GamesOptions> {
        private zza() {
        }

        public /* synthetic */ Api.Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            GamesOptions gamesOptions = (GamesOptions) obj;
            if (gamesOptions == null) {
                gamesOptions = new GamesOptions.Builder((zze) null).build();
            }
            return new zzf(context, looper, clientSettings, gamesOptions, connectionCallbacks, onConnectionFailedListener);
        }

        /* synthetic */ zza(zze zze) {
            this();
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
    public static final class GamesOptions implements Api.ApiOptions.HasGoogleSignInAccountOptions, Api.ApiOptions {
        public final boolean zzaj;
        public final boolean zzak;
        public final int zzal;
        public final boolean zzam;
        public final int zzan;
        @RecentlyNonNull
        public final String zzao;
        @RecentlyNonNull
        public final ArrayList<String> zzap;
        public final boolean zzaq;
        public final boolean zzar;
        @RecentlyNonNull
        public final GoogleSignInAccount zzas;
        @RecentlyNonNull
        public final String zzat;
        /* access modifiers changed from: private */
        public final int zzau;
        public final int zzav;
        public final int zzaw;

        private GamesOptions(boolean z, boolean z2, int i, boolean z3, int i2, String str, ArrayList<String> arrayList, boolean z4, boolean z5, GoogleSignInAccount googleSignInAccount, String str2, int i3, int i4, int i5) {
            this.zzaj = z;
            this.zzak = z2;
            this.zzal = i;
            this.zzam = z3;
            this.zzan = i2;
            this.zzao = str;
            this.zzap = arrayList;
            this.zzaq = z4;
            this.zzar = z5;
            this.zzas = googleSignInAccount;
            this.zzat = str2;
            this.zzau = i3;
            this.zzav = i4;
            this.zzaw = i5;
        }

        /* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
        public static final class Builder {
            private boolean zzaj;
            private boolean zzak;
            private int zzal;
            private boolean zzam;
            private int zzan;
            private String zzao;
            private ArrayList<String> zzap;
            private boolean zzaq;
            private boolean zzar;
            GoogleSignInAccount zzas;
            private String zzat;
            private int zzau;
            private int zzav;
            private int zzaw;

            private Builder() {
                this.zzaj = false;
                this.zzak = true;
                this.zzal = 17;
                this.zzam = false;
                this.zzan = 4368;
                this.zzao = null;
                this.zzap = new ArrayList<>();
                this.zzaq = false;
                this.zzar = false;
                this.zzas = null;
                this.zzat = null;
                this.zzau = 0;
                this.zzav = 8;
                this.zzaw = 0;
            }

            private Builder(GamesOptions gamesOptions) {
                this.zzaj = false;
                this.zzak = true;
                this.zzal = 17;
                this.zzam = false;
                this.zzan = 4368;
                this.zzao = null;
                this.zzap = new ArrayList<>();
                this.zzaq = false;
                this.zzar = false;
                this.zzas = null;
                this.zzat = null;
                this.zzau = 0;
                this.zzav = 8;
                this.zzaw = 0;
                if (gamesOptions != null) {
                    this.zzaj = gamesOptions.zzaj;
                    this.zzak = gamesOptions.zzak;
                    this.zzal = gamesOptions.zzal;
                    this.zzam = gamesOptions.zzam;
                    this.zzan = gamesOptions.zzan;
                    this.zzao = gamesOptions.zzao;
                    this.zzap = gamesOptions.zzap;
                    this.zzaq = gamesOptions.zzaq;
                    this.zzar = gamesOptions.zzar;
                    this.zzas = gamesOptions.zzas;
                    this.zzat = gamesOptions.zzat;
                    this.zzau = gamesOptions.zzau;
                    this.zzav = gamesOptions.zzav;
                    this.zzaw = gamesOptions.zzaw;
                }
            }

            @RecentlyNonNull
            public final Builder setSdkVariant(int i) {
                this.zzan = i;
                return this;
            }

            @RecentlyNonNull
            public final GamesOptions build() {
                return new GamesOptions(this.zzaj, this.zzak, this.zzal, this.zzam, this.zzan, this.zzao, this.zzap, this.zzaq, this.zzar, this.zzas, this.zzat, this.zzau, this.zzav, this.zzaw, (zze) null);
            }

            /* synthetic */ Builder(zze zze) {
                this();
            }

            /* synthetic */ Builder(GamesOptions gamesOptions, zze zze) {
                this(gamesOptions);
            }

            static {
                new AtomicInteger(0);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x002a, code lost:
            r1 = r4.zzao;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0051, code lost:
            r1 = r4.zzas;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(@androidx.annotation.RecentlyNonNull java.lang.Object r5) {
            /*
                r4 = this;
                r0 = 1
                if (r5 != r4) goto L_0x0004
                return r0
            L_0x0004:
                boolean r1 = r5 instanceof com.google.android.gms.games.Games.GamesOptions
                r2 = 0
                if (r1 != 0) goto L_0x000a
                return r2
            L_0x000a:
                com.google.android.gms.games.Games$GamesOptions r5 = (com.google.android.gms.games.Games.GamesOptions) r5
                boolean r1 = r4.zzaj
                boolean r3 = r5.zzaj
                if (r1 != r3) goto L_0x007f
                boolean r1 = r4.zzak
                boolean r3 = r5.zzak
                if (r1 != r3) goto L_0x007f
                int r1 = r4.zzal
                int r3 = r5.zzal
                if (r1 != r3) goto L_0x007f
                boolean r1 = r4.zzam
                boolean r3 = r5.zzam
                if (r1 != r3) goto L_0x007f
                int r1 = r4.zzan
                int r3 = r5.zzan
                if (r1 != r3) goto L_0x007f
                java.lang.String r1 = r4.zzao
                if (r1 != 0) goto L_0x0033
                java.lang.String r1 = r5.zzao
                if (r1 != 0) goto L_0x007f
                goto L_0x003b
            L_0x0033:
                java.lang.String r3 = r5.zzao
                boolean r1 = r1.equals(r3)
                if (r1 == 0) goto L_0x007f
            L_0x003b:
                java.util.ArrayList<java.lang.String> r1 = r4.zzap
                java.util.ArrayList<java.lang.String> r3 = r5.zzap
                boolean r1 = r1.equals(r3)
                if (r1 == 0) goto L_0x007f
                boolean r1 = r4.zzaq
                boolean r3 = r5.zzaq
                if (r1 != r3) goto L_0x007f
                boolean r1 = r4.zzar
                boolean r3 = r5.zzar
                if (r1 != r3) goto L_0x007f
                com.google.android.gms.auth.api.signin.GoogleSignInAccount r1 = r4.zzas
                if (r1 != 0) goto L_0x005a
                com.google.android.gms.auth.api.signin.GoogleSignInAccount r1 = r5.zzas
                if (r1 != 0) goto L_0x007f
                goto L_0x0062
            L_0x005a:
                com.google.android.gms.auth.api.signin.GoogleSignInAccount r3 = r5.zzas
                boolean r1 = r1.equals(r3)
                if (r1 == 0) goto L_0x007f
            L_0x0062:
                java.lang.String r1 = r4.zzat
                java.lang.String r3 = r5.zzat
                boolean r1 = android.text.TextUtils.equals(r1, r3)
                if (r1 == 0) goto L_0x007f
                int r1 = r4.zzau
                int r3 = r5.zzau
                if (r1 != r3) goto L_0x007f
                int r1 = r4.zzav
                int r3 = r5.zzav
                if (r1 != r3) goto L_0x007f
                int r1 = r4.zzaw
                int r5 = r5.zzaw
                if (r1 != r5) goto L_0x007f
                return r0
            L_0x007f:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.games.Games.GamesOptions.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i = ((((((((((this.zzaj ? 1 : 0) + true) * 31) + (this.zzak ? 1 : 0)) * 31) + this.zzal) * 31) + (this.zzam ? 1 : 0)) * 31) + this.zzan) * 31;
            String str = this.zzao;
            int i2 = 0;
            int hashCode = (((((((i + (str == null ? 0 : str.hashCode())) * 31) + this.zzap.hashCode()) * 31) + (this.zzaq ? 1 : 0)) * 31) + (this.zzar ? 1 : 0)) * 31;
            GoogleSignInAccount googleSignInAccount = this.zzas;
            int hashCode2 = (hashCode + (googleSignInAccount == null ? 0 : googleSignInAccount.hashCode())) * 31;
            String str2 = this.zzat;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            return ((((((hashCode2 + i2) * 31) + this.zzau) * 31) + this.zzav) * 31) + this.zzaw;
        }

        @RecentlyNonNull
        public final Bundle zzj() {
            Bundle bundle = new Bundle();
            bundle.putBoolean("com.google.android.gms.games.key.isHeadless", this.zzaj);
            bundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", this.zzak);
            bundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", this.zzal);
            bundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", this.zzam);
            bundle.putInt("com.google.android.gms.games.key.sdkVariant", this.zzan);
            bundle.putString("com.google.android.gms.games.key.forceResolveAccountKey", this.zzao);
            bundle.putStringArrayList("com.google.android.gms.games.key.proxyApis", this.zzap);
            bundle.putBoolean("com.google.android.gms.games.key.unauthenticated", this.zzaq);
            bundle.putBoolean("com.google.android.gms.games.key.skipWelcomePopup", this.zzar);
            bundle.putParcelable("com.google.android.gms.games.key.googleSignInAccount", this.zzas);
            bundle.putString("com.google.android.gms.games.key.realClientPackageName", this.zzat);
            bundle.putInt("com.google.android.gms.games.key.API_VERSION", this.zzav);
            bundle.putInt("com.google.android.gms.games.key.authenticationStrategy", this.zzaw);
            return bundle;
        }

        @RecentlyNonNull
        public static Builder zza(@RecentlyNonNull GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
            Builder builder = new Builder((GamesOptions) null, (zze) null);
            builder.zzas = googleSignInAccount;
            return builder;
        }

        @RecentlyNonNull
        public final GoogleSignInAccount getGoogleSignInAccount() {
            return this.zzas;
        }

        /* synthetic */ GamesOptions(boolean z, boolean z2, int i, boolean z3, int i2, String str, ArrayList arrayList, boolean z4, boolean z5, GoogleSignInAccount googleSignInAccount, String str2, int i3, int i4, int i5, zze zze) {
            this(z, z2, i, z3, i2, str, arrayList, z4, z5, googleSignInAccount, str2, i3, i4, i5);
        }
    }

    private static GamesOptions zza(GoogleSignInAccount googleSignInAccount) {
        GamesOptions.Builder zza2 = GamesOptions.zza(googleSignInAccount, (GamesOptions) null);
        zza2.setSdkVariant(1052947);
        return zza2.build();
    }

    @RecentlyNonNull
    public static AchievementsClient getAchievementsClient(@RecentlyNonNull Context context, @RecentlyNonNull GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new com.google.android.gms.internal.games.zzf(context, zza(googleSignInAccount));
    }

    @RecentlyNonNull
    public static SnapshotsClient getSnapshotsClient(@RecentlyNonNull Context context, @RecentlyNonNull GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zzdg(context, zza(googleSignInAccount));
    }

    @RecentlyNonNull
    public static GamesClient getGamesClient(@RecentlyNonNull Activity activity, @RecentlyNonNull GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zzaq(activity, zza(googleSignInAccount));
    }

    static {
        Api.ClientKey<zzf> clientKey = new Api.ClientKey<>();
        CLIENT_KEY = clientKey;
        zze zze = new zze();
        zzaf = zze;
        zzg zzg = new zzg();
        zzag = zzg;
        new Scope("https://www.googleapis.com/auth/games");
        new Scope("https://www.googleapis.com/auth/games_lite");
        new Scope("https://www.googleapis.com/auth/drive.appdata");
        API = new Api<>("Games.API", zze, clientKey);
        new Scope("https://www.googleapis.com/auth/games.firstparty");
        new Api("Games.API_1P", zzg, clientKey);
    }
}
