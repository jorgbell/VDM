package androidx.media2.exoplayer.external.decoder;

public abstract class Buffer {
    private int flags;

    public void clear() {
        this.flags = 0;
    }

    public final boolean isDecodeOnly() {
        return getFlag(Integer.MIN_VALUE);
    }

    public final boolean isEndOfStream() {
        return getFlag(4);
    }

    public final boolean isKeyFrame() {
        return getFlag(1);
    }

    public final void setFlags(int i) {
        this.flags = i;
    }

    public final void addFlag(int i) {
        this.flags = i | this.flags;
    }

    /* access modifiers changed from: protected */
    public final boolean getFlag(int i) {
        return (this.flags & i) == i;
    }
}