import java.util.Scanner;

import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;

class Employee{
	private String name;
	private int age,salary;
	private String designation;

	Employee(){}
	Employee(int salary,String d){
		Scanner sc = new Scanner(System.in);
				
		System.out.print("\nEnter name : ");
		name = sc.nextLine();

		System.out.print("\nEnter age : ");
		age = sc.nextInt();
		
		this.salary = salary;
		this.designation = d;
	}
	public void display(){
		System.out.println("------------------------------------");
		System.out.println("Deatils of the Employee are :- ");
		System.out.println("Name   : "+name);
		System.out.println("Age    : "+age);
		System.out.println("Salary : "+salary);
		System.out.println("Designation : "+designation+"\n");
	}
	public void raiseSalary(){
		raiseSalary(0);
	}
    public void raiseSalary(int num){
		salary  += num;
	}
    public int getSalary(){
        return salary;
    }
};

class Clerk extends Employee{
	Clerk(){
		super(10000,"CLERK");
	}
	public void raiseSalary(){
		super.raiseSalary(2000);
	}
}
class Programmer extends Employee{
	Programmer(){
		super(25000,"PROGRAMMER");
	}
	public void raiseSalary(){
		super.raiseSalary(5000);
	}
}
class Manager extends Employee{
	Manager(){
		super(80000,"Manager");
	}
	public void raiseSalary(){
		super.raiseSalary(10000);
	}
}
public class Day4{

	public static void main(String []args){

        int ch1=0,ch2=0;
        Employee e[] = new Employee[100];
        int empcount=0;

        do{
            System.out.println("---------------------");
            System.out.println("1. Create \n2. Display\n3. Raise Salary\n4. Exit");
            System.out.println("---------------------");
            System.out.print("Enter a choice : ");

            ch1 = new Scanner(System.in).nextInt();
            switch(ch1){
                case 1:
                    do{
                        System.out.println("---------------------");
                        System.out.println("1. Clerk \n2. Programmer\n3. Manager\n4. Exit");
                        System.out.println("---------------------");
                        System.out.print("Enter a choice : ");
            
                        ch2 = new Scanner(System.in).nextInt();
                        switch(ch2){
                            case 1:
                                e[empcount++] = new Clerk();
                                break;
                            case 2:
                                e[empcount++] = new Programmer();
                                break;
                            case 3:
                                e[empcount++] = new Manager();
                                break;  
                        }
                    }while(ch2 != 4);
                    break;
                case 2:
                    System.out.println("---------- Employee Details -----------");
                    for(int i=0;i<empcount;i++)
                        e[i].display();
                    break;
                case 3:
                    for(int i=0;i<empcount;i++)
                        e[i].raiseSalary();
                    break;  
            }
        }while(ch1 != 4);
	}
};