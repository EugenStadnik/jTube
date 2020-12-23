
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
    "maxReadAheadMediaTimeMs",
    "minReadAheadMediaTimeMs",
    "readAheadGrowthRateMs"
})
public class DynamicReadaheadConfig {

    @JsonProperty("maxReadAheadMediaTimeMs")
    private int maxReadAheadMediaTimeMs;
    @JsonProperty("minReadAheadMediaTimeMs")
    private int minReadAheadMediaTimeMs;
    @JsonProperty("readAheadGrowthRateMs")
    private int readAheadGrowthRateMs;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public DynamicReadaheadConfig() {
    }

    public DynamicReadaheadConfig(int maxReadAheadMediaTimeMs, int minReadAheadMediaTimeMs, int readAheadGrowthRateMs) {
        super();
        this.maxReadAheadMediaTimeMs = maxReadAheadMediaTimeMs;
        this.minReadAheadMediaTimeMs = minReadAheadMediaTimeMs;
        this.readAheadGrowthRateMs = readAheadGrowthRateMs;
    }

    @JsonProperty("maxReadAheadMediaTimeMs")
    public int getMaxReadAheadMediaTimeMs() {
        return maxReadAheadMediaTimeMs;
    }

    @JsonProperty("maxReadAheadMediaTimeMs")
    public void setMaxReadAheadMediaTimeMs(int maxReadAheadMediaTimeMs) {
        this.maxReadAheadMediaTimeMs = maxReadAheadMediaTimeMs;
    }

    @JsonProperty("minReadAheadMediaTimeMs")
    public int getMinReadAheadMediaTimeMs() {
        return minReadAheadMediaTimeMs;
    }

    @JsonProperty("minReadAheadMediaTimeMs")
    public void setMinReadAheadMediaTimeMs(int minReadAheadMediaTimeMs) {
        this.minReadAheadMediaTimeMs = minReadAheadMediaTimeMs;
    }

    @JsonProperty("readAheadGrowthRateMs")
    public int getReadAheadGrowthRateMs() {
        return readAheadGrowthRateMs;
    }

    @JsonProperty("readAheadGrowthRateMs")
    public void setReadAheadGrowthRateMs(int readAheadGrowthRateMs) {
        this.readAheadGrowthRateMs = readAheadGrowthRateMs;
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
        return new ToStringBuilder(this).append("maxReadAheadMediaTimeMs", maxReadAheadMediaTimeMs).append("minReadAheadMediaTimeMs", minReadAheadMediaTimeMs).append("readAheadGrowthRateMs", readAheadGrowthRateMs).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalProperties).append(maxReadAheadMediaTimeMs).append(readAheadGrowthRateMs).append(minReadAheadMediaTimeMs).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof DynamicReadaheadConfig)) {
            return false;
        }
        DynamicReadaheadConfig rhs = ((DynamicReadaheadConfig) other);
        return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(maxReadAheadMediaTimeMs, rhs.maxReadAheadMediaTimeMs).append(readAheadGrowthRateMs, rhs.readAheadGrowthRateMs).append(minReadAheadMediaTimeMs, rhs.minReadAheadMediaTimeMs).isEquals();
    }

}
