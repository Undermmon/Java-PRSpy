/*
* This Source Code Form is subject to the terms of the Mozilla Public
* License, v. 2.0. If a copy of the MPL was not distributed with this
* file, You can obtain one at https://mozilla.org/MPL/2.0/.
*/

package me.undermon.realityapi.spy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum Platform {
	UNKNOWN,
	LINUX,
	WINDOWS;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Platform.class);

	static Platform fromString(String name) {
		Platform platform = switch(name) {
			case "win32" -> WINDOWS;
			case "linux-64" -> LINUX;

			
			default -> UNKNOWN;
		};

		if (platform.equals(UNKNOWN)) {
			LOGGER.warn("Unknown platform: {}", name);
		}

		return platform;
	}
}
