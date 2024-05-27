/*
* This Source Code Form is subject to the terms of the Mozilla Public
* License, v. 2.0. If a copy of the MPL was not distributed with this
* file, You can obtain one at https://mozilla.org/MPL/2.0/.
*/

package me.undermon.realityapi.spy;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import com.neovisionaries.i18n.CountryCode;

record ServerInfoServer (
	String serverId,
	boolean hasMumble,
	String countryFlag,
	ServerInfoProperties properties,
	ServerInfoPlayer[] players
) implements Server {

	private class PlayerIterator implements Iterator<Player> {
		private int cursor = -1;

		@Override
		public boolean hasNext() {
			return players.length - 1 > cursor;
		}

		@Override
		public Player next() {
			cursor += 1;

			return players[cursor];
		}
	}

	@Override
	public Iterator<Player> iterator() {
		return new PlayerIterator();
	}

	@Override
	public String identifier() {
		return this.serverId;
	}

	@Override
	public String name() {
		return this.properties.hostname();
	}

	@Override
	public String message() {
		return this.properties.bf2_sponsortext();
	}

	@Override
	public Platform platform() {
		return Platform.fromString(this.properties.bf2_os());
	}

	@Override
	public CountryCode country() {
		CountryCode code;
	
		try {
			code = CountryCode.valueOf(this.countryFlag);
		} catch (IllegalArgumentException e) {
			code = CountryCode.UNDEFINED;
		}
		
		return code;
	}

	@Override
	public String version() {
		return this.properties.gamever();
	}

	@Override
	public boolean hasPassword() {
		return this.properties.password() > 0;
	}

	@Override
	public int reservedSlots() {
		return this.properties.bf2_reservedslots();
	}

	@Override
	public Optional<URL> logo() {
		try {
			return Optional.of(new URL(this.properties.bf2_sponsorlogo_url()));
		} catch (MalformedURLException e) {
			return Optional.empty();
		}
	}

	@Override
	public Optional<URL> community() {
		try {
			return Optional.of(new URL(this.properties.bf2_communitylogo_url()));
		} catch (MalformedURLException e) {
			return Optional.empty();
		}
	}

	@Override
	public Map map() {
		return Map.fromFullName(this.properties.mapname());
	}

	@Override
	public me.undermon.realityapi.spy.Mode mode() {
		return Mode.fromIngameId(this.properties.gametype());
	}

	@Override
	public Layer layer() {
		return Layer.fromMapSize(this.properties.bf2_mapsize());
	}

	@Override
	public int compareTo(Server other) {
		return this.name().compareToIgnoreCase(other.name());
	}

	@Override
	public Faction factionOne() {
		return Faction.fromCode(this.properties.bf2_team1());
	}

	@Override
	public Faction factionTwo() {
		return Faction.fromCode(this.properties.bf2_team2());
	}

	@Override
	public int connected() {
		return this.properties.numplayers();
	}

	@Override
	public int capacity() {
		return this.properties.maxplayers();
	}

	@Override
	public Optional<URL> resources() {
		try {
			return Optional.of(new URL(this.properties.bf2_d_dl()));
		} catch (MalformedURLException e) {
			return Optional.empty();
		}
	}

	@Override
	public String toString() {
		return "Server[name=%s, id=%s, platform=%s, country=%s, mumble=%b, password=%b, players=%d/%d(%d), map=%s(%s, %s)]".
		formatted(
			this.name(),
			this.identifier(),
			this.platform(),
			this.country(),
			this.hasMumble(),
			this.hasPassword(),
			this.connected(),
			this.capacity(),
			this.reservedSlots(),
			this.map(),
			this.mode(),
			this.layer());
	}

	@Override
	public Stream<Player> stream() {
		return StreamSupport.stream(this.spliterator(), false);
	}
}
