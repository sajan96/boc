package db_access;
import java.sql.*;

public class MySQLConnection {
	public static final String TEST_QUERY ="select * from sajan";
	public static final String USER_NAME="root";
	private Connection con;
	public MySQLConnection() {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/oop",USER_NAME,"sajan@1996");								
			}catch(Exception e){ System.out.println(e);
			
			}  
			}
	public Connection getCon() {
		return con;
	}
	
	public ResultSet getResultSetByQuery(String query) throws SQLException {
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery(query);
		return rs;
	}
	
	public void closeConnection() throws SQLException {
		con.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	

		// TODO Auto-generated constructor stub
	

}
