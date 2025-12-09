package desafio.emprestimo.financeiro.service;

import desafio.emprestimo.financeiro.controller.dto.CustomerLoanRequest;
import desafio.emprestimo.financeiro.controller.dto.CustomerLoanResponse;
import desafio.emprestimo.financeiro.controller.dto.LoanResponse;
import desafio.emprestimo.financeiro.domain.Loan;
import desafio.emprestimo.financeiro.domain.LoanType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {

    public CustomerLoanResponse checkLoanAvailability(CustomerLoanRequest loanRequest) {

        var customer = loanRequest.toCustomer();
        var loan = new Loan(customer);

        List<LoanResponse> loans = new ArrayList<>();

        if (loan.isPersonalLoanAvailable()) {
             loans.add(new LoanResponse(LoanType.PERSONAL, loan.getPersonalLoanInterestRate()));
        }

        if (loan.isConsigmentLoanAvailable()) {
            loans.add(new LoanResponse(LoanType.CONSIGNMENT, loan.getConsigmentLoanInterestRate()));
        }

        if (loan.isGuaranteedLoanAvailable()) {
            loans.add(new LoanResponse(LoanType.GUARANTEED, loan.getGuaranteedLoanInterestRate()));
        }

        return  new CustomerLoanResponse(loanRequest.name(), loans);
    }
}
