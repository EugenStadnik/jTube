
package org.jtube.data.vimeo.playerData;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "hdr",
        "sdr"
})
public class Hevc {

    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();
    @JsonProperty("hdr")
    private List<Object> hdr = new ArrayList<>();
    @JsonProperty("sdr")
    private List<Object> sdr = new ArrayList<>();

    /**
     * No args constructor for use in serialization
     */
    public Hevc() {
    }

    public Hevc(List<Object> hdr, List<Object> sdr) {
        super();
        this.hdr = hdr;
        this.sdr = sdr;
    }

    @JsonProperty("hdr")
    public List<Object> getHdr() {
        return hdr;
    }

    @JsonProperty("hdr")
    public void setHdr(List<Object> hdr) {
        this.hdr = hdr;
    }

    public Hevc withHdr(List<Object> hdr) {
        this.hdr = hdr;
        return this;
    }

    @JsonProperty("sdr")
    public List<Object> getSdr() {
        return sdr;
    }

    @JsonProperty("sdr")
    public void setSdr(List<Object> sdr) {
        this.sdr = sdr;
    }

    public Hevc withSdr(List<Object> sdr) {
        this.sdr = sdr;
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

    public Hevc withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("hdr", hdr).append("sdr", sdr).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(sdr).append(additionalProperties).append(hdr).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Hevc)) {
            return false;
        }
        Hevc rhs = ((Hevc) other);
        return new EqualsBuilder().append(sdr, rhs.sdr).append(additionalProperties, rhs.additionalProperties).append(hdr, rhs.hdr).isEquals();
    }

}
