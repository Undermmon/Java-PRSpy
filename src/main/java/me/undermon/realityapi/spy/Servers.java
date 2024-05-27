/*
* This Source Code Form is subject to the terms of the Mozilla Public
* License, v. 2.0. If a copy of the MPL was not distributed with this
* file, You can obtain one at https://mozilla.org/MPL/2.0/.
*/

package me.undermon.realityapi.spy;

import java.util.stream.Stream;

public interface Servers extends Iterable<Server> {
	
	public Stream<Server> stream();

	public static Servers from(String json) {
		return ServerInfo.GSON.fromJson(json, ServerInfo.class);
	}
}
