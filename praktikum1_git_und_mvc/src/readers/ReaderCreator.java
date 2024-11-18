package readers;

import java.io.IOException;

public abstract class ReaderCreator {
	
	public abstract ReaderProduct factoryMethod(String typ) throws IOException;

}
// IST RICHTIG
