package org.jtube.data.vimeo;

import org.jtube.data.SourceData;
import org.jtube.data.vimeo.playerData.PlayerData;
import org.jtube.data.vimeo.streams.Streams;

import java.util.Objects;

public class VimeoSourceData extends SourceData {

	private PlayerData playerData;
	private Streams streams;

	public VimeoSourceData() {
	}

	public VimeoSourceData(PlayerData playerData, Streams streams) {
		this.playerData = playerData;
		this.streams = streams;
	}

	public PlayerData getPlayerData() {
		return playerData;
	}

	public void setPlayerData(PlayerData playerData) {
		this.playerData = playerData;
	}

	public VimeoSourceData withPlayerData(PlayerData playerData) {
		this.playerData = playerData;
		return this;
	}

	public Streams getStreams() {
		return streams;
	}

	public void setStreams(Streams streams) {
		this.streams = streams;
	}

	public VimeoSourceData withStreams(Streams streams) {
		this.streams = streams;
		return this;
	}

	@Override
	public String toString() {
		return "VimeoSourceData{" +
				"playerData=" + playerData +
				", streams=" + streams +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		VimeoSourceData that = (VimeoSourceData) o;
		return playerData.equals(that.playerData) &&
				streams.equals(that.streams);
	}

	@Override
	public int hashCode() {
		return Objects.hash(playerData, streams);
	}
}
