import org.jtube.Processor;

import java.util.stream.Stream;

class Example {

	public static void main(String[] args) {
		if(args == null || args.length == 0) {
			System.out.println("Usage: java Example https://www.youtube.com/watch?v=H9154xIoYTA https://www.youtube.com/watch?v=I2s-xpGteh4");
		} else {
			Stream.of(args).map(Processor::new).parallel().forEach(Processor::start);
		}
		/*Stream.of(
				"https://www.youtube.com/watch?v=H9154xIoYTA"
				, "https://www.youtube.com/watch?v=I2s-xpGteh4"
				, "https://www.youtube.com/watch?v=Kn9tkjdyaCY"
				, "https://www.youtube.com/watch?v=nwx0f3Txktc"
				, "https://www.youtube.com/watch?v=ighghZIoP1k"
		).map(Processor::new).parallel().forEach(Processor::start);*/

	}
}
