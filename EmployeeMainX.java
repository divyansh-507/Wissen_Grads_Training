// package assignment;

import java.util.*;

abstract class Employee {
    static int count;
    private int age;
    private String name;
    private float salary;
    private String designation;

    public final void display() {
        System.out.println("-------------------------");
        System.out.println("Name:" + name);
        System.out.println("Salary:" + salary);
        System.out.println("Age:" + age);
        System.out.println("Designation:" + designation);
        System.out.println("-------------------------");
    }

    public Employee(int salary, String designation) {

        System.out.print("Enter name : ");
        this.name = new Scanner(System.in).nextLine();

        this.age = InvalidAgeException.readAge();

        this.salary = salary;
        this.designation = designation;

    }

    public void raiseSalary() {

    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float getSalary() {
        return salary;
    }

}

final class Clerk extends Employee {

    public Clerk() {
        super(10000, "Clerk");
    }

    public void raiseSalary() {
        setSalary(getSalary() + 2000);
    }

}

final class Programmer extends Employee {
    public Programmer() {
        super(25000, "Programmer");
    }

    public void raiseSalary() {
        setSalary(getSalary() + 5000);
    }
}

final class Manager extends Employee {
    public Manager() {
        super(80000, "Manager");
    }

    public void raiseSalary() {
        setSalary(getSalary() + 10000);
    }
}

class InvalidAgeException extends Exception {

    InvalidAgeException() {
        super();
    }

    InvalidAgeException(String msg) {
        super(msg);
    }

    public static int readAge() {

        while (true) {
            try {
                System.out.println("Enter age:");
                int age = new Scanner(System.in).nextInt();

                if (age < 20 || age > 60) {
                    throw new InvalidAgeException();
                } else {
                    return age;
                }
            } catch (InputMismatchException i) {
                System.out.println("please enter numbers only.........");
            } catch (InvalidAgeException q) {
                System.out.println("please enter age between 20 to 60.");
            }

        }

    }

}

public class EmployeeMainX {

    public static void main(String[] args) {
        // Employee emp = new Employee(800000,"CEO");

        Employee e[] = new Employee[1000];
        int empcount = 0;
        int ch1 = 0, ch2 = 0;

        do {
            System.out.println("-------------------");
            System.out.println("1. Create");
            System.out.println("2. Display");
            System.out.println("3. RaiseSalary");
            System.out.println("4.Exit");
            System.out.print("Enter the choice :");
            try {
                ch1 = new Scanner(System.in).nextInt();
            } catch (InputMismatchException q) {
                System.out.println("Please Enter Numbers only ... ");
                ch1 = 0;
            }

            switch (ch1) {
                case 1: {

                    do {
                        System.out.println("-------------------");
                        System.out.println("1. Clerk");
                        System.out.println("2. Programmer");
                        System.out.println("3. Manager");
                        System.out.println("4.Exit");
                        System.out.print("Enter the choice :");
                        try {
                            ch2 = new Scanner(System.in).nextInt();
                        } catch (InputMismatchException q) {
                            System.out.println("Please Enter Numbers only ... ");
                            ch2 = 0;
                        }
                        switch (ch2) {
                            case 1: {
                                e[empcount] = new Clerk();
                                empcount++;
                                Employee.count++;

                                break;
                            }
                            case 2: {
                                e[empcount] = new Programmer();
                                empcount++;
                                Employee.count++;

                                break;

                            }
                            case 3: {
                                e[empcount] = new Manager();
                                empcount++;
                                Employee.count++;
                                break;
                            }
                            default:
                                System.out.println("Please Enter number between 1 - 4");

                        }
                    } while (ch2 != 4);
                    break;
                }
                case 2: {
                    for (int i = 0; i < empcount; i++) {
                        e[i].display();
                    }
                    break;

                }
                case 3: {
                    for (int i = 0; i < empcount; i++) {
                        e[i].raiseSalary();
                    }
                    break;
                }
                default:
                    System.out.println("Please Enter number between 1 - 4");
            }

        } while (ch1 != 4);

        System.out.println("Number of Employee:" + Employee.count);
    }
}
