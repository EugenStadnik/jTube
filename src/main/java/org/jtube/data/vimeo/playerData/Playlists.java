
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
        "separate_av",
        "streams",
        "cdns",
        "streams_avc",
        "default_cdn"
})
public class Playlists {

    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();
    @JsonProperty("separate_av")
    private boolean separateAv;
    @JsonProperty("streams")
    private List<Stream> streams = new ArrayList<>();
    @JsonProperty("cdns")
    private Cdns cdns;
    @JsonProperty("streams_avc")
    private List<Stream> streamsAvc = new ArrayList<>();
    @JsonProperty("default_cdn")
    private String defaultCdn;

    /**
     * No args constructor for use in serialization
     */
    public Playlists() {
    }

    public Playlists(boolean separateAv, List<Stream> streams, Cdns cdns, List<Stream> streamsAvc, String defaultCdn) {
        super();
        this.separateAv = separateAv;
        this.streams = streams;
        this.cdns = cdns;
        this.streamsAvc = streamsAvc;
        this.defaultCdn = defaultCdn;
    }

    @JsonProperty("separate_av")
    public boolean isSeparateAv() {
        return separateAv;
    }

    @JsonProperty("separate_av")
    public void setSeparateAv(boolean separateAv) {
        this.separateAv = separateAv;
    }

    public Playlists withSeparateAv(boolean separateAv) {
        this.separateAv = separateAv;
        return this;
    }

    @JsonProperty("streams")
    public List<Stream> getStreams() {
        return streams;
    }

    @JsonProperty("streams")
    public void setStreams(List<Stream> streams) {
        this.streams = streams;
    }

    public Playlists withStreams(List<Stream> streams) {
        this.streams = streams;
        return this;
    }

    @JsonProperty("cdns")
    public Cdns getCdns() {
        return cdns;
    }

    @JsonProperty("cdns")
    public void setCdns(Cdns cdns) {
        this.cdns = cdns;
    }

    public Playlists withCdns(Cdns cdns) {
        this.cdns = cdns;
        return this;
    }

    @JsonProperty("streams_avc")
    public List<Stream> getStreamsAvc() {
        return streamsAvc;
    }

    @JsonProperty("streams_avc")
    public void setStreamsAvc(List<Stream> streamsAvc) {
        this.streamsAvc = streamsAvc;
    }

    public Playlists withStreamsAvc(List<Stream> streamsAvc) {
        this.streamsAvc = streamsAvc;
        return this;
    }

    @JsonProperty("default_cdn")
    public String getDefaultCdn() {
        return defaultCdn;
    }

    @JsonProperty("default_cdn")
    public void setDefaultCdn(String defaultCdn) {
        this.defaultCdn = defaultCdn;
    }

    public Playlists withDefaultCdn(String defaultCdn) {
        this.defaultCdn = defaultCdn;
        return this;
    }

    public Playlist defaultCdnObject() {
        switch (defaultCdn) {
            case "fastlynlc_skyfire": return cdns.getFastlynlcSkyfire();
            case "fastly_skyfire": return cdns.getFastlySkyfire();
            case "akfire_interconnect_quic": return cdns.getAkfireInterconnectQuic();
            default: return null;
        }
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Playlists withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("separateAv", separateAv).append("streams", streams).append("cdns", cdns).append("streamsAvc", streamsAvc).append("defaultCdn", defaultCdn).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(streams).append(cdns).append(separateAv).append(additionalProperties).append(streamsAvc).append(defaultCdn).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Playlists)) {
            return false;
        }
        Playlists rhs = ((Playlists) other);
        return new EqualsBuilder().append(streams, rhs.streams).append(cdns, rhs.cdns).append(separateAv, rhs.separateAv).append(additionalProperties, rhs.additionalProperties).append(streamsAvc, rhs.streamsAvc).append(defaultCdn, rhs.defaultCdn).isEquals();
    }

}
