/*
* This Source Code Form is subject to the terms of the Mozilla Public
* License, v. 2.0. If a copy of the MPL was not distributed with this
* file, You can obtain one at https://mozilla.org/MPL/2.0/.
*/

package me.undermon.realityapi;

import java.util.Optional;

record ServerInfoPlayer(
	String name, int score, int kills, int deaths, int team, int ping, int isAI) implements Player {

	@Override
	public int compareTo(Player other) {
		return this.name().compareToIgnoreCase(other.name());
	}

	@Override
	public String toString() {
		return "%s[%s, kills=%s, deaths=%s, KD=%s, ping=%s]".formatted( 
			(this.isBot()) ? "Bot" : "Player",
			this.tag().map(tag -> tag + " ").orElse("") + this.name(),
			this.kills,
			this.deaths,
			this.kd(),
			this.ping
		);
	}

	@Override
	public Optional<String> tag() {
		String tag = this.name.split(" ")[0];

		return tag.isEmpty() ? Optional.empty() : Optional.of(tag);  
	}

	@Override
	public String name() {
		return this.name.split(" ")[1];
	}

	@Override
	public double kd() {
		return (this.deaths != 0) ? (double) this.kills / this.deaths : this.kills;
	}

	@Override
	public boolean inFactionOne() {
		return this.team == 1;
	}

	@Override
	public boolean isBot() {
		return this.isAI != 0;
	}
}
