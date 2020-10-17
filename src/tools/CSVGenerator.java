package tools;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CSVGenerator {
	private BufferedWriter fileWriter;
	
	public CSVGenerator(String file) throws IOException {
		// TODO Auto-generated constructor stub
		fileWriter = new BufferedWriter(new FileWriter(file));
	}
	
	public void test(ResultSet rs) throws SQLException, IOException {
		
		while(rs.next()) {  
			System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3) + "   "+rs.getString("email"));  
		} 
	}
	
	
	
	public void generateCSV(ResultSet rs) throws SQLException , IOException  {
	//get column list from resultset
	//add column list to string like below statement
	fileWriter.write("id;f_name;l_name;email");
//		fileWriter.write(column);
		int counter=1;
		while(rs.next()) {  
			//all the column data append to line,esiest way is used string bulder,and append column data bu using forloop and number of column
			 String line = String.format("%d;%s;%s;%s",counter++,
					 rs.getString(1),rs.getString(2), rs.getString(3) );
             fileWriter.newLine();
             fileWriter.write(line);   			
			System.out.println(line);  
		} 
		fileWriter.close();

	}

}
