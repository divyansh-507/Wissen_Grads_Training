import java.sql.*;

public class JDBCDemo4{
	public static void main(String[] args){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
           	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");	
		
			Statement stmt = con.createStatement();
	
			stmt.addBatch("insert into EMP values('Amit', 21)");
			stmt.addBatch("insert into EMP values('Bhumika', 22)");
			stmt.addBatch("insert into EMP values('Chitvan', 23)");
			stmt.addBatch("insert into EMP values('Danish', 24)");
			stmt.addBatch("insert into EMP values('Elizabeth', 25)");
	
			System.out.print("Do you want to add all records in DB ? (true/false) : ");	
			boolean confirm = new Scanner(System.in).nextBoolean();

			if(confirm)
				stmt.executeBatch();
			else
				System.out.println("None of the query is executed ... ");

			stmt.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}

	}
}