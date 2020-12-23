
package org.jtube.data.segmentedPlaylist;

import io.lindstrom.m3u8.model.MasterPlaylist;
import io.lindstrom.m3u8.model.MediaPlaylist;
import org.jtube.data.SourceData;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SegmentedPlaylistSourceData extends SourceData {

    private URL canonicalUrl;
    private Map<URL, MasterPlaylist> uriMasterPlaylistMap = new HashMap<>();
    private Map<URL, MediaPlaylist> uriMediaPlaylistMap = new HashMap<>();

    public Map<URL, MasterPlaylist> getUriMasterPlaylistMap() {
        return uriMasterPlaylistMap;
    }

    public Map<URL, MediaPlaylist> getUriMediaPlaylistMap() {
        return uriMediaPlaylistMap;
    }

    public URL getCanonicalUrl() {
        return canonicalUrl;
    }

    public void setCanonicalUrl(URL canonicalUrl) {
        this.canonicalUrl = canonicalUrl;
    }

    @Override
    public String toString() {
        return uriMasterPlaylistMap.toString() + uriMediaPlaylistMap.toString();
    }

    @Override
    public int hashCode() {
        return uriMasterPlaylistMap.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof SegmentedPlaylistSourceData)) {
            return false;
        }
        SegmentedPlaylistSourceData rhs = ((SegmentedPlaylistSourceData) other);
        return this.uriMasterPlaylistMap.equals(rhs.uriMasterPlaylistMap);
    }

}
