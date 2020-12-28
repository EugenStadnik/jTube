package org.jtube.utils.media;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Merger {

	private static final Logger LOGGER = Logger.getLogger(Merger.class);
	private static Merger instance;
	private ShellExecutor shellExecutor = ShellExecutor.getInstance();

	private Merger() {}

	public static synchronized Merger getInstance() {
		if(instance == null) {
			instance = new Merger();
		}
		return instance;
	}

	public File mergeAudioAndVideo(File audioFile, File videoFile, File outputFile) throws IOException, InterruptedException {
		String ffmpegCheck = shellExecutor.execute("ffmpeg --help");
		if(!ffmpegCheck.contains("ffmpeg version") && !ffmpegCheck.contains("usage: ffmpeg")) {
			throw new IllegalStateException("There is no 'ffmpeg' installed or appended to $PATH." +
					"\nThere will be no ability to merge video and audio automatically." +
					"\nPlease install 'ffmpeg' and/or appent it's binary file to $PATH environment variable.");
		}
		for (File f : Arrays.asList(audioFile, videoFile, outputFile.getParentFile())) {
			if (! f.exists()) {
				throw new FileNotFoundException(f.getAbsolutePath());
			}
		}
		if (outputFile.exists()) {
			LOGGER.info("The " + outputFile.getName() + " redundant output file deleted: " + outputFile.delete());
		}
		String command = "ffmpeg -i " + audioFile.getAbsolutePath() + " -i " + videoFile.getAbsolutePath()
				+ " -c:v copy -c:a aac " + outputFile.getAbsolutePath();
		shellExecutor.execute(command);
		if (!outputFile.exists()) {
			LOGGER.warn("The " + videoFile.getName() + " video and " + audioFile.getName()
					+ " audio are not merged to " + outputFile.getName() + " file.");
			return null;
		}
		LOGGER.info("The " + videoFile.getName() + " video and " + audioFile.getName()
				+ " audio are merged successfully to " + outputFile.getName() + " file.");
		return outputFile;
	}

}
