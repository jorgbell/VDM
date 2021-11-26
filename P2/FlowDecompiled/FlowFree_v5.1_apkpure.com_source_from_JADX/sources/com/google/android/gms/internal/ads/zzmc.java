package com.google.android.gms.internal.ads;

import android.util.Log;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzmc {
    private static final int zzA = zzqj.zzl("sosn");
    private static final int zzB = zzqj.zzl("tvsh");
    private static final int zzC = zzqj.zzl("----");
    private static final String[] zzD = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};
    private static final int zza = zzqj.zzl("nam");
    private static final int zzb = zzqj.zzl("trk");
    private static final int zzc = zzqj.zzl("cmt");
    private static final int zzd = zzqj.zzl("day");
    private static final int zze = zzqj.zzl("ART");
    private static final int zzf = zzqj.zzl("too");
    private static final int zzg = zzqj.zzl("alb");
    private static final int zzh = zzqj.zzl("com");
    private static final int zzi = zzqj.zzl("wrt");
    private static final int zzj = zzqj.zzl("lyr");
    private static final int zzk = zzqj.zzl("gen");
    private static final int zzl = zzqj.zzl("covr");
    private static final int zzm = zzqj.zzl("gnre");
    private static final int zzn = zzqj.zzl("grp");
    private static final int zzo = zzqj.zzl("disk");
    private static final int zzp = zzqj.zzl("trkn");
    private static final int zzq = zzqj.zzl("tmpo");
    private static final int zzr = zzqj.zzl("cpil");
    private static final int zzs = zzqj.zzl("aART");
    private static final int zzt = zzqj.zzl("sonm");
    private static final int zzu = zzqj.zzl("soal");
    private static final int zzv = zzqj.zzl("soar");
    private static final int zzw = zzqj.zzl("soaa");
    private static final int zzx = zzqj.zzl("soco");
    private static final int zzy = zzqj.zzl("rtng");
    private static final int zzz = zzqj.zzl("pgap");

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035 A[Catch:{ all -> 0x01d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003c A[Catch:{ all -> 0x01d5 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzmy zza(com.google.android.gms.internal.ads.zzqc r13) {
        /*
            int r0 = r13.zzg()
            int r1 = r13.zzr()
            int r0 = r0 + r1
            int r1 = r13.zzr()
            int r2 = r1 >> 24
            r2 = r2 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = "und"
            java.lang.String r4 = "TCON"
            java.lang.String r5 = "MetadataUtil"
            r6 = 0
            r7 = 169(0xa9, float:2.37E-43)
            if (r2 == r7) goto L_0x01d8
            int r2 = zzm     // Catch:{ all -> 0x01d5 }
            r7 = -1
            if (r1 != r2) goto L_0x0045
            int r1 = zze(r13)     // Catch:{ all -> 0x01d5 }
            if (r1 <= 0) goto L_0x0032
            java.lang.String[] r2 = zzD     // Catch:{ all -> 0x01d5 }
            int r3 = r2.length     // Catch:{ all -> 0x01d5 }
            r3 = 148(0x94, float:2.07E-43)
            if (r1 > r3) goto L_0x0032
            int r1 = r1 + r7
            r1 = r2[r1]     // Catch:{ all -> 0x01d5 }
            goto L_0x0033
        L_0x0032:
            r1 = r6
        L_0x0033:
            if (r1 == 0) goto L_0x003c
            com.google.android.gms.internal.ads.zznh r2 = new com.google.android.gms.internal.ads.zznh     // Catch:{ all -> 0x01d5 }
            r2.<init>(r4, r6, r1)     // Catch:{ all -> 0x01d5 }
            r6 = r2
            goto L_0x0041
        L_0x003c:
            java.lang.String r1 = "Failed to parse standard genre code"
            android.util.Log.w(r5, r1)     // Catch:{ all -> 0x01d5 }
        L_0x0041:
            r13.zzi(r0)
            return r6
        L_0x0045:
            int r2 = zzo     // Catch:{ all -> 0x01d5 }
            if (r1 != r2) goto L_0x0053
            java.lang.String r2 = "TPOS"
            com.google.android.gms.internal.ads.zznh r1 = zzd(r1, r2, r13)     // Catch:{ all -> 0x01d5 }
            r13.zzi(r0)
            return r1
        L_0x0053:
            int r2 = zzp     // Catch:{ all -> 0x01d5 }
            if (r1 != r2) goto L_0x0061
            java.lang.String r2 = "TRCK"
            com.google.android.gms.internal.ads.zznh r1 = zzd(r1, r2, r13)     // Catch:{ all -> 0x01d5 }
            r13.zzi(r0)
            return r1
        L_0x0061:
            int r2 = zzq     // Catch:{ all -> 0x01d5 }
            r4 = 1
            r8 = 0
            if (r1 != r2) goto L_0x0071
            java.lang.String r2 = "TBPM"
            com.google.android.gms.internal.ads.zznf r1 = zzc(r1, r2, r13, r4, r8)     // Catch:{ all -> 0x01d5 }
            r13.zzi(r0)
            return r1
        L_0x0071:
            int r2 = zzr     // Catch:{ all -> 0x01d5 }
            if (r1 != r2) goto L_0x007f
            java.lang.String r2 = "TCMP"
            com.google.android.gms.internal.ads.zznf r1 = zzc(r1, r2, r13, r4, r4)     // Catch:{ all -> 0x01d5 }
            r13.zzi(r0)
            return r1
        L_0x007f:
            int r2 = zzl     // Catch:{ all -> 0x01d5 }
            r9 = 4
            if (r1 != r2) goto L_0x00dd
            int r1 = r13.zzr()     // Catch:{ all -> 0x01d5 }
            int r2 = r13.zzr()     // Catch:{ all -> 0x01d5 }
            int r3 = com.google.android.gms.internal.ads.zzlp.zzaH     // Catch:{ all -> 0x01d5 }
            if (r2 != r3) goto L_0x00d4
            int r2 = r13.zzr()     // Catch:{ all -> 0x01d5 }
            int r2 = com.google.android.gms.internal.ads.zzlp.zzf(r2)     // Catch:{ all -> 0x01d5 }
            r3 = 13
            r4 = 14
            if (r2 != r3) goto L_0x00a1
            java.lang.String r3 = "image/jpeg"
            goto L_0x00a9
        L_0x00a1:
            if (r2 != r4) goto L_0x00a8
            java.lang.String r3 = "image/png"
            r2 = 14
            goto L_0x00a9
        L_0x00a8:
            r3 = r6
        L_0x00a9:
            if (r3 != 0) goto L_0x00c2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d5 }
            r3 = 41
            r1.<init>(r3)     // Catch:{ all -> 0x01d5 }
            java.lang.String r3 = "Unrecognized cover art flags: "
            r1.append(r3)     // Catch:{ all -> 0x01d5 }
            r1.append(r2)     // Catch:{ all -> 0x01d5 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01d5 }
            android.util.Log.w(r5, r1)     // Catch:{ all -> 0x01d5 }
            goto L_0x00d9
        L_0x00c2:
            r13.zzj(r9)     // Catch:{ all -> 0x01d5 }
            int r1 = r1 + -16
            byte[] r2 = new byte[r1]     // Catch:{ all -> 0x01d5 }
            r13.zzk(r2, r8, r1)     // Catch:{ all -> 0x01d5 }
            com.google.android.gms.internal.ads.zznb r1 = new com.google.android.gms.internal.ads.zznb     // Catch:{ all -> 0x01d5 }
            r4 = 3
            r1.<init>(r3, r6, r4, r2)     // Catch:{ all -> 0x01d5 }
            r6 = r1
            goto L_0x00d9
        L_0x00d4:
            java.lang.String r1 = "Failed to parse cover art attribute"
            android.util.Log.w(r5, r1)     // Catch:{ all -> 0x01d5 }
        L_0x00d9:
            r13.zzi(r0)
            return r6
        L_0x00dd:
            int r2 = zzs     // Catch:{ all -> 0x01d5 }
            if (r1 != r2) goto L_0x00eb
            java.lang.String r2 = "TPE2"
            com.google.android.gms.internal.ads.zznh r1 = zzb(r1, r2, r13)     // Catch:{ all -> 0x01d5 }
            r13.zzi(r0)
            return r1
        L_0x00eb:
            int r2 = zzt     // Catch:{ all -> 0x01d5 }
            if (r1 != r2) goto L_0x00f9
            java.lang.String r2 = "TSOT"
            com.google.android.gms.internal.ads.zznh r1 = zzb(r1, r2, r13)     // Catch:{ all -> 0x01d5 }
            r13.zzi(r0)
            return r1
        L_0x00f9:
            int r2 = zzu     // Catch:{ all -> 0x01d5 }
            if (r1 != r2) goto L_0x0107
            java.lang.String r2 = "TSO2"
            com.google.android.gms.internal.ads.zznh r1 = zzb(r1, r2, r13)     // Catch:{ all -> 0x01d5 }
            r13.zzi(r0)
            return r1
        L_0x0107:
            int r2 = zzv     // Catch:{ all -> 0x01d5 }
            if (r1 != r2) goto L_0x0115
            java.lang.String r2 = "TSOA"
            com.google.android.gms.internal.ads.zznh r1 = zzb(r1, r2, r13)     // Catch:{ all -> 0x01d5 }
            r13.zzi(r0)
            return r1
        L_0x0115:
            int r2 = zzw     // Catch:{ all -> 0x01d5 }
            if (r1 != r2) goto L_0x0123
            java.lang.String r2 = "TSOP"
            com.google.android.gms.internal.ads.zznh r1 = zzb(r1, r2, r13)     // Catch:{ all -> 0x01d5 }
            r13.zzi(r0)
            return r1
        L_0x0123:
            int r2 = zzx     // Catch:{ all -> 0x01d5 }
            if (r1 != r2) goto L_0x0131
            java.lang.String r2 = "TSOC"
            com.google.android.gms.internal.ads.zznh r1 = zzb(r1, r2, r13)     // Catch:{ all -> 0x01d5 }
            r13.zzi(r0)
            return r1
        L_0x0131:
            int r2 = zzy     // Catch:{ all -> 0x01d5 }
            if (r1 != r2) goto L_0x013f
            java.lang.String r2 = "ITUNESADVISORY"
            com.google.android.gms.internal.ads.zznf r1 = zzc(r1, r2, r13, r8, r8)     // Catch:{ all -> 0x01d5 }
            r13.zzi(r0)
            return r1
        L_0x013f:
            int r2 = zzz     // Catch:{ all -> 0x01d5 }
            if (r1 != r2) goto L_0x014d
            java.lang.String r2 = "ITUNESGAPLESS"
            com.google.android.gms.internal.ads.zznf r1 = zzc(r1, r2, r13, r8, r4)     // Catch:{ all -> 0x01d5 }
            r13.zzi(r0)
            return r1
        L_0x014d:
            int r2 = zzA     // Catch:{ all -> 0x01d5 }
            if (r1 != r2) goto L_0x015b
            java.lang.String r2 = "TVSHOWSORT"
            com.google.android.gms.internal.ads.zznh r1 = zzb(r1, r2, r13)     // Catch:{ all -> 0x01d5 }
            r13.zzi(r0)
            return r1
        L_0x015b:
            int r2 = zzB     // Catch:{ all -> 0x01d5 }
            if (r1 != r2) goto L_0x0169
            java.lang.String r2 = "TVSHOW"
            com.google.android.gms.internal.ads.zznh r1 = zzb(r1, r2, r13)     // Catch:{ all -> 0x01d5 }
            r13.zzi(r0)
            return r1
        L_0x0169:
            int r2 = zzC     // Catch:{ all -> 0x01d5 }
            if (r1 != r2) goto L_0x0292
            r1 = r6
            r2 = r1
            r4 = -1
            r5 = -1
        L_0x0171:
            int r8 = r13.zzg()     // Catch:{ all -> 0x01d5 }
            if (r8 >= r0) goto L_0x01ab
            int r8 = r13.zzg()     // Catch:{ all -> 0x01d5 }
            int r10 = r13.zzr()     // Catch:{ all -> 0x01d5 }
            int r11 = r13.zzr()     // Catch:{ all -> 0x01d5 }
            r13.zzj(r9)     // Catch:{ all -> 0x01d5 }
            int r12 = com.google.android.gms.internal.ads.zzlp.zzaF     // Catch:{ all -> 0x01d5 }
            if (r11 != r12) goto L_0x0191
            int r10 = r10 + -12
            java.lang.String r1 = r13.zzw(r10)     // Catch:{ all -> 0x01d5 }
            goto L_0x0171
        L_0x0191:
            int r12 = com.google.android.gms.internal.ads.zzlp.zzaG     // Catch:{ all -> 0x01d5 }
            if (r11 != r12) goto L_0x019c
            int r10 = r10 + -12
            java.lang.String r2 = r13.zzw(r10)     // Catch:{ all -> 0x01d5 }
            goto L_0x0171
        L_0x019c:
            int r12 = com.google.android.gms.internal.ads.zzlp.zzaH     // Catch:{ all -> 0x01d5 }
            if (r11 != r12) goto L_0x01a1
            r5 = r10
        L_0x01a1:
            if (r11 == r12) goto L_0x01a4
            goto L_0x01a5
        L_0x01a4:
            r4 = r8
        L_0x01a5:
            int r10 = r10 + -12
            r13.zzj(r10)     // Catch:{ all -> 0x01d5 }
            goto L_0x0171
        L_0x01ab:
            java.lang.String r8 = "com.apple.iTunes"
            boolean r1 = r8.equals(r1)     // Catch:{ all -> 0x01d5 }
            if (r1 == 0) goto L_0x01d1
            java.lang.String r1 = "iTunSMPB"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x01d5 }
            if (r1 == 0) goto L_0x01d1
            if (r4 != r7) goto L_0x01be
            goto L_0x01d1
        L_0x01be:
            r13.zzi(r4)     // Catch:{ all -> 0x01d5 }
            r1 = 16
            r13.zzj(r1)     // Catch:{ all -> 0x01d5 }
            int r5 = r5 + -16
            java.lang.String r1 = r13.zzw(r5)     // Catch:{ all -> 0x01d5 }
            com.google.android.gms.internal.ads.zznd r6 = new com.google.android.gms.internal.ads.zznd     // Catch:{ all -> 0x01d5 }
            r6.<init>(r3, r2, r1)     // Catch:{ all -> 0x01d5 }
        L_0x01d1:
            r13.zzi(r0)
            return r6
        L_0x01d5:
            r1 = move-exception
            goto L_0x02c7
        L_0x01d8:
            r2 = 16777215(0xffffff, float:2.3509886E-38)
            r2 = r2 & r1
            int r7 = zzc     // Catch:{ all -> 0x01d5 }
            if (r2 != r7) goto L_0x021e
            int r2 = r13.zzr()     // Catch:{ all -> 0x01d5 }
            int r4 = r13.zzr()     // Catch:{ all -> 0x01d5 }
            int r7 = com.google.android.gms.internal.ads.zzlp.zzaH     // Catch:{ all -> 0x01d5 }
            if (r4 != r7) goto L_0x01fd
            r1 = 8
            r13.zzj(r1)     // Catch:{ all -> 0x01d5 }
            int r2 = r2 + -16
            java.lang.String r1 = r13.zzw(r2)     // Catch:{ all -> 0x01d5 }
            com.google.android.gms.internal.ads.zznd r6 = new com.google.android.gms.internal.ads.zznd     // Catch:{ all -> 0x01d5 }
            r6.<init>(r3, r1, r1)     // Catch:{ all -> 0x01d5 }
            goto L_0x021a
        L_0x01fd:
            java.lang.String r2 = "Failed to parse comment attribute: "
            java.lang.String r1 = com.google.android.gms.internal.ads.zzlp.zzg(r1)     // Catch:{ all -> 0x01d5 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x01d5 }
            int r3 = r1.length()     // Catch:{ all -> 0x01d5 }
            if (r3 == 0) goto L_0x0212
            java.lang.String r1 = r2.concat(r1)     // Catch:{ all -> 0x01d5 }
            goto L_0x0217
        L_0x0212:
            java.lang.String r1 = new java.lang.String     // Catch:{ all -> 0x01d5 }
            r1.<init>(r2)     // Catch:{ all -> 0x01d5 }
        L_0x0217:
            android.util.Log.w(r5, r1)     // Catch:{ all -> 0x01d5 }
        L_0x021a:
            r13.zzi(r0)
            return r6
        L_0x021e:
            int r3 = zza     // Catch:{ all -> 0x01d5 }
            if (r2 == r3) goto L_0x02bd
            int r3 = zzb     // Catch:{ all -> 0x01d5 }
            if (r2 != r3) goto L_0x0228
            goto L_0x02bd
        L_0x0228:
            int r3 = zzh     // Catch:{ all -> 0x01d5 }
            if (r2 == r3) goto L_0x02b3
            int r3 = zzi     // Catch:{ all -> 0x01d5 }
            if (r2 != r3) goto L_0x0232
            goto L_0x02b3
        L_0x0232:
            int r3 = zzd     // Catch:{ all -> 0x01d5 }
            if (r2 != r3) goto L_0x0240
            java.lang.String r2 = "TDRC"
            com.google.android.gms.internal.ads.zznh r1 = zzb(r1, r2, r13)     // Catch:{ all -> 0x01d5 }
            r13.zzi(r0)
            return r1
        L_0x0240:
            int r3 = zze     // Catch:{ all -> 0x01d5 }
            if (r2 != r3) goto L_0x024e
            java.lang.String r2 = "TPE1"
            com.google.android.gms.internal.ads.zznh r1 = zzb(r1, r2, r13)     // Catch:{ all -> 0x01d5 }
            r13.zzi(r0)
            return r1
        L_0x024e:
            int r3 = zzf     // Catch:{ all -> 0x01d5 }
            if (r2 != r3) goto L_0x025c
            java.lang.String r2 = "TSSE"
            com.google.android.gms.internal.ads.zznh r1 = zzb(r1, r2, r13)     // Catch:{ all -> 0x01d5 }
            r13.zzi(r0)
            return r1
        L_0x025c:
            int r3 = zzg     // Catch:{ all -> 0x01d5 }
            if (r2 != r3) goto L_0x026a
            java.lang.String r2 = "TALB"
            com.google.android.gms.internal.ads.zznh r1 = zzb(r1, r2, r13)     // Catch:{ all -> 0x01d5 }
            r13.zzi(r0)
            return r1
        L_0x026a:
            int r3 = zzj     // Catch:{ all -> 0x01d5 }
            if (r2 != r3) goto L_0x0278
            java.lang.String r2 = "USLT"
            com.google.android.gms.internal.ads.zznh r1 = zzb(r1, r2, r13)     // Catch:{ all -> 0x01d5 }
            r13.zzi(r0)
            return r1
        L_0x0278:
            int r3 = zzk     // Catch:{ all -> 0x01d5 }
            if (r2 != r3) goto L_0x0284
            com.google.android.gms.internal.ads.zznh r1 = zzb(r1, r4, r13)     // Catch:{ all -> 0x01d5 }
            r13.zzi(r0)
            return r1
        L_0x0284:
            int r3 = zzn     // Catch:{ all -> 0x01d5 }
            if (r2 != r3) goto L_0x0292
            java.lang.String r2 = "TIT1"
            com.google.android.gms.internal.ads.zznh r1 = zzb(r1, r2, r13)     // Catch:{ all -> 0x01d5 }
            r13.zzi(r0)
            return r1
        L_0x0292:
            java.lang.String r2 = "Skipped unknown metadata entry: "
            java.lang.String r1 = com.google.android.gms.internal.ads.zzlp.zzg(r1)     // Catch:{ all -> 0x01d5 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x01d5 }
            int r3 = r1.length()     // Catch:{ all -> 0x01d5 }
            if (r3 == 0) goto L_0x02a7
            java.lang.String r1 = r2.concat(r1)     // Catch:{ all -> 0x01d5 }
            goto L_0x02ac
        L_0x02a7:
            java.lang.String r1 = new java.lang.String     // Catch:{ all -> 0x01d5 }
            r1.<init>(r2)     // Catch:{ all -> 0x01d5 }
        L_0x02ac:
            android.util.Log.d(r5, r1)     // Catch:{ all -> 0x01d5 }
            r13.zzi(r0)
            return r6
        L_0x02b3:
            java.lang.String r2 = "TCOM"
            com.google.android.gms.internal.ads.zznh r1 = zzb(r1, r2, r13)     // Catch:{ all -> 0x01d5 }
            r13.zzi(r0)
            return r1
        L_0x02bd:
            java.lang.String r2 = "TIT2"
            com.google.android.gms.internal.ads.zznh r1 = zzb(r1, r2, r13)     // Catch:{ all -> 0x01d5 }
            r13.zzi(r0)
            return r1
        L_0x02c7:
            r13.zzi(r0)
            goto L_0x02cc
        L_0x02cb:
            throw r1
        L_0x02cc:
            goto L_0x02cb
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzmc.zza(com.google.android.gms.internal.ads.zzqc):com.google.android.gms.internal.ads.zzmy");
    }

    private static zznh zzb(int i, String str, zzqc zzqc) {
        int zzr2 = zzqc.zzr();
        if (zzqc.zzr() == zzlp.zzaH) {
            zzqc.zzj(8);
            return new zznh(str, (String) null, zzqc.zzw(zzr2 - 16));
        }
        String valueOf = String.valueOf(zzlp.zzg(i));
        Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse text attribute: ".concat(valueOf) : new String("Failed to parse text attribute: "));
        return null;
    }

    private static zznf zzc(int i, String str, zzqc zzqc, boolean z, boolean z2) {
        int zze2 = zze(zzqc);
        if (z2) {
            zze2 = Math.min(1, zze2);
        }
        if (zze2 < 0) {
            String valueOf = String.valueOf(zzlp.zzg(i));
            Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse uint8 attribute: ".concat(valueOf) : new String("Failed to parse uint8 attribute: "));
            return null;
        } else if (z) {
            return new zznh(str, (String) null, Integer.toString(zze2));
        } else {
            return new zznd("und", str, Integer.toString(zze2));
        }
    }

    private static zznh zzd(int i, String str, zzqc zzqc) {
        int zzr2 = zzqc.zzr();
        if (zzqc.zzr() == zzlp.zzaH && zzr2 >= 22) {
            zzqc.zzj(10);
            int zzm2 = zzqc.zzm();
            if (zzm2 > 0) {
                StringBuilder sb = new StringBuilder(11);
                sb.append(zzm2);
                String sb2 = sb.toString();
                int zzm3 = zzqc.zzm();
                if (zzm3 > 0) {
                    String valueOf = String.valueOf(sb2);
                    StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 12);
                    sb3.append(valueOf);
                    sb3.append("/");
                    sb3.append(zzm3);
                    sb2 = sb3.toString();
                }
                return new zznh(str, (String) null, sb2);
            }
        }
        String valueOf2 = String.valueOf(zzlp.zzg(i));
        Log.w("MetadataUtil", valueOf2.length() != 0 ? "Failed to parse index/count attribute: ".concat(valueOf2) : new String("Failed to parse index/count attribute: "));
        return null;
    }

    private static int zze(zzqc zzqc) {
        zzqc.zzj(4);
        if (zzqc.zzr() == zzlp.zzaH) {
            zzqc.zzj(8);
            return zzqc.zzl();
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }
}
