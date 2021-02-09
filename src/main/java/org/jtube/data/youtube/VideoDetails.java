
package org.jtube.data.youtube;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "videoId",
    "title",
    "lengthSeconds",
    "channelId",
    "isOwnerViewing",
    "shortDescription",
    "isCrawlable",
    "thumbnail",
    "averageRating",
    "allowRatings",
    "viewCount",
    "author",
    "isPrivate",
    "isUnpluggedCorpus",
    "isLiveContent"
})
public class VideoDetails {

    @JsonProperty("videoId")
    private String videoId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("lengthSeconds")
    private String lengthSeconds;
    @JsonProperty("channelId")
    private String channelId;
    @JsonProperty("isOwnerViewing")
    private boolean isOwnerViewing;
    @JsonProperty("shortDescription")
    private String shortDescription;
    @JsonProperty("isCrawlable")
    private boolean isCrawlable;
    @JsonProperty("thumbnail")
    @Valid
    private Thumbnail thumbnail;
    @JsonProperty("averageRating")
    private double averageRating;
    @JsonProperty("allowRatings")
    private boolean allowRatings;
    @JsonProperty("viewCount")
    private String viewCount;
    @JsonProperty("author")
    private String author;
    @JsonProperty("isPrivate")
    private boolean isPrivate;
    @JsonProperty("isUnpluggedCorpus")
    private boolean isUnpluggedCorpus;
    @JsonProperty("isLiveContent")
    private boolean isLiveContent;
    @JsonIgnore
    @Valid
    private final Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public VideoDetails() {
    }

    public VideoDetails(String videoId, String title, String lengthSeconds, String channelId, boolean isOwnerViewing, String shortDescription, boolean isCrawlable, Thumbnail thumbnail, double averageRating, boolean allowRatings, String viewCount, String author, boolean isPrivate, boolean isUnpluggedCorpus, boolean isLiveContent) {
        super();
        this.videoId = videoId;
        this.title = title;
        this.lengthSeconds = lengthSeconds;
        this.channelId = channelId;
        this.isOwnerViewing = isOwnerViewing;
        this.shortDescription = shortDescription;
        this.isCrawlable = isCrawlable;
        this.thumbnail = thumbnail;
        this.averageRating = averageRating;
        this.allowRatings = allowRatings;
        this.viewCount = viewCount;
        this.author = author;
        this.isPrivate = isPrivate;
        this.isUnpluggedCorpus = isUnpluggedCorpus;
        this.isLiveContent = isLiveContent;
    }

    @JsonProperty("videoId")
    public String getVideoId() {
        return videoId;
    }

    @JsonProperty("videoId")
    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("lengthSeconds")
    public String getLengthSeconds() {
        return lengthSeconds;
    }

    @JsonProperty("lengthSeconds")
    public void setLengthSeconds(String lengthSeconds) {
        this.lengthSeconds = lengthSeconds;
    }

    @JsonProperty("channelId")
    public String getChannelId() {
        return channelId;
    }

    @JsonProperty("channelId")
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    @JsonProperty("isOwnerViewing")
    public boolean isIsOwnerViewing() {
        return isOwnerViewing;
    }

    @JsonProperty("isOwnerViewing")
    public void setIsOwnerViewing(boolean isOwnerViewing) {
        this.isOwnerViewing = isOwnerViewing;
    }

    @JsonProperty("shortDescription")
    public String getShortDescription() {
        return shortDescription;
    }

    @JsonProperty("shortDescription")
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @JsonProperty("isCrawlable")
    public boolean isIsCrawlable() {
        return isCrawlable;
    }

    @JsonProperty("isCrawlable")
    public void setIsCrawlable(boolean isCrawlable) {
        this.isCrawlable = isCrawlable;
    }

    @JsonProperty("thumbnail")
    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    @JsonProperty("thumbnail")
    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    @JsonProperty("averageRating")
    public double getAverageRating() {
        return averageRating;
    }

    @JsonProperty("averageRating")
    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    @JsonProperty("allowRatings")
    public boolean isAllowRatings() {
        return allowRatings;
    }

    @JsonProperty("allowRatings")
    public void setAllowRatings(boolean allowRatings) {
        this.allowRatings = allowRatings;
    }

    @JsonProperty("viewCount")
    public String getViewCount() {
        return viewCount;
    }

    @JsonProperty("viewCount")
    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }

    @JsonProperty("author")
    public String getAuthor() {
        return author;
    }

    @JsonProperty("author")
    public void setAuthor(String author) {
        this.author = author;
    }

    @JsonProperty("isPrivate")
    public boolean isIsPrivate() {
        return isPrivate;
    }

    @JsonProperty("isPrivate")
    public void setIsPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    @JsonProperty("isUnpluggedCorpus")
    public boolean isIsUnpluggedCorpus() {
        return isUnpluggedCorpus;
    }

    @JsonProperty("isUnpluggedCorpus")
    public void setIsUnpluggedCorpus(boolean isUnpluggedCorpus) {
        this.isUnpluggedCorpus = isUnpluggedCorpus;
    }

    @JsonProperty("isLiveContent")
    public boolean isIsLiveContent() {
        return isLiveContent;
    }

    @JsonProperty("isLiveContent")
    public void setIsLiveContent(boolean isLiveContent) {
        this.isLiveContent = isLiveContent;
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
        return new ToStringBuilder(this).append("videoId", videoId).append("title", title).append("lengthSeconds", lengthSeconds).append("channelId", channelId).append("isOwnerViewing", isOwnerViewing).append("shortDescription", shortDescription).append("isCrawlable", isCrawlable).append("thumbnail", thumbnail).append("averageRating", averageRating).append("allowRatings", allowRatings).append("viewCount", viewCount).append("author", author).append("isPrivate", isPrivate).append("isUnpluggedCorpus", isUnpluggedCorpus).append("isLiveContent", isLiveContent).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(isOwnerViewing).append(thumbnail).append(isLiveContent).append(author).append(lengthSeconds).append(videoId).append(shortDescription).append(isPrivate).append(title).append(isCrawlable).append(averageRating).append(isUnpluggedCorpus).append(allowRatings).append(viewCount).append(additionalProperties).append(channelId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof VideoDetails)) {
            return false;
        }
        VideoDetails rhs = ((VideoDetails) other);
        return new EqualsBuilder().append(isOwnerViewing, rhs.isOwnerViewing).append(thumbnail, rhs.thumbnail).append(isLiveContent, rhs.isLiveContent).append(author, rhs.author).append(lengthSeconds, rhs.lengthSeconds).append(videoId, rhs.videoId).append(shortDescription, rhs.shortDescription).append(isPrivate, rhs.isPrivate).append(title, rhs.title).append(isCrawlable, rhs.isCrawlable).append(averageRating, rhs.averageRating).append(isUnpluggedCorpus, rhs.isUnpluggedCorpus).append(allowRatings, rhs.allowRatings).append(viewCount, rhs.viewCount).append(additionalProperties, rhs.additionalProperties).append(channelId, rhs.channelId).isEquals();
    }

}
