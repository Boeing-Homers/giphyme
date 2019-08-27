
package com.shivam.giphyme.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GiphyResponse {

    @SerializedName("data")
    @Expose
    private List<Data> data = null;
    @SerializedName("pagination")
    @Expose
    private Pagination pagination;
    @SerializedName("meta")
    @Expose
    private Meta meta;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GiphyResponse() {
    }

    /**
     * 
     * @param data
     * @param pagination
     * @param meta
     */
    public GiphyResponse(List<Data> data, Pagination pagination, Meta meta) {
        super();
        this.data = data;
        this.pagination = pagination;
        this.meta = meta;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    @Override
    public String toString() {
        return "GiphyResponse{" +
                "data=" + data +
                ", pagination=" + pagination +
                ", meta=" + meta +
                '}';
    }
}
