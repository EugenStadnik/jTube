
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
    "playerAttestationRenderer"
})
public class Attestation {

    @JsonProperty("playerAttestationRenderer")
    @Valid
    private PlayerAttestationRenderer playerAttestationRenderer;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Attestation() {
    }

    public Attestation(PlayerAttestationRenderer playerAttestationRenderer) {
        super();
        this.playerAttestationRenderer = playerAttestationRenderer;
    }

    @JsonProperty("playerAttestationRenderer")
    public PlayerAttestationRenderer getPlayerAttestationRenderer() {
        return playerAttestationRenderer;
    }

    @JsonProperty("playerAttestationRenderer")
    public void setPlayerAttestationRenderer(PlayerAttestationRenderer playerAttestationRenderer) {
        this.playerAttestationRenderer = playerAttestationRenderer;
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
        return new ToStringBuilder(this).append("playerAttestationRenderer", playerAttestationRenderer).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(playerAttestationRenderer).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Attestation)) {
            return false;
        }
        Attestation rhs = ((Attestation) other);
        return new EqualsBuilder().append(playerAttestationRenderer, rhs.playerAttestationRenderer).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
