package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* renamed from: com.google.android.play.core.internal.u */
public abstract class C2116u extends C2111k implements C2117v {
    public C2116u() {
        super("com.google.android.play.core.assetpacks.protocol.IAssetModuleServiceCallback");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo22022a(int i, Parcel parcel) throws RemoteException {
        switch (i) {
            case 2:
                mo21845b(parcel.readInt(), (Bundle) C2112l.m5293a(parcel, Bundle.CREATOR));
                return true;
            case 3:
                int readInt = parcel.readInt();
                Bundle bundle = (Bundle) C2112l.m5293a(parcel, Bundle.CREATOR);
                mo21851h(readInt);
                return true;
            case 4:
                int readInt2 = parcel.readInt();
                Bundle bundle2 = (Bundle) C2112l.m5293a(parcel, Bundle.CREATOR);
                mo21853j(readInt2);
                return true;
            case 5:
                mo21846c(parcel.createTypedArrayList(Bundle.CREATOR));
                return true;
            case 6:
                Parcelable.Creator creator = Bundle.CREATOR;
                Bundle bundle3 = (Bundle) C2112l.m5293a(parcel, creator);
                mo21854k((Bundle) C2112l.m5293a(parcel, creator));
                return true;
            case 7:
                mo21850g((Bundle) C2112l.m5293a(parcel, Bundle.CREATOR));
                return true;
            case 8:
                Parcelable.Creator creator2 = Bundle.CREATOR;
                Bundle bundle4 = (Bundle) C2112l.m5293a(parcel, creator2);
                mo21855l((Bundle) C2112l.m5293a(parcel, creator2));
                return true;
            case 10:
                Parcelable.Creator creator3 = Bundle.CREATOR;
                Bundle bundle5 = (Bundle) C2112l.m5293a(parcel, creator3);
                mo21856m((Bundle) C2112l.m5293a(parcel, creator3));
                return true;
            case 11:
                Parcelable.Creator creator4 = Bundle.CREATOR;
                mo21847d((Bundle) C2112l.m5293a(parcel, creator4), (Bundle) C2112l.m5293a(parcel, creator4));
                return true;
            case 12:
                Parcelable.Creator creator5 = Bundle.CREATOR;
                mo21848e((Bundle) C2112l.m5293a(parcel, creator5), (Bundle) C2112l.m5293a(parcel, creator5));
                return true;
            case 13:
                Parcelable.Creator creator6 = Bundle.CREATOR;
                mo21849f((Bundle) C2112l.m5293a(parcel, creator6), (Bundle) C2112l.m5293a(parcel, creator6));
                return true;
            case 14:
                Parcelable.Creator creator7 = Bundle.CREATOR;
                Bundle bundle6 = (Bundle) C2112l.m5293a(parcel, creator7);
                Bundle bundle7 = (Bundle) C2112l.m5293a(parcel, creator7);
                mo21857n();
                return true;
            case 15:
                Bundle bundle8 = (Bundle) C2112l.m5293a(parcel, Bundle.CREATOR);
                mo21852i();
                return true;
            default:
                return false;
        }
    }
}
