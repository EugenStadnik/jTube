# jTube
This is implementation of youTube(tm) video downloader engine implemented using Java(tm)

Currentlly this engine handles youtube, vimeo, eneyida, kino4ua, kinogo-net video sources. More sources will be available soon

ATTENTION: the ffmpeg need to be installed and/or it's binary added to $PATH environment variable.

To compile project - run "mvn clean compile"

To perform test run - just invoke Main.main(); method.
Or invoke "java -jar jTube.jar the://url.to/one?video the://url.to/another?video" from cmd
and engine will download best available quality by mentioned urls.

To import this module into your project just append following to your pom.xml file:
```
<repositories>
        <repository>
            <id>first_release</id>
            <url>https://github.com/EugenStadnik/jTube.git</url>
        </repository>
        <repository>
            <id>maven-releases</id>
            <name>maven-releases</name>
            <url>https://github.com</url>
            <releases>
                <enabled>true</enabled>
            </releases>
            <snapshots>
                <enabled>false</enabled>
            </snapshots>
        </repository>
    </repositories>

    <dependencies>
        <dependency>
            <groupId>com.github.EugenStadnik</groupId>
            <artifactId>jTube</artifactId>
            <version>0.1</version>
        </dependency>
    </dependencies>
```

This implementation is stable and runnable but need some refactor and additional features implementation.