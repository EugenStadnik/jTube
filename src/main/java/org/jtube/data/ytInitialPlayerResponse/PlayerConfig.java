
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
    "audioConfig",
    "streamSelectionConfig",
    "daiConfig",
    "mediaCommonConfig",
    "webPlayerConfig"
})
public class PlayerConfig {

    @JsonProperty("audioConfig")
    @Valid
    private AudioConfig audioConfig;
    @JsonProperty("streamSelectionConfig")
    @Valid
    private StreamSelectionConfig streamSelectionConfig;
    @JsonProperty("daiConfig")
    @Valid
    private DaiConfig daiConfig;
    @JsonProperty("mediaCommonConfig")
    @Valid
    private MediaCommonConfig mediaCommonConfig;
    @JsonProperty("webPlayerConfig")
    @Valid
    private WebPlayerConfig webPlayerConfig;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PlayerConfig() {
    }

    public PlayerConfig(AudioConfig audioConfig, StreamSelectionConfig streamSelectionConfig, DaiConfig daiConfig, MediaCommonConfig mediaCommonConfig, WebPlayerConfig webPlayerConfig) {
        super();
        this.audioConfig = audioConfig;
        this.streamSelectionConfig = streamSelectionConfig;
        this.daiConfig = daiConfig;
        this.mediaCommonConfig = mediaCommonConfig;
        this.webPlayerConfig = webPlayerConfig;
    }

    @JsonProperty("audioConfig")
    public AudioConfig getAudioConfig() {
        return audioConfig;
    }

    @JsonProperty("audioConfig")
    public void setAudioConfig(AudioConfig audioConfig) {
        this.audioConfig = audioConfig;
    }

    @JsonProperty("streamSelectionConfig")
    public StreamSelectionConfig getStreamSelectionConfig() {
        return streamSelectionConfig;
    }

    @JsonProperty("streamSelectionConfig")
    public void setStreamSelectionConfig(StreamSelectionConfig streamSelectionConfig) {
        this.streamSelectionConfig = streamSelectionConfig;
    }

    @JsonProperty("daiConfig")
    public DaiConfig getDaiConfig() {
        return daiConfig;
    }

    @JsonProperty("daiConfig")
    public void setDaiConfig(DaiConfig daiConfig) {
        this.daiConfig = daiConfig;
    }

    @JsonProperty("mediaCommonConfig")
    public MediaCommonConfig getMediaCommonConfig() {
        return mediaCommonConfig;
    }

    @JsonProperty("mediaCommonConfig")
    public void setMediaCommonConfig(MediaCommonConfig mediaCommonConfig) {
        this.mediaCommonConfig = mediaCommonConfig;
    }

    @JsonProperty("webPlayerConfig")
    public WebPlayerConfig getWebPlayerConfig() {
        return webPlayerConfig;
    }

    @JsonProperty("webPlayerConfig")
    public void setWebPlayerConfig(WebPlayerConfig webPlayerConfig) {
        this.webPlayerConfig = webPlayerConfig;
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
        return new ToStringBuilder(this).append("audioConfig", audioConfig).append("streamSelectionConfig", streamSelectionConfig).append("daiConfig", daiConfig).append("mediaCommonConfig", mediaCommonConfig).append("webPlayerConfig", webPlayerConfig).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(webPlayerConfig).append(mediaCommonConfig).append(additionalProperties).append(daiConfig).append(audioConfig).append(streamSelectionConfig).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof PlayerConfig)) {
            return false;
        }
        PlayerConfig rhs = ((PlayerConfig) other);
        return new EqualsBuilder().append(webPlayerConfig, rhs.webPlayerConfig).append(mediaCommonConfig, rhs.mediaCommonConfig).append(additionalProperties, rhs.additionalProperties).append(daiConfig, rhs.daiConfig).append(audioConfig, rhs.audioConfig).append(streamSelectionConfig, rhs.streamSelectionConfig).isEquals();
    }

}
