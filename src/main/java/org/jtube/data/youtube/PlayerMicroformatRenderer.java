
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
    "thumbnail",
    "embed",
    "title",
    "description",
    "lengthSeconds",
    "ownerProfileUrl",
    "externalChannelId",
    "isFamilySafe",
    "availableCountries",
    "isUnlisted",
    "hasYpcMetadata",
    "viewCount",
    "category",
    "publishDate",
    "ownerChannelName",
    "uploadDate"
})
public class PlayerMicroformatRenderer {

    @JsonProperty("thumbnail")
    @Valid
    private Thumbnail__ thumbnail;
    @JsonProperty("embed")
    @Valid
    private Embed embed;
    @JsonProperty("title")
    @Valid
    private Title title;
    @JsonProperty("description")
    @Valid
    private Description description;
    @JsonProperty("lengthSeconds")
    private String lengthSeconds;
    @JsonProperty("ownerProfileUrl")
    private String ownerProfileUrl;
    @JsonProperty("externalChannelId")
    private String externalChannelId;
    @JsonProperty("isFamilySafe")
    private boolean isFamilySafe;
    @JsonProperty("availableCountries")
    @Valid
    private List<String> availableCountries = null;
    @JsonProperty("isUnlisted")
    private boolean isUnlisted;
    @JsonProperty("hasYpcMetadata")
    private boolean hasYpcMetadata;
    @JsonProperty("viewCount")
    private String viewCount;
    @JsonProperty("category")
    private String category;
    @JsonProperty("publishDate")
    private String publishDate;
    @JsonProperty("ownerChannelName")
    private String ownerChannelName;
    @JsonProperty("uploadDate")
    private String uploadDate;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PlayerMicroformatRenderer() {
    }

    public PlayerMicroformatRenderer(Thumbnail__ thumbnail, Embed embed, Title title, Description description, String lengthSeconds, String ownerProfileUrl, String externalChannelId, boolean isFamilySafe, List<String> availableCountries, boolean isUnlisted, boolean hasYpcMetadata, String viewCount, String category, String publishDate, String ownerChannelName, String uploadDate) {
        super();
        this.thumbnail = thumbnail;
        this.embed = embed;
        this.title = title;
        this.description = description;
        this.lengthSeconds = lengthSeconds;
        this.ownerProfileUrl = ownerProfileUrl;
        this.externalChannelId = externalChannelId;
        this.isFamilySafe = isFamilySafe;
        this.availableCountries = availableCountries;
        this.isUnlisted = isUnlisted;
        this.hasYpcMetadata = hasYpcMetadata;
        this.viewCount = viewCount;
        this.category = category;
        this.publishDate = publishDate;
        this.ownerChannelName = ownerChannelName;
        this.uploadDate = uploadDate;
    }

    @JsonProperty("thumbnail")
    public Thumbnail__ getThumbnail() {
        return thumbnail;
    }

    @JsonProperty("thumbnail")
    public void setThumbnail(Thumbnail__ thumbnail) {
        this.thumbnail = thumbnail;
    }

    @JsonProperty("embed")
    public Embed getEmbed() {
        return embed;
    }

    @JsonProperty("embed")
    public void setEmbed(Embed embed) {
        this.embed = embed;
    }

    @JsonProperty("title")
    public Title getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(Title title) {
        this.title = title;
    }

    @JsonProperty("description")
    public Description getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(Description description) {
        this.description = description;
    }

    @JsonProperty("lengthSeconds")
    public String getLengthSeconds() {
        return lengthSeconds;
    }

    @JsonProperty("lengthSeconds")
    public void setLengthSeconds(String lengthSeconds) {
        this.lengthSeconds = lengthSeconds;
    }

    @JsonProperty("ownerProfileUrl")
    public String getOwnerProfileUrl() {
        return ownerProfileUrl;
    }

    @JsonProperty("ownerProfileUrl")
    public void setOwnerProfileUrl(String ownerProfileUrl) {
        this.ownerProfileUrl = ownerProfileUrl;
    }

