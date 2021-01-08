
package org.jtube.data.vimeo.playerData;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "team_origin_user_id",
        "liked",
        "account_type",
        "team_id",
        "watch_later",
        "owner",
        "id",
        "mod",
        "logged_in"
})
public class User {

    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();
    @JsonProperty("team_origin_user_id")
    private int teamOriginUserId;
    @JsonProperty("liked")
    private int liked;
    @JsonProperty("account_type")
    private String accountType;
    @JsonProperty("team_id")
    private int teamId;
    @JsonProperty("watch_later")
    private int watchLater;
    @JsonProperty("owner")
    private int owner;
    @JsonProperty("id")
    private int id;
    @JsonProperty("mod")
    private int mod;
    @JsonProperty("logged_in")
    private int loggedIn;

    /**
     * No args constructor for use in serialization
     */
    public User() {
    }

    public User(int teamOriginUserId, int liked, String accountType, int teamId, int watchLater, int owner, int id, int mod, int loggedIn) {
        super();
        this.teamOriginUserId = teamOriginUserId;
        this.liked = liked;
        this.accountType = accountType;
        this.teamId = teamId;
        this.watchLater = watchLater;
        this.owner = owner;
        this.id = id;
        this.mod = mod;
        this.loggedIn = loggedIn;
    }

    @JsonProperty("team_origin_user_id")
    public int getTeamOriginUserId() {
        return teamOriginUserId;
    }

    @JsonProperty("team_origin_user_id")
    public void setTeamOriginUserId(int teamOriginUserId) {
        this.teamOriginUserId = teamOriginUserId;
    }

    public User withTeamOriginUserId(int teamOriginUserId) {
        this.teamOriginUserId = teamOriginUserId;
        return this;
    }

    @JsonProperty("liked")
    public int getLiked() {
        return liked;
    }

    @JsonProperty("liked")
    public void setLiked(int liked) {
        this.liked = liked;
    }

    public User withLiked(int liked) {
        this.liked = liked;
        return this;
    }

    @JsonProperty("account_type")
    public String getAccountType() {
        return accountType;
    }

    @JsonProperty("account_type")
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public User withAccountType(String accountType) {
        this.accountType = accountType;
        return this;
    }

    @JsonProperty("team_id")
    public int getTeamId() {
        return teamId;
    }

    @JsonProperty("team_id")
    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public User withTeamId(int teamId) {
        this.teamId = teamId;
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

    public User withWatchLater(int watchLater) {
        this.watchLater = watchLater;
        return this;
    }

    @JsonProperty("owner")
    public int getOwner() {
        return owner;
    }

    @JsonProperty("owner")
    public void setOwner(int owner) {
        this.owner = owner;
    }

    public User withOwner(int owner) {
        this.owner = owner;
        return this;
    }

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    public User withId(int id) {
        this.id = id;
        return this;
    }

    @JsonProperty("mod")
    public int getMod() {
        return mod;
    }

    @JsonProperty("mod")
    public void setMod(int mod) {
        this.mod = mod;
    }

    public User withMod(int mod) {
        this.mod = mod;
        return this;
    }

    @JsonProperty("logged_in")
    public int getLoggedIn() {
        return loggedIn;
    }

    @JsonProperty("logged_in")
    public void setLoggedIn(int loggedIn) {
        this.loggedIn = loggedIn;
    }

    public User withLoggedIn(int loggedIn) {
        this.loggedIn = loggedIn;
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

    public User withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("teamOriginUserId", teamOriginUserId).append("liked", liked).append("accountType", accountType).append("teamId", teamId).append("watchLater", watchLater).append("owner", owner).append("id", id).append("mod", mod).append("loggedIn", loggedIn).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(owner).append(mod).append(accountType).append(teamId).append(loggedIn).append(watchLater).append(id).append(additionalProperties).append(teamOriginUserId).append(liked).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof User)) {
            return false;
        }
        User rhs = ((User) other);
        return new EqualsBuilder().append(owner, rhs.owner).append(mod, rhs.mod).append(accountType, rhs.accountType).append(teamId, rhs.teamId).append(loggedIn, rhs.loggedIn).append(watchLater, rhs.watchLater).append(id, rhs.id).append(additionalProperties, rhs.additionalProperties).append(teamOriginUserId, rhs.teamOriginUserId).append(liked, rhs.liked).isEquals();
    }

}
