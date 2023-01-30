import java.uti.*;
import java.util.ArrayList;
import java.util.Iterator;

class Emp {
    String name;
    int age;

    Emp(String n, int a) {
        name = n;
        age = a;
    }

    public String toString() {
        System.out.println("Name : " + name);
        System.out.println("Age : " + age);

    }
}

public class CollectionDemo3 {
    public static void main(String[] args) {
        ArrayList<Emp> obj = new ArrayList<Emp>();

        obj.add(new Emp("Rajesh", 32));
        obj.add(new Emp("Brijesh", 22));
        obj.add(new Emp("Ganesh", 31));
        obj.add(new Emp("Rakesh", 48));
        obj.add(new Emp("Suresh", 21));

        Iterator i = obj.iterator();
        while(i.hasNext(){
            System.out.println(i.next());
        }
    }
}