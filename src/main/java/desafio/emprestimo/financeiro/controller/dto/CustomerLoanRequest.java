package desafio.emprestimo.financeiro.controller.dto;

import desafio.emprestimo.financeiro.domain.Customer;

public record CustomerLoanRequest(Integer age,
                                  String cpf,
                                  String name,
                                  Double income,
                                  String location) {

    public Customer toCustomer() {
        return new Customer(
             age,
             cpf,
             name,
             income,
             location
        );
    }

}
