
package org.jtube.data.vimeo.streams;

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
        "id",
        "base_url",
        "format",
        "mime_type",
        "codecs",
        "bitrate",
        "avg_bitrate",
        "duration",
        "framerate",
        "width",
        "height",
        "channels",
        "sample_rate",
        "max_segment_duration",
        "init_segment",
        "segments"
})
public class Stream {

    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();
    @JsonProperty("id")
    private String id;
    @JsonProperty("base_url")
    private String baseUrl;
    @JsonProperty("format")
    private String format;
    @JsonProperty("mime_type")
    private String mimeType;
    @JsonProperty("codecs")
    private String codecs;
    @JsonProperty("bitrate")
    private int bitrate;
    @JsonProperty("avg_bitrate")
    private int avgBitrate;
    @JsonProperty("duration")
    private double duration;
    @JsonProperty("framerate")
    private double framerate;
    @JsonProperty("width")
    private int width;
    @JsonProperty("height")
    private int height;
    @JsonProperty("channels")
    private int channels;
    @JsonProperty("sample_rate")
    private int sampleRate;
    @JsonProperty("max_segment_duration")
    private int maxSegmentDuration;
    @JsonProperty("init_segment")
    private String initSegment;
    @JsonProperty("segments")
    private List<Segment> segments = new ArrayList<>();

    /**
     * No args constructor for use in serialization
     */
    public Stream() {
    }

