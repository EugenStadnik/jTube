
package org.jtube.data.vimeo.playerData;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "scaling",
        "volume",
        "hd"
})
public class Cookie {

    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();
    @JsonProperty("scaling")
    private int scaling;
    @JsonProperty("volume")
    private double volume;
    @JsonProperty("hd")
    private int hd;

    /**
     * No args constructor for use in serialization
     */
    public Cookie() {
    }

    public Cookie(int scaling, double volume, int hd) {
        super();
        this.scaling = scaling;
        this.volume = volume;
        this.hd = hd;
    }

    @JsonProperty("scaling")
    public int getScaling() {
        return scaling;
    }

    @JsonProperty("scaling")
    public void setScaling(int scaling) {
        this.scaling = scaling;
    }

    public Cookie withScaling(int scaling) {
        this.scaling = scaling;
        return this;
    }

    @JsonProperty("volume")
    public double getVolume() {
        return volume;
    }

    @JsonProperty("volume")
    public void setVolume(double volume) {
        this.volume = volume;
    }

    public Cookie withVolume(double volume) {
        this.volume = volume;
        return this;
    }

    @JsonProperty("hd")
    public int getHd() {
        return hd;
    }

    @JsonProperty("hd")
    public void setHd(int hd) {
        this.hd = hd;
    }

    public Cookie withHd(int hd) {
        this.hd = hd;
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

    public Cookie withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("scaling", scaling).append("volume", volume).append("hd", hd).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(volume).append(scaling).append(additionalProperties).append(hd).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Cookie)) {
            return false;
        }
        Cookie rhs = ((Cookie) other);
        return new EqualsBuilder().append(volume, rhs.volume).append(scaling, rhs.scaling).append(additionalProperties, rhs.additionalProperties).append(hd, rhs.hd).isEquals();
    }

}
