package testsCard;

import classCard.CreditCard;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class CreditCardTest {
    private CreditCard creditCard;

    @Before
    public void setUp() throws Exception {
        creditCard = new CreditCard("Kit", new BigDecimal(300));
    }

    @After
    public void tearDown() throws Exception {
        creditCard = null;
    }

    @Test
    public void testWithdrawFromCardPositiveAmount() {
        BigDecimal actual = creditCard.withdrawFromCardBalance(new BigDecimal(100));
        BigDecimal expected = new BigDecimal(200);
        assertEquals(expected, actual);
    }

    @Test
    public void testWithdrawFromCardNegativeBalance() {
        BigDecimal actual = creditCard.withdrawFromCardBalance(new BigDecimal(600));
        BigDecimal expected = new BigDecimal(-300);
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawFromCardNegativeAmount() {
        creditCard.withdrawFromCardBalance(new BigDecimal(-100));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawFromCardNullAmount() {
        creditCard.withdrawFromCardBalance(null);
    }

    @Test
    public void testGetCardBalanceInAnotherCurrency() {
        BigDecimal actual = creditCard.getCardBalanceInAnotherCurrency(new BigDecimal(2));
        BigDecimal expected = new BigDecimal("150.00");
        assertEquals(expected, actual);
    }

    @Test
    public void testAddToBalancePositiveCase() {
        BigDecimal actual = creditCard.addToBalance(new BigDecimal(2));
        BigDecimal expected = new BigDecimal(302);
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddToBalanceNullAmount() {
        creditCard.addToBalance(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddToBalanceNegativeAmount() {
        creditCard.addToBalance(new BigDecimal(-5));
    }
}
