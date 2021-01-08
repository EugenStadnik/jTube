
package org.jtube.data.vimeo.playerData;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "autopause",
        "playsinline",
        "settings",
        "color",
        "texttrack",
        "on_site",
        "app_id",
        "muted",
        "dnt",
        "player_id",
        "editor",
        "context",
        "time",
        "outro",
        "log_plays",
        "transparent",
        "loop",
        "autoplay"
})
public class Embed {

    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();
    @JsonProperty("autopause")
    private int autopause;
    @JsonProperty("playsinline")
    private int playsinline;
    @JsonProperty("settings")
    private Settings settings;
    @JsonProperty("color")
    private String color;
    @JsonProperty("texttrack")
    private String texttrack;
    @JsonProperty("on_site")
    private int onSite;
    @JsonProperty("app_id")
    private String appId;
    @JsonProperty("muted")
    private int muted;
    @JsonProperty("dnt")
    private int dnt;
    @JsonProperty("player_id")
    private String playerId;
    @JsonProperty("editor")
    private boolean editor;
    @JsonProperty("context")
    private String context;
    @JsonProperty("time")
    private int time;
    @JsonProperty("outro")
    private String outro;
    @JsonProperty("log_plays")
    private int logPlays;
    @JsonProperty("transparent")
    private int transparent;
    @JsonProperty("loop")
    private int loop;
    @JsonProperty("autoplay")
    private int autoplay;

    /**
     * No args constructor for use in serialization
     */
    public Embed() {
    }

    public Embed(int autopause, int playsinline, Settings settings, String color, String texttrack, int onSite, String appId, int muted, int dnt, String playerId, boolean editor, String context, int time, String outro, int logPlays, int transparent, int loop, int autoplay) {
        super();
        this.autopause = autopause;
        this.playsinline = playsinline;
        this.settings = settings;
        this.color = color;
        this.texttrack = texttrack;
        this.onSite = onSite;
        this.appId = appId;
        this.muted = muted;
        this.dnt = dnt;
        this.playerId = playerId;
        this.editor = editor;
        this.context = context;
        this.time = time;
        this.outro = outro;
        this.logPlays = logPlays;
        this.transparent = transparent;
        this.loop = loop;
        this.autoplay = autoplay;
    }

    @JsonProperty("autopause")
    public int getAutopause() {
        return autopause;
    }

    @JsonProperty("autopause")
    public void setAutopause(int autopause) {
        this.autopause = autopause;
    }

    public Embed withAutopause(int autopause) {
        this.autopause = autopause;
        return this;
    }

    @JsonProperty("playsinline")
    public int getPlaysinline() {
        return playsinline;
    }

    @JsonProperty("playsinline")
    public void setPlaysinline(int playsinline) {
        this.playsinline = playsinline;
    }

    public Embed withPlaysinline(int playsinline) {
        this.playsinline = playsinline;
        return this;
    }

    @JsonProperty("settings")
    public Settings getSettings() {
        return settings;
    }

    @JsonProperty("settings")
    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public Embed withSettings(Settings settings) {
        this.settings = settings;
        return this;
    }

    @JsonProperty("color")
    public String getColor() {
        return color;
    }

    @JsonProperty("color")
    public void setColor(String color) {
        this.color = color;
    }

    public Embed withColor(String color) {
        this.color = color;
        return this;
    }

    @JsonProperty("texttrack")
    public String getTexttrack() {
        return texttrack;
    }

    @JsonProperty("texttrack")
    public void setTexttrack(String texttrack) {
        this.texttrack = texttrack;
    }

    public Embed withTexttrack(String texttrack) {
        this.texttrack = texttrack;
        return this;
    }

    @JsonProperty("on_site")
    public int getOnSite() {
        return onSite;
    }

    @JsonProperty("on_site")
    public void setOnSite(int onSite) {
        this.onSite = onSite;
    }

    public Embed withOnSite(int onSite) {
        this.onSite = onSite;
        return this;
    }

    @JsonProperty("app_id")
    public String getAppId() {
        return appId;
    }

    @JsonProperty("app_id")
    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Embed withAppId(String appId) {
        this.appId = appId;
        return this;
    }

    @JsonProperty("muted")
    public int getMuted() {
        return muted;
    }

