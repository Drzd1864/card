package classCard;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public abstract class Card {
    protected String holderName;
    protected BigDecimal accountBalance;

    public Card(String holderName) {
        this.holderName = holderName;
    }



    public Card(String holderName, BigDecimal accountBalance) {
        this.holderName = holderName;
        this.accountBalance = accountBalance;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public BigDecimal addToBalance(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount can not be negative");
        }
        return accountBalance.add(amount);
    }

    public abstract BigDecimal withdrawFromCardBalance(BigDecimal amount);

    public BigDecimal getCardBalanceInAnotherCurrency(BigDecimal anotherCurrency) {
        return accountBalance.divide(anotherCurrency, 2, RoundingMode.CEILING);
    }

    @Override
    public String toString() {
        return "Card{" +
                "holderName='" + holderName + '\'' +
                ", accountBalance=" + accountBalance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Card card = (Card) o;
        return Objects.equals(holderName, card.holderName) && Objects.equals(accountBalance, card.accountBalance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(holderName, accountBalance);
    }
}


