
package org.jtube.data.vimeo.playerData;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "files",
        "lang",
        "sentry",
        "ab_tests",
        "cookie_domain",
        "timestamp",
        "gc_debug",
        "expires",
        "client",
        "currency",
        "session",
        "cookie",
        "build",
        "urls",
        "signature",
        "flags",
        "country",
        "file_codecs"
})
public class Request {

    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();
    @JsonProperty("files")
    private Files files;
    @JsonProperty("lang")
    private String lang;
    @JsonProperty("sentry")
    private Sentry sentry;
    @JsonProperty("ab_tests")
    private AbTests abTests;
    @JsonProperty("cookie_domain")
    private String cookieDomain;
    @JsonProperty("timestamp")
    private int timestamp;
    @JsonProperty("gc_debug")
    private GcDebug gcDebug;
    @JsonProperty("expires")
    private int expires;
    @JsonProperty("client")
    private Client client;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("session")
    private String session;
    @JsonProperty("cookie")
    private Cookie cookie;
    @JsonProperty("build")
    private Build build;
    @JsonProperty("urls")
    private Urls urls;
    @JsonProperty("signature")
    private String signature;
    @JsonProperty("flags")
    private Flags flags;
    @JsonProperty("country")
    private String country;
    @JsonProperty("file_codecs")
    private FileCodecs fileCodecs;

    /**
     * No args constructor for use in serialization
     */
    public Request() {
    }

    public Request(Files files, String lang, Sentry sentry, AbTests abTests, String cookieDomain, int timestamp, GcDebug gcDebug, int expires, Client client, String currency, String session, Cookie cookie, Build build, Urls urls, String signature, Flags flags, String country, FileCodecs fileCodecs) {
        super();
        this.files = files;
        this.lang = lang;
        this.sentry = sentry;
        this.abTests = abTests;
        this.cookieDomain = cookieDomain;
        this.timestamp = timestamp;
        this.gcDebug = gcDebug;
        this.expires = expires;
        this.client = client;
        this.currency = currency;
        this.session = session;
        this.cookie = cookie;
        this.build = build;
        this.urls = urls;
        this.signature = signature;
        this.flags = flags;
        this.country = country;
        this.fileCodecs = fileCodecs;
    }

    @JsonProperty("files")
    public Files getFiles() {
        return files;
    }

    @JsonProperty("files")
    public void setFiles(Files files) {
        this.files = files;
    }

    public Request withFiles(Files files) {
        this.files = files;
        return this;
    }

    @JsonProperty("lang")
    public String getLang() {
        return lang;
    }

    @JsonProperty("lang")
    public void setLang(String lang) {
        this.lang = lang;
    }

    public Request withLang(String lang) {
        this.lang = lang;
        return this;
    }

    @JsonProperty("sentry")
    public Sentry getSentry() {
        return sentry;
    }

    @JsonProperty("sentry")
    public void setSentry(Sentry sentry) {
        this.sentry = sentry;
    }

    public Request withSentry(Sentry sentry) {
        this.sentry = sentry;
        return this;
    }

    @JsonProperty("ab_tests")
    public AbTests getAbTests() {
        return abTests;
    }

    @JsonProperty("ab_tests")
    public void setAbTests(AbTests abTests) {
        this.abTests = abTests;
    }

    public Request withAbTests(AbTests abTests) {
        this.abTests = abTests;
        return this;
    }

    @JsonProperty("cookie_domain")
    public String getCookieDomain() {
        return cookieDomain;
    }

    @JsonProperty("cookie_domain")
    public void setCookieDomain(String cookieDomain) {
        this.cookieDomain = cookieDomain;
    }

    public Request withCookieDomain(String cookieDomain) {
        this.cookieDomain = cookieDomain;
        return this;
    }

