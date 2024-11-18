package readers;

import java.io.IOException;

public class ConcreteReaderCreator extends ReaderCreator{

	@Override
	public ReaderProduct factoryMethod(String typ) throws IOException {
		if(typ.equals("csv")) {
			return new ConcreteReaderProductCsv();
		}else{
			return new ConcreteReaderProductTxt();
		}
	}
}
