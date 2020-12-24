
package org.jtube.data.youtube;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
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
import org.jtube.data.MultimediaFormatType;
import org.jtube.utils.Constants;

import static org.jtube.data.MultimediaFormatType.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "itag",
        "url",
        "mimeType",
        "bitrate",
        "width",
        "height",
        "initRange",
        "indexRange",
        "lastModified",
        "contentLength",
        "quality",
        "fps",
        "qualityLabel",
        "projectionType",
        "averageBitrate",
        "approxDurationMs",
        "type",
        "highReplication",
        "audioQuality",
        "audioSampleRate",
        "audioChannels",
        "loudnessDb"
})
public class Format implements Comparable<Format> {

    @JsonProperty("initRange")
    @Valid
    private InitRange initRange;
    @JsonProperty("indexRange")
    @Valid
    private IndexRange indexRange;
    @JsonProperty("type")
    private String type;
    @JsonProperty("highReplication")
    private boolean highReplication;
    @JsonProperty("loudnessDb")
    private double loudnessDb;



    @JsonProperty("itag")
    private int itag;
    @JsonProperty("url")
    @Valid
    private URL url;
    @JsonProperty("mimeType")
    private String mimeType;
    @JsonProperty("bitrate")
    private int bitrate;
    @JsonProperty("width")
    private int width;
    @JsonProperty("height")
    private int height;
    @JsonProperty("lastModified")
    private String lastModified;
    @JsonProperty("contentLength")
    private String contentLength;
    @JsonProperty("quality")
    private String quality;
    @JsonProperty("fps")
    private int fps;
    @JsonProperty("qualityLabel")
    private QualityLabel qualityLabel;
    @JsonProperty("projectionType")
    private String projectionType;
    @JsonProperty("averageBitrate")
    private int averageBitrate;
    @JsonProperty("audioQuality")
    private String audioQuality;
    @JsonProperty("approxDurationMs")
    private String approxDurationMs;
    @JsonProperty("audioSampleRate")
    private String audioSampleRate;
    @JsonProperty("audioChannels")
    private int audioChannels;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Format() {
    }

    public Format(int itag, URL url, String mimeType, int bitrate, int width, int height, InitRange initRange, IndexRange indexRange, String lastModified, String contentLength, String quality, int fps, String qualityLabel, String projectionType, int averageBitrate, String approxDurationMs, String type, boolean highReplication, String audioQuality, String audioSampleRate, int audioChannels, double loudnessDb) {
        super();
        this.initRange = initRange;
        this.indexRange = indexRange;
        this.type = type;
        this.highReplication = highReplication;
        this.loudnessDb = loudnessDb;
        this.itag = itag;
        this.url = url;
        this.mimeType = mimeType;
        this.bitrate = bitrate;
        this.width = width;
        this.height = height;
        this.lastModified = lastModified;
        this.contentLength = contentLength;
        this.quality = quality;
        this.fps = fps;
        this.qualityLabel = QualityLabel.valueOf(qualityLabel);
        this.projectionType = projectionType;
        this.averageBitrate = averageBitrate;
        this.audioQuality = audioQuality;
        this.approxDurationMs = approxDurationMs;
        this.audioSampleRate = audioSampleRate;
        this.audioChannels = audioChannels;
    }

    @JsonProperty("initRange")
    public InitRange getInitRange() {
        return initRange;
    }

    @JsonProperty("initRange")
    public void setInitRange(InitRange initRange) {
        this.initRange = initRange;
    }

    @JsonProperty("indexRange")
    public IndexRange getIndexRange() {
        return indexRange;
    }

