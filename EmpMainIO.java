import java.util.*;
import java.io.*;

abstract class Emp implements java.io.Serializable {
    public static int count = 0;

    protected int age;
    protected String name;
    protected float salary;
    protected String designation;

    public final String toString() {
        return "Name : " + name + "\nSalary : " + salary + "\nAge : " + age + "\nDesignation : " + designation + "\n";
    }

    Emp() {
    }

    public static void writeToFile(ArrayList<Emp> e) {
        try {
            File dir = new File("EmployeeData");
            dir.mkdir();

            File f = new File(dir, "Employees.ser");
            f.createNewFile();

            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream("EmployeeData\\Employees.ser"));
            oos.writeObject(e);
            oos.close();

            System.out.println("Serialized Successfully");

            // PrintWriter pw = new PrintWriter(new FileOutputStream(f, true));
            // pw.print(name + "|" + age + "|" + salary + "|" + designation + "\n");
            // pw.flush();
            // pw.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static ArrayList<Emp> readFromDFile() {
        try {
            File f = new File("EmployeeData\\Employees.ser");
            if (f.exists()) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
                ArrayList<Emp> list = (ArrayList<Emp>) ois.readObject();

                ois.close();
                return list;
            } else {
                System.out.println("No emoloyeees record found");
            }
        } catch (Exception e) {
            System.out.println("Oops !! " + e);
        }
        return new ArrayList<Emp>();
        // File f = new File("emp\\Employees.txt");
        // if (f.exists()) {
        // BufferedReader fr = new BufferedReader(new FileReader(f));
        // String line = null;
        // while ((line = fr.readLine()) != null) {
        // StringTokenizer st = new StringTokenizer(line, "|");
        // System.out.println("\nName: " + st.nextToken());
        // System.out.println("Age: " + st.nextToken());
        // System.out.println("Salary: " + st.nextToken());
        // System.out.println("Designation: " + st.nextToken());
        // System.out.println("------------------------------");
        // }
        // fr.close();
        // } else
        // System.out.println("\tNO SUCH FILE FOUND");
        // } catch (Exception ex) {
        // System.out.println("\tFILE ERROR : " + ex);
        // }
    }

    // public static void display() {

    // }

    public Emp(int salary, String designation) {

        System.out.print("Enter name : ");
        this.name = new Scanner(System.in).nextLine();

        this.age = InvalidAgeException.readAge();

        this.salary = salary;
        this.designation = designation;

        count++;
        // writeToFile();

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
                System.out.print("Enter age:");
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

// Name - Sorter...
class NameSorter implements Comparator<Emp> {
    public int compare(Emp e1, Emp e2) {
        String n1 = e1.getName();
        String n2 = e2.getName();

        return n1.compareTo(n2);
    }
}

// Age - Sorter...
class AgeSorter implements Comparator<Emp> {
    public int compare(Emp e1, Emp e2) {
        Integer n1 = e1.getAge();
        Integer n2 = e2.getAge();

        return n1.compareTo(n2);
    }
}

// Designation - Sorter...
class DesignationSorter implements Comparator<Emp> {
    public int compare(Emp e1, Emp e2) {
        String n1 = e1.getDesignation();
        String n2 = e2.getDesignation();

        return n1.compareTo(n2);
    }
}

public class EmpMainIO {

    public static void mainMenu() {
        System.out.println("-------------------");
        System.out.println("1. Create");
        System.out.println("2. Display");
        System.out.println("3. RaiseSalary");
        System.out.println("4. Exit");
        System.out.println("-------------------");
    }

    public static void subMenu() {
        System.out.println("-------------------");
        System.out.println("1. Clerk");
        System.out.println("2. Programmer");
        System.out.println("3. Manager");
        System.out.println("4. Exit");
        System.out.println("-------------------");
    }

    public static void main(String[] args) {
        ArrayList<Emp> e = Emp.readFromDFile();
        // Vector<Emp> e = new Vector<Emp>(1000);
        // Emp em = new Emp(800000,"CEO");

        int ch1 = 0, ch2 = 0;

        do {
            mainMenu();
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
                        subMenu();
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
                            case 4: {
                                // Emp.writeToFile(e);
                                break;
                            }
                            default:
                                System.out.println("Please Enter number between 1 - 4");

                        }
                    } while (ch2 != 4);
                    break;
                }
                case 2: {
                    System.out.println("==================");
                    // e = Emp.readFromDFile();
                    Iterator it = e.iterator();
                    while (it.hasNext()) {
                        System.out.println(it.next());
                    }
                    break;
                }
                // for(int i = 0;i < Emp.count;i++){
                // System.out.println("-----------------");
                // System.out.println(e[i]);
                // System.out.println("-----------------");
                // }

                // for (int i = 0; i < Emp.count; i++) {
                // e[i].display();
                // }

                case 3: {
                    Iterator<Emp> i = e.iterator();
                    while (i.hasNext()) {
                        i.next().raiseSalary();
                    }
                    break;
                }
                case 4:
                    Emp.writeToFile(e);
                    System.out.println("Total Number of Employees created : " + Emp.count);
                    break;
                default:
                    System.out.println("Please Enter number between 1 - 4");
            }

        } while (ch1 != 4);
    }

}