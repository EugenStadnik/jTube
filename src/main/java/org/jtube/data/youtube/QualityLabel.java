package org.jtube.data.youtube;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QualityLabel implements Comparable<QualityLabel> {
	private static final Map<String, QualityLabel> valuesMap
			= Stream.of("6480p60", "6480p", "6480i", "6480"
			, "4320p60", "4320p", "4320i", "4320", "2160p60", "2160p", "2160i", "2160"
			, "1440p60", "1440p", "1440i", "1440", "1080p60", "1080p", "1080i", "1080"
			, "720p60", "720p", "720i", "720", "480p", "480i", "480"
			, "360p", "360i", "360", "240p", "240i", "240", "144p", "144i", "144")
			.collect(Collectors.toMap(Function.identity(), QualityLabel::new));
	private static final List<QualityLabel> values = new ArrayList<>(valuesMap.values());

	private final String value;

	private QualityLabel(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return value;
	}

	@Override
	public boolean equals(Object anObject) {
		if (this == anObject) {
			return true;
		}
		if (anObject instanceof QualityLabel) {
			QualityLabel other = (QualityLabel)anObject;
			return this.value.equals(other.value);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

	public static QualityLabel valueOf(String value) {
		QualityLabel object = valuesMap.get(value);
		if(object == null) {
			throw new IllegalArgumentException("No such " + value + " of QualityLabel");
		}
		return object;
	}

	public static List<QualityLabel> values() {
		return values;
	}

	@Override
	public int compareTo(QualityLabel other) {
		return values.indexOf(other) - values.indexOf(this);
	}
}
