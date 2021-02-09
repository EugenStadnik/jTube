
package org.jtube.data.vimeo.playerData;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "fullscreen",
        "byline",
        "like",
        "playbar",
        "title",
        "color",
        "speed",
        "watch_later",
        "share",
        "scaling",
        "spatial_compass",
        "collections",
        "info_on_pause",
        "portrait",
        "logo",
        "embed",
        "badge",
        "spatial_label",
        "volume"
})
public class Settings {

    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();
    @JsonProperty("fullscreen")
    private int fullscreen;
    @JsonProperty("byline")
    private int byline;
    @JsonProperty("like")
    private int like;
    @JsonProperty("playbar")
    private int playbar;
    @JsonProperty("title")
    private int title;
    @JsonProperty("color")
    private int color;
    @JsonProperty("speed")
    private int speed;
    @JsonProperty("watch_later")
    private int watchLater;
    @JsonProperty("share")
    private int share;
    @JsonProperty("scaling")
    private int scaling;
    @JsonProperty("spatial_compass")
    private int spatialCompass;
    @JsonProperty("collections")
    private int collections;
    @JsonProperty("info_on_pause")
    private int infoOnPause;
    @JsonProperty("portrait")
    private int portrait;
    @JsonProperty("logo")
    private int logo;
    @JsonProperty("embed")
    private int embed;
    @JsonProperty("badge")
    private Object badge;
    @JsonProperty("spatial_label")
    private int spatialLabel;
    @JsonProperty("volume")
    private int volume;

    /**
     * No args constructor for use in serialization
     */
    public Settings() {
    }

    public Settings(int fullscreen, int byline, int like, int playbar, int title, int color, int speed, int watchLater, int share, int scaling, int spatialCompass, int collections, int infoOnPause, int portrait, int logo, int embed, Object badge, int spatialLabel, int volume) {
        super();
        this.fullscreen = fullscreen;
        this.byline = byline;
        this.like = like;
        this.playbar = playbar;
        this.title = title;
        this.color = color;
        this.speed = speed;
        this.watchLater = watchLater;
        this.share = share;
        this.scaling = scaling;
        this.spatialCompass = spatialCompass;
        this.collections = collections;
        this.infoOnPause = infoOnPause;
        this.portrait = portrait;
        this.logo = logo;
        this.embed = embed;
        this.badge = badge;
        this.spatialLabel = spatialLabel;
        this.volume = volume;
    }

    @JsonProperty("fullscreen")
    public int getFullscreen() {
        return fullscreen;
    }

    @JsonProperty("fullscreen")
    public void setFullscreen(int fullscreen) {
        this.fullscreen = fullscreen;
    }

    public Settings withFullscreen(int fullscreen) {
        this.fullscreen = fullscreen;
        return this;
    }

    @JsonProperty("byline")
    public int getByline() {
        return byline;
    }

    @JsonProperty("byline")
    public void setByline(int byline) {
        this.byline = byline;
    }

    public Settings withByline(int byline) {
        this.byline = byline;
        return this;
    }

    @JsonProperty("like")
    public int getLike() {
        return like;
    }

    @JsonProperty("like")
    public void setLike(int like) {
        this.like = like;
    }

    public Settings withLike(int like) {
        this.like = like;
        return this;
    }

    @JsonProperty("playbar")
    public int getPlaybar() {
        return playbar;
    }

    @JsonProperty("playbar")
    public void setPlaybar(int playbar) {
        this.playbar = playbar;
    }

    public Settings withPlaybar(int playbar) {
        this.playbar = playbar;
        return this;
    }

    @JsonProperty("title")
    public int getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(int title) {
        this.title = title;
    }

    public Settings withTitle(int title) {
        this.title = title;
        return this;
    }

    @JsonProperty("color")
    public int getColor() {
        return color;
    }

    @JsonProperty("color")
    public void setColor(int color) {
        this.color = color;
    }

    public Settings withColor(int color) {
        this.color = color;
        return this;
    }

    @JsonProperty("speed")
    public int getSpeed() {
        return speed;
    }

    @JsonProperty("speed")
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Settings withSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    @JsonProperty("watch_later")
    public int getWatchLater() {
        return watchLater;
    }

    @JsonProperty("watch_later")
    public void setWatchLater(int watchLater) {
        this.watchLater = watchLater;
    }

    public Settings withWatchLater(int watchLater) {
        this.watchLater = watchLater;
        return this;
    }

    @JsonProperty("share")
    public int getShare() {
        return share;
    }

    @JsonProperty("share")
    public void setShare(int share) {
        this.share = share;
    }

    public Settings withShare(int share) {
        this.share = share;
        return this;
    }

