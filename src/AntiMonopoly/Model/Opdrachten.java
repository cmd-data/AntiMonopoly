package AntiMonopoly.Model;

import org.apache.commons.collections4.map.LinkedMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Opdrachten {

	public static final LinkedMap<Integer,String> monopolisten = new LinkedMap<>();            // Apache Commons Collections 'LinkedMap'
	public static final LinkedMap<Integer,String> concurrenten = new LinkedMap<>();

	public static LinkedMap<Integer,String> shuffledMon = new LinkedMap<>();
	public static LinkedMap<Integer,String> shuffledCon = new LinkedMap<>();

	Opdrachten(){                                                             /** constructor met alle opdrachten **/
		monopolisten.put(0,"Ga naar Buurtspoorwegen.");
		monopolisten.put(1,"Door een duister zaakje te doen \nkrijg je een groot contract met de regering. \nMaar iemand heeft de pers ingelicht." +
				" \nOm te zien of de deal doorgaat, \nrol met de dobbelsteen. \nBij 7 of minder: GEEN DEAL; \n8 of meer: de storm waait over \nen je ontvangt €75.000");
		monopolisten.put(2,"Je maakt jouw concurrenten failliet \ndoor jouw prijzen drastisch te laten zakken, \ndaarna kon je ze nog hoger laten stijgen." +
				" Ontvang €50.000 van de bank.");
		monopolisten.put(3,"Ga naar de electriciteitscentrale.");
		monopolisten.put(4,"Ga naar Start.");
		monopolisten.put(5,"Ga naar Start.");
		monopolisten.put(6,"Je probeert een monopolie op zonne-energie te hebben, \ngoed geprobeerd maar je kan ze niet allemaal winnen!" +
				" Betaal €50.000 aan de bank.");
		monopolisten.put(7,"Je verbetert jouw publiek imago \ndoor te investeren in culturele activiteiten. \nGoed idee!");
		monopolisten.put(8,"Je loog en zei dat je een \ningenieuze schop had uitgevonden, \ndie je gezien hebt in een Azteken museum." +
				" \nMaar het gerechtshof verklaart jouw patent als ongeldig. \nBetaal €75.000 aan de bank.");
		monopolisten.put(9,"Door een gebrek aan concurrenten werd je nalatig, \nje wordt nu onderboden door de Chinese markt. \nBetaal €25.000 aan de bank.");
		monopolisten.put(10,"Ga op vakantie naar de Nieuwstraat in Brussel.");
		monopolisten.put(11,"Een nieuwe uitvinding zou jouw beste product aan banden hebben gelegd. \nJe hebt het opgekocht en van de markt gehouden," +
				" je ontvangt €25.000 van de bank.");
		monopolisten.put(12,"Een nieuwe rechter denkt: \n'Wat goed is voor monopolisten is goed voor het land!', \nje ontvangt €25.000");
		monopolisten.put(13,"Om het mededingingsrecht te omzeilen \nheb je een advocaat omgekocht om een fusie goed te keuren \nmaar een eerlijke secretaresse heeft jou verklikt." +
				" \nGa direct naar de gevangenis en passeer niet langs Start!");
		monopolisten.put(14,"Door een publiek protest verlies je een belastingsvoordeel\ndat door een corrupte politicus voor jou gecreëerd was." +
				" \nBetaal de bank €75.000");
		monopolisten.put(15,"Jouw tweelingsbroer had zogezegd een concurrerend bedrijf \nmaar het gerecht heeft hem verplicht zijn leidinggevende functie op te zeggen." +
				" \nBetaal €25.000");
		monopolisten.put(16,"Ondanks de vele veroordelingen van de Anti-Monopolie stichting \nontvang jij toch de nationale prijs voor Humanitaire persoon van het jaar!");
		monopolisten.put(17,"Je hebt een monopolie op bakstenen, \nontvang van elke concurrent €10.000.");
		monopolisten.put(18,"Een makelaar die met jou bevriend is \nkrijgt een mooie positie binnen de regering. \nHij is zijn oude vrienden niet vergeten," +
				" \niedere monopolist ontvangt €25.000!");
		monopolisten.put(19,"Je bent een huisjesmelker \nen liet een aantal advocaten \ndezelfde huur betalen ongeacht de staat van het huis. " +
				"\nGerechtelijk onderzoek bracht dit aan het licht. \nGa direct naar de gevangenis en ga niet langs Start!");
		monopolisten.put(20,"Dankzij wat politieke spelletjes zijn de LEZ's afgeschaft \nen kunnen jouw vrachtwagens weer volop de stad vervuilen. " +
				"\nJe ontvangt €75.000");
		monopolisten.put(21,"Tijdens een spelletje golf \nmaak je een goede deal voor badkuipen, \nontvang €50.000");
		monopolisten.put(22,"Een wet die de bevolking in staat stelde om monopolisten aan te klagen \nwerd versoepeld. \nOntvang €25.000 van iedere concurrent.");
		monopolisten.put(23,"Ga naar de Veldstraat in Gent.");
		monopolisten.put(24,"Je hebt een monopolie op coaxiaal internet, \nde regering betaalt jou €50.000");

		concurrenten.put(0,"De Anti-Monopolie stichting haalt een elektronica gigant van de markt. \nOntvang €75.000");
		concurrenten.put(1,"De regering brengt een halt toe aan een aantal prijsafspraken, \niedereen begint elkaar massaal te onderbieden. " +
				"\nga naar de Prijzenoorlog!");
		concurrenten.put(2,"Door middel van 'loop holes' \nkunnen grote bedrijven hun belasting onderduiken. \nDe regering komt het geld bij jou halen, " +
				"\nbetaal €75.000");
		concurrenten.put(3,"Er heerst een depressie \nen andere concurrenten onderbieden jou, \nbetaal hen elks €10.000");
		concurrenten.put(4,"Een monopolist die jouw bedrijf schaadt \ngaat akkoord met een instemmingsbesluit. \nGeniet van deze morele overwinning!");
		concurrenten.put(5,"Je vond huurders voor jouw panden, \nontvang €50.000 van de bank.");
		concurrenten.put(6,"Je krijgt een beurs van de Anti-Monopolie stichting, \nontvang €25.000");
		concurrenten.put(7,"Je hebt jouw verhuur auto's een nieuw kleurtje gegeven \nen business is booming! \nOntvang €50.000");
		concurrenten.put(8,"Je start een nieuw zaak maar zal die succesvol zijn? \nAls je 9 of minder rolt dat faalt ie; \nbij 10 of meer ontvang je €75.000!");
		concurrenten.put(9,"De stichting voor het mededingingsrecht \nheeft een monopolist geblokkeerd die jouw zaak wou overnemen. " +
				"\nHoera!, de zaken blijven draaien!");
		concurrenten.put(10,"De monopolisten hebben de olieprijs opgevoerd, \nbetaal €50.000 aan de bank.");
		concurrenten.put(11,"De economie gaat schitterend! \nIedereen kan zijn huur betalen \nen jij ontvangt €50.000");
		concurrenten.put(12,"De regering geeft de Anti-Monopolie stichting \neen extra duwtje in de rug! \nOntvang van iedere monopolist €25.000");
		concurrenten.put(13,"Door een door de regering gesteund onderzoek \nvindt men een beter manier om huizen te bouwen." +
				" \nJouw huurprijzen zakken \ndoordat er een groter aanbod is. \nGa naar een Prijzenoorlog!");
		concurrenten.put(14,"De regering beslist om een grote multinational te steunen \nmaar jouw vraag voor financiële steun werd genegeerd." +
				" \nBetaal €75.000 aan de bank.");
		concurrenten.put(15,"Je vecht om ervoor te zorgen dat \neen duur anti-pollutie middel niet verplicht wordt \nmaar gelukkig voor onze lucht verlies je. " +
				"\nBetaal €25.000 aan de bank.");
		concurrenten.put(16,"Ga naar buurtspoorwegen.");
		concurrenten.put(17,"Ga naar Start.");
		concurrenten.put(18,"Ga naar Start.");
		concurrenten.put(19,"Ga naar de Meir in Antwerpen.");
		concurrenten.put(20,"Ga op bezoek naar de gascentrale.");
		concurrenten.put(21,"Gigant Alles nv verlaagt zijn huurprijzen \nom zo concurrenten te vernietigen. \nBetaal €50.000 aan de bank.");
		concurrenten.put(22,"Ga op weekend naar de Steenstraat in Brugge.");
		concurrenten.put(23,"Je wint een gerechtelijke zaak tegen een monopolist. \nZelfs na het betalen van jouw advocaten ontvang je nog €75.000");
		concurrenten.put(24,"Een gigantische makelaar laat jou met rust \nom ervoor te zorgen dat de Anti-Monopolie stichting hem ook met rust laat. " +
				"\nOntvang €25.000 van de bank.");

		monopolistenSchudden();
		concurrentenSchudden();
	}

	public static LinkedMap<Integer, String> getConcurrenten() { return concurrenten; }
	public static LinkedMap<Integer, String> getMonopolisten() { return monopolisten; }

	public static LinkedMap<Integer, String> getShuffledMon() { return shuffledMon; }
	public static LinkedMap<Integer, String> getShuffledCon() { return shuffledCon; }

	public static void setShuffledMon(LinkedMap<Integer, String> shuffledMon) { Opdrachten.shuffledMon = shuffledMon; }

	public static void setShuffledCon(LinkedMap<Integer, String> shuffledCon) { Opdrachten.shuffledCon = shuffledCon; }

	private static void monopolistenSchudden() {
		ArrayList<Integer> keys = new ArrayList<>(Opdrachten.monopolisten.keySet());
		Collections.shuffle(keys);                                       	// keys schudden (er is geen shuffle-methode voor 'map')
		LinkedMap<Integer,String> shuffledMap = new LinkedMap<>();			// nieuwe geschudde LinkedMap
		for (Integer i : keys){												// interatie over keys list
			shuffledMap.put(i,monopolisten.get(i));
		}
		shuffledMon.putAll(shuffledMap);
	}

	private static void concurrentenSchudden() {
		ArrayList<Integer> keys = new ArrayList<>(Opdrachten.concurrenten.keySet());
		Collections.shuffle(keys);                                       	//keys schudden (er is geen shuffle-methode voor 'map')
		LinkedMap<Integer,String> shuffledMap = new LinkedMap<>();			// nieuwe geschudde LinkedMap
		for (Integer i : keys){												// interatie over keys list
			shuffledMap.put(i,concurrenten.get(i));
		}
		shuffledCon.putAll(shuffledMap);
	}
}