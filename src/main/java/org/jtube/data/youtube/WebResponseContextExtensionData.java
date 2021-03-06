
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
    "hasDecorated"
})
public class WebResponseContextExtensionData {

    @JsonProperty("hasDecorated")
    private boolean hasDecorated;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public WebResponseContextExtensionData() {
    }

    public WebResponseContextExtensionData(boolean hasDecorated) {
        super();
        this.hasDecorated = hasDecorated;
    }

    @JsonProperty("hasDecorated")
    public boolean isHasDecorated() {
        return hasDecorated;
    }

    @JsonProperty("hasDecorated")
    public void setHasDecorated(boolean hasDecorated) {
        this.hasDecorated = hasDecorated;
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
        return new ToStringBuilder(this).append("hasDecorated", hasDecorated).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(hasDecorated).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof WebResponseContextExtensionData)) {
            return false;
        }
        WebResponseContextExtensionData rhs = ((WebResponseContextExtensionData) other);
        return new EqualsBuilder().append(hasDecorated, rhs.hasDecorated).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
