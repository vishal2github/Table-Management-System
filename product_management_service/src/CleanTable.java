import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CleanTable
{
	public static void main(String[] args)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/productmanagementdb", "root", "micql@5132");
			System.out.println("Connection established...\n");
			
			Statement st = cn.createStatement();
			st.executeUpdate("delete from productdetails");
			System.out.println("All records deleted, and table cleaned...\n");
			
			cn.close();
			System.out.println("Connection closed successfully!");
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}
