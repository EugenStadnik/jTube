
package org.jtube.data.youtube;

import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "playbackMode"
})
public class MiniplayerRenderer {

    @JsonProperty("playbackMode")
    private String playbackMode;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public MiniplayerRenderer() {
    }

    public MiniplayerRenderer(String playbackMode) {
        super();
        this.playbackMode = playbackMode;
    }

    @JsonProperty("playbackMode")
    public String getPlaybackMode() {
        return playbackMode;
    }

    @JsonProperty("playbackMode")
    public void setPlaybackMode(String playbackMode) {
        this.playbackMode = playbackMode;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("playbackMode", playbackMode).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(playbackMode).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof MiniplayerRenderer)) {
            return false;
        }
        MiniplayerRenderer rhs = ((MiniplayerRenderer) other);
        return new EqualsBuilder().append(playbackMode, rhs.playbackMode).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
