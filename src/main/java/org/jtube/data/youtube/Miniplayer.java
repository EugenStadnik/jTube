
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
    "miniplayerRenderer"
})
public class Miniplayer {

    @JsonProperty("miniplayerRenderer")
    @Valid
    private MiniplayerRenderer miniplayerRenderer;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Miniplayer() {
    }

    public Miniplayer(MiniplayerRenderer miniplayerRenderer) {
        super();
        this.miniplayerRenderer = miniplayerRenderer;
    }

    @JsonProperty("miniplayerRenderer")
    public MiniplayerRenderer getMiniplayerRenderer() {
        return miniplayerRenderer;
    }

    @JsonProperty("miniplayerRenderer")
    public void setMiniplayerRenderer(MiniplayerRenderer miniplayerRenderer) {
        this.miniplayerRenderer = miniplayerRenderer;
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
        return new ToStringBuilder(this).append("miniplayerRenderer", miniplayerRenderer).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(miniplayerRenderer).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Miniplayer)) {
            return false;
        }
        Miniplayer rhs = ((Miniplayer) other);
        return new EqualsBuilder().append(miniplayerRenderer, rhs.miniplayerRenderer).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
