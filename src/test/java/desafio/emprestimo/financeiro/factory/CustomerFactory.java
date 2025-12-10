package desafio.emprestimo.financeiro.factory;

import desafio.emprestimo.financeiro.domain.Customer;

public class CustomerFactory {

    public static Customer build() {

        return new Customer(25, "123.456.789-00", "Noah Sebastian", 5000.00, "SP");
    }

    public static Customer build(int age) {

        return new Customer(age, "123.456.789-00", "Noah Sebastian", 5000.00, "SP");
    }

    public static Customer build(Double income) {

        return new Customer(25, "123.456.789-00", "Noah Sebastian", income, "SP");
    }

    public static Customer build(String location) {

        return new Customer(25, "123.456.789-00", "Noah Sebastian", 5000.00, location);
    }
}
