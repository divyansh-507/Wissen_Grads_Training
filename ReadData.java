import java.io.*;

public class ReadData {
    public static void main(String[] args) {
        // InputStreamReader isr = new InputStreamReader(System.in);

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter Name : ");
            String name = br.readLine();
            System.out.print("Enter Age : ");
            int age = Integer.parseInt(br.readLine());

            System.out.println("----------------");
            System.out.println("Name : " + name + "\nAge : " + age);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}