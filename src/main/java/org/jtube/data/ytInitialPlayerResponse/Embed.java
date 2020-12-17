
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
    "iframeUrl",
    "flashUrl",
    "width",
    "height",
    "flashSecureUrl"
})
public class Embed {

    @JsonProperty("iframeUrl")
    private String iframeUrl;
    @JsonProperty("flashUrl")
    private String flashUrl;
    @JsonProperty("width")
    private int width;
    @JsonProperty("height")
    private int height;
    @JsonProperty("flashSecureUrl")
    private String flashSecureUrl;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Embed() {
    }

    public Embed(String iframeUrl, String flashUrl, int width, int height, String flashSecureUrl) {
        super();
        this.iframeUrl = iframeUrl;
        this.flashUrl = flashUrl;
        this.width = width;
        this.height = height;
        this.flashSecureUrl = flashSecureUrl;
    }

    @JsonProperty("iframeUrl")
    public String getIframeUrl() {
        return iframeUrl;
    }

    @JsonProperty("iframeUrl")
    public void setIframeUrl(String iframeUrl) {
        this.iframeUrl = iframeUrl;
    }

    @JsonProperty("flashUrl")
    public String getFlashUrl() {
        return flashUrl;
    }

    @JsonProperty("flashUrl")
    public void setFlashUrl(String flashUrl) {
        this.flashUrl = flashUrl;
    }

    @JsonProperty("width")
    public int getWidth() {
        return width;
    }

    @JsonProperty("width")
    public void setWidth(int width) {
        this.width = width;
    }

    @JsonProperty("height")
    public int getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(int height) {
        this.height = height;
    }

    @JsonProperty("flashSecureUrl")
    public String getFlashSecureUrl() {
        return flashSecureUrl;
    }

    @JsonProperty("flashSecureUrl")
    public void setFlashSecureUrl(String flashSecureUrl) {
        this.flashSecureUrl = flashSecureUrl;
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
        return new ToStringBuilder(this).append("iframeUrl", iframeUrl).append("flashUrl", flashUrl).append("width", width).append("height", height).append("flashSecureUrl", flashSecureUrl).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(width).append(flashUrl).append(flashSecureUrl).append(additionalProperties).append(iframeUrl).append(height).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Embed)) {
            return false;
        }
        Embed rhs = ((Embed) other);
        return new EqualsBuilder().append(width, rhs.width).append(flashUrl, rhs.flashUrl).append(flashSecureUrl, rhs.flashSecureUrl).append(additionalProperties, rhs.additionalProperties).append(iframeUrl, rhs.iframeUrl).append(height, rhs.height).isEquals();
    }

}
