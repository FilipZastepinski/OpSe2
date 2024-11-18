package readers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import business.Getraenkemarkt;

public class ConcreteReaderProductTxt extends ReaderProduct {

	private BufferedReader reader;
	private Getraenkemarkt getraenkemarkt;
	
	public ConcreteReaderProductTxt() throws IOException {
		this.reader = new BufferedReader(new FileReader("Getraenkemaerkte.txt"));
	}
	

	@Override
	public String[] leseAusDatei() throws IOException {
		
		String[] ergebniszeile = new String[5];
		String zeile = reader.readLine();
		
		int i = 0;

		while (i < ergebniszeile.length) {
			ergebniszeile[i] = zeile;
			zeile = reader.readLine();
			i++;
		}
		return ergebniszeile;
	}

	@Override
	public void schließeReader() throws IOException {
		reader.close();
	}
}