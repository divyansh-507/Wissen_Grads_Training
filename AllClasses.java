package assignment;

import java.io.*;
import java.util.*;

abstract class Employee {
	private String name;
	private int age, salary;
	private String designation;

	Employee(int salary, String d) {
		Scanner sc = new Scanner(System.in);

		System.out.print("\nEnter name : ");
		name = sc.nextLine();

		age = InvalidAgeException.readAge();

		this.salary = salary;
		this.designation = d;
	}

	public void display() {
		System.out.println("------------------------------------");
		System.out.println("Deatils of the Employee are :- ");
		System.out.println("Name   : " + name);
		System.out.println("Age    : " + age);
		System.out.println("Salary : " + salary);
		System.out.println("Designation : " + designation + "\n");
	}

	public void raiseSalary() {
		salary += 2000;
	}

	public void setSalary(int num) {
		this.salary = num;
	}

	public int getSalary() {
		return salary;
	}
};

class Clerk extends Employee {
	Clerk() {
		super(10000, "CLERK");
	}

	public void raiseSalary() {
		super.raiseSalary();
	}
}

class Programmer extends Employee {
	Programmer() {
		super(25000, "PROGRAMMER");
	}

	public void raiseSalary() {
		super.setSalary(super.getSalary() + 5000);
	}
}

class Manager extends Employee {
	Manager() {
		super(80000, "Manager");
	}

	public void raiseSalary() {
		super.setSalary(super.getSalary() + 10000);
	}
}

class AllClasses {
}

class InvalidAgeException extends RuntimeException {
	public InvalidAgeException() {
	}

	public InvalidAgeException(String msg) {
		super(msg);
	}

	public static int readAge() {
		while (true) {
			try {
				System.out.print("Enter age : ");
				int age = new Scanner(System.in).nextInt();
				if (age < 21 || age > 60)
					throw new InvalidAgeException();
				else
					return age;
			} catch (InputMismatchException ex) {
				System.out.println("Please enter number only ...");
			} catch (InvalidAgeException ex) {
				System.out.println("Please enter between 21 - 60");
			}
		}
	}

}

// class InvalidChoiceException extends RuntimeException{
// public InvalidChoiceException(){}
// public InvalidChoiceException(String msg){
// super(msg);
// }
// public static int readChoice(){
// while(true){
// try{
// System.out.print("Enter choice : ");
// int ch = new Scanner(System.in).nextInt();
// if(ch < 1 || ch > 4)
// throw new InvalidChoiceException();
// else return ch ;
// }
// catch(InputMismatchException ex){
// System.out.println("Please enter numbers only ...");
// }
// catch(InvalidChoiceException ex){
// System.out.println("Please enter between 1 - 4");
// }
// }
// }

// }
