package org.jtube.data.result;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.json.JSONObject;
import org.jtube.data.MultimediaFormatType;
import org.jtube.data.youtube.QualityLabel;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"type",
		"resolution",
		"frameRate",
		"audioSampleRate",
		"bitRate",
		"urls"
})
public class MultiMediaStream implements Comparable<MultiMediaStream> {

	@JsonProperty("type")
	private MultimediaFormatType type;
	@JsonProperty("resolution")
	private QualityLabel resolution;
	@JsonProperty("frameRate")
	private Long frameRate;
	@JsonProperty("audioSampleRate")
	private String audioSampleRate;
	@JsonProperty("bitRate")
	private long bitRate;
	@JsonProperty("urls")
	private List<URL> urls = new ArrayList<>();
	@JsonProperty("codecs")
	private List<String> codecs = new ArrayList<>();

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public MultiMediaStream() {
	}

	public MultiMediaStream(MultimediaFormatType type, QualityLabel resolution, Long frameRate, String audioSampleRate, int bitRate, List<URL> urls, List<String> codecs) {
		super();
		this.type = type;
		this.resolution = resolution;
		this.frameRate = frameRate;
		this.audioSampleRate = audioSampleRate;
		this.bitRate = bitRate;
		this.urls = urls;
		this.codecs = codecs;
	}

	@JsonProperty("type")
	public MultimediaFormatType getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(MultimediaFormatType type) {
		this.type = type;
	}

	public MultiMediaStream withType(MultimediaFormatType type) {
		this.type = type;
		return this;
	}

	@JsonProperty("resolution")
	public String getResolution() {
		return resolution.toString();
	}

	@JsonProperty("resolution")
	public void setResolution(QualityLabel resolution) {
		this.resolution = resolution;
	}

	public MultiMediaStream withResolution(QualityLabel resolution) {
		this.resolution = resolution;
		return this;
	}

	@JsonProperty("frameRate")
	public Long getFrameRate() {
		return frameRate;
	}

	@JsonProperty("frameRate")
	public void setFrameRate(Long frameRate) {
		this.frameRate = frameRate;
	}

	public MultiMediaStream withFrameRate(Long frameRate) {
		this.frameRate = frameRate;
		return this;
	}

	@JsonProperty("audioSampleRate")
	public String getAudioSampleRate() {
		return audioSampleRate;
	}

	@JsonProperty("audioSampleRate")
	public void setAudioSampleRate(String audioSampleRate) {
		this.audioSampleRate = audioSampleRate;
	}

	public MultiMediaStream withAudioSampleRate(String audioSampleRate) {
		this.audioSampleRate = audioSampleRate;
		return this;
	}

	@JsonProperty("bitRate")
	public long getBitRate() {
		return bitRate;
	}

	@JsonProperty("bitRate")
	public void setBitRate(long bitRate) {
		this.bitRate = bitRate;
	}

	public MultiMediaStream withBitRate(long bitRate) {
		this.bitRate = bitRate;
		return this;
	}

	@JsonProperty("urls")
	public List<URL> getUrls() {
		return urls;
	}

	@JsonProperty("urls")
	public void setUrls(List<URL> urls) {
		this.urls = urls;
	}

	public MultiMediaStream withUrls(List<URL> urls) {
		this.urls = urls;
		return this;
	}

	@JsonProperty("codecs")
	public List<String> getCodecs() {
		return codecs;
	}

	@JsonProperty("codecs")
	public void setCodecs(List<String> codecs) {
		this.codecs = codecs;
	}

	public MultiMediaStream withCodecs(List<String> codecs) {
		this.codecs = codecs;
		return this;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(frameRate).append(urls).append(bitRate).append(type).append(resolution).append(audioSampleRate).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if (!(other instanceof MultiMediaStream)) {
			return false;
		}
		MultiMediaStream rhs = ((MultiMediaStream) other);
		return new EqualsBuilder().append(frameRate, rhs.frameRate).append(urls, rhs.urls).append(bitRate, rhs.bitRate).append(type, rhs.type).append(resolution, rhs.resolution).append(audioSampleRate, rhs.audioSampleRate).isEquals();
	}

	@Override
	public String toString() {
		return new JSONObject(this).toString(3);
	}

	@Override
	public int compareTo(MultiMediaStream other) {
		if(other.bitRate != 0 && this.bitRate != 0) {
			return (int)(other.bitRate - this.bitRate);
		} else if(other.resolution != null && this.resolution != null) {
			return this.resolution.compareTo(other.resolution);
		}
		return 0;
	}

}