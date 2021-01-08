
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
        "cdn_url",
        "vimeo_api_url",
        "request",
        "player_url",
        "video",
        "user",
        "embed",
        "view",
        "vimeo_url"
})
public class PlayerData {

    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();
    @JsonProperty("cdn_url")
    private URL cdnUrl;
    @JsonProperty("vimeo_api_url")
    private URL vimeoApiUrl;
    @JsonProperty("request")
    private Request request;
    @JsonProperty("player_url")
    private String playerUrl;
    @JsonProperty("video")
    private Video video;
    @JsonProperty("user")
    private User user;
    @JsonProperty("embed")
    private Embed embed;
    @JsonProperty("view")
    private int view;
    @JsonProperty("vimeo_url")
    private String vimeoUrl;

    /**
     * No args constructor for use in serialization
     */
    public PlayerData() {
    }

    public PlayerData(URL cdnUrl, URL vimeoApiUrl, Request request, String playerUrl, Video video, User user, Embed embed, int view, String vimeoUrl) {
        super();
        this.cdnUrl = cdnUrl;
        this.vimeoApiUrl = vimeoApiUrl;
        this.request = request;
        this.playerUrl = playerUrl;
        this.video = video;
        this.user = user;
        this.embed = embed;
        this.view = view;
        this.vimeoUrl = vimeoUrl;
    }

    @JsonProperty("cdn_url")
    public URL getCdnUrl() {
        return cdnUrl;
    }

    @JsonProperty("cdn_url")
    public void setCdnUrl(URL cdnUrl) {
        this.cdnUrl = cdnUrl;
    }

    public PlayerData withCdnUrl(URL cdnUrl) {
        this.cdnUrl = cdnUrl;
        return this;
    }

    @JsonProperty("vimeo_api_url")
    public URL getVimeoApiUrl() {
        return vimeoApiUrl;
    }

    @JsonProperty("vimeo_api_url")
    public void setVimeoApiUrl(URL vimeoApiUrl) {
        this.vimeoApiUrl = vimeoApiUrl;
    }

    public PlayerData withVimeoApiUrl(URL vimeoApiUrl) {
        this.vimeoApiUrl = vimeoApiUrl;
        return this;
    }

    @JsonProperty("request")
    public Request getRequest() {
        return request;
    }

    @JsonProperty("request")
    public void setRequest(Request request) {
        this.request = request;
    }

    public PlayerData withRequest(Request request) {
        this.request = request;
        return this;
    }

    @JsonProperty("player_url")
    public String getPlayerUrl() {
        return playerUrl;
    }

    @JsonProperty("player_url")
    public void setPlayerUrl(String playerUrl) {
        this.playerUrl = playerUrl;
    }

    public PlayerData withPlayerUrl(String playerUrl) {
        this.playerUrl = playerUrl;
        return this;
    }

    @JsonProperty("video")
    public Video getVideo() {
        return video;
    }

    @JsonProperty("video")
    public void setVideo(Video video) {
        this.video = video;
    }

    public PlayerData withVideo(Video video) {
        this.video = video;
        return this;
    }

    @JsonProperty("user")
    public User getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(User user) {
        this.user = user;
    }

    public PlayerData withUser(User user) {
        this.user = user;
        return this;
    }

    @JsonProperty("embed")
    public Embed getEmbed() {
        return embed;
    }

    @JsonProperty("embed")
    public void setEmbed(Embed embed) {
        this.embed = embed;
    }

    public PlayerData withEmbed(Embed embed) {
        this.embed = embed;
        return this;
    }

    @JsonProperty("view")
    public int getView() {
        return view;
    }

    @JsonProperty("view")
    public void setView(int view) {
        this.view = view;
    }

    public PlayerData withView(int view) {
        this.view = view;
        return this;
    }

    @JsonProperty("vimeo_url")
    public String getVimeoUrl() {
        return vimeoUrl;
    }

    @JsonProperty("vimeo_url")
    public void setVimeoUrl(String vimeoUrl) {
        this.vimeoUrl = vimeoUrl;
    }

    public PlayerData withVimeoUrl(String vimeoUrl) {
        this.vimeoUrl = vimeoUrl;
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

    public PlayerData withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("cdnUrl", cdnUrl).append("vimeoApiUrl", vimeoApiUrl).append("request", request).append("playerUrl", playerUrl).append("video", video).append("user", user).append("embed", embed).append("view", view).append("vimeoUrl", vimeoUrl).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(request).append(view).append(vimeoApiUrl).append(playerUrl).append(cdnUrl).append(vimeoUrl).append(video).append(embed).append(additionalProperties).append(user).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof PlayerData)) {
            return false;
        }
        PlayerData rhs = ((PlayerData) other);
        return new EqualsBuilder().append(request, rhs.request).append(view, rhs.view).append(vimeoApiUrl, rhs.vimeoApiUrl).append(playerUrl, rhs.playerUrl).append(cdnUrl, rhs.cdnUrl).append(vimeoUrl, rhs.vimeoUrl).append(video, rhs.video).append(embed, rhs.embed).append(additionalProperties, rhs.additionalProperties).append(user, rhs.user).isEquals();
    }

}
