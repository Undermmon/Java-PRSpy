/*
* This Source Code Form is subject to the terms of the Mozilla Public
* License, v. 2.0. If a copy of the MPL was not distributed with this
* file, You can obtain one at https://mozilla.org/MPL/2.0/.
*/

package me.undermon.realityapi.prspy;

import java.net.URL;
import java.util.Optional;
import java.util.stream.Stream;

import com.neovisionaries.i18n.CountryCode;

public interface Server extends Iterable<Player>, Comparable<Server> {

	public String identifier();

	public String name();

	public String message();

	public String version();

	public Platform platform();

	public CountryCode country();

	public Optional<URL> resources();

	public boolean hasMumble();

	public boolean hasPassword();

	public int reservedSlots();

	public int connected();

	public int capacity();

	public Optional<URL> logo();

	public Optional<URL> community();

	public Map map();

	public Mode mode();

	public Layer layer();

	public Faction factionOne();

	public Faction factionTwo();

	public Stream<Player> stream();

}
