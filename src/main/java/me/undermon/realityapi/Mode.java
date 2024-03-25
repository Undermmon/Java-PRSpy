/*
* This Source Code Form is subject to the terms of the Mozilla Public
* License, v. 2.0. If a copy of the MPL was not distributed with this
* file, You can obtain one at https://mozilla.org/MPL/2.0/.
*/

package me.undermon.realityapi;

public enum Mode {
	UNKNOWN("unknown", "Unknown"),
	AAS("gpm_cq", "Assault and Secure"),
	INSURGENCY("gpm_insurgency", "Insurgency"),
	SKIRMISH("gpm_skirmish", "Skirmish"),
	CNC("gpm_cnc", "Command & Control"),
	VEHICLE_WARFARE("gpm_vehicles", "Vehicle Warfare"),
	COOP("gpm_coop", "Co-Operative"),
	TRAINING("gpm_training", "Training"),
	COUNTER("gpm_counter", "Counter-Attack"),
	GUNGAME("gpm_gungame", "Gungame"),
	SCENARIO("gpm_scenario", "Scenario");

	private String code;
	private String name;

	Mode(String code, String name) {
		this.code = code;
		this.name = name;
	};

	public String getName() {
		return name;
	}

	static Mode fromGamemode(String gamemode) {

		for (Mode mode : Mode.values()) {
			if (mode.code.equals(gamemode)) {
				return mode;
			}	
		}

		return Mode.UNKNOWN;
	}
}
