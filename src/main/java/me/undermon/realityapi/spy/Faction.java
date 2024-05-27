/*
* This Source Code Form is subject to the terms of the Mozilla Public
* License, v. 2.0. If a copy of the MPL was not distributed with this
* file, You can obtain one at https://mozilla.org/MPL/2.0/.
*/

package me.undermon.realityapi.spy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum Faction {
	ARF("arf", "African Resistance Fighters"),
	ARGENTINA_1982("arg82", "Argentine Armed Forces"),
	CANADA("cf", "Canadian Forces"),
	CHINA("ch", "Chinese Forces"),
	MILITIA("chinsurgent", "Militia"),
	FRANCE("fr", "French Forces"),
	SYRIAN_REBELS("fsa", "Syrian Rebels"),
	BRITISH("gb", "British Armed Forces"),
	BRITISH_82("gb82", "British Armed Forces"),
	GERMANY("ger", "German Forces"),
	HAMAS("hamas", "Hamas"),
	IDF("idf", "Israeli Defence Forces"),
	MEC("mec", "Middle East Coalition"),
	INSURGENT("meinsurgent", "Iraqi Insurgents"),
	NETHERLANDS("nl", "Dutch Armed Forces"),
	POLAND("pl", "Polish Armed Forces"),
	RUSSIA("ru", "Russian Armed Forces"),
	TALIBAN("taliban", "Taliban"),
	USMC("us", "United States Marine Corps"),
	USA("usa", "United States Army"),
	NVA("vnnva", "North Vietnamese Army"),
	USA_VIETNAM("vnusa", "United States Army"),
	USMC_VIETNAM("vnusmc", "United States Marine Corps"),
	WEHRMACHT("ww2ger", "Wehrmacht"),
	USA_WW2("ww2usa", "United States Army"),
	VIETCONG("vnvc", "Viet Cong"),
	UNKNOWN("unknown", "Unknown");

	private static final Logger LOGGER = LoggerFactory.getLogger(Faction.class);
	
	private String id;
	private String name;

	private Faction(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	static Faction fromId(String id) {

		for (Faction faction : Faction.values()) {
			if (faction.id.equalsIgnoreCase(id)) {
				return faction;
			}
		}

		LOGGER.warn("Unknown faction id: {}", id);

		return Faction.UNKNOWN;
	}
}
