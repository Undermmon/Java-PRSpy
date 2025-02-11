/*
* This Source Code Form is subject to the terms of the Mozilla Public
* License, v. 2.0. If a copy of the MPL was not distributed with this
* file, You can obtain one at https://mozilla.org/MPL/2.0/.
*/

package me.undermon.realityapi.spy;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import com.google.gson.Gson;

record ServerInfo(ServerInfoServer[] servers) implements Servers {
	static final Gson GSON = new Gson();

	@Override
	public String toString() {
		return "Servers[count=%d]".formatted(servers.length);
	}

	@Override
	public Iterator<Server> iterator() {
		return new ServerIterator();
	}

	private class ServerIterator implements Iterator<Server> {
		private int cursor = -1;

		@Override
		public boolean hasNext() {
			return servers.length - 1 > cursor;
		}

		@Override
		public Server next() {
			if (!this.hasNext()) {
				throw new NoSuchElementException();
			}
			
			cursor += 1;
			
			return servers[cursor];
		}
	}

	@Override
	public Stream<Server> stream() {
		return StreamSupport.stream(this.spliterator(), false);
	}
}
