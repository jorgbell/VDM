package com.google.android.gms.common.data;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public class DataBufferIterator<T> implements Iterator<T> {
    @RecentlyNonNull
    protected final DataBuffer<T> zaa;
    @RecentlyNonNull
    protected int zab = -1;

    public DataBufferIterator(@RecentlyNonNull DataBuffer<T> dataBuffer) {
        Preconditions.checkNotNull(dataBuffer);
        this.zaa = dataBuffer;
    }

    @RecentlyNonNull
    public boolean hasNext() {
        return this.zab < this.zaa.getCount() - 1;
    }

    @RecentlyNonNull
    public T next() {
        if (hasNext()) {
            DataBuffer<T> dataBuffer = this.zaa;
            int i = this.zab + 1;
            this.zab = i;
            return dataBuffer.get(i);
        }
        int i2 = this.zab;
        StringBuilder sb = new StringBuilder(46);
        sb.append("Cannot advance the iterator beyond ");
        sb.append(i2);
        throw new NoSuchElementException(sb.toString());
    }

    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
