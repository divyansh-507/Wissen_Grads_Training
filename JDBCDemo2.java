import java.sql.*;
import java.io.*;


public class JDBCDemo{
	
	public static void main(String []args){
		try{
			BufferedReader br = new BUfferedReader(new InputStreamReader(System.in));


			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","tiger");
			
			PreparedStatement pstmt = con.prepareStatement("insert into emp values(?, ?)");

			System.out.print("Enter name : ");
			String name = br.readLine();
			
			System.out.print("Enter age : ");
			int age = Integer.parseInt(br.readLine());

			pstmt.setString(1,name);
			pstmt.setInt(2,age);
			pstmt.execute();

			pstmt.close();
			con.close();	
		}
		catch(Exception e){
			System.out.println(e);	
		}
	}

}
