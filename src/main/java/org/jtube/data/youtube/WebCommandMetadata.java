
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
    "sendPost",
    "apiUrl"
})
public class WebCommandMetadata {

    @JsonProperty("sendPost")
    private boolean sendPost;
    @JsonProperty("apiUrl")
    private String apiUrl;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public WebCommandMetadata() {
    }

    public WebCommandMetadata(boolean sendPost, String apiUrl) {
        super();
        this.sendPost = sendPost;
        this.apiUrl = apiUrl;
    }

    @JsonProperty("sendPost")
    public boolean isSendPost() {
        return sendPost;
    }

    @JsonProperty("sendPost")
    public void setSendPost(boolean sendPost) {
        this.sendPost = sendPost;
    }

    @JsonProperty("apiUrl")
    public String getApiUrl() {
        return apiUrl;
    }

    @JsonProperty("apiUrl")
    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
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
        return new ToStringBuilder(this).append("sendPost", sendPost).append("apiUrl", apiUrl).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(sendPost).append(additionalProperties).append(apiUrl).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof WebCommandMetadata)) {
            return false;
        }
        WebCommandMetadata rhs = ((WebCommandMetadata) other);
        return new EqualsBuilder().append(sendPost, rhs.sendPost).append(additionalProperties, rhs.additionalProperties).append(apiUrl, rhs.apiUrl).isEquals();
    }

}
