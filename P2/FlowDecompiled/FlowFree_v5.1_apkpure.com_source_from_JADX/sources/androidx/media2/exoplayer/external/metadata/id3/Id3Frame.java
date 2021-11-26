package androidx.media2.exoplayer.external.metadata.id3;

import androidx.media2.exoplayer.external.metadata.Metadata;

public abstract class Id3Frame implements Metadata.Entry {

    /* renamed from: id */
    public final String f14id;

    public int describeContents() {
        return 0;
    }

    public Id3Frame(String str) {
        this.f14id = str;
    }

    public String toString() {
        return this.f14id;
    }
}
