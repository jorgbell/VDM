package com.google.firebase.platforminfo;

import android.content.Context;
import com.google.firebase.components.Component;
import com.google.firebase.components.Dependency;

public class LibraryVersionComponent {

    public interface VersionExtractor<T> {
        String extract(T t);
    }

    public static Component<?> create(String str, String str2) {
        return Component.intoSet(LibraryVersion.create(str, str2), LibraryVersion.class);
    }

    public static Component<?> fromContext(String str, VersionExtractor<Context> versionExtractor) {
        Component.Builder<LibraryVersion> intoSetBuilder = Component.intoSetBuilder(LibraryVersion.class);
        intoSetBuilder.add(Dependency.required(Context.class));
        intoSetBuilder.factory(LibraryVersionComponent$$Lambda$1.lambdaFactory$(str, versionExtractor));
        return intoSetBuilder.build();
    }
}
