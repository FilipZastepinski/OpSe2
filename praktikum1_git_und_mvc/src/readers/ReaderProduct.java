package readers;

import java.io.IOException;

public abstract class ReaderProduct {

	public abstract String[] leseAusDatei() throws IOException;

	public abstract void schließeReader() throws IOException;
}
// IST RICHTIG