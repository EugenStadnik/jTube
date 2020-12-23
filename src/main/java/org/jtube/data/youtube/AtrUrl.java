
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
    "baseUrl",
    "elapsedMediaTimeSeconds"
})
public class AtrUrl {

    @JsonProperty("baseUrl")
    private String baseUrl;
    @JsonProperty("elapsedMediaTimeSeconds")
    private int elapsedMediaTimeSeconds;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AtrUrl() {
    }

    public AtrUrl(String baseUrl, int elapsedMediaTimeSeconds) {
        super();
        this.baseUrl = baseUrl;
        this.elapsedMediaTimeSeconds = elapsedMediaTimeSeconds;
    }

    @JsonProperty("baseUrl")
    public String getBaseUrl() {
        return baseUrl;
    }

    @JsonProperty("baseUrl")
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @JsonProperty("elapsedMediaTimeSeconds")
    public int getElapsedMediaTimeSeconds() {
        return elapsedMediaTimeSeconds;
    }

    @JsonProperty("elapsedMediaTimeSeconds")
    public void setElapsedMediaTimeSeconds(int elapsedMediaTimeSeconds) {
        this.elapsedMediaTimeSeconds = elapsedMediaTimeSeconds;
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
        return new ToStringBuilder(this).append("baseUrl", baseUrl).append("elapsedMediaTimeSeconds", elapsedMediaTimeSeconds).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(baseUrl).append(additionalProperties).append(elapsedMediaTimeSeconds).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof AtrUrl)) {
            return false;
        }
        AtrUrl rhs = ((AtrUrl) other);
        return new EqualsBuilder().append(baseUrl, rhs.baseUrl).append(additionalProperties, rhs.additionalProperties).append(elapsedMediaTimeSeconds, rhs.elapsedMediaTimeSeconds).isEquals();
    }

}
