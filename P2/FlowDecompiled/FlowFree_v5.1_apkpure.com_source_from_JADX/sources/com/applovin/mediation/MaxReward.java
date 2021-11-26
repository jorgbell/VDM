package com.applovin.mediation;

public class MaxReward {
    public static final int DEFAULT_AMOUNT = 0;
    public static final String DEFAULT_LABEL = "";

    /* renamed from: a */
    private final String f2554a;

    /* renamed from: b */
    private final int f2555b;

    private MaxReward(int i, String str) {
        if (i >= 0) {
            this.f2554a = str;
            this.f2555b = i;
            return;
        }
        throw new IllegalArgumentException("Reward amount must be greater than or equal to 0");
    }

    public static MaxReward create(int i, String str) {
        return new MaxReward(i, str);
    }

    public static MaxReward createDefault() {
        return create(0, "");
    }

    public final int getAmount() {
        return this.f2555b;
    }

    public final String getLabel() {
        return this.f2554a;
    }

    public String toString() {
        return "MaxReward{amount=" + this.f2555b + ", label='" + this.f2554a + '\'' + '}';
    }
}
