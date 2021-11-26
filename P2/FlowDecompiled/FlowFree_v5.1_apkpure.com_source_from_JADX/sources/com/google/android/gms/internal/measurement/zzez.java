package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
final /* synthetic */ class zzez implements zzfp {
    private final Context zza;

    zzez(Context context) {
        this.zza = context;
    }

    public final Object zza() {
        zzfn zzfn;
        zzfn zzfn2;
        BufferedReader bufferedReader;
        Context context = this.zza;
        int i = zzfh.zzc;
        String str = Build.TYPE;
        String str2 = Build.TAGS;
        if ((!str.equals("eng") && !str.equals("userdebug")) || (!str2.contains("dev-keys") && !str2.contains("test-keys"))) {
            return zzfn.zzc();
        }
        if (zzek.zza() && !context.isDeviceProtectedStorage()) {
            context = context.createDeviceProtectedStorageContext();
        }
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            StrictMode.allowThreadDiskWrites();
            File file = new File(context.getDir("phenotype_hermetic", 0), "overrides.txt");
            zzfn = file.exists() ? zzfn.zzd(file) : zzfn.zzc();
        } catch (RuntimeException e) {
            Log.e("HermeticFileOverrides", "no data dir", e);
            zzfn = zzfn.zzc();
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th;
        }
        if (zzfn.zza()) {
            File file2 = (File) zzfn.zzb();
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file2)));
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String[] split = readLine.split(" ", 3);
                    if (split.length != 3) {
                        Log.e("HermeticFileOverrides", readLine.length() != 0 ? "Invalid: ".concat(readLine) : new String("Invalid: "));
                    } else {
                        String str3 = new String(split[0]);
                        String decode = Uri.decode(new String(split[1]));
                        String str4 = (String) hashMap2.get(split[2]);
                        if (str4 == null) {
                            String str5 = new String(split[2]);
                            str4 = Uri.decode(str5);
                            if (str4.length() < 1024 || str4 == str5) {
                                hashMap2.put(str5, str4);
                            }
                        }
                        if (!hashMap.containsKey(str3)) {
                            hashMap.put(str3, new HashMap());
                        }
                        ((Map) hashMap.get(str3)).put(decode, str4);
                    }
                }
                String valueOf = String.valueOf(file2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 7);
                sb.append("Parsed ");
                sb.append(valueOf);
                Log.i("HermeticFileOverrides", sb.toString());
                zzew zzew = new zzew(hashMap);
                bufferedReader.close();
                zzfn2 = zzfn.zzd(zzew);
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            } catch (Throwable th2) {
                zzga.zza(th, th2);
            }
        } else {
            zzfn2 = zzfn.zzc();
        }
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        return zzfn2;
        throw th;
    }
}
