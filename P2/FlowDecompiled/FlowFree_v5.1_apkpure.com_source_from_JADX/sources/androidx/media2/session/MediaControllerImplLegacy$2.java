package androidx.media2.session;

import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.media2.session.futures.ResolvableFuture;

class MediaControllerImplLegacy$2 extends ResultReceiver {
    final /* synthetic */ ResolvableFuture val$result;

    /* access modifiers changed from: protected */
    public void onReceiveResult(int i, Bundle bundle) {
        this.val$result.set(new SessionResult(i, bundle));
        throw null;
    }
}
