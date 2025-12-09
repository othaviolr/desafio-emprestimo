package desafio.emprestimo.financeiro.domain;

public class Loan {

    private Customer customer;

    public Loan(Customer customer) {
        this.customer = customer;
    }

    public boolean isPersonalLoanAvailable() {
        return BasicLoanAvailable();
    }

    public boolean isConsigmentLoanAvailable() {
        return customer.IsIncomeEqualOrGreaterThan(5000.0);
    }

    public boolean isGuaranteedLoanAvailable() {
        return BasicLoanAvailable();
    }

    public double getPersonalLoanInterestRate(){
        if (isPersonalLoanAvailable()) {
            return 4.0;
        }
        throw new LoanNotAvailableException();
    }

    public double getGuaranteedLoanInterestRate(){
        if (isGuaranteedLoanAvailable()) {
            return 3.0;
        }
        throw new LoanNotAvailableException();
    }

    public double getConsigmentLoanInterestRate(){
        if (isConsigmentLoanAvailable()) {
            return 2.0;
        }
        throw new LoanNotAvailableException();
    }

    private boolean BasicLoanAvailable() {
        if (customer.IsIncomeEqualOrLowerThan(3000.0)) {
            return true;
        }

        return customer.IsIncomeBetween(3000.00, 5000.00)
                && customer.IsAgeLowerThan(30)
                && customer.IsFromLocation("SP");
    }
}
