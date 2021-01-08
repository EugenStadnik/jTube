
package org.jtube.data.vimeo.playerData;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "backend",
        "js"
})
public class Build {

    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();
    @JsonProperty("backend")
    private String backend;
    @JsonProperty("js")
    private String js;

    /**
     * No args constructor for use in serialization
     */
    public Build() {
    }

    public Build(String backend, String js) {
        super();
        this.backend = backend;
        this.js = js;
    }

    @JsonProperty("backend")
    public String getBackend() {
        return backend;
    }

    @JsonProperty("backend")
    public void setBackend(String backend) {
        this.backend = backend;
    }

    public Build withBackend(String backend) {
        this.backend = backend;
        return this;
    }

    @JsonProperty("js")
    public String getJs() {
        return js;
    }

    @JsonProperty("js")
    public void setJs(String js) {
        this.js = js;
    }

    public Build withJs(String js) {
        this.js = js;
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

    public Build withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("backend", backend).append("js", js).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(js).append(backend).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Build)) {
            return false;
        }
        Build rhs = ((Build) other);
        return new EqualsBuilder().append(js, rhs.js).append(backend, rhs.backend).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
