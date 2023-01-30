package Employee.assignment;

import java.util.*;

abstract class Emp {
    public static int count = 0;

    protected int age;
    protected String name;
    protected float salary;
    protected String designation;

    public final String toString() {
        return "Name : " + name + "\nSalary : " + salary + "\nAge : " + age + "\nDesignation : " + designation + "\n";
    }

    // public final void display() {
    // System.out.println("-------------------------");
    // System.out.println("Name:" + name);
    // System.out.println("Salary:" + salary);
    // System.out.println("Age:" + age);
    // System.out.println("Designation:" + designation);
    // System.out.println("-------------------------");
    // }
    Emp() {
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

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getDesignation() {
        return this.designation;
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

class SortByName extends Emp implements Comparator<Emp> {

    // Sorting in ascending order of name
    public int compare(Emp a, Emp b) {

        return a.name.compareTo(b.name);
    }
}

class SortByDesignation implements Comparator<Emp> {

    // Sorting in ascending order of Designation
    public int compare(Emp a, Emp b) {
        return a.designation.compareTo(b.designation);
    }
}

public class EmpMain {
    public static void main(String[] args) {
        ArrayList<Emp> e = new ArrayList<Emp>(1000);
        // Vector<Emp> e = new Vector<Emp>(1000);
        // Emp em = new Emp(800000,"CEO");

        int ch1 = 0, ch2 = 0, ch3 = 0;

        do {
            System.out.println("-------------------");
            System.out.println("1. Create");
            System.out.println("2. Display");
            System.out.println("3. RaiseSalary");
            System.out.println("4. Exit");
            System.out.print("Enter the choice : ");
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
                                e.add(new Clerk());
                                break;
                            }
                            case 2: {
                                e.add(new Programmer());
                                break;

                            }
                            case 3: {
                                e.add(new Manager());
                                break;
                            }
                            default:
                                System.out.println("Please Enter number between 1 - 4");

                        }
                    } while (ch2 != 4);
                    break;
                }
                case 2: {

                    do {
                        System.out.println("\n-------------------");
                        System.out.println("1. Name");
                        System.out.println("2. Designation");
                        System.out.println("3. Age");
                        System.out.println("4. Exit");
                        System.out.print("Enter a choice to display the Details Accordingly : ");

                        try {
                            ch3 = new Scanner(System.in).nextInt();
                        } catch (InputMismatchException q) {
                            System.out.println("Please Enter Numbers only ... ");
                            ch3 = 0;
                        }

                        switch (ch3) {
                            case 1:
                                Collections.sort(e, new SortByName());
                                System.out.println("\nSorted by name : ");
                                System.out.println("==================");
                                break;
                            case 2:
                                Collections.sort(e, new SortByDesignation());
                                System.out.println("\nSorted by Designation : ");
                                System.out.println("==================");
                                break;
                            case 3:
                                Collections.sort(e, new SortByAge());
                                System.out.println("\nSorted by Age : ");
                                System.out.println("==================");
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("Enter number between 1 - 4");
                                break;
                        }

                        Iterator it = e.iterator();

                        while (it.hasNext())
                            System.out.println(it.next());
                        break;
                    } while (ch3 != 4);

                    // System.out.println("==================");

                    // Enumeration<Emp> en = e.elements();

                    // while (en.hasMoreElements()) {
                    // System.out.println("-----------------");
                    // System.out.println(en.nextElement());
                    // System.out.println("-----------------");
                    // }

                    // for(int i = 0;i < Emp.count;i++){
                    // System.out.println("-----------------");
                    // System.out.println(e[i]);
                    // System.out.println("-----------------");
                    // }

                    // for (int i = 0; i < Emp.count; i++) {
                    // e[i].display();
                    // }
                    break;

                }
                case 3: {
                    Iterator<Emp> i = e.iterator();
                    while (i.hasNext()) {
                        i.next().raiseSalary();
                    }
                    break;
                }
                case 4:
                    System.out.println("Total Number of Employees created : " + Emp.count);
                    break;
                default:
                    System.out.println("Please Enter number between 1 - 4");
            }

        } while (ch1 != 4);
    }

}