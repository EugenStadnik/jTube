
package org.jtube.data.ytInitialPlayerResponse;

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
    "clickTrackingParams",
    "commandMetadata",
    "playlistEditEndpoint"
})
public class AddToWatchLaterCommand {

    @JsonProperty("clickTrackingParams")
    private String clickTrackingParams;
    @JsonProperty("commandMetadata")
    @Valid
    private CommandMetadata commandMetadata;
    @JsonProperty("playlistEditEndpoint")
    @Valid
    private PlaylistEditEndpoint playlistEditEndpoint;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AddToWatchLaterCommand() {
    }

    public AddToWatchLaterCommand(String clickTrackingParams, CommandMetadata commandMetadata, PlaylistEditEndpoint playlistEditEndpoint) {
        super();
        this.clickTrackingParams = clickTrackingParams;
        this.commandMetadata = commandMetadata;
        this.playlistEditEndpoint = playlistEditEndpoint;
    }

    @JsonProperty("clickTrackingParams")
    public String getClickTrackingParams() {
        return clickTrackingParams;
    }

    @JsonProperty("clickTrackingParams")
    public void setClickTrackingParams(String clickTrackingParams) {
        this.clickTrackingParams = clickTrackingParams;
    }

    @JsonProperty("commandMetadata")
    public CommandMetadata getCommandMetadata() {
        return commandMetadata;
    }

    @JsonProperty("commandMetadata")
    public void setCommandMetadata(CommandMetadata commandMetadata) {
        this.commandMetadata = commandMetadata;
    }

    @JsonProperty("playlistEditEndpoint")
    public PlaylistEditEndpoint getPlaylistEditEndpoint() {
        return playlistEditEndpoint;
    }

    @JsonProperty("playlistEditEndpoint")
    public void setPlaylistEditEndpoint(PlaylistEditEndpoint playlistEditEndpoint) {
        this.playlistEditEndpoint = playlistEditEndpoint;
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
        return new ToStringBuilder(this).append("clickTrackingParams", clickTrackingParams).append("commandMetadata", commandMetadata).append("playlistEditEndpoint", playlistEditEndpoint).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(commandMetadata).append(playlistEditEndpoint).append(additionalProperties).append(clickTrackingParams).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof AddToWatchLaterCommand)) {
            return false;
        }
        AddToWatchLaterCommand rhs = ((AddToWatchLaterCommand) other);
        return new EqualsBuilder().append(commandMetadata, rhs.commandMetadata).append(playlistEditEndpoint, rhs.playlistEditEndpoint).append(additionalProperties, rhs.additionalProperties).append(clickTrackingParams, rhs.clickTrackingParams).isEquals();
    }

}
