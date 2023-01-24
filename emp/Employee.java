package assignment;

import java.util.*;

abstract class Emp {
    public static int count=0;
    
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

    public Emp(int salary, String designation) {

        System.out.print("Enter name : ");
        this.name = new Scanner(System.in).nextLine();

        this.age = InvalidAgeException.readAge();

        this.salary = salary;
        this.designation = designation;
		
	   count++;

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

final class Clerk extends Emp {

    public Clerk() {
        super(10000, "Clerk");
    }

    public void raiseSalary() {
        setSalary(getSalary() + 2000);
    }

}

final class Programmer extends Emp {
    public Programmer() {
        super(25000, "Programmer");
    }

    public void raiseSalary() {
        setSalary(getSalary() + 5000);
    }
}

final class Manager extends Emp {
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

public class Employee
{
	public void run(){
	   Emp e[] = new Emp[1000];
	   
		//Emp em = new Emp(800000,"CEO");
        
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
                                e[Emp.count] = new Clerk();
                                break;
                            }
                            case 2: {
                                e[Emp.count] = new Programmer();
                                break;

                            }
                            case 3: {
                                e[Emp.count] = new Manager();
                                break;
                            }
                            default:
                                System.out.println("Please Enter number between 1 - 4");

                        }
                    } while (ch2 != 4);
                    break;
                }
                case 2: {
                    for (int i = 0; i < Emp.count; i++) {
                        e[i].display();
                    }
                    break;

                }
                case 3: {
                    for (int i = 0; i < Emp.count; i++) {
                        e[i].raiseSalary();
                    }
                    break;
                }
			case 4 :
				System.out.println("Total Number of Employees created : " + Emp.count);
				break;
                default:
                    System.out.println("Please Enter number between 1 - 4");
            }

        } while (ch1 != 4);
	}
}
