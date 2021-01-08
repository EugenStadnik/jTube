
package org.jtube.data.vimeo.playerData;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "track",
        "data",
        "group"
})
public class StatsFresnel {

    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();
    @JsonProperty("track")
    private boolean track;
    @JsonProperty("data")
    private Data data;
    @JsonProperty("group")
    private boolean group;

    /**
     * No args constructor for use in serialization
     */
    public StatsFresnel() {
    }

    public StatsFresnel(boolean track, Data data, boolean group) {
        super();
        this.track = track;
        this.data = data;
        this.group = group;
    }

    @JsonProperty("track")
    public boolean isTrack() {
        return track;
    }

    @JsonProperty("track")
    public void setTrack(boolean track) {
        this.track = track;
    }

    public StatsFresnel withTrack(boolean track) {
        this.track = track;
        return this;
    }

    @JsonProperty("data")
    public Data getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(Data data) {
        this.data = data;
    }

    public StatsFresnel withData(Data data) {
        this.data = data;
        return this;
    }

    @JsonProperty("group")
    public boolean isGroup() {
        return group;
    }

    @JsonProperty("group")
    public void setGroup(boolean group) {
        this.group = group;
    }

    public StatsFresnel withGroup(boolean group) {
        this.group = group;
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

    public StatsFresnel withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("track", track).append("data", data).append("group", group).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalProperties).append(track).append(data).append(group).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof StatsFresnel)) {
            return false;
        }
        StatsFresnel rhs = ((StatsFresnel) other);
        return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(track, rhs.track).append(data, rhs.data).append(group, rhs.group).isEquals();
    }

}
