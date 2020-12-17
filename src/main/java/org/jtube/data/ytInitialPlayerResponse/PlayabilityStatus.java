
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
    "status",
    "playableInEmbed",
    "miniplayer",
    "contextParams"
})
public class PlayabilityStatus {

    @JsonProperty("status")
    private String status;
    @JsonProperty("playableInEmbed")
    private boolean playableInEmbed;
    @JsonProperty("miniplayer")
    @Valid
    private Miniplayer miniplayer;
    @JsonProperty("contextParams")
    private String contextParams;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PlayabilityStatus() {
    }

    public PlayabilityStatus(String status, boolean playableInEmbed, Miniplayer miniplayer, String contextParams) {
        super();
        this.status = status;
        this.playableInEmbed = playableInEmbed;
        this.miniplayer = miniplayer;
        this.contextParams = contextParams;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("playableInEmbed")
    public boolean isPlayableInEmbed() {
        return playableInEmbed;
    }

    @JsonProperty("playableInEmbed")
    public void setPlayableInEmbed(boolean playableInEmbed) {
        this.playableInEmbed = playableInEmbed;
    }

    @JsonProperty("miniplayer")
    public Miniplayer getMiniplayer() {
        return miniplayer;
    }

    @JsonProperty("miniplayer")
    public void setMiniplayer(Miniplayer miniplayer) {
        this.miniplayer = miniplayer;
    }

    @JsonProperty("contextParams")
    public String getContextParams() {
        return contextParams;
    }

    @JsonProperty("contextParams")
    public void setContextParams(String contextParams) {
        this.contextParams = contextParams;
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
        return new ToStringBuilder(this).append("status", status).append("playableInEmbed", playableInEmbed).append("miniplayer", miniplayer).append("contextParams", contextParams).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(contextParams).append(additionalProperties).append(playableInEmbed).append(miniplayer).append(status).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof PlayabilityStatus)) {
            return false;
        }
        PlayabilityStatus rhs = ((PlayabilityStatus) other);
        return new EqualsBuilder().append(contextParams, rhs.contextParams).append(additionalProperties, rhs.additionalProperties).append(playableInEmbed, rhs.playableInEmbed).append(miniplayer, rhs.miniplayer).append(status, rhs.status).isEquals();
    }

}
