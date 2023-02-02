import java.sql.*;

public class JDBCDemo3{
	public static void main(String[] args){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
            	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");	
			
			// create a procedure in sql commandline
			CallableStatement cstmt = con.prepareCall("CALL my_proc()");
			// calls the procedure everytime the code runs(stored procedure)

			cstmt.execute();
			System.out.println("Called stored procedure successfully");
			
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}