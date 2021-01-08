
package org.jtube.data.vimeo.playerData;

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
        "dash",
        "hls",
        "progressive"
})
public class Files {

    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();
    @JsonProperty("dash")
    private Playlists dash;
    @JsonProperty("hls")
    private Playlists hls;
    @JsonProperty("progressive")
    private List<Progressive> progressive = new ArrayList<>();

    /**
     * No args constructor for use in serialization
     */
    public Files() {
    }

    public Files(Playlists dash, Playlists hls, List<Progressive> progressive) {
        super();
        this.dash = dash;
        this.hls = hls;
        this.progressive = progressive;
    }

    @JsonProperty("dash")
    public Playlists getDash() {
        return dash;
    }

    @JsonProperty("dash")
    public void setDash(Playlists dash) {
        this.dash = dash;
    }

    public Files withDash(Playlists dash) {
        this.dash = dash;
        return this;
    }

    @JsonProperty("hls")
    public Playlists getHls() {
        return hls;
    }

    @JsonProperty("hls")
    public void setHls(Playlists hls) {
        this.hls = hls;
    }

    public Files withHls(Playlists hls) {
        this.hls = hls;
        return this;
    }

    @JsonProperty("progressive")
    public List<Progressive> getProgressive() {
        return progressive;
    }

    @JsonProperty("progressive")
    public void setProgressive(List<Progressive> progressive) {
        this.progressive = progressive;
    }

    public Files withProgressive(List<Progressive> progressive) {
        this.progressive = progressive;
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

    public Files withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("dash", dash).append("hls", hls).append("progressive", progressive).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(progressive).append(additionalProperties).append(dash).append(hls).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Files)) {
            return false;
        }
        Files rhs = ((Files) other);
        return new EqualsBuilder().append(progressive, rhs.progressive).append(additionalProperties, rhs.additionalProperties).append(dash, rhs.dash).append(hls, rhs.hls).isEquals();
    }

}
