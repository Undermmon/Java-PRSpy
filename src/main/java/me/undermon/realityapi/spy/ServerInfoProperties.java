/*
* This Source Code Form is subject to the terms of the Mozilla Public
* License, v. 2.0. If a copy of the MPL was not distributed with this
* file, You can obtain one at https://mozilla.org/MPL/2.0/.
*/

package me.undermon.realityapi.spy;

record ServerInfoProperties(
	String gamename,
	String hostname,
	String gamever,
	String mapname,
	String gametype,
	String gamevariant,
	int numplayers,
	int maxplayers,
	int password,
	int timelimit,
	String roundtime,
	String bf2_os,
	String bf2_d_dl,
	String bf2_sponsortext,
	String bf2_sponsorlogo_url,
	String bf2_communitylogo_url,
	String bf2_team1,
	String bf2_team2,
	int bf2_mapsize,
	int bf2_reservedslots
) {

}
