package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
public class GetSignInIntentRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetSignInIntentRequest> CREATOR = new zzg();
    private String zzau;
    private final String zzax;
    private final String zzbd;

    GetSignInIntentRequest(String str, String str2, String str3) {
        Preconditions.checkNotNull(str);
        this.zzax = str;
        this.zzbd = str2;
        this.zzau = str3;
    }

    public String getServerClientId() {
        return this.zzax;
    }

    public String getHostedDomainFilter() {
        return this.zzbd;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getServerClientId(), false);
        SafeParcelWriter.writeString(parcel, 2, getHostedDomainFilter(), false);
        SafeParcelWriter.writeString(parcel, 3, this.zzau, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GetSignInIntentRequest)) {
            return false;
        }
        GetSignInIntentRequest getSignInIntentRequest = (GetSignInIntentRequest) obj;
        if (!Objects.equal(this.zzax, getSignInIntentRequest.zzax) || !Objects.equal(this.zzbd, getSignInIntentRequest.zzbd) || !Objects.equal(this.zzau, getSignInIntentRequest.zzau)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzax, this.zzbd, this.zzau);
    }
}
