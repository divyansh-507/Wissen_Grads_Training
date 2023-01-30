import java.io.*;

public class IODemo {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter File name : ");
            String filename = br.readLine();

            File f = new File(filename);

            if (f.exists()) {
                BufferedReader fr = new BufferedReader(new FileReader(filename));

                String line = null;
                while ((line = fr.readLine()) != null) {
                    System.out.println(line);
                }
                fr.close();
            } else {
                System.out.println("Sorry ! File doesn't exits ... ");
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}