
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
    "action",
    "removedVideoId"
})
public class Action_ {

    @JsonProperty("action")
    private String action;
    @JsonProperty("removedVideoId")
    private String removedVideoId;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Action_() {
    }

    public Action_(String action, String removedVideoId) {
        super();
        this.action = action;
        this.removedVideoId = removedVideoId;
    }

    @JsonProperty("action")
    public String getAction() {
        return action;
    }

    @JsonProperty("action")
    public void setAction(String action) {
        this.action = action;
    }

    @JsonProperty("removedVideoId")
    public String getRemovedVideoId() {
        return removedVideoId;
    }

    @JsonProperty("removedVideoId")
    public void setRemovedVideoId(String removedVideoId) {
        this.removedVideoId = removedVideoId;
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
        return new ToStringBuilder(this).append("action", action).append("removedVideoId", removedVideoId).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(action).append(removedVideoId).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Action_)) {
            return false;
        }
        Action_ rhs = ((Action_) other);
        return new EqualsBuilder().append(action, rhs.action).append(removedVideoId, rhs.removedVideoId).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
