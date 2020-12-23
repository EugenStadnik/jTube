
package org.jtube.data.youtube;

import java.util.HashMap;
import java.util.List;
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
    "thumbnails"
})
public class Thumbnail {

    @JsonProperty("thumbnails")
    @Valid
    private List<Thumbnail_> thumbnails = null;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Thumbnail() {
    }

    public Thumbnail(List<Thumbnail_> thumbnails) {
        super();
        this.thumbnails = thumbnails;
    }

    @JsonProperty("thumbnails")
    public List<Thumbnail_> getThumbnails() {
        return thumbnails;
    }

    @JsonProperty("thumbnails")
    public void setThumbnails(List<Thumbnail_> thumbnails) {
        this.thumbnails = thumbnails;
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
        return new ToStringBuilder(this).append("thumbnails", thumbnails).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(thumbnails).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Thumbnail)) {
            return false;
        }
        Thumbnail rhs = ((Thumbnail) other);
        return new EqualsBuilder().append(thumbnails, rhs.thumbnails).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
