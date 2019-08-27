
package com.shivam.giphyme.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Images {

    @SerializedName("preview_webp")
    @Expose
    private PreviewWebp previewWebp;


    @SerializedName("480w_still")
    @Expose
    private Still480 still480;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Images() {
    }

    public Images(PreviewWebp previewWebp, Still480 still480) {
        this.previewWebp = previewWebp;
        this.still480 = still480;
    }

    public PreviewWebp getPreviewWebp() {
        return previewWebp;
    }

    public void setPreviewWebp(PreviewWebp previewWebp) {
        this.previewWebp = previewWebp;
    }

    public Still480 getStill480() {
        return still480;
    }

    public void setStill480(Still480 still480) {
        this.still480 = still480;
    }

    @Override
    public String toString() {
        return "Images{" +
                "previewWebp=" + previewWebp +
                ", still480=" + still480 +
                '}';
    }
}
