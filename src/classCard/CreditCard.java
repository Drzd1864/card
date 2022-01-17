package classCard;


import java.math.BigDecimal;

public class CreditCard extends Card {

    public CreditCard(String holderName) {
        super(holderName);
    }

    public CreditCard(String holderName, BigDecimal accountBalance) {
        super(holderName, accountBalance);
    }

    @Override
    public BigDecimal withdrawFromCardBalance(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount can not be negative");
        }
        return accountBalance.subtract(amount);
    }
}

