package AntiMonopoly.Model;

import org.apache.commons.collections4.map.LinkedMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Opdrachten {

	private final LinkedMap<Integer,String> monopolisten = new LinkedMap<>();            /** Apache Commons Collections 'LinkedMap' **/
	private final LinkedMap<Integer,String> concurrenten = new LinkedMap<>();

	private LinkedMap<Integer,String> shuffledMon = new LinkedMap<>();
	private LinkedMap<Integer,String> shuffledCon = new LinkedMap<>();

	Opdrachten(){                                                             /** constructor met alle opdrachten **/
		monopolisten.put(0,"Ga naar Buurtspoorwegen.");
		monopolisten.put(1,"Door een duister zaakje te doen krijg je een groot contract met de regering. Maar iemand heeft de pers ingelicht." +
				" Om te zien of de deal doorgaat, rol met de dobbelsteen. Bij 7 of minder: GEEN DEAL; 8 of meer: de storm waait over en je ontvangt €75.000");
		monopolisten.put(2,"Je maakt jouw concurrenten failliet door jouw prijzen drastisch te laten zakken, daarna kon je ze nog hoger laten stijgen." +
				" Ontvang €50.000 van de bank.");
		monopolisten.put(3,"Ga naar de electriciteitscentrale.");
		monopolisten.put(4,"Ga naar Start.");
		monopolisten.put(5,"Ga naar Start.");
		monopolisten.put(6,"Je probeert een monopolie op zonne-energie te hebben, goed geprobeerd maar je kan ze niet allemaal winnen!" +
				" Betaal €50.000 aan de bank.");
		monopolisten.put(7,"Je verbetert jouw publiek imago door te investeren in culturele activiteiten. Goed idee!");
		monopolisten.put(8,"Je loog en zei dat je een ingenieuze schop had uitgevonden, die je gezien hebt in een Azteken museum." +
				" Maar het gerechtshof verklaart jouw patent als ongeldig. Betaal €75.000 aan de bank.");
		monopolisten.put(9,"Door een gebrek aan concurrenten werd je nalatig, je wordt nu onderboden door de Chinese markt. Betaal €25.000 aan de bank.");
		monopolisten.put(10,"Ga op vakantie naar de Nieuwstraat in Brussel.");
		monopolisten.put(11,"Een nieuwe uitvinding zou jouw beste product aan banden hebben gelegd. Je hebt het opgekocht en van de markt gehouden," +
				" je ontvangt €25.000 van de bank.");
		monopolisten.put(12,"Een nieuwe rechter denkt: 'Wat goed is voor monopolisten is goed voor het land!', je ontvangt €25.000");
		monopolisten.put(13,"Om het mededingingsrecht te omzeilen heb je een advocaat omgekocht om een fusie goed te keuren maar een eerlijke secretaresse heeft jou verklikt." +
				" Ga direct naar de gevangenis en passeer niet langs Start!");
		monopolisten.put(14,"Door een publiek protest verlies je een belastingsvoordeel dat door een corrupte politicus voor jou gecreëerd was." +
				" Betaal de bank €75.000");
		monopolisten.put(15,"Jouw tweelingsbroer had zogezegd een concurrerend bedrijf maar het gerecht heeft hem verplicht zijn leidinggevende functie op te zeggen." +
				" Betaal €25.000");
		monopolisten.put(16,"Ondanks de vele veroordelingen van de Anti-Monopolie stichting ontvang jij toch de nationale prijs voor Humanitaire persoon van het jaar!");
		monopolisten.put(17,"Je hebt een monopolie op bakstenen, ontvang van elke concurrent €10.000.");
		monopolisten.put(18,"Een makelaar die met jou bevriend is krijgt een mooie positie binnen de regering. Hij is zijn oude vrienden niet vergeten," +
				" iedere monopolist ontvangt €25.000!");
		monopolisten.put(19,"Je bent een huisjesmelker en liet een aantal advocaten dezelfde huur betalen ongeacht de staat van het huis. " +
				"Gerechtelijk onderzoek bracht dit aan het licht. Ga direct naar de gevangenis en ga niet langs Start!");
		monopolisten.put(20,"Dankzij wat politieke spelletjes zijn de LEZ's afgeschaft en kunnen jouw vrachtwagens weer volop de stad vervuilen. " +
				"Je ontvangt €75.000");
		monopolisten.put(21,"Tijdens een spelletje golf maak je een goede deal voor badkuipen, ontvang €50.000");
		monopolisten.put(22,"Een wet die de bevolking in staat stelde om monopolisten aan te klagen werd versoepeld. Ontvang €25.000 van iedere concurrent.");
		monopolisten.put(23,"Ga naar de Veldstraat in Gent.");
		monopolisten.put(24,"Je hebt een monopolie op coaxiaal internet, de regering betaalt jou €50.000");

		concurrenten.put(0,"De Anti-Monopolie stichting haalt een elektronica gigant van de markt. Ontvang €75.000");
		concurrenten.put(1,"De regering brengt een halt toe aan een aantal prijsafspraken, iedereen begint elkaar massaal te onderbieden. " +
				"ga naar de Prijzenoorlog!");
		concurrenten.put(2,"Door middel van 'loop holes' kunnen grote bedrijven hun belasting onderduiken. De regering komt het geld bij jou halen, " +
				"betaal €75.000");
		concurrenten.put(3,"Er heerst een depressie en andere concurrenten onderbieden jou, betaal hen elks €10.000");
		concurrenten.put(4,"Een monopolist die jouw bedrijf schaadt gaat akkoord met een instemmingsbesluit. Geniet van deze morele overwinning!");
		concurrenten.put(5,"Je vond huurders voor jouw panden, ontvang €50.000 van de bank.");
		concurrenten.put(6,"Je krijgt een beurs van de Anti-Monopolie stichting, ontvang €25.000");
		concurrenten.put(7,"Je hebt jouw verhuur auto's een nieuw kleurtje gegeven en business is booming! Ontvang €50.000");
		concurrenten.put(8,"Je start een nieuw zaak maar zal die succesvol zijn? Als je 9 of minder rolt dat faalt ie; bij 10 of meer ontvang je €75.000!");
		concurrenten.put(9,"De stichting voor het mededingingsrecht heeft een monopolist geblokkeerd die jouw zaak wou overnemen. " +
				"Hoera!, de zaken blijven draaien!");
		concurrenten.put(10,"De monopolisten hebben de olieprijs opgevoerd, betaal €50.000 aan de bank.");
		concurrenten.put(11,"De economie gaat schitterend! Iedereen kan zijn huur betalen en jij ontvangt €50.000");
		concurrenten.put(12,"De regering geeft de Anti-Monopolie stichting een extra duwtje in de rug! Ontvang van iedere monopolist €25.000");
		concurrenten.put(13,"Door een door de regering gesteund onderzoek vindt men een beter manier om huizen te bouwen." +
				" Jouw huurprijzen zakken doordat er een groter aanbod is. Ga naar een Prijzenoorlog!");
		concurrenten.put(14,"De regering beslist om een grote multinational te steunen maar jouw vraag voor financiële steun werd genegeerd." +
				" Betaal €75.000 aan de bank.");
		concurrenten.put(15,"Je vecht om ervoor te zorgen dat een duur anti-pollutie middel niet verplicht wordt maar gelukkig voor onze lucht verlies je. " +
				"Betaal €25.000 aan de bank.");
		concurrenten.put(16,"Ga naar buurtspoorweg.");
		concurrenten.put(17,"Ga naar Start.");
		concurrenten.put(18,"Ga naar Start.");
		concurrenten.put(19,"Ga naar de Meir in Antwerpen.");
		concurrenten.put(20,"Ga op bezoek naar de gascentrale.");
		concurrenten.put(21,"Gigant Alles nv verlaagt zijn huurprijzen om zo concurrenten te vernietigen. Betaal €50.000 aan de bank.");
		concurrenten.put(22,"Ga op weekend naar de Steenstraat in Brugge.");
		concurrenten.put(23,"Je wint een gerechtelijke zaak tegen een monopolist. Zelfs na het betalen van jouw advocaten ontvang je nog €75.000");
		concurrenten.put(24,"Een gigantische makelaar laat jou met rust om ervoor te zorgen dat de Anti-Monopolie stichting hem ook met rust laat. " +
				"Ontvang €25.000 van de bank.");
		monopolistenSchudden();
		concurrentenSchudden();
	}

	public LinkedMap<Integer, String> getConcurrenten() { return concurrenten; }
	public LinkedMap<Integer, String> getMonopolisten() { return monopolisten; }

	public LinkedMap<Integer, String> getShuffledMon() { return shuffledMon; }
	public LinkedMap<Integer, String> getShuffledCon() { return shuffledCon; }

	public void setShuffledMon(LinkedMap<Integer, String> shuffledMon) { this.shuffledMon = shuffledMon; }

	public void setShuffledCon(LinkedMap<Integer, String> shuffledCon) { this.shuffledCon = shuffledCon; }

	private void monopolistenSchudden() {
		List<Integer> keys = new ArrayList(this.monopolisten.keySet());
		Collections.shuffle(keys);                                       	/** keys schudden (er is geen shuffle-methode voor 'map') **/
		LinkedMap<Integer,String> shuffledMap = new LinkedMap<>();			/** nieuwe geschudde LinkedMap **/
		for (Integer i : keys){												/** interatie over keys list **/
			shuffledMap.put(i,monopolisten.get(i));
		}
		shuffledMon.putAll(shuffledMap);
	}

	private void concurrentenSchudden() {
		List<Integer> keys = new ArrayList(this.concurrenten.keySet());
		Collections.shuffle(keys);                                       	/** keys schudden (er is geen shuffle-methode voor 'map') **/
		LinkedMap<Integer,String> shuffledMap = new LinkedMap<>();			/** nieuwe geschudde LinkedMap **/
		for (Integer i : keys){												/** interatie over keys list **/
			shuffledMap.put(i,concurrenten.get(i));
		}
		shuffledCon.putAll(shuffledMap);
	}

	public void doeOpdrachtMonopolist() {

	}

	public void doeOpdrachtConcurrent(){

	}

	/*public static void main(String[] args) {
		new Opdrachten().concurrentenSchudden();
		new Opdrachten().monopolistenSchudden();
		System.out.println(new Opdrachten().getMonopolisten());				// test code
		System.out.println(new Opdrachten().getConcurrenten());
		System.out.println(new Opdrachten().getShuffledCon());
	}*/
}