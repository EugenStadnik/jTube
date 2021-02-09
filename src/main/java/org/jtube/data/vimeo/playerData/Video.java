
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
        "rating",
        "version",
        "height",
        "duration",
        "thumbs",
        "owner",
        "id",
        "embed_code",
        "title",
        "share_url",
        "width",
        "embed_permission",
        "fps",
        "spatial",
        "allow_hd",
        "hd",
        "default_to_hd",
        "url",
        "privacy",
        "bypass_token"
})
public class Video {

    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();
    @JsonProperty("rating")
    private Rating rating;
    @JsonProperty("version")
    private Version version;
    @JsonProperty("height")
    private int height;
    @JsonProperty("duration")
    private int duration;
    @JsonProperty("thumbs")
    private Thumbs thumbs;
    @JsonProperty("owner")
    private Owner owner;
    @JsonProperty("id")
    private int id;
    @JsonProperty("embed_code")
    private String embedCode;
    @JsonProperty("title")
    private String title;
    @JsonProperty("share_url")
    private URL shareUrl;
    @JsonProperty("width")
    private int width;
    @JsonProperty("embed_permission")
    private String embedPermission;
    @JsonProperty("fps")
    private double fps;
    @JsonProperty("spatial")
    private Object spatial;
    @JsonProperty("allow_hd")
    private int allowHd;
    @JsonProperty("hd")
    private int hd;
    @JsonProperty("default_to_hd")
    private int defaultToHd;
    @JsonProperty("url")
    private URL url;
    @JsonProperty("privacy")
    private String privacy;
    @JsonProperty("bypass_token")
    private String bypassToken;

    /**
     * No args constructor for use in serialization
     */
    public Video() {
    }

    public Video(Rating rating, Version version, int height, int duration, Thumbs thumbs, Owner owner, int id, String embedCode, String title, URL shareUrl, int width, String embedPermission, double fps, Object spatial, int allowHd, int hd, int defaultToHd, URL url, String privacy, String bypassToken) {
        super();
        this.rating = rating;
        this.version = version;
        this.height = height;
        this.duration = duration;
        this.thumbs = thumbs;
        this.owner = owner;
        this.id = id;
        this.embedCode = embedCode;
        this.title = title;
        this.shareUrl = shareUrl;
        this.width = width;
        this.embedPermission = embedPermission;
        this.fps = fps;
        this.spatial = spatial;
        this.allowHd = allowHd;
        this.hd = hd;
        this.defaultToHd = defaultToHd;
        this.url = url;
        this.privacy = privacy;
        this.bypassToken = bypassToken;
    }

    @JsonProperty("rating")
    public Rating getRating() {
        return rating;
    }

    @JsonProperty("rating")
    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Video withRating(Rating rating) {
        this.rating = rating;
        return this;
    }

    @JsonProperty("version")
    public Version getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(Version version) {
        this.version = version;
    }

