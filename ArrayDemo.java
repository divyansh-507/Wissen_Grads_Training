public class ArrayDemo{
    public static void main(String []args){
        int a[];
        // int b[5];
        // int c[] = new int[];
        int d[] = new int[5];

        int g[];
        int[] h,k,m;

        int arr[] = {11,22,33,44,55};

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
        System.out.prinln("---------------------");
        for(int x : arr){
            System.out.println(arr[i]);
        }
        System.out.prinln("---------------------");

        for(int i=0;i<args.length;i++){
            System.out.println(args[i]);
        }
        System.out.prinln("---------------------");

        for(String s : args){
            System.out.prinln(s);
        }
        System.out.prinln("---------------------");

        int md[][] = new int [6][];

        md[0] = new int[5];
        md[1] = new int[7];
        md[2] = new int[50];
        md[3] = new int[2];
        md[4] = new int[10];

        for(int i=0;i<md.length;i++){
            for(int j=0;j<md[i].length;j++){
                System.out.println(md[i][j]);
            }
            System.out.prinln();
        }
        System.out.prinln("---------------------");

        Student s[] = new Student[5];
        String name[] = {"Geeta" , "Rita" , "Sita" , "Neeta" , "Meeta"};

        for(int i=0;i<s.length;i++){
            s[i] = new Student();
            s[i].name = names[i];
        }

        for(Student st:s){
            System.out.println("Name : "+st.name);
        }
    }
}
class Student{
    String name;
}