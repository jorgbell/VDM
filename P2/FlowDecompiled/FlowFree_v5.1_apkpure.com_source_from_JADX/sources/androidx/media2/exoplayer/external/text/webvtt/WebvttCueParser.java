package androidx.media2.exoplayer.external.text.webvtt;

import java.util.regex.Pattern;

public final class WebvttCueParser {
    public static final Pattern CUE_HEADER_PATTERN = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");

    static {
        Pattern.compile("(\\S+?):(\\S+)");
    }
}
