
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
    "serializedShareEntity"
})
public class WebPlayerShareEntityServiceEndpoint {

    @JsonProperty("serializedShareEntity")
    private String serializedShareEntity;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public WebPlayerShareEntityServiceEndpoint() {
    }

    public WebPlayerShareEntityServiceEndpoint(String serializedShareEntity) {
        super();
        this.serializedShareEntity = serializedShareEntity;
    }

    @JsonProperty("serializedShareEntity")
    public String getSerializedShareEntity() {
        return serializedShareEntity;
    }

    @JsonProperty("serializedShareEntity")
    public void setSerializedShareEntity(String serializedShareEntity) {
        this.serializedShareEntity = serializedShareEntity;
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
        return new ToStringBuilder(this).append("serializedShareEntity", serializedShareEntity).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(serializedShareEntity).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof WebPlayerShareEntityServiceEndpoint)) {
            return false;
        }
        WebPlayerShareEntityServiceEndpoint rhs = ((WebPlayerShareEntityServiceEndpoint) other);
        return new EqualsBuilder().append(serializedShareEntity, rhs.serializedShareEntity).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
