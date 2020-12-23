
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
    "challenge",
    "botguardData"
})
public class PlayerAttestationRenderer {

    @JsonProperty("challenge")
    private String challenge;
    @JsonProperty("botguardData")
    @Valid
    private BotguardData botguardData;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PlayerAttestationRenderer() {
    }

    public PlayerAttestationRenderer(String challenge, BotguardData botguardData) {
        super();
        this.challenge = challenge;
        this.botguardData = botguardData;
    }

    @JsonProperty("challenge")
    public String getChallenge() {
        return challenge;
    }

    @JsonProperty("challenge")
    public void setChallenge(String challenge) {
        this.challenge = challenge;
    }

    @JsonProperty("botguardData")
    public BotguardData getBotguardData() {
        return botguardData;
    }

    @JsonProperty("botguardData")
    public void setBotguardData(BotguardData botguardData) {
        this.botguardData = botguardData;
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
        return new ToStringBuilder(this).append("challenge", challenge).append("botguardData", botguardData).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(challenge).append(botguardData).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof PlayerAttestationRenderer)) {
            return false;
        }
        PlayerAttestationRenderer rhs = ((PlayerAttestationRenderer) other);
        return new EqualsBuilder().append(challenge, rhs.challenge).append(botguardData, rhs.botguardData).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
