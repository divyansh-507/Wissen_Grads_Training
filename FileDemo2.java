import java.io.*;
import java.util.*;

public class FileDemo2 {
    public static void main(String[] args) {
        try {
            File f = new File("abc.txt");
            System.out.println("File length : " + f.length());
            System.out.println("Is it a File : " + f.isFile());
            System.out.println("Is it a directory : " + f.isDirectory());
            System.out.println("Last modified Time : " + f.lastModified());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
