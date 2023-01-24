import java.io.IOException;
import java.util.*;

class Employee{
	private String name;
	private int age,salary;
	private String designation;

	Employee(){}
	Employee(int salary,String d)
    {
		Scanner sc = new Scanner(System.in);
				
		System.out.print("\nEnter name : ");
		name = sc.nextLine();

		age = InvalidAgeException.readAge();
		
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
		salary+=2000;
	}
    public void setSalary(int num){
		if(salary <= 0)
            this.salary  = num;
	}
    public int getSalary(){
        return salary;
    }
};

class Clerk extends Employee{
	Clerk() 
    {
		super(10000,"CLERK");
	}
	public void raiseSalary(){
		super.raiseSalary();
	}
}
class Programmer extends Employee{
	Programmer() 
    {
		super(25000,"PROGRAMMER");
	}
	public void raiseSalary(){
		super.setSalary(super.getSalary()+5000);
	}
}
class Manager extends Employee{
	Manager()
    {
		super(80000,"Manager");
	}
	public void raiseSalary(){
		super.setSalary(super.getSalary()+10000);
	}
}
public class Day5{

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
                       
                        
                        if(ch2 ==1){
                            e[empcount] = new Clerk();
                            empcount++;
                        }
                        else if(ch2 == 2){
                                e[empcount] = new Programmer();
                                empcount++;
                        }
                        else if(ch2 == 3){
                            e[empcount] = new Manager();
                            empcount++;
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

class InvalidAgeException extends RuntimeException{
    public InvalidAgeException(){}
    public InvalidAgeException(String msg){
        super(msg);
    }
    public static int readAge(){
        while(true){
            try{
                System.out.print("Enter age : ");
                int age = new Scanner(System.in).nextInt();
                if(age < 21 || age > 60)
                    throw new InvalidAgeException();
                else return age ;
            }
            catch(InputMismatchException ex){
                System.out.println("Please enter number only ...");
            }
            catch(InvalidAgeException ex){
                System.out.println("Invalid Age Exception handler .. ");
                System.out.println("Please enter between 21 - 60");
            }
        }
    }

}