    @JsonProperty("timestamp")
    public int getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public Request withTimestamp(int timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    @JsonProperty("gc_debug")
    public GcDebug getGcDebug() {
        return gcDebug;
    }

    @JsonProperty("gc_debug")
    public void setGcDebug(GcDebug gcDebug) {
        this.gcDebug = gcDebug;
    }

    public Request withGcDebug(GcDebug gcDebug) {
        this.gcDebug = gcDebug;
        return this;
    }

    @JsonProperty("expires")
    public int getExpires() {
        return expires;
    }

    @JsonProperty("expires")
    public void setExpires(int expires) {
        this.expires = expires;
    }

    public Request withExpires(int expires) {
        this.expires = expires;
        return this;
    }

    @JsonProperty("client")
    public Client getClient() {
        return client;
    }

    @JsonProperty("client")
    public void setClient(Client client) {
        this.client = client;
    }

    public Request withClient(Client client) {
        this.client = client;
        return this;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Request withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    @JsonProperty("session")
    public String getSession() {
        return session;
    }

    @JsonProperty("session")
    public void setSession(String session) {
        this.session = session;
    }

    public Request withSession(String session) {
        this.session = session;
        return this;
    }

    @JsonProperty("cookie")
    public Cookie getCookie() {
        return cookie;
    }

    @JsonProperty("cookie")
    public void setCookie(Cookie cookie) {
        this.cookie = cookie;
    }

    public Request withCookie(Cookie cookie) {
        this.cookie = cookie;
        return this;
    }

    @JsonProperty("build")
    public Build getBuild() {
        return build;
    }

    @JsonProperty("build")
    public void setBuild(Build build) {
        this.build = build;
    }

    public Request withBuild(Build build) {
        this.build = build;
        return this;
    }

    @JsonProperty("urls")
    public Urls getUrls() {
        return urls;
    }

    @JsonProperty("urls")
    public void setUrls(Urls urls) {
        this.urls = urls;
    }

    public Request withUrls(Urls urls) {
        this.urls = urls;
        return this;
    }

    @JsonProperty("signature")
    public String getSignature() {
        return signature;
    }

    @JsonProperty("signature")
    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Request withSignature(String signature) {
        this.signature = signature;
        return this;
    }

    @JsonProperty("flags")
    public Flags getFlags() {
        return flags;
    }

    @JsonProperty("flags")
    public void setFlags(Flags flags) {
        this.flags = flags;
    }

    public Request withFlags(Flags flags) {
        this.flags = flags;
        return this;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    public Request withCountry(String country) {
        this.country = country;
        return this;
    }

    @JsonProperty("file_codecs")
    public FileCodecs getFileCodecs() {
        return fileCodecs;
    }

    @JsonProperty("file_codecs")
    public void setFileCodecs(FileCodecs fileCodecs) {
        this.fileCodecs = fileCodecs;
    }

    public Request withFileCodecs(FileCodecs fileCodecs) {
        this.fileCodecs = fileCodecs;
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

    public Request withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("files", files).append("lang", lang).append("sentry", sentry).append("abTests", abTests).append("cookieDomain", cookieDomain).append("timestamp", timestamp).append("gcDebug", gcDebug).append("expires", expires).append("client", client).append("currency", currency).append("session", session).append("cookie", cookie).append("build", build).append("urls", urls).append("signature", signature).append("flags", flags).append("country", country).append("fileCodecs", fileCodecs).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(country).append(expires).append(cookie).append(signature).append(abTests).append(session).append(gcDebug).append(flags).append(cookieDomain).append(fileCodecs).append(urls).append(build).append(files).append(client).append(currency).append(additionalProperties).append(lang).append(sentry).append(timestamp).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Request)) {
            return false;
        }
        Request rhs = ((Request) other);
        return new EqualsBuilder().append(country, rhs.country).append(expires, rhs.expires).append(cookie, rhs.cookie).append(signature, rhs.signature).append(abTests, rhs.abTests).append(session, rhs.session).append(gcDebug, rhs.gcDebug).append(flags, rhs.flags).append(cookieDomain, rhs.cookieDomain).append(fileCodecs, rhs.fileCodecs).append(urls, rhs.urls).append(build, rhs.build).append(files, rhs.files).append(client, rhs.client).append(currency, rhs.currency).append(additionalProperties, rhs.additionalProperties).append(lang, rhs.lang).append(sentry, rhs.sentry).append(timestamp, rhs.timestamp).isEquals();
    }

}