    @JsonProperty("muted")
    public void setMuted(int muted) {
        this.muted = muted;
    }

    public Embed withMuted(int muted) {
        this.muted = muted;
        return this;
    }

    @JsonProperty("dnt")
    public int getDnt() {
        return dnt;
    }

    @JsonProperty("dnt")
    public void setDnt(int dnt) {
        this.dnt = dnt;
    }

    public Embed withDnt(int dnt) {
        this.dnt = dnt;
        return this;
    }

    @JsonProperty("player_id")
    public String getPlayerId() {
        return playerId;
    }

    @JsonProperty("player_id")
    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public Embed withPlayerId(String playerId) {
        this.playerId = playerId;
        return this;
    }

    @JsonProperty("editor")
    public boolean isEditor() {
        return editor;
    }

    @JsonProperty("editor")
    public void setEditor(boolean editor) {
        this.editor = editor;
    }

    public Embed withEditor(boolean editor) {
        this.editor = editor;
        return this;
    }

    @JsonProperty("context")
    public String getContext() {
        return context;
    }

    @JsonProperty("context")
    public void setContext(String context) {
        this.context = context;
    }

    public Embed withContext(String context) {
        this.context = context;
        return this;
    }

    @JsonProperty("time")
    public int getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(int time) {
        this.time = time;
    }

    public Embed withTime(int time) {
        this.time = time;
        return this;
    }

    @JsonProperty("outro")
    public String getOutro() {
        return outro;
    }

    @JsonProperty("outro")
    public void setOutro(String outro) {
        this.outro = outro;
    }

    public Embed withOutro(String outro) {
        this.outro = outro;
        return this;
    }

    @JsonProperty("log_plays")
    public int getLogPlays() {
        return logPlays;
    }

    @JsonProperty("log_plays")
    public void setLogPlays(int logPlays) {
        this.logPlays = logPlays;
    }

    public Embed withLogPlays(int logPlays) {
        this.logPlays = logPlays;
        return this;
    }

    @JsonProperty("transparent")
    public int getTransparent() {
        return transparent;
    }

    @JsonProperty("transparent")
    public void setTransparent(int transparent) {
        this.transparent = transparent;
    }

    public Embed withTransparent(int transparent) {
        this.transparent = transparent;
        return this;
    }

    @JsonProperty("loop")
    public int getLoop() {
        return loop;
    }

    @JsonProperty("loop")
    public void setLoop(int loop) {
        this.loop = loop;
    }

    public Embed withLoop(int loop) {
        this.loop = loop;
        return this;
    }

    @JsonProperty("autoplay")
    public int getAutoplay() {
        return autoplay;
    }

    @JsonProperty("autoplay")
    public void setAutoplay(int autoplay) {
        this.autoplay = autoplay;
    }

    public Embed withAutoplay(int autoplay) {
        this.autoplay = autoplay;
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

    public Embed withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("autopause", autopause).append("playsinline", playsinline).append("settings", settings).append("color", color).append("texttrack", texttrack).append("onSite", onSite).append("appId", appId).append("muted", muted).append("dnt", dnt).append("playerId", playerId).append("editor", editor).append("context", context).append("time", time).append("outro", outro).append("logPlays", logPlays).append("transparent", transparent).append("loop", loop).append("autoplay", autoplay).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(settings).append(editor).append(color).append(autopause).append(dnt).append(transparent).append(autoplay).append(texttrack).append(logPlays).append(loop).append(appId).append(playsinline).append(context).append(outro).append(onSite).append(time).append(additionalProperties).append(muted).append(playerId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Embed)) {
            return false;
        }
        Embed rhs = ((Embed) other);
        return new EqualsBuilder().append(settings, rhs.settings).append(editor, rhs.editor).append(color, rhs.color).append(autopause, rhs.autopause).append(dnt, rhs.dnt).append(transparent, rhs.transparent).append(autoplay, rhs.autoplay).append(texttrack, rhs.texttrack).append(logPlays, rhs.logPlays).append(loop, rhs.loop).append(appId, rhs.appId).append(playsinline, rhs.playsinline).append(context, rhs.context).append(outro, rhs.outro).append(onSite, rhs.onSite).append(time, rhs.time).append(additionalProperties, rhs.additionalProperties).append(muted, rhs.muted).append(playerId, rhs.playerId).isEquals();
    }

}
