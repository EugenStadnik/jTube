
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
        "profile",
        "width",
        "mime",
        "fps",
        "url",
        "cdn",
        "quality",
        "id",
        "origin",
        "height"
})
public class Progressive {

    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();
    @JsonProperty("profile")
    private int profile;
    @JsonProperty("width")
    private int width;
    @JsonProperty("mime")
    private String mime;
    @JsonProperty("fps")
    private int fps;
    @JsonProperty("url")
    private URL url;
    @JsonProperty("cdn")
    private String cdn;
    @JsonProperty("quality")
    private String quality;
    @JsonProperty("id")
    private String id;
    @JsonProperty("origin")
    private String origin;
    @JsonProperty("height")
    private int height;

    /**
     * No args constructor for use in serialization
     */
    public Progressive() {
    }

    public Progressive(int profile, int width, String mime, int fps, URL url, String cdn, String quality, String id, String origin, int height) {
        super();
        this.profile = profile;
        this.width = width;
        this.mime = mime;
        this.fps = fps;
        this.url = url;
        this.cdn = cdn;
        this.quality = quality;
        this.id = id;
        this.origin = origin;
        this.height = height;
    }

    @JsonProperty("profile")
    public int getProfile() {
        return profile;
    }

    @JsonProperty("profile")
    public void setProfile(int profile) {
        this.profile = profile;
    }

    public Progressive withProfile(int profile) {
        this.profile = profile;
        return this;
    }

    @JsonProperty("width")
    public int getWidth() {
        return width;
    }

    @JsonProperty("width")
    public void setWidth(int width) {
        this.width = width;
    }

    public Progressive withWidth(int width) {
        this.width = width;
        return this;
    }

    @JsonProperty("mime")
    public String getMime() {
        return mime;
    }

    @JsonProperty("mime")
    public void setMime(String mime) {
        this.mime = mime;
    }

    public Progressive withMime(String mime) {
        this.mime = mime;
        return this;
    }

    @JsonProperty("fps")
    public int getFps() {
        return fps;
    }

    @JsonProperty("fps")
    public void setFps(int fps) {
        this.fps = fps;
    }

    public Progressive withFps(int fps) {
        this.fps = fps;
        return this;
    }

    @JsonProperty("url")
    public URL getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(URL url) {
        this.url = url;
    }

    public Progressive withUrl(URL url) {
        this.url = url;
        return this;
    }

    @JsonProperty("cdn")
    public String getCdn() {
        return cdn;
    }

    @JsonProperty("cdn")
    public void setCdn(String cdn) {
        this.cdn = cdn;
    }

    public Progressive withCdn(String cdn) {
        this.cdn = cdn;
        return this;
    }

    @JsonProperty("quality")
    public String getQuality() {
        return quality;
    }

    @JsonProperty("quality")
    public void setQuality(String quality) {
        this.quality = quality;
    }

    public Progressive withQuality(String quality) {
        this.quality = quality;
        return this;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public Progressive withId(String id) {
        this.id = id;
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

    public Progressive withOrigin(String origin) {
        this.origin = origin;
        return this;
    }

    @JsonProperty("height")
    public int getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(int height) {
        this.height = height;
    }

    public Progressive withHeight(int height) {
        this.height = height;
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

    public Progressive withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("profile", profile).append("width", width).append("mime", mime).append("fps", fps).append("url", url).append("cdn", cdn).append("quality", quality).append("id", id).append("origin", origin).append("height", height).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(profile).append(mime).append(origin).append(width).append(fps).append(id).append(additionalProperties).append(cdn).append(url).append(quality).append(height).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Progressive)) {
            return false;
        }
        Progressive rhs = ((Progressive) other);
        return new EqualsBuilder().append(profile, rhs.profile).append(mime, rhs.mime).append(origin, rhs.origin).append(width, rhs.width).append(fps, rhs.fps).append(id, rhs.id).append(additionalProperties, rhs.additionalProperties).append(cdn, rhs.cdn).append(url, rhs.url).append(quality, rhs.quality).append(height, rhs.height).isEquals();
    }

}
