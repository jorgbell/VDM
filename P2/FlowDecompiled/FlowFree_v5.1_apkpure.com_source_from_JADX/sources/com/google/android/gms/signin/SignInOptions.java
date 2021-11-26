package com.google.android.gms.signin;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class SignInOptions implements Api.ApiOptions {
    @RecentlyNonNull
    public static final SignInOptions zaa = new SignInOptions(false, false, (String) null, false, (String) null, (String) null, false, (Long) null, (Long) null);

    private SignInOptions(boolean z, boolean z2, String str, boolean z3, String str2, String str3, boolean z4, Long l, Long l2) {
    }

    @RecentlyNonNull
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SignInOptions)) {
            return false;
        }
        SignInOptions signInOptions = (SignInOptions) obj;
        return Objects.equal((Object) null, (Object) null) && Objects.equal((Object) null, (Object) null) && Objects.equal((Object) null, (Object) null) && Objects.equal((Object) null, (Object) null) && Objects.equal((Object) null, (Object) null);
    }

    @RecentlyNonNull
    public final int hashCode() {
        Boolean bool = Boolean.FALSE;
        return Objects.hashCode(bool, bool, null, bool, bool, null, null, null, null);
    }
}
