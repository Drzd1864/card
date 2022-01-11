package classCard;


import exceptionCard.InsufficientFundsException;

import java.math.BigDecimal;

public class DebitCard extends Card {

    public DebitCard(String holderName) {
        super(holderName);
    }

    public DebitCard(String holderName, BigDecimal accountBalance) {
        super(holderName, accountBalance);
    }

    @Override
    public BigDecimal withdrawFromCardBalance(BigDecimal amount) {
        if (amount == null /*|| amount.compareTo(BigDecimal.ZERO) < 0*/) {
            throw new IllegalArgumentException("Amount can not be negative");
        }
        if (accountBalance.compareTo(amount) >= 0) {
            return accountBalance.subtract(amount);
        } else {
            throw new InsufficientFundsException("Insufficient funds");
        }
    }
}



