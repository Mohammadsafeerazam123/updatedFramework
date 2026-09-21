package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class CRUD_Db {

	public static void main(String[] args) throws Exception {
		
		Driver d = new Driver();
		
		DriverManager.registerDriver(d);
		Connection con = DriverManager.getConnection("jdbc:mysql://49.249.29.4:3307/ninza_hrm","root@%","root");
		
		Statement st =con.createStatement();
		// excute
		//1. creating the table
		st.execute("create table asdfgtt3(name VARCHAR(20));");
		//2. inserting the data
		st.execute("insert into asdfgtt3 value('asd');");
		//3. getting it and checking
		
		boolean status = st.execute("select * from asdfghtt3;");
		
		if(status==true) {
			System.out.println("table created");
		}
		else {
			System.out.println("table not created");
		}

	}

}
