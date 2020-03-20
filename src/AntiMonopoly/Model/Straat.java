package AntiMonopoly.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.*;

public class Straat extends Tegel {

	private String straten, stad;
	private int prijs, huur, hypotheek, prijsHuis, aantalGebouwen, positie;
	private Speler eigenaar;
	private final int MAXHOTEL = 1;
	private final int MAXHUISMON = 3;
	private final int MAXHUISCON = 4;
	private Gebouwen gebouw;

	/**
	 * Standaard constructor voor 'isKoopbaar' methode in Tegel
	 */

	public Straat(String straat, int prijs, int huur, int hypotheek, int prijsHuis, Speler eigenaar, Gebouwen gebouw, int aantalGebouwen, String stad, int positie) {
		super(straat, positie);
		this.straten = straat;
		this.prijs = prijs;
		this.huur = huur;
		this.hypotheek = hypotheek;
		this.prijsHuis = prijsHuis;
		this.eigenaar = eigenaar;
		this.gebouw = gebouw;
		this.aantalGebouwen = aantalGebouwen;
		this.stad = stad;
		this.positie = positie;
	}

	public static boolean isBebouwd(Straat straat) {
		try {
			return straat.gebouw != null;
		} catch (NullPointerException ignored) {
		}
		return false;
	}

	public static boolean hasHotel(Straat straat) {
		try {
			return Gebouwen.Hotel.class.equals(straat.gebouw.getClass());
		} catch (NullPointerException ignored) {
		}
		return false;
	}

	public static boolean hasHouse(Straat straat) {
		try {
			return Gebouwen.Huis.class.equals(straat.gebouw.getClass());
		} catch (NullPointerException ignored) {
		}
		return false;
	}

	public static void koopStraat(Speler speler, Straat straat) {

		if (speler.getGeld() < straat.prijs) {

			//niet nodig

		} else {
			speler.setGeld(-straat.prijs);
			straat.setEigenaar(speler);
		}
	}

	public void verkoopStraat (Speler speler, Straat straat) {
		speler.setGeld(straat.prijs);
		straat.setEigenaar(null);
	}

	public static int getHuur(Straat straat) {
		boolean concurrent = straat.eigenaar.getIsConcurrent();

		if (!isBebouwd(straat)) {
			if (concurrent) {
				return straat.huur;
			} else {
				if (isMonopolyStad(straat.stad)) {
					return straat.huur * 2;
				} else {
					return straat.huur;
				}
			}
		}

		if (hasHouse(straat)) {
			if (concurrent) {
				return straat.prijsHuis / 10 * straat.aantalGebouwen + straat.huur;
			} else {
				if (isMonopolyStad(straat.stad)) {
					return (straat.prijsHuis / 5 * straat.aantalGebouwen + straat.huur) * 2;
				} else {
					return straat.prijsHuis / 5 * straat.aantalGebouwen + straat.huur;
				}
			}
		}

		if (hasHotel(straat)) {
			if (concurrent) {
				return straat.prijsHuis / 10 * 5 + straat.huur;
			} else {
				if (isMonopolyStad(straat.stad)) {
					return (straat.prijsHuis / 2 * 4 + straat.huur) * 2;
				} else {
					return straat.prijsHuis / 2 * 4 + straat.huur;
				}
			}
		}
		return 0;
	}

	public static boolean isMonopolyStad(String stad) {
		List<Straat> straten = new ArrayList<>();
		Set<Speler> eigenaars = new HashSet<>();

		for (Tegel tegel : Spelbord.getTegels()) {
			if (tegel instanceof Straat && stad.equals(((Straat) tegel).stad)) {
				if (!Hypotheek.getHypotheekLijst().contains(tegel)) {
					straten.add((Straat) tegel);
				}
			}

		}

		for (Straat straat : straten) {
			eigenaars.add(straat.eigenaar);
		}

		return straten.size() > eigenaars.size();
	}

