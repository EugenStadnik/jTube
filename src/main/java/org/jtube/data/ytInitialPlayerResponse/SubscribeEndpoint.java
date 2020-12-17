
package org.jtube.data.ytInitialPlayerResponse;

import java.util.HashMap;
import java.util.List;
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
    "channelIds",
    "params"
})
public class SubscribeEndpoint {

    @JsonProperty("channelIds")
    @Valid
    private List<String> channelIds = null;
    @JsonProperty("params")
    private String params;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public SubscribeEndpoint() {
    }

    public SubscribeEndpoint(List<String> channelIds, String params) {
        super();
        this.channelIds = channelIds;
        this.params = params;
    }

    @JsonProperty("channelIds")
    public List<String> getChannelIds() {
        return channelIds;
    }

    @JsonProperty("channelIds")
    public void setChannelIds(List<String> channelIds) {
        this.channelIds = channelIds;
    }

    @JsonProperty("params")
    public String getParams() {
        return params;
    }

    @JsonProperty("params")
    public void setParams(String params) {
        this.params = params;
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
        return new ToStringBuilder(this).append("channelIds", channelIds).append("params", params).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalProperties).append(channelIds).append(params).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof SubscribeEndpoint)) {
            return false;
        }
        SubscribeEndpoint rhs = ((SubscribeEndpoint) other);
        return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(channelIds, rhs.channelIds).append(params, rhs.params).isEquals();
    }

}
