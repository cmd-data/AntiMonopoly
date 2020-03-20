package AntiMonopoly.Model;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.apache.commons.collections4.map.LinkedMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.IntStream;

public class ConcurrentenOfMonopolistenvak extends Tegel {

	Dice dice = new Dice();

	public ConcurrentenOfMonopolistenvak(String naam, int positie) {
		super(naam, positie);
	}

	private static Opdrachten opdrachten = new Opdrachten();

	/**
	 * Leest de opdracht voor
	 * Voert de opdracht uit
	 * En steekt de kaart onderaan het deck terug
	 * @param speler
	 */

	public static String zieKaart (Speler speler){											// activeren met 'trek kaart'

		if (speler.getIsConcurrent()){
			return Opdrachten.concurrenten.getValue(Opdrachten.shuffledCon.firstKey());
		} else {
			return Opdrachten.monopolisten.getValue(Opdrachten.shuffledMon.firstKey());
		}
	}

	public static void voerUit(Speler speler){												// activeren met knop 'OK' op de kaart

		if (speler.getIsConcurrent()){
			doeOpdrachtConcurrent(Opdrachten.shuffledCon.firstKey(),speler);
			steekTerugCon();
		} else {
			doeOpdrachtMonopolist(Opdrachten.shuffledMon.firstKey(),speler);
			steekTerugMon();
		}
		Spel.updateGeld();

	}

	public static void steekTerugMon() {
		ArrayList<Integer> keys = new ArrayList<>(Opdrachten.shuffledMon.keySet());
		LinkedMap<Integer,String> rotatedMon = new LinkedMap<>();
		Collections.rotate(keys, -1);											/** .rotate methode en -1 zorgt ervoor dat eerste de laatste key wordt en alles opschuift */
		for (Integer i : keys){
			String value = Opdrachten.monopolisten.getValue(i);
			rotatedMon.put(i,value);													/** plaats de waarde voor index i uit originele lijst in nieuwe map */
		}
		Opdrachten.setShuffledMon(rotatedMon);
	}

	public static void steekTerugCon() {
		ArrayList<Integer> keys = new ArrayList<>(Opdrachten.shuffledCon.keySet());
		LinkedMap<Integer,String> rotatedCon = new LinkedMap<>();
		Collections.rotate(keys, -1);
		for (Integer i : keys){
			String value = Opdrachten.concurrenten.getValue(i);
			rotatedCon.put(i,value);
		}
		Opdrachten.setShuffledCon(rotatedCon);
	}

	/**
	 * Alle move methoden nog linken met pion op spelbord (zowel voor monopolist als concurrent)
	 * @param opdracht
	 * @param speler
	 * @return
	 */

	public static void doeOpdrachtMonopolist(int opdracht,Speler speler) {
		switch (opdracht) {
			case 0:
				Tegel.tegelMethode(speler.getRectangle(), speler, 25);
				Spel.move(speler, Spelbord.getTegels().get(25));
				break;
			case 1:
				if (IntStream.of(Dice.rollDice()).sum() >= 8) {             // maakt som van gerolde dobbelstenen die in array zitten
					speler.setGeld(75000);
				}
				Dice.setCount(-1);
				break;
			case 2:                                                                // -25000 ??
			case 21:
			case 24:
				speler.setGeld(50000);
				break;
			case 3:
				Tegel.tegelMethode(speler.getRectangle(), speler, 12);
				Spel.move(speler, Spelbord.getTegels().get(12));
				break;
			case 4:
			case 5:
				Tegel.tegelMethode(speler.getRectangle(), speler, 0);
				Spel.move(speler, Spelbord.getTegels().get(0));
				break;
			case 6:
				speler.setGeld(-50000);
				break;
			case 7:
			case 16:
				break;
			case 8:
			case 14:
				speler.setGeld(-75000);                                            // doet niets ??
				break;
			case 9:
			case 15:
				speler.setGeld(-25000);                                            // + 50000 ??
				break;
			case 10:
				Tegel.tegelMethode(speler.getRectangle(), speler, 39);
				Spel.move(speler, Spelbord.getTegels().get(39));
				break;
			case 11:
			case 12:
				speler.setGeld(25000);
				break;
			case 13:
			case 19:
				Spel.move(speler, Spelbord.getTegels().get(30));
				Tegel.tegelMethode(speler.getRectangle(), speler, 30);
				break;
			case 17:
				int count = 0;
				for (Speler spelers : Spel.getSpelers()) {
					if (spelers.getIsConcurrent()) {
						count++;
						spelers.setGeld(-10000);
					}
				}
				speler.setGeld(count * 10000);
				break;
			case 18:
				for (Speler spelers : Spel.getSpelers()) {
					if (!spelers.getIsConcurrent()) {
						spelers.setGeld(25000);
					}
				}
				break;
			case 20:
				speler.setGeld(75000);                                    // doet niets (geen geld erbij of weg)??
				break;
			case 22:
				int counter = 0;
				for (Speler spelers : Spel.getSpelers()) {
					if (spelers.getIsConcurrent()) {
						counter++;
						spelers.setGeld(-25000);
					}
				}
				speler.setGeld(counter * 25000);
				break;
			case 23:
				Tegel.tegelMethode(speler.getRectangle(), speler, 31);
				Spel.move(speler, Spelbord.getTegels().get(31));
		}
	}

