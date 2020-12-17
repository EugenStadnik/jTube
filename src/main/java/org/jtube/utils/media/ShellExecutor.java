package org.jtube.utils.media;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShellExecutor {

	private static ShellExecutor instance;

	private ShellExecutor() {}

	public static synchronized ShellExecutor getInstance() {
		if(instance == null) {
			instance = new ShellExecutor();
		}
		return instance;
	}

	public String execute(String command) throws IOException, InterruptedException {
		ProcessBuilder pb = new ProcessBuilder(command.split("[ ]"));
		pb.redirectErrorStream(true);
		Process process = pb.start();
		process.waitFor();
		BufferedReader reader =
				new BufferedReader(new InputStreamReader(process.getInputStream()));
		StringBuilder builder = new StringBuilder();
		String line;
		while ( (line = reader.readLine()) != null) {
			builder.append(line);
			builder.append(System.getProperty("line.separator"));
		}
		return builder.toString();
	}

}
