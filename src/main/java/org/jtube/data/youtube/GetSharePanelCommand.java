
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
    "clickTrackingParams",
    "commandMetadata",
    "webPlayerShareEntityServiceEndpoint"
})
public class GetSharePanelCommand {

    @JsonProperty("clickTrackingParams")
    private String clickTrackingParams;
    @JsonProperty("commandMetadata")
    @Valid
    private CommandMetadata commandMetadata;
    @JsonProperty("webPlayerShareEntityServiceEndpoint")
    @Valid
    private WebPlayerShareEntityServiceEndpoint webPlayerShareEntityServiceEndpoint;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public GetSharePanelCommand() {
    }

    public GetSharePanelCommand(String clickTrackingParams, CommandMetadata commandMetadata, WebPlayerShareEntityServiceEndpoint webPlayerShareEntityServiceEndpoint) {
        super();
        this.clickTrackingParams = clickTrackingParams;
        this.commandMetadata = commandMetadata;
        this.webPlayerShareEntityServiceEndpoint = webPlayerShareEntityServiceEndpoint;
    }

    @JsonProperty("clickTrackingParams")
    public String getClickTrackingParams() {
        return clickTrackingParams;
    }

    @JsonProperty("clickTrackingParams")
    public void setClickTrackingParams(String clickTrackingParams) {
        this.clickTrackingParams = clickTrackingParams;
    }

    @JsonProperty("commandMetadata")
    public CommandMetadata getCommandMetadata() {
        return commandMetadata;
    }

    @JsonProperty("commandMetadata")
    public void setCommandMetadata(CommandMetadata commandMetadata) {
        this.commandMetadata = commandMetadata;
    }

    @JsonProperty("webPlayerShareEntityServiceEndpoint")
    public WebPlayerShareEntityServiceEndpoint getWebPlayerShareEntityServiceEndpoint() {
        return webPlayerShareEntityServiceEndpoint;
    }

    @JsonProperty("webPlayerShareEntityServiceEndpoint")
    public void setWebPlayerShareEntityServiceEndpoint(WebPlayerShareEntityServiceEndpoint webPlayerShareEntityServiceEndpoint) {
        this.webPlayerShareEntityServiceEndpoint = webPlayerShareEntityServiceEndpoint;
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
        return new ToStringBuilder(this).append("clickTrackingParams", clickTrackingParams).append("commandMetadata", commandMetadata).append("webPlayerShareEntityServiceEndpoint", webPlayerShareEntityServiceEndpoint).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(commandMetadata).append(additionalProperties).append(clickTrackingParams).append(webPlayerShareEntityServiceEndpoint).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof GetSharePanelCommand)) {
            return false;
        }
        GetSharePanelCommand rhs = ((GetSharePanelCommand) other);
        return new EqualsBuilder().append(commandMetadata, rhs.commandMetadata).append(additionalProperties, rhs.additionalProperties).append(clickTrackingParams, rhs.clickTrackingParams).append(webPlayerShareEntityServiceEndpoint, rhs.webPlayerShareEntityServiceEndpoint).isEquals();
    }

}
