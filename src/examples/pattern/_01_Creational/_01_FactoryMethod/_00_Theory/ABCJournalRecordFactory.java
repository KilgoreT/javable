package examples.pattern._01_Creational._01_FactoryMethod._00_Theory;


import java.io.DataInput;
import java.io.EOFException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class ABCJournalRecordFactory implements JournalRecordFactoryIF {

    // Типы записей
    private static final String START_OF_SALE = "4";
    private static final String SALE_LINE_ITEM = "17";

    private DataInput in;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

    // счетчик количества записей
    private int sequenceNumber = 0;

    ABCJournalRecordFactory(DataInput input) {
        in = input;
    }


    @Override
    public JournalRecordIF nextRecord() throws EOFException, IOException {

        String record = in.readLine();
        StringTokenizer tokenizer;
        tokenizer = new StringTokenizer(record, ",");
        sequenceNumber++;

        try {
            String recordType = tokenizer.nextToken();
            //...
            if (recordType.equals(START_OF_SALE)) {
                return constractStartOfSale(tokenizer);
            } else if (recordType.equals(SALE_LINE_ITEM)) {
                return constractSaleLineItem(tokenizer);
            } else {
                String msg = "Unknown record type";
                throw new IOException(msg);
            }
        } catch (NoSuchElementException e) {
            String msg = "record is missing some fields";
            IOException ioe = new EOFException(msg);
            ioe.initCause(e);
            throw ioe;
        }
    }


    private JournalRecordIF constractStartOfSale(StringTokenizer tok) throws NoSuchElementException {
        String transactionID = tok.nextToken();
        tok.nextToken();
        String timestampString = tok.nextToken();
        Date timestamp = parseTimestamp(timestampString);
        String terminalID = tok.nextToken();
        return new StartOfSale(terminalID,
                sequenceNumber,
                timestamp,
                transactionID);
    }

    private JournalRecordIF constractSaleLineItem(StringTokenizer tokenizer) {
        return null;
    }

}
