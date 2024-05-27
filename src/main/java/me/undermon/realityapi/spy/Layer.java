/*
* This Source Code Form is subject to the terms of the Mozilla Public
* License, v. 2.0. If a copy of the MPL was not distributed with this
* file, You can obtain one at https://mozilla.org/MPL/2.0/.
*/

package me.undermon.realityapi.spy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum Layer {
	INFANTRY("Infantry", "Inf"),
	STANDARD("Standard", "Std"),
	ALTERNATIVE("Alternative", "Alt"),
	LARGE("Large", "Lrg"),
	UNKNOWN("Unknown", "?");

	private static final Logger LOGGER = LoggerFactory.getLogger(Layer.class);

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
			LOGGER.warn("Unknown layer: {}", string);
			
			return Layer.UNKNOWN;
		}
	}

	static Layer fromMapSize(int size) {
		Layer layer = switch (size) {
			case 16 -> Layer.INFANTRY;
			case 32 -> Layer.ALTERNATIVE;
			case 64 -> Layer.STANDARD;
			case 128 -> Layer.LARGE;

			default -> Layer.UNKNOWN;
		};

		if (layer.equals(Layer.UNKNOWN)) {
			LOGGER.warn("Unknown layer size: {}", size);			
		}

		return layer;
	}
}
