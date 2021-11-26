package com.google.firebase.crashlytics.ndk;

import java.io.File;

final class SessionFiles {
    public final File app;
    public final File device;
    public final File metadata;
    public final File minidump;

    /* renamed from: os */
    public final File f5332os;
    public final File session;

    static final class Builder {
        /* access modifiers changed from: private */
        public File app;
        /* access modifiers changed from: private */
        public File binaryImages;
        /* access modifiers changed from: private */
        public File device;
        /* access modifiers changed from: private */
        public File metadata;
        /* access modifiers changed from: private */
        public File minidump;
        /* access modifiers changed from: private */

        /* renamed from: os */
        public File f5333os;
        /* access modifiers changed from: private */
        public File session;

        Builder() {
        }

        /* access modifiers changed from: package-private */
        public Builder minidumpFile(File file) {
            this.minidump = file;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder metadataFile(File file) {
            this.metadata = file;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder sessionFile(File file) {
            this.session = file;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder appFile(File file) {
            this.app = file;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder deviceFile(File file) {
            this.device = file;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder osFile(File file) {
            this.f5333os = file;
            return this;
        }

        /* access modifiers changed from: package-private */
        public SessionFiles build() {
            return new SessionFiles(this);
        }
    }

    private SessionFiles(Builder builder) {
        this.minidump = builder.minidump;
        File unused = builder.binaryImages;
        this.metadata = builder.metadata;
        this.session = builder.session;
        this.app = builder.app;
        this.device = builder.device;
        this.f5332os = builder.f5333os;
    }
}
