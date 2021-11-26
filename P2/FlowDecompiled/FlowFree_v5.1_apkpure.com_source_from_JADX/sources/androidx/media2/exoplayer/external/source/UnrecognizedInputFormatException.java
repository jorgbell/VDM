package androidx.media2.exoplayer.external.source;

import android.net.Uri;
import androidx.media2.exoplayer.external.ParserException;

public class UnrecognizedInputFormatException extends ParserException {
    public UnrecognizedInputFormatException(String str, Uri uri) {
        super(str);
    }
}
