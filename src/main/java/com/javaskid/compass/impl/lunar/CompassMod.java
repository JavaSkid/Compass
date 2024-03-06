package com.javaskid.compass.impl.lunar;

import com.google.common.collect.ImmutableList;
import com.javaskid.compass.impl.lunar.bogus.FakeCategory;
import com.javaskid.compass.impl.lunar.bogus.FakeFeatureDetails;
import com.javaskid.compass.impl.lunar.bogus.FakeMod;

public class CompassMod extends FakeMod {
    public CompassMod() {
        super(true);
    }

    @Override
    public void render() {

    }

    @Override
    protected FakeFeatureDetails getFeatureDetails() {
        return new FakeFeatureDetails("compass", ImmutableList.of(FakeCategory.ALL), "JavaSkid");
    }
}
