
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
    "enableServerStitchedDai"
})
public class DaiConfig {

    @JsonProperty("enableServerStitchedDai")
    private boolean enableServerStitchedDai;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public DaiConfig() {
    }

    public DaiConfig(boolean enableServerStitchedDai) {
        super();
        this.enableServerStitchedDai = enableServerStitchedDai;
    }

    @JsonProperty("enableServerStitchedDai")
    public boolean isEnableServerStitchedDai() {
        return enableServerStitchedDai;
    }

    @JsonProperty("enableServerStitchedDai")
    public void setEnableServerStitchedDai(boolean enableServerStitchedDai) {
        this.enableServerStitchedDai = enableServerStitchedDai;
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
        return new ToStringBuilder(this).append("enableServerStitchedDai", enableServerStitchedDai).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(enableServerStitchedDai).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof DaiConfig)) {
            return false;
        }
        DaiConfig rhs = ((DaiConfig) other);
        return new EqualsBuilder().append(enableServerStitchedDai, rhs.enableServerStitchedDai).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
