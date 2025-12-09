package desafio.emprestimo.financeiro.controller.dto;

import desafio.emprestimo.financeiro.domain.LoanType;

public record LoanResponse(LoanType type, Double interestRate) {
}
