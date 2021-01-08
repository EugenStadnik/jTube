
package org.jtube.data.vimeo.playerData;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "profile",
        "quality",
        "id",
        "fps"
})
public class Stream {

    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();
    @JsonProperty("profile")
    private int profile;
    @JsonProperty("quality")
    private String quality;
    @JsonProperty("id")
    private String id;
    @JsonProperty("fps")
    private int fps;

    /**
     * No args constructor for use in serialization
     */
    public Stream() {
    }

    public Stream(int profile, String quality, String id, int fps) {
        super();
        this.profile = profile;
        this.quality = quality;
        this.id = id;
        this.fps = fps;
    }

    @JsonProperty("profile")
    public int getProfile() {
        return profile;
    }

    @JsonProperty("profile")
    public void setProfile(int profile) {
        this.profile = profile;
    }

    public Stream withProfile(int profile) {
        this.profile = profile;
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

    public Stream withQuality(String quality) {
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

    public Stream withId(String id) {
        this.id = id;
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

    public Stream withFps(int fps) {
        this.fps = fps;
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

    public Stream withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("profile", profile).append("quality", quality).append("id", id).append("fps", fps).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(fps).append(id).append(additionalProperties).append(profile).append(quality).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Stream)) {
            return false;
        }
        Stream rhs = ((Stream) other);
        return new EqualsBuilder().append(fps, rhs.fps).append(id, rhs.id).append(additionalProperties, rhs.additionalProperties).append(profile, rhs.profile).append(quality, rhs.quality).isEquals();
    }

}
