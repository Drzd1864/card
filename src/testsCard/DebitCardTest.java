package testsCard;

import classCard.DebitCard;
import exceptionCard.InsufficientFundsException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class DebitCardTest {
    private DebitCard debitCard;

    @Before
    public void setUp() throws Exception {
        debitCard = new DebitCard("Kit", new BigDecimal(200));
    }

    @After
    public void tearDown() throws Exception {
        debitCard = null;
    }

    @Test(expected = InsufficientFundsException.class)
    public void testWithdrawIfCardBalanceLessAmount() {
        debitCard.withdrawFromCardBalance(new BigDecimal(400));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawFromCardNullAmount() {
        debitCard.withdrawFromCardBalance(null);
    }

    @Test
    public void testWithdrawFromCardBalance() {
        BigDecimal actual = debitCard.withdrawFromCardBalance(new BigDecimal(50));
        BigDecimal expected = new BigDecimal(150);
        assertEquals(expected, actual);
    }
}

