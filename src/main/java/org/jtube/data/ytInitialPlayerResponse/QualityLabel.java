package org.jtube.data.ytInitialPlayerResponse;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QualityLabel {
	private static final Map<String, QualityLabel> valuesMap
			= Stream.of("6480p", "4320p", "2160p", "1440p", "1080p", "1080i", "1080p60"
			, "720p", "720i", "720p60", "480p", "480i", "360p", "360i", "240p", "240i", "144p", "144i").collect(Collectors.toMap(Function.identity(), QualityLabel::new));
	private static final QualityLabel[] valuesArray = valuesMap.values().toArray(QualityLabel[]::new);

	private String value;

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

	public static QualityLabel[] values() {
		return valuesArray;
	}
}
