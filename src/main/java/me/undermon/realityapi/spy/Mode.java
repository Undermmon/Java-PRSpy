/*
* This Source Code Form is subject to the terms of the Mozilla Public
* License, v. 2.0. If a copy of the MPL was not distributed with this
* file, You can obtain one at https://mozilla.org/MPL/2.0/.
*/

package me.undermon.realityapi.spy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum Mode {
	UNKNOWN("unknown", "Unknown", "?"),
	AAS("gpm_cq", "Assault and Secure", "AAS"),
	INSURGENCY("gpm_insurgency", "Insurgency", "Ins"),
	SKIRMISH("gpm_skirmish", "Skirmish", "Sk"),
	CNC("gpm_cnc", "Command & Control", "C&C"),
	VEHICLE_WARFARE("gpm_vehicles", "Vehicle Warfare", "VW"),
	COOP("gpm_coop", "Co-Operative", "Coop"),
	TRAINING("gpm_training", "Training", "Tr"),
	COUNTER("gpm_counter", "Counter-Attack", "CT"),
	GUNGAME("gpm_gungame", "Gungame", "Gun"),
	SCENARIO("gpm_scenario", "Scenario", "Sc");

	private static final Logger LOGGER = LoggerFactory.getLogger(Mode.class);

	private String code;
	private String longName;
	private String shortName;

	
	Mode(String id, String longName, String shortName) {
		this.code = id;
		this.longName = longName;
		this.shortName = shortName;
	}
	
	public String getLongName() {
		return longName;
	}

	public String getShortName() {
		return shortName;
	}

	public static Mode fromString(String string) {
		try {
			return Mode.valueOf(string.toUpperCase());
		} catch (IllegalArgumentException e) {

			LOGGER.warn("Unknown map: {}", string);

			return Mode.UNKNOWN;
		}
	}

	static Mode fromIngameId(String id) {

		for (Mode mode : Mode.values()) {
			if (mode.code.equals(id)) {
				return mode;
			}	
		}

		LOGGER.warn("Unknown map id: {}", id);

		return Mode.UNKNOWN;
	}
}
