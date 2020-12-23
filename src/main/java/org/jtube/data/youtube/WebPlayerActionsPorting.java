
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
    "getSharePanelCommand",
    "subscribeCommand",
    "unsubscribeCommand",
    "addToWatchLaterCommand",
    "removeFromWatchLaterCommand"
})
public class WebPlayerActionsPorting {

    @JsonProperty("getSharePanelCommand")
    @Valid
    private GetSharePanelCommand getSharePanelCommand;
    @JsonProperty("subscribeCommand")
    @Valid
    private SubscribeCommand subscribeCommand;
    @JsonProperty("unsubscribeCommand")
    @Valid
    private UnsubscribeCommand unsubscribeCommand;
    @JsonProperty("addToWatchLaterCommand")
    @Valid
    private AddToWatchLaterCommand addToWatchLaterCommand;
    @JsonProperty("removeFromWatchLaterCommand")
    @Valid
    private RemoveFromWatchLaterCommand removeFromWatchLaterCommand;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public WebPlayerActionsPorting() {
    }

    public WebPlayerActionsPorting(GetSharePanelCommand getSharePanelCommand, SubscribeCommand subscribeCommand, UnsubscribeCommand unsubscribeCommand, AddToWatchLaterCommand addToWatchLaterCommand, RemoveFromWatchLaterCommand removeFromWatchLaterCommand) {
        super();
        this.getSharePanelCommand = getSharePanelCommand;
        this.subscribeCommand = subscribeCommand;
        this.unsubscribeCommand = unsubscribeCommand;
        this.addToWatchLaterCommand = addToWatchLaterCommand;
        this.removeFromWatchLaterCommand = removeFromWatchLaterCommand;
    }

    @JsonProperty("getSharePanelCommand")
    public GetSharePanelCommand getGetSharePanelCommand() {
        return getSharePanelCommand;
    }

    @JsonProperty("getSharePanelCommand")
    public void setGetSharePanelCommand(GetSharePanelCommand getSharePanelCommand) {
        this.getSharePanelCommand = getSharePanelCommand;
    }

    @JsonProperty("subscribeCommand")
    public SubscribeCommand getSubscribeCommand() {
        return subscribeCommand;
    }

    @JsonProperty("subscribeCommand")
    public void setSubscribeCommand(SubscribeCommand subscribeCommand) {
        this.subscribeCommand = subscribeCommand;
    }

    @JsonProperty("unsubscribeCommand")
    public UnsubscribeCommand getUnsubscribeCommand() {
        return unsubscribeCommand;
    }

    @JsonProperty("unsubscribeCommand")
    public void setUnsubscribeCommand(UnsubscribeCommand unsubscribeCommand) {
        this.unsubscribeCommand = unsubscribeCommand;
    }

    @JsonProperty("addToWatchLaterCommand")
    public AddToWatchLaterCommand getAddToWatchLaterCommand() {
        return addToWatchLaterCommand;
    }

    @JsonProperty("addToWatchLaterCommand")
    public void setAddToWatchLaterCommand(AddToWatchLaterCommand addToWatchLaterCommand) {
        this.addToWatchLaterCommand = addToWatchLaterCommand;
    }

    @JsonProperty("removeFromWatchLaterCommand")
    public RemoveFromWatchLaterCommand getRemoveFromWatchLaterCommand() {
        return removeFromWatchLaterCommand;
    }

    @JsonProperty("removeFromWatchLaterCommand")
    public void setRemoveFromWatchLaterCommand(RemoveFromWatchLaterCommand removeFromWatchLaterCommand) {
        this.removeFromWatchLaterCommand = removeFromWatchLaterCommand;
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
        return new ToStringBuilder(this).append("getSharePanelCommand", getSharePanelCommand).append("subscribeCommand", subscribeCommand).append("unsubscribeCommand", unsubscribeCommand).append("addToWatchLaterCommand", addToWatchLaterCommand).append("removeFromWatchLaterCommand", removeFromWatchLaterCommand).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(removeFromWatchLaterCommand).append(subscribeCommand).append(getSharePanelCommand).append(unsubscribeCommand).append(addToWatchLaterCommand).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof WebPlayerActionsPorting)) {
            return false;
        }
        WebPlayerActionsPorting rhs = ((WebPlayerActionsPorting) other);
        return new EqualsBuilder().append(removeFromWatchLaterCommand, rhs.removeFromWatchLaterCommand).append(subscribeCommand, rhs.subscribeCommand).append(getSharePanelCommand, rhs.getSharePanelCommand).append(unsubscribeCommand, rhs.unsubscribeCommand).append(addToWatchLaterCommand, rhs.addToWatchLaterCommand).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
