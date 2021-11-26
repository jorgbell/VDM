package okhttp3;

import com.mopub.mobileads.resource.DrawableConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class CipherSuite {
    private static final Map<String, CipherSuite> INSTANCES = new LinkedHashMap();
    static final Comparator<String> ORDER_BY_NAME = new Comparator<String>() {
        public int compare(String str, String str2) {
            int min = Math.min(str.length(), str2.length());
            int i = 4;
            while (i < min) {
                char charAt = str.charAt(i);
                char charAt2 = str2.charAt(i);
                if (charAt == charAt2) {
                    i++;
                } else if (charAt < charAt2) {
                    return -1;
                } else {
                    return 1;
                }
            }
            int length = str.length();
            int length2 = str2.length();
            if (length == length2) {
                return 0;
            }
            if (length < length2) {
                return -1;
            }
            return 1;
        }
    };
    public static final CipherSuite TLS_AES_128_CCM_SHA256 = init("TLS_AES_128_CCM_SHA256", 4868);
    public static final CipherSuite TLS_AES_128_GCM_SHA256 = init("TLS_AES_128_GCM_SHA256", 4865);
    public static final CipherSuite TLS_AES_256_CCM_8_SHA256 = init("TLS_AES_256_CCM_8_SHA256", 4869);
    public static final CipherSuite TLS_AES_256_GCM_SHA384 = init("TLS_AES_256_GCM_SHA384", 4866);
    public static final CipherSuite TLS_CHACHA20_POLY1305_SHA256 = init("TLS_CHACHA20_POLY1305_SHA256", 4867);
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256 = init("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384 = init("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256 = init("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA = init("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256 = init("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA = init("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384 = init("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
    public static final CipherSuite TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256 = init("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
    public static final CipherSuite TLS_RSA_WITH_3DES_EDE_CBC_SHA = init("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
    public static final CipherSuite TLS_RSA_WITH_AES_128_CBC_SHA = init("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
    public static final CipherSuite TLS_RSA_WITH_AES_128_GCM_SHA256 = init("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
    public static final CipherSuite TLS_RSA_WITH_AES_256_CBC_SHA = init("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
    public static final CipherSuite TLS_RSA_WITH_AES_256_GCM_SHA384 = init("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
    final String javaName;

    static {
        init("SSL_RSA_WITH_NULL_MD5", 1);
        init("SSL_RSA_WITH_NULL_SHA", 2);
        init("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
        init("SSL_RSA_WITH_RC4_128_MD5", 4);
        init("SSL_RSA_WITH_RC4_128_SHA", 5);
        init("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
        init("SSL_RSA_WITH_DES_CBC_SHA", 9);
        init("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
        init("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
        init("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
        init("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
        init("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
        init("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
        init("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
        init("SSL_DH_anon_WITH_RC4_128_MD5", 24);
        init("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
        init("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
        init("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
        init("TLS_KRB5_WITH_DES_CBC_SHA", 30);
        init("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
        init("TLS_KRB5_WITH_RC4_128_SHA", 32);
        init("TLS_KRB5_WITH_DES_CBC_MD5", 34);
        init("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
        init("TLS_KRB5_WITH_RC4_128_MD5", 36);
        init("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
        init("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
        init("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
        init("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
        init("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
        init("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
        init("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
        init("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
        init("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
        init("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
        init("TLS_RSA_WITH_NULL_SHA256", 59);
        init("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
        init("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
        init("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
        init("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
        init("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
        init("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
        init("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
        init("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
        init("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
        init("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
        init("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
        init("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);
        init("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
        init("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
        init("TLS_PSK_WITH_RC4_128_SHA", 138);
        init("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
        init("TLS_PSK_WITH_AES_128_CBC_SHA", 140);
        init("TLS_PSK_WITH_AES_256_CBC_SHA", 141);
        init("TLS_RSA_WITH_SEED_CBC_SHA", DrawableConstants.CtaButton.WIDTH_DIPS);
        init("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
        init("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);
        init("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
        init("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
        init("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);
        init("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
        init("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
        init("TLS_FALLBACK_SCSV", 22016);
        init("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
        init("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
        init("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
        init("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
        init("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
        init("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
        init("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
        init("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
        init("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
        init("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
        init("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
        init("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
        init("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
        init("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
        init("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
        init("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
        init("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
        init("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
        init("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
        init("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
        init("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
        init("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
        init("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
        init("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
        init("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
        init("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
        init("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
        init("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
        init("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
        init("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
        init("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
        init("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
        init("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
        init("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
        init("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
        init("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
        init("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
        init("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);
        init("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);
    }

    public static synchronized CipherSuite forJavaName(String str) {
        CipherSuite cipherSuite;
        synchronized (CipherSuite.class) {
            Map<String, CipherSuite> map = INSTANCES;
            cipherSuite = map.get(str);
            if (cipherSuite == null) {
                cipherSuite = map.get(secondaryName(str));
                if (cipherSuite == null) {
                    cipherSuite = new CipherSuite(str);
                }
                map.put(str, cipherSuite);
            }
        }
        return cipherSuite;
    }

    private static String secondaryName(String str) {
        if (str.startsWith("TLS_")) {
            return "SSL_" + str.substring(4);
        } else if (!str.startsWith("SSL_")) {
            return str;
        } else {
            return "TLS_" + str.substring(4);
        }
    }

    static List<CipherSuite> forJavaNames(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String forJavaName : strArr) {
            arrayList.add(forJavaName(forJavaName));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private CipherSuite(String str) {
        Objects.requireNonNull(str);
        this.javaName = str;
    }

    private static CipherSuite init(String str, int i) {
        CipherSuite cipherSuite = new CipherSuite(str);
        INSTANCES.put(str, cipherSuite);
        return cipherSuite;
    }

    public String toString() {
        return this.javaName;
    }
}
