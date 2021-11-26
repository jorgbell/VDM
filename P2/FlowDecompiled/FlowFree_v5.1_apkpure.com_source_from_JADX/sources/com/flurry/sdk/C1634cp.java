package com.flurry.sdk;

import com.flurry.sdk.C1618cc;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import javax.net.ssl.SSLException;

/* renamed from: com.flurry.sdk.cp */
public abstract class C1634cp implements Runnable {

    /* renamed from: a */
    protected String f4130a;

    /* renamed from: b */
    protected C1618cc f4131b;

    /* renamed from: c */
    protected String f4132c;

    /* renamed from: d */
    protected String f4133d;

    /* renamed from: e */
    protected String f4134e;

    /* renamed from: f */
    protected String f4135f;

    /* renamed from: g */
    protected String f4136g;

    /* renamed from: h */
    public String f4137h;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract InputStream mo11408a() throws IOException;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo11409a(String str) {
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo11410b();

    /* renamed from: c */
    public boolean mo11411c() {
        return true;
    }

    public void run() {
        C1618cc ccVar = C1618cc.f4084a;
        this.f4131b = ccVar;
        InputStream inputStream = null;
        try {
            inputStream = mo11408a();
            if (this.f4131b != ccVar) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        C1648cy.m4318a(5, "Transport", e.getMessage(), e);
                    }
                }
                mo11410b();
            } else if (inputStream == null) {
                C1648cy.m4325b("Transport", "Null InputStream");
                this.f4131b = new C1618cc(C1618cc.C1619a.IO, "Null InputStream");
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        C1648cy.m4318a(5, "Transport", e2.getMessage(), e2);
                    }
                }
                mo11410b();
            } else {
                ReadableByteChannel newChannel = Channels.newChannel(inputStream);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                WritableByteChannel newChannel2 = Channels.newChannel(byteArrayOutputStream);
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(16384);
                while (true) {
                    if (newChannel.read(allocateDirect) < 0) {
                        if (allocateDirect.position() <= 0) {
                            break;
                        }
                    }
                    allocateDirect.flip();
                    newChannel2.write(allocateDirect);
                    allocateDirect.compact();
                }
                byteArrayOutputStream.flush();
                if (!mo11409a(byteArrayOutputStream.toString())) {
                    this.f4131b = new C1618cc(C1618cc.C1619a.AUTHENTICATE, "Signature Error.");
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                            C1648cy.m4318a(5, "Transport", e3.getMessage(), e3);
                        }
                    }
                    mo11410b();
                    return;
                }
                this.f4137h = new String(byteArrayOutputStream.toByteArray(), "utf-8");
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        C1648cy.m4318a(5, "Transport", e4.getMessage(), e4);
                    }
                }
                mo11410b();
            }
        } catch (MalformedURLException e5) {
            this.f4131b = new C1618cc(C1618cc.C1619a.OTHER, e5.toString());
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e6) {
                    C1648cy.m4318a(5, "Transport", e6.getMessage(), e6);
                }
            }
            mo11410b();
        } catch (SSLException e7) {
            C1648cy.m4320a("Transport", e7.getMessage(), (Throwable) e7);
            this.f4131b = new C1618cc(C1618cc.C1619a.UNKNOWN_CERTIFICATE, e7.toString());
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e8) {
                    C1648cy.m4318a(5, "Transport", e8.getMessage(), e8);
                }
            }
            mo11410b();
        } catch (IOException e9) {
            C1648cy.m4320a("Transport", e9.getMessage(), (Throwable) e9);
            this.f4131b = new C1618cc(C1618cc.C1619a.IO, e9.toString());
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e10) {
                    C1648cy.m4318a(5, "Transport", e10.getMessage(), e10);
                }
            }
            mo11410b();
        } catch (Exception e11) {
            this.f4131b = new C1618cc(C1618cc.C1619a.OTHER, e11.toString());
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e12) {
                    C1648cy.m4318a(5, "Transport", e12.getMessage(), e12);
                }
            }
            mo11410b();
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e13) {
                    C1648cy.m4318a(5, "Transport", e13.getMessage(), e13);
                }
            }
            mo11410b();
            throw th;
        }
    }

    /* renamed from: d */
    public final String mo11412d() {
        return this.f4132c;
    }

    /* renamed from: e */
    public final String mo11413e() {
        return this.f4133d;
    }

    /* renamed from: f */
    public final String mo11414f() {
        return this.f4135f;
    }

    /* renamed from: g */
    public final String mo11415g() {
        return this.f4136g;
    }

    /* renamed from: h */
    public final C1618cc mo11416h() {
        return this.f4131b;
    }
}
