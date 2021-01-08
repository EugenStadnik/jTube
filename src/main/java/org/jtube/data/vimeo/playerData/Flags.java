
package org.jtube.data.vimeo.playerData;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "dnt",
        "preload_video",
        "plays",
        "partials",
        "autohide_controls"
})
public class Flags {

    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();
    @JsonProperty("dnt")
    private int dnt;
    @JsonProperty("preload_video")
    private String preloadVideo;
    @JsonProperty("plays")
    private int plays;
    @JsonProperty("partials")
    private int partials;
    @JsonProperty("autohide_controls")
    private int autohideControls;

    /**
     * No args constructor for use in serialization
     */
    public Flags() {
    }

    public Flags(int dnt, String preloadVideo, int plays, int partials, int autohideControls) {
        super();
        this.dnt = dnt;
        this.preloadVideo = preloadVideo;
        this.plays = plays;
        this.partials = partials;
        this.autohideControls = autohideControls;
    }

    @JsonProperty("dnt")
    public int getDnt() {
        return dnt;
    }

    @JsonProperty("dnt")
    public void setDnt(int dnt) {
        this.dnt = dnt;
    }

    public Flags withDnt(int dnt) {
        this.dnt = dnt;
        return this;
    }

    @JsonProperty("preload_video")
    public String getPreloadVideo() {
        return preloadVideo;
    }

    @JsonProperty("preload_video")
    public void setPreloadVideo(String preloadVideo) {
        this.preloadVideo = preloadVideo;
    }

    public Flags withPreloadVideo(String preloadVideo) {
        this.preloadVideo = preloadVideo;
        return this;
    }

    @JsonProperty("plays")
    public int getPlays() {
        return plays;
    }

    @JsonProperty("plays")
    public void setPlays(int plays) {
        this.plays = plays;
    }

    public Flags withPlays(int plays) {
        this.plays = plays;
        return this;
    }

    @JsonProperty("partials")
    public int getPartials() {
        return partials;
    }

    @JsonProperty("partials")
    public void setPartials(int partials) {
        this.partials = partials;
    }

    public Flags withPartials(int partials) {
        this.partials = partials;
        return this;
    }

    @JsonProperty("autohide_controls")
    public int getAutohideControls() {
        return autohideControls;
    }

    @JsonProperty("autohide_controls")
    public void setAutohideControls(int autohideControls) {
        this.autohideControls = autohideControls;
    }

    public Flags withAutohideControls(int autohideControls) {
        this.autohideControls = autohideControls;
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

    public Flags withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("dnt", dnt).append("preloadVideo", preloadVideo).append("plays", plays).append("partials", partials).append("autohideControls", autohideControls).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(plays).append(autohideControls).append(dnt).append(preloadVideo).append(additionalProperties).append(partials).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Flags)) {
            return false;
        }
        Flags rhs = ((Flags) other);
        return new EqualsBuilder().append(plays, rhs.plays).append(autohideControls, rhs.autohideControls).append(dnt, rhs.dnt).append(preloadVideo, rhs.preloadVideo).append(additionalProperties, rhs.additionalProperties).append(partials, rhs.partials).isEquals();
    }

}
