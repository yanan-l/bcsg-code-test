import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by YANAN on 26/07/2015.
 */
public class FileProcessor {
    public Set<BankcardDetails> readCSV(String fileName) {
        BufferedReader reader = null;
        String line = "";
        String csvSplitBy = ",";
        Set<BankcardDetails> bankCardSet = new TreeSet<BankcardDetails>();
        try {
            reader = new BufferedReader(new FileReader(fileName));
            while ((line = reader.readLine()) != null) {
                String[] cardDetails = line.split(csvSplitBy);
                bankCardSet.add(computeBankCardDetails(cardDetails));
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        }
        return bankCardSet;
    }

    public BankcardDetails computeBankCardDetails(String[] cardDetailsString) {
        BankcardDetails cardDetails = new BankcardDetails();
        if (cardDetailsString.length == 3) {
            String bankName = cardDetailsString[0];
            String bankNumber = cardDetailsString[1];
            cardDetails.setBankName(bankName);
            cardDetails.setCardNumber(bankNumber);
            cardDetails.setMaskedNumber(computeMaskedNumber(bankName, bankNumber));
            cardDetails.setExpirationDate(cardDetailsString[2]);
            return cardDetails;
        } else {
            throw new IllegalArgumentException("Invalid data");
        }
    }

    private String computeMaskedNumber(String bankName, String bankNumber) {
        String maskedNumber = null;
        if ("HSBC Canada".equals(bankName)) {
            maskedNumber = maskNumber(bankNumber, "##xx-xxxx-xxxx-xxxx");
        } else if ("Royal Bank of  Canada".equals(bankName)) {
            maskedNumber = maskNumber(bankNumber, "####-xxxx-xxxx-xxxx");
        } else if ("American Express".equals(bankName)) {
            maskedNumber = maskNumber(bankNumber, "xxxx-xxxx-xxxx-###");
        }
        return maskedNumber;
    }

    private String maskNumber(String bankNumber, String pattern) {
        int index = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (c == '#') {
                builder.append(bankNumber.charAt(index));
                index++;
            } else if (c == 'x') {
                builder.append('x');
                index++;
            } else {
                builder.append(c);
                index++;
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        FileProcessor processor = new FileProcessor();
        Set<BankcardDetails> bankCardSet = processor.readCSV("C:\\Users\\YANAN\\bankCardSort\\src\\main\\resources\\mid-test.csv");
        System.out.println(bankCardSet);
    }
}
