/*
* This Source Code Form is subject to the terms of the Mozilla Public
* License, v. 2.0. If a copy of the MPL was not distributed with this
* file, You can obtain one at https://mozilla.org/MPL/2.0/.
*/

package me.undermon.realityapi;

public enum Map {
	UNKNOWN("Unknown"),
	ADAK("Adak - BETA"),
	AL_BASRAH("Al Basrah"),
	ASAD_KHAL("Asad Khal"),
	ASCHEBERG("Ascheberg - BETA"),
	ASSAULT_ON_GROZNY("Assault on Grozny"),
	ASSAULT_ON_MESTIA("Assault on Mestia"),
	BAMYAN("Bamyan"),
	BATTLE_OF_IA_DRANG("Battle of Ia Drang"),
	BEIRUT("Beirut"),
	BLACK_GOLD("Black Gold"),
	BRECOURT_ASSAULT("Brecourt Assault"),
	BURNING_SANDS("Burning Sands"),
	CARENTAN("Carentan"),
	CHARLIES_POINT("Charlie's Point"),
	DEAGLE5("Deagle5"),
	DOVRE("Dovre"),
	DOVRE_WINTER("Dovre Winter"),
	DRAGON_FLY("Dragon Fly"),
	FALLUJAH_WEST("Fallujah West"),
	FIELDS_OF_KASSEL("Fields of Kassel - BETA"),
	FOOLS_ROAD("Fools Road"),
	GAZA("Gaza"),
	GOOSE_GREEN("Goose Green"),
	HADES_PEAK("Hades Peak"),
	HILL_488("Hill 488"),
	IRON_RIDGE("Iron Ridge"),
	KAFAR_HALAB("Kafr Halab"),
	KARBALA("Karbala"),
	KASHAN_DESERT("Kashan Desert"),
	KHAMISIYAH("Khamisiyah"),
	KOKAN("Kokan"),
	KORBACH_OFFENSIVE("Korbach Offensive - BETA"),
	KORENGAL("Korengal Valley"),
	KOZELSK("Kozelsk"),
	KUNAR_PROVINCE("Kunar Province - BETA"),
	LASHKAR_VALLEY("Lashkar Valley"),
	MASIRAH("Masirah"),
	MERVILLE("Merville"),
	MUSA_QALA("Musa Qala - BETA"),
	MUTTRAH_CITY("Muttrah City"),
	NUIJAMAA("Nuijamaa"),
	OMAHA_BEACH("Omaha Beach"),
	OP_BARRACUDA("Operation Barracuda"),
	OPERATION_BOBCAT("Operation Bobcat"),
	OPERATION_FALCON("Operation Falcon"),
	OPERATION_GHOST_TRAIN("Operation Ghost Train"),
	OPERATION_MARLIN("Operation Marlin"),
	OPERATION_SOUL_REBEL("Operation Soul Rebel"),
	OPERATION_THUNDER("Operation Thunder - BETA"),
	OUTPOST("Outpost"),
	PAVLOVSK_BAY("Pavlovsk Bay"),
	RAMIEL("Ramiel"),
	RAS_EL_MASRI("Ras El Masri"),
	REICHSWALD("Reichswald"),
	ROAD_TO_DAMASCUS("Road to Damascus"),
	ROUTE("Route E-106"),
	SAAREMAA("Saaremaa"),
	SAHEL("Sahel"),
	SBENEH_OUTSKIRTS("Sbeneh Outskirts"),
	SHAHADAH("Shahadah"),
	SHIJIA_VALLEY("Shijia Valley"),
	SHIPMENT("Shipment"),
	SILENT_EAGLE("Silent Eagle"),
	TAD_SAE("Tad Sae Offensive"),
	TEST_AIRFIELD("Test Airfield"),
	TEST_BOOTCAMP("Test Bootcamp"),
	THE_FALKLANDS("The Falklands"),
	ULYANOVSK("Ulyanovsk"),
	VADSO_CITY("Vadso City"),
	WANDA_SHAN("Wanda Shan"),
	XIANGSHAN("Xiangshan"),
	YAMALIA("Yamalia"),
	ZAKHO("Zakho - BETA");

	private String name;

	Map(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	static Map fromName(String name) {

		for (Map map : Map.values()) {
			if (map.getName().equals(name)) {
				return map;
			}
		}

		return Map.UNKNOWN;
	}
}
