
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
        "account_type",
        "name",
        "img",
        "url",
        "img_2x",
        "id"
})
public class Owner {

    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();
    @JsonProperty("account_type")
    private String accountType;
    @JsonProperty("name")
    private String name;
    @JsonProperty("img")
    private URL img;
    @JsonProperty("url")
    private URL url;
    @JsonProperty("img_2x")
    private URL img2x;
    @JsonProperty("id")
    private int id;

    /**
     * No args constructor for use in serialization
     */
    public Owner() {
    }

    public Owner(String accountType, String name, URL img, URL url, URL img2x, int id) {
        super();
        this.accountType = accountType;
        this.name = name;
        this.img = img;
        this.url = url;
        this.img2x = img2x;
        this.id = id;
    }

    @JsonProperty("account_type")
    public String getAccountType() {
        return accountType;
    }

    @JsonProperty("account_type")
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Owner withAccountType(String accountType) {
        this.accountType = accountType;
        return this;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Owner withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("img")
    public URL getImg() {
        return img;
    }

    @JsonProperty("img")
    public void setImg(URL img) {
        this.img = img;
    }

    public Owner withImg(URL img) {
        this.img = img;
        return this;
    }

    @JsonProperty("url")
    public URL getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(URL url) {
        this.url = url;
    }

    public Owner withUrl(URL url) {
        this.url = url;
        return this;
    }

    @JsonProperty("img_2x")
    public URL getImg2x() {
        return img2x;
    }

    @JsonProperty("img_2x")
    public void setImg2x(URL img2x) {
        this.img2x = img2x;
    }

    public Owner withImg2x(URL img2x) {
        this.img2x = img2x;
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

    public Owner withId(int id) {
        this.id = id;
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

    public Owner withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("accountType", accountType).append("name", name).append("img", img).append("url", url).append("img2x", img2x).append("id", id).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(img).append(img2x).append(accountType).append(name).append(id).append(additionalProperties).append(url).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Owner)) {
            return false;
        }
        Owner rhs = ((Owner) other);
        return new EqualsBuilder().append(img, rhs.img).append(img2x, rhs.img2x).append(accountType, rhs.accountType).append(name, rhs.name).append(id, rhs.id).append(additionalProperties, rhs.additionalProperties).append(url, rhs.url).isEquals();
    }

}
