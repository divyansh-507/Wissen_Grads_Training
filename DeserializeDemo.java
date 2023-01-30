import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class DeserializeDemo {
    public static void main(String[] args) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.ser"));
            Person p = (Person) ois.readObject(p1);

            System.out.println("Name : " + p.name);
            System.out.println("Age : " + p.age);
            // ois.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}