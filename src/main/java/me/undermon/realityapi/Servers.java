/*
* This Source Code Form is subject to the terms of the Mozilla Public
* License, v. 2.0. If a copy of the MPL was not distributed with this
* file, You can obtain one at https://mozilla.org/MPL/2.0/.
*/

package me.undermon.realityapi;

import com.google.gson.Gson;

public interface Servers extends Iterable<Server> {
	public static Servers from(String json) {
		return new Gson().fromJson(json, ServerInfo.class);
	}
}
