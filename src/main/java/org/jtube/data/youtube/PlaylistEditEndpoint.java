
package org.jtube.data.youtube;

import java.util.HashMap;
import java.util.List;
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
    "playlistId",
    "actions"
})
public class PlaylistEditEndpoint {

    @JsonProperty("playlistId")
    private String playlistId;
    @JsonProperty("actions")
    @Valid
    private List<Action> actions = null;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PlaylistEditEndpoint() {
    }

    public PlaylistEditEndpoint(String playlistId, List<Action> actions) {
        super();
        this.playlistId = playlistId;
        this.actions = actions;
    }

    @JsonProperty("playlistId")
    public String getPlaylistId() {
        return playlistId;
    }

    @JsonProperty("playlistId")
    public void setPlaylistId(String playlistId) {
        this.playlistId = playlistId;
    }

    @JsonProperty("actions")
    public List<Action> getActions() {
        return actions;
    }

    @JsonProperty("actions")
    public void setActions(List<Action> actions) {
        this.actions = actions;
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
        return new ToStringBuilder(this).append("playlistId", playlistId).append("actions", actions).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(playlistId).append(additionalProperties).append(actions).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof PlaylistEditEndpoint)) {
            return false;
        }
        PlaylistEditEndpoint rhs = ((PlaylistEditEndpoint) other);
        return new EqualsBuilder().append(playlistId, rhs.playlistId).append(additionalProperties, rhs.additionalProperties).append(actions, rhs.actions).isEquals();
    }

}