    @JsonProperty("indexRange")
    public void setIndexRange(IndexRange indexRange) {
        this.indexRange = indexRange;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("highReplication")
    public boolean isHighReplication() {
        return highReplication;
    }

    @JsonProperty("highReplication")
    public void setHighReplication(boolean highReplication) {
        this.highReplication = highReplication;
    }

    @JsonProperty("loudnessDb")
    public double getLoudnessDb() {
        return loudnessDb;
    }

    @JsonProperty("loudnessDb")
    public void setLoudnessDb(double loudnessDb) {
        this.loudnessDb = loudnessDb;
    }



    @JsonProperty("itag")
    public int getItag() {
        return itag;
    }

    @JsonProperty("itag")
    public void setItag(int itag) {
        this.itag = itag;
    }

    @JsonProperty("url")
    public URL getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(URL url) {
        this.url = url;
    }

    @JsonProperty("mimeType")
    public String getMimeType() {
        return mimeType;
    }

    @JsonProperty("mimeType")
    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    @JsonProperty("bitrate")
    public int getBitrate() {
        return bitrate;
    }

    @JsonProperty("bitrate")
    public void setBitrate(int bitrate) {
        this.bitrate = bitrate;
    }

    @JsonProperty("width")
    public int getWidth() {
        return width;
    }

    @JsonProperty("width")
    public void setWidth(int width) {
        this.width = width;
    }

    @JsonProperty("height")
    public int getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(int height) {
        this.height = height;
    }

    @JsonProperty("lastModified")
    public String getLastModified() {
        return lastModified;
    }

    @JsonProperty("lastModified")
    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    @JsonProperty("contentLength")
    public String getContentLength() {
        return contentLength;
    }

    @JsonProperty("contentLength")
    public void setContentLength(String contentLength) {
        this.contentLength = contentLength;
    }

    @JsonProperty("quality")
    public String getQuality() {
        return quality;
    }

    @JsonProperty("quality")
    public void setQuality(String quality) {
        this.quality = quality;
    }

    @JsonProperty("fps")
    public int getFps() {
        return fps;
    }

    @JsonProperty("fps")
    public void setFps(int fps) {
        this.fps = fps;
    }

    @JsonProperty("qualityLabel")
    public QualityLabel getQualityLabel() {
        return qualityLabel;
    }

    @JsonProperty("qualityLabel")
    public void setQualityLabel(String qualityLabel) {
        this.qualityLabel = QualityLabel.valueOf(qualityLabel);
    }

    @JsonProperty("projectionType")
    public String getProjectionType() {
        return projectionType;
    }

    @JsonProperty("projectionType")
    public void setProjectionType(String projectionType) {
        this.projectionType = projectionType;
    }

    @JsonProperty("averageBitrate")
    public int getAverageBitrate() {
        return averageBitrate;
    }

    @JsonProperty("averageBitrate")
    public void setAverageBitrate(int averageBitrate) {
        this.averageBitrate = averageBitrate;
    }

    @JsonProperty("audioQuality")
    public String getAudioQuality() {
        return audioQuality;
    }

    @JsonProperty("audioQuality")
    public void setAudioQuality(String audioQuality) {
        this.audioQuality = audioQuality;
    }

    @JsonProperty("approxDurationMs")
    public String getApproxDurationMs() {
        return approxDurationMs;
    }

    @JsonProperty("approxDurationMs")
    public void setApproxDurationMs(String approxDurationMs) {
        this.approxDurationMs = approxDurationMs;
    }

    @JsonProperty("audioSampleRate")
    public String getAudioSampleRate() {
        return audioSampleRate;
    }

    @JsonProperty("audioSampleRate")
    public void setAudioSampleRate(String audioSampleRate) {
        this.audioSampleRate = audioSampleRate;
    }

    @JsonProperty("audioChannels")
    public int getAudioChannels() {
        return audioChannels;
    }

    @JsonProperty("audioChannels")
    public void setAudioChannels(int audioChannels) {
        this.audioChannels = audioChannels;
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
        MultimediaFormatType multimediaFormatType = getMediaFormatType();
        return "[" + mimeType + "; "
                + (multimediaFormatType.equals(VIDEO) || multimediaFormatType.equals(AUDIO_VIDEO) ? qualityLabel + "; " + fps + "fps; " : "")
                + (multimediaFormatType.equals(AUDIO) || multimediaFormatType.equals(AUDIO_VIDEO) ? audioSampleRate + "kHz; " : "")
                + averageBitrate + "bps.]";
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(url).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Format)) {
            return false;
        }
        Format rhs = ((Format) other);
        return new EqualsBuilder().append(url, rhs.url).isEquals();
    }

    @Override
    public int compareTo(Format other) {
        return other.bitrate - this.bitrate;
    }

    public MultimediaFormatType getMediaFormatType() {
        if((mimeType.toLowerCase().contains("audio") && mimeType.toLowerCase().contains("video"))
                || (audioSampleRate != null && !audioSampleRate.trim().isEmpty() && mimeType.toLowerCase().contains("video"))) {
            return AUDIO_VIDEO;
        } else if(mimeType.toLowerCase().contains("audio")) {
            return AUDIO;
        } else {
            return VIDEO;
        }
    }

    public String getFileExtension() {
        return "." + mimeType.split("[;]")[0].split("[/]")[1];
    }

    public String getFileSufix() {
        return "_" + getMediaFormatType().toString().toLowerCase() + getFileExtension();
    }

    public File getTemporaryFile(String title) {
        return new File(Constants.TMP + title + getFileSufix());
    }

    public File getMergedFile(String title) {
        return new File(Constants.DOWNLOADED + title + Constants.AVI);
    }
}
