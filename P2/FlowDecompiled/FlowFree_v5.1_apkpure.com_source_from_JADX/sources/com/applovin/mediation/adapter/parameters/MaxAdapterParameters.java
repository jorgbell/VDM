package com.applovin.mediation.adapter.parameters;

import android.os.Bundle;

public interface MaxAdapterParameters {
    Bundle getServerParameters();

    Boolean hasUserConsent();

    Boolean isAgeRestrictedUser();

    Boolean isDoNotSell();

    boolean isTesting();
}
