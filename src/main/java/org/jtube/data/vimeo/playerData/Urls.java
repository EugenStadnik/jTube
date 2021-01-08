
package org.jtube.data.vimeo.playerData;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "barebone_js",
        "test_imp",
        "js_base",
        "fresnel",
        "js",
        "proxy",
        "mux_url",
        "fresnel_mimir_inputs_url",
        "fresnel_chunk_url",
        "three_js",
        "vuid_js",
        "fresnel_manifest_url",
        "chromeless_css",
        "player_telemetry_url",
        "chromeless_js",
        "css"
})
public class Urls {

    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();
    @JsonProperty("barebone_js")
    private String bareboneJs;
    @JsonProperty("test_imp")
    private String testImp;
    @JsonProperty("js_base")
    private String jsBase;
    @JsonProperty("fresnel")
    private String fresnel;
    @JsonProperty("js")
    private String js;
    @JsonProperty("proxy")
    private String proxy;
    @JsonProperty("mux_url")
    private String muxUrl;
    @JsonProperty("fresnel_mimir_inputs_url")
    private String fresnelMimirInputsUrl;
    @JsonProperty("fresnel_chunk_url")
    private String fresnelChunkUrl;
    @JsonProperty("three_js")
    private String threeJs;
    @JsonProperty("vuid_js")
    private String vuidJs;
    @JsonProperty("fresnel_manifest_url")
    private String fresnelManifestUrl;
    @JsonProperty("chromeless_css")
    private String chromelessCss;
    @JsonProperty("player_telemetry_url")
    private String playerTelemetryUrl;
    @JsonProperty("chromeless_js")
    private String chromelessJs;
    @JsonProperty("css")
    private String css;

    /**
     * No args constructor for use in serialization
     */
    public Urls() {
    }

    public Urls(String bareboneJs, String testImp, String jsBase, String fresnel, String js, String proxy, String muxUrl, String fresnelMimirInputsUrl, String fresnelChunkUrl, String threeJs, String vuidJs, String fresnelManifestUrl, String chromelessCss, String playerTelemetryUrl, String chromelessJs, String css) {
        super();
        this.bareboneJs = bareboneJs;
        this.testImp = testImp;
        this.jsBase = jsBase;
        this.fresnel = fresnel;
        this.js = js;
        this.proxy = proxy;
        this.muxUrl = muxUrl;
        this.fresnelMimirInputsUrl = fresnelMimirInputsUrl;
        this.fresnelChunkUrl = fresnelChunkUrl;
        this.threeJs = threeJs;
        this.vuidJs = vuidJs;
        this.fresnelManifestUrl = fresnelManifestUrl;
        this.chromelessCss = chromelessCss;
        this.playerTelemetryUrl = playerTelemetryUrl;
        this.chromelessJs = chromelessJs;
        this.css = css;
    }

    @JsonProperty("barebone_js")
    public String getBareboneJs() {
        return bareboneJs;
    }

    @JsonProperty("barebone_js")
    public void setBareboneJs(String bareboneJs) {
        this.bareboneJs = bareboneJs;
    }

    public Urls withBareboneJs(String bareboneJs) {
        this.bareboneJs = bareboneJs;
        return this;
    }

    @JsonProperty("test_imp")
    public String getTestImp() {
        return testImp;
    }

    @JsonProperty("test_imp")
    public void setTestImp(String testImp) {
        this.testImp = testImp;
    }

    public Urls withTestImp(String testImp) {
        this.testImp = testImp;
        return this;
    }

    @JsonProperty("js_base")
    public String getJsBase() {
        return jsBase;
    }

    @JsonProperty("js_base")
    public void setJsBase(String jsBase) {
        this.jsBase = jsBase;
    }

    public Urls withJsBase(String jsBase) {
        this.jsBase = jsBase;
        return this;
    }

    @JsonProperty("fresnel")
    public String getFresnel() {
        return fresnel;
    }

    @JsonProperty("fresnel")
    public void setFresnel(String fresnel) {
        this.fresnel = fresnel;
    }

    public Urls withFresnel(String fresnel) {
        this.fresnel = fresnel;
        return this;
    }

    @JsonProperty("js")
    public String getJs() {
        return js;
    }

    @JsonProperty("js")
    public void setJs(String js) {
        this.js = js;
    }

    public Urls withJs(String js) {
        this.js = js;
        return this;
    }

    @JsonProperty("proxy")
    public String getProxy() {
        return proxy;
    }

    @JsonProperty("proxy")
    public void setProxy(String proxy) {
        this.proxy = proxy;
    }

    public Urls withProxy(String proxy) {
        this.proxy = proxy;
        return this;
    }

    @JsonProperty("mux_url")
    public String getMuxUrl() {
        return muxUrl;
    }

    @JsonProperty("mux_url")
    public void setMuxUrl(String muxUrl) {
        this.muxUrl = muxUrl;
    }

    public Urls withMuxUrl(String muxUrl) {
        this.muxUrl = muxUrl;
        return this;
    }

    @JsonProperty("fresnel_mimir_inputs_url")
    public String getFresnelMimirInputsUrl() {
        return fresnelMimirInputsUrl;
    }

    @JsonProperty("fresnel_mimir_inputs_url")
    public void setFresnelMimirInputsUrl(String fresnelMimirInputsUrl) {
        this.fresnelMimirInputsUrl = fresnelMimirInputsUrl;
    }

