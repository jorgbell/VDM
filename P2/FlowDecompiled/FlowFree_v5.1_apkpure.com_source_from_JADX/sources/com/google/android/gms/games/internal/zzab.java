package com.google.android.gms.games.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.multiplayer.realtime.zzb;
import com.google.android.gms.games.video.VideoCapabilities;
import com.google.android.gms.internal.games.zza;
import com.google.android.gms.internal.games.zzd;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public abstract class zzab extends zza implements zzy {
    public zzab() {
        super("com.google.android.gms.games.internal.IGamesCallbacks");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 6001) {
            zze(parcel.readString());
        } else if (i == 6002) {
            zzf(parcel.readString());
        } else if (i == 12011) {
            zzb((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
        } else if (i == 12012) {
            zze(parcel.readInt(), parcel.readString());
        } else if (i == 13001) {
            zzan((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
        } else if (i == 13002) {
            zzd(parcel.readInt());
        } else if (i == 19001) {
            zza(parcel.readInt(), (VideoCapabilities) zzd.zza(parcel, VideoCapabilities.CREATOR));
        } else if (i != 19002) {
            switch (i) {
                case 5001:
                    zza(parcel.readInt(), parcel.readString());
                    break;
                case 5002:
                    zza((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                    break;
                case 5003:
                    zzb(parcel.readInt(), parcel.readString());
                    break;
                case 5004:
                    zzc((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                    break;
                case 5005:
                    Parcelable.Creator creator = DataHolder.CREATOR;
                    zza((DataHolder) zzd.zza(parcel, creator), (DataHolder) zzd.zza(parcel, creator));
                    break;
                case 5006:
                    zzd((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                    break;
                case 5007:
                    zze((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                    break;
                case 5008:
                    zzf((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                    break;
                case 5009:
                    zzg((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                    break;
                case 5010:
                    zzh((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                    break;
                case 5011:
                    zzi((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                    break;
                default:
                    switch (i) {
                        case 5016:
                            onSignOutComplete();
                            break;
                        case 5017:
                            zzk((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 5018:
                            zzs((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 5019:
                            zzt((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 5020:
                            zzd(parcel.readInt(), parcel.readString());
                            break;
                        case 5021:
                            zzu((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 5022:
                            zzv((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 5023:
                            zzw((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 5024:
                            zzx((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 5025:
                            zzy((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 5026:
                            zza((DataHolder) zzd.zza(parcel, DataHolder.CREATOR), parcel.createStringArray());
                            break;
                        case 5027:
                            zzb((DataHolder) zzd.zza(parcel, DataHolder.CREATOR), parcel.createStringArray());
                            break;
                        case 5028:
                            zzc((DataHolder) zzd.zza(parcel, DataHolder.CREATOR), parcel.createStringArray());
                            break;
                        case 5029:
                            zzd((DataHolder) zzd.zza(parcel, DataHolder.CREATOR), parcel.createStringArray());
                            break;
                        case 5030:
                            zze((DataHolder) zzd.zza(parcel, DataHolder.CREATOR), parcel.createStringArray());
                            break;
                        case 5031:
                            zzf((DataHolder) zzd.zza(parcel, DataHolder.CREATOR), parcel.createStringArray());
                            break;
                        case 5032:
                            zza((zzb) zzd.zza(parcel, zzb.CREATOR));
                            break;
                        case 5033:
                            zza(parcel.readInt(), parcel.readInt(), parcel.readString());
                            break;
                        case 5034:
                            zza(parcel.readInt(), parcel.readString(), zzd.zza(parcel));
                            break;
                        case 5035:
                            zzaa((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 5036:
                            zzb(parcel.readInt());
                            break;
                        case 5037:
                            zzl((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 5038:
                            zzz((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 5039:
                            zzab((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 5040:
                            zzc(parcel.readInt());
                            break;
                        case 9001:
                            zzj((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 11001:
                            zzc(parcel.readInt(), (Bundle) zzd.zza(parcel, Bundle.CREATOR));
                            break;
                        case 12001:
                            zzag((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 14001:
                            zza((DataHolder[]) parcel.createTypedArray(DataHolder.CREATOR));
                            break;
                        case 15001:
                            zzao((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 17002:
                            zze(parcel.readInt());
                            break;
                        case 19008:
                            zzf(parcel.readInt());
                            break;
                        case 19009:
                            zzg(parcel.readInt());
                            break;
                        case 19010:
                            zzh(parcel.readInt());
                            break;
                        case 20001:
                            zzap((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 20002:
                            zzaq((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 20003:
                            zzar((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 20004:
                            zzas((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 20005:
                            zzat((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 20006:
                            zzau((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 20007:
                            zzav((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 20008:
                            zzaw((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 20009:
                            zzax((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                            break;
                        case 20012:
                            zzb((Status) zzd.zza(parcel, Status.CREATOR));
                            break;
                        case 20019:
                            onCaptureOverlayStateChanged(parcel.readInt());
                            break;
                        case 20020:
                            zze(parcel.readInt(), (Bundle) zzd.zza(parcel, Bundle.CREATOR));
                            break;
                        case 23001:
                            zzm(parcel.readInt());
                            break;
                        case 23002:
                            zzi(parcel.readInt());
                            break;
                        case 23003:
                            zzj(parcel.readInt());
                            break;
                        case 23004:
                            zzk(parcel.readInt());
                            break;
                        case 23005:
                            zzl(parcel.readInt());
                            break;
                        case 24002:
                            zza(zzd.zza(parcel));
                            break;
                        case 25002:
                            zzg(parcel.readString());
                            break;
                        case 25003:
                            zza((Status) zzd.zza(parcel, Status.CREATOR), parcel.readString());
                            break;
                        default:
                            switch (i) {
                                case 8001:
                                    zzac((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                                    break;
                                case 8002:
                                    zza(parcel.readInt(), (Bundle) zzd.zza(parcel, Bundle.CREATOR));
                                    break;
                                case 8003:
                                    zzn((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                                    break;
                                case 8004:
                                    zzo((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                                    break;
                                case 8005:
                                    zzp((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                                    break;
                                case 8006:
                                    zzq((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                                    break;
                                case 8007:
                                    zzc(parcel.readInt(), parcel.readString());
                                    break;
                                case 8008:
                                    zzr((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                                    break;
                                case 8009:
                                    zzd(parcel.readString());
                                    break;
                                case 8010:
                                    zzb(parcel.readString());
                                    break;
                                default:
                                    switch (i) {
                                        case 10001:
                                            zzm((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                                            break;
                                        case 10002:
                                            zzc(parcel.readString());
                                            break;
                                        case 10003:
                                            zzad((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                                            break;
                                        case 10004:
                                            zzae((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                                            break;
                                        case 10005:
                                            zzb(parcel.readInt(), (Bundle) zzd.zza(parcel, Bundle.CREATOR));
                                            break;
                                        case 10006:
                                            zzaf((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                                            break;
                                        default:
                                            switch (i) {
                                                case 12004:
                                                    zza((DataHolder) zzd.zza(parcel, DataHolder.CREATOR), (Contents) zzd.zza(parcel, Contents.CREATOR));
                                                    break;
                                                case 12005:
                                                    zzah((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                                                    break;
                                                case 12006:
                                                    zzai((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                                                    break;
                                                case 12007:
                                                    zzaj((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                                                    break;
                                                case 12008:
                                                    zzam((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                                                    break;
                                                default:
                                                    switch (i) {
                                                        case 12014:
                                                            zzak((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                                                            break;
                                                        case 12015:
                                                            zzd(parcel.readInt(), (Bundle) zzd.zza(parcel, Bundle.CREATOR));
                                                            break;
                                                        case 12016:
                                                            zzal((DataHolder) zzd.zza(parcel, DataHolder.CREATOR));
                                                            break;
                                                        case 12017:
                                                            String readString = parcel.readString();
                                                            Parcelable.Creator creator2 = Contents.CREATOR;
                                                            zza((DataHolder) zzd.zza(parcel, DataHolder.CREATOR), readString, (Contents) zzd.zza(parcel, creator2), (Contents) zzd.zza(parcel, creator2), (Contents) zzd.zza(parcel, creator2));
                                                            break;
                                                        default:
                                                            return false;
                                                    }
                                            }
                                    }
                            }
                    }
            }
        } else {
            zza(parcel.readInt(), zzd.zza(parcel));
        }
        parcel2.writeNoException();
        return true;
    }
}
