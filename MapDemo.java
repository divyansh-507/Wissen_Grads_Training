import java.util.*;

public class MapDemo{
	public static void main(String []args){
		//Hashtable obj = new HashTable();
		//HashMap obj = new HashMap();
		//TreeMap obj = new TreeMap();
		LinkedHashMap obj = new LinkedHashMap();

		obj.put("111","Rajesh");
		obj.put("222","Rakesh");
		obj.put("333","Ramesh");
		obj.put("444","Suresh");
		obj.put("555","Ganesh");
		
		Set s = obj.entrySet();
		Iterator i = s.iterator();

		while(i.hasNext()){
			Map.Entry me = (Map.Enrty) i.next();
			
			System.out.println("\nEmp Id : "+me.getKey());
			System.out.println("Name : "+me.getValue());
		}
	}
}