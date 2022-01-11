package classCard;

import java.math.BigDecimal;

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
}

