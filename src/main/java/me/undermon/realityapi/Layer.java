/*
* This Source Code Form is subject to the terms of the Mozilla Public
* License, v. 2.0. If a copy of the MPL was not distributed with this
* file, You can obtain one at https://mozilla.org/MPL/2.0/.
*/

package me.undermon.realityapi;

public enum Layer {
	INFANTRY,
	STANDARD,
	ALTERNATIVE,
	LARGE,
	UNKNOWN;

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
