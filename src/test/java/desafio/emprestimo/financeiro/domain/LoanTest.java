package desafio.emprestimo.financeiro.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class LoanTest {

    @Mock
    private Customer customer;

    @InjectMocks
    private Loan loan;

    @Nested
    class isPersonalLoanAvailable {

        @Test
        void shouldBeAvailableWhenIncomeIsEqualOrLess3k() {

            doReturn(true).when(customer).IsIncomeEqualOrLowerThan(3000.0);

           assertTrue (loan.isPersonalLoanAvailable());
        }

        @Test
        void shouldBeAvailableWhenIncomeIsBetween3kAnd5kAndAgeIsLessThan30AndLocationIsSP() {

            doReturn(false).when(customer).IsIncomeEqualOrLowerThan(3000.0);
            doReturn(true).when(customer).IsIncomeBetween(3000.0, 5000.0);
            doReturn(true).when(customer).IsAgeLowerThan(30);
            doReturn(true).when(customer).IsFromLocation("SP");

            assertTrue (loan.isPersonalLoanAvailable());
        }
    }

    @Nested
    class isGuaranteedLoanAvailable {

        @Test
        void shouldBeAvailableWhenIncomeIsEqualOrLess3k() {

            doReturn(true).when(customer).IsIncomeEqualOrLowerThan(3000.0);

            assertTrue (loan.isGuaranteedLoanAvailable());
        }

        @Test
        void shouldBeAvailableWhenIncomeIsBetween3kAnd5kAndAgeIsLessThan30AndLocationIsSP() {

            doReturn(false).when(customer).IsIncomeEqualOrLowerThan(3000.0);
            doReturn(true).when(customer).IsIncomeBetween(3000.0, 5000.0);
            doReturn(true).when(customer).IsAgeLowerThan(30);
            doReturn(true).when(customer).IsFromLocation("SP");

            assertTrue (loan.isGuaranteedLoanAvailable());
        }
    }

    @Nested
    class isConsigmentLoanAvailable {

        @Test
        void shouldBeAvailableWhenIncomeIsEqualOrGreaterThan5k() {

            doReturn(true).when(customer).IsIncomeEqualOrGreaterThan(5000.0);

            assertTrue(loan.isConsigmentLoanAvailable());
        }

        @Test
        void shouldBeNotAvailableWhenIncomeIsEqualTo4k() {

            doReturn(false).when(customer).IsIncomeEqualOrGreaterThan(4000.0);

            assertFalse(loan.isConsigmentLoanAvailable());
        }
    }

    @Nested
    class getPersonalLoanInterestRate {

        @Test
        void shouldBeTheInterestRateBe4() {

            doReturn(true).when(customer).IsIncomeEqualOrLowerThan(3000.0);

            assertEquals(4.0, loan.getPersonalLoanInterestRate());
        }

        @Test
        void shouldThrowExceptionWhenIsNotAvailable() {

            doReturn(false).when(customer).IsIncomeEqualOrLowerThan(3000.0);

            assertThrows(LoanNotAvailableException.class, () -> loan.getPersonalLoanInterestRate());
        }
    }

    @Nested
    class getGuaranteedLoanInterestRate {

        @Test
        void shouldBeTheInterestRateBe3() {

            doReturn(true).when(customer).IsIncomeEqualOrLowerThan(3000.0);

            assertEquals(3.0, loan.getGuaranteedLoanInterestRate());
        }

        @Test
        void shouldThrowExceptionWhenIsNotAvailable() {

            doReturn(false).when(customer).IsIncomeEqualOrLowerThan(3000.0);

            assertThrows(LoanNotAvailableException.class, () -> loan.getGuaranteedLoanInterestRate());
        }
    }

    @Nested
    class getConsigmentLoanInterestRate {

        @Test
        void shouldBeTheInterestRateBe2() {

            doReturn(true).when(customer).IsIncomeEqualOrGreaterThan(5000.0);

            assertEquals(2.0, loan.getConsigmentLoanInterestRate());
        }

        @Test
        void shouldThrowExceptionWhenIsNotAvailable() {

            doReturn(false).when(customer).IsIncomeEqualOrGreaterThan(5000.0);

            assertThrows(LoanNotAvailableException.class, () -> loan.getConsigmentLoanInterestRate());
        }
    }
}