import java.sql.*;

public class JDBCDemo5{
	public static void main(String[] args){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
           	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");	
		
			// Statement stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
	
			ResultSEt rs = stmt.executeQuery("select * from EMP");

			while(rs.next()){
				System.out.println("\nName : "+rs.getString(1));
				System.out.println("Age : "+rs.getInt(2));
			}
			
			System.out.println("========================");
			
			while(rs.previous()){
				System.out.println("\nName : "+rs.getString(1));
				System.out.println("Age : "+rs.getInt(2));
			}
			
			System.out.println("========================");
	
			rs.first();
			{
				System.out.println("\nName : "+rs.getString(1));
				System.out.println("Age : "+rs.getInt(2));
			}
			
			System.out.println("========================");

			rs.last();
			{
				System.out.println("\nName : "+rs.getString(1));
				System.out.println("Age : "+rs.getInt(2));
			}
			
			System.out.println("========================");

			rs.absolute(5);
			{
				System.out.println("\nName : "+rs.getString(1));
				System.out.println("Age : "+rs.getInt(2));
			}
			
			System.out.println("========================");
			
			rs.relative(-2);
			{
				System.out.println("\nName : "+rs.getString(1));
				System.out.println("Age : "+rs.getInt(2));
			}
			
			System.out.println("========================");
			
			rs.colse();
			stmt.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}

	}
}