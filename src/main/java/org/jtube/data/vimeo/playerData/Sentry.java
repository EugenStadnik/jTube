
package org.jtube.data.vimeo.playerData;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "url",
        "enabled",
        "debug_enabled",
        "debug_intent"
})
public class Sentry {

    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();
    @JsonProperty("url")
    private String url;
    @JsonProperty("enabled")
    private boolean enabled;
    @JsonProperty("debug_enabled")
    private boolean debugEnabled;
    @JsonProperty("debug_intent")
    private int debugIntent;

    /**
     * No args constructor for use in serialization
     */
    public Sentry() {
    }

    public Sentry(String url, boolean enabled, boolean debugEnabled, int debugIntent) {
        super();
        this.url = url;
        this.enabled = enabled;
        this.debugEnabled = debugEnabled;
        this.debugIntent = debugIntent;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    public Sentry withUrl(String url) {
        this.url = url;
        return this;
    }

    @JsonProperty("enabled")
    public boolean isEnabled() {
        return enabled;
    }

    @JsonProperty("enabled")
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Sentry withEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    @JsonProperty("debug_enabled")
    public boolean isDebugEnabled() {
        return debugEnabled;
    }

    @JsonProperty("debug_enabled")
    public void setDebugEnabled(boolean debugEnabled) {
        this.debugEnabled = debugEnabled;
    }

    public Sentry withDebugEnabled(boolean debugEnabled) {
        this.debugEnabled = debugEnabled;
        return this;
    }

    @JsonProperty("debug_intent")
    public int getDebugIntent() {
        return debugIntent;
    }

    @JsonProperty("debug_intent")
    public void setDebugIntent(int debugIntent) {
        this.debugIntent = debugIntent;
    }

    public Sentry withDebugIntent(int debugIntent) {
        this.debugIntent = debugIntent;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Sentry withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("url", url).append("enabled", enabled).append("debugEnabled", debugEnabled).append("debugIntent", debugIntent).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(debugEnabled).append(additionalProperties).append(debugIntent).append(url).append(enabled).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Sentry)) {
            return false;
        }
        Sentry rhs = ((Sentry) other);
        return new EqualsBuilder().append(debugEnabled, rhs.debugEnabled).append(additionalProperties, rhs.additionalProperties).append(debugIntent, rhs.debugIntent).append(url, rhs.url).append(enabled, rhs.enabled).isEquals();
    }

}
