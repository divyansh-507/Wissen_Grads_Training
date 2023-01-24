import java.util.*;

public class CollectionDemo{
	public static void main(String []args){
	
		//HashSet obj = new HashSet();
		//TreeSet obj = new TreeSet();
		//LinkedHashSet obj = new LinkdedHashSet();

		//Vector obj = new Vector();
		//ArrayList obj = new ArrayList();
		//LinkedList obj = new LinkedList();
		PriorityQueue obj = new PriorityQueue();


		obj.add("555");
		obj.add("111");
		obj.add("333");
		obj.add("222");
		obj.add("444");	


		Iteratot i1 = obj.iterator();
		while(i1.hasNext(){
			System.out.println(i1.next());
		}
	
	}
}