    @JsonProperty("externalChannelId")
    public String getExternalChannelId() {
        return externalChannelId;
    }

    @JsonProperty("externalChannelId")
    public void setExternalChannelId(String externalChannelId) {
        this.externalChannelId = externalChannelId;
    }

    @JsonProperty("isFamilySafe")
    public boolean isIsFamilySafe() {
        return isFamilySafe;
    }

    @JsonProperty("isFamilySafe")
    public void setIsFamilySafe(boolean isFamilySafe) {
        this.isFamilySafe = isFamilySafe;
    }

    @JsonProperty("availableCountries")
    public List<String> getAvailableCountries() {
        return availableCountries;
    }

    @JsonProperty("availableCountries")
    public void setAvailableCountries(List<String> availableCountries) {
        this.availableCountries = availableCountries;
    }

    @JsonProperty("isUnlisted")
    public boolean isIsUnlisted() {
        return isUnlisted;
    }

    @JsonProperty("isUnlisted")
    public void setIsUnlisted(boolean isUnlisted) {
        this.isUnlisted = isUnlisted;
    }

    @JsonProperty("hasYpcMetadata")
    public boolean isHasYpcMetadata() {
        return hasYpcMetadata;
    }

    @JsonProperty("hasYpcMetadata")
    public void setHasYpcMetadata(boolean hasYpcMetadata) {
        this.hasYpcMetadata = hasYpcMetadata;
    }

    @JsonProperty("viewCount")
    public String getViewCount() {
        return viewCount;
    }

    @JsonProperty("viewCount")
    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }

    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(String category) {
        this.category = category;
    }

    @JsonProperty("publishDate")
    public String getPublishDate() {
        return publishDate;
    }

    @JsonProperty("publishDate")
    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    @JsonProperty("ownerChannelName")
    public String getOwnerChannelName() {
        return ownerChannelName;
    }

    @JsonProperty("ownerChannelName")
    public void setOwnerChannelName(String ownerChannelName) {
        this.ownerChannelName = ownerChannelName;
    }

    @JsonProperty("uploadDate")
    public String getUploadDate() {
        return uploadDate;
    }

    @JsonProperty("uploadDate")
    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
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
        return new ToStringBuilder(this).append("thumbnail", thumbnail).append("embed", embed).append("title", title).append("description", description).append("lengthSeconds", lengthSeconds).append("ownerProfileUrl", ownerProfileUrl).append("externalChannelId", externalChannelId).append("isFamilySafe", isFamilySafe).append("availableCountries", availableCountries).append("isUnlisted", isUnlisted).append("hasYpcMetadata", hasYpcMetadata).append("viewCount", viewCount).append("category", category).append("publishDate", publishDate).append("ownerChannelName", ownerChannelName).append("uploadDate", uploadDate).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(thumbnail).append(externalChannelId).append(publishDate).append(description).append(lengthSeconds).append(title).append(hasYpcMetadata).append(ownerChannelName).append(uploadDate).append(ownerProfileUrl).append(isUnlisted).append(embed).append(viewCount).append(additionalProperties).append(category).append(isFamilySafe).append(availableCountries).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof PlayerMicroformatRenderer)) {
            return false;
        }
        PlayerMicroformatRenderer rhs = ((PlayerMicroformatRenderer) other);
        return new EqualsBuilder().append(thumbnail, rhs.thumbnail).append(externalChannelId, rhs.externalChannelId).append(publishDate, rhs.publishDate).append(description, rhs.description).append(lengthSeconds, rhs.lengthSeconds).append(title, rhs.title).append(hasYpcMetadata, rhs.hasYpcMetadata).append(ownerChannelName, rhs.ownerChannelName).append(uploadDate, rhs.uploadDate).append(ownerProfileUrl, rhs.ownerProfileUrl).append(isUnlisted, rhs.isUnlisted).append(embed, rhs.embed).append(viewCount, rhs.viewCount).append(additionalProperties, rhs.additionalProperties).append(category, rhs.category).append(isFamilySafe, rhs.isFamilySafe).append(availableCountries, rhs.availableCountries).isEquals();
    }

}
