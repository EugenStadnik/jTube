
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
    "loudnessDb",
    "perceptualLoudnessDb",
    "enablePerFormatLoudness"
})
public class AudioConfig {

    @JsonProperty("loudnessDb")
    private double loudnessDb;
    @JsonProperty("perceptualLoudnessDb")
    private double perceptualLoudnessDb;
    @JsonProperty("enablePerFormatLoudness")
    private boolean enablePerFormatLoudness;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AudioConfig() {
    }

    public AudioConfig(double loudnessDb, double perceptualLoudnessDb, boolean enablePerFormatLoudness) {
        super();
        this.loudnessDb = loudnessDb;
        this.perceptualLoudnessDb = perceptualLoudnessDb;
        this.enablePerFormatLoudness = enablePerFormatLoudness;
    }

    @JsonProperty("loudnessDb")
    public double getLoudnessDb() {
        return loudnessDb;
    }

    @JsonProperty("loudnessDb")
    public void setLoudnessDb(double loudnessDb) {
        this.loudnessDb = loudnessDb;
    }

    @JsonProperty("perceptualLoudnessDb")
    public double getPerceptualLoudnessDb() {
        return perceptualLoudnessDb;
    }

    @JsonProperty("perceptualLoudnessDb")
    public void setPerceptualLoudnessDb(double perceptualLoudnessDb) {
        this.perceptualLoudnessDb = perceptualLoudnessDb;
    }

    @JsonProperty("enablePerFormatLoudness")
    public boolean isEnablePerFormatLoudness() {
        return enablePerFormatLoudness;
    }

    @JsonProperty("enablePerFormatLoudness")
    public void setEnablePerFormatLoudness(boolean enablePerFormatLoudness) {
        this.enablePerFormatLoudness = enablePerFormatLoudness;
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
        return new ToStringBuilder(this).append("loudnessDb", loudnessDb).append("perceptualLoudnessDb", perceptualLoudnessDb).append("enablePerFormatLoudness", enablePerFormatLoudness).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalProperties).append(loudnessDb).append(enablePerFormatLoudness).append(perceptualLoudnessDb).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof AudioConfig)) {
            return false;
        }
        AudioConfig rhs = ((AudioConfig) other);
        return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(loudnessDb, rhs.loudnessDb).append(enablePerFormatLoudness, rhs.enablePerFormatLoudness).append(perceptualLoudnessDb, rhs.perceptualLoudnessDb).isEquals();
    }

}
