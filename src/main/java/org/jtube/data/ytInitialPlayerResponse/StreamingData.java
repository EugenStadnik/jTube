
package org.jtube.data.ytInitialPlayerResponse;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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
    "expiresInSeconds",
    "formats",
    "adaptiveFormats",
    "dashManifestUrl"
})
public class StreamingData {

    @JsonProperty("expiresInSeconds")
    private String expiresInSeconds;
    @JsonProperty("formats")
    @Valid
    private List<MediaFormat> formats = null;
    @JsonProperty("adaptiveFormats")
    @Valid
    private List<MediaFormat> adaptiveFormats = null;
    @JsonProperty("dashManifestUrl")
    private String dashManifestUrl;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public StreamingData() {
    }

    public StreamingData(String expiresInSeconds, List<MediaFormat> formats, List<MediaFormat> adaptiveFormats, String dashManifestUrl) {
        super();
        this.expiresInSeconds = expiresInSeconds;
        this.formats = formats;
        this.adaptiveFormats = adaptiveFormats;
        this.dashManifestUrl = dashManifestUrl;
    }

    @JsonProperty("expiresInSeconds")
    public String getExpiresInSeconds() {
        return expiresInSeconds;
    }

    @JsonProperty("expiresInSeconds")
    public void setExpiresInSeconds(String expiresInSeconds) {
        this.expiresInSeconds = expiresInSeconds;
    }

    @JsonProperty("formats")
    public List<MediaFormat> getFormats() {
        return formats;
    }

    @JsonProperty("formats")
    public void setFormats(List<MediaFormat> formats) {
        this.formats = formats;
    }

    @JsonProperty("adaptiveFormats")
    public List<MediaFormat> getAdaptiveFormats() {
        return adaptiveFormats;
    }

    @JsonProperty("adaptiveFormats")
    public void setAdaptiveFormats(List<MediaFormat> adaptiveFormats) {
        this.adaptiveFormats = adaptiveFormats;
    }

    @JsonProperty("dashManifestUrl")
    public String getDashManifestUrl() {
        return dashManifestUrl;
    }

    @JsonProperty("dashManifestUrl")
    public void setDashManifestUrl(String dashManifestUrl) {
        this.dashManifestUrl = dashManifestUrl;
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
        return new ToStringBuilder(this).append("expiresInSeconds", expiresInSeconds).append("formats", formats).append("adaptiveFormats", adaptiveFormats).append("dashManifestUrl", dashManifestUrl).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(dashManifestUrl).append(formats).append(adaptiveFormats).append(additionalProperties).append(expiresInSeconds).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof StreamingData)) {
            return false;
        }
        StreamingData rhs = ((StreamingData) other);
        return new EqualsBuilder().append(dashManifestUrl, rhs.dashManifestUrl).append(formats, rhs.formats).append(adaptiveFormats, rhs.adaptiveFormats).append(additionalProperties, rhs.additionalProperties).append(expiresInSeconds, rhs.expiresInSeconds).isEquals();
    }

    public List<MediaFormat> getFormats(MediaFormatType mediaFormatType) {
        return Stream.concat(adaptiveFormats.stream(), formats.stream())
                .filter((mediaFormat) -> mediaFormat.getMediaFormatType().equals(mediaFormatType))
                .sorted()
                .collect(Collectors.toList());
    }

    public MediaFormat getBestVideoFormat(QualityLabel qualityLabel) {
        return getFormats(MediaFormatType.VIDEO).stream()
                .filter((mediaFormat) -> mediaFormat.getQualityLabel().equals(qualityLabel))
                .findFirst().orElse(null);
    }

    public MediaFormat getBestAudioFormat(int bps) {
        return getFormats(MediaFormatType.AUDIO).stream()
                .filter((mediaFormat) -> mediaFormat.getBitrate() <= bps)
                .findFirst().orElse(null);
    }

}
