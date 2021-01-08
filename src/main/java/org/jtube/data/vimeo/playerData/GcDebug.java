
package org.jtube.data.vimeo.playerData;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "bucket"
})
public class GcDebug {

    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();
    @JsonProperty("bucket")
    private String bucket;

    /**
     * No args constructor for use in serialization
     */
    public GcDebug() {
    }

    public GcDebug(String bucket) {
        super();
        this.bucket = bucket;
    }

    @JsonProperty("bucket")
    public String getBucket() {
        return bucket;
    }

    @JsonProperty("bucket")
    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public GcDebug withBucket(String bucket) {
        this.bucket = bucket;
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

    public GcDebug withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("bucket", bucket).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(bucket).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof GcDebug)) {
            return false;
        }
        GcDebug rhs = ((GcDebug) other);
        return new EqualsBuilder().append(bucket, rhs.bucket).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
