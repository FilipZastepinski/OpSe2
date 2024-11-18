package gui;

import java.io.IOException;
import business.GetraenkemarktModel;
import javafx.stage.Stage;

public class GetraenkemarktControl {

	private GetraenkemarktModel getrMod;
	private GetraenkemarktView getrView;

	public GetraenkemarktControl(Stage primaryStage) {
		this.getrMod = new GetraenkemarktModel();
		this.getrView = new GetraenkemarktView(this, primaryStage);
	}

	public void nehmeGetraenkemarktAuf() {
		try {
			// Eingabedaten aus der View holen und ans Model übergeben
			getrMod.nehmeGetraenkemarktAuf(getrView.getTxtArtikelnummer().getText(),
					Float.parseFloat(getrView.getTxtEinkaufspreis().getText()),
					Float.parseFloat(getrView.getTxtVerkaufspreis().getText()), getrView.getTxtMitAlkohol().getText(),
					getrView.getTxtBehältnis().getText().split(";"));
			getrView.zeigeInformationsfensterAn("Das Getraenkemarkt wurde aufgenommen!");
		} catch (Exception exc) {
			getrView.zeigeFehlermeldungsfensterAn(exc.getMessage());
		}
	}

	public void zeigeGetraenkeMarktAn() {
		String anzeigeText = getrMod.zeigeGetraenkeMarktAn();
		getrView.getTxtAnzeige().setText(anzeigeText);
	}

	public void leseAusDatei(String typ) {
		try {
			getrMod.leseAusDatei(typ);
			getrView.zeigeInformationsfensterAn("Die Getraenkemarkt wurden gelesen!");
		} catch (IOException exc) {
			getrView.zeigeInformationsfensterAn("IOException beim Lesen!");
		} catch (Exception exc) {
			getrView.zeigeInformationsfensterAn("Unbekannter Fehler beim Lesen!");
		}
	}

	public void schreibeGetraenkemarktInCsvDatei() {
		try {
			getrMod.schreibeGetraenkemarktInCsvDatei();
			getrView.zeigeInformationsfensterAn("Die Getraenkemaerkte wurden gespeichert!");
		} catch (IOException exc) {
			getrView.zeigeFehlermeldungsfensterAn("IOException beim Speichern!");
		} catch (Exception exc) {
			getrView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!");
		}
	}

}
