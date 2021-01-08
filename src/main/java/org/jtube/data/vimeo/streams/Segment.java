
package org.jtube.data.vimeo.streams;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "start",
        "end",
        "url",
        "size"
})
public class Segment {

    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();
    @JsonProperty("start")
    private double start;
    @JsonProperty("end")
    private double end;
    @JsonProperty("url")
    private String url;
    @JsonProperty("size")
    private int size;

    /**
     * No args constructor for use in serialization
     */
    public Segment() {
    }

    public Segment(double start, double end, String url, int size) {
        super();
        this.start = start;
        this.end = end;
        this.url = url;
        this.size = size;
    }

    @JsonProperty("start")
    public double getStart() {
        return start;
    }

    @JsonProperty("start")
    public void setStart(double start) {
        this.start = start;
    }

    public Segment withStart(double start) {
        this.start = start;
        return this;
    }

    @JsonProperty("end")
    public double getEnd() {
        return end;
    }

    @JsonProperty("end")
    public void setEnd(double end) {
        this.end = end;
    }

    public Segment withEnd(double end) {
        this.end = end;
        return this;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    public Segment withUrl(String url) {
        this.url = url;
        return this;
    }

    @JsonProperty("size")
    public int getSize() {
        return size;
    }

    @JsonProperty("size")
    public void setSize(int size) {
        this.size = size;
    }

    public Segment withSize(int size) {
        this.size = size;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Segment withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("start", start).append("end", end).append("url", url).append("size", size).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(start).append(end).append(additionalProperties).append(size).append(url).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Segment)) {
            return false;
        }
        Segment rhs = ((Segment) other);
        return new EqualsBuilder().append(start, rhs.start).append(end, rhs.end).append(additionalProperties, rhs.additionalProperties).append(size, rhs.size).append(url, rhs.url).isEquals();
    }

}
