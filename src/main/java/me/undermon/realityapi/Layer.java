/*
* This Source Code Form is subject to the terms of the Mozilla Public
* License, v. 2.0. If a copy of the MPL was not distributed with this
* file, You can obtain one at https://mozilla.org/MPL/2.0/.
*/

package me.undermon.realityapi;

public enum Layer {
	INFANTRY("Infantry", "Inf"),
	STANDARD("Standard", "Std"),
	ALTERNATIVE("Alternative", "Alt"),
	LARGE("Large", "Lrg"),
	UNKNOWN("Unknown", "?");

	private String longName;
	private String shortName;

	private Layer(String longName, String shortName) {
		this.longName = longName;
		this.shortName = shortName;
	}

	public String getLongName() {
		return longName;
	}

	public String getShortName() {
		return shortName;
	}

	public static Layer fromString(String string) {
		try {
			return Layer.valueOf(string.toUpperCase());
		} catch (IllegalArgumentException e) {
			return Layer.UNKNOWN;
		}
	}

	static Layer fromMapSize(int size) {
		return switch (size) {
			case 16 -> Layer.INFANTRY;
			case 32 -> Layer.ALTERNATIVE;
			case 64 -> Layer.STANDARD;
			case 128 -> Layer.LARGE;

			default -> Layer.UNKNOWN;
		};
	}
}
