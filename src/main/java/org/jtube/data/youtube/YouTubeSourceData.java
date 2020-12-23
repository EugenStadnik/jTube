
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
import org.jtube.data.SourceData;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "responseContext",
    "playabilityStatus",
    "streamingData",
    "playbackTracking",
    "videoDetails",
    "playerConfig",
    "storyboards",
    "microformat",
    "trackingParams",
    "attestation"
})
public class YouTubeSourceData extends SourceData {

    @JsonProperty("responseContext")
    @Valid
    private ResponseContext responseContext;
    @JsonProperty("playabilityStatus")
    @Valid
    private PlayabilityStatus playabilityStatus;
    @JsonProperty("streamingData")
    @Valid
    private StreamingData streamingData;
    @JsonProperty("playbackTracking")
    @Valid
    private PlaybackTracking playbackTracking;
    @JsonProperty("videoDetails")
    @Valid
    private VideoDetails videoDetails;
    @JsonProperty("playerConfig")
    @Valid
    private PlayerConfig playerConfig;
    @JsonProperty("storyboards")
    @Valid
    private Storyboards storyboards;
    @JsonProperty("microformat")
    @Valid
    private Microformat microformat;
    @JsonProperty("trackingParams")
    private String trackingParams;
    @JsonProperty("attestation")
    @Valid
    private Attestation attestation;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public YouTubeSourceData() {
    }

    public YouTubeSourceData(ResponseContext responseContext, PlayabilityStatus playabilityStatus, StreamingData streamingData, PlaybackTracking playbackTracking, VideoDetails videoDetails, PlayerConfig playerConfig, Storyboards storyboards, Microformat microformat, String trackingParams, Attestation attestation) {
        super();
        this.responseContext = responseContext;
        this.playabilityStatus = playabilityStatus;
        this.streamingData = streamingData;
        this.playbackTracking = playbackTracking;
        this.videoDetails = videoDetails;
        this.playerConfig = playerConfig;
        this.storyboards = storyboards;
        this.microformat = microformat;
        this.trackingParams = trackingParams;
        this.attestation = attestation;
    }

    @JsonProperty("responseContext")
    public ResponseContext getResponseContext() {
        return responseContext;
    }

    @JsonProperty("responseContext")
    public void setResponseContext(ResponseContext responseContext) {
        this.responseContext = responseContext;
    }

    @JsonProperty("playabilityStatus")
    public PlayabilityStatus getPlayabilityStatus() {
        return playabilityStatus;
    }

    @JsonProperty("playabilityStatus")
    public void setPlayabilityStatus(PlayabilityStatus playabilityStatus) {
        this.playabilityStatus = playabilityStatus;
    }

    @JsonProperty("streamingData")
    public StreamingData getStreamingData() {
        return streamingData;
    }

    @JsonProperty("streamingData")
    public void setStreamingData(StreamingData streamingData) {
        this.streamingData = streamingData;
    }

    @JsonProperty("playbackTracking")
    public PlaybackTracking getPlaybackTracking() {
        return playbackTracking;
    }

    @JsonProperty("playbackTracking")
    public void setPlaybackTracking(PlaybackTracking playbackTracking) {
        this.playbackTracking = playbackTracking;
    }

    @JsonProperty("videoDetails")
    public VideoDetails getVideoDetails() {
        return videoDetails;
    }

    @JsonProperty("videoDetails")
    public void setVideoDetails(VideoDetails videoDetails) {
        this.videoDetails = videoDetails;
    }

    @JsonProperty("playerConfig")
    public PlayerConfig getPlayerConfig() {
        return playerConfig;
    }

    @JsonProperty("playerConfig")
    public void setPlayerConfig(PlayerConfig playerConfig) {
        this.playerConfig = playerConfig;
    }

    @JsonProperty("storyboards")
    public Storyboards getStoryboards() {
        return storyboards;
    }

    @JsonProperty("storyboards")
    public void setStoryboards(Storyboards storyboards) {
        this.storyboards = storyboards;
    }

    @JsonProperty("microformat")
    public Microformat getMicroformat() {
        return microformat;
    }

    @JsonProperty("microformat")
    public void setMicroformat(Microformat microformat) {
        this.microformat = microformat;
    }

    @JsonProperty("trackingParams")
    public String getTrackingParams() {
        return trackingParams;
    }

    @JsonProperty("trackingParams")
    public void setTrackingParams(String trackingParams) {
        this.trackingParams = trackingParams;
    }

    @JsonProperty("attestation")
    public Attestation getAttestation() {
        return attestation;
    }

    @JsonProperty("attestation")
    public void setAttestation(Attestation attestation) {
        this.attestation = attestation;
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
        return new ToStringBuilder(this).append("responseContext", responseContext).append("playabilityStatus", playabilityStatus).append("streamingData", streamingData).append("playbackTracking", playbackTracking).append("videoDetails", videoDetails).append("playerConfig", playerConfig).append("storyboards", storyboards).append("microformat", microformat).append("trackingParams", trackingParams).append("attestation", attestation).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(playerConfig).append(trackingParams).append(attestation).append(videoDetails).append(streamingData).append(responseContext).append(playabilityStatus).append(playbackTracking).append(microformat).append(additionalProperties).append(storyboards).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof YouTubeSourceData)) {
            return false;
        }
        YouTubeSourceData rhs = ((YouTubeSourceData) other);
        return new EqualsBuilder().append(playerConfig, rhs.playerConfig).append(trackingParams, rhs.trackingParams).append(attestation, rhs.attestation).append(videoDetails, rhs.videoDetails).append(streamingData, rhs.streamingData).append(responseContext, rhs.responseContext).append(playabilityStatus, rhs.playabilityStatus).append(playbackTracking, rhs.playbackTracking).append(microformat, rhs.microformat).append(additionalProperties, rhs.additionalProperties).append(storyboards, rhs.storyboards).isEquals();
    }

}
