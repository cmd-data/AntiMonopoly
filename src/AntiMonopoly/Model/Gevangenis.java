package AntiMonopoly.Model;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Gevangenis extends Tegel {

	private static final int boete = 50000;
	private static List<Speler> gevangenen = new ArrayList<>();


	public Gevangenis(String naam, int positie) {
		super(naam, positie);
	}

	public static void opBezoek (Speler speler) {
		System.out.println("Sightseeing Tour");
	}

	public static void verlaatGevangenisDoorGooien(Speler speler) {

		int worp = Dice.rollDice();
		if (Dice.isIsDubbel()) {
			Spel.move(speler, worp);
			gevangenen.remove(speler);

			final Stage dialog = new Stage();
			dialog.initModality(Modality.APPLICATION_MODAL);
			VBox dialogVBox = new VBox();
			dialog.setTitle("Gevangenis");
			dialogVBox.getChildren().addAll(new Text("U gooide dubbel!\n U bent vrij!"));
			Scene dialogScene = new Scene(dialogVBox, 300, 250);
			dialogVBox.setAlignment(Pos.CENTER);
			dialogVBox.setSpacing(10);
			dialogVBox.setStyle("-fx-font: 20px Tahoma");
			dialog.setScene(dialogScene);
			dialog.show();

		} else {
			final Stage dialog = new Stage();
			dialog.initModality(Modality.APPLICATION_MODAL);
			VBox dialogVBox = new VBox();
			dialog.setTitle("Gevangenis");
			dialogVBox.getChildren().addAll(new Text("U gooide niet dubbel!\n U blijft gevangen!"));
			Scene dialogScene = new Scene(dialogVBox, 300, 250);
			dialogVBox.setAlignment(Pos.CENTER);
			dialogVBox.setSpacing(10);
			dialogVBox.setStyle("-fx-font: 20px Tahoma");
			dialog.setScene(dialogScene);
			dialog.show();

		}

		Spel.updateGeld();
	}

	public static void verlaatGevangenisDoorBetalen(Speler speler){

		final Stage dialog = new Stage();
		dialog.initModality(Modality.APPLICATION_MODAL);
		VBox dialogVBox = new VBox();
		dialog.setTitle("Gevangenis");
		dialogVBox.getChildren().addAll(new Text("U betaalde een boete \nen bent vrij,"));
		Scene dialogScene = new Scene(dialogVBox, 300, 250);
		dialogVBox.setAlignment(Pos.CENTER);
		dialogVBox.setSpacing(10);
		dialogVBox.setStyle("-fx-font: 20px Tahoma");
		dialog.setScene(dialogScene);
		dialog.show();

		speler.setGeld(-boete);
		Spel.updateGeld();
		Dice.setCount(1);
	}


	public static List<Speler> getGevangenen() {
		return gevangenen; }
}