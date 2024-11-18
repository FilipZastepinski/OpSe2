package readers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import business.Getraenkemarkt;

public class ConcreteReaderProductCsv extends ReaderProduct {

	private BufferedReader reader;
	
	public ConcreteReaderProductCsv() throws IOException {
		this.reader = new BufferedReader(new FileReader("Getraenkemaerkte.csv"));
	}

	@Override
	public String[] leseAusDatei() throws IOException {
		String[] ergebniszeile = reader.readLine().split(";");
		return ergebniszeile;
	}

	@Override
	public void schließeReader() throws IOException {
		reader.close();
		
	}
}