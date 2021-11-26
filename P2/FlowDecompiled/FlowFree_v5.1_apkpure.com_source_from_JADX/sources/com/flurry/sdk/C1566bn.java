package com.flurry.sdk;

import com.flurry.sdk.C1654dd;
import com.flurry.sdk.C1659df;
import com.flurry.sdk.C1720ex;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Future;

/* renamed from: com.flurry.sdk.bn */
public abstract class C1566bn extends C1730f {

    /* renamed from: a */
    protected final String f3961a;

    /* renamed from: b */
    protected String f3962b;

    /* renamed from: d */
    protected C1565bm f3963d;

    /* renamed from: e */
    Set<String> f3964e = new HashSet();

    /* renamed from: f */
    public C1579bp f3965f;

    /* renamed from: g */
    private C1521av f3966g = C1913n.m4811a().f4723b;

    /* renamed from: h */
    private C1914o<C1519au> f3967h;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo11323a(int i, String str, String str2);

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public abstract String mo11329d();

    public C1566bn(String str, String str2) {
        super(str2, C1720ex.m4478a(C1720ex.C1722a.REPORTS));
        C15671 r0 = new C1914o<C1519au>() {
            /* renamed from: a */
            public final /* synthetic */ void mo11263a(Object obj) {
                C1519au auVar = (C1519au) obj;
                String str = C1566bn.this.f3961a;
                C1648cy.m4329c(str, "NetworkAvailabilityChanged : NetworkAvailable = " + auVar.f3825a);
                if (auVar.f3825a) {
                    C1566bn.this.mo11326b();
                }
            }
        };
        this.f3967h = r0;
        this.f3961a = str2;
        this.f3962b = "AnalyticsData_";
        this.f3966g.subscribe(r0);
        this.f3965f = new C1579bp(str);
    }

