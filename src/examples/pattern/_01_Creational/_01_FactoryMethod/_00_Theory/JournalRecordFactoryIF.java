package examples.pattern._01_Creational._01_FactoryMethod._00_Theory;

import java.io.EOFException;
import java.io.IOException;

public interface JournalRecordFactoryIF {

    public JournalRecordIF nextRecord() throws EOFException, IOException;
}
