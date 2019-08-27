
package com.shivam.giphyme.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pagination {

    @SerializedName("total_count")
    @Expose
    private Integer totalCount;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("offset")
    @Expose
    private Integer offset;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Pagination() {
    }

    /**
     * 
     * @param count
     * @param totalCount
     * @param offset
     */
    public Pagination(Integer totalCount, Integer count, Integer offset) {
        super();
        this.totalCount = totalCount;
        this.count = count;
        this.offset = offset;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @Override
    public String toString() {
        return "Pagination{" +
                "totalCount=" + totalCount +
                ", count=" + count +
                ", offset=" + offset +
                '}';
    }
}
