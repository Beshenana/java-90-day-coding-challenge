
package edu.haramaya.cosc3053.Day9;

public class PayrollEngine {

    // Parent abstract class
    public static abstract class Employee {

        private final String id;
        private final String name;

        public Employee(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public abstract double calculatePay();
    }

    // TODO 9.1: Full-time employee
    public static class FullTimeEmployee extends Employee {

        private final double monthlySalary;

        public FullTimeEmployee(
                String id,
                String name,
                double monthlySalary) {

            super(id, name);

            if (!Double.isFinite(monthlySalary) || monthlySalary < 0) {
                throw new IllegalArgumentException(
                        "Invalid monthly salary"
                );
            }

            this.monthlySalary = monthlySalary;
        }

        @Override
        public double calculatePay() {
            return monthlySalary;
        }
    }

    // TODO 9.2: Contract employee
    public static class ContractEmployee extends Employee {

        private final double hourlyRate;
        private final double hoursWorked;

        public ContractEmployee(
                String id,
                String name,
                double hourlyRate,
                double hoursWorked) {

            super(id, name);

            if (!Double.isFinite(hourlyRate)
                    || !Double.isFinite(hoursWorked)
                    || hourlyRate < 0
                    || hoursWorked < 0) {

                throw new IllegalArgumentException(
                        "Invalid contract payment information"
                );
            }

            this.hourlyRate = hourlyRate;
            this.hoursWorked = hoursWorked;
        }

        @Override
        public double calculatePay() {
            return hourlyRate * hoursWorked;
        }
    }

    // TODO 9.3: Polymorphic payroll processor
    public static void processPayroll(Employee[] employees) {

        double totalPayroll = 0;

        for (Employee employee : employees) {

            double payment = employee.calculatePay();

            System.out.println(
                    "Employee ID: " + employee.getId()
            );

            System.out.println(
                    "Employee Name: " + employee.getName()
            );

            System.out.println(
                    "Payment: $" + payment
            );

            System.out.println("-------------------------");

            totalPayroll += payment;
        }

        System.out.println(
                "Total Payroll: $" + totalPayroll
        );
    }

    // Main method
    public static void main(String[] args) {

        System.out.println(
                "Day 09 Payroll Hierarchy Challenge"
        );

        Employee[] employees = {
                new FullTimeEmployee(
                        "E001", "Abebe", 30000
                ),

                new ContractEmployee(
                        "E002", "Kebede", 200, 80
                ),

                new FullTimeEmployee(
                        "E003", "Hana", 25000
                )
        };

        processPayroll(employees);
    }
}
