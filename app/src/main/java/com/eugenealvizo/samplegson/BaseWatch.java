package com.eugenealvizo.samplegson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eugene on 5/18/17.
 */

public class BaseWatch {

    @SerializedName("watches")
    @Expose
    private List<Watch> watches = new ArrayList<>();

    public List<Watch> getWatches() {
        return watches;
    }

    public void setWatches(List<Watch> watches) {
        this.watches = watches;
    }
}