    /* renamed from: a */
    public final void mo11264a() {
        C1579bp bpVar = this.f3965f;
        String str = bpVar.f3993b;
        ArrayList<String> arrayList = new ArrayList<>();
        File fileStreamPath = C1536b.m4057a().getFileStreamPath(".FlurrySenderIndex.info.".concat(String.valueOf(str)));
        C1648cy.m4317a(5, "FlurryDataSenderIndex", "isOldIndexFilePresent: for " + str + fileStreamPath.exists());
        if (fileStreamPath.exists()) {
            List<String> a = bpVar.mo11334a(str);
            if (a != null && a.size() > 0) {
                arrayList.addAll(a);
                for (String b : arrayList) {
                    bpVar.mo11337b(b);
                }
            }
            C1579bp.m4127c(str);
        } else {
            List<C1585bq> list = (List) new C1906l(C1536b.m4057a().getFileStreamPath(C1579bp.m4128d(bpVar.f3993b)), str, 1, new C1693dv<List<C1585bq>>() {
                /* renamed from: a */
                public final com.flurry.sdk.C1688ds<java.util.List<com.flurry.sdk.C1585bq>> mo11281a(
/*
Method generation error in method: com.flurry.sdk.bp.1.a(int):com.flurry.sdk.ds<java.util.List<com.flurry.sdk.bq>>, dex: classes.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.flurry.sdk.bp.1.a(int):com.flurry.sdk.ds<java.util.List<com.flurry.sdk.bq>>, class status: UNLOADED
                	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:640)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:91)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:697)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:291)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:156)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                
*/
            }).mo11568a();
            if (list == null) {
                C1648cy.m4329c("FlurryDataSenderIndex", "New main file also not found. returning..");
                mo11326b();
            }
            for (C1585bq bqVar : list) {
                arrayList.add(bqVar.f4000a);
            }
        }
        for (String str2 : arrayList) {
            List<String> e = bpVar.mo11338e(str2);
            if (e != null && !e.isEmpty()) {
                bpVar.f3994c.put(str2, e);
            }
        }
        mo11326b();
    }

    /* renamed from: a */
    public final void mo11324a(C1565bm bmVar) {
        this.f3963d = bmVar;
    }

    /* renamed from: a */
    public final void mo11325a(final byte[] bArr, final String str, final String str2) {
        if (bArr == null || bArr.length == 0) {
            C1648cy.m4317a(6, this.f3961a, "Report that has to be sent is EMPTY or NULL");
            return;
        }
        runAsync(new C1702eb() {
            /* renamed from: a */
            public final void mo11257a() {
                C1566bn.this.mo11327b(bArr, str, str2);
            }
        });
        mo11326b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo11326b() {
        runAsync(new C1702eb() {
            /* renamed from: a */
            public final void mo11257a() {
                C1566bn.this.mo11328c();
            }
        });
    }

    /* JADX WARNING: type inference failed for: r6v8, types: [byte[], RequestObjectType] */
    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final void mo11328c() {
        if (!C1615c.m4214a()) {
            C1648cy.m4317a(5, this.f3961a, "Reports were not sent! No Internet connection!");
            return;
        }
        List<String> a = this.f3965f.mo11333a();
        if (a.isEmpty()) {
            C1648cy.m4317a(4, this.f3961a, "No more reports to send.");
            return;
        }
        for (final String next : a) {
            if (m4103e()) {
                List<String> f = this.f3965f.mo11339f(next);
                String str = this.f3961a;
                C1648cy.m4317a(4, str, "Number of not sent blocks = " + f.size());
                for (final String next2 : f) {
                    if (!this.f3964e.contains(next2)) {
                        if (!m4103e()) {
                            break;
                        }
                        C1574bo a2 = C1574bo.m4121b(next2).mo11568a();
                        if (a2 == null) {
                            C1648cy.m4317a(6, this.f3961a, "Internal ERROR! Cannot read!");
                            this.f3965f.mo11336a(next2, next);
                        } else {
                            ? r6 = a2.f3988b;
                            if (r6 == 0 || r6.length == 0) {
                                C1648cy.m4317a(6, this.f3961a, "Internal ERROR! Report is empty!");
                                this.f3965f.mo11336a(next2, next);
                            } else {
                                C1648cy.m4317a(5, this.f3961a, "Reading block info ".concat(String.valueOf(next2)));
                                this.f3964e.add(next2);
                                final String d = mo11329d();
                                String str2 = this.f3961a;
                                C1648cy.m4317a(4, str2, "FlurryDataSender: start upload data with id = " + next2 + " to " + d);
                                C1654dd ddVar = new C1654dd();
                                ddVar.f4187f = d;
                                ddVar.f4298p = 100000;
                                ddVar.f4188g = C1659df.C1662a.kPost;
                                ddVar.mo11438a("Content-Type", "application/octet-stream");
                                ddVar.mo11438a("X-Flurry-Api-Key", C1561bi.m4088a().mo11318b());
                                ddVar.f4174c = new C1682do();
                                ddVar.f4175d = new C1689dt();
                                ddVar.f4173b = r6;
                                C1477ac acVar = C1913n.m4811a().f4729h;
                                ddVar.f4195n = acVar != null && acVar.f3709e;
                                ddVar.f4172a = new C1654dd.C1656a<byte[], String>() {
                                    /* renamed from: a */
                                    public final /* synthetic */ void mo11330a(C1654dd ddVar, Object obj) {
                                        final String str = (String) obj;
                                        final int i = ddVar.f4194m;
                                        if (i != 200) {
                                            Future unused = C1566bn.this.runAsync(new C1702eb() {
                                                /* renamed from: a */
                                                public final void mo11257a() throws Exception {
                                                    C1566bn.this.mo11323a(i, C1566bn.m4101a(str), next2);
                                                }
                                            });
                                        }
                                        if ((i < 200 || i >= 300) && i != 400) {
                                            String str2 = C1566bn.this.f3961a;
                                            C1648cy.m4332e(str2, "Analytics report sent with error " + d);
                                            C1566bn bnVar = C1566bn.this;
                                            bnVar.runAsync(new C1702eb(next2) {

                                                /* renamed from: a */
                                                final /* synthetic */ String f3985a;

                                                {
                                                    this.f3985a = r2;
                                                }

                                                /* renamed from: a */
                                                public final void mo11257a() {
                                                    C1565bm bmVar = C1566bn.this.f3963d;
                                                    if (bmVar != null) {
                                                        bmVar.mo11322b();
                                                    }
                                                    if (!C1566bn.this.f3964e.remove(this.f3985a)) {
                                                        String str = C1566bn.this.f3961a;
                                                        C1648cy.m4317a(6, str, "Internal error. Block with id = " + this.f3985a + " was not in progress state");
                                                    }
                                                }
                                            });
                                            return;
                                        }
                                        String str3 = C1566bn.this.f3961a;
                                        C1648cy.m4332e(str3, "Analytics report sent to " + d);
                                        String str4 = C1566bn.this.f3961a;
                                        C1648cy.m4317a(3, str4, "FlurryDataSender: report " + next2 + " sent. HTTP response: " + i);
                                        String str5 = C1566bn.this.f3961a;
                                        StringBuilder sb = new StringBuilder("FlurryDataSender:");
                                        sb.append(C1566bn.m4101a(str));
                                        C1648cy.m4317a(3, str5, sb.toString());
                                        if (str != null) {
                                            C1648cy.m4317a(3, C1566bn.this.f3961a, "HTTP response: ".concat(String.valueOf(str)));
                                        }
                                        C1566bn bnVar2 = C1566bn.this;
                                        bnVar2.runAsync(new C1702eb(i, next2, next) {

                                            /* renamed from: a */
                                            final /* synthetic */ int f3981a;

                                            /* renamed from: b */
                                            final /* synthetic */ String f3982b;

                                            /* renamed from: c */
                                            final /* synthetic */ String f3983c;

                                            {
                                                this.f3981a = r2;
                                                this.f3982b = r3;
                                                this.f3983c = r4;
                                            }

                                            /* renamed from: a */
                                            public final void mo11257a() {
                                                C1565bm bmVar = C1566bn.this.f3963d;
                                                if (bmVar != null) {
                                                    if (this.f3981a == 200) {
                                                        bmVar.mo11321a();
                                                    } else {
                                                        bmVar.mo11322b();
                                                    }
                                                }
                                                if (!C1566bn.this.f3965f.mo11336a(this.f3982b, this.f3983c)) {
                                                    String str = C1566bn.this.f3961a;
                                                    C1648cy.m4317a(6, str, "Internal error. Block wasn't deleted with id = " + this.f3982b);
                                                }
                                                if (!C1566bn.this.f3964e.remove(this.f3982b)) {
                                                    String str2 = C1566bn.this.f3961a;
                                                    C1648cy.m4317a(6, str2, "Internal error. Block with id = " + this.f3982b + " was not in progress state");
                                                }
                                            }
                                        });
                                        C1566bn.this.mo11326b();
                                    }
                                };
                                C1638ct.m4301a().mo11424a(this, ddVar);
                            }
                        }
                    }
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: e */
    private boolean m4103e() {
        return m4104f() <= 5;
    }

    /* renamed from: f */
    private int m4104f() {
        return this.f3964e.size();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo11327b(byte[] bArr, String str, String str2) {
        String str3 = this.f3962b + str + "_" + str2;
        C1574bo boVar = new C1574bo(bArr);
        String str4 = boVar.f3987a;
        C1574bo.m4121b(str4).mo11569a(boVar);
        C1648cy.m4317a(5, this.f3961a, "Saving Block File " + str4 + " at " + C1536b.m4057a().getFileStreamPath(C1574bo.m4120a(str4)));
        this.f3965f.mo11335a(boVar, str3);
    }

    /* renamed from: a */
    static /* synthetic */ String m4101a(String str) {
        if (str != null && str.contains("<body>") && str.contains("</body>")) {
            return str.substring(str.indexOf("<body>") + 6, str.indexOf("</body>"));
        }
        StringBuilder sb = new StringBuilder("Can not parse http error message: ");
        if (str == null) {
            str = "NULL";
        }
        sb.append(str);
        return sb.toString();
    }
}
