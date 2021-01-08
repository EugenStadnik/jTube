
package org.jtube.data.vimeo.playerData;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "fastlynlc_skyfire",
        "akfire_interconnect_quic",
        "fastly_skyfire"
})
public class Cdns {

    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();
    @JsonProperty("fastlynlc_skyfire")
    private Playlist fastlynlcSkyfire;
    @JsonProperty("akfire_interconnect_quic")
    private Playlist akfireInterconnectQuic;
    @JsonProperty("fastly_skyfire")
    private Playlist fastlySkyfire;

    /**
     * No args constructor for use in serialization
     */
    public Cdns() {
    }

    public Cdns(Playlist fastlynlcSkyfire, Playlist akfireInterconnectQuic, Playlist fastlySkyfire) {
        super();
        this.fastlynlcSkyfire = fastlynlcSkyfire;
        this.akfireInterconnectQuic = akfireInterconnectQuic;
        this.fastlySkyfire = fastlySkyfire;
    }

    @JsonProperty("fastlynlc_skyfire")
    public Playlist getFastlynlcSkyfire() {
        return fastlynlcSkyfire;
    }

    @JsonProperty("fastlynlc_skyfire")
    public void setFastlynlcSkyfire(Playlist fastlynlcSkyfire) {
        this.fastlynlcSkyfire = fastlynlcSkyfire;
    }

    public Cdns withFastlynlcSkyfire(Playlist fastlynlcSkyfire) {
        this.fastlynlcSkyfire = fastlynlcSkyfire;
        return this;
    }

    @JsonProperty("akfire_interconnect_quic")
    public Playlist getAkfireInterconnectQuic() {
        return akfireInterconnectQuic;
    }

    @JsonProperty("akfire_interconnect_quic")
    public void setAkfireInterconnectQuic(Playlist akfireInterconnectQuic) {
        this.akfireInterconnectQuic = akfireInterconnectQuic;
    }

    public Cdns withAkfireInterconnectQuic(Playlist akfireInterconnectQuic) {
        this.akfireInterconnectQuic = akfireInterconnectQuic;
        return this;
    }

    @JsonProperty("fastly_skyfire")
    public Playlist getFastlySkyfire() {
        return fastlySkyfire;
    }

    @JsonProperty("fastly_skyfire")
    public void setFastlySkyfire(Playlist skyfire) {
        this.fastlySkyfire = skyfire;
    }

    public Cdns withFastlySkyfire(Playlist skyfire) {
        this.fastlySkyfire = skyfire;
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

    public Cdns withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("fastlynlcSkyfire", fastlynlcSkyfire).append("akfireInterconnectQuic", akfireInterconnectQuic).append("fastlySkyfire", fastlySkyfire).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(fastlynlcSkyfire).append(additionalProperties).append(akfireInterconnectQuic).append(fastlySkyfire).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Cdns)) {
            return false;
        }
        Cdns rhs = ((Cdns) other);
        return new EqualsBuilder().append(fastlynlcSkyfire, rhs.fastlynlcSkyfire).append(additionalProperties, rhs.additionalProperties).append(akfireInterconnectQuic, rhs.akfireInterconnectQuic).append(fastlySkyfire, rhs.fastlySkyfire).isEquals();
    }

}
