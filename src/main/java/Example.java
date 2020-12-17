import org.jtube.Processor;

import java.util.stream.Stream;

class Example {

	public static void main(String[] args) {
		Stream.of(
				"https://www.youtube.com/watch?v=H9154xIoYTA"
				, "https://www.youtube.com/watch?v=I2s-xpGteh4"
				, "https://www.youtube.com/watch?v=Kn9tkjdyaCY"
				, "https://www.youtube.com/watch?v=nwx0f3Txktc"
				, "https://www.youtube.com/watch?v=ighghZIoP1k"
		).map(Processor::new).parallel().forEach(Processor::start);

	}
}