    @JsonProperty("scaling")
    public int getScaling() {
        return scaling;
    }

    @JsonProperty("scaling")
    public void setScaling(int scaling) {
        this.scaling = scaling;
    }

    public Settings withScaling(int scaling) {
        this.scaling = scaling;
        return this;
    }

    @JsonProperty("spatial_compass")
    public int getSpatialCompass() {
        return spatialCompass;
    }

    @JsonProperty("spatial_compass")
    public void setSpatialCompass(int spatialCompass) {
        this.spatialCompass = spatialCompass;
    }

    public Settings withSpatialCompass(int spatialCompass) {
        this.spatialCompass = spatialCompass;
        return this;
    }

    @JsonProperty("collections")
    public int getCollections() {
        return collections;
    }

    @JsonProperty("collections")
    public void setCollections(int collections) {
        this.collections = collections;
    }

    public Settings withCollections(int collections) {
        this.collections = collections;
        return this;
    }

    @JsonProperty("info_on_pause")
    public int getInfoOnPause() {
        return infoOnPause;
    }

    @JsonProperty("info_on_pause")
    public void setInfoOnPause(int infoOnPause) {
        this.infoOnPause = infoOnPause;
    }

    public Settings withInfoOnPause(int infoOnPause) {
        this.infoOnPause = infoOnPause;
        return this;
    }

    @JsonProperty("portrait")
    public int getPortrait() {
        return portrait;
    }

    @JsonProperty("portrait")
    public void setPortrait(int portrait) {
        this.portrait = portrait;
    }

    public Settings withPortrait(int portrait) {
        this.portrait = portrait;
        return this;
    }

    @JsonProperty("logo")
    public int getLogo() {
        return logo;
    }

    @JsonProperty("logo")
    public void setLogo(int logo) {
        this.logo = logo;
    }

    public Settings withLogo(int logo) {
        this.logo = logo;
        return this;
    }

    @JsonProperty("embed")
    public int getEmbed() {
        return embed;
    }

    @JsonProperty("embed")
    public void setEmbed(int embed) {
        this.embed = embed;
    }

    public Settings withEmbed(int embed) {
        this.embed = embed;
        return this;
    }

    @JsonProperty("badge")
    public Object getBadge() {
        return badge;
    }

    @JsonProperty("badge")
    public void setBadge(Object badge) {
        this.badge = badge;
    }

    public Settings withBadge(Object badge) {
        this.badge = badge;
        return this;
    }

    @JsonProperty("spatial_label")
    public int getSpatialLabel() {
        return spatialLabel;
    }

    @JsonProperty("spatial_label")
    public void setSpatialLabel(int spatialLabel) {
        this.spatialLabel = spatialLabel;
    }

    public Settings withSpatialLabel(int spatialLabel) {
        this.spatialLabel = spatialLabel;
        return this;
    }

    @JsonProperty("volume")
    public int getVolume() {
        return volume;
    }

    @JsonProperty("volume")
    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Settings withVolume(int volume) {
        this.volume = volume;
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

    public Settings withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("fullscreen", fullscreen).append("byline", byline).append("like", like).append("playbar", playbar).append("title", title).append("color", color).append("speed", speed).append("watchLater", watchLater).append("share", share).append("scaling", scaling).append("spatialCompass", spatialCompass).append("collections", collections).append("infoOnPause", infoOnPause).append("portrait", portrait).append("logo", logo).append("embed", embed).append("badge", badge).append("spatialLabel", spatialLabel).append("volume", volume).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(spatialLabel).append(scaling).append(color).append(like).append(watchLater).append(playbar).append(title).append(portrait).append(speed).append(infoOnPause).append(volume).append(badge).append(fullscreen).append(collections).append(logo).append(share).append(embed).append(additionalProperties).append(byline).append(spatialCompass).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Settings)) {
            return false;
        }
        Settings rhs = ((Settings) other);
        return new EqualsBuilder().append(spatialLabel, rhs.spatialLabel).append(scaling, rhs.scaling).append(color, rhs.color).append(like, rhs.like).append(watchLater, rhs.watchLater).append(playbar, rhs.playbar).append(title, rhs.title).append(portrait, rhs.portrait).append(speed, rhs.speed).append(infoOnPause, rhs.infoOnPause).append(volume, rhs.volume).append(badge, rhs.badge).append(fullscreen, rhs.fullscreen).append(collections, rhs.collections).append(logo, rhs.logo).append(share, rhs.share).append(embed, rhs.embed).append(additionalProperties, rhs.additionalProperties).append(byline, rhs.byline).append(spatialCompass, rhs.spatialCompass).isEquals();
    }

}
