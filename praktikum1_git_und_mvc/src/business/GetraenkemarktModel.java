package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GetraenkemarktModel {

	public Getraenkemarkt getraenkemarkt;

	public void nehmeGetraenkemarktAuf(String artikelnummer, float einkaufspreis, float verkaufspreis,
			String mitAlkohol, String[] behaeltnis) {
		this.getraenkemarkt = new Getraenkemarkt(artikelnummer, einkaufspreis, verkaufspreis, mitAlkohol, behaeltnis);
	}

	public String zeigeGetraenkeMarktAn() {
		if (this.getraenkemarkt != null) {
			return this.getraenkemarkt.gibBehaeltnisZurueck(' ');
		} else {
			return "Bisher wurde kein Getraenkemarkt aufgenommen!";
		}
	}

	public void leseAusDatei(String typ) throws IOException {

		BufferedReader ein = new BufferedReader(new FileReader("Getraenkemaerkte.csv"));
		String[] zeile = ein.readLine().split(";");
		this.getraenkemarkt = new Getraenkemarkt(zeile[0], Float.parseFloat(zeile[1]), Float.parseFloat(zeile[2]),
				zeile[3], zeile[4].split("_"));
		ein.close();

	}

	public void schreibeGetraenkemarktInCsvDatei() throws IOException {
		BufferedWriter aus = new BufferedWriter(new FileWriter("GetraenkemaerkteAusgabe.csv", true));
		aus.write(getraenkemarkt.gibBehaeltnisZurueck(';'));
		aus.close();
	}

}
