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

import java.util.ArrayList;
import java.util.List;

public class GasEnElektriciteitsbedrijf extends Tegel {

	private static List<GasEnElektriciteitsbedrijf> bedrijven = new ArrayList<>();

	private static final int waarde = 150000;
	private Speler eigenaar;
	private String naam;
	private int positie;
	private final int hypotheek = 75000;

	/**
	 * Standaard constructor voor 'isKoopbaar' methode in Tegel
	 */

	public GasEnElektriciteitsbedrijf(String naam, Speler eigenaar, int positie) {
		super(naam, positie);
		this.naam = naam;
		this.eigenaar = eigenaar;
		this.positie = positie;
	}

	public void koopGasofElektriciteitsbedrijf(Speler speler, GasEnElektriciteitsbedrijf bedrijf) {
		if (speler.getGeld() < waarde) {
			System.out.println("Niet genoeg geld");
		} else {
			bedrijf.setEigenaar(speler);
			speler.setGeld(-waarde);
		}
	}

	public void verkoopGasofElektriciteitsbedrijf (Speler speler, GasEnElektriciteitsbedrijf gasenelek) {
		speler.setGeld(waarde);
		gasenelek.setEigenaar(null);
	}

	/**
	 * hoeveel bedraagt de huur?
	 * @param gasEnElektriciteitsbedrijf
	 * @return
	 */

	public static int getHuur(GasEnElektriciteitsbedrijf gasEnElektriciteitsbedrijf) {
		int waardeWorp = Dice.rollDie();

		Speler eigenaar = gasEnElektriciteitsbedrijf.getEigenaar();
		int aantal = 0;

		for (Tegel tegel : Spelbord.getTegels()) {
			if (tegel instanceof GasEnElektriciteitsbedrijf) {
				bedrijven.add((GasEnElektriciteitsbedrijf) tegel);
			}
		}

		if (eigenaar.getIsConcurrent()) {
			return waardeWorp * 4 * 1000;
		} else {
			for (GasEnElektriciteitsbedrijf bedrijf : bedrijven) {
				if (eigenaar.equals(bedrijf.getEigenaar())) {
					aantal++;
				}
			}

			switch (aantal) {
				case 1:
					return (waardeWorp * 4 * 1000);
				case 2:
					return (waardeWorp * 10 * 1000);
			}
		}
		return 0;

	}

	/**
	 * visuele pop-up voor als je een bedrijf kan kopen
	 * @param bedrijf
	 * @param aanZet
	 */

	public static void gasElekMethodeKopen (GasEnElektriciteitsbedrijf bedrijf, Speler aanZet) {

		final Stage dialog = new Stage();
		dialog.initModality(Modality.APPLICATION_MODAL);
		VBox dialogVBox = new VBox();
		dialog.setTitle(bedrijf.getNaam());
		Button button = new Button("Koop");
		dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €" + waarde), button);
		Scene dialogScene = new Scene(dialogVBox, 500,300);
		dialogVBox.setAlignment(Pos.CENTER);
		dialogVBox.setSpacing(10);
		dialogVBox.setStyle("-fx-font: 20px Tahoma");
		dialog.setScene(dialogScene);
		dialog.show();

		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				dialog.close();
				Tegel.koopEigendom(bedrijf, aanZet);
				Spelbord.showOwner(bedrijf.getPositie(),aanZet);

				final Stage dialog = new Stage();
				dialog.initModality(Modality.APPLICATION_MODAL);
				VBox dialogVBox = new VBox();
				dialog.setTitle("Proficiat met uw aankoop!");
				Button button = new Button("OK");
				dialogVBox.getChildren().addAll(new Text("U hebt " + bedrijf.getNaam() + " aangekocht"), new Text("voor €" + waarde),
						button);
				Scene dialogScene = new Scene(dialogVBox, 600,300);
				dialogVBox.setAlignment(Pos.CENTER);
				dialogVBox.setSpacing(10);
				dialogVBox.setStyle("-fx-font: 20px Tahoma");
				dialog.setScene(dialogScene);
				dialog.show();

				button.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						dialog.close();
					}
				});
			}
		});
	}

	/**
	 * visuele pop-up als je huur moet betalen
	 * @param bedrijf
	 * @param aanZet
	 */

	public static void gasElekMethodeHuur (GasEnElektriciteitsbedrijf bedrijf, Speler aanZet) {

		final Stage dialog = new Stage();
		dialog.initModality(Modality.APPLICATION_MODAL);
		VBox dialogVBox = new VBox();
		dialog.setTitle("Betaal Huur");
		Button button = new Button("Betaal € " + getHuur(bedrijf));
		dialogVBox.getChildren().addAll(new Text("U dient huur te betalen aan " + bedrijf.getEigenaar().getNaam()), button);
		Scene dialogScene = new Scene(dialogVBox, 500,300);
		dialogVBox.setAlignment(Pos.CENTER);
		dialogVBox.setSpacing(10);
		dialogVBox.setStyle("-fx-font: 20px Tahoma");
		dialog.setScene(dialogScene);
		dialog.show();

		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				dialog.close();
				int geldVoorAankoop = aanZet.getGeld();
				Tegel.betaalHuur(bedrijf, aanZet);
				int prijsHuur = geldVoorAankoop - aanZet.getGeld();

				final Stage dialog = new Stage();
				dialog.initModality(Modality.APPLICATION_MODAL);
				VBox dialogVBox = new VBox();
				dialog.setTitle("Huur");
				Button button = new Button("OK");
				dialogVBox.getChildren().addAll(new Text("U gooide: " + Dice.getWorp1()), new Text("De huurprijs bedraagde: €" + prijsHuur ),
						button);
				Scene dialogScene = new Scene(dialogVBox, 600,300);
				dialogVBox.setAlignment(Pos.CENTER);
				dialogVBox.setSpacing(10);
				dialogVBox.setStyle("-fx-font: 20px Tahoma");
				dialog.setScene(dialogScene);
				dialog.show();

				button.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						dialog.close();
					}
				});
			}
		});
	}

	public Speler getEigenaar() {
		return this.eigenaar;
	}

	public String getNaam() {
		return naam;
	}

	public void setEigenaar(Speler eigenaar) {
		this.eigenaar = eigenaar;
	}

	public static List<GasEnElektriciteitsbedrijf> getBedrijven() { return bedrijven; }

	public static int getWaarde() { return waarde; }

	public int getHypotheek() { return hypotheek; }
}







