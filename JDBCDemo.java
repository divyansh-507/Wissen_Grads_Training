import java.sql.*;

public class JDBCDemo{
	
	public static void main(String []args){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","tiger");
			Statement stmt = con.createStatement();
			
			//stmt.executeUpdate("insert into emp vlaues ('Amit', 33)");
			//stmt.executeUpdate("delete from emp where age < 30");
			//stmt.executeQuery("Update emp set age = age+1");

			/*
			ResultSet rs = stmt.executeQuery("select * from emp");
			while(rs.next()){
				System.out.println("\nName : "+rs.getString(1));
				System.out.println("Age : "+rs.getInt(2));
			}	
			rs.close();
			*/

			stmt.close();
			con.close();	
		}
		catch(Exception e){
			System.out.println(e);	
		}
	}

}

/* start .

set classpath=ojdbc6.jar;.;%classpath%
*/