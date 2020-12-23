
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
    "playerStoryboardSpecRenderer"
})
public class Storyboards {

    @JsonProperty("playerStoryboardSpecRenderer")
    @Valid
    private PlayerStoryboardSpecRenderer playerStoryboardSpecRenderer;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Storyboards() {
    }

    public Storyboards(PlayerStoryboardSpecRenderer playerStoryboardSpecRenderer) {
        super();
        this.playerStoryboardSpecRenderer = playerStoryboardSpecRenderer;
    }

    @JsonProperty("playerStoryboardSpecRenderer")
    public PlayerStoryboardSpecRenderer getPlayerStoryboardSpecRenderer() {
        return playerStoryboardSpecRenderer;
    }

    @JsonProperty("playerStoryboardSpecRenderer")
    public void setPlayerStoryboardSpecRenderer(PlayerStoryboardSpecRenderer playerStoryboardSpecRenderer) {
        this.playerStoryboardSpecRenderer = playerStoryboardSpecRenderer;
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
        return new ToStringBuilder(this).append("playerStoryboardSpecRenderer", playerStoryboardSpecRenderer).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(playerStoryboardSpecRenderer).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Storyboards)) {
            return false;
        }
        Storyboards rhs = ((Storyboards) other);
        return new EqualsBuilder().append(playerStoryboardSpecRenderer, rhs.playerStoryboardSpecRenderer).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
