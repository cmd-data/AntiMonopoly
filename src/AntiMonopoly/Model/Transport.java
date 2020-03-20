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

public class Transport extends Tegel {

	private static List<Transport> transport = new ArrayList<>();

	private static final int waarde = 200000;
	private Speler eigenaar;
	private String naam;
	private int positie;
	private final int hypotheek = 100000;

	public Transport(String naam, Speler eigenaar, int positie){
		super(naam,positie);
		this.naam = naam;
		this.eigenaar = eigenaar;
		this.positie = positie;
	}

	public static int getWaarde() { return waarde; }

	public void koopTransportbedrijf(Speler speler, Transport bedrijf){

		if (speler.getGeld() < waarde) {
			//niet nodig
		} else {
			bedrijf.setEigenaar(speler);
			speler.setGeld(-waarde);
		}
	}

	public void verkoopTransportbedrijf (Speler speler, Transport bedrijf) {
		speler.setGeld(waarde);
		bedrijf.setEigenaar(null);
	}

	public static int getHuur(Transport transportBedrijf){
		int aantal = 0;
		Speler eigenaar = transportBedrijf.getEigenaar();

		for (Tegel tegel : Spelbord.getTegels()) {
			if (tegel instanceof Transport){
				transport.add((Transport)tegel);
			}
		}

		if(eigenaar.getIsConcurrent()){
			transport.clear();
			return (int) (waarde * 0.1);
		} else {
			for (int i = 0; i < transport.size(); i++) {
				if (eigenaar.equals(transport.get(i).getEigenaar())){
					aantal++;												  // checken hoeveel transportbedrijven een monopolist heeft
				}
			}
			transport.clear();
			return (int) (waarde * 0.1) * aantal;
		}

	}

	public static void transportMethodeKopen (Transport transport, Speler aanZet) {
		//Tegel heeft geen eigenaar

		if (aanZet.getGeld() < waarde) {

			final Stage dialog0 = new Stage();
			dialog0.initModality(Modality.APPLICATION_MODAL);
			VBox dialogVBox0 = new VBox();
			dialog0.setTitle("Oeps!");
			Button button0 = new Button("OK");
			dialogVBox0.getChildren().addAll(new Text("U heeft te weinig geld om dit kopen!"), button0);
			Scene dialogScene0 = new Scene(dialogVBox0, 500, 300);
			dialogVBox0.setAlignment(Pos.CENTER);
			dialogVBox0.setSpacing(10);
			dialogVBox0.setStyle("-fx-font: 20px Tahoma");
			dialog0.setScene(dialogScene0);
			dialog0.show();

			button0.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					dialog0.close();
				}
			});

		} else {

			final Stage dialog = new Stage();
			dialog.initModality(Modality.APPLICATION_MODAL);
			VBox dialogVBox = new VBox();
			dialog.setTitle(transport.getNaam());
			Button button = new Button("Koop");
			dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €" + waarde), button);
			Scene dialogScene = new Scene(dialogVBox, 300, 250);
			dialogVBox.setAlignment(Pos.CENTER);
			dialogVBox.setSpacing(10);
			dialogVBox.setStyle("-fx-font: 20px Tahoma");
			dialog.setScene(dialogScene);
			dialog.show();

			button.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					dialog.close();
					Tegel.koopEigendom(transport, aanZet);
					Spelbord.showOwner(transport.getPositie(), aanZet);

					final Stage dialog = new Stage();
					dialog.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox = new VBox();
					dialog.setTitle("Proficiat met uw aankoop!");
					Button button = new Button("OK");
					dialogVBox.getChildren().addAll(new Text("U hebt " + transport.getNaam() + " aangekocht"), new Text("voor €" + waarde),
							button);
					Scene dialogScene = new Scene(dialogVBox, 600, 250);
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
	}

	public static void transportMethodeHuur(Transport transport, Speler aanZet) {

		if (aanZet.getGeld() < getHuur(transport)) {

			final Stage dialog0 = new Stage();
			dialog0.initModality(Modality.APPLICATION_MODAL);
			VBox dialogVBox0 = new VBox();
			dialog0.setTitle("Oeps!");
			Button button0 = new Button(":'-(");
			dialogVBox0.getChildren().addAll(new Text("U heeft te weinig geld huur te betalen!"), button0);
			Scene dialogScene0 = new Scene(dialogVBox0, 500, 300);
			dialogVBox0.setAlignment(Pos.CENTER);
			dialogVBox0.setSpacing(10);
			dialogVBox0.setStyle("-fx-font: 20px Tahoma");
			dialog0.setScene(dialogScene0);
			dialog0.show();

			button0.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {

					final Stage dialog0 = new Stage();
					dialog0.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox0 = new VBox();
					dialog0.setTitle("Winnaar en verliezer");
					Button button01 = new Button(":'-(");
					dialogVBox0.getChildren().addAll(new Text("De winnaar is: " + FaillietWinnaar.isWinnaar().getNaam()), new Text ("De verliezer is :" + aanZet.getNaam()), button01);
					Scene dialogScene0 = new Scene(dialogVBox0, 500, 300);
					dialogVBox0.setAlignment(Pos.CENTER);
					dialogVBox0.setSpacing(10);
					dialogVBox0.setStyle("-fx-font: 20px Tahoma");
					dialog0.setScene(dialogScene0);
					dialog0.show();

					button01.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Runtime.getRuntime().exit(1);
						}
					});
				}
			});

		} else {

			final Stage dialog = new Stage();
			dialog.initModality(Modality.APPLICATION_MODAL);
			VBox dialogVBox = new VBox();
			dialog.setTitle("Betaal Huur");
			Button button = new Button("Betaal €" + getHuur(transport));
			dialogVBox.getChildren().addAll(new Text("U dient huur te betalen aan " + transport.getEigenaar().getNaam()), button);
			Scene dialogScene = new Scene(dialogVBox, 500, 250);
			dialogVBox.setAlignment(Pos.CENTER);
			dialogVBox.setSpacing(10);
			dialogVBox.setStyle("-fx-font: 20px Tahoma");
			dialog.setScene(dialogScene);
			dialog.show();

			button.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					dialog.close();
					Tegel.betaalHuur(transport, aanZet);
				}
			});
		}
	}

	public static List<Transport> getTransport() { return transport; }

	public Speler getEigenaar() { return eigenaar; }

	public void setEigenaar(Speler eigenaar) { this.eigenaar = eigenaar; }

	public String getNaam() { return naam; }

	public void setNaam(String naam) { this.naam = naam; }

	public int getHypotheek() { return hypotheek; }
}