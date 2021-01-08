
package org.jtube.data.vimeo.streams;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "clip_id",
        "base_url",
        "video",
        "audio"
})
public class Streams {

    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();
    @JsonProperty("clip_id")
    private String clipId;
    @JsonProperty("base_url")
    private String baseUrl;
    @JsonProperty("video")
    private List<Stream> video = new ArrayList<>();
    @JsonProperty("audio")
    private List<Stream> audio = new ArrayList<>();

    /**
     * No args constructor for use in serialization
     */
    public Streams() {
    }

    public Streams(String clipId, String baseUrl, List<Stream> video, List<Stream> audio) {
        super();
        this.clipId = clipId;
        this.baseUrl = baseUrl;
        this.video = video;
        this.audio = audio;
    }

    @JsonProperty("clip_id")
    public String getClipId() {
        return clipId;
    }

    @JsonProperty("clip_id")
    public void setClipId(String clipId) {
        this.clipId = clipId;
    }

    public Streams withClipId(String clipId) {
        this.clipId = clipId;
        return this;
    }

    @JsonProperty("base_url")
    public String getBaseUrl() {
        return baseUrl;
    }

    @JsonProperty("base_url")
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Streams withBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    @JsonProperty("video")
    public List<Stream> getVideo() {
        return video;
    }

    @JsonProperty("video")
    public void setVideo(List<Stream> video) {
        this.video = video;
    }

    public Streams withVideo(List<Stream> video) {
        this.video = video;
        return this;
    }

    @JsonProperty("audio")
    public List<Stream> getAudio() {
        return audio;
    }

    @JsonProperty("audio")
    public void setAudio(List<Stream> audio) {
        this.audio = audio;
    }

    public Streams withAudio(List<Stream> audio) {
        this.audio = audio;
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

    public Streams withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("clipId", clipId).append("baseUrl", baseUrl).append("video", video).append("audio", audio).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(clipId).append(baseUrl).append(video).append(audio).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Streams)) {
            return false;
        }
        Streams rhs = ((Streams) other);
        return new EqualsBuilder().append(clipId, rhs.clipId).append(baseUrl, rhs.baseUrl).append(video, rhs.video).append(audio, rhs.audio).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