    public Video withVersion(Version version) {
        this.version = version;
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

    public Video withHeight(int height) {
        this.height = height;
        return this;
    }

    @JsonProperty("duration")
    public int getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Video withDuration(int duration) {
        this.duration = duration;
        return this;
    }

    @JsonProperty("thumbs")
    public Thumbs getThumbs() {
        return thumbs;
    }

    @JsonProperty("thumbs")
    public void setThumbs(Thumbs thumbs) {
        this.thumbs = thumbs;
    }

    public Video withThumbs(Thumbs thumbs) {
        this.thumbs = thumbs;
        return this;
    }

    @JsonProperty("owner")
    public Owner getOwner() {
        return owner;
    }

    @JsonProperty("owner")
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Video withOwner(Owner owner) {
        this.owner = owner;
        return this;
    }

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    public Video withId(int id) {
        this.id = id;
        return this;
    }

    @JsonProperty("embed_code")
    public String getEmbedCode() {
        return embedCode;
    }

    @JsonProperty("embed_code")
    public void setEmbedCode(String embedCode) {
        this.embedCode = embedCode;
    }

    public Video withEmbedCode(String embedCode) {
        this.embedCode = embedCode;
        return this;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    public Video withTitle(String title) {
        this.title = title;
        return this;
    }

    @JsonProperty("share_url")
    public URL getShareUrl() {
        return shareUrl;
    }

    @JsonProperty("share_url")
    public void setShareUrl(URL shareUrl) {
        this.shareUrl = shareUrl;
    }

    public Video withShareUrl(URL shareUrl) {
        this.shareUrl = shareUrl;
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

    public Video withWidth(int width) {
        this.width = width;
        return this;
    }

    @JsonProperty("embed_permission")
    public String getEmbedPermission() {
        return embedPermission;
    }

    @JsonProperty("embed_permission")
    public void setEmbedPermission(String embedPermission) {
        this.embedPermission = embedPermission;
    }

    public Video withEmbedPermission(String embedPermission) {
        this.embedPermission = embedPermission;
        return this;
    }

    @JsonProperty("fps")
    public double getFps() {
        return fps;
    }

    @JsonProperty("fps")
    public void setFps(double fps) {
        this.fps = fps;
    }

    public Video withFps(double fps) {
        this.fps = fps;
        return this;
    }

    @JsonProperty("spatial")
    public Object getSpatial() {
        return spatial;
    }

    @JsonProperty("spatial")
    public void setSpatial(Object spatial) {
        this.spatial = spatial;
    }

    public Video withSpatial(Object spatial) {
        this.spatial = spatial;
        return this;
    }

    @JsonProperty("allow_hd")
    public int getAllowHd() {
        return allowHd;
    }

    @JsonProperty("allow_hd")
    public void setAllowHd(int allowHd) {
        this.allowHd = allowHd;
    }

    public Video withAllowHd(int allowHd) {
        this.allowHd = allowHd;
        return this;
    }

    @JsonProperty("hd")
    public int getHd() {
        return hd;
    }

    @JsonProperty("hd")
    public void setHd(int hd) {
        this.hd = hd;
    }

    public Video withHd(int hd) {
        this.hd = hd;
        return this;
    }

    @JsonProperty("default_to_hd")
    public int getDefaultToHd() {
        return defaultToHd;
    }

    @JsonProperty("default_to_hd")
    public void setDefaultToHd(int defaultToHd) {
        this.defaultToHd = defaultToHd;
    }

    public Video withDefaultToHd(int defaultToHd) {
        this.defaultToHd = defaultToHd;
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

    public Video withUrl(URL url) {
        this.url = url;
        return this;
    }

    @JsonProperty("privacy")
    public String getPrivacy() {
        return privacy;
    }

    @JsonProperty("privacy")
    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public Video withPrivacy(String privacy) {
        this.privacy = privacy;
        return this;
    }

    @JsonProperty("bypass_token")
    public String getBypassToken() {
        return bypassToken;
    }

    @JsonProperty("bypass_token")
    public void setBypassToken(String bypassToken) {
        this.bypassToken = bypassToken;
    }

    public Video withBypassToken(String bypassToken) {
        this.bypassToken = bypassToken;
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

    public Video withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("rating", rating).append("version", version).append("height", height).append("duration", duration).append("thumbs", thumbs).append("owner", owner).append("id", id).append("embedCode", embedCode).append("title", title).append("shareUrl", shareUrl).append("width", width).append("embedPermission", embedPermission).append("fps", fps).append("spatial", spatial).append("allowHd", allowHd).append("hd", hd).append("defaultToHd", defaultToHd).append("url", url).append("privacy", privacy).append("bypassToken", bypassToken).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(owner).append(embedPermission).append(rating).append(fps).append(allowHd).append(privacy).append(title).append(defaultToHd).append(version).append(url).append(duration).append(bypassToken).append(width).append(shareUrl).append(id).append(embedCode).append(additionalProperties).append(spatial).append(hd).append(height).append(thumbs).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Video)) {
            return false;
        }
        Video rhs = ((Video) other);
        return new EqualsBuilder().append(owner, rhs.owner).append(embedPermission, rhs.embedPermission).append(rating, rhs.rating).append(fps, rhs.fps).append(allowHd, rhs.allowHd).append(privacy, rhs.privacy).append(title, rhs.title).append(defaultToHd, rhs.defaultToHd).append(version, rhs.version).append(url, rhs.url).append(duration, rhs.duration).append(bypassToken, rhs.bypassToken).append(width, rhs.width).append(shareUrl, rhs.shareUrl).append(id, rhs.id).append(embedCode, rhs.embedCode).append(additionalProperties, rhs.additionalProperties).append(spatial, rhs.spatial).append(hd, rhs.hd).append(height, rhs.height).append(thumbs, rhs.thumbs).isEquals();
    }

}
