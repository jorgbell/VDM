package com.google.android.gms.games.event;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.zzb;

@UsedByReflection("GamesGmsClientImpl.java")
/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public final class EventEntity extends zzb implements Event {
    @RecentlyNonNull
    public static final Parcelable.Creator<EventEntity> CREATOR = new zza();
    private final String description;
    private final String name;
    private final long value;
    private final PlayerEntity zzcr;
    private final String zzcx;
    private final String zzcy;
    private final boolean zzcz;
    private final Uri zzm;
    private final String zzx;

    public EventEntity(@RecentlyNonNull Event event) {
        this.zzcx = event.getEventId();
        this.name = event.getName();
        this.description = event.getDescription();
        this.zzm = event.getIconImageUri();
        this.zzx = event.getIconImageUrl();
        this.zzcr = (PlayerEntity) event.getPlayer().freeze();
        this.value = event.getValue();
        this.zzcy = event.getFormattedValue();
        this.zzcz = event.isVisible();
    }

    EventEntity(String str, String str2, String str3, Uri uri, String str4, Player player, long j, String str5, boolean z) {
        this.zzcx = str;
        this.name = str2;
        this.description = str3;
        this.zzm = uri;
        this.zzx = str4;
        this.zzcr = new PlayerEntity(player);
        this.value = j;
        this.zzcy = str5;
        this.zzcz = z;
    }

    @RecentlyNonNull
    public final String getEventId() {
        return this.zzcx;
    }

    @RecentlyNonNull
    public final String getName() {
        return this.name;
    }

    @RecentlyNonNull
    public final String getDescription() {
        return this.description;
    }

    @RecentlyNonNull
    public final Uri getIconImageUri() {
        return this.zzm;
    }

    @RecentlyNonNull
    public final String getIconImageUrl() {
        return this.zzx;
    }

    @RecentlyNonNull
    public final Player getPlayer() {
        return this.zzcr;
    }

    public final long getValue() {
        return this.value;
    }

    @RecentlyNonNull
    public final String getFormattedValue() {
        return this.zzcy;
    }

    public final boolean isVisible() {
        return this.zzcz;
    }

    public final int hashCode() {
        return zza(this);
    }

    static int zza(Event event) {
        return Objects.hashCode(event.getEventId(), event.getName(), event.getDescription(), event.getIconImageUri(), event.getIconImageUrl(), event.getPlayer(), Long.valueOf(event.getValue()), event.getFormattedValue(), Boolean.valueOf(event.isVisible()));
    }

    public final boolean equals(@RecentlyNonNull Object obj) {
        return zza(this, obj);
    }

    static boolean zza(Event event, Object obj) {
        if (!(obj instanceof Event)) {
            return false;
        }
        if (event == obj) {
            return true;
        }
        Event event2 = (Event) obj;
        return Objects.equal(event2.getEventId(), event.getEventId()) && Objects.equal(event2.getName(), event.getName()) && Objects.equal(event2.getDescription(), event.getDescription()) && Objects.equal(event2.getIconImageUri(), event.getIconImageUri()) && Objects.equal(event2.getIconImageUrl(), event.getIconImageUrl()) && Objects.equal(event2.getPlayer(), event.getPlayer()) && Objects.equal(Long.valueOf(event2.getValue()), Long.valueOf(event.getValue())) && Objects.equal(event2.getFormattedValue(), event.getFormattedValue()) && Objects.equal(Boolean.valueOf(event2.isVisible()), Boolean.valueOf(event.isVisible()));
    }

    @RecentlyNonNull
    public final String toString() {
        return zzb(this);
    }

    static String zzb(Event event) {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper(event);
        stringHelper.add("Id", event.getEventId());
        stringHelper.add("Name", event.getName());
        stringHelper.add("Description", event.getDescription());
        stringHelper.add("IconImageUri", event.getIconImageUri());
        stringHelper.add("IconImageUrl", event.getIconImageUrl());
        stringHelper.add("Player", event.getPlayer());
        stringHelper.add("Value", Long.valueOf(event.getValue()));
        stringHelper.add("FormattedValue", event.getFormattedValue());
        stringHelper.add("isVisible", Boolean.valueOf(event.isVisible()));
        return stringHelper.toString();
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getEventId(), false);
        SafeParcelWriter.writeString(parcel, 2, getName(), false);
        SafeParcelWriter.writeString(parcel, 3, getDescription(), false);
        SafeParcelWriter.writeParcelable(parcel, 4, getIconImageUri(), i, false);
        SafeParcelWriter.writeString(parcel, 5, getIconImageUrl(), false);
        SafeParcelWriter.writeParcelable(parcel, 6, getPlayer(), i, false);
        SafeParcelWriter.writeLong(parcel, 7, getValue());
        SafeParcelWriter.writeString(parcel, 8, getFormattedValue(), false);
        SafeParcelWriter.writeBoolean(parcel, 9, isVisible());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