	public static void straatMethodeKopen (Straat straat, Speler aanZet) {

		if (aanZet.getGeld() < straat.prijs) {

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
			dialog.setTitle(straat.getNaam());
			Button button = new Button("Koop");
			dialogVBox.getChildren().addAll(new Text("Aankoopprijs: €" + straat.getPrijs()), new Text("Huur: €" + straat.getHuurPrijs()),
					new Text("Hypotheek: €" + straat.getHypotheek()), new Text("Huisprijs: €" + straat.getPrijsHuis()), button);
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
					Tegel.koopEigendom(straat, aanZet);
					Spelbord.showOwner(straat.getPositie(), aanZet);

					final Stage dialog = new Stage();
					dialog.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox = new VBox();
					dialog.setTitle("Proficiat met uw aankoop!");
					Button button = new Button("OK");
					dialogVBox.getChildren().addAll(new Text("U hebt " + straat.getNaam() + " aangekocht"), new Text("voor €" + straat.getPrijs()),
							button);
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
						}
					});
				}
			});
		}
	}

	public static void straatMethodeHuur (Straat straat, Speler aanZet) {

		if (aanZet.getGeld() < getHuur(straat)) {

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
					Button button0 = new Button(":'-(");
					dialogVBox0.getChildren().addAll(new Text("De winnaar is: " + FaillietWinnaar.isWinnaar().getNaam()), new Text ("De verliezer is :" + aanZet.getNaam()), button0);
					Scene dialogScene0 = new Scene(dialogVBox0, 500, 300);
					dialogVBox0.setAlignment(Pos.CENTER);
					dialogVBox0.setSpacing(10);
					dialogVBox0.setStyle("-fx-font: 20px Tahoma");
					dialog0.setScene(dialogScene0);
					dialog0.show();

				}
			});

		} else {

			final Stage dialog = new Stage();
			dialog.initModality(Modality.APPLICATION_MODAL);
			VBox dialogVBox = new VBox();
			dialog.setTitle("Betaal Huur");
			Button button = new Button("Betaal €" + getHuur(straat));
			dialogVBox.getChildren().addAll(new Text("U dient huur te betalen aan " + straat.getEigenaar().getNaam()), button);
			Scene dialogScene = new Scene(dialogVBox, 400, 250);
			dialogVBox.setAlignment(Pos.CENTER);
			dialogVBox.setSpacing(10);
			dialogVBox.setStyle("-fx-font: 20px Tahoma");
			dialog.setScene(dialogScene);
			dialog.show();

			button.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					dialog.close();
					Tegel.betaalHuur(straat, aanZet);
				}
			});
		}
	}

	public static void straatMethodeBouwen (Straat straat, Speler aanZet){

		if (isMonopolyStad(straat.stad) || aanZet.getIsConcurrent()) {
			final Stage dialog = new Stage();
			dialog.initModality(Modality.APPLICATION_MODAL);
			VBox dialogVBox = new VBox();
			dialog.setTitle("Bouw");
			Button button1 = new Button("Bouw Hotel");
			ComboBox<Integer> comboBox = new ComboBox<>();
			ObservableList<Integer> hetAantalHuizen =
					FXCollections.observableArrayList(0, 1, 2, 3, 4);
			comboBox.setItems(hetAantalHuizen);
			Button button2 = new Button("Bouw Huis");
			dialogVBox.getChildren().addAll(new Text("Huisprijs: €" + straat.getPrijsHuis()), new Text("Hoeveel huizen wilt u?"),
					comboBox, button1, button2);
			Scene dialogScene = new Scene(dialogVBox, 300, 250);
			dialogVBox.setAlignment(Pos.CENTER);
			dialogVBox.setSpacing(10);
			dialogVBox.setStyle("-fx-font: 20px Tahoma");
			dialog.setScene(dialogScene);
			dialog.show();

			//Koop Hotel
			button1.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					dialog.close();
					int geldVoorAankoop = aanZet.getGeld();
					Gebouwen.koopHotel(straat, new Gebouwen.Hotel(), aanZet);
					int prijsHotel = geldVoorAankoop - aanZet.getGeld();

					final Stage dialog = new Stage();
					dialog.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox = new VBox();
					dialog.setTitle("Hotel");
					Button button = new Button("OK");
					dialogVBox.getChildren().addAll(new Text("U kocht een hotel voor €" + prijsHotel),
							button);
					Scene dialogScene = new Scene(dialogVBox, 400, 250);
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

			//Koop huis
			button2.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					String tekst = " huizen voor €";
					if (comboBox.getValue() == 1) {
						tekst = " huis voor €";
					}

					dialog.close();
					int geldVoorAankoop = aanZet.getGeld();
					Gebouwen.koopHuis(straat, new Gebouwen.Huis(),
							comboBox.getValue(), aanZet);
					int prijsHuis = geldVoorAankoop - aanZet.getGeld();

					final Stage dialog = new Stage();
					dialog.initModality(Modality.APPLICATION_MODAL);
					VBox dialogVBox17 = new VBox();
					dialog.setTitle("Huis");
					Button button = new Button("OK");
					dialogVBox17.getChildren().addAll(new Text("U kocht " + comboBox.getValue() + tekst + prijsHuis),
							button);
					Scene dialogScene17 = new Scene(dialogVBox17, 400, 250);
					dialogVBox17.setAlignment(Pos.CENTER);
					dialogVBox17.setSpacing(10);
					dialogVBox17.setStyle("-fx-font: 20px Tahoma");
					dialog.setScene(dialogScene17);
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


	public String getStraat() {
		return straten;
	}

	public int getPrijs() {
		return this.prijs;
	}

	public int getHypotheek() {
		return this.hypotheek;
	}

	public int getPrijsHuis() {
		return prijsHuis;
	}

	public Speler getEigenaar() {
		return this.eigenaar;
	}

	public void setEigenaar(Speler eigenaar) {
		this.eigenaar = eigenaar;
	}

	public int getMaxHotel() {
		return MAXHOTEL;
	}

	public int getMaxHuisMon() {
		return MAXHUISMON;
	}

	public int getMaxHuisCon() {
		return MAXHUISCON;
	}

	public Gebouwen getGebouw() {
		return this.gebouw;
	}

	public void setGebouw(Gebouwen gebouw) {
		this.gebouw = gebouw;
	}

	public int getAantalGebouwen() {
		return aantalGebouwen;
	}

	public void setAantalGebouwen(int aantalGebouwen) {
		this.aantalGebouwen = aantalGebouwen;
	}

	public String getStad() {
		return this.stad;
	}

	public int getHuurPrijs() { return huur; }
}