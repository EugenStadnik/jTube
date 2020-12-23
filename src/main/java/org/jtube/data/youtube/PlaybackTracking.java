
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
    "videostatsPlaybackUrl",
    "videostatsDelayplayUrl",
    "videostatsWatchtimeUrl",
    "ptrackingUrl",
    "qoeUrl",
    "setAwesomeUrl",
    "atrUrl"
})
public class PlaybackTracking {

    @JsonProperty("videostatsPlaybackUrl")
    @Valid
    private VideostatsPlaybackUrl videostatsPlaybackUrl;
    @JsonProperty("videostatsDelayplayUrl")
    @Valid
    private VideostatsDelayplayUrl videostatsDelayplayUrl;
    @JsonProperty("videostatsWatchtimeUrl")
    @Valid
    private VideostatsWatchtimeUrl videostatsWatchtimeUrl;
    @JsonProperty("ptrackingUrl")
    @Valid
    private PtrackingUrl ptrackingUrl;
    @JsonProperty("qoeUrl")
    @Valid
    private QoeUrl qoeUrl;
    @JsonProperty("setAwesomeUrl")
    @Valid
    private SetAwesomeUrl setAwesomeUrl;
    @JsonProperty("atrUrl")
    @Valid
    private AtrUrl atrUrl;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PlaybackTracking() {
    }

    public PlaybackTracking(VideostatsPlaybackUrl videostatsPlaybackUrl, VideostatsDelayplayUrl videostatsDelayplayUrl, VideostatsWatchtimeUrl videostatsWatchtimeUrl, PtrackingUrl ptrackingUrl, QoeUrl qoeUrl, SetAwesomeUrl setAwesomeUrl, AtrUrl atrUrl) {
        super();
        this.videostatsPlaybackUrl = videostatsPlaybackUrl;
        this.videostatsDelayplayUrl = videostatsDelayplayUrl;
        this.videostatsWatchtimeUrl = videostatsWatchtimeUrl;
        this.ptrackingUrl = ptrackingUrl;
        this.qoeUrl = qoeUrl;
        this.setAwesomeUrl = setAwesomeUrl;
        this.atrUrl = atrUrl;
    }

    @JsonProperty("videostatsPlaybackUrl")
    public VideostatsPlaybackUrl getVideostatsPlaybackUrl() {
        return videostatsPlaybackUrl;
    }

    @JsonProperty("videostatsPlaybackUrl")
    public void setVideostatsPlaybackUrl(VideostatsPlaybackUrl videostatsPlaybackUrl) {
        this.videostatsPlaybackUrl = videostatsPlaybackUrl;
    }

    @JsonProperty("videostatsDelayplayUrl")
    public VideostatsDelayplayUrl getVideostatsDelayplayUrl() {
        return videostatsDelayplayUrl;
    }

    @JsonProperty("videostatsDelayplayUrl")
    public void setVideostatsDelayplayUrl(VideostatsDelayplayUrl videostatsDelayplayUrl) {
        this.videostatsDelayplayUrl = videostatsDelayplayUrl;
    }

    @JsonProperty("videostatsWatchtimeUrl")
    public VideostatsWatchtimeUrl getVideostatsWatchtimeUrl() {
        return videostatsWatchtimeUrl;
    }

    @JsonProperty("videostatsWatchtimeUrl")
    public void setVideostatsWatchtimeUrl(VideostatsWatchtimeUrl videostatsWatchtimeUrl) {
        this.videostatsWatchtimeUrl = videostatsWatchtimeUrl;
    }

    @JsonProperty("ptrackingUrl")
    public PtrackingUrl getPtrackingUrl() {
        return ptrackingUrl;
    }

    @JsonProperty("ptrackingUrl")
    public void setPtrackingUrl(PtrackingUrl ptrackingUrl) {
        this.ptrackingUrl = ptrackingUrl;
    }

    @JsonProperty("qoeUrl")
    public QoeUrl getQoeUrl() {
        return qoeUrl;
    }

    @JsonProperty("qoeUrl")
    public void setQoeUrl(QoeUrl qoeUrl) {
        this.qoeUrl = qoeUrl;
    }

    @JsonProperty("setAwesomeUrl")
    public SetAwesomeUrl getSetAwesomeUrl() {
        return setAwesomeUrl;
    }

    @JsonProperty("setAwesomeUrl")
    public void setSetAwesomeUrl(SetAwesomeUrl setAwesomeUrl) {
        this.setAwesomeUrl = setAwesomeUrl;
    }

    @JsonProperty("atrUrl")
    public AtrUrl getAtrUrl() {
        return atrUrl;
    }

    @JsonProperty("atrUrl")
    public void setAtrUrl(AtrUrl atrUrl) {
        this.atrUrl = atrUrl;
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
        return new ToStringBuilder(this).append("videostatsPlaybackUrl", videostatsPlaybackUrl).append("videostatsDelayplayUrl", videostatsDelayplayUrl).append("videostatsWatchtimeUrl", videostatsWatchtimeUrl).append("ptrackingUrl", ptrackingUrl).append("qoeUrl", qoeUrl).append("setAwesomeUrl", setAwesomeUrl).append("atrUrl", atrUrl).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(videostatsWatchtimeUrl).append(videostatsDelayplayUrl).append(qoeUrl).append(setAwesomeUrl).append(videostatsPlaybackUrl).append(additionalProperties).append(ptrackingUrl).append(atrUrl).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof PlaybackTracking)) {
            return false;
        }
        PlaybackTracking rhs = ((PlaybackTracking) other);
        return new EqualsBuilder().append(videostatsWatchtimeUrl, rhs.videostatsWatchtimeUrl).append(videostatsDelayplayUrl, rhs.videostatsDelayplayUrl).append(qoeUrl, rhs.qoeUrl).append(setAwesomeUrl, rhs.setAwesomeUrl).append(videostatsPlaybackUrl, rhs.videostatsPlaybackUrl).append(additionalProperties, rhs.additionalProperties).append(ptrackingUrl, rhs.ptrackingUrl).append(atrUrl, rhs.atrUrl).isEquals();
    }

}
