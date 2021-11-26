package com.flurry.android;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.flurry.sdk.C1714eh;
import com.flurry.sdk.C1716ei;
import com.mopub.common.Constants;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Locale;

public interface FlurryPrivacySession {

    public interface Callback {
        void failure();

        void success();
    }

    public static class Request implements C1714eh.C1715a {

        /* renamed from: a */
        final String f3567a;

        /* renamed from: b */
        final String f3568b;

        /* renamed from: c */
        final String f3569c;
        public final Callback callback;
        public final Context context;
        public final String verifier;

        public Request(Context context2, Callback callback2) {
            String str;
            this.context = context2;
            this.callback = callback2;
            this.f3568b = context2.getPackageName();
            String a = C1716ei.C1718b.m4473a();
            this.verifier = a;
            MessageDigest a2 = C1716ei.C1717a.m4472a("SHA-256");
            if (a2 != null) {
                a2.update(a.getBytes(Charset.defaultCharset()));
                str = Base64.encodeToString(a2.digest(), 11);
            } else {
                str = "";
            }
            this.f3567a = str;
            Locale locale = Locale.getDefault();
            String language = locale.getLanguage();
            language = TextUtils.isEmpty(language) ? C1714eh.C1715a.f4312e : language;
            String country = locale.getCountry();
            country = TextUtils.isEmpty(country) ? C1714eh.C1715a.f4311d : country;
            this.f3569c = language + "-" + country;
        }
    }

    /* renamed from: com.flurry.android.FlurryPrivacySession$a */
    public static class C1435a {

        /* renamed from: a */
        public final Uri f3570a;

        public C1435a(String str, long j, Request request) {
            this.f3570a = new Uri.Builder().scheme(Constants.HTTPS).authority("flurry.mydashboard.oath.com").appendQueryParameter("device_session_id", str).appendQueryParameter("expires_in", String.valueOf(j)).appendQueryParameter("device_verifier", request.f3567a).appendQueryParameter("lang", request.f3569c).build();
        }
    }
}
