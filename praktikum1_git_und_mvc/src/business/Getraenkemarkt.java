package business;

public class Getraenkemarkt {

	// Artikelnummer
	private String artikelnummer;
	// Einkaufs- und Verkaufspreise
	private float einkaufspreis;
	private float verkaufspreis;
	// Ob mit oder ohne Alkohol
	private String mitAlkohol;
	// Arten der Behältnisse
	private String[] behaeltnis;

	public Getraenkemarkt(String artikelnummer, float einkaufspreis, float verkaufspreis, String mitAlkohol,
			String[] behaeltnis) {
		this.artikelnummer = artikelnummer;
		this.einkaufspreis = einkaufspreis;
		this.verkaufspreis = verkaufspreis;
		this.mitAlkohol = mitAlkohol;
		this.behaeltnis = behaeltnis;
	}

	public String getArtikelnummer() {
		return artikelnummer;
	}

	public void setArtikelnummer(String artikelnummer) {
		this.artikelnummer = artikelnummer;
	}

	public float getEinkaufspreis() {
		return einkaufspreis;
	}

	public void setEinkaufspreis(float einkaufspreis) {
		this.einkaufspreis = einkaufspreis;
	}

	public float getVerkaufspreis() {
		return verkaufspreis;
	}

	public void setVerkaufspreis(float verkaufspreis) {
		this.verkaufspreis = verkaufspreis;
	}

	public String getMitAlkohol() {
		return mitAlkohol;
	}

	public void setMitAlkohol(String mitAlkohol) {
		this.mitAlkohol = mitAlkohol;
	}

	public String[] getBehaeltnis() {
		return behaeltnis;
	}

	public void setBehaeltnis(String[] behaeltnis) {
		this.behaeltnis = behaeltnis;
	}

	public String getBehaeltnisAlsString(char trenner) {
		String ergebnis = "";
		int i = 0;
		for (i = 0; i < this.getBehaeltnis().length - 1; i++) {
			ergebnis = ergebnis + this.getBehaeltnis()[i] + trenner;
		}
		return ergebnis + this.getBehaeltnis()[i];
	}

	public String gibBehaeltnisZurueck(char trenner) {
		return this.getArtikelnummer() + trenner + this.getEinkaufspreis() + trenner + this.getVerkaufspreis() + trenner
				+ this.getMitAlkohol() + trenner + "\n" + this.getBehaeltnisAlsString(trenner) + "\n";
	}
}