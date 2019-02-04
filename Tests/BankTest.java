import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Executable;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    Bank bank;

    @BeforeEach
    void Setup () {
        bank = new Bank();
    }

    @Test
    void bank_negativeBalanceCalcInterest_throwsException() {
        Account acc = new Account(-1);
        assertThrows(InvalidBalanceException.class, ()-> bank.calculateYearlyInterest(acc));
    }

    @Test
    void bank_zeroBalanceCalcInterest_returnZero() {
        Account acc = new Account(0);
        assertEquals(0, bank.calculateYearlyInterest(acc));
    }

    @Test
    void bank_lowBalanceCalcInterest_returnInterest() {
        Account acc = new Account(40);
        assertEquals(40*.03, bank.calculateYearlyInterest(acc));
    }

    @Test
    void bank_lowMidBoundaryBalanceCalcInterest_returnInterest() {
        Account acc = new Account(100);
        assertEquals(100*.05, bank.calculateYearlyInterest(acc));
    }

    @Test
    void bank_midBalanceCalcInterest_returnInterest() {
        Account acc = new Account(106);
        assertEquals(106*.05, bank.calculateYearlyInterest(acc));
    }

    @Test
    void bank_midHighBalanceCalcInterest_returnInterest() {
        Account acc = new Account(1000);
        assertEquals(1000*.07, bank.calculateYearlyInterest(acc));
    }

    @Test
    void bank_highBalanceCalcInterest_returnInterest() {
        Account acc = new Account(3000);
        assertEquals(3000*.07, bank.calculateYearlyInterest(acc));
    }
}