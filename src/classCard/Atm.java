package classCard;

import java.math.BigDecimal;
import java.util.Objects;


public class Atm {
    private Card card;


    public Atm(Card card) {
        this.card = card;
    }

    public BigDecimal addToBalance(BigDecimal amount) {
        return card.addToBalance(amount);
    }

    public void withdrawFromCardBalance(BigDecimal amount) {
        card.withdrawFromCardBalance(amount);
    }

    @Override
    public String toString() {
        return "Atm{" +
                "card=" + card +
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
        Atm atm = (Atm) o;
        return Objects.equals(card, atm.card);
    }

    @Override
    public int hashCode() {
        return Objects.hash(card);
    }
}

