
package org.jtube.data.vimeo.playerData;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "1280",
        "960",
        "640",
        "base"
})
public class Thumbs {

    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();
    @JsonProperty("1280")
    private URL _1280;
    @JsonProperty("960")
    private URL _960;
    @JsonProperty("640")
    private URL _640;
    @JsonProperty("base")
    private URL base;

    /**
     * No args constructor for use in serialization
     */
    public Thumbs() {
    }

    public Thumbs(URL _1280, URL _960, URL _640, URL base) {
        super();
        this._1280 = _1280;
        this._960 = _960;
        this._640 = _640;
        this.base = base;
    }

    @JsonProperty("1280")
    public URL get1280() {
        return _1280;
    }

    @JsonProperty("1280")
    public void set1280(URL _1280) {
        this._1280 = _1280;
    }

    public Thumbs with1280(URL _1280) {
        this._1280 = _1280;
        return this;
    }

    @JsonProperty("960")
    public URL get960() {
        return _960;
    }

    @JsonProperty("960")
    public void set960(URL _960) {
        this._960 = _960;
    }

    public Thumbs with960(URL _960) {
        this._960 = _960;
        return this;
    }

    @JsonProperty("640")
    public URL get640() {
        return _640;
    }

    @JsonProperty("640")
    public void set640(URL _640) {
        this._640 = _640;
    }

    public Thumbs with640(URL _640) {
        this._640 = _640;
        return this;
    }

    @JsonProperty("base")
    public URL getBase() {
        return base;
    }

    @JsonProperty("base")
    public void setBase(URL base) {
        this.base = base;
    }

    public Thumbs withBase(URL base) {
        this.base = base;
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

    public Thumbs withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("_1280", _1280).append("_960", _960).append("_640", _640).append("base", base).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(_960).append(_1280).append(additionalProperties).append(_640).append(base).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Thumbs)) {
            return false;
        }
        Thumbs rhs = ((Thumbs) other);
        return new EqualsBuilder().append(_960, rhs._960).append(_1280, rhs._1280).append(additionalProperties, rhs.additionalProperties).append(_640, rhs._640).append(base, rhs.base).isEquals();
    }

}