    public Stream(String id, String baseUrl, String format, String mimeType, String codecs, int bitrate, int avgBitrate, double duration, double framerate, int width, int height, int channels, int sampleRate, int maxSegmentDuration, String initSegment, List<Segment> segments) {
        super();
        this.id = id;
        this.baseUrl = baseUrl;
        this.format = format;
        this.mimeType = mimeType;
        this.codecs = codecs;
        this.bitrate = bitrate;
        this.avgBitrate = avgBitrate;
        this.duration = duration;
        this.framerate = framerate;
        this.width = width;
        this.height = height;
        this.channels = channels;
        this.sampleRate = sampleRate;
        this.maxSegmentDuration = maxSegmentDuration;
        this.initSegment = initSegment;
        this.segments = segments;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public Stream withId(String id) {
        this.id = id;
        return this;
    }

    @JsonProperty("base_url")
    public String getBaseUrl() {
        return baseUrl;
    }

    @JsonProperty("base_url")
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Stream withBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    @JsonProperty("format")
    public String getFormat() {
        return format;
    }

    @JsonProperty("format")
    public void setFormat(String format) {
        this.format = format;
    }

    public Stream withFormat(String format) {
        this.format = format;
        return this;
    }

    @JsonProperty("mime_type")
    public String getMimeType() {
        return mimeType;
    }

    @JsonProperty("mime_type")
    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public Stream withMimeType(String mimeType) {
        this.mimeType = mimeType;
        return this;
    }

    @JsonProperty("codecs")
    public String getCodecs() {
        return codecs;
    }

    @JsonProperty("codecs")
    public void setCodecs(String codecs) {
        this.codecs = codecs;
    }

    public Stream withCodecs(String codecs) {
        this.codecs = codecs;
        return this;
    }

    @JsonProperty("bitrate")
    public int getBitrate() {
        return bitrate;
    }

    @JsonProperty("bitrate")
    public void setBitrate(int bitrate) {
        this.bitrate = bitrate;
    }

    public Stream withBitrate(int bitrate) {
        this.bitrate = bitrate;
        return this;
    }

    @JsonProperty("avg_bitrate")
    public int getAvgBitrate() {
        return avgBitrate;
    }

    @JsonProperty("avg_bitrate")
    public void setAvgBitrate(int avgBitrate) {
        this.avgBitrate = avgBitrate;
    }

    public Stream withAvgBitrate(int avgBitrate) {
        this.avgBitrate = avgBitrate;
        return this;
    }

    @JsonProperty("duration")
    public double getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(double duration) {
        this.duration = duration;
    }

    public Stream withDuration(double duration) {
        this.duration = duration;
        return this;
    }

    @JsonProperty("framerate")
    public double getFramerate() {
        return framerate;
    }

    @JsonProperty("framerate")
    public void setFramerate(double framerate) {
        this.framerate = framerate;
    }

    public Stream withFramerate(double framerate) {
        this.framerate = framerate;
        return this;
    }

    @JsonProperty("width")
    public int getWidth() {
        return width;
    }

    @JsonProperty("width")
    public void setWidth(int width) {
        this.width = width;
    }

    public Stream withWidth(int width) {
        this.width = width;
        return this;
    }

    @JsonProperty("height")
    public int getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(int height) {
        this.height = height;
    }

    public Stream withHeight(int height) {
        this.height = height;
        return this;
    }

    @JsonProperty("channels")
    public int getChannels() {
        return channels;
    }

    @JsonProperty("channels")
    public void setChannels(int channels) {
        this.channels = channels;
    }

    public Stream withChannels(int channels) {
        this.channels = channels;
        return this;
    }

    @JsonProperty("sample_rate")
    public int getSampleRate() {
        return sampleRate;
    }

    @JsonProperty("sample_rate")
    public void setSampleRate(int sampleRate) {
        this.sampleRate = sampleRate;
    }

    public Stream withSampleRate(int sampleRate) {
        this.sampleRate = sampleRate;
        return this;
    }

    @JsonProperty("max_segment_duration")
    public int getMaxSegmentDuration() {
        return maxSegmentDuration;
    }

    @JsonProperty("max_segment_duration")
    public void setMaxSegmentDuration(int maxSegmentDuration) {
        this.maxSegmentDuration = maxSegmentDuration;
    }

    public Stream withMaxSegmentDuration(int maxSegmentDuration) {
        this.maxSegmentDuration = maxSegmentDuration;
        return this;
    }

    @JsonProperty("init_segment")
    public String getInitSegment() {
        return initSegment;
    }

    @JsonProperty("init_segment")
    public void setInitSegment(String initSegment) {
        this.initSegment = initSegment;
    }

    public Stream withInitSegment(String initSegment) {
        this.initSegment = initSegment;
        return this;
    }

    @JsonProperty("segments")
    public List<Segment> getSegments() {
        return segments;
    }

    @JsonProperty("segments")
    public void setSegments(List<Segment> segments) {
        this.segments = segments;
    }

    public Stream withSegments(List<Segment> segments) {
        this.segments = segments;
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

    public Stream withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("baseUrl", baseUrl).append("format", format).append("mimeType", mimeType).append("codecs", codecs).append("bitrate", bitrate).append("avgBitrate", avgBitrate).append("duration", duration).append("framerate", framerate).append("width", width).append("height", height).append("maxSegmentDuration", maxSegmentDuration).append("initSegment", initSegment).append("segments", segments).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(maxSegmentDuration).append(avgBitrate).append(framerate).append(codecs).append(format).append(bitrate).append(mimeType).append(segments).append(duration).append(initSegment).append(baseUrl).append(width).append(id).append(additionalProperties).append(height).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Stream)) {
            return false;
        }
        Stream rhs = ((Stream) other);
        return new EqualsBuilder().append(maxSegmentDuration, rhs.maxSegmentDuration).append(avgBitrate, rhs.avgBitrate).append(framerate, rhs.framerate).append(codecs, rhs.codecs).append(format, rhs.format).append(bitrate, rhs.bitrate).append(mimeType, rhs.mimeType).append(segments, rhs.segments).append(duration, rhs.duration).append(initSegment, rhs.initSegment).append(baseUrl, rhs.baseUrl).append(width, rhs.width).append(id, rhs.id).append(additionalProperties, rhs.additionalProperties).append(height, rhs.height).isEquals();
    }

}
