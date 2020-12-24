# jTube
This is implementation of youTube(tm) video downloader engine implemented using Java(tm)

ATTENTION: the ffmpeg need to be installed and/or it's binary added to $PATH environment variable.

To compile project - run "mvn clean compile"

To perform test run - just invoke Main.main(); method.
Or invoke "java -jar jTube.jar the://url.to/one?video the://url.to/another?video" from cmd
and engine will download best available quality by mentioned urls.


This implementation is stable and runable but need some refactor and additional features implementation.