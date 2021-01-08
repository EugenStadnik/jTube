
package org.jtube.data.vimeo.playerData;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "url",
        "origin",
        "avc_url"
})
public class Playlist {

    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();
    @JsonProperty("url")
    private URL url;
    @JsonProperty("origin")
    private String origin;
    @JsonProperty("avc_url")
    private URL avcUrl;

    /**
     * No args constructor for use in serialization
     */
    public Playlist() {
    }

    public Playlist(URL url, String origin, URL avcUrl) {
        super();
        this.url = url;
        this.origin = origin;
        this.avcUrl = avcUrl;
    }

    @JsonProperty("url")
    public URL getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(URL url) {
        this.url = url;
    }

    public Playlist withUrl(URL url) {
        this.url = url;
        return this;
    }

    @JsonProperty("origin")
    public String getOrigin() {
        return origin;
    }

    @JsonProperty("origin")
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Playlist withOrigin(String origin) {
        this.origin = origin;
        return this;
    }

    @JsonProperty("avc_url")
    public URL getAvcUrl() {
        return avcUrl;
    }

    @JsonProperty("avc_url")
    public void setAvcUrl(URL avcUrl) {
        this.avcUrl = avcUrl;
    }

    public Playlist withAvcUrl(URL avcUrl) {
        this.avcUrl = avcUrl;
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

    public Playlist withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("url", url).append("origin", origin).append("avcUrl", avcUrl).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(avcUrl).append(additionalProperties).append(url).append(origin).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Playlist)) {
            return false;
        }
        Playlist rhs = ((Playlist) other);
        return new EqualsBuilder().append(avcUrl, rhs.avcUrl).append(additionalProperties, rhs.additionalProperties).append(url, rhs.url).append(origin, rhs.origin).isEquals();
    }

}
