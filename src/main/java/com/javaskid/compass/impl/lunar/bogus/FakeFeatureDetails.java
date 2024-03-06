package com.javaskid.compass.impl.lunar.bogus;

import java.util.Arrays;
import java.util.List;

public class FakeFeatureDetails {

    private String id;
    private List<FakeCategory> categories;
    private boolean enabledOnCurrentVersion = true;
    private boolean hidden = false;
    private List<String> aliases;
    private List<String> authors;
    public FakeFeatureDetails(String id, List<FakeCategory> categories, String ... authors) {
        this.id = id;
        this.categories = categories;
        this.authors = Arrays.asList(authors);
    }
}