    public Urls withFresnelMimirInputsUrl(String fresnelMimirInputsUrl) {
        this.fresnelMimirInputsUrl = fresnelMimirInputsUrl;
        return this;
    }

    @JsonProperty("fresnel_chunk_url")
    public String getFresnelChunkUrl() {
        return fresnelChunkUrl;
    }

    @JsonProperty("fresnel_chunk_url")
    public void setFresnelChunkUrl(String fresnelChunkUrl) {
        this.fresnelChunkUrl = fresnelChunkUrl;
    }

    public Urls withFresnelChunkUrl(String fresnelChunkUrl) {
        this.fresnelChunkUrl = fresnelChunkUrl;
        return this;
    }

    @JsonProperty("three_js")
    public String getThreeJs() {
        return threeJs;
    }

    @JsonProperty("three_js")
    public void setThreeJs(String threeJs) {
        this.threeJs = threeJs;
    }

    public Urls withThreeJs(String threeJs) {
        this.threeJs = threeJs;
        return this;
    }

    @JsonProperty("vuid_js")
    public String getVuidJs() {
        return vuidJs;
    }

    @JsonProperty("vuid_js")
    public void setVuidJs(String vuidJs) {
        this.vuidJs = vuidJs;
    }

    public Urls withVuidJs(String vuidJs) {
        this.vuidJs = vuidJs;
        return this;
    }

    @JsonProperty("fresnel_manifest_url")
    public String getFresnelManifestUrl() {
        return fresnelManifestUrl;
    }

    @JsonProperty("fresnel_manifest_url")
    public void setFresnelManifestUrl(String fresnelManifestUrl) {
        this.fresnelManifestUrl = fresnelManifestUrl;
    }

    public Urls withFresnelManifestUrl(String fresnelManifestUrl) {
        this.fresnelManifestUrl = fresnelManifestUrl;
        return this;
    }

    @JsonProperty("chromeless_css")
    public String getChromelessCss() {
        return chromelessCss;
    }

    @JsonProperty("chromeless_css")
    public void setChromelessCss(String chromelessCss) {
        this.chromelessCss = chromelessCss;
    }

    public Urls withChromelessCss(String chromelessCss) {
        this.chromelessCss = chromelessCss;
        return this;
    }

    @JsonProperty("player_telemetry_url")
    public String getPlayerTelemetryUrl() {
        return playerTelemetryUrl;
    }

    @JsonProperty("player_telemetry_url")
    public void setPlayerTelemetryUrl(String playerTelemetryUrl) {
        this.playerTelemetryUrl = playerTelemetryUrl;
    }

    public Urls withPlayerTelemetryUrl(String playerTelemetryUrl) {
        this.playerTelemetryUrl = playerTelemetryUrl;
        return this;
    }

    @JsonProperty("chromeless_js")
    public String getChromelessJs() {
        return chromelessJs;
    }

    @JsonProperty("chromeless_js")
    public void setChromelessJs(String chromelessJs) {
        this.chromelessJs = chromelessJs;
    }

    public Urls withChromelessJs(String chromelessJs) {
        this.chromelessJs = chromelessJs;
        return this;
    }

    @JsonProperty("css")
    public String getCss() {
        return css;
    }

    @JsonProperty("css")
    public void setCss(String css) {
        this.css = css;
    }

    public Urls withCss(String css) {
        this.css = css;
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

    public Urls withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("bareboneJs", bareboneJs).append("testImp", testImp).append("jsBase", jsBase).append("fresnel", fresnel).append("js", js).append("proxy", proxy).append("muxUrl", muxUrl).append("fresnelMimirInputsUrl", fresnelMimirInputsUrl).append("fresnelChunkUrl", fresnelChunkUrl).append("threeJs", threeJs).append("vuidJs", vuidJs).append("fresnelManifestUrl", fresnelManifestUrl).append("chromelessCss", chromelessCss).append("playerTelemetryUrl", playerTelemetryUrl).append("chromelessJs", chromelessJs).append("css", css).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(playerTelemetryUrl).append(css).append(threeJs).append(js).append(testImp).append(bareboneJs).append(jsBase).append(proxy).append(fresnel).append(fresnelMimirInputsUrl).append(chromelessCss).append(muxUrl).append(fresnelChunkUrl).append(fresnelManifestUrl).append(additionalProperties).append(vuidJs).append(chromelessJs).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Urls)) {
            return false;
        }
        Urls rhs = ((Urls) other);
        return new EqualsBuilder().append(playerTelemetryUrl, rhs.playerTelemetryUrl).append(css, rhs.css).append(threeJs, rhs.threeJs).append(js, rhs.js).append(testImp, rhs.testImp).append(bareboneJs, rhs.bareboneJs).append(jsBase, rhs.jsBase).append(proxy, rhs.proxy).append(fresnel, rhs.fresnel).append(fresnelMimirInputsUrl, rhs.fresnelMimirInputsUrl).append(chromelessCss, rhs.chromelessCss).append(muxUrl, rhs.muxUrl).append(fresnelChunkUrl, rhs.fresnelChunkUrl).append(fresnelManifestUrl, rhs.fresnelManifestUrl).append(additionalProperties, rhs.additionalProperties).append(vuidJs, rhs.vuidJs).append(chromelessJs, rhs.chromelessJs).isEquals();
    }

}
