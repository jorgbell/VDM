package com.applovin.impl.sdk.utils;

import android.util.Xml;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

/* renamed from: com.applovin.impl.sdk.utils.u */
public class C1167u {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1107r f2506a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Stack<C1169a> f2507b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public StringBuilder f2508c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public long f2509d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C1169a f2510e;

    /* renamed from: com.applovin.impl.sdk.utils.u$a */
    private static class C1169a extends C1166t {
        C1169a(String str, Map<String, String> map, C1166t tVar) {
            super(str, map, tVar);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo9716a(C1166t tVar) {
            if (tVar != null) {
                this.f2502c.add(tVar);
                return;
            }
            throw new IllegalArgumentException("None specified.");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo9717d(String str) {
            this.f2501b = str;
        }
    }

    C1167u(C1062k kVar) {
        if (kVar != null) {
            this.f2506a = kVar.mo9411z();
            return;
        }
        throw new IllegalArgumentException("No sdk specified.");
    }

    /* renamed from: a */
    public static C1166t m2781a(String str, C1062k kVar) throws SAXException {
        return new C1167u(kVar).mo9704a(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Map<String, String> m2784a(Attributes attributes) {
        if (attributes == null) {
            return Collections.emptyMap();
        }
        int length = attributes.getLength();
        HashMap hashMap = new HashMap(length);
        for (int i = 0; i < length; i++) {
            hashMap.put(attributes.getQName(i), attributes.getValue(i));
        }
        return hashMap;
    }

    /* renamed from: a */
    public C1166t mo9704a(String str) throws SAXException {
        if (str != null) {
            this.f2508c = new StringBuilder();
            this.f2507b = new Stack<>();
            this.f2510e = null;
            Xml.parse(str, new ContentHandler() {
                public void characters(char[] cArr, int i, int i2) {
                    String trim = new String(Arrays.copyOfRange(cArr, i, i2)).trim();
                    if (C1155o.m2673b(trim)) {
                        C1167u.this.f2508c.append(trim);
                    }
                }

                public void endDocument() {
                    long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) - C1167u.this.f2509d;
                    C1107r a = C1167u.this.f2506a;
                    a.mo9584b("XmlParser", "Finished parsing in " + seconds + " seconds");
                }

                public void endElement(String str, String str2, String str3) {
                    C1167u uVar = C1167u.this;
                    C1169a unused = uVar.f2510e = (C1169a) uVar.f2507b.pop();
                    C1167u.this.f2510e.mo9717d(C1167u.this.f2508c.toString().trim());
                    C1167u.this.f2508c.setLength(0);
                }

                public void endPrefixMapping(String str) {
                }

                public void ignorableWhitespace(char[] cArr, int i, int i2) {
                }

                public void processingInstruction(String str, String str2) {
                }

                public void setDocumentLocator(Locator locator) {
                }

                public void skippedEntity(String str) {
                }

                public void startDocument() {
                    C1167u.this.f2506a.mo9584b("XmlParser", "Begin parsing...");
                    long unused = C1167u.this.f2509d = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
                }

                public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
                    C1169a aVar = null;
                    try {
                        if (!C1167u.this.f2507b.isEmpty()) {
                            aVar = (C1169a) C1167u.this.f2507b.peek();
                        }
                        C1169a aVar2 = new C1169a(str2, C1167u.this.m2784a(attributes), aVar);
                        if (aVar != null) {
                            aVar.mo9716a(aVar2);
                        }
                        C1167u.this.f2507b.push(aVar2);
                    } catch (Exception e) {
                        C1107r a = C1167u.this.f2506a;
                        a.mo9585b("XmlParser", "Unable to process element <" + str2 + ">", e);
                        throw new SAXException("Failed to start element", e);
                    }
                }

                public void startPrefixMapping(String str, String str2) {
                }
            });
            C1169a aVar = this.f2510e;
            if (aVar != null) {
                return aVar;
            }
            throw new SAXException("Unable to parse XML into node");
        }
        throw new IllegalArgumentException("Unable to parse. No XML specified.");
    }
}
