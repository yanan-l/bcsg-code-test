import java.util.Date;

import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by YANAN on 26/07/2015.
 */
class BankcardDetails implements Comparable<BankcardDetails> {
    private String bankName;
    private String cardNumber;
    private String maskedNumber;
    private String expirationDate;

    public BankcardDetails() {

    }

    public BankcardDetails(String bankName, String cardNumber, String maskedNumber, String expirationDate) {
        this.bankName = bankName;
        this.cardNumber = cardNumber;
        this.maskedNumber = maskedNumber;
        this.expirationDate = expirationDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getMaskedNumber() {
        return maskedNumber;
    }

    public void setMaskedNumber(String maskedNumber) {
        this.maskedNumber = maskedNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BankcardDetails) {
            BankcardDetails other = (BankcardDetails) obj;
            return (this.bankName == null ? other.bankName == null : this.bankName.equals(other.bankName)) &&
                    (this.cardNumber == null ? other.cardNumber == null : this.cardNumber.equals(other.cardNumber)) &&
                    (this.maskedNumber == null ? other.maskedNumber == null : this.maskedNumber.equals(other.maskedNumber)) &&
                    (this.expirationDate == null ? other.expirationDate == null : this.expirationDate.equals(other.expirationDate));
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(bankName).append(cardNumber).append(maskedNumber).append(expirationDate).toHashCode();
    }

    @Override
    public int compareTo(BankcardDetails bcd) {
        return expirationDate.compareTo(bcd.expirationDate);
    }

    @Override
    public String toString() {
        return "Bank Card Name: " + this.bankName + " Bank Card Number: " + this.cardNumber + " Masked Number: " + maskedNumber + " Expiration Date: " + expirationDate + "\n";
    }
}
