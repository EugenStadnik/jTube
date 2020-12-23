
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
    "webPlayerActionsPorting"
})
public class WebPlayerConfig {

    @JsonProperty("webPlayerActionsPorting")
    @Valid
    private WebPlayerActionsPorting webPlayerActionsPorting;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public WebPlayerConfig() {
    }

    public WebPlayerConfig(WebPlayerActionsPorting webPlayerActionsPorting) {
        super();
        this.webPlayerActionsPorting = webPlayerActionsPorting;
    }

    @JsonProperty("webPlayerActionsPorting")
    public WebPlayerActionsPorting getWebPlayerActionsPorting() {
        return webPlayerActionsPorting;
    }

    @JsonProperty("webPlayerActionsPorting")
    public void setWebPlayerActionsPorting(WebPlayerActionsPorting webPlayerActionsPorting) {
        this.webPlayerActionsPorting = webPlayerActionsPorting;
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
        return new ToStringBuilder(this).append("webPlayerActionsPorting", webPlayerActionsPorting).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(webPlayerActionsPorting).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof WebPlayerConfig)) {
            return false;
        }
        WebPlayerConfig rhs = ((WebPlayerConfig) other);
        return new EqualsBuilder().append(webPlayerActionsPorting, rhs.webPlayerActionsPorting).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
