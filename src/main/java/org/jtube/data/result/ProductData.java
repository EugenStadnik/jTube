package org.jtube.data.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.json.JSONObject;
import org.jtube.data.MultimediaFormatType;
import org.jtube.data.Source;

import javax.validation.Valid;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"canonicalUrl",
		"title",
		"source",
		"multiMediaStreams"
})
public class ProductData {

	@JsonProperty("canonicalUrl")
	@Valid
	private URL canonicalUrl;
	@JsonProperty("title")
	private String title;
	@JsonProperty("source")
	@Valid
	private Source source;
	@JsonProperty("multiMediaStreams")
	@Valid
	private List<MultiMediaStream> multiMediaStreams = new ArrayList<>();
	@JsonProperty("errors")
	@Valid
	private List<Throwable> errors = new ArrayList<>();

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public ProductData() {
	}

	public ProductData(URL canonicalUrl, String title, Source source, List<MultiMediaStream> multiMediaStreams) {
		super();
		this.canonicalUrl = canonicalUrl;
		this.title = title;
		this.source = source;
		this.multiMediaStreams = multiMediaStreams;
		setParentProductData();
	}

	private void setParentProductData() {
		this.multiMediaStreams.forEach(multiMediaStream -> multiMediaStream.setParentProductData(this));
	}

	@JsonProperty("canonicalUrl")
	public URL getCanonicalUrl() {
		return canonicalUrl;
	}

	@JsonProperty("canonicalUrl")
	public void setCanonicalUrl(URL canonicalUrl) {
		this.canonicalUrl = canonicalUrl;
	}

	public ProductData withCanonicalUrl(URL canonicalUrl) {
		this.canonicalUrl = canonicalUrl;
		return this;
	}

	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	@JsonProperty("title")
	public void setTitle(String title) {
		this.title = title;
	}

	public ProductData withTitle(String title) {
		this.title = title;
		return this;
	}

	@JsonProperty("source")
	public Source getSource() {
		return source;
	}

	@JsonProperty("source")
	public void setSource(Source source) {
		this.source = source;
	}

	public ProductData withSource(Source source) {
		this.source = source;
		return this;
	}

	@JsonProperty("multiMediaStreams")
	public List<MultiMediaStream> getMultiMediaStreams() {
		return multiMediaStreams;
	}

	@JsonProperty("multiMediaStreams")
	public void setMultiMediaStreams(List<MultiMediaStream> multiMediaStreams) {
		this.multiMediaStreams = multiMediaStreams;
		setParentProductData();
	}

	public ProductData withMultiMediaStreams(List<MultiMediaStream> multiMediaStreams) {
		this.multiMediaStreams = multiMediaStreams;
		setParentProductData();
		return this;
	}

	@JsonProperty("errors")
	public List<Throwable> getErrors() {
		return errors;
	}

	@JsonProperty("errors")
	public void setErrors(List<Throwable> errors) {
		this.errors = errors;
	}

	public ProductData withAppendError(Throwable error) {
		this.errors.add(error);
		return this;
	}

	@Override
	public int hashCode() {
		return this.canonicalUrl.hashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if (!(other instanceof ProductData)) {
			return false;
		}
		ProductData rhs = ((ProductData) other);
		return this.canonicalUrl.equals(rhs.canonicalUrl);
	}

	@Override
	public String toString() {
		return new JSONObject(this).toString(3);
	}

	public List<MultiMediaStream> getMultiMediaStreams(MultimediaFormatType multimediaFormatType) {
		return multiMediaStreams.stream()
				.filter((stream) -> stream.getType().equals(multimediaFormatType))
				.sorted()
				.collect(Collectors.toList());
	}
}
