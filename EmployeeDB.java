import java.util.*;
import java.io.*;
import java.sql.*;

abstract class Emp implements java.io.Serializable {
    public static int count = 0;

    protected int empID;
    protected int age;
    protected String name;
    protected float salary;
    protected String designation;

    public static Connection con;
    public static Statement stmt;

    // for establishing connextion only once
    static {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
        stmt = con.createStatement();
    }

    Emp() {
    }

    public Emp(int salary, String designation) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter id : ");
            empID = Math.abs(Integer.parseInt(br.readLine()));
            System.out.print("Enter name : ");
            String name = br.readLine();
            this.age = InvalidAgeException.readAge();

            PreparedStatement pstmt = con.prepareStatement("insert into emp values(?, ?, ?, ?, ?)");

            pstmt.setInt(1, empID);
            pstmt.setString(2, name);
            pstmt.setInt(3, age);
            pstmt.setInt(4, salary);
            pstmt.setString(5, designation);
            pstmt.execute();

            count++;
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void display() {
        try {
            ResultSet rs = stmt.executeQuery("select * from EMPLOYEE");
            if (!rs.next()) {
                System.out.println("No records to display ...");
                return;
            }

            while (rs.next()) {
                System.out.println("\nID : " + rs.getString(1));
                System.out.println("Name : " + rs.getString(2));
                System.out.println("Age : " + rs.getString(3));
                System.out.println("Salary : " + rs.getString(4));
                System.out.println("Designation : " + rs.getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateSalary() {
        try {
            stmt.executeUpdate("update EMPLOYEE set SALARY = SALAR+2000 where DESIGNATION = 'Clerk'");
            stmt.executeUpdate("update EMPLOYEE set SALARY = SALAR+5000 where DESIGNATION = 'Programmer'");
            stmt.executeUpdate("update EMPLOYEE set SALARY = SALAR+10000 where DESIGNATION = 'Manager'");

            // stmt.execute();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void remove() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter Id of Employee you want to delete : ");
            int id = Integer.parseInt(br.readLine());

            ResultSet rs = stmt.executeQuery("select * from EMPLOYEE where id = " + id);
            if (!rs.next()) {
                System.out.println("Oops !! Employee with this ID does not exist");
            } else {
                System.out.println("\nID : " + rs.getString(1));
                System.out.println("Name : " + rs.getString(2));
                System.out.println("Age : " + rs.getString(3));
                System.out.println("Salary : " + rs.getString(4));
                System.out.println("Designation : " + rs.getString(5));

                System.out.println("Do you really want to delele this record (Y/N) : ");

                String str = br.readLine();
                if (str == "Y" || str == "y") {
                    stmt.executeQuery("delete from EMPLOYEE where id = " + id);
                } else {
                    System.out.println("You chose not to delete the record, Thanks ... ");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

final class Clerk extends Emp {

    public Clerk() {
        super(10000, "Clerk");
    }
}

final class Programmer extends Emp {
    public Programmer() {
        super(25000, "Programmer");
    }
}

final class Manager extends Emp {
    public Manager() {
        super(80000, "Manager");
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

public class EmployeeDB {

    public static void mainMenu() {
        System.out.println("-------------------");
        System.out.println("1. Create");
        System.out.println("2. Display");
        System.out.println("3. RaiseSalary");
        System.out.println("4. Delete Record");
        System.out.println("5. Exit");
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

            // establish connection

            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
            } catch (Exception e) {
                e.printStackTrace();
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
                            case 1:
                                new Clerk();
                                break;

                            case 2:
                                new Programmer();
                                break;

                            case 3:
                                new Manager();
                                break;

                            case 4:
                                break;

                            default:
                                System.out.println("Please Enter number between 1 - 4");

                        }
                    } while (ch2 != 4);
                    break;
                }
                case 2: {
                    Emp.display();
                    break;
                }

                case 3: {
                    Emp.updateSalary();
                    break;
                }
                case 4: {
                    Emp.remove();
                    break;
                }
                case 5:
                    System.out.println("Total Number of Employees created : " + Emp.count);
                    break;
                default:
                    System.out.println("Please Enter number between 1 - 4");
            }

        } while (ch1 != 5);
    }

}