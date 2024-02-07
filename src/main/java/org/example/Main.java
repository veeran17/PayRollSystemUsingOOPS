package org.example;

import java.util.ArrayList;

abstract class Employee {

    private String name;
    private int id;


    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract double calculateSalary();


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id + "Salary = " + calculateSalary() +
                '}';
    }
}
class Fulltimeemployee extends Employee{

        private double monthlySalary;

        public Fulltimeemployee(String name, int id, double monthlySalary){
            super(name,id);
            this.monthlySalary=monthlySalary;
        }


    @Override
    public double calculateSalary() {
        return monthlySalary;

    }
}




class Parttimeemployee extends  Employee{

    private  int workedHours;
    private double hourlyRate;

    public Parttimeemployee(String name,int id,int workedHours,double hourlyRate){
        super(name,id);
        this.workedHours=workedHours;
        this.hourlyRate=hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return workedHours*hourlyRate;
    }
}

class PayrollSystem{

    private ArrayList<Employee> employeeList;

    public PayrollSystem(){

        employeeList=new ArrayList<>();
    }

    public void addEmployee(Employee employee){

        employeeList.add(employee);
    }

    public void removeEmployee(int id){

        Employee employeeToRemove = null;
        for(Employee employee : employeeList){
            if(employee.getId() == id){
                employeeToRemove = employee;
                break;
            }
        }
        if(employeeToRemove != null){
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployee(){
        for (Employee employee :employeeList){
            System.out.println(employee);
        }
    }
}
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PayrollSystem prs = new PayrollSystem();
        Fulltimeemployee emp1 = new Fulltimeemployee("Ramkumar", 1,75000.0);
        Parttimeemployee emp2 = new Parttimeemployee("Saketh", 2, 350, 1500.0);

        prs.addEmployee(emp1);
        prs.addEmployee(emp2);

        System.out.println("Initial Employee details");
        prs.displayEmployee();

        System.out.println("Removing Employees");
        prs.removeEmployee(2);

        System.out.println("Remaining Employee details");
        prs.displayEmployee();
    }
}