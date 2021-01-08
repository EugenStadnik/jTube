
package org.jtube.data.vimeo.playerData;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "chromecast",
        "stats_fresnel"
})
public class AbTests {

    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();
    @JsonProperty("chromecast")
    private Chromecast chromecast;
    @JsonProperty("stats_fresnel")
    private StatsFresnel statsFresnel;

    /**
     * No args constructor for use in serialization
     */
    public AbTests() {
    }

    public AbTests(Chromecast chromecast, StatsFresnel statsFresnel) {
        super();
        this.chromecast = chromecast;
        this.statsFresnel = statsFresnel;
    }

    @JsonProperty("chromecast")
    public Chromecast getChromecast() {
        return chromecast;
    }

    @JsonProperty("chromecast")
    public void setChromecast(Chromecast chromecast) {
        this.chromecast = chromecast;
    }

    public AbTests withChromecast(Chromecast chromecast) {
        this.chromecast = chromecast;
        return this;
    }

    @JsonProperty("stats_fresnel")
    public StatsFresnel getStatsFresnel() {
        return statsFresnel;
    }

    @JsonProperty("stats_fresnel")
    public void setStatsFresnel(StatsFresnel statsFresnel) {
        this.statsFresnel = statsFresnel;
    }

    public AbTests withStatsFresnel(StatsFresnel statsFresnel) {
        this.statsFresnel = statsFresnel;
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

    public AbTests withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("chromecast", chromecast).append("statsFresnel", statsFresnel).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(statsFresnel).append(chromecast).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof AbTests)) {
            return false;
        }
        AbTests rhs = ((AbTests) other);
        return new EqualsBuilder().append(statsFresnel, rhs.statsFresnel).append(chromecast, rhs.chromecast).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
