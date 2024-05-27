/*
* This Source Code Form is subject to the terms of the Mozilla Public
* License, v. 2.0. If a copy of the MPL was not distributed with this
* file, You can obtain one at https://mozilla.org/MPL/2.0/.
*/

package me.undermon.realityapi.prspy;

import java.util.Optional;

public interface Player extends Comparable<Player> {

	public String name();

	public Optional<String> tag();

	public int kills();

	public int deaths();

	public double kd();

	public boolean inFactionOne();

	public int ping();

	public boolean isBot();

}
