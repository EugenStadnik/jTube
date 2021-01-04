package org.jtube.utils.media;

import java.io.File;
import java.io.IOException;

public interface Merger {

	File mergeMultimediaFiles(File ... multimediaFiles) throws IOException, InterruptedException;

}
