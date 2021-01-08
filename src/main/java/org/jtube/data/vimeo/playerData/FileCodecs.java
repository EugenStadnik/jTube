
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
        "hevc",
        "av1",
        "avc"
})
public class FileCodecs {

    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();
    @JsonProperty("hevc")
    private Hevc hevc;
    @JsonProperty("av1")
    private List<Object> av1 = new ArrayList<>();
    @JsonProperty("avc")
    private List<String> avc = new ArrayList<>();

    /**
     * No args constructor for use in serialization
     */
    public FileCodecs() {
    }

    public FileCodecs(Hevc hevc, List<Object> av1, List<String> avc) {
        super();
        this.hevc = hevc;
        this.av1 = av1;
        this.avc = avc;
    }

    @JsonProperty("hevc")
    public Hevc getHevc() {
        return hevc;
    }

    @JsonProperty("hevc")
    public void setHevc(Hevc hevc) {
        this.hevc = hevc;
    }

    public FileCodecs withHevc(Hevc hevc) {
        this.hevc = hevc;
        return this;
    }

    @JsonProperty("av1")
    public List<Object> getAv1() {
        return av1;
    }

    @JsonProperty("av1")
    public void setAv1(List<Object> av1) {
        this.av1 = av1;
    }

    public FileCodecs withAv1(List<Object> av1) {
        this.av1 = av1;
        return this;
    }

    @JsonProperty("avc")
    public List<String> getAvc() {
        return avc;
    }

    @JsonProperty("avc")
    public void setAvc(List<String> avc) {
        this.avc = avc;
    }

    public FileCodecs withAvc(List<String> avc) {
        this.avc = avc;
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

    public FileCodecs withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("hevc", hevc).append("av1", av1).append("avc", avc).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(hevc).append(additionalProperties).append(av1).append(avc).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof FileCodecs)) {
            return false;
        }
        FileCodecs rhs = ((FileCodecs) other);
        return new EqualsBuilder().append(hevc, rhs.hevc).append(additionalProperties, rhs.additionalProperties).append(av1, rhs.av1).append(avc, rhs.avc).isEquals();
    }

}
