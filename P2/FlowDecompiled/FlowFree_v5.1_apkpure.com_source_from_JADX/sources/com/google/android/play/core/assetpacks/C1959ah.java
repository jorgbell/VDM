package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.play.core.tasks.C2172i;

/* renamed from: com.google.android.play.core.assetpacks.ah */
final class C1959ah extends C1958ag<ParcelFileDescriptor> {
    C1959ah(C1963an anVar, C2172i<ParcelFileDescriptor> iVar) {
        super(anVar, iVar);
    }

    /* renamed from: e */
    public final void mo21848e(Bundle bundle, Bundle bundle2) throws RemoteException {
        super.mo21848e(bundle, bundle2);
        this.f4820a.mo22196e((ParcelFileDescriptor) bundle.getParcelable("chunk_file_descriptor"));
    }
}
