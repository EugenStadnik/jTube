
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
    "webCommandMetadata"
})
public class CommandMetadata {

    @JsonProperty("webCommandMetadata")
    @Valid
    private WebCommandMetadata webCommandMetadata;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public CommandMetadata() {
    }

    public CommandMetadata(WebCommandMetadata webCommandMetadata) {
        super();
        this.webCommandMetadata = webCommandMetadata;
    }

    @JsonProperty("webCommandMetadata")
    public WebCommandMetadata getWebCommandMetadata() {
        return webCommandMetadata;
    }

    @JsonProperty("webCommandMetadata")
    public void setWebCommandMetadata(WebCommandMetadata webCommandMetadata) {
        this.webCommandMetadata = webCommandMetadata;
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
        return new ToStringBuilder(this).append("webCommandMetadata", webCommandMetadata).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(webCommandMetadata).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof CommandMetadata)) {
            return false;
        }
        CommandMetadata rhs = ((CommandMetadata) other);
        return new EqualsBuilder().append(webCommandMetadata, rhs.webCommandMetadata).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
