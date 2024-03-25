/*
* This Source Code Form is subject to the terms of the Mozilla Public
* License, v. 2.0. If a copy of the MPL was not distributed with this
* file, You can obtain one at https://mozilla.org/MPL/2.0/.
*/

package me.undermon.realityapi;

public enum Platform {
	UNKNOWN,
	LINUX,
	WINDOWS;

	static Platform fromString(String name) {
		return switch(name) {
			case "win32" -> WINDOWS;
			case "linux-64" -> LINUX;

			default -> UNKNOWN;
		};
	}
}