	public static void doeOpdrachtConcurrent (int opdracht, Speler speler) {

			switch (opdracht) {
				case 0:
				case 23:
					speler.setGeld(75000);
					break;
				case 1:
				case 13:
					Spel.move(speler, Spelbord.getTegels().get(30));
					Tegel.tegelMethode(speler.getRectangle(),speler,30);
					break;
				case 2:
				case 14:
					speler.setGeld(-75000);
					break;
				case 3:
					int counter = 0;
					for (Speler spelers : Spel.getSpelers()) {
						if (spelers.getIsConcurrent()) {
							counter++;
							spelers.setGeld(10000);
						}
					}
					speler.setGeld(counter * -10000);
					break;
				case 4:
				case 9:
					break;
				case 5:
				case 7:
				case 11:
					speler.setGeld(50000);
					break;
				case 6:
				case 24:
					speler.setGeld(25000);
					break;
				case 8:
					if (IntStream.of(Dice.rollDice()).sum() >= 9) {
						speler.setGeld(75000);
					}
					Dice.setCount(-1);
					break;
				case 10:
				case 21:
					speler.setGeld(-50000);
					break;
				case 12:
					int count = 0;
					for (Speler spelers : Spel.getSpelers()) {
						if (!spelers.getIsConcurrent()) {
							count++;
							spelers.setGeld(-25000);
						}
					}
					speler.setGeld(count * 25000);
					break;
				case 15:
					speler.setGeld(-25000);
					break;
				case 16:
					Tegel.tegelMethode(speler.getRectangle(),speler,25);
					Spel.move(speler, Spelbord.getTegels().get(25));
					break;
				case 17:
				case 18:
					Tegel.tegelMethode(speler.getRectangle(),speler,0);
					Spel.move(speler, Spelbord.getTegels().get(0));
					break;
				case 19:
					Tegel.tegelMethode(speler.getRectangle(),speler,37);
					Spel.move(speler, Spelbord.getTegels().get(37));
					break;
				case 20:
					Tegel.tegelMethode(speler.getRectangle(),speler,28);
					Spel.move(speler, Spelbord.getTegels().get(28));
					break;
				case 22:
					Tegel.tegelMethode(speler.getRectangle(),speler,6);
					Spel.move(speler, Spelbord.getTegels().get(6));
			}
		}

		public static void vakMethode(Speler aanZet){

			final Stage dialog = new Stage();
			dialog.initModality(Modality.APPLICATION_MODAL);
			VBox dialogVBox = new VBox();
			dialog.setTitle("Concurrenten en Monopolistenvak");
			Button button = new Button("Trek kaart");
			dialogVBox.getChildren().addAll(new Text("Neem een kaart"), button);
			Scene dialogScene = new Scene(dialogVBox, 500,300);
			dialogVBox.setAlignment(Pos.CENTER);
			dialogVBox.setSpacing(10);
			dialogVBox.setStyle("-fx-font: 20px Tahoma");
			dialog.setScene(dialogScene);
			dialog.show();

			button.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent actionEvent) {
					dialog.close();

					final Stage dialog = new Stage();
					dialog.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox = new VBox();
					dialog.setTitle("Opdracht");
					Button button = new Button("OK");
					dialogVBox.getChildren().addAll(new Text(ConcurrentenOfMonopolistenvak.zieKaart(aanZet)), button);
					Scene dialogScene = new Scene(dialogVBox, 1200, 250);
					dialogVBox.setAlignment(Pos.CENTER);
					dialogVBox.setSpacing(10);
					dialogVBox.setStyle("-fx-font: 20px Tahoma");
					dialog.setScene(dialogScene);
					dialog.show();

					button.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent actionEvent) {
							ConcurrentenOfMonopolistenvak.voerUit(aanZet);
							dialog.close();
						}
					});
				}
			});
		}
	}
