
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
    "playerMicroformatRenderer"
})
public class Microformat {

    @JsonProperty("playerMicroformatRenderer")
    @Valid
    private PlayerMicroformatRenderer playerMicroformatRenderer;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Microformat() {
    }

    public Microformat(PlayerMicroformatRenderer playerMicroformatRenderer) {
        super();
        this.playerMicroformatRenderer = playerMicroformatRenderer;
    }

    @JsonProperty("playerMicroformatRenderer")
    public PlayerMicroformatRenderer getPlayerMicroformatRenderer() {
        return playerMicroformatRenderer;
    }

    @JsonProperty("playerMicroformatRenderer")
    public void setPlayerMicroformatRenderer(PlayerMicroformatRenderer playerMicroformatRenderer) {
        this.playerMicroformatRenderer = playerMicroformatRenderer;
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
        return new ToStringBuilder(this).append("playerMicroformatRenderer", playerMicroformatRenderer).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(playerMicroformatRenderer).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Microformat)) {
            return false;
        }
        Microformat rhs = ((Microformat) other);
        return new EqualsBuilder().append(playerMicroformatRenderer, rhs.playerMicroformatRenderer).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
