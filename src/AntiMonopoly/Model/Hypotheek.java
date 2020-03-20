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

}