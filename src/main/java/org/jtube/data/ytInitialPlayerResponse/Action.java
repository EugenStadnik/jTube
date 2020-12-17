
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
    "addedVideoId",
    "action"
})
public class Action {

    @JsonProperty("addedVideoId")
    private String addedVideoId;
    @JsonProperty("action")
    private String action;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Action() {
    }

    public Action(String addedVideoId, String action) {
        super();
        this.addedVideoId = addedVideoId;
        this.action = action;
    }

    @JsonProperty("addedVideoId")
    public String getAddedVideoId() {
        return addedVideoId;
    }

    @JsonProperty("addedVideoId")
    public void setAddedVideoId(String addedVideoId) {
        this.addedVideoId = addedVideoId;
    }

    @JsonProperty("action")
    public String getAction() {
        return action;
    }

    @JsonProperty("action")
    public void setAction(String action) {
        this.action = action;
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
        return new ToStringBuilder(this).append("addedVideoId", addedVideoId).append("action", action).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(action).append(additionalProperties).append(addedVideoId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Action)) {
            return false;
        }
        Action rhs = ((Action) other);
        return new EqualsBuilder().append(action, rhs.action).append(additionalProperties, rhs.additionalProperties).append(addedVideoId, rhs.addedVideoId).isEquals();
    }

}
