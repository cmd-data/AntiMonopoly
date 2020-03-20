package AntiMonopoly.Model;

import AntiMonopoly.View.MainMetPion.MainMetPionView;
import AntiMonopoly.View.MainScreen.MainView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class Hypotheek {

	private static List<Tegel> hypotheekLijst = new ArrayList<>();

	public Hypotheek (){ }

	public static boolean stopHuur(Tegel tegel) {
		return hypotheekLijst.contains(tegel);
	}

	public static List<Tegel> getHypotheekLijst() { return hypotheekLijst; }

	public static List<String> getHypotheekLijstNamen(Speler speler) {
		List <String> hypotheken = new ArrayList<>();
		for (Tegel tegel : hypotheekLijst) {
			hypotheken.add(tegel.getNaam());
		}
		hypotheken.retainAll(Speler.eigendommen(speler));			// houdt alleen duplicaten in de hypotheken lijst (eigendommen van de speler die ook op hypotheek staan)
		return hypotheken;
	}

	public static void neemHypotheek(Tegel tegel, Speler speler) {
		if(!hypotheekLijst.contains(tegel)) {

			hypotheekLijst.add(tegel);

			if (tegel instanceof Straat) {
				speler.setGeld(((Straat) tegel).getHypotheek());
			}
			if (tegel instanceof Transport) {
				speler.setGeld(((Transport) tegel).getHypotheek());
			}
			if (tegel instanceof GasEnElektriciteitsbedrijf) {
				speler.setGeld(((GasEnElektriciteitsbedrijf) tegel).getHypotheek());
			}

			Spel.updateGeld();
		}
	}

	public static void uitHypotheek(Tegel tegel, Speler speler){
		if (hypotheekLijst.contains(tegel)) {
			hypotheekLijst.remove(tegel);

			if (tegel instanceof Straat) {
				speler.setGeld(-((Straat) tegel).getHypotheek());
			}
			if (tegel instanceof Transport) {
				speler.setGeld(-((Transport) tegel).getHypotheek());
			}
			if (tegel instanceof GasEnElektriciteitsbedrijf) {
				speler.setGeld(-((GasEnElektriciteitsbedrijf) tegel).getHypotheek());
			}

			Spel.updateGeld();
		}
	}

	public static void hypotheekKnop(MainMetPionView view) {
		final Stage dialog = new Stage();
		dialog.initModality(Modality.APPLICATION_MODAL);
		VBox dialogVBox = new VBox();

		Button button1 = new Button("Op hypotheek");
		Button button2 = new Button("Uit hypotheek");
		ObservableList<String> eigendommen =
				FXCollections.observableArrayList(Speler.eigendommen(Spel.getSpelers().get(Dice.getCount()-1))); //eigendommen van de speler die aan de beurt is
		view.getMainView().getEigendommen().setItems(eigendommen);

		ObservableList<String> hypotheken =
				FXCollections.observableArrayList(Hypotheek.getHypotheekLijstNamen(Spel.getSpelers().get(Dice.getCount()-1)));
		view.getMainView().getHypotheken().setItems(hypotheken);

		dialog.setTitle("Eigendom op hypotheek zetten");
		dialogVBox.getChildren().addAll(new Text("Eigendommen: "),view.getMainView().getEigendommen(),new Text("Hypotheken: "),view.getMainView().getHypotheken(), button1,button2);
		Scene dialogScene = new Scene(dialogVBox, 300, 300);
		dialogVBox.setAlignment(Pos.CENTER);
		dialogVBox.setSpacing(10);
		dialogVBox.setStyle("-fx-font: 20px Tahoma");
		dialog.setScene(dialogScene);
		dialog.show();

		button1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				for (Tegel tegel : Spelbord.getTegels()) {
					if (view.getMainView().getEigendommen().getValue().equals(tegel.getNaam())){
						neemHypotheek(tegel,Spel.getSpelers().get(Dice.getCount()-1));
						dialog.close();
					}
				}
			}
		});

		button2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				for (Tegel tegel : Spelbord.getTegels()) {
					if (view.getMainView().getHypotheken().getValue().equals(tegel.getNaam())){
						uitHypotheek(tegel,Spel.getSpelers().get(Dice.getCount()-1));
						dialog.close();
					}
				}
			}
		});
	}

}