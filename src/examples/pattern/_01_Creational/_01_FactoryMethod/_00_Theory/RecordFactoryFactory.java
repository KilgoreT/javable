package examples.pattern._01_Creational._01_FactoryMethod._00_Theory;

import java.io.DataInput;
import java.lang.reflect.Constructor;

public class RecordFactoryFactory {

    private Constructor factoryConstructor;

    //POS Types
    public static final String ABC = "abc";

    //Constructor
    public RecordFactoryFactory(String posType) throws POSException {

        Class[] param = {DataInput.class};
        Class factoryClass;

        if (ABC.equals(posType)) {
            factoryClass = ABCJournalRecordFactory.class;
        } else {
            String msg = "Unknown POS type: " + posType;
            throw new IllegalArgumentException(msg);
        }

        try {
            factoryConstructor = factoryClass.getConstructor(param);
        } catch (Exception e) {
            String msg = "Error while constructing factory";
            throw new POSException(msg, e);
        }

    }

    // Метод создает объекты JournalRecordFactoryIF
    public JournalRecordFactoryIF createFactory(DataInput in) throws POSException {
        Object[] args = {in};
        Object factory;
        try {
            factory = factoryConstructor.newInstance(args);
        } catch (Exception e) {
            String msg = "Error creating factory";
            throw new POSException(msg, e);
        }
        return (JournalRecordFactoryIF)factory;
    }


}
