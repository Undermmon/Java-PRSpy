/*
* This Source Code Form is subject to the terms of the Mozilla Public
* License, v. 2.0. If a copy of the MPL was not distributed with this
* file, You can obtain one at https://mozilla.org/MPL/2.0/.
*/

package me.undermon.realityapi;

import java.util.Iterator;

record ServerInfo(ServerInfoServer[] servers) implements Servers {

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
			cursor += 1;
			
			return servers[cursor];
		}
	}
}
