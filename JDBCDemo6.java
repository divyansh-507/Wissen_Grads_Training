import java.sql.*;

public class JDBCDemo6
{
	public static void main(String[] args){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
           	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");	
		
			Statement stmt = con.createStatement();
			
			System.out.print("Enter table name : ");
			String tname = new Scanner(System.int).next();

			ResultSEt rs = stmt.executeQuery("select * from "+tname);

			ResultSetMetaData rsmd = rs.getMetaData();

			int columns = rsmd.getColumnCount();

			while(rs.next()){
				for(int i=1;i<=columns;i++)
					System.out.println(rsmd.getColumnName(i)+" : "+rs.getString(i));
				System.out.println();
			}

			rs.close();

			stmt.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}

	}
}