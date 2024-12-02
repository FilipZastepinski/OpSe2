package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ownUtil.Observable;
import ownUtil.Observer;
import readers.*;

public class GetraenkemarktModel implements Observable {

	public Getraenkemarkt getraenkemarkt;
	
	// Singleton Pattern ----------------------------------------------------------------
	// statische variable die beim aufruf von getInstance() die einzige Instanz hält
	private static GetraenkemarktModel instance;
	// verwindert erzeugung weiterer instanzen in anderen klassen
	private GetraenkemarktModel() { 
		
	}
	// methode zur erzeugung einer einzigen instanz
	public static GetraenkemarktModel getInstance() {
		if (instance == null) {
			instance = new GetraenkemarktModel();
		}
		return instance;
	}
	// Singleton Pattern ---------------------------------------------------------------
	
	// Observable Pattern
	private List<Observer> observers = new ArrayList<>(); // Liste der Beobachter
	
	@Override
	public void addObserver(Observer observer) {
		this.observers.add(observer);
		
	}

	@Override
	public void removeObserver(Observer observer) {
		this.observers.remove(observer);
		
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update();
		}
		
	}

	public void nehmeGetraenkemarktAuf(String artikelnummer, float einkaufspreis, float verkaufspreis,
			String mitAlkohol, String[] behaeltnis) {
		this.getraenkemarkt = new Getraenkemarkt(artikelnummer, einkaufspreis, verkaufspreis, mitAlkohol, behaeltnis);
		notifyObservers(); // Benachrichtigung der Observer nach Aufnahme von Getränken
	}

	public String zeigeGetraenkeMarktAn() {
		if (this.getraenkemarkt != null) {
			return this.getraenkemarkt.gibBehaeltnisZurueck(' ');
		} else {
			return "Bisher wurde kein Getraenkemarkt aufgenommen!";
		}
	}

	public void leseAusDatei(String typ) throws IOException {
		String[] daten;
	    
	    if ("txt".equals(typ)) {
	        daten = leseGetraenkemarktDateiAusTxt();
	    } else if ("csv".equals(typ)) {
	        daten = leseGetraenkemarktDatenAusCsv();
	    } else {
	        throw new IllegalArgumentException("Unbekannter Dateityp: " + typ);
	    }

	    // Überprüfen, ob Daten erfolgreich gelesen wurden
	    if (daten != null && daten.length >= 5) {
	        // Initialisieren des Getraenkemarkt-Objekts mit den gelesenen Daten
	        this.getraenkemarkt = new Getraenkemarkt(
	            daten[0],
	            Float.parseFloat(daten[1]),
	            Float.parseFloat(daten[2]),
	            daten[3],
	            daten[4].split("_")
	        );
	    } else {
	        throw new IOException("Fehler beim Lesen der Daten aus der Datei");
	    }
	    notifyObservers(); // Benachrichtigung der Observer nach lesen von Dateien
		
	}

	public void schreibeGetraenkemarktInCsvDatei() throws IOException {
		BufferedWriter aus = new BufferedWriter(new FileWriter("GetraenkemaerkteAusgabe.csv", true));
		aus.write(getraenkemarkt.gibBehaeltnisZurueck(';'));
		aus.close();
	}
	
	//Ergänzen der Methode leseGetraenkemarktDatenAusCsv
	public String[] leseGetraenkemarktDatenAusCsv() throws IOException {
		ReaderCreator creator = new ConcreteReaderCreator();
		ReaderProduct reader = creator.factoryMethod("csv");
		String [] aus = reader.leseAusDatei();
		reader.schließeReader();
		return aus;
	}
	
	//Ergänzen der Methode leseGetrankemarktDatenAusTxt
	public String[] leseGetraenkemarktDateiAusTxt() throws IOException {
		ReaderCreator creator = new ConcreteReaderCreator();
		ReaderProduct reader = creator.factoryMethod("txt");
		String [] aus = reader.leseAusDatei();
		reader.schließeReader();
		return aus;
	}

}
