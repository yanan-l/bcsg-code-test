/**
 * Created by YANAN on 26/07/2015.
 */

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Set;
import java.util.List;

public class BankCardDetailsTest {
    private FileProcessor processor;

    @Before
    public void setUp() {
        processor = new FileProcessor();
    }

    @Test
    public void testReadCVS() {
        Set<BankcardDetails> cardDetailsSet = processor.readCSV("C:\\Users\\YANAN\\bankCardSort\\src\\test\\resources\\mid-test.csv");
        assertEquals("Incorrect data", 3, cardDetailsSet.size());
        List<BankcardDetails> cardDetailsList = new ArrayList<BankcardDetails>(cardDetailsSet);
        assertEquals("Incorrect data", "American Express", cardDetailsList.get(0).getBankName());
        assertEquals("Incorrect data", "xxxx-xxxx-xxxx-345", cardDetailsList.get(0).getMaskedNumber());
        assertEquals("Incorrect data", "HSBC Canada", cardDetailsList.get(1).getBankName());
        assertEquals("Incorrect data", "56xx-xxxx-xxxx-xxxx", cardDetailsList.get(1).getMaskedNumber());
        assertEquals("Incorrect data", "Royal Bank of  Canada", cardDetailsList.get(2).getBankName());
        assertEquals("Incorrect data", "4519-xxxx-xxxx-xxxx", cardDetailsList.get(2).getMaskedNumber());
    }

    @Test
    public void testReadCsvWithException() {
        //Negative Scenarios
    }
}
