package desafio.emprestimo.financeiro.domain;

public class Customer {

    private Integer age;
    private String cpf;
    private String name;
    private Double income;
    private String location;

    public Customer(Integer age, String cpf, String name, Double income, String location) {

        this.age = age;
        this.cpf = cpf;
        this.name = name;
        this.income = income;
        this.location = location;
    }

    public boolean IsIncomeEqualOrLowerThan(double value) {
        return income <= value;
    }

    public boolean IsIncomeEqualOrGreaterThan(double value) {
        return income >= value;
    }

    public boolean IsIncomeBetween(double minValue, double maxValue) {
        return income >= minValue && income <= maxValue;
    }

    public boolean IsAgeLowerThan(int value) {
        return age < value;
    }

    public boolean IsFromLocation(String location) {
        return this.location.equalsIgnoreCase(location);
    }
}
