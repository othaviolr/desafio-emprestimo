package desafio.emprestimo.financeiro.controller;

import desafio.emprestimo.financeiro.controller.dto.CustomerLoanRequest;
import desafio.emprestimo.financeiro.controller.dto.CustomerLoanResponse;
import desafio.emprestimo.financeiro.controller.dto.LoanResponse;
import desafio.emprestimo.financeiro.service.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping(value = "/customer-loans")
    public ResponseEntity<CustomerLoanResponse> customerLoans(@RequestBody CustomerLoanRequest loansRequest) {

        var loanResponse = loanService.checkLoanAvailability(loansRequest);

        return ResponseEntity.ok(loanResponse);
    }
}
