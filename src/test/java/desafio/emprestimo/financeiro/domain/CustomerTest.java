package desafio.emprestimo.financeiro.domain;

import desafio.emprestimo.financeiro.factory.CustomerFactory;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CustomerTest {

    @Nested
    class isIncomeEqualOrLowerThan {

        @Test
        void shouldBeTrueWhenIncomeIsEqual() {

            var customer = CustomerFactory.build(5000.0);

            assertTrue(customer.IsIncomeEqualOrLowerThan(5000.0));
        }

        @Test
        void shouldBeTrueWhenIncomeIsLowerThan() {

            var customer = CustomerFactory.build(5000.0);

            assertTrue(customer.IsIncomeEqualOrLowerThan(9000.0));
        }

        @Test
        void shouldBeFalseWhenIncomeIsGreaterThanValue() {

            var customer = CustomerFactory.build(5000.0);

            assertFalse(customer.IsIncomeEqualOrLowerThan(8000.0));
        }
    }

    @Nested
    class isIncomeEqualOrGreaterThan {

        @Test
        void shouldBeTrueWhenIncomeIsEqual() {

            var customer = CustomerFactory.build(5000.0);

            assertTrue(customer.IsIncomeEqualOrGreaterThan(5000.0));
        }

        @Test
        void shouldBeTrueWhenIncomeIsGreaterThan() {

            var customer = CustomerFactory.build(5000.0);

            assertTrue(customer.IsIncomeEqualOrGreaterThan(3000.0));
        }

        @Test
        void shouldBeFalseWhenIncomeIsLowerThanValue() {

            var customer = CustomerFactory.build(5000.0);

            assertFalse(customer.IsIncomeEqualOrGreaterThan(8000.0));
        }
    }

    @Nested
    class isIncomeBetween {

        @Test
        void shouldBeTrueWhenIncomeIsBetween() {

            var customer = CustomerFactory.build(5000.0);

            assertTrue(customer.IsIncomeBetween(3000.0, 8000.0));
        }

        @Test
        void shouldBeTrueWhenIncomeIsEqualToMin() {

            var customer = CustomerFactory.build(5000.0);

            assertTrue(customer.IsIncomeBetween(5000.0, 8000.0));
        }

        @Test
        void shouldBeTrueWhenIncomeIsEqualToMax() {

            var customer = CustomerFactory.build(8000.0);

            assertTrue(customer.IsIncomeBetween(5000.0, 8000.0));
        }

        @Test
        void shouldBeFalseWhenIncomeIsNotBetween() {

            var customer = CustomerFactory.build(5000.0);

            assertFalse(customer.IsIncomeBetween(3000.0, 4500.0));
        }
    }

    @Nested
    class isAgeLowerThan {

        @Test
        void shouldBeTrueWhenAgeIsLowerThan() {

            var customer = CustomerFactory.build(25);

            assertTrue(customer.IsAgeLowerThan(30));
        }

        @Test
        void shouldBeFalseWhenAgeIsNotLowerThan() {

            var customer = CustomerFactory.build(25);

            assertFalse(customer.IsAgeLowerThan(24));
        }

        @Test
        void shouldBeFalseWhenAgeIsEqualToValue() {

            var customer = CustomerFactory.build(25);

            assertFalse(customer.IsAgeLowerThan(25));
        }
    }

    @Nested
    class isFromLocation {

        @Test
        void shouldBeTrueWhenLocationIsTheSame() {

            var customer = CustomerFactory.build("SP");

            assertTrue(customer.IsFromLocation("SP"));
        }

        @Test
        void shouldBeFalseWhenLocationIsNotTheSame() {

            var customer = CustomerFactory.build("SP");

            assertFalse(customer.IsFromLocation("PR"));
        }
    }
}