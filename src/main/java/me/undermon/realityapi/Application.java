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

import com.google.gson.Gson;


public class Application {
	private static final Gson GSON = new Gson();

	/**
	* InnerJPrSpy
	*/
	private record Test(String name, int age, int height) {
		
	}


	public static void main(String[] args) throws Exception {		
		String data = Files.readString(Paths.get("ServerInfo.json"));
		
		// System.out.println(data);
		Application.name(data);
	}
	
	public static void name(String json) {
		ServerInfo serverInfo = GSON.fromJson(json, ServerInfo.class);


		for (ServerInfoServer server : serverInfo.servers()) {
			for (ServerInfoPlayer player : server.players()) {
				System.out.println(player);
			}
		}
	}
	
	public static void prspy() throws Exception {
		HttpClient client = HttpClient.newHttpClient();
		
		URI uri = new URI("https://servers.realitymod.com/api/ServerInfo");
		HttpRequest request = HttpRequest.newBuilder().uri(uri).GET().build();
		
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		
		System.out.println(response.body());
	}
}
