
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
    "serviceTrackingParams",
    "webResponseContextExtensionData"
})
public class ResponseContext {

    @JsonProperty("serviceTrackingParams")
    @Valid
    private List<ServiceTrackingParam> serviceTrackingParams = null;
    @JsonProperty("webResponseContextExtensionData")
    @Valid
    private WebResponseContextExtensionData webResponseContextExtensionData;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ResponseContext() {
    }

    public ResponseContext(List<ServiceTrackingParam> serviceTrackingParams, WebResponseContextExtensionData webResponseContextExtensionData) {
        super();
        this.serviceTrackingParams = serviceTrackingParams;
        this.webResponseContextExtensionData = webResponseContextExtensionData;
    }

    @JsonProperty("serviceTrackingParams")
    public List<ServiceTrackingParam> getServiceTrackingParams() {
        return serviceTrackingParams;
    }

    @JsonProperty("serviceTrackingParams")
    public void setServiceTrackingParams(List<ServiceTrackingParam> serviceTrackingParams) {
        this.serviceTrackingParams = serviceTrackingParams;
    }

    @JsonProperty("webResponseContextExtensionData")
    public WebResponseContextExtensionData getWebResponseContextExtensionData() {
        return webResponseContextExtensionData;
    }

    @JsonProperty("webResponseContextExtensionData")
    public void setWebResponseContextExtensionData(WebResponseContextExtensionData webResponseContextExtensionData) {
        this.webResponseContextExtensionData = webResponseContextExtensionData;
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
        return new ToStringBuilder(this).append("serviceTrackingParams", serviceTrackingParams).append("webResponseContextExtensionData", webResponseContextExtensionData).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(serviceTrackingParams).append(webResponseContextExtensionData).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof ResponseContext)) {
            return false;
        }
        ResponseContext rhs = ((ResponseContext) other);
        return new EqualsBuilder().append(serviceTrackingParams, rhs.serviceTrackingParams).append(webResponseContextExtensionData, rhs.webResponseContextExtensionData).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
