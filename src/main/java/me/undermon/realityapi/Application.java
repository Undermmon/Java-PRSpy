/*
* This Source Code Form is subject to the terms of the Mozilla Public
* License, v. 2.0. If a copy of the MPL was not distributed with this
* file, You can obtain one at https://mozilla.org/MPL/2.0/.
*/

package me.undermon.realityapi;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Application {
	public static void main(String[] args) throws Exception {		
		String data = Files.readString(Paths.get("ServerInfo.json"));
		// String data = retrieveServerInfo();

		Servers servers = Servers.from(data);
		
		for (Server server : servers) {
			System.out.println(server.country() + " " + server.connected() + "/" + server.capacity() + " " + server.name());

			// System.out.println(server.name() + " -> " + server.community());
		}
	}
	
	public static String retrieveServerInfo() throws Exception {
		HttpClient client = HttpClient.newHttpClient();
		
		URI uri = new URI("https://servers.realitymod.com/api/ServerInfo");
		HttpRequest request = HttpRequest.newBuilder().uri(uri).GET().build();
		
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		
		return response.body();
	}
}
