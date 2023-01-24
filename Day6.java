import assignment.*;

import java.util.*;

public class Day6 {

    public static void main(String[] args) {

        int ch1 = 0, ch2 = 0;
        Employee e[] = new Employee[100];
        int empcount = 0;
        Employee emp = new Employee();
        do {
            System.out.println("---------------------");
            System.out.println("1. Create \n2. Display\n3. Raise Salary\n4. Exit");
            System.out.println("---------------------");
            System.out.print("Enter a choice : ");

            ch1 = new Scanner(System.in).nextInt();
            switch (ch1) {
                case 1:
                    do {
                        System.out.println("---------------------");
                        System.out.println("1. Clerk \n2. Programmer\n3. Manager\n4. Exit");
                        System.out.println("---------------------");
                        System.out.print("Enter a choice : ");

                        ch2 = new Scanner(System.in).nextInt();

                        if (ch2 == 1) {
                            e[empcount] = new Clerk();
                            empcount++;
                        } else if (ch2 == 2) {
                            e[empcount] = new Programmer();
                            empcount++;
                        } else if (ch2 == 3) {
                            e[empcount] = new Manager();
                            empcount++;
                        }

                    } while (ch2 != 4);
                    break;
                case 2:
                    System.out.println("---------- Employee Details -----------");
                    for (int i = 0; i < empcount; i++)
                        e[i].display();
                    break;
                case 3:
                    for (int i = 0; i < empcount; i++)
                        e[i].raiseSalary();
                    break;
            }
        } while (ch1 != 4);
    }
};
