import java.util.*;

public class CollectionDemo2 {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<Object>(); // genrics
        // ArrayList<Object> arr = new ArrayList<Object>();
        list.add("Hello");
        list.add(234232);
        list.add(new Date());
        list.add(new Thread());
        list.add(3242.89);

        System.out.println(list);

        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(111, "Rakesh");
        map.put(222, "Mahesh");
        map.put(333, "Dinesh");

        System.out.println(map);

        AddingElements<Integer> obj1 = new AddingElements<Integer>();
        obj1.add(120, 180);

        AddingElements<String> obj2 = new AddingElements<String>();
        obj2.add("120", "180");

        AddingElements<Double> obj3 = new AddingElements<Double>();
        obj3.add(120.0012, 180.0018);
    }

}

class AddingElements<T> {
    public void add(T a, T b) {
        System.out.println("Addition of some type");
        // System.out.println(a + b);
    }
}
