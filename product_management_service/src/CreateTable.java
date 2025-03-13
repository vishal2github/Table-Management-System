
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable
{
	public static void main(String[] args)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/productmanagementdb", "root", "micql@5132");
			System.out.println("Connection established...");
			
			Statement st = cn.createStatement();
			st.execute("create table productdetails(pid int primary key, name varchar(20), brand varchar(20), color varchar(20), price int)");
			System.out.println("Table created successfully...");
			
			cn.close();
			System.out.println("Connection closed successfully!");
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}
