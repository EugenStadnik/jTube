
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
    "maxBitrate"
})
public class StreamSelectionConfig {

    @JsonProperty("maxBitrate")
    private String maxBitrate;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public StreamSelectionConfig() {
    }

    public StreamSelectionConfig(String maxBitrate) {
        super();
        this.maxBitrate = maxBitrate;
    }

    @JsonProperty("maxBitrate")
    public String getMaxBitrate() {
        return maxBitrate;
    }

    @JsonProperty("maxBitrate")
    public void setMaxBitrate(String maxBitrate) {
        this.maxBitrate = maxBitrate;
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
        return new ToStringBuilder(this).append("maxBitrate", maxBitrate).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(maxBitrate).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof StreamSelectionConfig)) {
            return false;
        }
        StreamSelectionConfig rhs = ((StreamSelectionConfig) other);
        return new EqualsBuilder().append(maxBitrate, rhs.maxBitrate).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
